
public class AISophCity {
	int cityNumber;
	String costFunction;
	
	public AISophCity(int cityNumber,String costFunction) {
		// TODO Auto-generated constructor stub
		this.cityNumber=cityNumber;
		this.costFunction=costFunction;
	}
	public int getDistFromCity( int cityNumber){
		AISophCost aicost=new AISophCost();
		switch (costFunction) {
		case "c1": return aicost.c1(this.cityNumber,cityNumber);
		case "c2": return aicost.c2(this.cityNumber,cityNumber);
		case "c3": return aicost.c3(this.cityNumber,cityNumber);
		}
		return 0;
	}

}
