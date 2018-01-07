
public class AISophCost {
	
	public int c1(int x, int y){
		if(x == y)
			return  0;
		else if(x < 3 && y < 3 )
			return  1;
		else if(x < 3)
			return  200;
		else if(y < 3)
			return  200;
		else if( x%7 == y % 7)
			return  2;
		else
			return  (Math.abs(x-y) + 3);	
	}
	
	public int c2(int x, int y){
		if(x == y)
			return  0;
		else if(x + y < 10 )
			return (Math.abs(x-y) + 4);
		else if( (x + y) % 11 == 0)
			return 3;
		else
			return (int) (Math.pow(Math.abs(x-y),2) + 10);
	}
	
	public int c3(int x, int y){
		
		if(x == y)
			return  0;
		else
			return (int) Math.pow(Math.abs(x + y),2);
			
	}


}
