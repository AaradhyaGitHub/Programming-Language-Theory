- What are types, evaluation, compilers vs interpreters 

Functional Programming: 
    - We are interested in pure mathematical functions 
    - Input -> Result Nothing else 
    - Immutable data -> Data does not change in place 
    - No / Less Side effects 
    - Functional Programming is more declarative 
    - Easier to Verify -> mathematically prove the correctness of an algorithm 



In an iterative approach, we tell the computer how to solve a given problem. 
We define what it means to have a sum. 

SUM -> Sum of an empty list is 0 
    -> Sum with a list with at least 1 element x is that x + whatever the rest of the sum is

Haskell is lazy evaluated: 
- When something is Strictly evaluated like C and Java, you evaluate things in order and evaluate everything. 
- In Haskell things only get evealuated if it really needs to be evaluated
- Things only get evaluated if needed. 

