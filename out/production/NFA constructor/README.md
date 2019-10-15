Austin Cari
10/14/2019
WSU Vancouver
CS 317 - Formal Automata and Languages

This program constructs NFAs using postfix expressions. 
Postfix expressions are another but equivalent way to represent
regular expressions. They prioritize precedence and order of
operations by implying it with the placement of their symbols

For example, 
    AUB*
becomes
    AB|*
    
This program will construct an NFA and then print a transition
table to System.out.println in the following format;

String: ab&c*de|&
Start: X | Accept: Y
========================
(Q0, a) -> Q1
(Q1, b) -> Q2
...

The program requires a single .txt file as an argument. The 
program will read through each new line, producing an NFA 
as each symbol is read. 

To compile;
javac main.java
java Main example.txt
