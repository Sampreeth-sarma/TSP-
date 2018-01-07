
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class AIProject {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter simp for simple and soph for sophisticated");
		String algType = sc.nextLine();
		
		System.out.println("enter the number of cities");
		int numOfCities = sc.nextInt();
		
		System.out.println("enter the cost function: c1 or c2 or c3");
		String inputCostFunction = sc.next();
		
		System.out.println("enter the meb value");
		int meb = sc.nextInt();
		
		
    	  if(algType.equalsIgnoreCase("simp")){
				System.out.println("enter strt pt");
				int startPoint = sc.nextInt();
				
    		  AISimple simp = new AISimple();
			  long start = System.nanoTime();
    		  simp.simpleAlg(numOfCities,inputCostFunction,meb,startPoint);
			  long diff = System.nanoTime()-start;
			  System.out.println("Time taken to execute is : "+ diff/(int)Math.pow(10,9)+" seconds");
			 
    		  
    	  }
    	  else if(algType.equalsIgnoreCase("soph")){
    		  AISophStart soph = new AISophStart();
			  long start = System.nanoTime();
    		  soph.sophisticatedAlg(numOfCities,inputCostFunction,meb);
			  long diff = System.nanoTime()-start;
			  System.out.println("Time taken to execute is : "+ diff/(int)Math.pow(10,9)+" seconds");
    	  }
	}

}
