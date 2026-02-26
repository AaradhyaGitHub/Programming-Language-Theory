Recursion within functions 

Functions have ifs, let bindings, where bindings 
But there are no loops. You have to use recursion 

name <args> = ... name <args> ...

Recursion: 
fac n = 
 if n <= 1 then 
    1
 else 
   n * fac(n-1) 


fac3: 
3 *fac(2)
3 * 2 * fac(1) 
3*2*1 
6*1 
6 

Guards: 
- You can have 3,4,5 numbers of guards. 
- Guard needs to have some boolean expression like n <= 1 
- The first guard will evaluate to True and taken as definition for the function 

fac n 
 | n <= 1 = 1 
 | otherwise = n * fac (n-1)

patterm matching: 
is_zero 0 = True 
is_zero _ = False 

Another method to implement recursion is using Accumulators: 

fac n = aux n 1 
where 
  aux n acc
  | n <= 1 = acc
  | otherside = aux (n-1) (n*acc) 