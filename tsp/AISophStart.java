
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AISophStart {
	
	public void sophisticatedAlg(int numOfCities,String inputCostFunction,int meb) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		AISophAllCities allCities = new AISophAllCities();
				for( int cityNumber=0; cityNumber< numOfCities;cityNumber++){
					AISophCity newCity = new AISophCity(cityNumber,inputCostFunction);
					allCities.addCity(newCity);
				}
				
				
				 AISophPop pop = new AISophPop(50,true);
				 	AISophAlgo algo = new AISophAlgo();
			        pop = algo.revisePopulation(pop);
			        meb-=50;
			        while(meb>0) {
				        pop = algo.revisePopulation(pop);
				        meb-=101;
			        }

			        
			        FileWriter f2= new FileWriter("2runs.txt",true);
					PrintWriter pw = new PrintWriter(f2);
					if(numOfCities==30 && inputCostFunction.equals("c2")){	
					pw.println("This is the solution of TSP by using Genetic algorithm with "+numOfCities+" cities.\nThe cost function used is "+inputCostFunction+" with MEB value "+numOfCities*(numOfCities+1)/2);
			        pw.println("path is:");}
			        System.out.println("This is the solution of TSP by using Genetic algorithm with "+numOfCities+" cities.\nThe cost function used is "+inputCostFunction+" with MEB value "+numOfCities*(numOfCities+1)/2);
			        System.out.println("path is:");
			        AISophTour iterate = (pop.getFittestTourFromPop());
			        for( int i=0;i<iterate.sizeOfTour();i++){
			        	pw.print(iterate.getCityFromTour(i).cityNumber+" ");
			        	System.out.print(iterate.getCityFromTour(i).cityNumber+" ");
			        }
			        pw.println("\ncost is : "+pop.getFittestTourFromPop().getTourdistance()+"\n\n");
			        System.out.println("\ncost is : "+pop.getFittestTourFromPop().getTourdistance()+"\n\n");
			        pw.close();
	}

}
