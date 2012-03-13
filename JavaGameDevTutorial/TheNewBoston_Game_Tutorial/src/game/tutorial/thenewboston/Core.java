package game.tutorial.thenewboston;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;

public abstract class Core 
{

	//array of common display modes
	private static final DisplayMode modes1[] = {
		new DisplayMode(800, 600, 32, 0),
		new DisplayMode(800, 600, 24, 0),
		new DisplayMode(800, 600, 16, 0),
		new DisplayMode(640, 480, 32, 0),
		new DisplayMode(640, 480, 24, 0),
		new DisplayMode(640, 480, 16, 0),
	};

	private boolean running;
	protected ScreenManager s;

	//stop method
	public void stop()
	{
		running = false;
	}

	//call init and game loop
	public void run()
	{
		try
		{
			init();
			gameLoop();
		}
		catch(Exception e){}
		finally
		{
			s.restoreScreen();
		}
	}

	//main game loop
	public void gameLoop() 
	{
		long startingTime = System.currentTimeMillis();
		long accumulatedTime = startingTime;

		while (running) 
		{
			long timePassed = System.currentTimeMillis() - accumulatedTime;
			accumulatedTime += timePassed;

			update(timePassed);

			//draw and update screen
			Graphics2D g = s.getGraphics();
			paint(g);
			g.dispose();
			s.update();

			try
			{
				Thread.sleep(20);
			}
			catch (Exception e) {}
		}
	}

	//update sprite positioning (check if on screen)
	private void update(long timePassed) 
	{
	}
	

	//paints graphics to screen
	public abstract void paint(Graphics2D g);
	{
	}

	//initialize window
	public void init() 
	{
		s = new ScreenManager();
		DisplayMode dm = s.findFirstCompatibleDM(modes1);
		s.setFullScreen(dm);

		Window w = s.returnFullScreenWindow();
		w.setFont(new Font("Arial", Font.PLAIN, 20));
		w.setBackground(Color.GREEN);
		w.setForeground(Color.WHITE);

		running = true;		
	}

}
