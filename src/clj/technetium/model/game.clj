(ns technetium.model.game
  (:require [technetium.model.asteroid :as asteroid]))

(def game (atom []))

(defn new-game [size]
  (for [x (range 0 size)
        y (range 0 size)
        z (range 0 size)]
    (asteroid/new-asteroid x y z nil)))

(defn reset []
  (reset! game (new-game asteroid/field-size)) @game)

(defn get-game [] @game)

(defn key-for [asteroid]
  (let [x (:x asteroid)
        y (:y asteroid)
        z (:z asteroid)]
    (str "x" x "y" y "z" z)))

(defn entry-for [asteroid]
  {(key-for asteroid) asteroid})

(reset)