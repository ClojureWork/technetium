(ns technetium.model.game-test
  (:require [clojure.test :refer :all])
  (:require [technetium.model.game :refer [game]]
            [technetium.model.game :as game]))

(deftest test-game
  (testing "game creation"
    (let [game (game/new-game 3)]
      (is (= 27 (count game))))))

(deftest test-adjacent
  (testing "fetching list of adjacent locations"
    (let [adjacent (game/adjacent 0 0 0)]
      (is (= 26 (count adjacent))))))
