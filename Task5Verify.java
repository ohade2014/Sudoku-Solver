//ohad eliyahou 203866447 30.11.2017
// the function check if the matrix solution is legal.
public class Task5Verify {
	
	
public static boolean isSolution(int sqrtN, int[][] hints, int[][] board) {
	
	   boolean isSolution=true;
        int [][]tempBoard=new int[sqrtN*sqrtN][sqrtN*sqrtN];

        if( !(TasksArrays.isMatrixBetween(board, sqrtN*sqrtN,1,sqrtN*sqrtN)))
            throw new RuntimeException("the board is not sqrtN");

        for(int i=0;i<board.length & isSolution;i++)
            if (!(TasksArrays.isAllDiff(board[i])))
                isSolution = false;

        TasksArrays.columns(board);// change the row to colums.
        for(int i=0;i<board.length & isSolution;i++)
            if (!(TasksArrays.isAllDiff(board[i])))
                isSolution = false;

    TasksArrays.columns(board);//change the row and colums back.
    TasksArrays.blocks(board, sqrtN);//change the matrix from block to row.
        for(int i=0;i<board.length & isSolution;i++)
            if (!(TasksArrays.isAllDiff(board[i])))
                isSolution = false;

    TasksArrays.blocks(board,sqrtN);//change the matrix back from blocks to row.
        for(int j=0;j<hints.length & isSolution;j++){
                if(board[hints[j][0]][hints[j][1]]!=hints[j][2])
                    isSolution=false;
            }
            return isSolution;	}

}
