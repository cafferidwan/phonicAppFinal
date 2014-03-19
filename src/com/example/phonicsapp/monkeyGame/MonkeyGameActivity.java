package com.example.phonicsapp.monkeyGame;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.IOnAreaTouchListener;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import StatusBarController.StatusBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.Display;

import com.example.phonicsapp.GameMainPage;
import com.example.phonicsapp.R;


public class MonkeyGameActivity  extends SimpleBaseGameActivity implements IOnAreaTouchListener
{
	// ===========================================================
	// Constants
	// ===========================================================
	static MonkeyGameActivity MonkeyGameActivityActivity;
	
	static int CAMERA_WIDTH;
	static int CAMERA_HEIGHT;
	static float distance;
	// ===========================================================
	// Fields
	// ===========================================================
	
	public static BitmapTextureAtlas mBitmapAtlas;
	public static TextureRegion mTexture;
	
	public static Sprite backGround, obj1, obj2, obj3, obj4, wrongObj1, wrongObj2, banana, monkey1, monkey2;
	//obj1-moi, obj2-mama, obj3-megh, obj4-mohis, wrongObj1-tala, wrongObj2-wrongObj2;
	
	public static Camera mCamera;
	public static Scene mScene;
	
	//Fixed Objects monkey1, monkey2, banana;
	public static BitmapTextureAtlas mBitmapTextureAtlasM1, mBitmapTextureAtlasM2;
	public static ITextureRegion mFaceTextureRegionM1, mFaceTextureRegionM2;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasBanana;
	public static ITextureRegion mFaceTextureRegionBanana;
	
	//Letter-A
	public BitmapTextureAtlas mBitmapTextureAtlasA1;
	public BitmapTextureAtlas mBitmapTextureAtlasA2;
	public BitmapTextureAtlas mBitmapTextureAtlasA3;
	public BitmapTextureAtlas mBitmapTextureAtlasA4;
	public BitmapTextureAtlas mBitmapTextureAtlasWA1;
	public BitmapTextureAtlas mBitmapTextureAtlasWA2;
	
	public static ITextureRegion mFaceTextureRegionA1;
	public static ITextureRegion mFaceTextureRegionA2;
	public static ITextureRegion mFaceTextureRegionA3;
	public static ITextureRegion mFaceTextureRegionA4;
	public static ITextureRegion mFaceTextureRegionWA1;
	public static ITextureRegion mFaceTextureRegionWA2;
	
	//Letter-Mo
	public static BitmapTextureAtlas mBitmapTextureAtlasMo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo2;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo3;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo4;
	public static BitmapTextureAtlas mBitmapTextureAtlasWMo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWMo2;
	
	public static ITextureRegion mFaceTextureRegionMo1;
	public static ITextureRegion mFaceTextureRegionMo2;
	public static ITextureRegion mFaceTextureRegionMo3;
	public static ITextureRegion mFaceTextureRegionMo4;
	public static ITextureRegion mFaceTextureRegionWMo1;
	public static ITextureRegion mFaceTextureRegionWMo2;
	
	//Letter-Ko
	public static BitmapTextureAtlas mBitmapTextureAtlasKo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasKo2;
	public static BitmapTextureAtlas mBitmapTextureAtlasKo3;
	public static BitmapTextureAtlas mBitmapTextureAtlasKo4;
	public static BitmapTextureAtlas mBitmapTextureAtlasWKo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWKo2;
		
	public static ITextureRegion mFaceTextureRegionKo1;
	public static ITextureRegion mFaceTextureRegionKo2;
	public static ITextureRegion mFaceTextureRegionKo3;
	public static ITextureRegion mFaceTextureRegionKo4;
	public static ITextureRegion mFaceTextureRegionWKo1;
	public static ITextureRegion mFaceTextureRegionWKo2;
	
	//Letter-Lo
	public static BitmapTextureAtlas mBitmapTextureAtlasLo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasLo2;
	public static BitmapTextureAtlas mBitmapTextureAtlasLo3;
	public static BitmapTextureAtlas mBitmapTextureAtlasLo4;
	public static BitmapTextureAtlas mBitmapTextureAtlasWLo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWLo2;
		
	public static ITextureRegion mFaceTextureRegionLo1;
	public static ITextureRegion mFaceTextureRegionLo2;
	public static ITextureRegion mFaceTextureRegionLo3;
	public static ITextureRegion mFaceTextureRegionLo4;
	public static ITextureRegion mFaceTextureRegionWLo1;
	public static ITextureRegion mFaceTextureRegionWLo2;
	
	//Letter-To
	public static BitmapTextureAtlas mBitmapTextureAtlasTo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasTo2;
	public static BitmapTextureAtlas mBitmapTextureAtlasTo3;
	public static BitmapTextureAtlas mBitmapTextureAtlasTo4;
	public static BitmapTextureAtlas mBitmapTextureAtlasWTo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWTo2;
		
	public static ITextureRegion mFaceTextureRegionTo1;
	public static ITextureRegion mFaceTextureRegionTo2;
	public static ITextureRegion mFaceTextureRegionTo3;
	public static ITextureRegion mFaceTextureRegionTo4;
	public static ITextureRegion mFaceTextureRegionWTo1;
	public static ITextureRegion mFaceTextureRegionWTo2;
	
	
	static float mFaceCount = -100;

	public static int aCount = 0;
	public static int randomItem, randomItem1;
	
	public static Sprite[] position = new Sprite[7];
	
	static float ImageHeight;
	static float ImageWidth;
	
	static float ImageHeightObjects;
	static float ImageWidthObjects;
	
	static int value = 0;
	static int bananaValue = 0;
	
	public static VertexBufferObjectManager vbo;
	static Boolean audioPlay = false;
	static MediaPlayer mediaPlayer = new MediaPlayer();
	static int obj1Sound, obj2Sound, obj3Sound, obj4Sound, wrongObj1Sound, wrongObj2Sound;
	
	public static TimerHandler timer1, timer2;
	public static int monkeyGameLevelSelector;
	
	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	
	@Override
	public EngineOptions onCreateEngineOptions() 
	{
		MonkeyGameActivityActivity = this;
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HEIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();
		
		ImageHeight = CAMERA_HEIGHT/1.1f;
		ImageWidth = CAMERA_WIDTH/6.0f;
		
		ImageHeightObjects = CAMERA_HEIGHT/5.0f;
		ImageWidthObjects = CAMERA_WIDTH/7.5f;
		
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	}

	@Override
	public void onCreateResources() 
	{
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("MonkeyGameGfx/");
		
		mBitmapAtlas = new BitmapTextureAtlas(getTextureManager(), 1600, 868,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mTexture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapAtlas, getAssets(), "bg-3.png", 0, 0);

		//Letter-A
		mBitmapTextureAtlasA1 = new BitmapTextureAtlas(getTextureManager(), 120, 120, TextureOptions.BILINEAR);
		mBitmapTextureAtlasA2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasA3 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasA4 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasWA1 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasWA2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
				
		mFaceTextureRegionA1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasA1, this, "LetterA/keramBoard1.png", 0, 0);
		mFaceTextureRegionA2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasA2, this, "LetterA/mas.png",0,0);
		mFaceTextureRegionA3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasA3, this, "LetterA/mula-2.png",0,0);
		mFaceTextureRegionA4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasA4, this, "LetterA/mohis-2.png",0,0);
		mFaceTextureRegionWA1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWA1, this, "LetterA/ma.png",0,0);
		mFaceTextureRegionWA2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWA2, this, "LetterA/pineapple.png",0,0);
				
		//Letter-Mo
		mBitmapTextureAtlasMo1 = new BitmapTextureAtlas(getTextureManager(), 120, 120, TextureOptions.BILINEAR);
		mBitmapTextureAtlasMo2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasMo3 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasMo4 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasWMo1 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasWMo2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		
		mFaceTextureRegionMo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo1, this, "LetterMo/moi-2.png", 0, 0);
		mFaceTextureRegionMo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo2, this, "LetterMo/mama-2.png",0,0);
		mFaceTextureRegionMo3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo3, this, "LetterMo/megh.png",0,0);
		mFaceTextureRegionMo4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo4, this, "LetterMo/mohis-2.png",0,0);
		mFaceTextureRegionWMo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWMo1, this, "LetterMo/tala.png",0,0);
		mFaceTextureRegionWMo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWMo2, this, "LetterMo/langol.png",0,0);
		
		//Letter-Ko
		mBitmapTextureAtlasKo1 = new BitmapTextureAtlas(getTextureManager(), 120, 120, TextureOptions.BILINEAR);
		mBitmapTextureAtlasKo2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasKo3 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasKo4 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasWKo1 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasWKo2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
				
		mFaceTextureRegionKo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasKo1, this, "LetterKo/moi-2.png", 0, 0);
		mFaceTextureRegionKo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasKo2, this, "LetterKo/mama-2.png",0,0);
		mFaceTextureRegionKo3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasKo3, this, "LetterKo/megh.png",0,0);
		mFaceTextureRegionKo4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasKo4, this, "LetterKo/mohis-2.png",0,0);
		mFaceTextureRegionWKo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWKo1, this, "LetterKo/tala.png",0,0);
		mFaceTextureRegionWKo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWKo2, this, "LetterKo/langol.png",0,0);
				
		//Letter-Lo
		mBitmapTextureAtlasLo1 = new BitmapTextureAtlas(getTextureManager(), 120, 120, TextureOptions.BILINEAR);
		mBitmapTextureAtlasLo2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasLo3 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasLo4 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasWLo1 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasWLo2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
						
		mFaceTextureRegionLo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasLo1, this, "LetterLo/moi-2.png", 0, 0);
		mFaceTextureRegionLo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasLo2, this, "LetterLo/mama-2.png",0,0);
		mFaceTextureRegionLo3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasLo3, this, "LetterLo/megh.png",0,0);
		mFaceTextureRegionLo4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasLo4, this, "LetterLo/mohis-2.png",0,0);
		mFaceTextureRegionWLo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWLo1, this, "LetterLo/tala.png",0,0);
		mFaceTextureRegionWLo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWLo2, this, "LetterLo/langol.png",0,0);
						
		//Letter-To
		mBitmapTextureAtlasTo1 = new BitmapTextureAtlas(getTextureManager(), 120, 120, TextureOptions.BILINEAR);
		mBitmapTextureAtlasTo2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasTo3 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasTo4 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasWTo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasWTo2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
								
		mFaceTextureRegionTo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTo1, this, "LetterTo/keramBoard1.png", 0, 0);
		mFaceTextureRegionTo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTo2, this, "LetterTo/mas.png",0,0);
		mFaceTextureRegionTo3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTo3, this, "LetterTo/mula-2.png",0,0);
		mFaceTextureRegionTo4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTo4, this, "LetterTo/mohis-2.png",0,0);
		mFaceTextureRegionWTo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWTo1, this, "LetterTo/ma.png",0,0);
		mFaceTextureRegionWTo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWTo2, this, "LetterTo/pineapple.png",0,0);			
		
		//Fixed Objects- monkey1, monkey2, banana
		mBitmapTextureAtlasM1 = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasM2 = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasBanana = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		
		mFaceTextureRegionM1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasM1, this, "m4.png",0,0);
		mFaceTextureRegionM2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasM2, this, "m3.png",0,0);
		mFaceTextureRegionBanana = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBanana, this, "banana-1.png",0,0);
		
		
		mBitmapAtlas.load();
		
		//Letter-A
		mBitmapTextureAtlasA1.load();
		mBitmapTextureAtlasA2.load();
		mBitmapTextureAtlasA3.load();
		mBitmapTextureAtlasA4.load();
		mBitmapTextureAtlasWA1.load();
		mBitmapTextureAtlasWA2.load();
		
		//Letter-Mo
		mBitmapTextureAtlasMo1.load();
		mBitmapTextureAtlasMo2.load();
		mBitmapTextureAtlasMo3.load();
		mBitmapTextureAtlasMo4.load();
		mBitmapTextureAtlasWMo1.load();
		mBitmapTextureAtlasWMo2.load();
		
		//Letter-Ko
		mBitmapTextureAtlasKo1.load();
		mBitmapTextureAtlasKo2.load();
		mBitmapTextureAtlasKo3.load();
		mBitmapTextureAtlasKo4.load();
		mBitmapTextureAtlasWKo1.load();
		mBitmapTextureAtlasWKo2.load();
		
		//Letter-Lo
		mBitmapTextureAtlasLo1.load();
		mBitmapTextureAtlasLo2.load();
		mBitmapTextureAtlasLo3.load();
		mBitmapTextureAtlasLo4.load();
		mBitmapTextureAtlasWLo1.load();
		mBitmapTextureAtlasWLo2.load();
		
		//Letter-To
		mBitmapTextureAtlasTo1.load();
		mBitmapTextureAtlasTo2.load();
		mBitmapTextureAtlasTo3.load();
		mBitmapTextureAtlasTo4.load();
		mBitmapTextureAtlasWTo1.load();
		mBitmapTextureAtlasWTo2.load();
		
		//Fixed Objects monkey1, monkey2, banana;
		mBitmapTextureAtlasBanana.load();
		mBitmapTextureAtlasM1.load();
		mBitmapTextureAtlasM2.load();
		
	}
	
	@Override
	public void onBackPressed()
	{
	    new AlertDialog.Builder(this)
	        .setTitle("Really Exit?")
	        .setMessage("Are you sure you want to exit?")
	        .setNegativeButton(android.R.string.no, null)
	        .setPositiveButton(android.R.string.yes, new OnClickListener()
	        {

	            public void onClick(DialogInterface arg0, int arg1) 
	            {
	            	aCount = 0;
					mFaceCount = -100; 
	                MonkeyGameActivity.super.onBackPressed();
	            }
	        }).create().show();
	}
	
	@Override
	public Scene onCreateScene() 
	{
		/* Just a simple */
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));
		vbo = getVertexBufferObjectManager();

		//debug mode
		//RootTools.debugMode = true; 
		StatusBar.showStatusBar();
				
		backGround = new Sprite(0, 0, mTexture,getVertexBufferObjectManager());
		backGround.setWidth(CAMERA_WIDTH);
		backGround.setHeight(CAMERA_HEIGHT);
		mScene.attachChild(backGround);
		
//		MonkeyGameActivity.monkeyGameLevelSelector = 2;
		
		mScene.registerUpdateHandler(new TimerHandler(1, true, new ITimerCallback()
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) 
			{
				// TODO Auto-generated method stub
				
				if(value == 1)
				{
					MonkeyFunction.monkey1();
				}
			}
		}));
		 
		mScene.registerUpdateHandler(new TimerHandler(3, true, new ITimerCallback() 
		{
			
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				// TODO Auto-generated method stub
				//Adding Banana
				if(bananaValue == 1)
				{
					MonkeyFunction.addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
				}
			}
		}));
		
		MonkeyGameTimerHandlers.selectRandromObjects();
		
		mScene.setOnAreaTouchListener(this);
		return mScene;
	}

	
	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,ITouchArea pTouchArea, float pTouchAreaLocalX,float pTouchAreaLocalY) 
	{
		// TODO Auto-generated method stub
		
		if (pSceneTouchEvent.isActionDown()) 
		{
			ObjectRemoveFunctions.removeFace((Sprite) pTouchArea);
			return true;
		}
		return false;
	}

	

	public static void startActivity()
	{
		if(monkeyGameLevelSelector == 0)
		{
			monkeyGameLevelSelector = 1;
			MonkeyGameActivityActivity.finish();
			MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, MonkeyGameActivity.class));
		}
		else if(monkeyGameLevelSelector == 1)
		{
			monkeyGameLevelSelector = 0;
			MonkeyGameActivityActivity.finish();
			MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, GameMainPage.class));

		}
	}
	
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}