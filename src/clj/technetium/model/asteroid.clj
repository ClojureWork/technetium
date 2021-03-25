(ns technetium.model.asteroid)

(def RADIOACTIVE 43)

(def field-size 4)

(def ^:private field-data {:size        field-size
                           :radioactive [{:x 1 :y 1 :z 1}
                                         {:x 1 :y 1 :z 2}
                                         {:x 2 :y 1 :z 1}
                                         ]
                           })

(def ^:private field (atom []))

(defn radioactive?
  ([data x y z] (some #(= % {:x x :y y :z z}) (:radioactive data)))
  ([x y z] (radioactive? field-data x y z)))

(defn potential-neighbor-coordinates [x y z]
  (remove #(= {:x x :y y :z z} %)
          (for [a (range (- x 1) (+ x 2))
                b (range (- y 1) (+ y 2))
                c (range (- z 1) (+ z 2))]
            {:x a :y b :z c})))

(defn count-radioactive-neighbors [data x y z]
  (count (filter #(radioactive? data (:x %) (:y %) (:z %)) (potential-neighbor-coordinates x y z))))

(defn radiation-at [data x y z]
  (if (radioactive? data x y z) RADIOACTIVE (count-radioactive-neighbors data x y z)))

(defn new-asteroid
  ([data x y z] {:x         x
                 :y         y
                 :z         z
                 :radiation (radiation-at data x y z)})
  ([x y z] {:x         x
            :y         y
            :z         z}))

(defn new-asteroid-field
  ([data]
   (let [size (:size data)]
     (for [x (range 0 size)
           y (range 0 size)
           z (range 0 size)]
       (new-asteroid data x y z))))
  ([] (new-asteroid-field field-data)))

(defn has-location [asteroid x y z]
  (and (= (asteroid :x) x) (= (asteroid :y) y) (= (asteroid :z) z)))

(defn get-asteroid-field [] @field)

(defn get-asteroid-at
  ([x y z] (get-asteroid-at x y z @field))
  ([x y z field] (first (filter #(has-location % x y z) field))))

(defn reset []
  (reset! field (new-asteroid-field field-data)) @field)

(defn radioactive-count [field]
  (count (filter #(= RADIOACTIVE (:radiation %)) field)))

(defn visible? [asteroid]
  (let [radiation (:radiation asteroid)]
    (or (nil? radiation) (not (zero? radiation)))))

(reset)