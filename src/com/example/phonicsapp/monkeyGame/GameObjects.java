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
	
//	public static void checker()
//	{
//		if(MonkeyGameActivity.moi!=null)
//		{
//			if(MonkeyGameActivity.moi.getX()<0 && MonkeyGameActivity.moi.getX()<MonkeyGameActivity.CAMERA_WIDTH)
//			{
//			Debug.d("moi is there");
//			new Runnable() {
//				public void run() {
//					MonkeyGameActivity.mScene
//							.unregisterTouchArea(MonkeyGameActivity.moi);
//					MonkeyGameActivity.mScene
//							.detachChild(MonkeyGameActivity.moi);
//				}
//			};
//			}
//		}
//		 if(MonkeyGameActivity.mama!=null)
//		{
//		    if(MonkeyGameActivity.mama.getX()<0 && MonkeyGameActivity.mama.getX()<MonkeyGameActivity.CAMERA_WIDTH)
//			{
//			Debug.d("moi is there");
//			new Runnable() {
//				public void run() {
//					MonkeyGameActivity.mScene
//							.unregisterTouchArea(MonkeyGameActivity.mama);
//					MonkeyGameActivity.mScene
//							.detachChild(MonkeyGameActivity.mama);
//				}
//			};
//			}
//		}
//		 if(MonkeyGameActivity.mohis!=null)
//		{
//			if(MonkeyGameActivity.mohis.getX()<0 && MonkeyGameActivity.mohis.getX()<MonkeyGameActivity.CAMERA_WIDTH)
//			{
//			Debug.d("moi is there");
//			new Runnable() {
//				public void run() {
//					MonkeyGameActivity.mScene
//							.unregisterTouchArea(MonkeyGameActivity.mohis);
//					MonkeyGameActivity.mScene
//							.detachChild(MonkeyGameActivity.mohis);
//				}
//			};
//			}
//		}
//		 if(MonkeyGameActivity.megh!=null)
//		{
//			if(MonkeyGameActivity.megh.getX()<0 && MonkeyGameActivity.megh.getX()<MonkeyGameActivity.CAMERA_WIDTH)
//			{
//			Debug.d("moi is there");
//			new Runnable() {
//				public void run() {
//					MonkeyGameActivity.mScene
//							.unregisterTouchArea(MonkeyGameActivity.megh);
//					MonkeyGameActivity.mScene
//							.detachChild(MonkeyGameActivity.megh);
//				}
//			};
//			}
//		}
//		 if(MonkeyGameActivity.tala!=null)
//		{
//			if(MonkeyGameActivity.moi.getX()<0 && MonkeyGameActivity.moi.getX()<MonkeyGameActivity.CAMERA_WIDTH)
//			{
//			Debug.d("moi is there");
//			new Runnable() {
//				public void run() {
//					MonkeyGameActivity.mScene
//							.unregisterTouchArea(MonkeyGameActivity.tala);
//					MonkeyGameActivity.mScene
//							.detachChild(MonkeyGameActivity.tala);
//				}
//			};
//			}
//		}
//		 if(MonkeyGameActivity.langol!=null)
//		{
//			if(MonkeyGameActivity.moi.getX()<0 && MonkeyGameActivity.moi.getX()<MonkeyGameActivity.CAMERA_WIDTH)
//			{
//			Debug.d("moi is there");
//			new Runnable() {
//				public void run() {
//					MonkeyGameActivity.mScene
//							.unregisterTouchArea(MonkeyGameActivity.langol);
//					MonkeyGameActivity.mScene
//							.detachChild(MonkeyGameActivity.langol);
//				}
//			};
//			}
//		}
//	}

	public static void moi(int number)
	{
		if(number == 1)
		{
			ax = -150;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
			
			bx = -150;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
		}
		
		MonkeyGameActivity.moi = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMoi, MonkeyGameActivity.vbo); 
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.moi);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.moi);
		MonkeyGameActivity.moi.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.moi.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path moiPath = new Path(2).to(ax, ay ).to(bx, by);
		
		MonkeyGameActivity.moi.registerEntityModifier(new PathModifier(4, moiPath, null, new IPathModifierListener()
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
				new Runnable() {
					public void run() {
						//Debug.d("onPathFinished");
						MonkeyGameActivity.mScene
								.detachChild(MonkeyGameActivity.moi);
					}
				};
			}
		}, EaseSineInOut.getInstance()));
		
	}
	
	public static void megh(int number)
	{
		if(number == 1)
		{
			ax = -150;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
			
			bx = -150;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
		}
		
		MonkeyGameActivity.megh = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionMegh, MonkeyGameActivity.vbo);
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.megh);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.megh);
		MonkeyGameActivity.megh.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.megh.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path meghPath = new Path(2).to(ax, ay ).to(bx, by);
		
		MonkeyGameActivity.megh.registerEntityModifier(new PathModifier(4, meghPath, null, new IPathModifierListener()
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
				new Runnable() {
					public void run() {
						MonkeyGameActivity.mScene.detachChild(MonkeyGameActivity.megh);
					}
				};
			}
		}, EaseSineInOut.getInstance()));
		
	}
	
	public static void mama(int number)
	{
		if(number == 1)
		{
			ax = -150;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
			
			bx = -150;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
		}
		
		MonkeyGameActivity.mama = new Sprite(0, 150, MonkeyGameActivity.mFaceTextureRegionMama, MonkeyGameActivity.vbo);
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.mama);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.mama);
		MonkeyGameActivity.mama.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.mama.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path mamaPath = new Path(2).to(ax, ay ).to(bx, by);
		
		MonkeyGameActivity.mama.registerEntityModifier(new PathModifier(4, mamaPath, null, new IPathModifierListener()
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
		}, EaseSineInOut.getInstance()));
		new Runnable() {
			public void run() {
				//Debug.d("onPathFinished");
				MonkeyGameActivity.mScene
						.detachChild(MonkeyGameActivity.mama);
			}
		};
	}
	
	public static void mohis(int number)
	{
		if(number == 1)
		{
			ax = -150;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
			
			bx = -150;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
		}
		
		MonkeyGameActivity.mohis = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionMohis, MonkeyGameActivity.vbo);
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.mohis);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.mohis);
		MonkeyGameActivity.mohis.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.mohis.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path mohisPath = new Path(2).to(ax, ay ).to(bx, by);
		
		MonkeyGameActivity.mohis.registerEntityModifier(new PathModifier(4, mohisPath, null, new IPathModifierListener() 
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
				//MonkeyGameActivity.mScene.detachChild(MonkeyGameActivity.mohis);
				new Runnable() {
					public void run() {
						MonkeyGameActivity.mScene.detachChild(MonkeyGameActivity.mohis);
					}
				};
			}
		}, EaseSineInOut.getInstance()));
		
	}
	
	public static void tala(int number)
	{
		if(number == 1)
		{
			ax = -150;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
			
			bx = -150;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
		}
		
		MonkeyGameActivity.tala = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionTala, MonkeyGameActivity.vbo);
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.tala);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.tala);
		MonkeyGameActivity.tala.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.tala.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path talaPath = new Path(2).to(ax, ay ).to(bx, by);
		MonkeyGameActivity.tala.registerEntityModifier(new PathModifier(4, talaPath, null, new IPathModifierListener() 
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
				//MonkeyGameActivity.mScene.detachChild(MonkeyGameActivity.tala);
				new Runnable() {
					public void run() {
						MonkeyGameActivity.mScene.detachChild(MonkeyGameActivity.tala);
					}
				};
			}
		}, EaseSineInOut.getInstance()));
		
	}
	
	public static void langol(int number)
	{
		if(number == 1)
		{
			ax = -150;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
			
			bx = MonkeyGameActivity.CAMERA_WIDTH+20;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 20;
		}
		else if(number == 2)
		{
			ax = MonkeyGameActivity.CAMERA_WIDTH+20;
			ay = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
			
			bx = -150;
			by = MonkeyGameActivity.CAMERA_HEIGHT/2 - 170;
		}
		
		MonkeyGameActivity.langol = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionLangol, MonkeyGameActivity.vbo);
		MonkeyGameActivity.mScene.attachChild(MonkeyGameActivity.langol);
		MonkeyGameActivity.mScene.registerTouchArea(MonkeyGameActivity.langol);
		MonkeyGameActivity.langol.setWidth(MonkeyGameActivity.ImageWidthObjects);
		MonkeyGameActivity.langol.setHeight(MonkeyGameActivity.ImageHeightObjects);
		
		final Path langolPath = new Path(2).to(ax, ay ).to(bx, by);
		MonkeyGameActivity.langol.registerEntityModifier(new PathModifier(4, langolPath, null, new IPathModifierListener() 
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
				//MonkeyGameActivity.mScene.detachChild(MonkeyGameActivity.langol);
				new Runnable() {
					public void run() {
						MonkeyGameActivity.mScene
								.detachChild(MonkeyGameActivity.langol);
					}
				};
			}
		}, EaseSineInOut.getInstance()));
		
	}
}
