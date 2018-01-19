# Java_School_Tasks

Calculator
------------
  General description:
  Write a calculator for evaluating arithmetic expressions.
An expression can consist of:
1.  Digits (0-9)
2.  Dots as decimal marks (valid example: 100.02, not valid example : 100..02)
3.  Parentheses
4.  Mathematical symbols (allowed are : "+", "-", "*", "/")
5.  Rounding is to be performed to 4 significant digits, only the final result is to be rounded. Example: 102.12356 -> 102.1236
 
Input and expected output:
* Input : String containing arithmetic expression
* Output : evaluation result or null if the expression cannot be evaluated

Subsequence
-------------
  General description:
1.  Given two sequences {X} and {Y} of arbitrary elements (java.lang.Object).
2.  Determine whether {X} can be built by removing some elements from {Y} without changing the order.

Input and expected output:
* Input : List X and List Y
* Output : boolean, true if {X} can be built from {Y}, false otherwise

Examples

{X} : "A", "B", "C", "D"

{Y} : "BD", "A", "ABC", "B", "M", "D", "M","C", "DC", "D"
