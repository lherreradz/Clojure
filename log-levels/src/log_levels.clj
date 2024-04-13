(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (str/triml 
   (str/trimr
    (get (nth (re-seq  #"([a-zA-Z_0-9 ])+" (str/replace s #"(\t)*(\r)*(\n)*" "")) 1) 0)
   )
  )
)

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (
   (->>
    (nth (re-seq  #"([a-zA-Z_0-9 ])+" (str/replace s #"(\t)*(\r)*(\n)*" "")) 0)
    (get 0)
    (str/lower-case)  
    (str/trimr)
    (str/triml)
    )
   )
  )

(
 defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")" )
  )
