(ns metop-lab2.main
  (:require [metop-lab2.half-div :as half-div]
            [metop-lab2.golden-ratio :as golden-ratio])
  )

(def a 1.0)
(def b 2.0)
(def eps 0.0001)

(println "Метод половинного деления:")
(def h-d (half-div/find-minimum a b eps))
(printf "x_m = %.3f; y_m = %.3f\n" (get h-d 0) (get h-d 1))
(println "Метод золотого сечения:")