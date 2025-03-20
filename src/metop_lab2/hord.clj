(ns metop-lab2.hord)

(def str-format "|\t%d\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\t%.3f\t|\n")

(def f (fn [x] (+ (* x x) (* -3 x) (* x (Math/log x)))))

(def dx 0.000001)
(def derivative (fn [x0] (/ (- (f (+ x0 dx)) (f x0)) dx)))
(def derivative-hc (fn [x0] (+ (* 2 x0) (Math/log x0) (- 0 2))))

(def find-extremum (fn
                     ([a b eps iter]
                      (let [x-tilda (- a (/ (* (derivative a) (- a b)) (- (derivative a) (derivative b))))
                            a-new (if (> (derivative x-tilda) 0) a x-tilda) b-new (if (> (derivative x-tilda) 0) x-tilda b)]
                        (printf str-format iter a b x-tilda (derivative x-tilda))
                          (if (<= (abs (derivative x-tilda)) eps) [x-tilda (f x-tilda)] (recur a-new b-new eps (- iter 1)))
                        )
                      )
                     ([a b eps]
                      (println "|\t№\t|\ta\t\t|\tb\t\t|\tx~\t\t|\tf'(x~)\t|")
                      (find-extremum a b eps 1))
                     )
  )