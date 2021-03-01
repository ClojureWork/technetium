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

(defn remove-asteroid [x y z game]
  (remove #(location-matches? x y z %) game))

(defn filter-zeros [game]
  (filter asteroid/visible? game))

(defn reveal [x y z]
  (swap! game
         (fn [n]
            (cons
              (asteroid/get-asteroid-at x y z)
              (remove-asteroid x y z n)))))

(defn reset []
  (reset! game (new-game asteroid/field-size))
  @game)

(defn get-game [] @game)

(reset)