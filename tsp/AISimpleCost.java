
public class AISimpleCost {
	static int x,y;
	
	public static int[][] c1(int[][] matrix, int numOfCities){
		
		for( int j=0;j<numOfCities;j++)
		{
			for(int i=0;i<numOfCities;i++){
				x = j;
				y = i;
				if(x == y)
					matrix[j][i] =  0;
				else if(x < 3 && y < 3 )
					matrix[j][i] =  1;
				else if(x < 3)
					matrix[j][i] =  200;
				else if(y < 3)
					matrix[j][i] =  200;
				else if( x%7 == y % 7)
					matrix[j][i] =  2;
				else
					matrix[j][i] =  (Math.abs(x-y) + 3);
			}
		}
		return matrix;
	}
	public static int[][] c2(int[][] matrix, int numOfCities)
	{
		for( int j=0;j<numOfCities;j++)
		{
			for(int i=0;i<numOfCities;i++){
				x = j+1;
				y = i+1;
				if(x == y)
					matrix[j][i] =  0;
				else if(x + y < 10 )
					matrix[j][i] = (Math.abs(x-y) + 4);
				else if( (x + y) % 11 == 0)
					matrix[j][i] = 3;
				else
					matrix[j][i] = (int) (Math.pow(Math.abs(x-y),2) + 10);
			}
		}
		return matrix;
	}
	public static int[][] c3(int[][] matrix, int numOfCities)
	{
		for( int j=0;j<numOfCities;j++)
		{
			for(int i=0;i<numOfCities;i++){
				x = j+1;
				y = i+1;
				if(x == y)
					matrix[j][i] =  0;
				else
					matrix[j][i] = (int) Math.pow(Math.abs(x + y),2);
			}
		}
		return matrix;
	}

}
