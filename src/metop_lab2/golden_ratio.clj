(ns metop-lab2.golden-ratio)

(def str-format "|\t%d\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\n")
(def f (fn [x] (+ (* x x) (* -3 x) (* x (Math/log x)))))

(def x1 (fn [a b] (+ a (* 0.382 (- b a)))))
(def x2 (fn [a b] (+ a (* 0.618 (- b a)))))

(def find-minimum (fn
                    ([a b eps iter] (
                                      let [y1 (f (x1 a b)) y2 (f (x2 a b)) a-new (if (< y1 y2) a (x1 a b)) b-new (if (< y1 y2) (x2 a b) b)]
                                      (printf str-format iter a b (x1 a b) (x2 a b) y1 y2)
                                      (if (< (- b a) eps) [(x1 a b) (f (x1 a b))] (recur a-new b-new eps (+ iter 1)))
                                      ))
                    ([a b eps]
                     (println "|\t№\t|\ta\t\t|\tb\t\t|\tx1\t\t|\tx2\t\t|\ty1\t\t|\ty2\t\t|")
                     (find-minimum a b eps 1))
                    ))