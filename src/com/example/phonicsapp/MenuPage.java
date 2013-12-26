package com.example.phonicsapp;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.debug.Debug;

public class MenuPage extends Scene
{
	GameMainPage GameMainPageInstance;

	public MenuPage()
	{
		setBackground(new Background(0.09804f, 0.6274f, 0));
		
		GameMainPage.backGround2 = new Sprite(0, 0, GameMainPage.mbackGround2TextureRegion, GameMainPage.vertexBufferObjectManager);
		GameMainPage.backGround2.setHeight(GameMainPage.CAMERA_HEIGHT);
		GameMainPage.backGround2.setWidth(GameMainPage.CAMERA_WIDTH);
		attachChild(GameMainPage.backGround2);
		GameMainPageInstance = GameMainPage.getSharedInstances();
		//instance = StartingPage.getSharedInstances();
		
		
//		GameMainPage.mo = new Sprite(GameMainPage.CAMERA_WIDTH/18, GameMainPage.CAMERA_HEIGHT/18, GameMainPage.mMoTextureRegion, GameMainPage.vertexBufferObjectManager)
//		{
//			@Override
//			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
//			{
//				switch (pSceneTouchEvent.getAction()) 
//				{
//				case TouchEvent.ACTION_DOWN:
//					
//					this.setScale((float) 1.2);
//					
//					GameMainPageInstance.startActivity();
//					
//				break;
//				case TouchEvent.ACTION_UP:
//					
//					this.setScale((float) 1.0);
//				break;
//				}
//
//				return true;
//			}
//		};
//		GameMainPage.mo.setHeight(GameMainPage.CAMERA_HEIGHT/5);
//		GameMainPage.mo.setWidth(GameMainPage.CAMERA_WIDTH/9);
//		registerTouchArea(GameMainPage.mo);
//		attachChild(GameMainPage.mo);
		
		final Sprite[][] b = new Sprite[100][100];
		
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=3; j++)
			{
				 b[i][j] = new Sprite(GameMainPage.CAMERA_WIDTH/18 -70 +130*i, 
						GameMainPage.CAMERA_HEIGHT/18+-70+120*j, GameMainPage.mMoTextureRegion, 
						GameMainPage.vertexBufferObjectManager)
				{
					@Override
					public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
					{
						switch (pSceneTouchEvent.getAction()) 
						{ 
						case TouchEvent.ACTION_DOWN:
							
							Debug.d("Touch.x:"+(pSceneTouchEvent.getX()));
							Debug.d("Touch.y:"+(pSceneTouchEvent.getY()));
							
							if(pSceneTouchEvent.getX()> b[1][1].getX() &&
									pSceneTouchEvent.getX()-50< b[1][1].getX()+100)
							{
								//b[1][1].setVisible(false);
								Debug.d("b[1][1] touched");
								GameMainPageInstance.startActivity();
							}
							
							if(pSceneTouchEvent.getX() > b[2][1].getX()&&
									pSceneTouchEvent.getX()-50< b[2][1].getX()+100)
							{
								//b[2][1].setVisible(false);
								Debug.d("b[2][1] touched");
							} 
								
							Debug.d("b1.x"+b[1][1].getX());
							Debug.d("b1.y"+b[1][1].getY());
							Debug.d("b2.x"+b[2][1].getX());
							Debug.d("b2.y"+b[2][1].getY());
//							Debug.d("b3.x"+b[3][1].getX());
//							Debug.d("b3.y"+b[3][1].getY());
							
							this.setScale((float) 1.2);
							//GameMainPageInstance.startActivity();
							//Debug.d(k+"Touched");
							
						break;
						case TouchEvent.ACTION_UP:
							
							this.setScale((float) 1.0);
							
						break;
						}
		
						return true;
					}
				};
				registerTouchArea(b[i][j]);
				attachChild(b[i][j]);
			}
		}
	}
}
