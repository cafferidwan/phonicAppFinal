package com.example.phonicsapp;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

public class MenuPage extends Scene
{
	StartingPage instance;

	public MenuPage()
	{
		setBackground(new Background(0.09804f, 0.6274f, 0));
		
		StartingPage.backGround2 = new Sprite(0, 0, StartingPage.mbackGround2TextureRegion, StartingPage.vertexBufferObjectManager);
		StartingPage.backGround2.setHeight(StartingPage.CAMERA_HEIGHT);
		StartingPage.backGround2.setWidth(StartingPage.CAMERA_WIDTH);
		attachChild(StartingPage.backGround2);
		//instance = StartingPage.getSharedInstances();
		
		
		StartingPage.mo = new Sprite(30, 10, StartingPage.mMoTextureRegion, StartingPage.vertexBufferObjectManager)
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
				case TouchEvent.ACTION_DOWN:
					
					this.setScale((float) 1.2);
				break;
				case TouchEvent.ACTION_UP:
					
					this.setScale((float) 1.0);
				break;
				}

				return true;
			}
		};
		StartingPage.mo.setHeight((float)(StartingPage.CAMERA_HEIGHT/4.5));
		StartingPage.mo.setWidth((float) (StartingPage.CAMERA_WIDTH/8.3));
		registerTouchArea(StartingPage.mo);
		attachChild(StartingPage.mo);
		
	}
	
	
}
