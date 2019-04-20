(ns primestable.core
  (require [clojure.pprint :as pp]) 
  (:gen-class))


(defn prime? [n]
  (->> (Math/sqrt n)
    int
    inc
    (range 2)
    (every? #(pos? (rem n %)))))


(defn find-primes [n]
  (loop [primes [2]
         i 3]
    (if (>= (count primes) n)
      primes
      (recur (if (prime? i)
               (conj primes i)
               primes)
             (inc i)))))


(defn print-mult-table
  [prime-nos]
  (println "Multiplication table for:" prime-nos)
  (->> (range 1 11)
    (map (fn [n]
           (->> prime-nos
             (map #(* n %))
             (zipmap prime-nos))))
    (pp/print-table prime-nos)))


(defn -main
  "I don't do a whole lot ... yet."
  [n-str]
  (-> (Integer/parseInt n-str)
    (find-primes)
    (print-mult-table)))
