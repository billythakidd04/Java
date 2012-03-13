package game.tutorial.thenewboston;

import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTest extends Core implements KeyListener
{
	
	private String message = "";
	
	public static void main(String[] args)
	{
		new KeyTest().run();
	}
	
	public void init()
	{
		super.init();
		Window w = s.returnFullScreenWindow();
		w.setFocusTraversalKeysEnabled(false);
		w.addKeyListener(this);
		
		message = "Press Esc to exit";
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
			message = "Pressed:" + KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}

	@Override//on release of keyboard key
	public void keyReleased(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		
		message = "Relased:" + KeyEvent.getKeyText(keyCode);
		e.consume();
	}

	@Override//not used for anything in this game/tutorial
	public void keyTyped(KeyEvent e) {e.consume();}

	@Override
	public synchronized void paint(Graphics2D g) 
	{
		Window w = s.returnFullScreenWindow();
		
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(message, s.getWidth()/2, s.getHeight()/2);
	}

	
	
}
