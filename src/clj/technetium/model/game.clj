(ns technetium.model.game
  (:require [technetium.model.asteroid :as asteroid]))

(def game (atom []))

(defn new-game [size]
  (for [x (range 0 size)
        y (range 0 size)
        z (range 0 size)]
    (asteroid/new-asteroid x y z nil)))

(defn location-matches? [x y z asteroid]
  (and (= x (:x asteroid)) (= y (:y asteroid)) (= z (:z asteroid))))

(defn reveal [x y z]
  (remove #(location-matches? x y z %) @game))


(defn reset []
  (reset! game (new-game asteroid/field-size)) @game)

(defn get-game [] @game)

(reset)