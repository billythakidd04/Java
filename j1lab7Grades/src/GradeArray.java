class GradeArray
{
	private GradedActivity[] grades;
	private int size = 0;
	
	public GradeArray()
	{
		
	}

	public GradeArray(int size)
	{
		grades = new GradedActivity [size];
	}
	public void storeValue(GradedActivity value, int subscript)
	{
		if ( (subscript > size+1) || (subscript < 0) )
		{
			throw new IllegalArgumentException();
		}			
		grades[subscript] = value;
				
	}
	public GradedActivity getValue(int subscript)
	{
		//*
		if ( (subscript > size+1) || (subscript < 0) )
		{
			throw new IllegalArgumentException();
		}
		return grades[subscript];
	}
	public int getSize()
	{
		return size;
	}
}
