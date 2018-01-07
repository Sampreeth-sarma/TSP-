
import java.util.ArrayList;

public class AISophAllCities {
	
	private static ArrayList<AISophCity> allCities = new ArrayList<AISophCity>();
	
	public  void addCity(AISophCity city){
		allCities.add(city);
	}
	
	public  AISophCity getCityFromCities(int cityNumber){
		return allCities.get(cityNumber);
	}
	
	public  int getNumberOfCities(){
		return allCities.size();
	}
}
