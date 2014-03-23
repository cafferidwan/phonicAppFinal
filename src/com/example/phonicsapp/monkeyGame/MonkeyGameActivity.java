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
import com.example.phonicsapp.Menu;
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
	
	//Letter-Bo
	public BitmapTextureAtlas mBitmapTextureAtlasBo1;
	public BitmapTextureAtlas mBitmapTextureAtlasBo2;
	public BitmapTextureAtlas mBitmapTextureAtlasBo3;
	public BitmapTextureAtlas mBitmapTextureAtlasBo4;
	public BitmapTextureAtlas mBitmapTextureAtlasWBo1;
	public BitmapTextureAtlas mBitmapTextureAtlasWBo2;
	
	public static ITextureRegion mFaceTextureRegionBo1;
	public static ITextureRegion mFaceTextureRegionBo2;
	public static ITextureRegion mFaceTextureRegionBo3;
	public static ITextureRegion mFaceTextureRegionBo4;
	public static ITextureRegion mFaceTextureRegionWA1;
	public static ITextureRegion mFaceTextureRegionWA2;
	
	//Letter-Ko
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw1;
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw2;
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw3;
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw4;
	public static BitmapTextureAtlas mBitmapTextureAtlasWRaw1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWRaw2;
		
	public static ITextureRegion mFaceTextureRegionRaw1;
	public static ITextureRegion mFaceTextureRegionRaw2;
	public static ITextureRegion mFaceTextureRegionRaw3;
	public static ITextureRegion mFaceTextureRegionRaw4;
	public static ITextureRegion mFaceTextureRegionWRaw1;
	public static ITextureRegion mFaceTextureRegionWRaw2;
	
	//Letter-Lo
	public static BitmapTextureAtlas mBitmapTextureAtlasToh1;
	public static BitmapTextureAtlas mBitmapTextureAtlasToh2;
	public static BitmapTextureAtlas mBitmapTextureAtlasToh3;
	public static BitmapTextureAtlas mBitmapTextureAtlasToh4;
	public static BitmapTextureAtlas mBitmapTextureAtlasWToh1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWToh2;
		
	public static ITextureRegion mFaceTextureRegionToh1;
	public static ITextureRegion mFaceTextureRegionToh2;
	public static ITextureRegion mFaceTextureRegionToh3;
	public static ITextureRegion mFaceTextureRegionToh4;
	public static ITextureRegion mFaceTextureRegionWToh1;
	public static ITextureRegion mFaceTextureRegionWToh2;
	
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
	public static int monkeyGameMenuLetterSelector;
	
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

		//Letter-Mo
		mBitmapTextureAtlasMo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasMo2 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasMo3 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasMo4 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasWMo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasWMo2 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		
		mFaceTextureRegionMo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo1, this, "LetterMo/moi-2.png", 0, 0);
		mFaceTextureRegionMo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo2, this, "LetterMo/mama-2.png",0,0);
		mFaceTextureRegionMo3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo3, this, "LetterMo/megh.png",0,0);
		mFaceTextureRegionMo4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo4, this, "LetterMo/mohis-2.png",0,0);
		mFaceTextureRegionWMo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWMo1, this, "LetterMo/tala.png",0,0);
		mFaceTextureRegionWMo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWMo2, this, "LetterMo/langol.png",0,0);
		
		//Letter-Bo
		mBitmapTextureAtlasBo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasBo2 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasBo3 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasBo4 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasWBo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasWBo2 = new BitmapTextureAtlas(getTextureManager(), 200, 110);
						
		mFaceTextureRegionBo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBo1, this, "LetterBo/balish.png", 0, 0);
		mFaceTextureRegionBo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBo2, this, "LetterBo/boi.png",0,0);
		mFaceTextureRegionBo3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBo3, this, "LetterBo/ballon.png",0,0);
		mFaceTextureRegionBo4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBo4, this, "LetterBo/brinjal.png",0,0);
		mFaceTextureRegionWA1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWBo1, this, "LetterBo/taka.png",0,0);
		mFaceTextureRegionWA2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWBo2, this, "LetterBo/megh.png",0,0);

		//Letter-Raw
		mBitmapTextureAtlasRaw1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasRaw2 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasRaw3 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasRaw4 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasWRaw1 = new BitmapTextureAtlas(getTextureManager(), 200, 110);
		mBitmapTextureAtlasWRaw2 = new BitmapTextureAtlas(getTextureManager(), 200, 110);
				
		mFaceTextureRegionRaw1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasRaw1, this, "LetterRaw/rui.png", 0, 0);
		mFaceTextureRegionRaw2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasRaw2, this, "LetterRaw/rui.png",0,0);
		mFaceTextureRegionRaw3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasRaw3, this, "LetterRaw/rui.png",0,0);
		mFaceTextureRegionRaw4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasRaw4, this, "LetterRaw/rui.png",0,0);
		mFaceTextureRegionWRaw1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWRaw1, this, "LetterRaw/megh.png",0,0);
		mFaceTextureRegionWRaw2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWRaw2, this, "LetterRaw/megh.png",0,0);
				
		//Letter-Toh
		mBitmapTextureAtlasToh1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasToh2 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasToh3 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasToh4 = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasWToh1 = new BitmapTextureAtlas(getTextureManager(), 200, 110);
		mBitmapTextureAtlasWToh2 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
						
		mFaceTextureRegionToh1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasToh1, this, "LetterToh/table.png", 0, 0);
		mFaceTextureRegionToh2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasToh2, this, "LetterToh/tomato.png",0,0);
		mFaceTextureRegionToh3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasToh3, this, "LetterToh/tin.png",0,0);
		mFaceTextureRegionToh4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasToh4, this, "LetterToh/taka.png",0,0);
		mFaceTextureRegionWToh1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWToh1, this, "LetterToh/megh.png",0,0);
		mFaceTextureRegionWToh2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWToh2, this, "LetterToh/langol.png",0,0);
						
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
		
		//Letter-Mo
		mBitmapTextureAtlasMo1.load();
		mBitmapTextureAtlasMo2.load();
		mBitmapTextureAtlasMo3.load();
		mBitmapTextureAtlasMo4.load();
		mBitmapTextureAtlasWMo1.load();
		mBitmapTextureAtlasWMo2.load();
		
		//Letter-Bo
		mBitmapTextureAtlasBo1.load();
		mBitmapTextureAtlasBo2.load();
		mBitmapTextureAtlasBo3.load();
		mBitmapTextureAtlasBo4.load();
		mBitmapTextureAtlasWBo1.load();
		mBitmapTextureAtlasWBo2.load();
		
		//Letter-Ko
		mBitmapTextureAtlasRaw1.load();
		mBitmapTextureAtlasRaw2.load();
		mBitmapTextureAtlasRaw3.load();
		mBitmapTextureAtlasRaw4.load();
		mBitmapTextureAtlasWRaw1.load();
		mBitmapTextureAtlasWRaw2.load();
		
		//Letter-Lo
		mBitmapTextureAtlasToh1.load();
		mBitmapTextureAtlasToh2.load();
		mBitmapTextureAtlasToh3.load();
		mBitmapTextureAtlasToh4.load();
		mBitmapTextureAtlasWToh1.load();
		mBitmapTextureAtlasWToh2.load();
		
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
		
		monkeyGameMenuLetterSelector = Menu.letterNumber;
		
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