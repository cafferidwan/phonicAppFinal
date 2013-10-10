package com.example.phonicsapp;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

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
		
		
		GameMainPage.mo = new Sprite(GameMainPage.CAMERA_WIDTH/18, GameMainPage.CAMERA_HEIGHT/18, GameMainPage.mMoTextureRegion, GameMainPage.vertexBufferObjectManager)
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
				case TouchEvent.ACTION_DOWN:
					
					this.setScale((float) 1.2);
					
					GameMainPageInstance.startActivity();
					
				break;
				case TouchEvent.ACTION_UP:
					
					this.setScale((float) 1.0);
				break;
				}

				return true;
			}
		};
		GameMainPage.mo.setHeight(GameMainPage.CAMERA_HEIGHT/5);
		GameMainPage.mo.setWidth(GameMainPage.CAMERA_WIDTH/9);
		registerTouchArea(GameMainPage.mo);
		attachChild(GameMainPage.mo);
		
	}
	
	
	
}
