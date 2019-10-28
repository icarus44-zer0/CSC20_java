/**
 * A Connect Four Object
 * 
 * A <code>ConnectFour</code> object contains the paraments 
 * and functionality of a connect four gameboard and the players
 * who will use the gameboard
 * 
 * @author  Joshua Poe
 * @version 1.3.2 10/16/19
 */

public class ConnectFour{
   private char[][] board;
   private int row;
   private int col;

/**
 * Default size of rows 
*/
   public static final int DEFAULT_ROW_SIZE = 6;

/**
 * Default size of columns 
*/
   public static final int DEFAULT_COL_SIZE = 7;

/**
 * Default row divider charecter 
*/
   public static final String ROW_DIVIDER = "|"; 

/**
 * Default column divider charecter 
*/
   public static final String COL_DIVIDER = "-+";

/**
 * Default column terminator charecter 
*/
   public static final String COL_TERMINATOR = "-";

/**
 * Default new line charecter 
*/
   public static final String NEW_LINE = "\n";


/**
 * Defualt ConnectFour Constructor 
 * 
 * Constructs a new board of defualt size row = 6, col = 7
 * intitalizes P1 and P2 to defualt values 
*/
   public ConnectFour(){
      row = 6;
      col = 7;
      board = new char[DEFAULT_ROW_SIZE][DEFAULT_COL_SIZE];
   
   
      for(int i = 0 ; i < 6; i ++){
         for(int j = 0 ; j < 7; j ++)
            board[i][j] = ' ';
      }
   }

/**
 * ConnectFour Constructor 
 *
 * Constructs a new board of a specified size
 * intitalizes P1 and P2 to defualt values 
 * 
 * @param a the number of rows the gameboard will have
 * @param b the number of columns the gameboard will have
 * @return a new gamboard of the delcared size 
*/
   public ConnectFour(int a, int b){
                  
      checkDimensions(a,b);
   
      row = a;
      col = b;
      board = new char[a][b];
   
      for(int i = 0 ; i < a; i ++){
         for(int j = 0 ; j < b; j ++)
            board[i][j] = ' ';
      }
   }


/**
 * Gets the charecter at a specified location on the gameboard 
 * 
 * @param r the row of the specified element
 * @param c the column the specified element
 * @return the charecter at the specified location 
*/
   public char get(int r, int c){
     
     // checkRow(r);
      checkCol(c);
   
      return board[r][c];
   }

/**
 * Adds a new charecter to the gameboard to represent a players move
 * in the next available location for the user specified column
 * 
 * @param c the column where the next move will occur 
 * @param ch the current players Symbol to be stored on the gameboard
 * @exception IndexOutOfBoundsException if the user enters a column not on the board
*/
   public void dropCol(int c, char ch){
      checkCol(c);
      checkColFull(c);
   
      for(int i = getRowCount() - 1 ; i >= 0; i--){
         if (get(i,c) == ' ' ){
            board[i][c] = ch;
            break;
         }  
      }
   }

/**
 * Gets the number of rows that are in the gamboard array
 * 
 * @return the intiger value stored in row
*/
   public int getRowCount(){
      return row;
   }

/**
 * Gets the number of columns that are in the gamboard array
 * 
 * @return the intiger value stored in col
*/
   public int getColCount(){
      return col;
   }

/**
 * Determins which player has won the game
 * 
 * @return the charecter value of the winning player 
 * @return empty if no winner declared 
*/
   public char winner(){
      char win = ' ';
      if (win != verticalWin()){
         win = verticalWin();
         return win;
      }
      else if(win != horizontalWin()){
         win = horizontalWin();
         return win;
      }
      else if(win != diag1Win()){
         win = diag1Win();
         return win;
      }
      else if(win != diag2Win()){
         win = diag2Win();
         return win;
      }
      else
         return win; 
   }
   
/**
 * 
 * 
*/
   public char verticalWin(){
      char fail = ' ';
   
         for (int j = board[0].length -1  ; j >= 0; j--) {
            for (int i = board.length - 1; i >= 0; i--) {
               if((i-3) >= 0 && board[i][j] != ' '){ 
                  if(board[i][j] == board[i-1][j] && board[i][j] != ' '){
                     if(board[i-1][j] == board[i-2][j] && board[i][j] != ' '){
                        if(board[i-2][j] == board[i-3][j] && board[i][j] != ' '){
                              return board[i][j];
                        }
                     }
                  }
               }
            }
         } 
      return fail;      
   }
   
/**
 * 
 * 
*/
   public char horizontalWin(){
      char fail = ' '; 
      
      for (int i = board.length - 1; i >= 0; i--) {
         for (int j = board[0].length -1  ; j >= 0; j--) {           
            if((j-3) >= 0 && board[i][j] != ' '){
               if(board[i][j] == board[i][j-1] && board[i][j] != ' '){
                  if(board[i][j-1] == board[i][j-2] && board[i][j] != ' '){
                     if(board[i][j-2] == board[i][j-3] && board[i][j] != ' '){
                           return board[i][j];
                     }
                  }
               }
            }
         }
      }
      return fail;      
   } 
   
/**
 * 
 * 
*/
   public char diag1Win(){
      char fail = ' ';
   
      for (int i = board.length - 1; i >= 0; i--) {
         for (int j = board[0].length -1  ; j >= 0; j--) {           
            if((i-3) >= 0 && (j-3) >= 0 && board[i][j] != ' '){
               if(board[i][j] == board[i-1][j-1] && board[i][j] != ' '){
                  if(board[i-1][j-1] == board[i-2][j-2] && board[i][j] != ' '){
                     if(board[i-2][j-2] == board[i-3][j-3] && board[i][j] != ' '){
                           return board[i][j];
                     }
                  }
               }
            }
         }
      }
      return fail;      
   }
   
/**
 * 
 * 
*/  
   public char diag2Win(){
      char fail = ' ';
      
      for (int i = board.length - 1; i >= 0; i--) {
         for (int j = board[0].length -1  ; j >= 0; j--) {           
            if((i-3) >= 0 && (j+3) < board[0].length && board[i][j] != ' '){
               if(board[i][j] == board[i-1][j+1] && board[i][j] != ' '){
                  if(board[i-1][j+1] == board[i-2][j+2] && board[i][j] != ' '){
                     if(board[i-2][j+2] == board[i-3][j+3] && board[i][j] != ' '){
                        return board[i][j];
                     }
                  }
               }
            }
         }
      }
      return fail;      
   }  

/**
 * Prints the entire array of chars to the screen 
 * along with the specified game board parameters 
 * 
 * @return the string equivlent of the board and the char array together
*/
   public String toString() {
      String racs = "";
   
      for (int i=0; i < getRowCount(); i++){
         for (int j=0; j < getColCount(); j++){
            racs = racs.concat(String.valueOf(get(i, j)));
            if (j< getColCount()-1)
               racs = racs.concat(ROW_DIVIDER);
         }
      
         racs = racs.concat(NEW_LINE);
         for (int k=0; k < getColCount()-1; k++){
            racs= racs.concat(COL_DIVIDER);
         }
        
         racs = racs.concat(COL_TERMINATOR);
         racs = racs.concat(NEW_LINE);
      }
      return racs;
   }
   
/**
 *
 *
*/
   public void checkDimensions(int r, int c){
      if (r < 4 || c < 3)
         throw new IllegalArgumentException(); 
   }
   
/**
 *
 *
*/
   public void checkRow(int r){ 
   
      if( r > getRowCount() - 1){
         throw new IndexOutOfBoundsException("here");
      }
      
      else if( r < 0){
         throw new IndexOutOfBoundsException("here 2");
      }
    
   }

/**
 *
 *
*/
   public void checkCol(int c)
   {
      if( c > getColCount() - 1){
         throw new IndexOutOfBoundsException();
      }
       
      else if( c < 0){
         throw new IndexOutOfBoundsException();
      }
   }

/**
 *
 *
*/
   public void checkColFull(int c){
      if(board[0][c] != ' ')
         throw new IndexOutOfBoundsException();
   }

}