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
import com.example.phonicsapp.boxGame.BoxGameActivity;


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
	
	public static BitmapTextureAtlas mBitmapTextureAtlasBoxSide;
	public static TextureRegion mBoxSideTextureRegion;
	
	public static ITextureRegion mJungleBackGroundTextureRegion, mBeachBackGroundTextureRegion,
								 mUnderWaterBackGroundTextureRegion, mPlanetBackGroundTextureRegion;
	public static BitmapTextureAtlas mBitmapTextureAtlasJungleBackGround, mBitmapTextureAtlasUnderWaterBackGround,
									 mBitmapTextureAtlasBeachBackGround, mBitmapTextureAtlasPlanetBackGround;
	
	public static Sprite backGround, obj1, obj2, obj3, obj4, wrongObj1, wrongObj2, banana, monkey1, monkey2;
	public static Sprite[] boxSide = new Sprite[7];
	
	public static Camera mCamera;
	public static Scene mScene;
	
	//Fixed Objects monkey1, monkey2, banana;
	public static BitmapTextureAtlas mBitmapTextureAtlasMonkeyWithoutReward, mBitmapTextureAtlasMonkeyWithBanana,
									mBitmapTextureAtlasMonkeyWithFish, mBitmapTextureAtlasMonkeyWithAlien, 
									mBitmapTextureAtlasMonkeyWithCup, mBitmapTextureAtlasMonkeyWithoutCup,
									mBitmapTextureAtlasMonkeyWithoutAlien, mBitmapTextureAtlasMonkeyWithoutFish;
	public static ITextureRegion mFaceTextureRegionMonkeyWithoutReward, mFaceTextureRegionMonkeyWithBanana, 
									mFaceTextureRegionMonkeyWithFish, mFaceTextureRegionMonkeyWithAlien,
									mFaceTextureRegionMonkeyWithCup, mFaceTextureRegionMonkeyWithoutCup,
									mFaceTextureRegionMonkeyWithoutAlien, mFaceTextureRegionMonkeyWithoutFish;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasBanana;
	public static ITextureRegion mFaceTextureRegionBanana;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasFish;
	public static ITextureRegion mFaceTextureRegionFish;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasCup;
	public static ITextureRegion mFaceTextureRegionCup;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasAlien;
	public static ITextureRegion mFaceTextureRegionAlien;
	
	//Letter-Mo
	public static BitmapTextureAtlas mBitmapTextureAtlasMo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo2;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo3;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo4;
	public static BitmapTextureAtlas mBitmapTextureAtlasWMo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWMo2;
	public static BitmapTextureAtlas mBitmapTextureAtlasWMo3;
	public static BitmapTextureAtlas mBitmapTextureAtlasWMo4;
	
	public static ITextureRegion mFaceTextureRegionMo1;
	public static ITextureRegion mFaceTextureRegionMo2;
	public static ITextureRegion mFaceTextureRegionMo3;
	public static ITextureRegion mFaceTextureRegionMo4;
	public static ITextureRegion mFaceTextureRegionWMo1;
	public static ITextureRegion mFaceTextureRegionWMo2;
	public static ITextureRegion mFaceTextureRegionWMo3;
	public static ITextureRegion mFaceTextureRegionWMo4;
	
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
	
	//reward objects like banana, fish, cup, alien
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
	public static double monkeyGameObjectScale;
	public static int[] monkeyGameLevelSelector1 = new int[25];
	
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
		
		mBitmapTextureAtlasJungleBackGround = new BitmapTextureAtlas(getTextureManager(), 1600, 868,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mJungleBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasJungleBackGround, getAssets(), "jungleBackground.png", 0, 0);

		mBitmapTextureAtlasBeachBackGround = new BitmapTextureAtlas(getTextureManager(), 1600, 868,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mBeachBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBeachBackGround, getAssets(), "beachBackground.png", 0, 0);

		mBitmapTextureAtlasUnderWaterBackGround = new BitmapTextureAtlas(getTextureManager(), 1600, 868,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mUnderWaterBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasUnderWaterBackGround, getAssets(), "underWaterBackground.png", 0, 0);

		mBitmapTextureAtlasPlanetBackGround = new BitmapTextureAtlas(getTextureManager(), 1600, 868,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mPlanetBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasPlanetBackGround, getAssets(), "planetBackground.png", 0, 0);

		mBitmapTextureAtlasBoxSide = new BitmapTextureAtlas(getTextureManager(), 300, 300,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mBoxSideTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBoxSide, getAssets(), "boxSide.png", 0, 0);

		
		//Letter-Mo
		mBitmapTextureAtlasMo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasMo2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasMo3 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasMo4 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWMo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWMo2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mFaceTextureRegionMo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo1, this, "LetterMo/moi.png", 0, 0);
		mFaceTextureRegionMo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo2, this, "LetterMo/mama.png",0,0);
		mFaceTextureRegionMo3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo3, this, "LetterMo/megh.png",0,0);
		mFaceTextureRegionMo4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMo4, this, "LetterMo/mohis.png",0,0);
		mFaceTextureRegionWMo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWMo1, this, "LetterMo/tala.png",0,0);
		mFaceTextureRegionWMo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWMo2, this, "LetterMo/langol.png",0,0);
		
		//Letter-Bo
		mBitmapTextureAtlasBo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasBo2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasBo3 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasBo4 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWBo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWBo2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
						
		mFaceTextureRegionBo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBo1, this, "LetterBo/balish.png", 0, 0);
		mFaceTextureRegionBo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBo2, this, "LetterBo/boi.png",0,0);
		mFaceTextureRegionBo3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBo3, this, "LetterBo/ballon.png",0,0);
		mFaceTextureRegionBo4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBo4, this, "LetterBo/brinjal.png",0,0);
		mFaceTextureRegionWA1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWBo1, this, "LetterBo/taka.png",0,0);
		mFaceTextureRegionWA2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWBo2, this, "LetterBo/megh.png",0,0);

		//Letter-Raw
		mBitmapTextureAtlasRaw1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasRaw2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasRaw3 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasRaw4 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWRaw1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWRaw2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
				
		mFaceTextureRegionRaw1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasRaw1, this, "LetterRaw/robi.png", 0, 0);
		mFaceTextureRegionRaw2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasRaw2, this, "LetterRaw/rocket.png",0,0);
		mFaceTextureRegionRaw3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasRaw3, this, "LetterRaw/rani.png",0,0);
		mFaceTextureRegionRaw4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasRaw4, this, "LetterRaw/rui.png",0,0);
		mFaceTextureRegionWRaw1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWRaw1, this, "LetterRaw/mama.png",0,0);
		mFaceTextureRegionWRaw2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWRaw2, this, "LetterRaw/table.png",0,0);
				
		//Letter-Toh
		mBitmapTextureAtlasToh1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasToh2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasToh3 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasToh4 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWToh1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWToh2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
						
		mFaceTextureRegionToh1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasToh1, this, "LetterToh/tomtom.png", 0, 0);
		mFaceTextureRegionToh2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasToh2, this, "LetterToh/tomato.png",0,0);
		mFaceTextureRegionToh3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasToh3, this, "LetterToh/tin.png",0,0);
		mFaceTextureRegionToh4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasToh4, this, "LetterToh/taka.png",0,0);
		mFaceTextureRegionWToh1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWToh1, this, "LetterToh/boi.png",0,0);
		mFaceTextureRegionWToh2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWToh2, this, "LetterToh/rocket.png",0,0);
						
		//Letter-To 
		mBitmapTextureAtlasTo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasTo2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasTo3 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasTo4 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWTo1 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasWTo2 = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
								
		mFaceTextureRegionTo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTo1, this, "LetterTo/keramBoard1.png", 0, 0);
		mFaceTextureRegionTo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTo2, this, "LetterTo/mas.png",0,0);
		mFaceTextureRegionTo3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTo3, this, "LetterTo/mula-2.png",0,0);
		mFaceTextureRegionTo4 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTo4, this, "LetterTo/mohis-2.png",0,0);
		mFaceTextureRegionWTo1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWTo1, this, "LetterTo/ma.png",0,0);
		mFaceTextureRegionWTo2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasWTo2, this, "LetterTo/pineapple.png",0,0);			
		
		//Fixed Objects- monkey1, monkey2, banana
		mBitmapTextureAtlasMonkeyWithoutReward = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasMonkeyWithBanana = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasMonkeyWithFish = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasMonkeyWithoutFish = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasMonkeyWithAlien = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasMonkeyWithoutAlien = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasMonkeyWithCup = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasMonkeyWithoutCup = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasBanana = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasFish = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasCup = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBitmapTextureAtlasAlien = new BitmapTextureAtlas(getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mFaceTextureRegionMonkeyWithoutReward = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMonkeyWithoutReward, this, "monkeyWithoutReward.png",0,0);
		mFaceTextureRegionMonkeyWithBanana = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMonkeyWithBanana, this, "monkeyWithBanana.png",0,0);
		mFaceTextureRegionMonkeyWithFish = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMonkeyWithFish, this, "monkeyWithFish.png",0,0);
		mFaceTextureRegionMonkeyWithoutFish = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMonkeyWithoutFish, this, "monkeyWithoutFish.png",0,0);
		mFaceTextureRegionMonkeyWithAlien = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMonkeyWithAlien, this, "monkeyWithAlien.png",0,0);
		mFaceTextureRegionMonkeyWithoutAlien = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMonkeyWithoutAlien, this, "monkeyWithoutAlien.png",0,0);
		mFaceTextureRegionMonkeyWithCup = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMonkeyWithCup, this, "monkeyWithCup.png",0,0);
		mFaceTextureRegionMonkeyWithoutCup = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMonkeyWithoutCup, this, "monkeyWithoutCup.png",0,0);
		
		mFaceTextureRegionBanana = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBanana, this, "banana.png",0,0);
		mFaceTextureRegionFish = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasFish, this, "fish.png",0,0);
		mFaceTextureRegionCup = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasCup, this, "cup.png",0,0);
		mFaceTextureRegionAlien = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasAlien, this, "alien.png",0,0);
		
		
		mBitmapTextureAtlasJungleBackGround.load();
		mBitmapTextureAtlasBeachBackGround.load();
		mBitmapTextureAtlasUnderWaterBackGround.load();
		mBitmapTextureAtlasPlanetBackGround.load();
		mBitmapTextureAtlasBoxSide.load();
		
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
		
		//Fixed Objects monkey1, monkey2, banana, fish, cup, alien;
		mBitmapTextureAtlasBanana.load();
		mBitmapTextureAtlasFish.load();
		mBitmapTextureAtlasCup.load();
		mBitmapTextureAtlasAlien.load();
		mBitmapTextureAtlasMonkeyWithoutReward.load();
		mBitmapTextureAtlasMonkeyWithBanana.load();
		mBitmapTextureAtlasMonkeyWithFish.load();
		mBitmapTextureAtlasMonkeyWithoutFish.load();
		mBitmapTextureAtlasMonkeyWithAlien.load();
		mBitmapTextureAtlasMonkeyWithoutAlien.load();
		mBitmapTextureAtlasMonkeyWithCup.load();
		mBitmapTextureAtlasMonkeyWithoutCup.load();
		
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
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));
		vbo = getVertexBufferObjectManager();

		//debug mode
		//RootTools.debugMode = true; 
		StatusBar.showStatusBar();
				
		monkeyGameObjectScale = 0.6;
		
//		MonkeyGameActivity.monkeyGameLevelSelector = 2;
		
		monkeyGameMenuLetterSelector = Menu.letterNumber;
		
		GameObjects.createObjects(monkeyGameMenuLetterSelector);
		
		
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
		

		//playing the introduction sound of parrot
		mScene.registerUpdateHandler(new TimerHandler((float) 0.5,new ITimerCallback()
		{
				@Override
				public void onTimePassed(TimerHandler pTimerHandler)
				{
					playIntroSound();
				}
		}));
		
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

	public void playIntroSound()
	{
		MonkeyGameActivity.audioPlay = true;
		if(monkeyGameMenuLetterSelector==1)
		{
			ObjectRemoveFunctions.playAudio(R.raw.monkey_mo);
		}
		else if(monkeyGameMenuLetterSelector==6)
		{
			ObjectRemoveFunctions.playAudio(R.raw.monkey_bo);
		}
		else if(monkeyGameMenuLetterSelector==4)
		{
			ObjectRemoveFunctions.playAudio(R.raw.monkey_ro);
		}
		else if(monkeyGameMenuLetterSelector==19)
		{
			ObjectRemoveFunctions.playAudio(R.raw.monkey_toh);
		}
		
	}

	

	public static void startActivity()
	{
		if(monkeyGameMenuLetterSelector==1)
		{
			if(monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] == 0)
			{
				monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] = 1;
				monkeyGameLevelSelector = 1;
				mScene.unregisterUpdateHandler(timer1);
				MonkeyGameActivityActivity.finish();
				MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, MonkeyGameActivity.class));
			}
			else if(monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] == 1)
			{
				monkeyGameLevelSelector = 0;
				mScene.unregisterUpdateHandler(timer1);
				MonkeyGameActivityActivity.finish();
				MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, GameMainPage.class));
		
				monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] = 0;
			}
		
		}
		else if(monkeyGameMenuLetterSelector==6)
		{
			if(monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] == 0)
			{
				monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] = 1;
				monkeyGameLevelSelector = 1;
				mScene.unregisterUpdateHandler(timer1);
				MonkeyGameActivityActivity.finish();
				MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, MonkeyGameActivity.class));
			}
			else if(monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] == 1)
			{
				monkeyGameLevelSelector = 0;
				mScene.unregisterUpdateHandler(timer1);
				MonkeyGameActivityActivity.finish();
				MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, GameMainPage.class));
		
				monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] = 0;
			}
		}
		else if(monkeyGameMenuLetterSelector==4)
		{
			if(monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] == 0 )
			{
				monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] = 1;
				monkeyGameLevelSelector = 1;
				mScene.unregisterUpdateHandler(timer1); 
				MonkeyGameActivityActivity.finish();
				MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, MonkeyGameActivity.class));
			}
			else if(monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] == 1 )
			{
				monkeyGameLevelSelector = 0;
				mScene.unregisterUpdateHandler(timer1);
				MonkeyGameActivityActivity.finish();
				MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, GameMainPage.class));
		
				monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] = 0;
			}
		}
		else if(monkeyGameMenuLetterSelector==19)
		{
			if(monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] == 0 )
			{
				monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] = 1;
				
				mScene.unregisterUpdateHandler(timer1);
				MonkeyGameActivityActivity.finish();
				MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, MonkeyGameActivity.class));
			}
			else if(monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] == 1 )
			{
				mScene.unregisterUpdateHandler(timer1);
				MonkeyGameActivityActivity.finish();
				MonkeyGameActivityActivity.startActivity(new Intent(MonkeyGameActivityActivity, GameMainPage.class));
		
				monkeyGameLevelSelector1[monkeyGameMenuLetterSelector] = 0;
			}
		}
	}
	
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}