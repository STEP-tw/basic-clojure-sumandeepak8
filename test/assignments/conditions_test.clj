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