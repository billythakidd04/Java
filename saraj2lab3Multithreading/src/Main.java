import java.util.LinkedList;
import java.util.Queue;


public class Main 
{
	static Queue<String> q = null;
	public static void main(String[] args) throws InterruptedException
	{
		q = new LinkedList<String>();
		intoQue user = new intoQue(q);
		write2File out2File = new write2File(q);
		out2File.start();
	}

}
