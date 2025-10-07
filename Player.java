public class Player
{
  private String mark;
  private TicTacToeBoard board;

  public Player(String m, TicTacToeBoard b)
  {
    mark = m;
    board = b;
  }

  public void takeTurn()
  {
    System.out.println("This should be overridden by subclasses");
  }

  public boolean makeMove(int r, int c)
  {
    boolean succeeded = board.mark(r,c,mark);
    return succeeded;
  }

  public TicTacToeBoard getBoard()
  {
    return board;
  }
  
  public String getMark()
  {
  	  return mark;
  }
}