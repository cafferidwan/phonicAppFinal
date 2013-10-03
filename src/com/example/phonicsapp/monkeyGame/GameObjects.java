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

	public static void moi()
	{
		MonkeyGameActivity.moi = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMoi, MonkeyGameActivity.vbo); 
		MonkeyGameActivity.moi.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.moi.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path moiPath = new Path(2).to(-100, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120 ).to(MonkeyGameActivity.CAMERA_WIDTH+20, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120);
		
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
	
	public static void megh()
	{
		MonkeyGameActivity.megh = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionMegh, MonkeyGameActivity.vbo);
		MonkeyGameActivity.megh.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.megh.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path meghPath = new Path(2).to(-100, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120 ).to(MonkeyGameActivity.CAMERA_WIDTH+20, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120);
		
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
	
	public static void mama()
	{
		MonkeyGameActivity.mama = new Sprite(0, 100, MonkeyGameActivity.mFaceTextureRegionMama, MonkeyGameActivity.vbo);
		MonkeyGameActivity.mama.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.mama.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path mamaPath = new Path(2).to(-100, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120 ).to(MonkeyGameActivity.CAMERA_WIDTH+20, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120);
		
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
	
	public static void mohis()
	{
		
		MonkeyGameActivity.mohis = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionMohis, MonkeyGameActivity.vbo);
		MonkeyGameActivity.mohis.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.mohis.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path mohisPath = new Path(2).to(-100, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120 ).to(MonkeyGameActivity.CAMERA_WIDTH+20, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120);
		
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
	
	public static void tala()
	{
		MonkeyGameActivity.tala = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionTala, MonkeyGameActivity.vbo);
		MonkeyGameActivity.tala.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.tala.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path talaPath = new Path(2).to(-100, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120 ).to(MonkeyGameActivity.CAMERA_WIDTH+20, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120);
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
	
	public static void langol()
	{
		MonkeyGameActivity.langol = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionLangol, MonkeyGameActivity.vbo);
		MonkeyGameActivity.langol.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.langol.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path langolPath = new Path(2).to(-100, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120 ).to(MonkeyGameActivity.CAMERA_WIDTH+20, MonkeyGameActivity.CAMERA_HEIGHT/2 - 120);
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
