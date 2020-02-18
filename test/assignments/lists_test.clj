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

(deftest count-test
  (testing "should return 4 when coll is (range 4)"
    (is (= 4 (count' (range 4))))))

(deftest reverse-test
  (testing "should return (reverse (range 4) when (reverse' (range 4)) calls"
    (is (= '(3 2 1 0) (reverse' [0 1 2 3]))))
  (testing "should return (reverse (range 4) when (reverse' (range 4)) calls"
    (is (= '(2 1 0) (reverse' '(0 1 2))))))

(deftest every-test
  (testing "should return false when pred is even? and coll is [1 2 3 4]"
    (is (= false (every?' even? [1 2 3 4]))))
  (testing "should return true when pred is even? and coll is [0 2 22 4]"
    (is (= true (every?' even? [0 2 22 4])))))

(deftest some-test
  (testing "should return true when pred is even? and coll is [1 2 3 4]"
    (is (= true (some?' even? [1 2 3 4]))))
  (testing "should return false when pred is even? and coll is [0 2 22 4]"
    (is (= false (some?' even? [1 3 21]))))
  (testing "should return true when pred is even? and coll is [0 2 22 4]"
    (is (= true (some?' odd? [1 3 4])))))

(deftest sum-of-adjacent-numbers-test
  (testing "should add adjacent number"
    (is (= [3 5 8] (sum-of-adjacent-digits [1 2 3 5])))))

(deftest index-of-test
  (testing "should return 2 when coll is [1 3 4 5] and n is 4"
    (is (= 2 (index-of [1 3 4 5] 4))))
  (testing "should return 4 when coll is (1 3 4 5 6 3) and n is 6"
    (is (= 4 (index-of '(1 3 4 5 6 3) 6)))))

(deftest sqr-of-the-first-test
  (testing "[4 5 6] => [16 16 16]"
    (is (= [16 16 16] (sqr-of-the-first [4 5 6])))))

(deftest third-or-fifth-test
  (testing "[1, 2, 3, 4, 5, 6, 7, 8] => [1, 4, 6, 7]"
    (is (= [1, 4, 6, 7] (third-or-fifth [1, 2, 3, 4, 5, 6, 7, 8])))))

(deftest double-up-test
  (testing "[1,2,3] -> [1,1,2,2,3,3]"
    (is (= [1, 1, 2, 2, 3, 3] (double-up [1,2,3])))))

(deftest russian-dolls-test
  (testing "[1 2 3] 3 ->  [[[1]] [[2]] [[3]]]"
    (is (= [[[1]] [[2]] [[3]]] (russian-dolls [1 2 3] 3)))))