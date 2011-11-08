import javax.swing.JOptionPane;


public class CourseGrades extends GradeArray implements Analyzable
{
	final static int size = 4;
	
	
	public CourseGrades()
	{
		course = new GradedActivity[size];
	}
	
	public void setLab(GradedActivity lab)
	{
		if (lab.getName().equalsIgnoreCase("lab"))
		{
			throw new IllegalArgumentException();
		}
		course[0] = lab;
	}
	
	public void setPassFailExam(GradedActivity exam)
	{
		if (exam.getName().equalsIgnoreCase("exam"))
		{
			throw new IllegalArgumentException();
		} 
		course[1] = exam;
	}
	
	public void setEssay(GradedActivity essay)
	{
		if (essay.getName().equalsIgnoreCase("essay"))
		{
			throw new IllegalArgumentException();
		}
		course[2] = essay;
	}
	
	public void setFinalExam(GradedActivity finalExam)
	{
		if (finalExam.getName().equalsIgnoreCase("final"))
		{
			throw new IllegalArgumentException();
		}
		course[3] = finalExam;
	}
	
	//public void toString();
	
	public static void main(String[] args) 
	{
		String NumStudent = JOptionPane.showInputDialog(null,"Please input number of students: ");
		int numStudents = Integer.parseInt(NumStudent);
		
		ClassGrades [] studentGrades = new ClassGrades [numStudents];
		for(int x = 0; x < numStudents; ++x)
		{
			studentGrades[x]=null;
		}
		
		String command = null;
		
		command = JOptionPane.showInputDialog(null, "grades or quit?");
		
		while (!command.equalsIgnoreCase("quit"))
		{			
			String gradeCommand = JOptionPane.showInputDialog(null, "what would u like to enter grades for?\nLab\nExam\nEssay\nFinal");
			
			String thisStudent = JOptionPane.showInputDialog(null, "enter students name");
			
			int x = 0;
			while (x < numStudents)
			{
				if(!thisStudent.equalsIgnoreCase(studentGrades[x].getStudentName()))
				{
					++x;
				}
				else if (thisStudent.equalsIgnoreCase(studentGrades[x].getStudentName()))
				{
					break;
				}
			}
			
			if(!thisStudent.equalsIgnoreCase(studentGrades[x].getStudentName()))
			{
				int check = JOptionPane.showConfirmDialog(null, "new entry?", "New Student Confirmation", JOptionPane.YES_NO_OPTION);
				if (check == 0)
				{
					studentGrades[x].setStudentName(JOptionPane.showInputDialog(null, "enter name of student"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "name not found");
				}
			}
			
			if (gradeCommand.equalsIgnoreCase("lab"))
			{
				this.setLab();
			}
		
		
		
		@SuppressWarnings("unused")
		String StudentName = JOptionPane.showInputDialog(null,"Student name you wish to input a grade for: ");
		
		@SuppressWarnings("unused")
		String Activity = JOptionPane.showInputDialog(null,"Please input the activity: ");
		
		@SuppressWarnings("unused")
		String Grade = JOptionPane.showInputDialog(null,"Please input the grade for the activity: ");
		}		
	}

	public double getAverage() 
	{
		return 0;
	}

	public GradedActivity getHighest() 
	{
		return null;
	}

	public GradedActivity getLowest() 
	{
		return null;
	}
}