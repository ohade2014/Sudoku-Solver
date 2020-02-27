//ohad eliyahou 203866447 30.11.2017
//convert the number to clause that the SAT will check, and the function blocks for 3 d matrix.




public class Task8Encode {

	
	public static void encode(int sqrtN, int[][] hints, int[][][] map) {

		int [][][] mapBlocks=blocks(map,sqrtN);

		for(int k=0; k<sqrtN*sqrtN;k++){

			for(int i=0;i<map.length;i++){

				int [] vars= new int[sqrtN*sqrtN];
// array row.			
				int [] vars1= new int[sqrtN*sqrtN];
//array colum.	
				int [] vars2= new int[sqrtN*sqrtN];
//array block.	
				for(int j=0;j<map.length;j++){
				
					int [] vars3=new int[sqrtN*sqrtN];
//array cell.			
					vars[j]=map[i][j][k];
				
					vars1[j]=map[j][i][k];
				
					vars2[j]=mapBlocks[i][j][k];
		
					for(int t=0;t<sqrtN*sqrtN;t++)
			
						vars3[t]=map[i][j][t];
				
					SATSolver.addClauses(Task6Cnf.exactlyOne(vars3));
}
	
				SATSolver.addClauses(Task6Cnf.exactlyOne(vars));

				SATSolver.addClauses(Task6Cnf.exactlyOne(vars1));
		
				SATSolver.addClauses(Task6Cnf.exactlyOne(vars2));

}
}


		for(int r=0;r<hints.length;r++){
			
			int [][] vars4=new int[1][1];
//array hints.		
			vars4[0][0]=map[hints[r][0]][hints[r][1]][hints[r][2]-1];
	
			SATSolver.addClauses(vars4);
}
	
		}



	public static int[][][] blocks(int[][][] matrix, int sqrtN)
	{
	
	int Size = matrix.length;
		
	int counteri=0;
	//number of the row in the exeact moment of the check.	
	int counterj=0;
	//number of the colum in the exeact moment of the check.	
	int k=0;
//the row in the new matrix.
	int z=0;
// the colum in the new matrix.
	int blockCounter=0;
// the block number in count from left to right and up to down.
	boolean counterians=true;
//if its become false, the check is out of bounds.
	int[][][] newMatrix = new int[Size][Size][sqrtN*sqrtN];
	
	for(int t=0; t<sqrtN*sqrtN &counterians;t++) {
		
		for (int i = counteri; i <counteri+sqrtN & counterians; i++) {
	
			for (int j = counterj; j < counterj + sqrtN; j++) 

// assigment tow number each time.
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
			
	if(blockCounter%sqrtN==0) // number of block in each row is the sqrtn, every time the modulo is zero the row advance.
	{
				
		counteri = counteri + sqrtN;
			
		if (counteri >= matrix.length)
			
			counterians=false;
			
	}


		
	}
		
	return newMatrix;	}
}
