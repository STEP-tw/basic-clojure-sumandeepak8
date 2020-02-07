(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

;(deftest lists
  ;(testing "map"
  ;  (testing "identity with single coll"
  ;    (is (= [1 2 3] (map' identity [1 2 3])))))
  ;)


(deftest filter-test
  (testing "filter"
    (is (= [0 2 4 6 8 10] (filter' even? (range 11))))))