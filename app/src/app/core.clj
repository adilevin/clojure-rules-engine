(ns app.core
  (:gen-class)
  (:require [clojure.pprint :refer [pprint]]))

(defmacro -if [measurement comparator value action]
  { 
    :predicate (list 'fn ['person] (list comparator (list 'person (keyword measurement)) value)),
    :action (keyword action),
    :txt (str "if " measurement " " comparator " " value " then " action)
  })

(defn determine-acceptance [person rules]
  (def result (first (filter #((:predicate %) person) rules)))
  {:decision (subs (str (:action result)) 1), :reason (:txt result)}
)

(defn read-rules []
  (load-file "./data/rules.clj"))

(defn read-person []
  (load-file "./data/person.clj"))

(defn print-rules [rules]  
  (println "\nRunning the following rules: ")
  (doseq [rule rules] (println "  " (rule :txt))))

(defn print-person [person]
  (println "\nTesting the following person: ")
  (print "  ")
  (pprint person))

(defn print-outcome [outcome]
  (println "\nResult: ")
  (println "  Decision: " (outcome :decision))
  (println "  Reason: " (outcome :reason)))

(defn -main [& args]
  (def rules (read-rules))
  (def person (read-person))
  (print-rules rules)
  (print-person person)
  (def outcome (determine-acceptance person rules))
  (print-outcome outcome)
  (println)
)
