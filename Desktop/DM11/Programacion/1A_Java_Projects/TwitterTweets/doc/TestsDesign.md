# **Test Design**

## - **Number Of Inversions**:

### Function
We are going to use the `numberOfInversions(list: List[Int])` function in these tests.

### Objective

The objective of this test design is to validate the functionality of the `numberOfInversions(...)` function on different types of lists.

### Test Plan

Seven lists with different characteristics will be used to evaluate the `numberOfInversions(...)` function:

1. `shortList`: List with few elements and no specific order.
2. `normalList`: List with non-repeated values and no specific order.
3. `repeatedList`: List with repeated values and no specific order.
4. `allRepeatedList`: List with repeated values and all equal.
5. `sortedList`: List with values ordered in ascending order.
6. `voidList`: Empty list.
7. `invertedSortedList`: List with values ordered in descending order.

For each list, an assertion will be made to validate that the `numberOfInversions(...)` function returns the correct number of inversions.

### Test Cases

| Test Case | Input List                 | Expected Result |
|-----------|----------------------------|----------------|
| 1         | shortList                  | 2              |  
| 2         | normalList                 | 4              |
| 3         | repeatedList               | 5              |
| 4         | allRepeatedList            | 0              |
| 5         | sortedList                 | 0              |
| 6         | voidList                   | 0              |
| 7         | invertedSortedList | 15             |

### Expected Results

We expect all assertions to pass successfully, indicating that the `numberOfInversions(...)` function is producing the correct number of inversions for each input list.

----

## - **Improving Quicksort**:

### Function
We are going to use the `improvingQuickSort(list: List[Int])` function in these tests.

### Objective

The objective of this test design is to validate the functionality of the `improvingQuickSort(...)` function on different types of lists.

### Test Plan

Six lists with different characteristics will be used to evaluate the `improvingQuickSort(...)` function:

1. `normalList`: List with non-repeated values and no specific order.
2. `repeatedList`: List with repeated values and no specific order.
3. `allRepeatedList`: List with repeated values and all equal.
4. `sortedList`: List with values ordered in ascending order.
5. `voidList`: Empty list.
6. `number3wayRepeatedList`: List with repeated values that occur three times at the start, at the center and at the end.

For each list, an assertion will be made to validate that the `improvingQuickSort(...)` function returns the list sorted in ascending order.

### Test Cases

| Test Case | Input List | Expected Result |
|---|---|---|
| 1 | normalList | List(2,3,6,7,9,10) |
| 2 | repeatedList | List(2,3,6,7,9,10,10) |
| 3 | allRepeatedList | List(1,1,1,1,1,1) |
| 4 | number3wayRepeatedList | List(1,3,7,8,10,10,10) |
| 5 | sortedList | List(1,2,3,10,22) |
| 6 | voidList | List() |

### Expected Results

We expect all assertions to pass successfully, indicating that the `improvingQuickSort(...)` function is returning the input lists sorted in ascending order.

----

## - **Randomized 3Way Partition**:

### Function
We are going to use the `randomized3WayPartition(list: List[Int], pivot: Int, pivot2: Int, left: List[Int], center: List[Int], right: List[Int])` function in these tests.

### Objective


The objective of this test design is to validate the functionality of the `randomized3WayPartition(...)` function on different types of lists.

### Test Plan

Three lists with different characteristics will be used to evaluate the `randomized3WayPartition(...)` function:

1. `normalList - (pivots [2,7])`: List with non-repeated values and no specific order.
2. `sortedList - (pivots [2,10])`: List with values ordered in ascending order.
3. `invertedSortedList - (pivots [1,8])`: List with values ordered in descending order.

For each list, an assertion will be made to validate that the `randomized3WayPartition(...)` function returns the three partitions (left, center, right) of the list sorted.

### Test Cases

| Test Case | Input List                     | Expected Result |
|---|--------------------------------|---|
| 1 | normalList - (pivots [2,7])    | List() |
| 2 | repeatedList - (pivots [2,10]) | List(22) |
| 3 | allRepeatedList - (pivots [1,8])    | List(6, 7) |

### Expected Results

We expect all assertions to pass successfully, indicating that the `randomized3WayPartition(...)` function is returning the sublist (left,center,right) sorted in ascending order.

----

## - **Merge Sort:**

### Function
We are going to use the `mergeSort(list: List[Int])` function in these tests.

### Objective

The objective of this test design is to validate the functionality of the `mergeSort(...)` function on different types of lists.

### Test Plan

Six lists with different characteristics will be used to evaluate the `mergeSort(...)` function:

1. `normalList`: List with non-repeated values and no specific order.
2. `repeatedList`: List with repeated values and no specific order.
3. `allRepeatedList`: List with repeated values and all equal.
4. `sortedList`: List with values ordered in ascending order.
5. `voidList`: Empty list.

For each list, an assertion will be made to validate that the `mergeSort(...)` function returns the list sorted in ascending order.

### Test Cases

| Test Case | Input List | Expected Result |
|---|---|---|
| 1 | normalList | List(2,3,6,7,9,10) |
| 2 | repeatedList | List(2,3,6,7,9,10,10) |
| 3 | allRepeatedList | List(1,1,1,1,1,1) |
| 4 | sortedList | List(1,2,3,10,22) |
| 5 | voidList | List() |

### Expected Results

We expect all assertions to pass successfully, indicating that the `mergeSort(...)` function is returning the input lists merged.

----

## - **Merge:**

### Function
We are going to use the `merge(left_list: List[Int], right_list: List[Int], countInv: Int)` function in these tests.

### Objective

The objective of this test design is to validate the functionality of the `merge(...)` function on different types of lists.

### Test Plan

Three lists with different characteristics will be used to evaluate the `merge(...)` function:

1. `normalList (left, right)`: List with non-repeated values and no specific order.
2. `repeatedList (left, right)`: List with repeated values and no specific order.
3. `allRepeatedList (left, right)`: List with repeated values and all equal.

For each list, an assertion will be made to validate that the `merge(...)` function returns the sublists sorted in ascending order.

### Test Cases

| Test Case | Input List                                  | Expected Result |
|---|---------------------------------------------|---|
| 1 | normalList (List(10,7,3), List(6,2,9))      | List(2,3,6,7,9,10) |
| 2 | repeatedList (List(10,7,3), List(10,6,2,9)) | List(2,3,6,7,9,10,10) |
| 3 | allRepeatedList (List(1,1,1), List(1,1,1))  | List(1,1,1,1,1,1) |

### Expected Results

We expect all assertions to pass successfully, indicating that the `merge(...)` function is returning the input lists sorted in ascending order.

----

## - **Closest Points**

### Function
We are going to use the `closestPoints(list: List[List[Int]])` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `closestPoints(...)` function using different types of sets of points.

### Test Plan
Seven sets of points with different characteristics will be used to evaluate the `closestPoints(...)` function:
- `oneSetPoint:` List with only one pair of points.
- `threeSetPoints:` List with three pair of points.
- `normalSetPoints:` List with non-repeated points and no specific order.
- `repeatedSetPoints:` List with repeated points.
- `oneRepeatedSetPoints:` List with only one repeated point.
- `voidPoints:` List of empty points.
- `oneVoidPoint:` List with only one empty point.

For each set of points, an assertion will be made to validate that the `closestPoints(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points | Expected Result |
|----------|--------------|-----------------|
 | 1        | threeSetPoints | 1.0 |
 | 2        | oneSetPoint    | -1.0|
 | 3        | normalSetPoints | 2.2360 |
| 4        | repeatedSetPoints | -1.0 |
| 5        | oneRepeatedSetPoints | 2.2360 |
| 6        | voidPoints | -1.0 |
| 7        | oneVoidPoint | 3.1622 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `closestPoints(...)` function is returning the expected result for each set of points.

----

## - **Merge Sort Points**

### Function
We are going to use the `mergeSortPoints(list: List[List[Int]], whichPoints: Int)` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `mergeSortPoints(...)` function using different types of sets of points.

### Test Plan
Four sets of points with different characteristics will be used to evaluate the `mergeSortPoints(...)` function:
- `oneSetPoint:` List with only one pair of points.
- `normalSetPoints:` List with non-repeated points and no specific order.
- `repeatedSetPoints:` List with repeated points.
- `oneRepeatedSetPoints:` List with only one repeated point.

For each set of points, an assertion will be made to validate that the `mergeSortPoints(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points | Expected Result                                                |
|----------|--------------|----------------------------------------------------------------|
| 1        | oneSetPoint | oneSetPoint                                                    |
| 2        | normalSetPoints    | List(List(-2,1), List(-1,-3), List(0,0), List(4,9))            |
| 3        | repeatedSetPoints | repeatedSetPoints                                              |
| 4        | oneRepeatedSetPoints | List(List(-1,-3), List(0,0), List(-2,1), List(-2,1), List(4,9) |

### Expected Results
We expect all assertions to pass successfully, indicating that the `mergeSortPoints(...)` function is returning the expected result for each set of points.

----

## - **Merge Points:**

### Function
We are going to use the `mergePoints(left_list: List[Int], right_list: List[Int], whichPoints: Int)` function in these tests.

### Objective

The objective of this test design is to validate the functionality of the `mergePoints(...)` function on different types of lists.

### Test Plan

Three lists with different characteristics will be used to evaluate the `mergePoints(...)` function:

1. `threeSetPoints (left, right)`: List with three pair of points.
2. `repeatedSetPoints (left, right)`: List with repeated points.
3. `oneRepeatedSetPoints (left, right)`: List with only one repeated point.

For each list, an assertion will be made to validate that the `mergePoints(...)` function returns the sublists sorted in ascending order.

### Test Cases

| Test Case | Input List                                                     | Expected Result                                                     |
|---|----------------------------------------------------------------|---------------------------------------------------------------------|
| 1 | threeSetPoints (List(List(0, 0), List(0,1)), List(List(1, 1))) | threeSetPoints                                                      |
| 2 | repeatedSetPoints (List(List(4, 9), List(4,9), List(4,9)), List(List(4, 9), List(4,9))               | repeatedSetPoints                                                   |
| 3 | oneRepeatedSetPoints (List(List(0, 0), List(4, 9), List(-1, -3)), List(List(-2, 1), List(-2, 1))                | List(List(-2, 1), List(-2, 1),List(0, 0), List(4, 9), List(-1, -3)) |

### Expected Results

We expect all assertions to pass successfully, indicating that the `mergePoints(...)` function is returning the input lists sorted in ascending order.

----

## - **No Void Points:**

### Function
We are going to use the `noVoidPoints(list: List[List[Int]], resultList: List[List[Int]])` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `noVoidPoints(...)` function using different types of sets of points.

### Test Plan
Five sets of points with different characteristics will be used to evaluate the `noVoidPoints(...)` function:
- `oneSetPoint:` List with only one pair of points.
- `normalSetPoints:` List with non-repeated points and no specific order.
- `repeatedSetPoints:` List with repeated points.
- `oneVoidPoint:` List with only one empty point.
- `voidPoints:` List of empty points.

For each set of points, an assertion will be made to validate that the `noVoidPoints(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points      | Expected Result                         |
|-----------|-------------------|-----------------------------------------|
| 1         | oneSetPoint       | oneSetPoint                             |
| 2         | normalSetPoints   | normalSetPoints.reverse                 |
| 3         | repeatedSetPoints | repeatedSetPoints.reverse               |
| 4         | oneVoidPoint      | List(List(-1,-3), List(4,9), List(0,0)) |
| 5         | voidPoints        | List()                                  |

### Expected Results
We expect all assertions to pass successfully, indicating that the `noVoidPoints(...)` function is returning the expected result for each set of points.

----

## - **Middle Line:**

### Function
We are going to use the `middleLine(list: List[List[Int]])` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `middleLine(...)` function using different types of sets of points.

### Test Plan
Three sets of points with different characteristics will be used to evaluate the `middleLine(...)` function:
- `repeatedSetPoints:` List with repeated points.
- `normalSetPoints:` List with non-repeated points and no specific order.
- `oneRepeatedSetPoints:` List with only one repeated point.

For each set of points, an assertion will be made to validate that the `middleLine(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points         | Expected Result                         |
|----------|----------------------|-----------------------------------------|
| 1        | repeatedSetPoints    | List(4.0,9.0)                             |
| 2        | normalSetPoints      | List(1.5,3.0)                 |
| 3        | oneRepeatedSetPoints | List(-1.0,-3.0)              |

### Expected Results
We expect all assertions to pass successfully, indicating that the `middleLine(...)` function is returning the expected result for each set of points.

----

## - **Not Exceed D:**

### Function
We are going to use the `notExceedD(list: List[List[Int]], middleLine: List[Double], d: double, resultList: List[List[Int]])` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `notExceedD(...)` function using different types of sets of points.

### Test Plan
Three sets of points with different characteristics will be used to evaluate the `notExceedD(...)` function:
- `repeatedSetPoints:` List with repeated points.
- `normalSetPoints:` List with non-repeated points and no specific order.
- `threeSetPoints:` List with only one repeated point.

Two 'middleLine' and one 'd' will be used to evaluate the `notExceedD(...)` function:
- `positiveMiddleLine:` Positive number.
- `negativeMiddleLine:` Negative number.
- `d:` Positive number (distance).

For each set of points, an assertion will be made to validate that the `notExceedD(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points                             | Expected Result                  |
|----------|------------------------------------------|----------------------------------|
| 1        | normalSetPoints, positiveMiddleLine, d   | List(List(-1, -3), List(0, 0))                 |
| 2        | repeatedSetPoints, negativeMiddleLine, d | List()                 |
| 3        | threeSetPoints, positiveMiddleLine, d    | List(List(1, 1), List(0, 1), List(0, 0))       |

### Expected Results
We expect all assertions to pass successfully, indicating that the `notExceedD(...)` function is returning the expected result for each set of points.

----

## - **Min:**

### Function
We are going to use the `min(value: Double, value2: Double)` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `min(...)` function using different double numbers.

### Test Plan
Three double numbers with different characteristics will be used to evaluate the `min(...)` function:
- `positiveNumber:` Positive double number.
- `positiveNumber2:` Positive double number.
- `negativeNumber:` Negative double number.

For each set of points, an assertion will be made to validate that the `min(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points                    | Expected Result |
|----------|---------------------------------|-----------------|
| 1        | positiveNumber, negativeNumber  | negativeNumber  |
| 2        | negativeNumber, negativeNumber  | negativeNumber  |
| 3        | positiveNumber, positiveNumber2 | positiveNumber  |

### Expected Results
We expect all assertions to pass successfully, indicating that the `min(...)` function is returning the expected result.

----

## - **Parallel Fors Min Distance:**

### Function
We are going to use the `parallelForsMinDistance(pair: List[Int], list: List[List[Int]], distances: List[Double])` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `parallelForsMinDistance(...)` function using different types of sets of points.

### Test Plan
Three sets of points with different characteristics will be used to evaluate the `parallelForsMinDistance(...)` function:
- `threeSetPoints:` List with only one repeated point.
- `normalSetPoints:` List with non-repeated points and no specific order.
- `repeatedSetPoints:` List with repeated points.

For each set of points, an assertion will be made to validate that the `parallelForsMinDistance(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points | Expected Result    |
|-----------|------------|--------------------|
| 1         | threeSetPoints | 1.0                |
| 2         | normalSetPoints | 2.2360688956433634 |
| 3         | repeatedSetPoints | 2.147483647E9      |


### Expected Results
We expect all assertions to pass successfully, indicating that the `parallelForsMinDistance(...)` function is returning the expected result for each set of points.

----

## - **Min Distance Of Pairs Distances:**

### Function
We are going to use the `minDistanceOfPairsDistances(distancesList: List[Double], min: Double)` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `minDistanceOfPairsDistances(...)` function using different distances lists.

### Test Plan
Three double numbers with different characteristics will be used to evaluate the `minDistanceOfPairsDistances(...)` function:
- `distances:` Normal distances.
- `repeatedDistances:` Two repeated distances in a normal list of distances.
- `voidDistances:` No distances.

For each set of points, an assertion will be made to validate that the `minDistanceOfPairsDistances(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points      | Expected Result |
|----------|-------------------|-----------------|
| 1        | distances         | 0.99            |
| 2        | repeatedDistances | 1.1             |
| 3        | voidDistances     | Int.MaxValue    |

### Expected Results
We expect all assertions to pass successfully, indicating that the `minDistanceOfPairsDistances(...)` function is returning the expected result.

----

## - **Find Min Distance**

### Function
We are going to use the `findMinDistance(list: List[List[Int]], min: Double)` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `findMinDistance(...)` function using different types of sets of points.

### Test Plan
Three sets of points with different characteristics will be used to evaluate the `findMinDistance(...)` function:
- `setPoints1:` List with n (n > 2) pair of points.
- `setVoidPoins:` List with no elements.
- `setPoints2:` List with only two pair of points.

For each set of points, an assertion will be made to validate that the `findMinDistance(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points | Expected Result |
|-----------|------------|-----------------|
| 1         | setPoints1 | 2.2360          |
| 2         | setVoidPoints | Int.MaxValue    |
| 3         | setPoints2 | 1.0000          |


### Expected Results
We expect all assertions to pass successfully, indicating that the `findMinDistance(...)` function is returning the expected result for each set of points.

----

## - **Euclidean Distance**

### Function
We are going to use the `euclideanDistance(firstPair: List[Int], secondPair: List[Int])` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `euclideanDistance(...)` function using different pairs of points.

### Test Plan
Six pairs of points with different characteristics will be used to evaluate the `euclideanDistance(...)` function:
- `firstPair:` A list of two non-negative integers.
- `secondPair:` A list of two non-negative integers.
- `thirdPair:` A list of two integers, where one or both may be negative.
- `voidPair:` An empty list.
- `samePair:` A list of two identical non-negative integers.

For each pair of points, an assertion will be made to validate that the `euclideanDistance(...)` function returns the correct result.

### Test Cases
| Test Case | Input Points | Expected Result |
|-----------|--------------|-----------------|
| 1         | firstPair, secondPair | 9.8489 |
| 2         | firstPair, thirdPair | 3.1623 |
| 3         | secondPair, thirdPair | 7.8103 |
| 4         | voidPair, secondPair | -1.0 |
| 5         | thirdPair, voidPair | -1.0 |
| 6         | samePair, samePair | 0.0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `euclideanDistance(...)` function is returning the expected distance value for each pair of points.

----

## - **Predecessor**

### Function
We are going to use the `pred(n: Int)` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `pred(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `pred(...)` function:
- `number1:` A positive number.
- `number2:` Zero.
- `number3:` A negative number.

It's important to know that the `pred(...)` function, only works for positive integers, excluding 0, and for the other numbers (negative integers and zero) the result is 0. So, for each number, an assertion will be made to validate that the Predecessor function returns the correct result.

### Test Cases
| Test Case | Input Number | Expected Result |
|-----------|--------------|-----------------|
| 1         | number1 | 1 |
| 2         | number2 | 0 |
| 3         | number3 | 0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `pred(...)` function is returning the expected value for each number.

----

## - **Square Root**:

### Function
We are going to use the `squareRoot(number: Double)` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `squareRoot(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `squareRoot(...)` functions:
- `number1ToSquareRoot:` A positive number with exact square root.
- `number2ToSquareRoot:` A positive number with no exact square root.
- `number3ToSquareRoot:` Zero.

Now, for each number, an assertion will be made to validate that the `squareRoot(...)` function returns the correct result.

### Test Cases
| Test Case | Input Number        | Expected Result |
|-----------|---------------------|-----------------|
| 1         | number1ToSquareRoot | 2.0000 |
| 2         | number2ToSquareRoot | 1.4142 |
| 3         | number3ToSquareRoot | 0.0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `squareRoot(...)` function is returning the expected value for each number.

----

## - **Abs**:

### Function
We are going to use the `abs(x: Int)` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `abs(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `abs(...)` functions:
- `number1:` A positive number.
- `number2:` Zero.
- `number3:` A negative number.

Now, for each number, an assertion will be made to validate that the `abs(...)` function returns the correct result.

### Test Cases
| Test Case | Input Number | Expected Result |
|-----------|--------------|-----------------|
| 1         | number1 | 2 |
| 2         | number2 | 0 |
| 3         | number3 | 4 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `abs(...)` function is returning the expected value for each number.

----

## - **Pow**:

### Function
We are going to use the `pow(base: Int, exp: Int)` function in these tests.

### Objective
The objective of this test design is to validate the functionality of the `pow(...)` function using different integer numbers.

### Test Plan
Three numbers will be used to evaluate `pow(...)` function as the base and other three numbers will be used as the exp:
- `number1:` A positive number.
- `number2:` Zero.
- `number3:` A negative number.
- `exp1:` A positive number.
- `exp2:` Zero.
- `exp3:` A positive number.

Now, for each number, an assertion will be made to validate that the `pow(...)` function returns the correct result.

### Test Cases
| Test Case | Input Numbers (base, exp) | Expected Result |
|-----------|--------------|-----------------|
| 1         | number1,exp1 | 4 |
| 2         | number3,exp1 | 1 |
| 3         | number1,exp2 | 1 |
| 4         | number2,exp3 | 0 |

### Expected Results
We expect all assertions to pass successfully, indicating that the `pow(...)` function is returning the expected value for each number.