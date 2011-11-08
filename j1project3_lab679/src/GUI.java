import javax.swing.JFrame;


public class GUI extends JFrame
{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
	{
		startLayoutSet newFrame = new startLayoutSet();
		
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setSize(300, 150);
		newFrame.setLocationRelativeTo(null);
		newFrame.setVisible(true);
		newFrame.setResizable(false);
	}
}
