(ns metop-lab2.main
  (:require [metop-lab2.half-div :as half-div]
            [metop-lab2.golden-ratio :as golden-ratio]
            [metop-lab2.hord :as hord])
  )

(def min-format "x_m = %.3f; y_m = %.3f\n")
(def extremum-format "x* = %.3f; y* = %.3f\n")

(def a 1.0)
(def b 2.0)
(def eps 0.005)

(println "Метод половинного деления:")
(def h-d (half-div/find-minimum a b eps))
(printf min-format (get h-d 0) (get h-d 1))
(println "Метод золотого сечения:")
(def g-r (golden-ratio/find-minimum a b eps))
(printf min-format (get g-r 0) (get g-r 1))
(println "Метод хорд:")
(def h (hord/find-extremum a b eps))
(printf extremum-format (get h 0) (get h 1))