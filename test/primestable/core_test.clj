(ns primestable.core-test
  (:require [clojure.test :refer :all]
            [primestable.core :refer :all]))


(deftest test-find-primes
  (testing "find-primes should return specified count"
           (is (= [2 3 5 7]
                  (find-primes 4)))
           (is (= [2 3 5 7 11 13 17 19]
                  (find-primes 8))))
  (testing "find-primes should really return primes"
           (is (every? prime? (find-primes 4)))
           (is (every? prime? (find-primes 8)))))
