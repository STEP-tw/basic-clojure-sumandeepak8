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
    (is (= [0 2 4 6 8 10] (filter' even? (range 11)))))
  (testing "returns only values for which pred returns true"
    (is (= [1 2 3] (filter' #(< % 5) [1 2 3 5 6 10])))
    ))

(deftest reduce-test
  (testing "returns first element if collection has only one ele"
    (is (= 1 (reduce' + [1])))
    )

  (testing "returns reduced result"
    (is (= 6 (reduce' + [1 2 3])))
    )

  (testing "with initial value"
    (is (= 12 (reduce' + 6 [1 2 3])))
    )
  )
