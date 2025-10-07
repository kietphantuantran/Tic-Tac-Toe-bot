import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    TicTacToeBoard board = new TicTacToeBoard();
    Player p1 = promptPlayer(1,board);
    Player p2 = promptPlayer(2,board);
    int turn = 1;
    while( board.isFinished() == false)
      if (turn == 1)
      {
      	System.out.println("p1");
        p1.takeTurn();
        turn = 2;
      }
      else
      {
      	System.out.println("p2");
        p2.takeTurn();
        turn = 1;
      }
    printResult(board);
  }

  public static Player promptPlayer(
      int num, TicTacToeBoard board)
  {
    Scanner scanner = LinkedScanner.getScanner();
    String mark;
    if (num == 1)
      mark = "X";
    else
      mark = "O";
    int choice = 0;
    // TODO : Modify the below code to allow for computer players to be chosen.
    while (choice != 1 && choice != 2 && choice != 3 )
    {
      System.out.println("Please choose Player " + num + " :");
      System.out.println("  (1) Human Player");
      System.out.println("  (2) Random Player");
      System.out.println("  (3) ArtificiallyIntelligentPlayer");
      String cin = scanner.nextLine();
      choice = Integer.parseInt(cin.substring(0));
    }
   
    if ( choice == 1)
     return new HumanPlayer(mark, board);
    else if ( choice == 2)
      return new RandomPlayer(mark, board);
    else
      return new ArtificiallyIntelligentPlayer(mark, board);
  }

  public static void printResult(TicTacToeBoard b)
  {
    b.draw();
    if (b.winner() == null)
      System.out.println("It's a tie!");
    else
      System.out.println(b.winner() + "'s win!");
  }
}