import java.util.Scanner;

public class HumanPlayer extends Player
{
  public HumanPlayer(String s, TicTacToeBoard b)
  {
    super(s, b);
  }

  public void takeTurn()
  {
    Scanner scanner = LinkedScanner.getScanner();
    // TODO --- show the user the board, and ask them for their move.
    System.out.println(" Please type your next move([row]x[columm]): ");
    String cin = scanner.nextLine();
    while ( !cin.substring(1,2).equals("x") )
    {
    	System.out.println("Please type again" );
    	cin = scanner.nextLine();
    }
    int r = Integer.parseInt(cin.substring(0,1));
    int c = Integer.parseInt(cin.substring(2));
    super.makeMove(r ,c );
    super.getBoard().draw();
  }
}