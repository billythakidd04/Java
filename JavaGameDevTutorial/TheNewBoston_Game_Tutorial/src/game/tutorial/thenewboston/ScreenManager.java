package game.tutorial.thenewboston;

import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class ScreenManager 
{

	private GraphicsDevice vc;

	public ScreenManager()
	{
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = e.getDefaultScreenDevice();//give vc access to monitor/screen

	}

	//get all compatible display modes
	public DisplayMode[] getCompatibleDisplayModes() 
	{
		return vc.getDisplayModes();
	}

	//compare DM passed into vc DM and check for match
	public DisplayMode findFirstCompatibleDM(DisplayMode [] modes)
	{
		DisplayMode goodModes[] = vc.getDisplayModes();

		for(int x = 0; x<modes.length;++x)
		{
			for(int y = 0; y<goodModes.length;++y)
			{
				if(displayModesMatch(modes[x],modes[y]))
				{
					return modes[x];//return either or since they match
				}
			}
		}
		return null;
	}

	//checks for matching DM
	private boolean displayModesMatch(DisplayMode m1, DisplayMode m2) 
	{
		if((m1.getWidth() != m2.getWidth())||(m1.getHeight() != m2.getHeight()))//test resolution
		{
			return false;
		}
		if((m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI)&&(m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI)&&(m1.getBitDepth()!=m2.getBitDepth()))//test bitmap color depth
		{
			return false;
		}
		if((m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN)&&(m2.getRefreshRate()!= DisplayMode.REFRESH_RATE_UNKNOWN)&&(m1.getRefreshRate()!=m2.getRefreshRate()))//test refresh rates
		{
			return false;
		}
		return true;
	}

	//get current display mode from video card
	public DisplayMode getCurrentDisplayMode()
	{
		return vc.getDisplayMode();
	}

	//make frame fullscreen
	public void setFullScreen(DisplayMode dm)
	{
		JFrame f = new JFrame();

		f.setUndecorated(true);
		f.setIgnoreRepaint(true);
		f.setResizable(false);

		vc.setFullScreenWindow(f);

		if((dm != null)&&(vc.isDisplayChangeSupported()))
		{
			try
			{
				vc.setDisplayMode(dm);
			}
			catch (Exception e) 
			{
			}
		}

		f.createBufferStrategy(2);
	}

	//set graphics object equal to this return element
	public Graphics2D getGraphics()
	{
		Window w = vc.getFullScreenWindow();
		if(w != null)
		{
			BufferStrategy s = w.getBufferStrategy();
			return (Graphics2D)s.getDrawGraphics();
		}
		return null;
	}

	//updates display
	public void update()
	{
		Window w = vc.getFullScreenWindow();
		if(w != null)
		{
			BufferStrategy s = w.getBufferStrategy();
			if(!s.contentsLost())
			{
				s.show();
			}
		}
	}
	
	//return full screen window
	public Window returnFullScreenWindow()
	{
		return vc.getFullScreenWindow();
	}
	
	//get window width
	public int getWidth()
	{
		Window w = vc.getFullScreenWindow();
		if(w != null)
		{
			return w.getWidth();
		}
		return 0;
	}

	//get window height
	public int getHeight()
	{
		Window w = vc.getFullScreenWindow();
		if(w != null)
		{
			return w.getHeight();
		}
		return 0;
	}
	
	//get out of fullscreen
	public void restoreScreen()
	{
		Window w = vc.getFullScreenWindow();
		
		if(w != null)
		{
			w.dispose();
		}
		
		vc.setFullScreenWindow(null);
	}
	
	//make image compatible with screen
	public BufferedImage createCompatibleImage(int w, int h, int t)//width height transparency
	{
		Window win = vc.getFullScreenWindow();
		
		if(win != null)
		{
			GraphicsConfiguration gc = win.getGraphicsConfiguration();
			return gc.createCompatibleImage(w, h, t);
		}
		
		return null;
	}

}
