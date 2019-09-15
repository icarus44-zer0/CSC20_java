public class MultiArray{

   public static void main(String[] args) {
   
      int[][] a = {{1, 2, 3,4,},{10, 11, 12, 13}};       
      int[][] b = {{1, 2, 3,4},{10, 11, 12,13}};

      int[][] c = {{10, 5, 4, 0}, {8, -1, 9, 2}, {0, 1, 7, -5}};       
      int[][] d = {{0, 16, 3, 29}, {1, 4, 7, 10}, {0, 0, -7, 6}};

      int[][] e = {{42},{}};       
      int[][] f = {{42},{}};

      int[][] g = {{},{}};       
      int[][] h = {{},{}};

      display(matrixSum(a,b));
      display(matrixSum(c,d));
      display(matrixSum(e,f));
      display(matrixSum(g,h));

   }

  public static int[][] matrixSum(int[][] a, int[][] b) {
    
         int i = 0;
         int j = 0;
         int row = 0;
         int col = 0;
      
      try{
         row = a.length;
         col = a[0].length;
      }
      catch(ArrayIndexOutOfBoundsException e) {
            int [][] f = new int[0][0];
            System.out.println(e);
            return f;
      }
      
         int [][] c = new int[row][col];               
         for (i=0; i < a.length; i++){
            for (j=0; j < a[i].length; j++){
                  c[i][j] = a[i][j] + b[i][j];
            }
         }
      return c;
      }

public static void display(int[][] a) {
   System.out.println();
   for (int i=0; i < a.length; i++){
      for (int j=0; j < a[0].length; j++)
           System.out.printf("%s", "["+a[i][j] +"] ");
      System.out.println();
      }
}

}
