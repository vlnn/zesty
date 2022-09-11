(ns zesty.core
  (:gen-class)
  (:require [clojure.string :as str]))

(def asm-map
  {:nop 0
   :ld  "3E"})

(defn is-valid?
  [cmd]
  true
  )

(defn parse-asm-line
  "Parse one line of asm code"
  [str]
  (let [split (str/split str #"(\s|,)+")]
    (if is-valid? split)
    (flatten  [(keyword (first split)) (rest split)])))

(defn validate-parsed-command [cmd]
  (is-valid? cmd))

(defn get-code [mnemonic]
  (get asm-map mnemonic))

(defn compile-command
  "Gets mnemonic with optional operands and returns machine code representation"
  [cmd]
  (get-code (first cmd)))

(defn asm->hex
  "Return hex representation of asm mnemonic and arguments"
  [str]
  (compile-command (parse-asm-line str)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (asm->hex "nop")))
