(ns technetium.model.game-test
  (:require [clojure.test :refer :all])
  (:require [technetium.model.game :refer :all]))

(deftest test-game
  (testing "game creation"
    (let [game (new-game 3)]
      (is (= 27 (count game))))))
