In Prolog, a series of questions can be asked about a fact. 

Database: 
is_in_love_with(romeo, juliet)

Question:
?- is_in_love_with(romeo, juliet). // true. 

?- is_in_love_with(romeo, X).

- This is asking "Who is Romeo in love with?"
- The realtion name in question and fact must be the same 
- The number of arguments in the question and fact must be the same 
- The argument that refer to object must be the same name 

relation name: is_in_love_with in both question and clause 
number of argument: 2 in both question and clause 

argument refering to the object must be same: 
- romeo is same in both 
- 2nd argument is a upperCase 
- X is a variable not a object 

question can be unified with the clause.
we return the value of X which is juliet 

?- is_in_love_with(romeo, olivia). // false.

?- is_in_love_with(romeo, X).
In order to unify this question with our fact, the argument X needs to be Sarah or the unification will fail. 

--- 

Unification: 
- Relation name must be equal 
- Number of arguments must be equal 
- Names of arguments referring to objects must be equal 
- Arguments must be in the same order 

