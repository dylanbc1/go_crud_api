package DivideAndConquerTestPacket

import DivideAndConquerPacket.DivideAndConquer
import java.text.DecimalFormat
import java.lang.Math

class DivideAndConquerTest extends munit.FunSuite {

  val shortList: List[Int] = List(3,1,2)
  val normalList: List[Int] = List(10,7,3,6,2,9)
  val repeatedList: List[Int] = List(10,7,3,10,6,2,9)
  val allRepeatedList: List[Int] = List(1,1,1,1,1,1)
  val sortedList: List[Int] = List(1,2,3,10,22)
  val voidList: List[Int] = List()
  val invertedSortedList: List[Int] = List(9,8,7,6,1,0)

  test("Number Of Inversions:") {
    assert(DivideAndConquer.numberOfInversions(shortList)==2)
    assert(DivideAndConquer.numberOfInversions(normalList)==10)
    assert(DivideAndConquer.numberOfInversions(repeatedList)==13)
    assert(DivideAndConquer.numberOfInversions(allRepeatedList)==0)
    assert(DivideAndConquer.numberOfInversions(sortedList)==0)
    assert(DivideAndConquer.numberOfInversions(voidList)==0)
    assert(DivideAndConquer.numberOfInversions(invertedSortedList)==15)
  }

  val number3wayRepeatedList: List[Int] = List(10, 7, 3, 10, 8, 1, 10)

  test("Improved QuickSort:") {
    assert(DivideAndConquer.improvingQuickSort(normalList) == List(2,3,6,7,9,10))
    assert(DivideAndConquer.improvingQuickSort(repeatedList) == List(2,3,6,7,9,10,10))
    assert(DivideAndConquer.improvingQuickSort(allRepeatedList)== List(1,1,1,1,1,1))
    assert(DivideAndConquer.improvingQuickSort(number3wayRepeatedList) == List(1,3,7,8,10,10,10))
    assert(DivideAndConquer.improvingQuickSort(sortedList) == sortedList)
    assert(DivideAndConquer.improvingQuickSort(voidList) == voidList)
  }

  test("Randomized 3Way Partition:") {
    assert(DivideAndConquer.randomized3WayPartition(List(10, 3, 6, 9), 2, 7, List(), List(), List())._1 == List())
    assert(DivideAndConquer.randomized3WayPartition(List(1, 3, 22), 2, 10, List(), List(), List())._3 == List(22))
    assert(DivideAndConquer.randomized3WayPartition(List(9, 7, 6, 0), 1, 8, List(), List(), List())._2 == List(6, 7))
  }

  test("Mergesort:"){
    assert(DivideAndConquer.mergeSort(normalList)._1 == List(2, 3, 6, 7, 9, 10))
    assert(DivideAndConquer.mergeSort(repeatedList)._1 == List(2, 3, 6, 7, 9, 10, 10))
    assert(DivideAndConquer.mergeSort(allRepeatedList)._1 == List(1, 1, 1, 1, 1, 1))
    assert(DivideAndConquer.mergeSort(sortedList)._1 == sortedList)
    assert(DivideAndConquer.mergeSort(voidList)._1 == voidList)
  }

  test("Merge:"){
    assert(DivideAndConquer.merge(List(10,7,3), List(6,2,9), 0)._1 == List(6,2,9,10,7,3))
    assert(DivideAndConquer.merge(List(10,7,3), List(10,6,2,9), 0)._1 == List(10,7,3,10,6,2,9))
    assert(DivideAndConquer.merge(List(1,1,1), List(1,1,1),0)._1 == List(1, 1, 1, 1, 1, 1))
  }

  val oneSetPoint: List[List[Int]] = List(List(0,0))
  val threeSetPoints: List[List[Int]] = List(List(0,0), List(0,1), List(1,1))
  val normalSetPoints: List[List[Int]] = List(List(0, 0), List(4, 9), List(-1, -3), List(-2, 1))
  val repeatedSetPoints: List[List[Int]] = List(List(4, 9), List(4, 9), List(4, 9), List(4, 9), List(4, 9))
  val oneRepeatedSetPoints: List[List[Int]] = List(List(0, 0), List(4, 9), List(-1, -3), List(-2, 1), List(-2, 1))
  val voidPoints: List[List[Int]] = List(List(), List(), List(), List())
  val oneVoidPoint: List[List[Int]] = List(List(), List(0,0), List(4,9), List(-1, -3))

  test("Merge Sort Points:") {
    assert(DivideAndConquer.mergeSortPoints(oneSetPoint,0) == oneSetPoint)
    assert(DivideAndConquer.mergeSortPoints(normalSetPoints, 0) == List(List(-2, 1), List(-1, -3), List(0, 0), List(4, 9)))
    assert(DivideAndConquer.mergeSortPoints(repeatedSetPoints, 1) == repeatedSetPoints)
    assert(DivideAndConquer.mergeSortPoints(oneRepeatedSetPoints, 1) == List(List(-1, -3), List(0, 0), List(-2, 1), List(-2, 1), List(4, 9)))
  }

  test("Merge Points:"){
    assert(DivideAndConquer.mergePoints(List(List(0, 0), List(0,1)), List(List(1, 1)), 0) == threeSetPoints)
    assert(DivideAndConquer.mergePoints(List(List(4, 9), List(4,9), List(4,9)), List(List(4, 9), List(4,9)), 1) == repeatedSetPoints)
    assert(DivideAndConquer.mergePoints(List(List(0, 0), List(4, 9), List(-1, -3)), List(List(-2, 1), List(-2, 1)), 0) == List(List(-2, 1), List(-2, 1),List(0, 0), List(4, 9), List(-1, -3)))
  }

  // I cast the result of the square root to String to only take 4 decimal places,
  // because the result is too long
  //val df = new DecimalFormat("#.0000")
  //val df2 = new DecimalFormat("#0.0")

  test("Closest Points:") {
    val threeSetPointsR = DivideAndConquer.closestPoints(threeSetPoints)
    val normalSetPointsR = DivideAndConquer.closestPoints(normalSetPoints)
    val oneRepeatedSetPointsR = DivideAndConquer.closestPoints(oneRepeatedSetPoints)
    val oneVoidPointR = DivideAndConquer.closestPoints(oneVoidPoint)

    assert(DivideAndConquer.closestPoints(oneSetPoint) == -1.0)
    assert(threeSetPointsR == 1.0000)
    assert(normalSetPointsR == 2.2360) // sqrt of 5
    assert(DivideAndConquer.closestPoints(repeatedSetPoints) == -1.0) // error
    assert(oneRepeatedSetPointsR == 2.2360) // sqrt of 5
    assert(DivideAndConquer.closestPoints(voidPoints) == -1.0) // error
    assert(oneVoidPointR== 3.1622) // sqrt of 10
  }

  val setPoints1: List[List[Int]] = List(List(0, 0), List(-1, -3), List(-2, 1))
  val setVoidPoints: List[List[Int]] = List()
  val setPoints2: List[List[Int]] = List(List(0,0), List(0,1))

  // assert with reverse because the function adds each head to the result list. Doesn't affect the result
  // of closest points
  test("No Void Points:") {
    assert(DivideAndConquer.noVoidPoints(oneSetPoint, List()) == oneSetPoint)
    assert(DivideAndConquer.noVoidPoints(normalSetPoints, List()) == normalSetPoints.reverse)
    assert(DivideAndConquer.noVoidPoints(repeatedSetPoints, List()) == repeatedSetPoints.reverse)
    assert(DivideAndConquer.noVoidPoints(oneVoidPoint, List()) == List(List(-1, -3),List(4,9),List(0,0)))
    assert(DivideAndConquer.noVoidPoints(voidPoints, List()) == List())
  }

  test("Middle line:") {
    assert(DivideAndConquer.middleLine(repeatedSetPoints) == List(4.0,9.0))
    assert(DivideAndConquer.middleLine(normalSetPoints) == List(1.5,3.0))
    assert(DivideAndConquer.middleLine(oneRepeatedSetPoints) == List(-1.0,-3.0))
  }

  val positiveMiddleLine: List[Double] = List(1.0, 2.0)
  val negativeMiddleLine: List[Double] = List(-2.0,0.0)
  val d: Double = 2.9

  test("Not Exceed D:") {
    assert(DivideAndConquer.notExceedD(normalSetPoints, positiveMiddleLine, d, List()) == List(List(-1, -3), List(0, 0)))
    assert(DivideAndConquer.notExceedD(repeatedSetPoints, negativeMiddleLine, d, List()) == List())
    assert(DivideAndConquer.notExceedD(threeSetPoints, positiveMiddleLine, d, List()) == List(List(1, 1), List(0, 1), List(0, 0)))
  }

  val positiveNumber: Double = 2.12
  val positiveNumber2: Double = 5.75
  val negativeNumber: Double = -8.9

  test("Min:"){
    assert(DivideAndConquer.min(positiveNumber, negativeNumber) == -8.9)
    assert(DivideAndConquer.min(negativeNumber, negativeNumber) == -8.9)
    assert(DivideAndConquer.min(positiveNumber, positiveNumber2) == 2.12)
  }

  test("Parallel Fors Min Distance:"){
    val threeSetPointsR = DivideAndConquer.parallelForsMinDistance(threeSetPoints.head, threeSetPoints.tail, List())
    val normalSetPointsR = DivideAndConquer.parallelForsMinDistance(normalSetPoints.head, normalSetPoints.tail, List())
    val repeatedSetPointsR = DivideAndConquer.parallelForsMinDistance(repeatedSetPoints.head, repeatedSetPoints.tail, List())

    assert(threeSetPointsR == 1.0)
    assert(normalSetPointsR == 2.2360688956433634)
    assert(repeatedSetPointsR == 2.147483647E9)
  }

  val distances: List[Double] = List(1.0, 0.03125, 3.82, 0.99)
  val repeatedDistances: List[Double] = List(2.0, 1.1, 9.24, 1.1)
  val voidDistances: List[Double] = List()

  test("Min Distance Of Pair Distances:"){
    assert(DivideAndConquer.minDistanceOfPairDistances(distances, Int.MaxValue) == 0.99)
    assert(DivideAndConquer.minDistanceOfPairDistances(repeatedDistances, Int.MaxValue) == 1.1)
    assert(DivideAndConquer.minDistanceOfPairDistances(voidDistances, Int.MaxValue) == Int.MaxValue)
  }

  test("Find Min Distance:"){
    val setPoints1R = DivideAndConquer.findMinDistance(setPoints1, Int.MaxValue)
    val setPoints2R = DivideAndConquer.findMinDistance(setPoints2, Int.MaxValue)

    assert(setPoints1R == 2.2360688956433634)
    assert(DivideAndConquer.findMinDistance(setVoidPoints, Int.MaxValue) == Int.MaxValue)
    assert(setPoints2R == 1.0)
  }

  val firstPair: List[Int] = List(0,0)
  val secondPair: List[Int] = List(4,9)
  val thirdPair: List[Int] = List(-1,3)
  val voidPair: List[Int] = List()
  val samePair: List[Int] = List(9,1)

  test("Euclidean Distance:") {
    val firstSecondPairR = DivideAndConquer.euclideanDistance(firstPair, secondPair)
    val firstThirdPairR = DivideAndConquer.euclideanDistance(firstPair, thirdPair)
    val secondThirdPairR = DivideAndConquer.euclideanDistance(secondPair, thirdPair)
    val samePairR = DivideAndConquer.euclideanDistance(samePair, samePair)

    assert(firstSecondPairR == 9.84890052084378)
    assert(firstThirdPairR == 3.162277665175675)
    assert(secondThirdPairR == 7.810250764544175)
    assert(DivideAndConquer.euclideanDistance(voidPair, secondPair) == -1.0)
    assert(DivideAndConquer.euclideanDistance(thirdPair, voidPair) == -1.0)
    assert(Math.round(samePairR) == 0)
  }

  val number1ToSquareRoot: Int = 4
  val number2ToSquareRoot: Int = 2
  val number3ToSquareRoot: Int = 0

  test("Square Root:") {
    val number1SqrtR = DivideAndConquer.squareRoot(number1ToSquareRoot)
    val number2SqrtR = DivideAndConquer.squareRoot(number2ToSquareRoot)
    val number3SqrtR = DivideAndConquer.squareRoot(number3ToSquareRoot)

    assert(number1SqrtR == 2.0000000929222947)
    assert(number2SqrtR == 1.4142156862745097)
    assert(Math.round(number3SqrtR) == 0)
  }

  val number1: Int = 2
  val number2: Int = 0
  val number3: Int = -1
  val exp1: Int = 2
  val exp2: Int = 0
  val exp3: Int = 1

  test("Pred:") {
    assert(DivideAndConquer.pred(number1) == 1)
    assert(DivideAndConquer.pred(number2) == 0)
    assert(DivideAndConquer.pred(number3) == 0)
  }

  val number4: Int = -4

  test("Abs:"){
    assert(DivideAndConquer.abs(number1) == 2)
    assert(DivideAndConquer.abs(number2) == 0)
    assert(DivideAndConquer.abs(number4) == 4)
  }

  test("Pow:") {
    assert(DivideAndConquer.pow(number1, exp1) == 4)
    assert(DivideAndConquer.pow(number3, exp1) == 1)
    assert(DivideAndConquer.pow(number1, exp2) == 1)
    assert(DivideAndConquer.pow(number2, exp3) == 0)
  }
}
