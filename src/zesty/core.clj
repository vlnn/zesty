(ns zesty.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn parse-asm-line
  "Parse and validate one line of asm code"
  [str]
  (let [split (str/split str #" ")]
    (first split)))

(defn asm->hex
  "Return hex representation of asm mnemonic and arguments"
  [str]
  (parse-asm-line str))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (asm->hex "nop")))
