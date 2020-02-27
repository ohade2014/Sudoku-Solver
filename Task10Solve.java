//ohad eliyahou 203866447 30.11.2017
//the function solve the matrix.



public class Task10Solve {
	

	public static int[][] solve(int sqrtN, int[][] hints) {
	
	int[][] board=new int[sqrtN*sqrtN][sqrtN*sqrtN];
	
	int[][][]varsMap= Task7Map.varsMap(sqrtN*sqrtN);
	
	SATSolver.init(sqrtN*sqrtN*sqrtN*sqrtN*sqrtN*sqrtN);
//initializ the sat solver for soduko in the right size.	
	Task8Encode.encode(sqrtN,hints,varsMap);
		
	boolean [] ans= SATSolver.getSolution();
		
	if(ans!=null && ans.length!=0) {
			
		board = Task9Decode.mapToBoard(varsMap, sqrtN*sqrtN, ans);
		
		boolean boardverfy = Task5Verify.isSolution(sqrtN, hints, board);
//check if the soduko is verify.	
		if (boardverfy == false)
			
			throw new ExceptionInInitializerError("there is no solution!!");
		}

		else if(ans==null)	throw new ExceptionInInitializerError("");
	
       		     else board=null;
	
	return board ;
	}
}
