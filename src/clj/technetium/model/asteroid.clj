(ns technetium.model.asteroid)

(def RADIOACTIVE 43)

(def field-size 4)

(def field-data {:size   field-size
                 :radioactive [{:x 1 :y 1 :z 1} {:x 0 :y 0 :z 0}]})

(def field (atom []))

(defn radioactive? [x y z]
  (some #(= % {:x x :y y :z z}) (:radioactive field-data)))

(defn new-asteroid
  ([x y z] (new-asteroid x y z nil))
  ([x y z radiation]
   {:x         x
    :y         y
    :z         z
    :radiation radiation
    :flagged   false}))

(defn radiation-from [x y z]
  (if (.contains (field-data :radioactive) {:x x :y y :z z}) 1 0))

(defn adjacent [x y z]
  (remove #(= {:x x :y y :z z} %)
          (for [a (range (- x 1) (+ x 2))
                b (range (- y 1) (+ y 2))
                c (range (- z 1) (+ z 2))]
            {:x a :y b :z c})))

(defn radiation-from-location [location]
  (radiation-from (:x location) (:y location) (:z location)))

(defn residual-radiation-at [x y z]
  (if (radioactive? x y z)
    RADIOACTIVE
    (reduce + (map radiation-from-location (adjacent x y z)))))

(defn new-asteroid-field
  ([] (new-asteroid-field field-data))
  ([data]
   (let [size (:size data)]
     (for [x (range 0 size)
           y (range 0 size)
           z (range 0 size)]
       (new-asteroid x y z (residual-radiation-at x y z))))))

(defn has-location [asteroid x y z]
  (and (= (asteroid :x) x) (= (asteroid :y) y) (= (asteroid :z) z)))

(defn get-asteroid-field [] @field)

(defn get-asteroid-at [x y z field]
  (first (filter #(has-location % x y z) field)))

(defn reset []
  (reset! field (new-asteroid-field)) @field)

(defn radioactive-count [field]
  (count (filter #(= RADIOACTIVE (:radiation %)) field)))

(reset)