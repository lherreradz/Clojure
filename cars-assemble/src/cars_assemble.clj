(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (def produced-items (* speed 221))
  (cond 
    (= speed 0) 0
    (<= speed 4) produced-items
    (<= speed 8) (* produced-items 0.9)
    (= speed 9) (* produced-items 0.8)
    (= speed 10) (* produced-items 0.77)
    )
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60))
  )
