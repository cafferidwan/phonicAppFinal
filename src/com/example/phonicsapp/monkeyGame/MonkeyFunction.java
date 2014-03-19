package com.example.phonicsapp.monkeyGame;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.modifier.ease.EaseSineInOut;

public class MonkeyFunction 
{

	public static void addFace(final float pX, final float pY) 
	{
		MonkeyGameActivity.distance = (float) (MonkeyGameActivity.CAMERA_WIDTH/5.3 );
		MonkeyGameActivity.mFaceCount = MonkeyGameActivity.mFaceCount+MonkeyGameActivity.distance;
		MonkeyGameActivity.aCount = MonkeyGameActivity.aCount+1;
		MonkeyGameActivity.bananaValue = 0;
		
		//if 5 banana is added then game over
		if(MonkeyGameActivity.aCount==5)
		{

			MonkeyGameActivity.mScene.clearUpdateHandlers();
			MonkeyGameActivity.mScene.clearEntityModifiers();
			MonkeyGameActivity.mScene.clearTouchAreas();
			MonkeyGameActivity.mScene.clearChildScene();
			//Finishing the game
			MonkeyGameActivity.mScene.registerUpdateHandler(new TimerHandler(2, new ITimerCallback() 
			{
				
				@Override
				public void onTimePassed(TimerHandler pTimerHandler)
				{
					// TODO Auto-generated method stub
					MonkeyGameActivity.aCount = 0;
					MonkeyGameActivity.mFaceCount = -100;
					MonkeyGameActivity.startActivity();
				}
			}));
		}
			MonkeyGameActivity.position[MonkeyGameActivity.aCount] = new Sprite(0, 50 , MonkeyGameActivity.mFaceTextureRegionBanana,MonkeyGameActivity.vbo); 
			MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.position[MonkeyGameActivity.aCount]);
			MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.position[MonkeyGameActivity.aCount]);
			
			MonkeyGameActivity.position[MonkeyGameActivity.aCount].setWidth(MonkeyGameActivity.ImageWidthObjects-22);
			MonkeyGameActivity.position[MonkeyGameActivity.aCount].setHeight(MonkeyGameActivity.ImageHeightObjects-22);
			
			final Path bananaPath = new Path(2).to(MonkeyGameActivity.CAMERA_WIDTH/2, -100).to(MonkeyGameActivity.mFaceCount, MonkeyGameActivity.CAMERA_HEIGHT - MonkeyGameActivity.CAMERA_HEIGHT/3 + 30 );
			
			MonkeyGameActivity.position[MonkeyGameActivity.aCount].registerEntityModifier(new PathModifier((float) 1, bananaPath, null, new IPathModifierListener() 
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
					//Debug.d("onPathFinished");
					
				}
			}, EaseSineInOut.getInstance()));
		}

	public static void monkey1()
	{
		MonkeyGameActivity.monkey1 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionM1, MonkeyGameActivity.vbo);
		MonkeyGameActivity.monkey1.setWidth(MonkeyGameActivity.ImageWidth);
		MonkeyGameActivity.monkey1.setHeight(MonkeyGameActivity.ImageHeight);
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.monkey1);
		MonkeyGameActivity.monkey1.setVisible(true);
		
		MonkeyGameActivity.value = 0;
		
		final Path monkey1Path = new Path(2).to(MonkeyGameActivity.CAMERA_WIDTH/2,-400).to(MonkeyGameActivity.position[MonkeyGameActivity.aCount].getX(),(float) (MonkeyGameActivity.position[MonkeyGameActivity.aCount].getY()-MonkeyGameActivity.CAMERA_HEIGHT/1.4)); 
		MonkeyGameActivity.monkey1.registerEntityModifier(new PathModifier((float) 1.1, monkey1Path, null, new IPathModifierListener() 
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
				//Debug.d("onPathFinished");
				MonkeyGameActivity.monkey1.setVisible(false);
				MonkeyGameActivity.mFaceCount=MonkeyGameActivity.mFaceCount-MonkeyGameActivity.distance;
				
				monkey2();
			}
		}, EaseSineInOut.getInstance()));
	}
	
	public static void monkey2()
	{
		MonkeyGameActivity.monkey2 = new Sprite(MonkeyGameActivity.position[MonkeyGameActivity.aCount].getX(), (float) (MonkeyGameActivity.position[MonkeyGameActivity.aCount].getY()-MonkeyGameActivity.CAMERA_HEIGHT/1.4), MonkeyGameActivity.mFaceTextureRegionM2, MonkeyGameActivity.vbo);
		MonkeyGameActivity.monkey2.setWidth(MonkeyGameActivity.ImageWidth);
		MonkeyGameActivity.monkey2.setHeight(MonkeyGameActivity.ImageHeight);
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.monkey2);
		
		final Path monkey2Path = new Path(2).to(MonkeyGameActivity.position[MonkeyGameActivity.aCount].getX(),(float) (MonkeyGameActivity.position[MonkeyGameActivity.aCount].getY()-MonkeyGameActivity.CAMERA_HEIGHT/1.4)).to(MonkeyGameActivity.CAMERA_WIDTH/2,-600);
		MonkeyGameActivity.monkey2.registerEntityModifier(new PathModifier((float)1.1, monkey2Path, null, new IPathModifierListener()
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
				//Debug.d("onPathFinished");
				MonkeyGameActivity.monkey2.setVisible(false);
			}
		}, EaseSineInOut.getInstance()));
		
		MonkeyGameActivity.mScene.detachChild(MonkeyGameActivity.position[MonkeyGameActivity.aCount]);
		MonkeyGameActivity.position[MonkeyGameActivity.aCount]=null;
		MonkeyGameActivity.aCount = MonkeyGameActivity.aCount - 1;
	}
}
