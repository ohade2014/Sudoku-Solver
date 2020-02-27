//ohad eliyahou 203866447 30.11.2017
//the function convert the number in index to the number that set for the SAT, and function that make the other way, and function that create the coard map.
public class Task7Map {
	
	
	public static int varName(int i, int j, int k, int n) {
	
	 int varName= ((n*n)*i)+(n*j)+k+1;//calculate the number in the matrix.
           return varName;}

	
public static int[] nameToIndex(int x, int n) {

		 int [] nameToIndex= new int[3];
        	nameToIndex[2]= (((x-1)%(n*n))%n);
        	nameToIndex[1]=((x-1-nameToIndex[2])%(n*n))/n;
        	nameToIndex[0]=(x-1-nameToIndex[2]-nameToIndex[1])/(n*n);
        return nameToIndex;}
	


	public static int[][][] varsMap(int n) {
	
	 int[][][]varsMap= new int[n][n][n];
         for(int i=0;i<varsMap.length;i++)
            for(int j=0;j<varsMap.length;j++)
                for(int k=0;k<varsMap.length;k++)
                    varsMap[i][j][k]=varName(i,j,k,n);//insert number to place using the varName function
    	return varsMap;	}
}
