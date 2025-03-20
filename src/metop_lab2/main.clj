(ns metop-lab2.main
  (:require [metop-lab2.half-div :as half-div]))

(def a 1)
(def b 2)
(def eps 0.005)

(println "Метод половинного деления:" (half-div/find-extremum a b eps))
