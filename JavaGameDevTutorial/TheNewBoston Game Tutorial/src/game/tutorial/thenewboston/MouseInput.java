package game.tutorial.thenewboston;

import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseInput extends Core implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener
{
	
	private String mess = "";
	
	public static void main(String[] args)
	{
		new MouseInput().run();
	}
	
	public void init()
	{
		super.init();
		Window w = s.returnFullScreenWindow();
		w.addMouseListener(this);
		w.addMouseMotionListener(this);
		w.addMouseWheelListener(this);
		w.addKeyListener(this);
		
		mess = "";
	}

	@Override
	public synchronized void paint(Graphics2D g) 
	{
		Window w = s.returnFullScreenWindow();
		
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, s.getWidth()/2, s.getHeight()/2);
	}

	///////mouse listeners////////
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		mess = "Mouse wheel active";
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		mess = "You pressed down the mouse";
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		mess = "You released the mouse";
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		mess = "You are draggin the mouse";
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		mess = "You are moving the mouse with out dragging";
	}

	@Override//when user presses a key on the keyboard down
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_ESCAPE)
		{
			stop();
		}
		else
		{
			mess = "Pressed:" + KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}

	@Override//on release of keyboard key
	public void keyReleased(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		
		mess = "Relased:" + KeyEvent.getKeyText(keyCode);
		e.consume();
	}

	@Override//not used for anything in this game/tutorial
	public void keyTyped(KeyEvent e) {e.consume();}

	@Override
	public void mouseClicked(MouseEvent e) 
	{/*unused*/}

	@Override
	public void mouseEntered(MouseEvent e) 
	{/*used when mouse enters screen -- unused in full screen*/}

	@Override
	public void mouseExited(MouseEvent e) 
	{/*used when mouse exits screen* -- unused in full screen*/}

}
