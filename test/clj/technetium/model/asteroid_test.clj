(ns technetium.model.asteroid-test
  (:require [clojure.test :refer :all])
  (:require [technetium.model.asteroid :refer :all]))

(def data {:size        4
           :radioactive [{:x 1 :y 1 :z 1} {:x 0 :y 0 :z 0}]})

(deftest test-adjacent
  (testing "fetching list of adjacent locations"
    (let [adjacent (adjacent 0 0 0)]
      (is (= 26 (count adjacent))))))

(deftest test-new-asteroid-field
  (testing "creating a new asteroid field based on some data"
    (let [field (new-asteroid-field data)]
      (is (= 64 (count field)))
      (is (= 2 (radioactive-count field))))))