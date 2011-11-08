package game.tutorial.thenewboston;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ThaKidd extends JFrame //STOPPED AT TUTORIAL NUMBER !!!!!!!
{
	private ScreenManager s;
	private Image bg;
	private boolean loaded;
	private Animation a;
	private Sprite sprite;
	
	//array of common display modes
	private static final DisplayMode modes1[] = {
		new DisplayMode(800, 600, 32, 0),
		new DisplayMode(800, 600, 24, 0),
		new DisplayMode(800, 600, 16, 0),
		new DisplayMode(640, 480, 32, 0),
		new DisplayMode(640, 480, 24, 0),
		new DisplayMode(640, 480, 16, 0),
	};
	//////////////////////////////////////////////
	//////////////////////////////////////////////
	
	
	
	public static void main(String [] args) 
	{		
		ThaKidd tk = new ThaKidd();
		tk.run();
	}

	//run method
	private void run() 
	{
		/*setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 24));
		loaded = false;*/
		
		s = new ScreenManager();
		
		try
		{
			DisplayMode dm = s.findFirstCompatibleDM(modes1);
			s.setFullScreen(dm);
			loadPics();
			movieLoop();
		}
		finally
		{
			s.restoreScreen();
		}
	}
	
	//main movie loop
	private void movieLoop() 
	{
		long startingTime = System.currentTimeMillis();
		long accumulatedTime = startingTime;
		
		while (accumulatedTime - startingTime < 5000) 
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
		if(sprite.getX() < 0)
		{
			sprite.setXVelocity(Math.abs(sprite.getXVelocity()));
		}
		else if(sprite.getX() + sprite.getWidth() > s.getWidth())
		{
			sprite.setXVelocity(-Math.abs(sprite.getXVelocity()));
		}
		
		if(sprite.getY() < 0)
		{
			sprite.setYVelocity(Math.abs(sprite.getYVelocity()));
		}
		else if(sprite.getY() + sprite.getHeight() > s.getHeight())
		{
			sprite.setYVelocity(-Math.abs(sprite.getYVelocity()));
		}
		
		sprite.update(timePassed);
	}

	//loads pictures and adds to scene arraylist
	private void loadPics() 
	{
		bg = new ImageIcon("back.jpg").getImage();
		Image face1 = new ImageIcon("face.png").getImage();
		Image face2 = new ImageIcon("face2.png").getImage();
		
		a = new Animation();
		
		a.addScene(face1, 250);
		a.addScene(face2, 250);
		
		sprite = new Sprite(a);
		sprite.setXVelocity(0.3f);
		sprite.setYVelocity(0.4f);
		
		loaded = true;
		repaint();
	}

	//paints graphics to screen
	public void paint(Graphics g)
	{
		if(g instanceof Graphics2D)
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		
		if(loaded)
		{
			g.drawImage(bg, 0, 0, null);
			g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);
		}
		
	}
}
