
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class AISophAlgo {
	
	private static final int tournamentSize = 5;
	private static final double mutationRate = 0.015;

	public AISophPop revisePopulation(AISophPop pop){
		
		AISophPop revisedPopulation = new AISophPop(pop.popSize(),false);
		revisedPopulation.setTour(pop.getFittestTourFromPop());
		for( int i=0;i<pop.popSize();i++){
			AISophTour parent1 = selectParent(pop);
			AISophTour parent2 = selectParent(pop);
			AISophTour child = crossover(parent1,parent2);
			revisedPopulation.setTour(child);
		}
		for( int i=0;i<pop.popSize();i++){
			mutation(revisedPopulation.getTourFromPop(i));
		}
		return revisedPopulation;		
	}
	
	public  AISophTour selectParent(AISophPop pop){
		
		double bestFitness = pop.getTourFromPop((int) (Math.random() * pop.popSize())).getFitness();
		AISophTour fittest = pop.getTourFromPop((int) (Math.random() * pop.popSize()));
	        for (int i = 1; i < tournamentSize; i++) {
	            int randomId = (int) (Math.random() * pop.popSize());
	            if( bestFitness < (pop.getTourFromPop(randomId)).getFitness()){
	            	fittest = (pop.getTourFromPop(randomId));
	            }
	        }
		return fittest;
	}
	
	public  AISophTour crossover(AISophTour parent1, AISophTour parent2){
		AISophTour child = new AISophTour();
		LinkedList<AISophCity> l1= new LinkedList<>();
		LinkedList<AISophCity> l2= new LinkedList<>();
		for (int i = 0; i < parent2.sizeOfTour(); i++) {	
			l1.add(parent1.getCityFromTour(i));
			l2.add(parent2.getCityFromTour(i));
			}
		int pos=0;
		Random rand= new Random();
		int start = rand.nextInt(parent2.sizeOfTour());
		AISophCity startCity = parent1.getCityFromCityNumber(start);
		int startCityIndex1 = parent1.indexOfCity(startCity);
		int startCityIndex2 = parent2.indexOfCity(startCity);
		child.setCityIntoTour(pos++, startCity);
		ArrayList<Integer> p = new ArrayList<>(4);
		while(pos<child.sizeOfTour()){
				if(startCityIndex1<l1.size()-1)
					p.add(startCity.getDistFromCity(l1.get(startCityIndex1+1).cityNumber));
				else
					p.add( startCity.getDistFromCity(l1.get(0).cityNumber));
				if(startCityIndex1>0)
					p.add(startCity.getDistFromCity(l1.get(startCityIndex1-1).cityNumber));
				else
					p.add( startCity.getDistFromCity(l1.get(l1.size()-1).cityNumber));
				if(startCityIndex2<l1.size()-1)
					p.add(startCity.getDistFromCity(l2.get(startCityIndex2+1).cityNumber));
				else
					p.add( startCity.getDistFromCity(l2.get(0).cityNumber));
				if(startCityIndex2>0)
					p.add(startCity.getDistFromCity(l2.get(startCityIndex2-1).cityNumber));
				else
					p.add( startCity.getDistFromCity(l2.get(l2.size()-1).cityNumber));
			int min = p.get(0);
			int minPos=0;
			for( int j=1;j<4;j++){
				if(min>p.get(j)){
					min=p.get(j);
					minPos=j;
				}
			}
			switch(minPos){
			case 0: if(startCityIndex1<l1.size()-1){
						child.setCityIntoTour(pos++,l1.get(startCityIndex1+1));
						}
					else{
						child.setCityIntoTour(pos++,l1.get(0));
					}
					break;
			case 1:if(startCityIndex1>0){
						child.setCityIntoTour(pos++,l1.get(startCityIndex1-1));
					}	
					else{
						child.setCityIntoTour(pos++,l1.get(l1.size()-1));
					}
					break;
			case 2:if(startCityIndex2<l1.size()-1){
						child.setCityIntoTour(pos++,l2.get(startCityIndex2+1));
					}
					else{
						child.setCityIntoTour(pos++,l2.get(0));
					}
					break;
			case 3:if(startCityIndex2>0){
						child.setCityIntoTour(pos++,l2.get(startCityIndex2-1));
						}
					else{
						child.setCityIntoTour(pos++,l2.get(l2.size()-1));
						}
					break;
				
			}
			l1.remove(startCityIndex1);
			l2.remove(startCityIndex2);
			
			startCityIndex1=l1.indexOf(child.getCityFromTour(pos-1));
			startCityIndex2=l2.indexOf(child.getCityFromTour(pos-1));
		}
		
		return child;
	}
	public  void mutation(AISophTour parent){
		for(int tourPos1=0; tourPos1 < parent.sizeOfTour(); tourPos1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){
                // Get a second random position in the tour
                int tourPos2 = (int) (parent.sizeOfTour() * Math.random());

                // Get the cities at target position in tour
                AISophCity city1 = parent.getCityFromTour(tourPos1);
                AISophCity city2 = parent.getCityFromTour(tourPos2);

                // Swap them around
                parent.setCityIntoTour(tourPos2, city1);
                parent.setCityIntoTour(tourPos1, city2);
            }
        }
	}
}
