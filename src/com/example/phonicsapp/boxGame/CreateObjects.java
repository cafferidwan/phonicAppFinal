package com.example.phonicsapp.boxGame;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;

public class CreateObjects 
{

	public static void create()
	{
		BoxGameActivity.backGround = new Sprite(0, 0, BoxGameActivity.mbackGroundTextureRegion,
				BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
		BoxGameActivity.backGround.setHeight(BoxGameActivity.CAMERA_HEIGHT);
		BoxGameActivity.backGround.setWidth(BoxGameActivity.CAMERA_WIDTH);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.backGround);
		
		BoxGameActivity.openedBox = new Sprite(BoxGameActivity.CAMERA_WIDTH/2-100, BoxGameActivity.CAMERA_HEIGHT/2, 
				BoxGameActivity.mBox1TextureRegion,  BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
		BoxGameActivity.mScene.attachChild(BoxGameActivity.openedBox);
		BoxGameActivity.openedBox.setVisible(false);
		
		//closed box
		BoxGameActivity.closedBox = new Sprite(BoxGameActivity.CAMERA_WIDTH/2-100, BoxGameActivity.CAMERA_HEIGHT/2, 
				BoxGameActivity.mBox2TextureRegion,  BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
		BoxGameActivity.mScene.attachChild(BoxGameActivity.closedBox);
		BoxGameActivity.closedBox.setVisible(true);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj1);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj1);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj2);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj2);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj3);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj3);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj4);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj4);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj5);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj5);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj6);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj6);
	
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.wrongObj1);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.wrongObj1);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.wrongObj2);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.wrongObj2);
		
		
		//parrot-letter
		BoxGameActivity.parrotLetter =  new Entity(50,20);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.parrotLetter);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.letter);
		BoxGameActivity.parrotLetter.attachChild(BoxGameActivity.letter);
		
		BoxGameActivity.parrot = new Parrot(0,0, 
				BoxGameActivity.mParrotTextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
		//BoxGameActivity.parrot.animate(new long[]{0, 0, 150, 150}, 0, 3, true);
		BoxGameActivity.parrot.setScale((float) 0.4);
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.parrot);
		BoxGameActivity.parrotLetter.attachChild(BoxGameActivity.parrot);
		
				
		Parrot.parrotPath();
	}
}
