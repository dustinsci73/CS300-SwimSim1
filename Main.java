public class Main {
	public static void main(String[] args) 
	{
	// TODO Auto-generated method stub
			
			char[][] tank = new char[8][32];
			int columnFish;
			int rowFish;
			int columnFood;
			int rowFood;
			int columnHook;
			int rowHook;
			int[][] random = generateRandomPositions(4,8,32);
			int[][] food = generateRandomPositions(6,8,32);
			int[][] hook = generateRandomPositions(1,8,32);
			
			while (true)
			{
				moveAllObjects(random,0,1,8,32);
				moveAllObjects(food,1,-1,8,32);
				moveAllObjects(hook,-1,0,8,32);
				fillTank(tank,'~');
				for (int i = 0; i < random.length; i++)
				{
					for (int j = 0; j < random[i].length; j++)
					{
						if (j == 0)
						{
							rowFish = random[i][j];
							columnFish = random[i][j+1];
							if(columnFish < tank[i].length)
							{
								placeObjectInTank("><))'>",tank,columnFish,rowFish);
							}
						}	
					}
				}
				for (int i = 0; i < food.length; i++)
				{
					for (int j = 0; j < food[i].length; j++)
					{
						if (j == 0)
						{
							rowFood = food[i][j];
							columnFood = food[i][j+1];
							if(columnFood < tank[i].length)
							{
								placeObjectInTank("*",tank,columnFood,rowFood);;
							}
						}	
					}
				}
				for (int i = 0; i < hook.length; i++)
				{
					for (int j = 0; j < hook[i].length; j++)
					{
						if (j == 0)
						{
							rowHook = hook[i][j];
							columnHook = hook[i][j+1];
							if(columnHook < tank[i].length)
							{
								placeObjectInTank("J",tank,columnHook,rowHook);
							}
						}	
					}
				}		
				renderTank(tank);
				Utility.pause(200);
			    System.out.println("\n\n\n");
			}
			
			/*fillTank(tank,'~');
			placeObjectInTank("><))'>",tank,30,5);
			for (int i = 0; i< tank.length; i++) {
				for (int j = 0; j< tank[i].length; j++) {
					System.out.print(tank[i][j]);
				}
				System.out.println();
			}
			*/
	}	
	public static void fillTank(char[][] tank, char water)
	{
		for (int i = 0; i < tank.length; i++)
		{
		    for (int j = 0; j < tank[i].length; j++)
			   {
			   	   tank[i][j] = water;
			   } 
		}
	}
		 
	public static void renderTank(char[][] tank)
	{
		for (int i = 0; i < tank.length; i++)
		{
			for (int j = 0; j < tank[i].length; j++)
			{
				System.out.print(tank[i][j]);
			}
			System.out.println();
		}
	}
	public static int[][] generateRandomPositions(int number, int width, int height)
	{
		
		int[][] random = new int[number][2];
			
		for (int i = 0; i < number; i++)
		{
			for (int j = 0; j <  2; j++)
			{
				int posX = Utility.randomInt(width);
				int posY = Utility.randomInt(height);
						
					if (j == 0)
					{
						random[i][j] = posX;
					}
					else if (j == 1)
					{
						random[i][j] = posY;
					}
				}
			}
			return random;
			
	}
	public static void placeObjectInTank(String object, char[][] tank, int column, int row)
	{
		if (object.length() < 2)
		{
			tank[row][column] = object.charAt(0);
		}
		if (object.length() > 2)
		{
			for (int i = object.length() - 1; i >= 0; i--)
			{
				tank[row][column] = object.charAt(i);
				column--;
				if (column < 0)
				{
					column += tank[0].length;
				} 		
			}
		}
	}
	public static void moveAllObjects(int[][] positions, int dx, int dy, int width, int height)
	{
		for (int i = 0; i < positions.length; i++)
		{
			if (positions[i][0] + dx > width - 1)
			{
				positions[i][0] = 0;
			}
			else if (positions[i][0] + dx < 0)
			{
				positions[i][0] = width - 1;
			}
			else 
			{
				positions[i][0] += dx;
			}
			
			if (positions[i][1] + dy > height - 1)
			{
				positions[i][1] = 0;
			}
			else if (positions[i][1] + dy < 0)
			{
				positions[i][1] = height - 1;
			}
			else 
			{
				positions[i][1] += dy;
			}
		}
	}
}







