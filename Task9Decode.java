//ohad eliyahou 203866447 30.11.2017
//translate the cnf clause to numbers.
public class Task9Decode {

	
	public static int cellValue(int[][][] map, int i, int j, boolean[] assignment) {

		int size=map.length;
		
		int value=0;
		
		for(int t=0;t<=size & value==0 ;t++)
		{
	if (assignment[(i*size*size)+(j*size)+1+t]==true)
//calculate the number and check if the asshgment in the number is true.	
				value=1+t;
		}
		
		if(value==0)
			
			throw new ExceptionInInitializerError("");
		
		return value  ;
	}
	
	

		public static int[][] mapToBoard(int[][][] map, int n, boolean[] assignment) {

		int [][] board=new int [n][n];
	
		for(int i=0;i<board.length;i++){
		
			for(int j=0;j<board[i].length;j++){
				
				board[i][j]=cellValue(map,i,j,assignment);
// build the board from the assignment with the cellValue function.			
			}
		
		}
		
		return board ;
	}
}
