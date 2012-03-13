package game.tutorial.thenewboston;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Look extends Core implements MouseMotionListener,KeyListener
{

	private Image bg;
	private Robot robot;
	private Point mouse;
	private Point center;
	private Point image;
	private boolean centering;

	public static void main(String[] args) 
	{
		new Look().run();
	}

	public void init()
	{
		super.init();

		mouse = new Point();
		center = new Point();
		image = new Point();
		centering = false;

		try
		{
			robot = new Robot();
			reCenterMouse();
			mouse.x = center.x;
			mouse.y = center.y;
		}
		catch (Exception e) 
		{
			System.out.println("Error 1");
		}

		Window w = s.returnFullScreenWindow();
		w.addMouseMotionListener(this);
		w.addKeyListener(this);

		bg = new ImageIcon("back.jpg").getImage();
	}

	@Override
	public synchronized void paint(Graphics2D g) 
	{
		int w = s.getWidth();
		int h = s.getHeight();

		image.x %= w;
		image.y %= h;

		if(image.x < 0)
		{
			image.x += w;
		}

		if(image.y < 0)
		{
			image.y += h;
		}

		int x = image.x;
		int y = image.y;
		
		g.drawImage(bg,x,y,null);
		g.drawImage(bg,x-w,y-h,null);
		g.drawImage(bg,x-w,y,null);
		g.drawImage(bg,x,y-h,null);
	}
	
	//recenter mouse using robot
	private synchronized void reCenterMouse()
	{
		Window w = s.returnFullScreenWindow();
		
		if ((robot != null)&&(w.isShowing()))
		{
			center.x = w.getWidth()/2;
			center.y = w.getHeight()/2;
			
			SwingUtilities.convertPointToScreen(center, w);
			centering = true;
			robot.mouseMove(center.x, center.y);
		}
	}

	@Override//when user presses a key on the keyboard down
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_ESCAPE)
		{
			stop();
		}
	}

	@Override//on release of keyboard key
	public void keyReleased(KeyEvent e)	{e.consume();}

	@Override
	public void keyTyped(KeyEvent e) {e.consume();}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		if((centering)&&(center.x == e.getX())&&(center.y == e.getY()))
		{
			centering = false;
		}
		else
		{
			int dx = e.getX() - mouse.x;
			int dy = e.getY() - mouse.y;
			image.x += dx;
			image.y += dy;
			reCenterMouse();
		}
		
		mouse.x = e.getX();
		mouse.y = e.getY();
	}

}
