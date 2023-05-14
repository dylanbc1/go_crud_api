# Recurrence Relation

## Number Of Inversions

- **Number Of Inversions:**
    
  To solve this first problem, we used the function ‘numberOfInversions’ to call the 'MergeSort' algorithm (which calls ‘merge’), so that it sorted the lists and counted the number of inversions that were necessary. Thus, we will calculate its recurrence relation.
    
  The function that gives us this recurrence relation is called 'mergeSort' in our algorithm. This function, takes the initial list of size n, splits it into two sublists of approximated size n/2, calls itself recursively 2 times (for the two resulting sublists) and at the end calls the 'merge' helper function which joins both already sorted sublists.
    
  We will start by defining the recurrence relationship that will determine the time that MergeSort takes, it will be **T(n) (n = length of the list)**
    
  Let's think that the list is of length 0 [T(0)] or of length 1 [T(1)], in that case its temporal complexity will be **O(1)**, because if the length of the input list is less than or equal to to 1, it takes constant time regardless of the size of the input, since if n = 0, the list is empty, so there's nothing to sort and we can't split into sublists, and if n = 1, there's nothing either to sort, since there is only one element, which is sorted.
    
  Now, let's look at the cases where n > 1. In these cases, MergeSort will split the list into two sublists of size n/2 approximately by making a recursive call to itself. Which leads to each list having its own recurrence relation for the time that is **T(n/2)**, then, if we add this to the recurrence relation of the main function, we would have: **T(n) = 2T(n/2)**
    
  We put the 2 at the beginning, because there are **two** sublists so there are two T(n/2). With this we already covered the part of the sublists and their ordering, we are missing the final step, which consists of calling the 'merge' function to join both ordered sublists:
    
  For 'merge', the union of two ordered sublists, we can see that its time complexity is linear to combine two ordered sublists. So it is **O(n).**
    
  So, joining the recurrence relation for the division of the list, the ordering of these sublists and the merge, we have:
  $$T(n) = 2T(n/2) + O(n)$$
    
  It should be noted that here we do not add the O(1) found at the beginning, since it does not really affect the time complexity of the algorithm and, furthermore, in the algorithm these cases (n<= 1) are handled as a special case
    

## Improved Quicksort

- **Improving Quicksort**
    
  To solve this problem, we took the Randomized QuickSort algorithm as a base and created one that instead of dividing the list into 2 and sorting them, divides the list into 3. It consists of an 'improvingQuickSort' function that takes two random pivots and calls its function helper 'randomized3WayPartition' that divides the list into three: those on the left, which are less or equal than pivot #1 and less than pivot #2, those in the center that are greater than pivot #1 and less or equal than pivot #2, and those on the right, which are greater than pivot #1 and greater than pivot #2. Then, in 'improvingQuickSort' the 3 lists are joined with the pivots and a recursive call is made to each list (to 'improvingQuickSort') so that they are ordered.
    
  The function that gives us this recurrence relation is called 'improvingQuickSort' in our algorithm. We will start by defining the recurrence relationship that will determine the time that ImprovingQuickSort takes, it will be **T(n) (n = length of the list)**
    
  We are going to find an average recurrence relation, because since the algorithm performs a partition of the list and compares all the elements with the pivots, there is a 'worst case' in which the complexity of the algorithm, like the classic QuickSort, is **O(n^2).**
    
  Let's think that the list is of length 0 [T(0)] or of length 1 [T(1)], in that case its temporal complexity will be **O(1)**, because if the length of the input list is less than or equal to 1, it takes constant time regardless of the size of the input, since if n = 0, the list is empty, so there's nothing to sort and we can't split into sublists, and if n = 1, there's nothing either to sort, since there is only one element, which is sorted.
    
  Now, let's look at the cases where n > 1. In these cases, first we will obtain the 2 random pivots, let's call their positions as **'q1' and 'q2' (in the future sorted list)**, where list(q1) < list(q2) (we make that verification in the algorithm), then, with these pivots, we will call the function 'randomized3WayPartition', which divides the list into three parts (those already mentioned above) and now we will call, for each resulting sublist (left, center, right), recursively again to 'improvingQuickSort'. 

  So, we can notice that when obtaining two random pivots, we do not know the exact length of each partition, since they are not always equal and one can be further from the other or vice versa, therefore, we are going to represent the division of the list of length $ original n$ with a constant $a$, where $a > 1$ so, we will have that each recursive call will have as input $\frac{n}{a}$ (here we will be assuming that the divisions will be of equal size). Now, we know that each resulting sublist will call $improvingQuickSort$ recursively, so we'll denote this number of calls as $b$, where $b \geq 1$. The partition cost in the worst case is O(n). So, the recurrence relation is:
    
  $$T(n) = b(\frac{n}{a}) + O(n)$$
    

## Closest Points

In this problem we use different recursive functions, but itself isn’t one, so we need to compute the entire complexity of the algorithm from the algorithms that are called. So, for each function whose time complexity is not easily calculable or evident. First, we will have the following table of functions whose time complexity is evident and easy to find, in order to summarize the procedure:

| Function | Temporal Complexity |
| --- | --- |
| noVoidPoints() | O(n) |
| middleLine() | O(1) |
| notExceedD() | O(n) |
| min() | O(1) |
| minDistanceOfPairDistances | O(n) |

- **Merge Sort Points:**
    
  We have already calculated the recurrence relation of the Merge Sort up, in the 'numberOfInversions' problem. Then we can

  use it here because the change is that we now are going to compare the points that the parameter indicate (0 - X or 1 - Y),

  and it doesn't affect the time complexity of the algorithm, because essentially it's the same comparison (one number and another number). 

  So, the recurrence relation is:

  $$T(n) = 2T(n/2) + O(n)$$
    
  Let's calculate its temporal complexity with the Master Method:
    
  **a** = 2 (two recursive calls)
    
  **b** = 2 (the list is partitioned in two)
    
  **f(n)** = O(n)
    
  So, we evaluate each step of the Master Method:
    
    1. ***T(n) = Θ(n ^ log_{b} {a}),* if:**
        
        f(n) = O(n ^ log_{b} {a} - ε), ε > 0
        
        O(n) = O(n ^ log_{2} 2 - ε)
        
        O(n) = O(n ^ 1 - ε) → NO, it isn’t fulfilled, since it doesn’t bound above (it is not greater)
        
    
    1. ***T(n) = Θ(n ^ log_{b} {a} log n),*** **if:**
        
        f(n) = Θ(n ^ log_{b} {a}) , ε > 0
        
        O(n) = Θ(n ^ log_{2} {2})
        
        **O(n) = Θ(n ^ 1)** → YES, it’s fullfilled, because is narrowly bounded (they are equal)
        
    
  Then, the temporal complexity is:
    
  **T(n) = Θ(n ^ log_{2}{2} log n)**
    
  $$T(n) = Θ(n‎‎\log‎ n)$$
    
- **Euclidean Distance:**
    
  To solve this problem, we use Euclidean Distance, which helps us recursively find the distance between a pair of integer points. So, the function that gives us this recurrence relation is called 'euclideanDistance' in our algorithm. We will start by defining the recurrence relationship that will determine the time that Euclidean Distance takes, it will be **T(n) (n = length of the list of points of the pair of points)**
    
  First, this function calls the recursive helper function 'euclideanDistanceRecursive' to get the distance between the two pairs of points following the Euclidean Distance formula, but not doing the square root.
    
  So, the function 'euclideanDistanceRecursive', performs a constant number of operations **(O(1))** to calculate the squared difference between the first elements of the two lists and add the result to the variable 'result'. The base case of the recursion is reached when both lists are empty (zero length), at which point the 'result' variable is returned.
    
  It should be noted that the code also includes some exit cases (return -1.0) if either of the two lists is empty, that is, if the format is not correct (however, this does not affect the recursion relation).
    
  Now, at the end of this 'euclideanDistanceRecursive' function a recursive call is made to itself, passing it the 'tail' of the list of each pair, therefore, as we define **T(n)** as the function time recurrence relation , then this recursive call will have a time recurrence relation **T(n-1)**, since the **length** of the pairs is **reduced by one unit** (we remove the 'head'). Thus, we have already calculated the recurrence relation with the base case and the recursive case, so the recurrence relation of the **‘euclideanDistanceRecursive’** is:
    
  $$T(n) = T(n-1) + O(1)$$
    
  Then, with this result, its square root is calculated, for this we use the 'squareRoot' function that uses different auxiliary functions, among them the main one, which is recursive. So, we will define this Square Root recurrence relation as **T'(n) (n = number for which the square root is being computed)**
    
  The 'iterativeSquareRoot' function uses the bisection approximation method, so in each iteration it reduces the search range by half, that is, the value of 'n' is reduced by half and makes a recursive call. This explains the presence of the term **T(n/2)** in the recurrence relation. Furthermore, the calculation of the square root is performed with a complexity of **O(1)**, since the 'iterativeSquareRoot' function uses a constant number of operations in each iteration. Thus, we have already calculated the recurrence relation with the base case and the recursive case, so the recurrence relation of the **‘squareRoot’** is:
    
  $$T’(n) = T’(n/2) + O(1)$$
    
  We already have the recurrence relations separately for the two recursive functions, now we must put them together in order to find the general recurrence relation. We must calculate the time complexity of the 'squareRoot' function:
    
  Following the Master Method, we have:
    
  **a =** 1
    
  **b =** 2
    
  **f(n) =** O(1)
    
    1. ***T(n) = Θ(n ^ log_{b} {a}),* if:**
        
        f(n) = O(n ^ log_{b} {a} - ε), ε > 0
        
        O(1) = O(n ^ log_{2} {1} - ε)
        
        O(1) = O(n ^ 0 - ε) → NO, it isn’t fulfilled, since it doesn’t bound above (it is not greater)
        
    2. ***T(n) = Θ(n ^ log_{b} {a} log n),*** **if:**
        
        f(n) = Θ(n ^ log_{b} {a}) , ε > 0
        
        O(1) = Θ(n ^ log_{2} {1})
        
        O(1) = Θ(n ^ 0)
        
        **O(1) = Θ(1)** → YES, it’s fulfilled, because is narrowly bounded (they are equal)
        
    
  Then, the temporal complexity is:
    
  **T(n) = Θ(n ^ log_{3} {2} log n)**
    
  **T(n) = Θ(n ^ 0 log n)**
    
  $$T(n) = Θ(\log n)$$
    
  Now we must put the first recurrence relation (’**euclideanDistanceRecursive’**) and the second temporal complexity **(‘squareRoot’)** together in order to find the general recurrence relation:
    
  $$T(n) = T(n-1) + O(\log n) + O(1)$$
    
  We see actually that O(1) doesn’t affect the temporal complexity, so we can express the recurrence relation as:
    
  $$T(n) = T(n-1) + O(\log n)$$
    
  This is a case of 'Decrease And Conquer', and its complexity with the Master Method has a different conditions. 
    
  ***T(n) = aT(n - b) + f(n)***
    
  ***Case 1:** If a < 1 then Θ(f(n)) = Θ(n ^ k log ^ p {n} )*
    
  ***Case 2:** If a = 1 then Θ(n * f(n)) = Θ(n ^ {k+1} log ^ p {n} )*
    
  ***Case 3:** If a > 1 then Θ(a ^ n/b * f(n)) = Θ(a ^ n/b {n ^ k} log ^ p {n} )*
    
  In the recurrence relation the necessary terms are:
    
  **a =** 1
    
  **b =** 1
    
  **f(n) =** O(log n)
    
  Following these conditions, we have that the temporal complexity is (case 2):
    
  $$T(n) = O(n \log n)$$
    

After this, we can add to the table of temporal complexity, the temporal complexity of ‘parallelForsMinDistance()’ and ‘quickSortPoints()’ and delete the one of ‘minDistanceOfPairDistances()’, because it’s already wrapped by the ‘parallelForsMinDistance()’

| Function | Temporal Complexity |
| --- | --- |
| noVoidPoints() | O(n) |
| middleLine() | O(1) |
| notExceedD() | O(n) |
| min() | O(1) |
| parallelForsMinDistance() | 2O(n) + O(n log n) |
| quickSortPoints() | O(n log n) |

Then, we can add to the table of temporal complexity, the temporal complexity of ‘findMinDistance()’ and delete the one of ‘parallelForsMinDistance()’, because it’s already wrapped by the ‘findMinDistance()’

| Function | Temporal Complexity |
| --- | --- |
| noVoidPoints() | O(n) |
| middleLine() | O(1) |
| notExceedD() | O(n) |
| min() | O(1) |
| findMinDistance() | 3O(n) + O(n log n) |
| quickSortPoints() | O(n log n) |