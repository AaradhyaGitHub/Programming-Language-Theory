-- ==================== PART ONE ====================

-- Problem 1: myremoveduplicates
-- without pattern matching
myremoveduplicates :: (Eq a) => [a] -> [a]
myremoveduplicates list
  | null list = []
  | elem (head list) (tail list) = myremoveduplicates (tail list)
  | otherwise = (head list) : myremoveduplicates (tail list)

-- with pattern matching
myremoveduplicates_pm :: (Eq a) => [a] -> [a]
myremoveduplicates_pm [] = []
myremoveduplicates_pm (x:xs)
  | elem x xs = myremoveduplicates_pm xs
  | otherwise = x : myremoveduplicates_pm xs

-- Problem 2: myintersection
-- without pattern matching
myintersection :: (Eq a) => [a] -> [a] -> [a]
myintersection list1 list2
  | null list1 = []
  | elem (head list1) list2 = (head list1) : myintersection (tail list1) list2
  | otherwise = myintersection (tail list1) list2

-- with pattern matching
myintersection_pm :: (Eq a) => [a] -> [a] -> [a]
myintersection_pm [] _ = []
myintersection_pm (x:xs) list2
  | elem x list2 = x : myintersection_pm xs list2
  | otherwise = myintersection_pm xs list2

-- Problem 3: mynthtail
-- without pattern matching
mynthtail :: Int -> [a] -> [a]
mynthtail n list
  | n == 0 = list
  | null list = []
  | otherwise = mynthtail (n-1) (tail list)

-- with pattern matching
mynthtail_pm :: Int -> [a] -> [a]
mynthtail_pm 0 list = list
mynthtail_pm _ [] = []
mynthtail_pm n (x:xs) = mynthtail_pm (n-1) xs

-- Problem 4: mylast
-- without pattern matching
mylast :: [a] -> [a]
mylast list
  | null list = []
  | null (tail list) = list
  | otherwise = mylast (tail list)

-- with pattern matching
mylast_pm :: [a] -> [a]
mylast_pm [] = []
mylast_pm [x] = [x]
mylast_pm (x:xs) = mylast_pm xs

-- Problem 5: myreverse
-- without pattern matching (efficient version with helper)
myreverse :: [a] -> [a]
myreverse list = reverseHelper list []
  where
    reverseHelper inlist acc
      | null inlist = acc
      | otherwise = reverseHelper (tail inlist) ((head inlist):acc)

-- with pattern matching (efficient version with helper)
myreverse_pm :: [a] -> [a]
myreverse_pm list = reverseHelper list []
  where
    reverseHelper [] acc = acc
    reverseHelper (x:xs) acc = reverseHelper xs (x:acc)

-- Problem 6: myreplaceall
-- without pattern matching
myreplaceall :: (Eq a) => a -> a -> [a] -> [a]
myreplaceall new old list
  | null list = []
  | (head list) == old = new : myreplaceall new old (tail list)
  | otherwise = (head list) : myreplaceall new old (tail list)

-- with pattern matching
myreplaceall_pm :: (Eq a) => a -> a -> [a] -> [a]
myreplaceall_pm _ _ [] = []
myreplaceall_pm new old (x:xs)
  | x == old = new : myreplaceall_pm new old xs
  | otherwise = x : myreplaceall_pm new old xs

-- Problem 7: myordered
-- without pattern matching
myordered :: (Ord a) => [a] -> Bool
myordered list
  | null list = True
  | null (tail list) = True
  | (head list) <= (head (tail list)) = myordered (tail list)
  | otherwise = False

-- with pattern matching
myordered_pm :: (Ord a) => [a] -> Bool
myordered_pm [] = True
myordered_pm [x] = True
myordered_pm (x:y:xs)
  | x <= y = myordered_pm (y:xs)
  | otherwise = False

-- ==================== PART TWO ====================

-- Calculator functions
-- using guards
calc :: String -> Double -> Double -> Double
calc op x y
  | op == "add" = x + y
  | op == "sub" = x - y
  | op == "mul" = x * y
  | op == "div" && y /= 0 = x / y
  | op == "pow" = x ** y
  | otherwise = 0.0

-- using pattern matching
calc_pm :: String -> Double -> Double -> Double
calc_pm "add" x y = x + y
calc_pm "sub" x y = x - y
calc_pm "mul" x y = x * y
calc_pm "div" x 0 = 0.0
calc_pm "div" x y = x / y
calc_pm "pow" x y = x ** y
calc_pm _ _ _ = 0.0

-- ==================== PART THREE ====================

-- listPairwise: applies operation to adjacent pairs
listPairwise :: String -> [Double] -> [Double]
listPairwise _ [] = []
listPairwise _ [x] = []
listPairwise op (x:y:xs) = calc_pm op x y : listPairwise op (y:xs)

-- runningTotal: computes cumulative sum
runningTotal :: [Double] -> [Double]
runningTotal list = runningHelper list 0
  where
    runningHelper [] _ = []
    runningHelper (x:xs) acc = newAcc : runningHelper xs newAcc
      where
        newAcc = calc_pm "add" acc x

-- ==================== PART FOUR ====================

-- Define the Operation type as a tuple
type Operation = (String, Double, Double)

-- evaluateOp: evaluates a single operation tuple
evaluateOp :: Operation -> Double
evaluateOp (op, x, y) = calc_pm op x y

-- evaluateAll: evaluates a list of operation tuples
evaluateAll :: [Operation] -> [Double]
evaluateAll [] = []
evaluateAll (op:ops) = evaluateOp op : evaluateAll ops

-- filterByResult: filters operations based on a predicate function
filterByResult :: (Double -> Bool) -> [Operation] -> [Operation]
filterByResult _ [] = []
filterByResult predicate (op:ops)
  | predicate (evaluateOp op) = op : filterByResult predicate ops
  | otherwise = filterByResult predicate ops

-- ==================== PART FIVE ====================

-- powers: infinite list of powers of a base
powers :: Double -> [Double]
powers base = powersHelper base 1
  where
    powersHelper b n = result : powersHelper b (n + 1)
      where
        result = calc_pm "pow" b n

-- factorials: infinite list of factorials
factorials :: [Double]
factorials = factorialsHelper 1 1
  where
    factorialsHelper n acc = acc : factorialsHelper (n + 1) newAcc
      where
        newAcc = calc_pm "mul" acc (n + 1)

-- combineSeqs: combine two infinite lists element-wise
combineSeqs :: String -> [Double] -> [Double] -> [Double]
combineSeqs _ [] _ = []
combineSeqs _ _ [] = []
combineSeqs op (x:xs) (y:ys) = calc_pm op x y : combineSeqs op xs ys