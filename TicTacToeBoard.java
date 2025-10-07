public class TicTacToeBoard
{
  private String[][] grid;
  
  /*
  public static void main(String[] args)
  {
    TicTacToeBoard b = new TicTacToeBoard();
    b.draw();
    b.mark(1,1,"X");
    b.mark(2,0,"O");
    b.mark(0,2,"X");
    b.mark(1,0,"O");
    b.draw();
  }
  */

  public TicTacToeBoard()
  {
    grid = new String[3][3];
  }
  
  public String[][] getGrid()
  {
  	  return grid;
  }

  private String getRow(int r)
  {
    String result = "";
    for (int c = 0; c < 3; c++)
    {
      result += "│"; // fence-post problem.
      result += " ";
      if (grid[r][c] != null)
        result += grid[r][c];
      else
        result += " ";
      result += " ";
    }
    return result.substring(1); // fence-post problem.
  }

  public void draw()
  {
    System.out.println();
    System.out.println(getRow(0));
    System.out.println("───┼───┼───");
    System.out.println(getRow(1));
    System.out.println("───┼───┼───");
    System.out.println(getRow(2));
    System.out.println();
  }

  public boolean isOccupied(int r, int c)
  {
    // Returns whether the specified position is already filled
    return grid[r][c] != null;
  }

  public boolean mark(int r, int c, String s)
  {
    // Makes a mark at the specified position.
    // Returns true if it was successful (i.e. it was not already occupied)
    if (isOccupied(r,c))
      return false;
    grid[r][c] = s;
    return true;
  }

  public boolean isFinished()
  {
    // Returns true if the board is totally full OR if there are three marks in
    // a row.
    //diagonal top
    int countNull = 0;
    for ( int r = 0; r < grid.length ; r++)
    	for ( int c = 0; c < grid[r].length ; c++)
    	{
    		if ( grid[r][c] == null )
    			 countNull++;
    	}
    if ( countNull == 0 )
    {
    	return true;
    }
    //dt
    if ( grid[0][0] != null && grid[1][1] != null && grid[2][2] != null 
    	&& grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2]) )
    	return true;
    //diagonal bottom
    if ( grid[2][0] != null && grid[1][1] != null && grid[0][2] != null 
    	&& grid[2][0].equals(grid[1][1]) && grid[2][0].equals(grid[0][2]) )
    	return true;
    // horizontal
    for ( int r = 0; r < grid.length ; r++)
    	{
    		if ( grid[r][0] != null && grid[r][1] != null && grid[r][2] != null 
    			&& grid[r][0].equals(grid[r][1]) && grid[r][0].equals(grid[r][2]) )
    			return true;
    	}
    //vertical
    	for ( int c = 0; c < grid[0].length ; c++)
    	{
    		if ( grid[0][c] != null && grid[1][c] != null && grid[2][c] != null 
    			&& grid[0][c].equals(grid[1][c]) && grid[0][c].equals(grid[2][c]) )
    			return true;
    	}
    return false;
  }

  public String winner()
  {
    // Returns "X" or "O" if someone wins.
    // Otherwise, returns null.
    // TODO
     //diagonal top
     if ( grid[0][0] != null && grid[1][1] != null && grid[2][2] != null 
    	&& grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2]) )
    	return grid[0][0];
    //diagonal bottom
    if ( grid[2][0] != null && grid[1][1] != null && grid[0][2] != null 
    	&& grid[2][0].equals(grid[1][1]) && grid[2][0].equals(grid[0][2]) )
    	return grid[2][0];
    // horizontal
    for ( int r = 0; r < grid.length ; r++)
    	{
    		if ( grid[r][0] != null && grid[r][1] != null && grid[r][2] != null 
    			&& grid[r][0].equals(grid[r][1]) && grid[r][0].equals(grid[r][2]) )
    			return grid[r][0];
    	}
    //vertical 
    	for ( int c = 0; c < grid[0].length ; c++)
    	{
    		if ( grid[0][c] != null && grid[1][c] != null && grid[2][c] != null 
    			&& grid[0][c].equals(grid[1][c]) && grid[0][c].equals(grid[2][c]) )
    			return grid[0][c];
    	}
    return null;
  }
}