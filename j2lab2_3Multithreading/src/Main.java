import java.util.LinkedList;
import java.util.Queue;


public class Main 
{
	public static void main(String[] args) 
	{
		//create queue
		Queue<String> q = new LinkedList<String>();
		//create update thread
		updateThread Update = new updateThread(q);
		//create user thread
		userInterfaceThread User = new userInterfaceThread(q);
		while(true)
		{
			User.run();//start user thread
			Update.run();//start update thread
		}
		
	}
}
