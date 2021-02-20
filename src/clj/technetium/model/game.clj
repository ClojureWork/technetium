(ns technetium.model.game)

(def field {:size 3 :mines [{:x 1 :y 1 :z 1}]})

(defn asteroid [x y z]
  {:x x
   :y y
   :z z
   :radiation nil})

(defn start []
  (for [x (range 0 3)
        y (range 0 3)
        z (range 0 3)]
    (asteroid x y z)))

(def game-repo (atom (start)))

(defn get-game [] @game-repo)


(defn key-for [asteroid]
  (let [x (:x asteroid)
        y (:y asteroid)
        z (:z asteroid)]
       (str "x" x "y" y "z" z)))

(defn entry-for [asteroid]
  {(key-for asteroid) asteroid})



