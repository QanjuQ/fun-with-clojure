(def square (comp (partial apply *) (partial repeat 2)))

(def trim-ends (comp rest butlast))

(def ends-equal? (comp (partial apply =) (juxt first last)))

(def palindrome? (comp 
                  (partial every? ends-equal?)
                  (partial take-while (complement empty?))
                  (partial iterate trim-ends)))

(def factorial (comp (partial apply *) (comp (partial range 2) inc) ))

(def first-not-divisible-by-last? (comp (complement zero?)(partial apply mod) (juxt last first)))

(def prime? (comp
             (partial every? first-not-divisible-by-last?)
             (partial butlast)
             (partial take-while (complement empty?))
             (partial iterate rest)
             (partial range 2)
             inc))

(def my-take (comp (partial apply take) reverse list))
; reversed the arguments of take

(def add-last-two (comp (partial apply +) (juxt last (comp last butlast))))

(def next-fibo-seq (comp (partial apply conj) (juxt identity add-last-two)))

(def fibonacci (comp last (partial my-take (iterate next-fibo-seq [0 1]))))