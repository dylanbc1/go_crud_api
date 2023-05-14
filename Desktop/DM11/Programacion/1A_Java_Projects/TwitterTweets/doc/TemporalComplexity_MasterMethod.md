# Temporal Complexity - Master Method

We are going to find the temporal complexity of the three problems with the **Master Method**, according to the recurrence relations found.

## Number Of Inversions

- **numberOfInversions()**
    
  We found that its recurrence relation is:
    
  **T(n) = 2T(n/2) + O(n)**
    
  We define the necessary terms:
    
  **a** = 2 (two recursive calls)
    
  **b** = 2 (we divide in 2)
    
  **f(n)** = O(n)
    
  So, we evaluate each step of the Master Method:
    
    1. ***T(n) = Θ(n ^ log_{b} {a}),* if:**
        
        f(n) = O(n ^ log_{b} {a} - ε), ε > 0
        
        O(n) = O(n ^ log_{2} 2 - ε)
        
        O(n) = O(n ^ 1 - ε) → NO, it isn’t fullfilled, since it doesn’t bound above (it is not greater)
        
    
    1. ***T(n) = Θ(n ^ log_{b} {a} log n),*** **if:**
        
        f(n) = Θ(n ^ log_{b} {a}) , ε > 0
        
        O(n) = Θ(n ^ log_{2} {2})
        
        **O(n) = Θ(n ^ 1)** → YES, it’s fullfilled, because is narrowly bounded (they are equal)
        
    
  Then, the temporal complexity is:
    
  **T(n) = Θ(n ^ log_{2} {2} log n)**
    
  $$T(n) = Θ(n \log n)$$
    

## Improved Quicksort

- **improvingQuickSort()**
    
  We found that its recurrence relation is:
    
  **T(n) = b(\frac{n}{a}) + O(n)**

  For practical purposes and in order to find the algorithmic complexity, we will assume that $a$ and $b$ have the same value. That is, $a=b$

  We define the necessary terms:

  **a** = b

  **b** = a

  **f(n)** = O(n)
    
  So, we evaluate each step of the Master Method:
    
    1. ***T(n) = Θ(n ^ log_{b} {a}),* if:**
        
        f(n) = O(n ^ log_{b} {a} - ε), ε > 0
        
        O(n) = O(n ^ log_{a} {b} - ε)
        
        O(n) = O(n ^ 1 - ε) → NO, it isn’t fullfilled, since it doesn’t bound above (it is not greater)
        
    
    1. ***T(n) = Θ(n ^ log_{b} {a} log n),*** **if:**
        
        f(n) = Θ(n ^ log_{b} {a}) , ε > 0
        
        O(n) = Θ(n ^ log_{a} {b})
        
        **O(n) = Θ(n ^ 1)** → YES, it’s fullfilled, because is narrowly bounded (they are equal)
        
    
  Then, the temporal complexity is:
    
  **T(n) = Θ(n ^ log_{a} {b} log n)**
    
  $$T(n) = Θ(n \log n)$$
    

## Closest Points

- **closestPoints()**
    
  In the 'Recurrence Relation' document we already defined the recurrence relations of the functions that this function uses and their temporal complexities, now we only have to add these complexities (depending on the number of functions that use this main function) and simplify, to find the total time complexity. So:
    
  **T(n) = noVoidPoints() + 2[mergeSortPoints()] + 3[findMinDistance()] + 2[min()] + notExceedD() + middleLine()**
    
  T(n) = O(n) + 2[ O(n log n) ] + 3[ 3O(n) + O(n log n) ] + 2[ O(1) ] + O(n) + O(1)
    
  T(n) = O(n) + 2O(n log n) + 9O(n) + 3O(n log n) + 2O(1) + O(n) + O(1)
    
  T(n) = 11 O(n) + 5 O(n log n) + 3 O(1)
    
  Now, we can simplify this result removing the constants, as they don't really affect time complexity
    
  T(n) = O(n) + O(n log n)
    
  Finally, we take the dominant temporal complexity, that is, the one that grows faster, in this case, as we can see, it is O(n log n). So:
    
  $$T(n) = O(n \log n)$$