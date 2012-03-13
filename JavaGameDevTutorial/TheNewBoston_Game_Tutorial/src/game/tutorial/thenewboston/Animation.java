package game.tutorial.thenewboston;

import java.awt.Image;
import java.util.ArrayList;

public class Animation 
{
	private ArrayList scenes;
	private int sceneIndex;
	private long movieTime, totalTime;
	
	//CONSTRUCTOR
	public Animation()
	{
		scenes = new ArrayList();
		totalTime = 0;
		start();
	}
	
	//add scene to arraylist and set time for each scene
	public synchronized void addScene(Image i, long time)
	{
		totalTime += time;
		scenes.add(new OneScene(i, totalTime));
	}
	
	//start animation from beginning
	public synchronized void start()
	{
		movieTime = 0;
		sceneIndex = 0;
	}
	
	//change scenes
	public synchronized void update(long timePassed)
	{
		if(scenes.size()>1)
		{
			movieTime += timePassed;
			
			if(movieTime >= totalTime)
			{
				movieTime = 0;
				sceneIndex = 0;
			}
			
			while(movieTime > getScene(sceneIndex).endTime)
			{
				sceneIndex++;
			}
		}
	}

	//get animations current scene (aka image)
	public synchronized Image getImage()
	{
		if(scenes.size()==0)
		{
			return null;
		}
		else
		{
			return getScene(sceneIndex).pic;
		}
	}

	//get scene
	private OneScene getScene(int x) 
	{
		return (OneScene)scenes.get(x);
	}
	
//////////PRIVATE INNER CLASS///////////
	
	private class OneScene
	{
		Image pic;
		long endTime;
		
		public OneScene(Image pic, long endTime)
		{
			this.pic = pic;
			this.endTime = endTime;
		}
	}
}
