package game.tutorial.thenewboston;

import java.awt.Image;


public class Sprite 
{
	private Animation a;
	private float x;
	private float y;
	private float vx;
	private float vy;

	//constructor
	public Sprite(Animation ani)
	{
		a = ani;
	}

	//update the position of the sprite
	public void update(long timePassed)
	{
		x += (vx * timePassed);
		y += (vy * timePassed);

		a.update(timePassed);
	}

	//get x position
	public float getX()
	{
		return x;
	}

	//get y position
	public float getY()
	{
		return y;
	}

	//set x position
	public void setX(float xVal)
	{
		x = xVal;
	}

	//set y position
	public void setY(float yVal)
	{
		y = yVal;
	}

	//get sprite height
	public int getHeight()
	{
		return a.getImage().getHeight(null);
	}

	//get sprite width
	public int getWidth()
	{
		return a.getImage().getWidth(null);
	}

	//get horizontal velocity
	public float getXVelocity()
	{
		return vx;
	}

	//get vertical velocity
	public float getYVelocity()
	{
		return vy;
	}

	//change x velocity
	public void setXVelocity(float VX)
	{
		vx = VX;
	}

	//change y velocity
	public void setYVelocity(float VY)
	{
		vy = VY;
	}
	
	//get sprite/image
	public Image getImage()
	{
		return a.getImage();
	}
}

