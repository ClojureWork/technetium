(ns technetium.model.game)

(def field {:size 3 :mines [{:x 1 :y 1 :z 1}]})

(def game (atom []))

(defn asteroid [x y z]
  {:x x
   :y y
   :z z
   :radiation nil})

(defn new-game [size]
  (for [x (range 0 size)
        y (range 0 size)
        z (range 0 size)]
    (asteroid x y z)))

(defn get-game [] @game)

(defn key-for [asteroid]
  (let [x (:x asteroid)
        y (:y asteroid)
        z (:z asteroid)]
       (str "x" x "y" y "z" z)))

(defn entry-for [asteroid]
  {(key-for asteroid) asteroid})

(defn reset []
  (reset! game (new-game 3)))

(reset)