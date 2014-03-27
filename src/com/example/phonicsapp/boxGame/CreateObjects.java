package com.example.phonicsapp.boxGame;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.debug.Debug;

public class CreateObjects 
{

	public static void create(int boxGameMenuLetter)
	{
		Debug.d("BoxMenuLEtter:"+boxGameMenuLetter);
		//Mo
		if(boxGameMenuLetter==1)
		{
			BoxGameActivity.backGround = new Sprite(0, 0, BoxGameActivity.mJungleBackGroundTextureRegion,
					BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			
		}
		//Bo
		else if(boxGameMenuLetter==6)
		{
			BoxGameActivity.backGround = new Sprite(0, 0, BoxGameActivity.mBeachBackGroundTextureRegion,
					BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			
		}
		//Raw
		else if(boxGameMenuLetter==4)
		{
			BoxGameActivity.backGround = new Sprite(0, 0, BoxGameActivity.mUnderWaterBackGroundTextureRegion,
					BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			
		}
		//Toh
		else if(boxGameMenuLetter==19)
		{
			BoxGameActivity.backGround = new Sprite(0, 0, BoxGameActivity.mPlanetBackGroundTextureRegion,
					BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			
		}
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
		BoxGameActivity.obj1.setScale((float) BoxGameActivity.objectScale);
		
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj2);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj2);
		BoxGameActivity.obj2.setScale((float) BoxGameActivity.objectScale);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj3);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj3);
		BoxGameActivity.obj3.setScale((float) BoxGameActivity.objectScale);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj4);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj4);
		BoxGameActivity.obj4.setScale((float) BoxGameActivity.objectScale);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj5);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj5);
		BoxGameActivity.obj5.setScale((float) BoxGameActivity.objectScale);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.obj6);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.obj6);
		BoxGameActivity.obj6.setScale((float) BoxGameActivity.objectScale);
	
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.wrongObj1);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.wrongObj1);
		BoxGameActivity.wrongObj1.setScale((float) BoxGameActivity.objectScale);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.wrongObj2);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.wrongObj2);
		BoxGameActivity.wrongObj2.setScale((float) BoxGameActivity.objectScale);
		
		
		//parrot-letter
		BoxGameActivity.parrotLetter =  new Entity(50,20);
		BoxGameActivity.mScene.attachChild(BoxGameActivity.parrotLetter);
		
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.letter);
		BoxGameActivity.parrotLetter.attachChild(BoxGameActivity.letter);
		
		if(boxGameMenuLetter == 1)
		{
		
			BoxGameActivity.parrot = new Parrot(0,0, 
					BoxGameActivity.mJungleParrotTextureRegion, BoxGameActivity.boxGameActivityInstance.
					getVertexBufferObjectManager());
		}
		else if(boxGameMenuLetter == 6)
		{
			BoxGameActivity.parrot = new Parrot(0,0, 
					BoxGameActivity.mBeachParrotTextureRegion, BoxGameActivity.boxGameActivityInstance.
					getVertexBufferObjectManager());
		}
		else if(boxGameMenuLetter == 4)
		{
			BoxGameActivity.parrot = new Parrot(0,0, 
					BoxGameActivity.mUnderWaterParrotTextureRegion, BoxGameActivity.boxGameActivityInstance.
					getVertexBufferObjectManager());
		}
		else if(boxGameMenuLetter == 19)
		{
			BoxGameActivity.parrot = new Parrot(0,0, 
					BoxGameActivity.mPlanetParrotTextureRegion, BoxGameActivity.boxGameActivityInstance.
					getVertexBufferObjectManager());
		}
		//BoxGameActivity.parrot.animate(new long[]{0, 0, 150, 150}, 0, 3, true);
		BoxGameActivity.parrot.setScale((float) 0.4);
		BoxGameActivity.mScene.registerTouchArea(BoxGameActivity.parrot);
		BoxGameActivity.parrotLetter.attachChild(BoxGameActivity.parrot);
		
				
		Parrot.parrotPath();
	}
}
