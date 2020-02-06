(ns assignments.conditions)

(defn safe-divide
  "Returns the result of x/y unless y is 0. Returns nil when y is 0"
  {:level        :easy
   :use          '[when-not zero?]
   :implemented? true}
  [x y] (if (zero? y) nil (/ x y)))

(defn informative-divide
  "Returns the result of x/y unless y is 0. Returns :infinite when y is 0"
  {:level        :easy
   :use          '[if-not zero?]
   :implemented? true}
  [x y]
  (let [result (safe-divide x y)]
    (if (nil? result) :infinite result)))

(defn harishchandra
  "Only returns truthy values as themselves.
  Falsy values(false and nil) return nil"
  {:level        :easy
   :use          '[when-let]
   :implemented? true}
  [x] (if (or (false? x) (nil? x)) false true))

(defn yudishtira
  "Only returns truthy values as themselves.
  Falsy values(false and nil) return :ashwathama"
  {:level        :easy
   :use          '[if-let]
   :implemented? true}
  [x] (if (harishchandra x) true :ashwathama))

(defn duplicate-first
  "Returns coll with the first element duplicated.
  Returns nil if col is empty"
  {:level        :easy
   :use          '[when-first concat]
   :alternates   '[empty? seq? conj into]
   :implemented? true}
  [coll]
  (if-not (empty? coll)
    (conj (seq coll) (first coll))
    nil))

(defn five-point-someone
  "Returns :chetan-bhagat if y is 5.
  If x is 5 is returns :satan-bhagat.
  If x is greater than y it returns :greece
  Otherwise it returns :universe"
  {:level        :easy
   :use          '[cond]
   :implemented? true}
  [x y]
  (cond
    (> x y) :greece
    (= x 5) :satan-bhagat
    (= y 5) :chetan-bhagat
    :else :universe))

(defn conditions-apply
  "Given a collection of any length, returns:
  :wonder-woman if collection has a single occurrence of 1 and 3 in that order
  :durga        if collection has a single occurrence of :a :b and :c in that order
  :cleopatra    if collection has a single occurrence of [2 3] and [4 5] in that order
  :tuntun if none of the conditions apply"
  {:level        :medium
   :use          '[condp filter]
   :alternates   '[if cond]
   :implemented? false}
  [coll])

(defn repeat-and-truncate
  "Given coll and options to repeat and truncate
  returns a collection that optionally repeats itself
  and is optionally truncated to the first n elements.
  (repeat-and-truncate (range 4) true true 6) => '(0 1 2 3 0 1)"
  {:level        :medium
   :use          '[cond->> concat take]
   :implemented? false}
  [coll rep? truncate? n])

(defn order-in-words
  "Given x, y and z, returns a vector consisting of
  sentences that explicitly mention if x > y or y > z or z > x.
  (order-in-words 4 3 2) => [:x-greater-than-y :y-greater-than-z]
  (order-in-words 4 3 5) => [:x-greater-than-y :z-greater-than-x]
  (order-in-words 2 3 4) => [:z-greater-than-x]"
  {:level        :easy
   :use          '[cond-> conj]
   :implemented? true}
  [x y z] (cond-> [] (> x y) (conj :x-greater-than-y)
                 (> y z) (conj :y-greater-than-z )
                 (> z x) (conj :z-greater-than-x)))

(defn zero-aliases
  "Given a zero-like value(0,[],(),#{},{}) should
  give back an alias for each type of zero like value
  or a default of :not-zero
  0 -> :zero
  [] -> :empty
  '() -> :empty
  #{} -> :empty-set
  {}  -> :empty-map
  \"\"  -> :empty-string"
  {:level        :easy
   :use          '[case]
   :implemented? true}
  [zero-like-value] (
                      let [value zero-like-value]
                      (case value
                        0 :zero
                        [] :empty
                        () :empty
                        #{} :empty-set
                        {} :empty-map
                        \"\" :empty-string)
                      ))

(defn zero-separated-palindrome
  "Given a sequence of numbers, increment the list
  and prepend a 0 to the incremented list concatenated
  with the reverse of the incremented list
  [1 2 3] -> (4 3 2 0 2 3 4)"
  {:level :easy
   :use '[as-> reverse]
   :implemented? false}
  [coll])