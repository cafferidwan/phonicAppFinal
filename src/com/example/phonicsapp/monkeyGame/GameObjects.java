package com.example.phonicsapp.monkeyGame;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.debug.Debug;
import org.andengine.util.modifier.ease.EaseSineInOut;

public class GameObjects 
{
	static float ax, ay, bx, by;

	public static void moi(int number)
	{
		if(number == 1)
		{
			ax = -100;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
			
			bx = -100;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
		}
		
		MonkeyGameActivity.moi = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMoi, MonkeyGameActivity.vbo); 
		MonkeyGameActivity.moi.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.moi.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path moiPath = new Path(2).to(ax, ay ).to(bx, by);
		
		MonkeyGameActivity.moi.registerEntityModifier(new PathModifier(4, moiPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.moi);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.moi);
	}
	
	public static void megh(int number)
	{
		if(number == 1)
		{
			ax = -100;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
			
			bx = -100;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
		}
		
		MonkeyGameActivity.megh = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionMegh, MonkeyGameActivity.vbo);
		MonkeyGameActivity.megh.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.megh.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path meghPath = new Path(2).to(ax, ay ).to(bx, by);
		
		MonkeyGameActivity.megh.registerEntityModifier(new PathModifier(4, meghPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity)
			{
				Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity)
			{
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.megh);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.megh);
		
	}
	
	public static void mama(int number)
	{
		if(number == 1)
		{
			ax = -100;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
			
			bx = -100;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
		}
		
		MonkeyGameActivity.mama = new Sprite(0, 100, MonkeyGameActivity.mFaceTextureRegionMama, MonkeyGameActivity.vbo);
		MonkeyGameActivity.mama.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.mama.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path mamaPath = new Path(2).to(ax, ay ).to(bx, by);
		
		MonkeyGameActivity.mama.registerEntityModifier(new PathModifier(4, mamaPath, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity)
			{
				Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.mama);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.mama);
	}
	
	public static void mohis(int number)
	{
		if(number == 1)
		{
			ax = -100;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
			
			bx = -100;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
		}
		
		MonkeyGameActivity.mohis = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionMohis, MonkeyGameActivity.vbo);
		MonkeyGameActivity.mohis.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.mohis.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path mohisPath = new Path(2).to(ax, ay ).to(bx, by);
		
		MonkeyGameActivity.mohis.registerEntityModifier(new PathModifier(4, mohisPath, null, new IPathModifierListener() 
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity)
			{
				Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity)
			{
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.mohis);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.mohis);
	}
	
	public static void tala(int number)
	{
		if(number == 1)
		{
			ax = -100;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
			
			bx = -100;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
		}
		
		MonkeyGameActivity.tala = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionTala, MonkeyGameActivity.vbo);
		MonkeyGameActivity.tala.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.tala.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path talaPath = new Path(2).to(ax, ay ).to(bx, by);
		MonkeyGameActivity.tala.registerEntityModifier(new PathModifier(4, talaPath, null, new IPathModifierListener() 
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity)
			{
				Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.tala);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.tala);
	}
	
	public static void langol(int number)
	{
		if(number == 1)
		{
			ax = -100;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 120;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
			
			bx = -100;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 220;
		}
		
		MonkeyGameActivity.langol = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionLangol, MonkeyGameActivity.vbo);
		MonkeyGameActivity.langol.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.langol.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path langolPath = new Path(2).to(ax, ay ).to(bx, by);
		MonkeyGameActivity.langol.registerEntityModifier(new PathModifier(4, langolPath, null, new IPathModifierListener() 
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.langol);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.langol);
	}
}
