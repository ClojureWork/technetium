(ns technetium.model.game)

(def field-size 2)

(def field {:size field-size :mines [{:x 1 :y 1 :z 1}]})

(def game (atom []))

(defn asteroid [x y z]
  {:x         x
   :y         y
   :z         z
   :radiation nil
   :flagged   false})

(defn new-game [size]
  (for [x (range 0 size)
        y (range 0 size)
        z (range 0 size)]
    (asteroid x y z)))

(defn radiation-from [x y z]
  (if (.contains (field :mines) {:x x :y y :z z}) 1 0))

(defn reset []
  (reset! game (new-game field-size)) @game)

(defn select [x y z]
  (if
    (.contains (field :mines) {:x x :y y :z z})
    (reset) (new-game 1)))

(defn adjacent [x y z]
  (remove #(= {:x x :y y :z z} %)
          (for [a (range (- x 1) (+ x 2))
                b (range (- y 1) (+ y 2))
                c (range (- z 1) (+ z 2))]
            {:x a :y b :z c})))


(defn get-game [] @game)

(defn key-for [asteroid]
  (let [x (:x asteroid)
        y (:y asteroid)
        z (:z asteroid)]
    (str "x" x "y" y "z" z)))

(defn entry-for [asteroid]
  {(key-for asteroid) asteroid})

(reset)