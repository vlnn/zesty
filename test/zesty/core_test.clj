(ns zesty.core-test
  (:require [clojure.test :refer :all]
            [zesty.core :refer :all]))

(deftest parse-the-line
  (testing "line parser"
    (is (= "nop" (parse-asm-line "nop")))
    (is (= "ld" (parse-asm-line "ld a,b")))
    (is (= "inc" (parse-asm-line "inc a"))))
  )

(deftest one-byte-mnemonics-compile
  (testing "nop mnemonic works"
    (is (= 0 (asm->hex "nop")))))
