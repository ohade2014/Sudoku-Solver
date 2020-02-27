//ohad eliyahou 203866447 30.11.2017
// the function check if there is more then one solution for the problem.
public class Task11Unique {
	
	public static int[][] solveUnique(int sqrtN, int[][] hints) {
		int [][] solution=new int [sqrtN*sqrtN][sqrtN*sqrtN];
		if((sqrtN*sqrtN)-1>hints.length)// if there is less hints then sqrtn*sqrtn -1 there is more then one sloution to the soduko.
			solution=null;
		else{
			int[][][]varsMap= Task7Map.varsMap(sqrtN*sqrtN);// the same action like in the 10 mission.
			SATSolver.init(sqrtN*sqrtN*sqrtN*sqrtN*sqrtN*sqrtN);
			Task8Encode.encode(sqrtN,hints,varsMap);
			int [] clause=new int [sqrtN*sqrtN*sqrtN*sqrtN];
			boolean [] ans= SATSolver.getSolution();
			if(ans!=null && ans.length!=0) {
				solution = Task9Decode.mapToBoard(varsMap, sqrtN*sqrtN, ans);
				boolean boardverfy = Task5Verify.isSolution(sqrtN, hints, solution);
				if (boardverfy == false)
					throw new ExceptionInInitializerError("there is no solution!!");
			}
			else {if(ans==null){
				throw new ExceptionInInitializerError("");}
				if(ans.length==0)solution=null;
			}
				int k=0;
			for(int i=0;i<varsMap.length;i++){
				for(int j=0;j<varsMap.length;j++){
					clause[k]=-(Task7Map.varName(i,j,(solution[i][j]-1),sqrtN*sqrtN));//build new arr whith the solution number just in (-).
					k=k+1;
				}
			}
			SATSolver.init(sqrtN*sqrtN*sqrtN*sqrtN*sqrtN*sqrtN);
			Task8Encode.encode(sqrtN,hints,varsMap);
			SATSolver.addClause(clause);// add the clause if there is more then one solution the SAT will find new solution else the assignment will be empty.
			boolean [] ans1= SATSolver.getSolution();
			if(ans1==null)
				throw new ExceptionInInitializerError();
			if(ans1.length!=0) //there is more then one solution.
			{
				solution =null;}
		}
		return solution;

	}

}
