(ns metop-lab2.newton)

(def str-format "|\t%d\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\n")

(def f (fn [x] (+ (* x x) (* -3 x) (* x (Math/log x)))))

(def dx 0.000001)
(def derivative-hc (fn [x0] (+ (* 2 x0) (Math/log x0) (- 0 2))))
(def double-derivative (fn [x0] (/ (- (derivative-hc (+ x0 dx)) (derivative-hc x0)) dx)))

(def find-extremum (fn
                     ([x eps iter _] (
                                               let [big-f (derivative-hc x) big-f-der (double-derivative x)]
                                               (printf str-format iter x big-f big-f-der (f x))
                                               (if (<= (abs big-f) eps) [x (f x)] (recur (- x (/ big-f big-f-der)) eps (+ iter 1) 0))
                                               )
                      )
                     ([a b eps]
                      (println "|\t№\t|\tx0\t\t|\tF(x)\t|\tF'(x)\t|\tf(x)\t|")
                      (find-extremum a eps 0 0)
                      )
                     ))