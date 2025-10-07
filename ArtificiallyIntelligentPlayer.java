public class ArtificiallyIntelligentPlayer extends Player
{
  private int turn;
  private int turnCorner;
  public ArtificiallyIntelligentPlayer(String s, TicTacToeBoard b)
  {
    super(s, b);
    turn = 0;
    turnCorner = 0;
  }

  public void takeTurn()
  {
    TicTacToeBoard g = super.getBoard();
    String[][] arr = g.getGrid();
    int order = 0;
    if ( this.getMark().equals("X"))
    	order = 1;
    else
    	order = 2;
    if ( order == 1)
    	this.goFirst(arr);
    else
    	this.goSecond(arr);
  }
     
  public Location nextMove(String toDo, String[][] arr)
  {
  	  String targetMark = this.getMark();
  	  if ( toDo.equals("block") )
  	  {
  	    if ( targetMark.equals("X") )
  	  	    targetMark = "O";
  	    else
  	  	    targetMark = "X";
  	  }
  	  for ( int r = 0; r < arr.length ; r++)
  	  {
  	  	  int rHorizontal = 0;
  	  	  int cHorizontal = 0;
  	  	  int empty = 0;
  	  	  int target = 0;
  	  	  for ( int c = 0; c < arr[0].length; c++)
  	  	  {
  	  	  	  if ( arr[r][c] == null )
  	  	  	  {
  	  	  	  	  empty++;
  	  	  	  	  rHorizontal = r;
  	  	  	  	  cHorizontal = c;
  	  	  	  }
  	  	  	  else if ( arr[r][c].equals(targetMark) )
  	  	  	  {
  	  	  	  	  target++;
  	  	  	  }
  	  	   }
  	  	   if ( empty == 1 && target == 2 )
  	  	   {
  	  	  	  return new Location( rHorizontal, cHorizontal);
  	  	   }
  	  }
  	  for ( int c = 0; c < arr[0].length ; c++)
  	  {
  	    int rVertical = 0;
  	    int cVertical = 0;
  	    int empty = 0;
  	  	int target = 0;
  	  	for ( int r = 0; r < arr.length; r++)
  	  	{
  	  	  if ( arr[r][c] == null )
  	  	  {
  	  	  	 empty++;
  	  	  	 rVertical = r;
  	  	  	 cVertical = c;
  	  	  }
  	  	  else if ( arr[r][c].equals(targetMark) )
  	  	  {
  	  	  	 target++;
  	  	  }
  	  	}
  	  	if ( empty == 1 && target == 2 )
  	  	{
  	  	   return new Location(rVertical, cVertical);
  	  	}
  	  }
  	  int emptyDiaR = 0;
  	  int targetDiaR = 0;
  	  int rDiaR = 0;
  	  int cDiaR = 0;
  	  for ( int i = 2; i >= 0 ; i--)
  	  {
  	  	 if ( arr[i][i] == null )
  	  	 {
  	  	    emptyDiaR++;
  	  	    rDiaR = i;
  	  	    cDiaR = i;
  	  	 }
  	  	 else if ( arr[i][i].equals(targetMark) )
  	  	 {
  	  	   targetDiaR++;
  	  	 }
  	  }
  	  if ( emptyDiaR == 1 && targetDiaR == 2 )
  	  {
  	  	 return new Location(rDiaR, cDiaR);
  	  }
  	  int emptyDiaL = 0;
  	  int targetDiaL = 0;
  	  int rDiaL = 0;
  	  int cDiaL = 0;
  	  int rID = 2;
  	  for ( int c = 0; c < arr.length ; c++)
  	  {
  	  	 if ( arr[rID][c] == null )
  	  	 {
  	  	    emptyDiaL++;
  	  	    rDiaL = rID;
  	  	    cDiaL = c;
  	  	 }
  	  	 else if ( arr[rID][c].equals(targetMark) )
  	  	 {
  	  	   targetDiaL++;
  	  	 }
  	  	 rID--;
  	  }
  	  if ( emptyDiaL == 1 && targetDiaL == 2 )
  	  {
  	    return new Location(rDiaL, cDiaL);
  	  }
  	  return null;
  	 }
  	 public Location checkCenter(String[][] arr)
  	 {
       for ( int r = 0; r < arr.length; r++)
       {
       	   if ( r % 2 == 0 && arr[r][1] == null)
       	     return new Location(r, 1);
       	   else
       	   {
       	     for ( int c = 0; c <= 1; c++)
       	       if ( arr[r][c*2] == null )
       	         return new Location(r, c*2);
       	   }
       }
       return null;
  	 }
  	 public void move(Location l)
  	 {
  	 	 int r = l.getRow();
         int c = l.getColum();
         super.makeMove(r, c);
         super.getBoard().draw();
         turn++;
  	 }
  	 public void moveRandom()
  	 {
  	 	 int r = (int)( Math.random()*3 );
         int c = (int)( Math.random()*3 );
         while ( super.makeMove(r ,c) == false )
         {
           r = (int)( Math.random()*3 );
           c = (int)( Math.random()*3 );
         }
         super.makeMove(r, c);
         super.getBoard().draw();
         turn++;
  	 }
  	 public void moveCorner()
  	 {
  	 	 int r = 2*(int)( Math.random()*2 );
         int c = 2*(int)( Math.random()*2 );
         while ( super.makeMove(r ,c) == false )
         {
           r = 2*(int)( Math.random()*2 );
           c = 2*(int)( Math.random()*2 );
         }
         turn++;
         turnCorner++;
         super.makeMove(r, c);
         super.getBoard().draw();
  	 }
  	 public void goFirst(String[][] arr)
  	 {
  	 	 if ( turn < 2 )
  	 	 {
  	 	   if ( this.nextMove("block", arr) == null && this.nextMove("win", arr) == null )
        	this.moveCorner();
           else if ( this.nextMove("win", arr) == null )
           {
           	 Location temp = this.nextMove("block", arr);
             this.move(temp);
           }
           else
           {
             Location temp = this.nextMove("win", arr);
             this.move(temp);
           }
         }  	   
        else  
        {
        	if ( turnCorner < 3 )
        	{
        	  if ( this.nextMove("block", arr) == null && this.nextMove("win", arr)== null )
        	    this.moveCorner();
              else if ( this.nextMove("win", arr) == null )
              {
              	  Location temp = this.nextMove("block", arr);
              	  this.move(temp);
              }
              else
              {
              	  Location temp = this.nextMove("win", arr);
              	  this.move(temp);
              }
        	}
        	else
        	{
        	  if ( this.nextMove("block", arr) == null && this.nextMove("win", arr) == null )
        	    this.moveRandom();
        	  else if ( this.nextMove("win", arr) == null )
        	  {
        	    Location temp = this.nextMove("block", arr);
        	    this.move(temp);
              }
              else 
              {
                Location temp = this.nextMove("win", arr);
            	this.move(temp);
              }
            }
        }
  	 }
  	 public void goSecond(String[][] arr)
  	 {
  	   if (super.makeMove(1, 1) == false && turn == 0 )
         this.goFirst(arr);
       else
       {
         if ( turn == 0)
         {
           super.makeMove(1, 1);
           super.getBoard().draw();
           turn++;
         }
         else if ( turn == 1)
         {
           if ( this.nextMove("block", arr) == null )
           {
             Location temp = this.checkCenter(arr);
             this.move(temp);
           }
           else 
           {
             Location temp = this.nextMove("block", arr);
             this.move(temp);
          }
        }
        else 
        {
          if ( this.nextMove("block", arr) == null && this.nextMove("win", arr) == null )
            this.moveRandom();
          else if ( this.nextMove("win", arr) == null )
          {
            Location temp = this.nextMove("block", arr);
        	this.move(temp);
          }
          else 
          {
            Location temp = this.nextMove("win", arr);
            this.move(temp);
          }
        }
      }
  	 }
}