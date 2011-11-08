package game.tutorial.thenewboston;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.JFrame;


public class Screen 
{
	private GraphicsDevice vc;//vc stands for video card
	
	public Screen()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();//get access to monitor or display device
		vc = env.getDefaultScreenDevice();//see above line
	}
	
	public void setFullScreen(DisplayMode dm, JFrame window)
	{
		window.setUndecorated(true);//no title bars etc
		window.setResizable(false);//Can't resize...
		vc.setFullScreenWindow(window);//set passed in JFrame to fullscreen
		
		if((dm != null) && (vc.isDisplayChangeSupported()))//monitor settings available and can video card change display
		{
			try
			{
				vc.setDisplayMode(dm);
			}
			catch (Exception ex) 
			{
				
			}
		}
	}
	
	public Window getFullScreenWindow()
	{
		return vc.getFullScreenWindow();
	}
	
	public void restoreScreen()
	{
		Window w = vc.getFullScreenWindow();
		if(w != null)
		{
			w.dispose();
		}
		
		vc.setFullScreenWindow(null);
	}
	
}
