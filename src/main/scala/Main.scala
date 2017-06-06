/**
  * Created by Fraser on 06/06/2017.
  */
object Main {
  //check if over 21
  def checkHandIsOk(hand : Int) : Boolean = hand match{
    case x if hand > 21 => false //hand is over 21, hand is bust
    case x if hand <= 21 && hand >= 2 => true //hand is in a possible range, pass
    case _ => printf("Error, %d is not a possible range\n", hand);false //hand is not a possible score, count as bust
  }

  //if neither is over 21 get the largest value
  def returnLargestValue(hand1 : Int, hand2 : Int) : Int = {
    //calculate the difference
    val difference : Int = hand1 - hand2;

    difference match{
      case x if difference < 0 => hand2 //hand 2 was larger
      case x if difference > 0 => hand1 //hand 1 was larger
      case 0 => 0//both hands had the same value
      case _ => printf("something went wrong");0
    }
  }
  //check for winner
  def checkForWinningHand(hand1 : Int, hand2 : Int) : Int = {
    //set this so it works
    val hand1Pass : Boolean = checkHandIsOk(hand1)
    val hand2pass : Boolean = checkHandIsOk(hand2)

    val x : Int = 0
    x match
    {
      case x if hand1Pass && hand2pass => returnLargestValue(hand1, hand2) //if both hands are fine check
      case x if !hand1Pass && hand2pass => hand2
      case x if hand1Pass && !hand2pass => hand1
      case x if !hand1Pass && !hand2pass => 0
      case _ => println("Something went wrong"); 0
    }
  }


  //main function
  def main(args : Array[String]) : Unit = {
    println("Hand 1: 18, Hand 2 : 21, Winning Hand: " + checkForWinningHand(18, 21))//test for hand 2 winning
    println("Hand 1: 20, Hand 2 : 18, Winning Hand: " + checkForWinningHand(20, 18))//test for hand 1 winning
    println("Hand 1: 22, Hand 2 : 22, Winning Hand: " + checkForWinningHand(22, 22))//test for both hands over
    println("Hand 1: 21, Hand 2 : 21, Winning Hand: " + checkForWinningHand(21, 21))//test for both hands the same
    println("Hand 1: 1, Hand 2 : 21, Winning Hand: " + checkForWinningHand(1, 21)) //test for non possible value
  }
}
