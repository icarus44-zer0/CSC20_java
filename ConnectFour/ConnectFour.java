import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class ConnectFour{
   private char[][] charBoard;
   private int row;
   private int col;

   public static final int DEFAULT_ROW_SIZE = 6;
   public static final int DEFAULT_COL_SIZE = 7;

   public static final String ROW_DIVIDER = "|"; 
   public static final String COL_DIVIDER = "-+"; 
   public static final String COL_TERMINATOR = "-";
   public static final String NEW_LINE = "\n";

   public static final char _X = 'X';
   public static final char _O = 'O';


    // constructs a new board of defualt size row = 6, col = 7
   public ConnectFour(){
      this.row = 6;
      this.col = 7;
      this.charBoard = new char[DEFAULT_ROW_SIZE][DEFAULT_COL_SIZE];
      
      for(int i = 0 ; i < 6; i ++){
         for(int j = 0 ; j < 7; j ++)
            this.charBoard[i][j] = ' ';
      }
   }

   public ConnectFour(int a, int b){
      if ( a < 4 || b < 3)
         throw new IllegalArgumentException();                
      this.row = a;
      this.col = b;
      this.charBoard = new char[a][b];
      
       for(int i = 0 ; i < a; i ++){
         for(int j = 0 ; j < b; j ++)
            this.charBoard[i][j] = ' ';
      }
   }

   public char get(int r, int c){
      return charBoard[r][c];
   }
    
   public void dropCol(int c, char ch){
      if( c > getRowCount())
         throw new IndexOutOfBoundsException();
        
      if (ch == _X){
         for(int i = getRowCount() - 1 ; i >= 0; i--){
            if (get(i,c) != 'X' && get(i,c) != 'O'){
               charBoard[i][c] = ch; 
               break;
            }  
         }
      }
   
      if (ch == _O){
         for(int i = getRowCount() - 1 ; i >= 0; i--){
            if (get(i,c) != 'X' && get(i,c) != 'O'){
               charBoard[i][c] = ch; 
               break;
            }  
         }
      }
   }

   public int getRowCount(){
      return row;
   }

   public int getColCount(){
      return col;
   }

public char winner(){
   char win = ' ';
   if (win != xWin())
      win = xWin();
   else if (win != oWin())
      win = oWin();
   return win;
}

   public char xWin(){
       char[][] temp = charBoard;
       
      for (int i = temp.length - 1; i >= 0; i--) {
         for (int j = temp[0].length -1  ; j >= 0; j--) {
            if(
               (i-3) >= 0
            &&  temp[i-0][j] == _X 
            &&  temp[i-1][j] == _X
            &&  temp[i-2][j] == _X
            &&  temp[i-3][j] == _X
              )
                return _X;
            
            else if(
                (j-3) >= 0
            &&  temp[i][j-0] == _X 
            &&  temp[i][j-1] == _X
            &&  temp[i][j-2] == _X
            &&  temp[i][j-3] == _X
              )
                return _X;

            else if(
               (i-3) >= 0
            && (j-3) >= 0   
            &&  temp[i-0][j-0] == _X 
            &&  temp[i-1][j-1] == _X
            &&  temp[i-2][j-2] == _X
            &&  temp[i-3][j-3] == _X
            )
               return _X;
            
            else if(
               (i-3) >= 0
            && (j+3) < temp[0].length   
            &&  temp[i-0][j-0] == _X 
            &&  temp[i-1][j+1] == _X
            &&  temp[i-2][j+2] == _X
            &&  temp[i-3][j+3] == _X
            )
               return _X;
         }
      }
      char noWinner = ' ';
      return noWinner;
   }

   public char oWin(){
      char[][] temp = charBoard;
       
      for (int i = temp.length - 1; i >= 0; i--) {
         for (int j = temp[0].length -1  ; j >= 0; j--) {
            if(
               (i-3) >= 0
            &&  temp[i-0][j] == _O 
            &&  temp[i-1][j] == _O 
            &&  temp[i-2][j] == _O 
            &&  temp[i-3][j] == _O 
              )
                return _O ;
            
            else if(
                (j-3) >= 0
            &&  temp[i][j-0] == _O 
            &&  temp[i][j-1] == _O 
            &&  temp[i][j-2] == _O 
            &&  temp[i][j-3] == _O 
              )
                return _O;

            else if(
               (i-3) >= 0
            && (j-3) >= 0   
            &&  temp[i-0][j-0] == _O  
            &&  temp[i-1][j-1] == _O 
            &&  temp[i-2][j-2] == _O 
            &&  temp[i-3][j-3] == _O 
            )
               return _O ;
            
            else if(
               (i-3) >= 0
            && (j+3) < temp[0].length   
            &&  temp[i-0][j-0] == _O  
            &&  temp[i-1][j+1] == _O 
            &&  temp[i-2][j+2] == _O 
            &&  temp[i-3][j+3] == _O 
            )
               return _O ;
         }
      }
      char noWinner = ' ';
      return noWinner;
   }
   
   //A WAY TO DETERMINE THINGS THAT ARENT FACTS
   public char winnerOld(){
      char win = ' ';
      if (win != vertWin()){
         win = vertWin();
         System.out.println("vert");
      }
      else if (win != horizWin()){
         System.out.println("Horz");
         win = horizWin();
      }
       else if (win != diagWin()){
         System.out.println("diag");
         win = diagWin();
      }
      return win;
   }
   
    // checks verticle wins for both _X and _O
   public char vertWin(){
      int x = 0;
      int o = 0;
    
      for (int i = 1; i < getRowCount(); i++) {
         for (int j = 0; j < getColCount(); j++) {
            char a = get(i, j);
            char b = get((i - 1), j);
            if (a == _X && b == _X) {
               x++;
                if (x >= 3) {
                  return _X;
               }
            } 
            else if (a == _O && b == _O)
               o++;
               if (o >= 3) {
                  return _O;
               }
            else {
               x = 0;
               o = 0;
            }
         }
      }
   
      char noWinner = ' ';
      return noWinner;
   }

    // checks horizontal wins for both _X and _O
   public char horizWin(){
      int x = 0;
      int o = 0;
      
      for (int i = 0; i < getRowCount(); i++) {
         for (int j = 1; j < getColCount(); j++) {
            char a = get(i, j);
            char b = get((i), j - 1);
            if (a == _X && b == _X) {
               x++;
               if (x >= 3) 
                  return _X;
            } 
            else if (a == _O && b == _O){
               o++;
               if (o >= 3) 
                  return _O;
            }
            else {
               x = 0;
               o = 0;
            }
         }
      }
   
      char noWinner = ' ';
      return noWinner;
   }

    // checks diagonal wins for both _X and _O
   public char diagWin(){
      int x = 0;
      int o = 0;
   
      for (int i = 1; i < getRowCount()-1; i++){
         for (int j = 1; j < getColCount()-1; j++){
                
            char a = get(i, j);
            char b = get((i+1),(j+1));
            if(a == _X && b == _X){
               x++;
               if (x >= 3) 
                  return _X;
            }
            else if(a == _O && b == _O){
               o++;
               if (o >= 3) 
                  return _O;
            }
         }
      }
      char noWinner = ' ';
      return noWinner;
   }

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

    public static void main(String[] args) {
       int p1 = 0;
       int p2 = 0;

       Scanner sc = new Scanner(System.in);
       ConnectFour game = new ConnectFour(10,10); 
       System.out.println(game.toString());
   
      while(true){
         //player 1s turn
         System.out.println("PLAYER 1: Choose 1-" + game.getColCount());
         p1 = sc.nextInt() - 1;
         game.dropCol(p1, _X);
            if (game.winner() != ' '){
            
               System.out.println(game.toString());
               System.out.println(game.winner()+"'s win!");
               break;
            }
         System.out.println(game.toString());

         //player 2s turn
         System.out.println("PLAYER 2: Choose 1-" + game.getColCount());
         p2 = sc.nextInt() - 1;
         game.dropCol(p2, _O);
      
            if (game.winner() != ' '){
           
               System.out.println(game.toString());
               System.out.println(game.winner()+"'s win!");
               break;
            }
         System.out.println(game.toString());
      }     
      sc.close();
   }
}