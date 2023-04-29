import java.util.Scanner
import scala.annotation.tailrec

object fastModularExponentiation {
  val scanner = new java.util.Scanner(System.in)

  def main(args: Array[String]): Unit = {
    println("Type the number:")
    val number = scanner.nextLine().toInt

    println("\nType the exponent:")
    val exp = scanner.nextLine().toInt

    println("\nType the mod:")
    val mod = scanner.nextLine().toInt

    val result = fastModularExponentiation(number, exp, mod)
    println(result)
  }

  def fastModularExponentiation(number: Int, exp: Int, mod: Int): Int = {
    fastModularExponentiationR(number, exp, mod, decimalToBinary(exp).reverse, 1, 1, pow(number, 2))
  }

  @tailrec
  def fastModularExponentiationR(number:Int, exp:Int, mod:Int, binaryNumber: List[Int], power:Int, x:Int, accNumber:Int): Int ={
    binaryNumber match {
      case Nil =>
        if(exp%2 != 0){
          (x*number) % mod
        } else {
          x
        }
      case head::tail =>
        if(head==1){
          fastModularExponentiationR(number, exp, mod, tail, accNumber%mod, (x*power)%mod, pow(accNumber%mod, 2))
        } else {
          fastModularExponentiationR(number, exp, mod, tail, accNumber%mod, x, pow(accNumber%mod, 2))
        }
    }
  }

  def decimalToBinary(decimal: Int): List[Int] =
      decimal match {
        case 0 => List(0)
        case 1 => List(1)
        case _ =>
          val quotient = decimal / 2
          val reminder = decimal % 2
          decimalToBinary(quotient) ::: List(reminder)
      }

  def pred(n: Int): Int =
    if (n > 0) n - 1 else 0

  def pow(base: Int, exp: Int): Int =
    if (exp == 0) 1 else base * pow(base, pred(exp))
}
