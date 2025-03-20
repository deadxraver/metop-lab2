(ns metop-lab2.half-div)

(def f (fn [x] (+ (* x x) (* -3 x) (* x (Math/log x)))))

(def x1 (fn [a b eps] (/ (+ a b (- 0 eps)) 2)))
(def x2 (fn [a b eps] (/ (+ a b eps) 2)))
(def xm (fn [a b] (/ (+ a b) 2)))

(def find-extremum
  (fn [a b eps] (
                  let [y1 (f (x1 a b eps))
                       y2 (f (x2 a b eps))
                       a1 (if (> y1 y2) (x1 a b eps) a)
                       b1 (if (> y1 y2) b (x2 a b eps))]
                  (if (> (- b1 a1) (* 2 eps)) (find-extremum a1 b1 eps) (f (xm a1 b1)))
                  )))
