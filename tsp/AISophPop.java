
import java.util.ArrayList;

public class AISophPop {
	
	ArrayList<AISophTour> tours;
	
	public AISophPop(int popSize, boolean initialise) {
		// TODO Auto-generated constructor stub
		tours= new ArrayList<AISophTour>(popSize);
		if(initialise){
		for( int i = 0 ; i < popSize ; i++){

			AISophTour newTour= new AISophTour();
			newTour.generateTour();
			setTour(newTour);
		}
		}
	}
	
	public int popSize(){
		return tours.size();
	}
	
	public AISophTour getTourFromPop(int index){
		return tours.get(index);
	}
	
	public AISophTour getFittestTourFromPop(){
		AISophTour fittestTour = tours.get(0);
		for( int i=1 ; i< popSize();i++){
			
			if( fittestTour.getFitness() < tours.get(i).getFitness()){
				fittestTour = tours.get(i);
			}
			
		}
		return fittestTour;
	}
	public AISophTour getWorstTourFromPop(){
		AISophTour worstTour = tours.get(0);
		for( int i=1 ; i< popSize();i++){
			
			if( worstTour.getFitness() > tours.get(i).getFitness()){
				worstTour = tours.get(i);
			}
			
		}
		return worstTour;
	}

	public void setTour(AISophTour tour) {
		// TODO Auto-generated method stub
		tours.add(tour);
		
	}
	public void replaceTour(int index,AISophTour tour){
		tours.set(index, tour);
	}
	public int getIndexOfTour(AISophTour tour){
		return tours.indexOf(tour);
	}

}
