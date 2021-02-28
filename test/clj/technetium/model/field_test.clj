(ns technetium.model.field-test
  (:require [clojure.test :refer :all])
  (:require [technetium.model.asteroid :refer :all]))

(deftest test-adjacent
  (testing "fetching list of adjacent locations"
    (let [adjacent (adjacent 0 0 0)]
      (is (= 26 (count adjacent))))))
