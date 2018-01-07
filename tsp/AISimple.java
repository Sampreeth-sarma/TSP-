
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AISimple {
	static int cost=0; 
	static String path;
	public void simpleAlg(int numOfCities,String inputCostFunction,int meb,int startPoint) throws IOException {

		if(numOfCities*(numOfCities+1)/2 < meb){
			int[][] matrix=new int[numOfCities][numOfCities];
			int x,y;
				cost=0;
				path="";

				String ret;
				//load matrix with the costs
				matrix = loadCostMatrix(matrix,inputCostFunction,numOfCities);
				if(matrix!=null){
				 ret=bstFrstSrch(matrix,startPoint,path,0).trim();
				 cost+=matrix[Integer.parseInt(ret.substring(ret.lastIndexOf('\t')+1))][startPoint];
				 
				 
				FileWriter f2= new FileWriter("2runs.txt",true);
				PrintWriter pw = new PrintWriter(f2);
				if(numOfCities==30 && inputCostFunction.equals("c2")){
				pw.println("This is the solution of TSP by using Greedy algorithm with "+numOfCities+" cities.\nThe cost function used is "+inputCostFunction+" with MEB value "+numOfCities*(numOfCities+1)/2);
				pw.println("path is :"+ret+"\n"+"cost is:"+cost+"\n\n");}
				System.out.println("This is the solution of TSP by using Greedy algorithm with "+numOfCities+" cities.\nThe cost function used is "+inputCostFunction+" with MEB value "+numOfCities*(numOfCities+1)/2);
				System.out.println("path is :"+ret+"\n"+"cost is:"+cost+"\n\n");
				
				pw.close();
				}
				else{
					System.out.println("invalid inputs");
					System.exit(0);
				}
				
				
		}
	}

	public static int[][] loadCostMatrix(int[][] matrix, String inputCostFunction, int numOfCities) {
		// TODO Auto-generated method stub
		int[][] a = null;

		switch (inputCostFunction) {
		case "c1": return AISimpleCost.c1(matrix,numOfCities);
		case "c2": return AISimpleCost.c2(matrix,numOfCities);
		case "c3": return AISimpleCost.c3(matrix,numOfCities);
		default:   return a;
		}
	}

	public static String bstFrstSrch(int[][] matrix, int rowNum, String path,int counter) {
		// TODO Auto-generated method stub
		if(counter==matrix[rowNum].length-1)
			return path;
		else{
			int min=getColNumOfMin(matrix[rowNum],rowNum,path);
			return bstFrstSrch(matrix, min, path+(min)+"\t",counter+1);
		}
	}

	private static int getColNumOfMin(int[] is,int rowNum,String path) {
		// TODO Auto-generated method stub
		int min=0, i;
		
		// to choose min
		for(i = 0 ; i < is.length ; i++){
			if(path.indexOf("\t"+(i)+"\t")==-1){
				min=i;
				break;
			}
		}
		// to find min
		for(i=0; i<is.length ;i++){
			if( i!=rowNum && path.indexOf("\t"+(i)+"\t")==-1 && is[i] < is[min] )
				min=i;
		}
		
		// to add the cost of next node into Netcost
		cost+=is[min];
		return min;
	}

}


