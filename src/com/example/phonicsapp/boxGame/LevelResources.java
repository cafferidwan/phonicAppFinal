package com.example.phonicsapp.boxGame;

import com.example.phonicsapp.R;

public class LevelResources
{

	public static void loadObjects(int i) 
	{
		// TODO Auto-generated method stub
		
		//Letter-A
		if(i == 1)
		{
			BoxGameActivity.obj1 = new Objects(BoxGameActivity.obj1X, BoxGameActivity.obj1Y, BoxGameActivity.mA1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj2 = new Objects(BoxGameActivity.obj2X, BoxGameActivity.obj2Y, BoxGameActivity.mA2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj3 = new Objects(BoxGameActivity.obj3X, BoxGameActivity.obj3Y, BoxGameActivity.mA3TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj4 = new Objects(BoxGameActivity.obj4X, BoxGameActivity.obj4Y, BoxGameActivity.mA4TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj5 = new Objects(BoxGameActivity.obj5X, BoxGameActivity.obj5Y, BoxGameActivity.mA5TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj6 = new Objects(BoxGameActivity.obj6X, BoxGameActivity.obj6Y, BoxGameActivity.mA6TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj1 = new Objects(BoxGameActivity.wrongObj1X, BoxGameActivity.wrongObj1Y, BoxGameActivity.mWMo1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj2 = new Objects(BoxGameActivity.wrongObj2X, BoxGameActivity.wrongObj2Y, BoxGameActivity.mWMo2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.letter = new Letter(900, BoxGameActivity.CAMERA_HEIGHT-100, 80, 80, BoxGameActivity.mATextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			
			BoxGameActivity.obj1Sound = R.raw.mula;
			BoxGameActivity.obj2Sound = R.raw.ma;
			BoxGameActivity.obj3Sound = R.raw.mohis;
			BoxGameActivity.obj4Sound = R.raw.megh;
			BoxGameActivity.obj5Sound = R.raw.moi;
			BoxGameActivity.obj6Sound = R.raw.mama;
			BoxGameActivity.wrongObj1Sound = R.raw.kola;
			BoxGameActivity.wrongObj2Sound = R.raw.keram;
			BoxGameActivity.letterSound = R.raw.mo;
		}
		//Letter-Mo
		else if(i == 2)
		{
			BoxGameActivity.obj1 = new Objects(BoxGameActivity.obj1X, BoxGameActivity.obj1Y, BoxGameActivity.mMo1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj2 = new Objects(BoxGameActivity.obj2X, BoxGameActivity.obj2Y, BoxGameActivity.mMo2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj3 = new Objects(BoxGameActivity.obj3X, BoxGameActivity.obj3Y, BoxGameActivity.mMo3TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj4 = new Objects(BoxGameActivity.obj4X, BoxGameActivity.obj4Y, BoxGameActivity.mMo4TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj5 = new Objects(BoxGameActivity.obj5X, BoxGameActivity.obj5Y, BoxGameActivity.mMo5TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj6 = new Objects(BoxGameActivity.obj6X, BoxGameActivity.obj6Y, BoxGameActivity.mMo6TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj1 = new Objects(BoxGameActivity.wrongObj1X, BoxGameActivity.wrongObj1Y, BoxGameActivity.mWMo1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj2 = new Objects(BoxGameActivity.wrongObj2X, BoxGameActivity.wrongObj2Y, BoxGameActivity.mWMo2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.letter = new Letter(900, BoxGameActivity.CAMERA_HEIGHT-100, 80, 80, BoxGameActivity.mMoTextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			
			BoxGameActivity.obj1Sound = R.raw.mula;
			BoxGameActivity.obj2Sound = R.raw.ma;
			BoxGameActivity.obj3Sound = R.raw.mohis;
			BoxGameActivity.obj4Sound = R.raw.megh;
			BoxGameActivity.obj5Sound = R.raw.moi;
			BoxGameActivity.obj6Sound = R.raw.mama;
			BoxGameActivity.wrongObj1Sound = R.raw.kola;
			BoxGameActivity.wrongObj2Sound = R.raw.keram;
			BoxGameActivity.letterSound = R.raw.mo;
		}
		//Letter-Ko
		else if(i == 3)
		{
			BoxGameActivity.obj1 = new Objects(BoxGameActivity.obj1X, BoxGameActivity.obj1Y, BoxGameActivity.mKo1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj2 = new Objects(BoxGameActivity.obj2X, BoxGameActivity.obj2Y, BoxGameActivity.mKo2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj3 = new Objects(BoxGameActivity.obj3X, BoxGameActivity.obj3Y, BoxGameActivity.mKo3TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj4 = new Objects(BoxGameActivity.obj4X, BoxGameActivity.obj4Y, BoxGameActivity.mKo4TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj5 = new Objects(BoxGameActivity.obj5X, BoxGameActivity.obj5Y, BoxGameActivity.mKo5TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj6 = new Objects(BoxGameActivity.obj6X, BoxGameActivity.obj6Y, BoxGameActivity.mKo6TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj1 = new Objects(BoxGameActivity.wrongObj1X, BoxGameActivity.wrongObj1Y, BoxGameActivity.mWKo1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj2 = new Objects(BoxGameActivity.wrongObj2X, BoxGameActivity.wrongObj2Y, BoxGameActivity.mWKo2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.letter = new Letter(900, BoxGameActivity.CAMERA_HEIGHT-100, 80, 80, BoxGameActivity.mKoTextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			
			BoxGameActivity.obj1Sound = R.raw.kola;
			BoxGameActivity.obj2Sound = R.raw.langol;
			BoxGameActivity.obj3Sound = R.raw.mula;
			BoxGameActivity.obj4Sound = R.raw.shorea;
			BoxGameActivity.obj5Sound = R.raw.ma;
			BoxGameActivity.obj6Sound = R.raw.mohis;
			BoxGameActivity.wrongObj1Sound = R.raw.aam;
			BoxGameActivity.wrongObj2Sound = R.raw.keram;
			BoxGameActivity.letterSound = R.raw.akar;
		}

		//Letter-Lo
		else if(i == 4)
		{
			BoxGameActivity.obj1 = new Objects(BoxGameActivity.obj1X, BoxGameActivity.obj1Y, BoxGameActivity.mLo1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj2 = new Objects(BoxGameActivity.obj2X, BoxGameActivity.obj2Y, BoxGameActivity.mLo2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj3 = new Objects(BoxGameActivity.obj3X, BoxGameActivity.obj3Y, BoxGameActivity.mLo3TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj4 = new Objects(BoxGameActivity.obj4X, BoxGameActivity.obj4Y, BoxGameActivity.mLo4TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj5 = new Objects(BoxGameActivity.obj5X, BoxGameActivity.obj5Y, BoxGameActivity.mLo5TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj6 = new Objects(BoxGameActivity.obj6X, BoxGameActivity.obj6Y, BoxGameActivity.mLo6TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj1 = new Objects(BoxGameActivity.wrongObj1X, BoxGameActivity.wrongObj1Y, BoxGameActivity.mWLo1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj2 = new Objects(BoxGameActivity.wrongObj2X, BoxGameActivity.wrongObj2Y, BoxGameActivity.mWLo2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.letter = new Letter(900, BoxGameActivity.CAMERA_HEIGHT-100, 80, 80, BoxGameActivity.mLoTextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
					
			BoxGameActivity.obj1Sound = R.raw.kola;
			BoxGameActivity.obj2Sound = R.raw.langol;
			BoxGameActivity.obj3Sound = R.raw.mula;
			BoxGameActivity.obj4Sound = R.raw.shorea;
			BoxGameActivity.obj5Sound = R.raw.ma;
			BoxGameActivity.obj6Sound = R.raw.mohis;
			BoxGameActivity.wrongObj1Sound = R.raw.aam;
			BoxGameActivity.wrongObj2Sound = R.raw.keram;
			BoxGameActivity.letterSound = R.raw.akar;
		}
		
		//Letter-To
		else if(i == 5)
		{
			BoxGameActivity.obj1 = new Objects(BoxGameActivity.obj1X, BoxGameActivity.obj1Y, BoxGameActivity.mTo1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj2 = new Objects(BoxGameActivity.obj2X, BoxGameActivity.obj2Y, BoxGameActivity.mTo2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj3 = new Objects(BoxGameActivity.obj3X, BoxGameActivity.obj3Y, BoxGameActivity.mTo3TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj4 = new Objects(BoxGameActivity.obj4X, BoxGameActivity.obj4Y, BoxGameActivity.mTo4TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj5 = new Objects(BoxGameActivity.obj5X, BoxGameActivity.obj5Y, BoxGameActivity.mTo5TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.obj6 = new Objects(BoxGameActivity.obj6X, BoxGameActivity.obj6Y, BoxGameActivity.mTo6TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj1 = new Objects(BoxGameActivity.wrongObj1X, BoxGameActivity.wrongObj1Y, BoxGameActivity.mWTo1TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.wrongObj2 = new Objects(BoxGameActivity.wrongObj2X, BoxGameActivity.wrongObj2Y, BoxGameActivity.mWTo2TextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
			BoxGameActivity.letter = new Letter(900, BoxGameActivity.CAMERA_HEIGHT-100, 80, 80, BoxGameActivity.mToTextureRegion, BoxGameActivity.boxGameActivityInstance.getVertexBufferObjectManager());
							
			BoxGameActivity.obj1Sound = R.raw.kola;
			BoxGameActivity.obj2Sound = R.raw.langol;
			BoxGameActivity.obj3Sound = R.raw.mula;
			BoxGameActivity.obj4Sound = R.raw.shorea;
			BoxGameActivity.obj5Sound = R.raw.ma;
			BoxGameActivity.obj6Sound = R.raw.mohis;
			BoxGameActivity.wrongObj1Sound = R.raw.aam;
			BoxGameActivity.wrongObj2Sound = R.raw.keram;
			BoxGameActivity.letterSound = R.raw.akar;
		}
	}
}
