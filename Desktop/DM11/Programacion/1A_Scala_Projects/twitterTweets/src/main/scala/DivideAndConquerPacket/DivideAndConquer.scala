package DivideAndConquerPacket

import scala.annotation.tailrec
import scala.util.Random
import java.lang.Math
import java.text.DecimalFormat

object DivideAndConquer extends App with IDivideAndConquer {

  /**
   *
   * Number of inversions to sort a list
   *
   * @param list List to be sorted
   * @return Number of inversions to sort the list
   */
  def numberOfInversions(list: List[Int]): Int =
    mergeSort(list)._2

  /**
   *
   * QuickSort improved, using a 3Way partition
   *
   * @param list List to be sorted
   * @return List already sorted
   */
  def improvingQuickSort(list: List[Int]): List[Int] =
    list match
      case Nil => list
      case head :: Nil => list
      case head :: tail =>
        val pivotPos = random(1, list.length - 1)
        val anotherPivotPos = random(pivotPos + 1, list.length)

        val pivot = list(pivotPos - 1)
        val anotherPivot = list(anotherPivotPos - 1)

        val valueHead = list.head
        val valueHead2 = list.tail.head
        var exchangedList: List[Int] = List()

        if (pivotPos == 2) {
          exchangedList = list.updated(0, pivot).updated(pivotPos - 1, valueHead).updated(1, anotherPivot).updated(anotherPivotPos - 1, valueHead)
        } else {
          exchangedList = list.updated(0, pivot).updated(pivotPos - 1, valueHead).updated(1, anotherPivot).updated(anotherPivotPos - 1, valueHead2)
        }

        // There are 2 pivots, then I need to compare them to know their respective order
        if (pivot > anotherPivot) {
          val (left, center, right) = randomized3WayPartition(exchangedList.tail.tail, anotherPivot, pivot, List(), List(), List())
          improvingQuickSort(left) ::: (anotherPivot :: improvingQuickSort(center) ::: (pivot :: improvingQuickSort(right)))
        } else if (pivot < anotherPivot) {
          val (left, center, right) = randomized3WayPartition(exchangedList.tail.tail, pivot, anotherPivot, List(), List(), List())
          improvingQuickSort(left) ::: (pivot :: improvingQuickSort(center) ::: (anotherPivot :: improvingQuickSort(right)))
        } else {
          val (left, center, right) = randomized3WayPartition(exchangedList.tail.tail, pivot, anotherPivot, List(), List(), List())
          improvingQuickSort(left) ::: improvingQuickSort(center) ::: (pivot :: (anotherPivot :: improvingQuickSort(right)))
        }

  /**
   *
   * Sort a list according to a pivot making a 3Way partition
   *
   * @param list List to be sorted
   * @param pivot Pivot #1 to compare
   * @param pivot2 Pivot #2 to compare
   * @param left Left result list
   * @param center Center result list
   * @param right Right result list
   * @return Number of inversions to sort the list
   */
  @tailrec
  def randomized3WayPartition(list: List[Int], pivot: Int, pivot2: Int, left: List[Int], center: List[Int], right: List[Int]): (List[Int], List[Int], List[Int]) =
    list match
      case Nil => (left, center, right)
      case head :: tail =>
        if (head <= pivot2 && head > pivot) {
          randomized3WayPartition(tail, pivot, pivot2, left, head :: center, right)
        } else if (head <= pivot) {
          randomized3WayPartition(tail, pivot, pivot2, head :: left, center, right)
        } else {
          randomized3WayPartition(tail, pivot, pivot2, left, center, head :: right)
        }

  /**
   *
   * Finds the closest (different) points of a list
   *
   * @param list List of pair of points
   * @return The distance of the closest points of a list of points (the points are pair of int numbers)
   */
  def closestPoints(list: List[List[Int]]): Double =
    val listWithNoVoidPoints = noVoidPoints(list, List()) // O(n)

    if(listWithNoVoidPoints == Nil || listWithNoVoidPoints.length == 1){
      -1.0
    } else {
      val xPoints = mergeSortPoints(listWithNoVoidPoints, 0) // O(n lg n)

      val (xd1, xd2) = xPoints splitAt (xPoints.length / 2)
      val xd1Min = findMinDistance(xd1, Int.MaxValue) // O(n)
      val xd2Min = findMinDistance(xd2, Int.MaxValue)

      val xMinDistance = min(xd1Min, xd2Min)

      val notExceedXMinDistance = notExceedD(listWithNoVoidPoints, middleLine(xPoints), xMinDistance, List()) // O(n)

      val yPoints = mergeSortPoints(notExceedXMinDistance, 1)
      val yMinDistance = findMinDistance(yPoints, Int.MaxValue)

      // Como INT MAX VALUE es el min que paso para comparar, si aun haciendo el
      // findMinDistance me da ese resultado, significa que no hubo uno menor y por tanto
      // todos los puntos son iguales
      if (xMinDistance == Int.MaxValue && yMinDistance == Int.MaxValue) {
        -1.0
      } else {
        BigDecimal(min(xMinDistance, yMinDistance)).setScale(4, BigDecimal.RoundingMode.DOWN).toString.toDouble
      }
    }

  /**
   *
   * Filter list to no void points
   *
   * @param list List to be filtered
   * @param resultList Result list to acumulate
   * @return Points with no void elements
   */
  @tailrec
  def noVoidPoints(list: List[List[Int]], resultList: List[List[Int]]): List[List[Int]] =
    list match
      case Nil => resultList
      case head::tail =>
        if(head == Nil) {
          noVoidPoints(tail, resultList)
        } else {
          noVoidPoints(tail, head::resultList)
        }

  /**
   *
   * Finds the middle point of the list
   *
   * @param list list that will be use in order to find the middle point
   * @return middle point of the list
   */
  def middleLine(list: List[List[Int]]): List[Double] =
    val center = math.floor(list.length / 2).toInt

    if (list.length % 2 == 0) {
      List( ((list(center-1).head + list(center).head) / 2.0).toDouble, ((list(center-1)(1) + list(center)(1)) / 2.0).toDouble)
    } else {
      List(list(center).head / 1.0, list(center)(1) / 1.0)
    }

  /**
   *
   * Filters the points that not exceed a distance d
   *
   * @param list List of pairs of points
   * @param middleLine Pair of points that are the middle line
   * @param d Distance that points can't exceed
   * @param resultList Result list of filtered points
   * @return List of pair of points that doesn't exceed d
   */
  @tailrec
  def notExceedD(list: List[List[Int]], middleLine: List[Double], d: Double, resultList: List[List[Int]]): List[List[Int]] =
    list match {
      case Nil => resultList
      case head :: tail =>
        var xDistance = head.head - middleLine.head

        if(xDistance < 0){
          xDistance = xDistance*(-1)
        }

        if (xDistance >= d) {
          notExceedD(tail, middleLine, d, resultList)
        } else {
          notExceedD(tail, middleLine, d, head :: resultList)
        }
    }

  /**
   *
   * Finds the minimum distance between two given distance
   *
   * @param value minimum distance between two points
   * @param value2 minimum distance between two points
   * @return minimum value or distance between the two values given before
   */
  def min(value: Double, value2: Double): Double =
    if (value < value2) {
      value
    } else {
      value2
    }

  /**
   *
   * Sort a list of pair of points (according to X or Y) with QuickSort
   *
   * @param list        List to be sorted
   * @param whichPoints X or Y points
   * @return Sorted list according to the specified points
   */
  // Sort the points by X or Y
  def mergeSortPoints(list: List[List[Int]], whichPoints: Int): (List[List[Int]]) =
    if (list.length <= 1) (list)
    else {
      val (left, right) = list.splitAt(list.length / 2)
      val (leftSorted) = mergeSortPoints(left, whichPoints)
      val (rightSorted) = mergeSortPoints(right, whichPoints)
      val (merged) = mergePoints(leftSorted, rightSorted, whichPoints)
      merged
    }


  /**
   *
   * Partition of the list of pair of points for X or Y
   *
   * @param list_left        Left part of the given list
   * @param list_right       Right part of the given list
   * @param whichPoints Is the indicator that tells the algorithm if we order the list respect to x or respect to y
   * @return The two partitions of pair of points
   */
  def mergePoints(list_left: List[List[Int]], list_right: List[List[Int]], whichPoints: Int): (List[List[Int]]) =
    (list_left, list_right) match {
      case (Nil, _) => (list_right)
      case (_, Nil) => (list_left)
      case (head1 :: tail1, head2 :: tail2) =>
        if (whichPoints == 0) {
          if (head1.head <= head2.head) {
            val (merged) = mergePoints(tail1, list_right, whichPoints)
            (head1 :: merged)
          } else {
            val (merged) = mergePoints(list_left, tail2, whichPoints)
            (head2 :: merged)
          }
        } else {
          if (head1(1) <= head2(1)) {
            val (merged) = mergePoints(tail1, list_right, whichPoints)
            (head1 :: merged)
          } else {
            val (merged) = mergePoints(list_left, tail2, whichPoints)
            (head2 :: merged)
          }
        }
    }

  /**
   *
   * Minimum distance of a pair of points
   *
   * @param list List of pair of points
   * @param min Min value to compare the values
   * @return Minimum distance of a list of pair of points
   */
  @tailrec // 3 O(n) + O(n log n)
  def findMinDistance(list: List[List[Int]], min: Double): Double =
    list match
      case Nil => min
      case head :: tail =>
        val possibleMin = parallelForsMinDistance(head, tail, List()) // 2 O(n) + O(n log n)

        if(possibleMin < min){
          findMinDistance(tail, possibleMin)
        } else {
          findMinDistance(tail, min)
        }

  /**
   *
   * Acts like two 'for', to find the distances within a pair of points and the rest of pair of points
   * @param pair Pair of points to compare
   * @param list List of pair of points.
   * @param distances List to acumulate the result distances
   * @return Number of inversions to sort the list
   */
  @tailrec // 2 O(n) + O(n log n)
  def parallelForsMinDistance(pair: List[Int], list: List[List[Int]], distances: List[Double]): Double =
    list match
      case Nil => minDistanceOfPairDistances(distances, Int.MaxValue) // O(n)
      case head::tail =>                  // T(n) = T(n-1) + O(1) -> O(n lg n) +
        parallelForsMinDistance(pair, tail, euclideanDistance(pair, head)::distances)

  /**
   *
   * Find the min distances of a list
   *
   * @param distancesList List of the distances
   * @param min Value to compare the rest of values
   * @return Minimum distance found
   */
  @tailrec
  def minDistanceOfPairDistances(distancesList: List[Double], min: Double): Double =
    distancesList match
      case Nil => min
      case head::tail =>
        if(distancesList.head == 0.03125){ // we know that this is the distance calculated
          // and approximated of the functions of same pair of points
          minDistanceOfPairDistances(distancesList.tail, min)
        } else {
          if (distancesList.head < min) {
            minDistanceOfPairDistances(distancesList.tail, distancesList.head)
          } else {
            minDistanceOfPairDistances(distancesList.tail, min)
          }
        }

  /**
   *
   * Sort a list with Merge Sort and find necessary number of inversions to sort it
   *
   * @param list List to be sorted
   * @return Sorted list, Number of inversions
   */
  def mergeSort(list: List[Int]): (List[Int], Int) = {
    if (list.length <= 1) (list, 0)
    else {
      val (left, right) = list.splitAt(list.length / 2)
      val (leftSorted, leftInversions) = mergeSort(left)
      val (rightSorted, rightInversions) = mergeSort(right)
      val (merged, mergeInversions) = merge(leftSorted, rightSorted, 0)
      (merged, leftInversions + rightInversions + mergeInversions)
    }
  }

  /**
   *
   * Merge two sublists, with the intention to sort them
   *
   * @param list_left Left list to be sorted
   * @param list_right Right list to be sorted
   * @param countInv Amount of inversions (acumulated)
   * @return Merged lists in one list, Number of inversions
   */
  def merge(list_left: List[Int], list_right: List[Int], countInv: Int): (List[Int], Int) =
    (list_left, list_right) match {
      case (Nil, _) => (list_right, countInv)
      case (_, Nil) => (list_left, countInv)
      case (head1 :: tail1, head2 :: tail2) =>
        if (head1 <= head2) {
          val (merged, inversions) = merge(tail1, list_right, countInv)
          (head1 :: merged, inversions)
        } else {
          val (merged, inversions) = merge(list_left, tail2, countInv + list_left.length)
          (head2 :: merged, inversions)
        }
    }

  /**
   *
   * Selects a random number in the range
   *
   * @param start Start of the range
   * @param end End of the range
   * @return Random number in the range
   */
  // QUICKSORT
  def random(start: Int, end: Int): Int = {
    val random = new Random()
    random.nextInt(end - start + 1) + start
  }

  /**
   *
   * Euclidean distance, principal function
   *
   * @param firstPair First pair of points
   * @param secondPair Second pair of points
   * @return Euclidean distance of the pair of points
   */
  def euclideanDistance(firstPair: List[Int], secondPair: List[Int]): Double =
    val distanceWithoutSqrt = euclideanDistanceRecursive(firstPair, secondPair, 0.0)
                            // T(n-1) + O(1) = Theta(n lg n)

    if(distanceWithoutSqrt == -1.0){
      distanceWithoutSqrt
    } else {
      squareRoot(distanceWithoutSqrt) // T(n/2) + O(1) = O(n)
    }

  /**
   *
   * Euclidean distance recursive calculated
   *
   * @param firstPair First pair of points
   * @param secondPair Second pair of points
   * @param result Result of the euclidean distance (accumulated)
   * @return Value of the euclidean distance (without calculating the square root) of two pair of points
   */
  @tailrec
  def euclideanDistanceRecursive(firstPair: List[Int], secondPair: List[Int], result: Double): Double =
    (firstPair, secondPair) match
      case (Nil, Nil) => result
      case (Nil, _) => -1.0
      case (_, Nil) => -1.0
      case (head :: tail, head2 :: tail2) =>
        val difference = head2 - head

        euclideanDistanceRecursive(tail, tail2, result + pow(difference, 2))

  /**
   *
   * Predecessor of a number
   *
   * @param n Number
   * @return Predecessor of the number
   */
  def pred(n: Int): Int = if (n > 0) n - 1 else 0

  /**
   *
   * Absolute value of a number
   *
   * @param x Number
   * @return Absolute value of the number
   */
  def abs(x: Double) = if (x >= 0) x else -x

  /**
   *
   * Pow of a number
   *
   * @param base The base of the pow
   * @param exp The exponent of the pow
   * @return Result of the base multiplied pow times
    */
  def pow(base: Int, exp: Int): Int =
    if (exp == 0) 1 else base * pow(base, pred(exp))

  /**
   *
   * Upgrades the possible result of the square root
   *
   * @param number Number to find its square root
   * @param aprox Approximated value of the square root
   * @return An upgraded approximated value
   */
  def upgrade(number: Double, aprox: Double) =
    (aprox + number / aprox) / 2

  /**
   *
   * Finds if the given number is a good estimation
   *
   * @param number Number that will be analize in order to find if it is a good estimation or not
   * @return A boolean value in order to know if the value is a good estimation
   */
  def isGoodEstimation(number: Double, aprox: Double) =
    abs(aprox * aprox - number) < 0.001

  /**
   *
   * Auxiliar algorithm that squares a number recursively
   *
   * @param number Number that will be squared
   * @param aprox Aproximated value of the squared root
   * @return The squared of the given number
   */
  @tailrec
  def iterativeSquareRoot(number: Double, aprox: Double): Double =
    if (isGoodEstimation(number, aprox)) aprox
    else iterativeSquareRoot(number, upgrade(number, aprox))

  /**
   *
   * Algorithm that squares a number
   *
   * @param number Number that will be squared
   * @return The squared number the given number
   */
  def squareRoot(number: Double): Double = iterativeSquareRoot(number, 1)
  // END OF SQRT METHODS
   
}
