package com.example.phonicsapp.monkeyGame;

import org.andengine.entity.sprite.Sprite;

import com.example.phonicsapp.R;

public class MonkeyGameLevelResources
{

	public static void LoadObjects(int i) 
	{
		// TODO Auto-generated method stub
		if(i == 1)
		{
			MonkeyGameActivity.obj1 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionA1, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj2 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionA2, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj3 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionA3, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj4 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionA4, MonkeyGameActivity.vbo);
		
			MonkeyGameActivity.wrongObj1 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWA1, MonkeyGameActivity.vbo);	
			MonkeyGameActivity.wrongObj2 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWA2, MonkeyGameActivity.vbo);
			
			MonkeyGameActivity.obj1Sound = R.raw.mo;
			MonkeyGameActivity.obj2Sound = R.raw.mula;
			MonkeyGameActivity.obj3Sound = R.raw.megh;
			MonkeyGameActivity.obj4Sound = R.raw.mohis;
			
			MonkeyGameActivity.wrongObj1Sound = R.raw.akar;
			MonkeyGameActivity.wrongObj2Sound = R.raw.aam;
			
		}
		else if(i == 2)
		{
			MonkeyGameActivity.obj1 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMo1, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj2 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMo2, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj3 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMo3, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj4 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMo4, MonkeyGameActivity.vbo);
		
			MonkeyGameActivity.wrongObj1 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWMo1, MonkeyGameActivity.vbo);	
			MonkeyGameActivity.wrongObj2 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWMo2, MonkeyGameActivity.vbo);
			
			MonkeyGameActivity.obj1Sound = R.raw.moi;
			MonkeyGameActivity.obj2Sound = R.raw.mama;
			MonkeyGameActivity.obj3Sound = R.raw.megh;
			MonkeyGameActivity.obj4Sound = R.raw.mohis;
			
			MonkeyGameActivity.wrongObj1Sound = R.raw.tala;
			MonkeyGameActivity.wrongObj2Sound = R.raw.langol;
		}
		//Letter-Ko
		else if(i == 3)
		{
			MonkeyGameActivity.obj1 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionKo1, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj2 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionKo2, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj3 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionKo3, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj4 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionKo4, MonkeyGameActivity.vbo);
		
			MonkeyGameActivity.wrongObj1 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWKo1, MonkeyGameActivity.vbo);	
			MonkeyGameActivity.wrongObj2 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWKo2, MonkeyGameActivity.vbo);
			
			MonkeyGameActivity.obj1Sound = R.raw.moi;
			MonkeyGameActivity.obj2Sound = R.raw.mama;
			MonkeyGameActivity.obj3Sound = R.raw.megh;
			MonkeyGameActivity.obj4Sound = R.raw.mohis;
			
			MonkeyGameActivity.wrongObj1Sound = R.raw.tala;
			MonkeyGameActivity.wrongObj2Sound = R.raw.langol;
		}
		//Letter-Lo
		else if(i == 4)
		{
			MonkeyGameActivity.obj1 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionLo1, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj2 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionLo2, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj3 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionLo3, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj4 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionLo4, MonkeyGameActivity.vbo);
				
			MonkeyGameActivity.wrongObj1 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWLo1, MonkeyGameActivity.vbo);	
			MonkeyGameActivity.wrongObj2 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWLo2, MonkeyGameActivity.vbo);
				
			MonkeyGameActivity.obj1Sound = R.raw.moi;
			MonkeyGameActivity.obj2Sound = R.raw.mama;
			MonkeyGameActivity.obj3Sound = R.raw.megh;
			MonkeyGameActivity.obj4Sound = R.raw.mohis;
					
			MonkeyGameActivity.wrongObj1Sound = R.raw.tala;
			MonkeyGameActivity.wrongObj2Sound = R.raw.langol;
		}
		//Letter-To
		else if(i == 5)
		{
			MonkeyGameActivity.obj1 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionTo1, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj2 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionTo2, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj3 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionTo3, MonkeyGameActivity.vbo);
			MonkeyGameActivity.obj4 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionTo4, MonkeyGameActivity.vbo);
				
			MonkeyGameActivity.wrongObj1 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWTo1, MonkeyGameActivity.vbo);	
			MonkeyGameActivity.wrongObj2 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionWTo2, MonkeyGameActivity.vbo);
					
			MonkeyGameActivity.obj1Sound = R.raw.moi;
			MonkeyGameActivity.obj2Sound = R.raw.mama;
			MonkeyGameActivity.obj3Sound = R.raw.megh;
			MonkeyGameActivity.obj4Sound = R.raw.mohis;
					
			MonkeyGameActivity.wrongObj1Sound = R.raw.tala;
			MonkeyGameActivity.wrongObj2Sound = R.raw.langol;
		}
	}

}
