class GradedActivity
{
	private int grade = 0;
	private String activity;

	public GradedActivity(int g, String name)
	{
		if (g < 0)
		{
			grade = 0;
		}
		else
		{
			grade = g;
		}
		activity = name;
	}
	public int getGrade()
	{
		return grade;
	}
	public String getName()
	{
		return activity;
	}
}
