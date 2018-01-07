
import java.util.ArrayList;
import java.util.Collections;

public class AISophTour {

	private ArrayList<AISophCity> tour = new ArrayList<AISophCity>();
	private double fitness=0;
	private float distance = 0;
	
	public AISophTour() {
		AISophAllCities allCities = new AISophAllCities();
		int sizeOfTour = allCities.getNumberOfCities();
		for( int i=0;i<sizeOfTour;i++){
			tour.add(i, null);
		}
	}
	
	public AISophTour(ArrayList<AISophCity> tour){
		this.tour=tour;
	}
	
	public void generateTour(){
		AISophAllCities allCities = new AISophAllCities();
		int sizeOfTour = allCities.getNumberOfCities();
		for( int i=0; i< sizeOfTour;i++){
			setCityIntoTour(i,allCities.getCityFromCities(i));
		}
		Collections.shuffle(tour);
	}
	
	public void setCityIntoTour(int index, AISophCity city) {
		// TODO Auto-generated method stub
		tour.set(index, city );
	}

	public AISophCity getCityFromTour(int index){
		return tour.get(index);
	}
	public AISophCity getCityFromCityNumber(int cityNumber){
		int i=0;
		while(cityNumber!=tour.get(i++).cityNumber);
		return tour.get(i-1);
	}
	
	public int sizeOfTour(){
		return tour.size();
	}
	
	public double getFitness(){
		if( fitness==0){
			return 1/getTourdistance();
		}
		else
			return fitness;
	}

	public float getTourdistance() {
		// TODO Auto-generated method stub
		if(distance==0){
			int distFrmSrcToDest=0;
			AISophCity sourceCity ;
			for( int i=0; i<sizeOfTour();i++){
				sourceCity = tour.get(i);
				AISophCity destinationCity = tour.get(i+1<sizeOfTour()?i+1:0);
				distFrmSrcToDest += sourceCity.getDistFromCity(destinationCity.cityNumber);
			}
			distance = distFrmSrcToDest;
		}
		return distance;
	}

	public boolean containsCity(AISophCity cityFromTour) {
		// TODO Auto-generated method stub
		return tour.contains(cityFromTour);
	}
	public int indexOfCity(AISophCity city){
		return tour.indexOf(city);
	}
}
