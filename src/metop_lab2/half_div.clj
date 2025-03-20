(ns metop-lab2.half-div)

(def str-format "|\t%d\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\n")

(def f (fn [x] (+ (* x x) (* -3 x) (* x (Math/log x)))))

(def x1 (fn [a b eps] (/ (+ a b (- 0 eps)) 2)))
(def x2 (fn [a b eps] (/ (+ a b eps) 2)))
(def xm (fn [a b] (/ (+ a b) 2)))

(def find-minimum
  (fn
    ([a b eps iter] (
                      let [y1 (f (x1 a b eps))
                           y2 (f (x2 a b eps))
                           a1 (if (> y1 y2) (x1 a b eps) a)
                           b1 (if (> y1 y2) b (x2 a b eps))]
                      (printf str-format iter a b (x1 a b eps) (x2 a b eps) y1 y2)
                      (if (> (- b1 a1) (* 2 eps)) (recur a1 b1 eps (+ iter 1)) [(xm a1 b1) (f (xm a1 b1))])
                      ))
    ([a b eps]
     (println "|\t№\t|\ta\t\t|\tb\t\t|\tx1\t\t|\tx2\t\t|\ty1\t\t|\ty2\t\t|")
     (find-minimum a b eps 1)
     )
    ))
