//ohad eliyahou 203866447 30.11.2017
// the function check if there is at leas one number correct, at most one number correct, and exactly one correct.
public class Task6Cnf {

	public static int[][] atLeastOne(int[] vars){
		int l= vars.length;
		int [][]cnfarr=new int[1][l];
		for(int i=0;i<cnfarr.length;i++) {
			if(vars[i] > 0)
				cnfarr[0][i] = vars[i];
			else
				cnfarr[0][i] = -(vars[i]);
		}
		return cnfarr;
	}

public static int [][]atMostOne(int[]vars) {
		int l= vars.length;
		int [][]cnfarr;
		int size=0;
		if(l==1){
			cnfarr=new int[1][2];
			cnfarr [0][0]=vars[0];
			cnfarr [0][1]=-vars[0];
		}
		else{
			for( int i=l; l>0;l--){
				size=size+i;
			}
			int counteri = 0;//counting number of parity.
			cnfarr = new int[size][2];//the size is 2 because its insert parity.
			for (int i = 0; i < l - 1; i++) {
				for (int j = i + 1; j < l; j++) {
							cnfarr[counteri][0]=-(vars[i]);//insert the number in (-)
							cnfarr[counteri][1] = -(vars[j]);
								counteri = counteri + 1;
						}

				}
			}
		return cnfarr;
	}
public static int[][] exactlyOne(int[] varNames) {
		int l = varNames.length;
		int counteri = 0;
		int size =0;
		for( int i=l-1; i>0;i--){
			size=size+i;
		}
		int[][] cnfarr = new int[size+1][];// size +1 because the size is the number of parity, and the one extra is the "at leastone"
		for (int i = 0; i < l - 1; i++) {
			for (int j = i + 1; j < l; j++) {
				int [] clause = new int [2];
				clause[0] = - (varNames[i]);
				clause[1] = - (varNames[j]);
				cnfarr[counteri] = clause;
				counteri = counteri + 1;
			}

		}
		cnfarr[size]=varNames;
		return cnfarr;

	}
}
