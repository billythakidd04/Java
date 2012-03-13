/*
public class IdeaTest 
{

	final static int MAP_SIZE = 40;
	public static void main(String[] args) 
	{
		int viewRad = 6;
		int row = 4;
		int col = 4;

		int rowDes = 25;
		int colDes = 25;

		System.out.println("The initial starting parameters are: \n");
		System.out.println("viewRad :" + viewRad);
		System.out.println("row ant is on :" + row);
		System.out.println("col ant is on :" + col);
		System.out.println("row we want to go to :" + rowDes);
		System.out.println("col we want to go to :" + colDes);

		searchNeighbors(viewRad,row,col);

		getDistance(row,col,rowDes,colDes);

	}

	private static int getDistance(int row, int col, int rowDes, int colDes) 
	{
		int rowDelta = Math.abs(row - rowDes);
		int colDelta = Math.abs(col - colDes);
		rowDelta = Math.min(rowDelta, MAP_SIZE - rowDelta);
		colDelta = Math.min(colDelta, MAP_SIZE - colDelta);
		System.out.println("\nrowDelta is: " + rowDelta +"colDelta is : " + colDelta);
		System.out.println("The distance is: " + rowDelta * rowDelta + colDelta * colDelta);

		return (rowDelta * rowDelta + colDelta * colDelta);
	}

	private static void searchNeighbors(int viewRad, int row, int col) 
	{
		for (int r = -viewRad; r <= viewRad; r++) //why using negative??? possibly for wrap around??
		{
			for (int c = -viewRad; c<= viewRad; c++) 
			{
				int effectiveCol = (col + c) % MAP_SIZE;
				effectiveCol = effectiveCol < 0 ? effectiveCol += MAP_SIZE : effectiveCol;

				int effectiveRow = (row + r) % MAP_SIZE;
				effectiveRow = effectiveRow < 0 ? effectiveRow += MAP_SIZE : effectiveRow;

				System.out.println("\nAnt is at tile 4,4");
				System.out.println("r is:"+r+" c is: "+c+" Effective Tile is:("+effectiveCol+","+effectiveRow+")");
			}
		}
	}

}
*/