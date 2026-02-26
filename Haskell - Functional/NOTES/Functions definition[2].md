Function defintiion within haskell. 

name arg1 arg 2 ... arg n = <expr> 
we don't really have a return. 

name arg1 arg2 . . . argn 

Examples: 

in_range min max x = 
    x >= min && x <= max


in_range 0 5 3 //True 
in_range 4 5 3 //False 

---

Types (Basics)
- every value has a type 
- type is strict

name :: <type>

Example: 
x :: Integer 
y :: Bool 
z ::  Float

Functions have their own types. Functions are just values!! 

in_range :: Integer -> Integer -> Integer -> Bool 
in_range min max x = x >= min && x <= max 

in_range 0.5 1.5 1 -> Type error 
in_range 0 5 3 -> Correct 


//this is not proper haskell syntax. This is imperative 
in_range min max x = 
    in_lower_bound = min <= x;
    in_upper_bound = max >= x; 
    return (in_lower_bounf && in_upper_bound);

Another tool we have is "let bindings" 
- you bind the result of some expression to a name and produce the last expression in relation to that. 

in_range min max x = 
    let in__lower_bound = min <= x 
        in_upper_bound = max >= x
    in
    in_lower_bound && in_upper_bound

another approach: where binding: 
in_range min max x = ilb && iub 
    where 
      ilb = min <= x 
      iub = max >= x


if then else can also be used: 

in_range min max x = 
 if ilb then iub else False 
 where 
 ilb = min <= x
 iub = max >= x

Functions can be written in a infix Notation. Here you write the function in between the arguments
ghci> :t (+)
(+) :: Num a => a -> a -> a 

add a b = a+b 
add 10 20 
10 `add` 20 
All equivalent 