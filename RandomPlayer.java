public class RandomPlayer extends Player
{
  public RandomPlayer(String s, TicTacToeBoard b)
  {
    super(s, b);
  }

  public void takeTurn()
  {
    String[][] g = super.getBoard().getGrid();
    int r = (int) (Math.random()*(g.length));
    int c = (int) (Math.random()*(g[0].length));
    while ( super.makeMove(r, c) == false )
    {
      r = (int) (Math.random()*(g.length));
      c = (int) (Math.random()*(g[0].length));
    }
    super.makeMove(r ,c );
    super.getBoard().draw();
  }
}