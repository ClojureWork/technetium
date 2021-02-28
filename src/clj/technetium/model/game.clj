(ns technetium.model.game
  (:require [technetium.model.asteroid :as field]))

(def game (atom []))

(defn find-asteroid-at [x y z]
  (first (filter #(field/has-location % x y z) @game)))

(defn new-game [size]
  (for [x (range 0 size)
        y (range 0 size)
        z (range 0 size)]
    (field/asteroid x y z nil)))

(defn reset []
  (reset! game (new-game field/field-size)) @game)

(defn select [x y z]
  (if
    (.contains (field/field-data :radioactive) {:x x :y y :z z})
    (reset) (new-game 1)))

(defn get-game [] @game)

(defn key-for [asteroid]
  (let [x (:x asteroid)
        y (:y asteroid)
        z (:z asteroid)]
    (str "x" x "y" y "z" z)))

(defn entry-for [asteroid]
  {(key-for asteroid) asteroid})

(reset)