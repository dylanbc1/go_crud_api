import scala.annotation.tailrec

object ListsAndRecursion extends App{

  // PUNTO 2
  // Combinations with no consecutive odds of a string of length n
  def noConsecutiveOdds(length: Int): List[List[Int]] = {
    if (length == 0) {
      List(List())
    } else { // llamo a la función que me calcula las opciones y combinaciones, pasando como parámetro la cadena construida aquí
      // con su respectiva longitud
      eachStringOptionsAndCombinations(0, noConsecutiveOdds(length - 1).length, noConsecutiveOdds(length - 1), List(List())).reverse.filter(_.nonEmpty)
    }
  }

  // ESTOS DOS SIGUIENTES MÉTODOS SON COMO DOS FOR, EL PRIMERO ITERA SOBRE EL BIG STRING, EL OTRO ITERA SOBRE
  // LOS STRINGS ESPECÍFICOS
  // | | | | | | | | | | | |
  // llamo al método options para sacar las opciones de cada string especifica, luego lo que hago es combinar a cada
  // string especifica dependiendo del length y de sus opciones
  @tailrec
  def eachStringOptionsAndCombinations(start: Int, end: Int, bigString: List[List[Int]],
                                       resultList: List[List[Int]]): List[List[Int]] = {
    if (start < end) {
      val optionsList = options(0, bigString(start).length - 1, bigString(start))

      if (start == 0) {
        val resultListUpdated = makeCombinations(bigString(start), optionsList)
        eachStringOptionsAndCombinations(1, end, bigString, resultListUpdated)
      } else {
        val resultListUpdated = resultList.:::(makeCombinations(bigString(start), optionsList))
        eachStringOptionsAndCombinations(start + 1, end, bigString, resultListUpdated)
      }
      //}
    } else resultList
  }

  // saco las opciones de cada string especifica
  def options(start: Int, end: Int, string: List[Int]): List[Int] = {
    if (string.isEmpty)
      List.range(0, 10)
    else if (string(start) % 2 == 0)
      List.range(0, 10)
    else
      List.range(0, 9, 2)
  }

  // Estas combinaciones LAS VOY A HACER HASTA QUE EL LENGTH DE LA CADENA ME LO IMPIDA
  def makeCombinations(string: List[Int], options: List[Int]) = {
    recursiveForCombinationsWithString(0, options.length - 1, string, options.reverse, List.fill(options.length)(Nil)).reverse
  }

  // me debe pasar la lista de opciones ya con el método .reverse, para poder ir sacando de 1 en 1
  @tailrec
  def recursiveForCombinationsWithString(start: Int, end: Int, string: List[Int], options: List[Int], resultCombinations: List[List[Int]]): List[List[Int]] = {
    if (start <= end) {
      val resultUpdated = resultCombinations.:::(List(resultCombinations(start).:::(((string).::(options.head)).reverse)))

      // agrego a la lista grande, la lista string (cadena previa) más el digito de las opciones, la cabeza, y le hago reverse
      // porque se agrega al principio.
      recursiveForCombinationsWithString(start + 1, end, string, options.tail, resultUpdated) // llamo otra vez a la función para ir agregando
      // nuevas combinaciones, actualizando la lista grande
      //}
    }
    else resultCombinations
  }

  val stringWithNoConsecutiveOdds = noConsecutiveOdds(3)
  println("\nPUNTO 2 Las combinaciones de la cadena de dígitos (longitud 3, en este ejemplo) " +
    "que NO tienen impares consecutivos son: "+stringWithNoConsecutiveOdds)

  // | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |

  // PUNTO 3
  // recursive function that calculates the length of a list
  def lengthOfList(list:List[List[Int]]) : Int =
    if(list.isEmpty)
      0
    else 1+lengthOfList(list.slice(0,list.length-1))

  println("\nPUNTO 3 La longitud de la lista que contiene las listas (combinaciones de la cadena de longitud 3, en este ejemplo," +
    " que no tienen impares consecutivos) es: "+lengthOfList(stringWithNoConsecutiveOdds))

  // PUNTO 4
  // MY recurrence ratio in recursive function that calculates the amount of combinations of a string of length n
  // without consecutive odds, where n >= 3
  def recurrenceAmountOfStringsWithoutConsecutiveOdds(length: Int) : Int = {
    if(length==1)
      10
    else if(length==2)
      75
    else 5*(recurrenceAmountOfStringsWithoutConsecutiveOdds(length-1)) + 5*(recurrenceAmountOfStringsWithoutConsecutiveOdds(length-2))
  }

  val recurrenceRatioStringsWithoutConsecutiveOdds = recurrenceAmountOfStringsWithoutConsecutiveOdds(3)
  println("\nPUNTO 4 Según mi relación de recurrencia, la cantidad de combinaciones que NO tienen impares consecutivos (en este ejemplo" +
    ", para cadena de longitud 3) son: "
    +recurrenceRatioStringsWithoutConsecutiveOdds)

  // PUNTO 5
  // Comparison between the result of the length of the List that contains the combinations with string without consecutive
  // odds (amount of combinations) AND the result of my recurrence ratio (amount of combinations) with the SAME length
  // of the string
  def comparison(amountComb1: Int, amountComb2:Int): Boolean ={
    if(amountComb1!=amountComb2) false else true
  }

  val areEqual = comparison(lengthOfList(stringWithNoConsecutiveOdds), recurrenceRatioStringsWithoutConsecutiveOdds)
  println("\nPUNTO 5 "+areEqual)
  println("Como se puede ver, los dos resultados NO son iguales. " +
    "\nEl resultado calculando la longitud de la lista es: "+lengthOfList(stringWithNoConsecutiveOdds)+
    "\nEl resultado con mi relación de recurrencia es: "+recurrenceRatioStringsWithoutConsecutiveOdds)

  // EXTRA !!!
  // The CORRECT recurrence ratio in recursive function that calculates the amount of combinations of a string of length n
  // without consecutive odds, where n >= 3
  def correctRecurrenceAmountOfStringsWithoutConsecutiveOdds(length: Int):Int =
    if(length==1)
      10
    else if(length==2)
      75
    else
      5*correctRecurrenceAmountOfStringsWithoutConsecutiveOdds(length-1)+ 25*correctRecurrenceAmountOfStringsWithoutConsecutiveOdds(length-2)

  val correctRecurrenceRatioStringsWithoutConsecutiveOdds = correctRecurrenceAmountOfStringsWithoutConsecutiveOdds(3)
  println("\nEXTRA Utilizando la relación de recurrencia correcta, la cantidad de combinaciones que NO tienen impares consecutivos " +
    "(en este ejemplo, cadena de longitud 3) son: "
    + correctRecurrenceRatioStringsWithoutConsecutiveOdds)
}
