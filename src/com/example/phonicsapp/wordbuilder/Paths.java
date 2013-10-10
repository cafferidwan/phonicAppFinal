package com.example.phonicsapp.wordbuilder;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

public class Paths 
{
	public static int x1 = -20;
	public static int x2 = +20;
	
	public static int ax1 = -100;
	public static int ax2 = +100;
	
	public static void setPosition(Sprite a, int ax, Sprite b, TouchEvent pSceneTouchEvent)
	{
		a.setPosition(pSceneTouchEvent.getX() - a.getWidth() / 2, 
				pSceneTouchEvent.getY() - a.getHeight() / 2);
				
		b.setPosition(pSceneTouchEvent.getX()+ax - b.getWidth() / 2, pSceneTouchEvent.getY() - 
									b.getHeight() / 2);
	}
	
	//splitting function
	public static void split(Sprite a,int x1, Sprite b, int x2)
	{
		final Path splitPath = new Path(2).to(a.getX(), a.getY())
				.to(a.getX()+x1, a.getY());
	
		a.registerEntityModifier(new PathModifier((float)0.3, splitPath, null, new IPathModifierListener() 
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				//Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
		
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) {
				//Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{

			}
		}));
		
		final Path moPath = new Path(2).to(b.getX(), b.getY())
				.to(b.getX()+x2, b.getY());
	
		b.registerEntityModifier(new PathModifier((float)0.3, moPath, null, new IPathModifierListener() 
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				//Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				//Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{

			}
		}));
	}
	//Paths after using scissor and splitting the words
	public static void splitPath()
	{
		//Splitting for 'akar' and 'mo'
		if(MainActivity.count1 == 1)
		{
			split(MainActivity.akar, x1, MainActivity.mo, x2);
		}
		//Splitting for 'mo' and 'akar'
		else if(MainActivity.count2 == 1)
		{
			split(MainActivity.akar, x2, MainActivity.mo, x1);
		}
		//Splitting for 'mo' and 'akar'
		else if(MainActivity.count3 == 1)
		{
			split(MainActivity.shorea, x1, MainActivity.mo, x2);
		}
		//Splitting for 'mo' and 'akar'
		else if(MainActivity.count4 == 1)
		{
			split(MainActivity.shorea, x2, MainActivity.mo, x1);	
		}
		//Splitting for 'shorea' and 'akar'
		else if(MainActivity.count5 == 1)
		{
			split(MainActivity.shorea, x1, MainActivity.akar, x2);
		}
		//Splitting for 'shorea' and 'akar'
		else if(MainActivity.count6 == 1)
		{
			split(MainActivity.shorea, x2, MainActivity.akar, x1);	
		}
		
	}
	
	//Scissor Paths
	public static void scissorPath()
	{
		final Path scissorPath = new Path(2).to(MainActivity.Scissor.getX(), MainActivity.Scissor.getY())
				.to(MainActivity.CAMERA_WIDTH - MainActivity.CAMERA_WIDTH/5, MainActivity.CAMERA_HEIGHT - MainActivity.CAMERA_HEIGHT/4);
		
		MainActivity.Scissor.registerEntityModifier(new PathModifier((float)0.2, scissorPath, null, new IPathModifierListener() {
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) {
				//Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
			
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) {
				//Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				MainActivity.count1 = 0;
				MainActivity.count2 = 0;
				MainActivity.count3 = 0;
				MainActivity.count4 = 0;
				MainActivity.count5 = 0;
				MainActivity.count6 = 0;
				MainActivity.count7 = 0;
				MainActivity.count8 = 0;
			}
		}));
	}
	
}
