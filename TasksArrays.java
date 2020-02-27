//ohad eliyahou 203866447 30.11.2017
//the function check if all the number diffrent,check if the numbers is between the max and the min,change row to colums, change block to row,
public class TasksArrays {

    public static boolean isAllDiff(int[] array) {
        boolean isAllDiffy = true;
        int temp;//temporary number in place i.
        int counter = 0;
        while (counter < array.length) {
            temp = array[counter];
            for (int i = 0; i < array.length; i++) {
                if (counter != i) {
                    if (temp == array[i])
                        isAllDiffy = false;
                }
            }
            counter++;
        }
        return isAllDiffy;
    }


    public static boolean isMatrixBetween(int[][] matrix, int n, int min, int max) {

        boolean isMatrixBetween = true;

        if (matrix == null || matrix.length != n)
            isMatrixBetween = false;
        else
        for (int i = 0; i < matrix.length & isMatrixBetween; i++) {
            if (matrix[i] == null || matrix[i].length != n)
                isMatrixBetween = false;

            for (int j = 0; j < n & isMatrixBetween; j++) {
                if (matrix[i][j] > max || matrix[i][j] < min)//check if the number is between the max and min that the function get.
                    isMatrixBetween = false;
            }
        }
        return isMatrixBetween;
    }


    public static int[][] columns(int[][] matrix) {
        int Size = matrix.length;
        int[][] tempMatrix = new int[Size][Size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                tempMatrix[j][i] = matrix[i][j];// change number in i row and j colum to the i colum and j row.
            }
        }
        return tempMatrix;
    }
        public static int[][] blocks(int[][]matrix, int sqrtN)
        {
          int Size = matrix.length;
        int counteri=0;//number of the row in the exeact moment of the check.
        int counterj=0;//number of the colum in the exeact moment of the check.
        int k=0;//the row in the new matrix.
        int z=0;// the colum in the new matrix.
        int blockCounter=0;// the block number in count from left to right and up to down.
        boolean counterians=true;//if its become false, the check is out of bounds.
        int[][] newMatrix = new int[Size][Size];
        for(int t=0; t<sqrtN*sqrtN &counterians;t++) {
          for (int i = counteri; i <counteri+sqrtN & counterians; i++)
	  {
            for (int j = counterj; j < counterj + sqrtN; j++)// assigment tow number each time.
	    {
              newMatrix[k][z]= matrix[i][j];
            z = z + 1;
        }
        }
        z=0;
        k=k+1;
        blockCounter=blockCounter+1;
        counterj=counterj+sqrtN;
        if(counterj>=matrix.length-1)
           counterj=0;
         if(blockCounter%sqrtN==0)// number of block in each row is the sqrtn, every time the modulo is zero the row advance.
	 {
            counteri = counteri + sqrtN;
           if (counteri >= matrix.length)
              counterians=false;
         }


        }
        return newMatrix;	}


}