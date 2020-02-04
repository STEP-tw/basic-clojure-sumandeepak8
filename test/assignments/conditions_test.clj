(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator informative"
    (is (= 2 (informative-divide 4 2)))
    (is (= :infinite (informative-divide 4 0)))))

(deftest harishchandra-test
  (testing "return only true for truthy values"
    (is (= true (harishchandra 2))))
  (testing "return only false for falsy values"
    (is (= false (harishchandra false))))
  (testing "return false for nil values also"
    (is (= false (harishchandra nil)))))

(deftest yudishtira-test
  (testing "return only true for truthy values"
    (is (= true (yudishtira 2))))
  (testing "return only false for falsy values"
    (is (= :ashwathama (yudishtira false))))
  (testing "return false for nil values also"
    (is (= :ashwathama (yudishtira nil)))))

(deftest duplication
  (testing "return coll with first element duplicate if coll is not empty"
    (is (= [1 1 2] (duplicate-first [1 2]))))
  (testing "return nil when coll is empty"
    (is (= nil (duplicate-first [])))))

(deftest five-points
  (testing "should return :chetan-bhagat when y is 5"
    (is (= :chetan-bhagat (five-point-someone 2 5))))
  (testing "should return :satan-bhagat when x is 5"
    (is (= :satan-bhagat (five-point-someone 5 5))))
  (testing "should return :greece when x is greater than y"
    (is (= :greece (five-point-someone 5 4))))
  (testing "should return :universe when x is greater than y"
    (is (= :universe (five-point-someone 6 8)))))