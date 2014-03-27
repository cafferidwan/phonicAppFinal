package com.example.phonicsapp.boxGame;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import com.example.phonicsapp.Menu;
import com.example.phonicsapp.R;
import com.example.phonicsapp.monkeyGame.MonkeyGameActivity;
import StatusBarController.StatusBar;
import android.content.Context;
import android.content.Intent;
import android.view.Display;

public class BoxGameActivity extends SimpleBaseGameActivity 
{

	static int CAMERA_WIDTH;
	static int CAMERA_HEIGHT;

	public Camera mCamera;
	public static Scene mScene;
	static Context context;
	
	public static ITextureRegion mJungleBackGroundTextureRegion, mBeachBackGroundTextureRegion,
								 mUnderWaterBackGroundTextureRegion, mPlanetBackGroundTextureRegion;
	public static BitmapTextureAtlas mBitmapTextureAtlasJungleBackGround, mBitmapTextureAtlasUnderWaterBackGround,
									 mBitmapTextureAtlasBeachBackGround, mBitmapTextureAtlasPlanetBackGround;
	
	public static ITextureRegion mBox1TextureRegion;
	public static ITextureRegion mBox2TextureRegion;
	public static BitmapTextureAtlas mBitmapTextureAtlasBox1;
	public static BitmapTextureAtlas mBitmapTextureAtlasBox2;
	
	private BuildableBitmapTextureAtlas mAnimatedJungleParrotBitmapTextureAtlas, 
										mAnimatedUnderWaterParrotBitmapTextureAtlas,
										mAnimatedBeachParrotBitmapTextureAtlas,
										mAnimatedPlanetParrotBitmapTextureAtlas;
	public static TiledTextureRegion mJungleParrotTextureRegion, mUnderWaterParrotTextureRegion,
										mBeachParrotTextureRegion, mPlanetParrotTextureRegion;
	
	//Letter-Mo
	public static ITextureRegion mMo1TextureRegion;
	public static ITextureRegion mMo2TextureRegion;
	public static ITextureRegion mMo3TextureRegion;
	public static ITextureRegion mMo4TextureRegion;
	public static ITextureRegion mMo5TextureRegion;
	public static ITextureRegion mMo6TextureRegion;
	public static ITextureRegion mMoTextureRegion;
	public static ITextureRegion mWMo1TextureRegion;
	public static ITextureRegion mWMo2TextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasMo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo2;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo3;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo4;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo5;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo6;
	public static BitmapTextureAtlas mBitmapTextureAtlasMo;
	public static BitmapTextureAtlas mBitmapTextureAtlasWMo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWMo2;
	
	
	//Letter-Bo
	public static ITextureRegion mBo1TextureRegion;
	public static ITextureRegion mBo2TextureRegion;
	public static ITextureRegion mBo3TextureRegion;
	public static ITextureRegion mBo4TextureRegion;
	public static ITextureRegion mBo5TextureRegion;
	public static ITextureRegion mBo6TextureRegion;
	public static ITextureRegion mBoTextureRegion;
	public static ITextureRegion mWBo1TextureRegion;
	public static ITextureRegion mWBo2TextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasBo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasBo2;
	public static BitmapTextureAtlas mBitmapTextureAtlasBo3;
	public static BitmapTextureAtlas mBitmapTextureAtlasBo4;
	public static BitmapTextureAtlas mBitmapTextureAtlasBo5;
	public static BitmapTextureAtlas mBitmapTextureAtlasBo6;
	public static BitmapTextureAtlas mBitmapTextureAtlasBo;
	public static BitmapTextureAtlas mBitmapTextureAtlasWBo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWBo2;
	
	
	//Letter-Raw
	public static ITextureRegion mRaw1TextureRegion;
	public static ITextureRegion mRaw2TextureRegion;
	public static ITextureRegion mRaw3TextureRegion;
	public static ITextureRegion mRaw4TextureRegion;
	public static ITextureRegion mRaw5TextureRegion;
	public static ITextureRegion mRaw6TextureRegion;
	public static ITextureRegion mRawTextureRegion;
	public static ITextureRegion mWRaw1TextureRegion;
	public static ITextureRegion mWRaw2TextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw1;
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw2;
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw3;
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw4;
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw5;
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw6;
	public static BitmapTextureAtlas mBitmapTextureAtlasRaw;
	public static BitmapTextureAtlas mBitmapTextureAtlasWRaw1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWRaw2;
	
	//Letter-Toh
	public static ITextureRegion mToh1TextureRegion;
	public static ITextureRegion mToh2TextureRegion;
	public static ITextureRegion mToh3TextureRegion;
	public static ITextureRegion mToh4TextureRegion;
	public static ITextureRegion mToh5TextureRegion;
	public static ITextureRegion mToh6TextureRegion;
	public static ITextureRegion mTohTextureRegion;
	public static ITextureRegion mWToh1TextureRegion;
	public static ITextureRegion mWToh2TextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasToh1;
	public static BitmapTextureAtlas mBitmapTextureAtlasToh2;
	public static BitmapTextureAtlas mBitmapTextureAtlasToh3;
	public static BitmapTextureAtlas mBitmapTextureAtlasToh4;
	public static BitmapTextureAtlas mBitmapTextureAtlasToh5;
	public static BitmapTextureAtlas mBitmapTextureAtlasToh6;
	public static BitmapTextureAtlas mBitmapTextureAtlasToh;
	public static BitmapTextureAtlas mBitmapTextureAtlasWToh1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWToh2;
	
	//Letter-To
	public static ITextureRegion mTo1TextureRegion;
	public static ITextureRegion mTo2TextureRegion;
	public static ITextureRegion mTo3TextureRegion;
	public static ITextureRegion mTo4TextureRegion;
	public static ITextureRegion mTo5TextureRegion;
	public static ITextureRegion mTo6TextureRegion;
	public static ITextureRegion mToTextureRegion;
	public static ITextureRegion mWTo1TextureRegion;
	public static ITextureRegion mWTo2TextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasTo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasTo2;
	public static BitmapTextureAtlas mBitmapTextureAtlasTo3;
	public static BitmapTextureAtlas mBitmapTextureAtlasTo4;
	public static BitmapTextureAtlas mBitmapTextureAtlasTo5;
	public static BitmapTextureAtlas mBitmapTextureAtlasTo6;
	public static BitmapTextureAtlas mBitmapTextureAtlasTo;
	public static BitmapTextureAtlas mBitmapTextureAtlasWTo1;
	public static BitmapTextureAtlas mBitmapTextureAtlasWTo2;
	
	
	public static Sprite backGround, openedBox, closedBox;
	static Sprite obj1, obj2, obj3, obj4, obj5, obj6,wrongObj1, wrongObj2;
	static int obj1Sound, obj2Sound, obj3Sound, obj4Sound, obj5Sound, obj6Sound, wrongObj1Sound, wrongObj2Sound, letterSound;
	
	static Letter letter ;
	//Obj1-mula, Obj2-ma, Obj3-mohis, Obj4-megh, Obj5-moi, Obj6-mama, wrongObj1-kola, wrongObj2-keramBoard;
	static AnimatedSprite  parrot;
	public static Entity parrotLetter;
	public static TimerHandler timer1, timer2, timer3;
	
	static float obj1X , obj1Y, obj2X, obj2Y, obj3X, obj3Y, obj4X, obj4Y, obj5X, obj5Y, 
				 obj6X, obj6Y, wrongObj1X, wrongObj1Y, wrongObj2X, wrongObj2Y,
				 letterX, letterY;
	
	static float ImageHight;
	static float ImageWidth;

	static BoxGameActivity boxGameActivityInstance;
	static int bCounter=0;
	static int aCounter=0;
	public static String DEBUG_TAG = BoxGameActivity.class.getSimpleName();
	static int counter=0;
	public static double objectScale;
	
	//level selector of box game
	public static int boxGameMenuLetterSelector;
	public static int[] letterLevelSelector = new int[25];
	//public static int letterLevelSelector1, letterLevelSelector4, letterLevelSelector6, letterLevelSelector19;
	
	public static BoxGameActivity getSharedInstances()
	{
		return boxGameActivityInstance;
	}
	
	@Override
	public EngineOptions onCreateEngineOptions()
	{
		// TODO Auto-generated method stub
		boxGameActivityInstance = this;
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HEIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();
		
		ImageHight = 120;
		ImageWidth = 120;
		
		obj1X = CAMERA_WIDTH/2 - CAMERA_WIDTH/4;
		obj1Y =	CAMERA_HEIGHT/2 - CAMERA_HEIGHT/4;
		
		obj6X = CAMERA_WIDTH/2 - CAMERA_WIDTH/3;
		obj6Y =	CAMERA_HEIGHT-130;
		
		wrongObj1X = 35;
		wrongObj1Y = CAMERA_HEIGHT-130;
		
		obj2X = 50;
		obj2Y = CAMERA_HEIGHT/2 - CAMERA_HEIGHT/4;
		
		obj3X = CAMERA_WIDTH - 150;
		obj3Y = CAMERA_HEIGHT-130;
		
		wrongObj2X = CAMERA_WIDTH - CAMERA_WIDTH/4 -95;
		wrongObj2Y = CAMERA_HEIGHT-130;
		
		obj4X =  CAMERA_WIDTH/2 + 40;
		obj4Y = CAMERA_HEIGHT/4;
		
		obj5X = CAMERA_WIDTH/2-90;
		obj5Y = CAMERA_HEIGHT/2 - CAMERA_HEIGHT/4;
		
		letterX = 160;
		letterY = 250;
		
		//Box game every object scale
		objectScale = 0.7;
		
		BoxGameActivity.counter = 0;
		
		//setting the level to 0
		//boxGameLevel = 0;
		
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	}

	@Override
	protected void onCreateResources() 
	{
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("BoxGameGfx/");

		mBitmapTextureAtlasJungleBackGround = new BitmapTextureAtlas(this.getTextureManager(), 1600, 864, TextureOptions.BILINEAR);
		mJungleBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasJungleBackGround, this,
				"JungleBG.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasBeachBackGround = new BitmapTextureAtlas(this.getTextureManager(), 1600, 864, TextureOptions.BILINEAR);
		mBeachBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBeachBackGround, this,
				"BeachBG.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasUnderWaterBackGround = new BitmapTextureAtlas(this.getTextureManager(), 1600, 864, TextureOptions.BILINEAR);
		mUnderWaterBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasUnderWaterBackGround, this,
				"UnderWaterBG.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasPlanetBackGround = new BitmapTextureAtlas(this.getTextureManager(), 1600, 864, TextureOptions.BILINEAR);
		mPlanetBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasPlanetBackGround, this,
				"PlanetBG.png", 0, 0,  1, 1);
		
		
		mBitmapTextureAtlasBox1 = new BitmapTextureAtlas(this.getTextureManager(), 180, 248, TextureOptions.BILINEAR);
		mBox1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBox1, this,
				"box-15.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasBox2 = new BitmapTextureAtlas(this.getTextureManager(), 180, 248, TextureOptions.BILINEAR);
		mBox2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBox2, this,
				"box-16.png", 0, 0,  1, 1);
		
		
		mAnimatedJungleParrotBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 806, 806, TextureOptions.REPEATING_BILINEAR_PREMULTIPLYALPHA);
		mJungleParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedJungleParrotBitmapTextureAtlas, this, "animatedParrot.png", 2, 2);
		
		mAnimatedBeachParrotBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 806, 806, TextureOptions.REPEATING_BILINEAR_PREMULTIPLYALPHA);
		mBeachParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedBeachParrotBitmapTextureAtlas, this, "beachParrot.png", 2, 2);
		
		mAnimatedUnderWaterParrotBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 806, 806, TextureOptions.REPEATING_BILINEAR_PREMULTIPLYALPHA);
		mUnderWaterParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedUnderWaterParrotBitmapTextureAtlas, this, "underWaterParrot.png", 2, 2);
		
		mAnimatedPlanetParrotBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 806, 806, TextureOptions.REPEATING_BILINEAR_PREMULTIPLYALPHA);
		mPlanetParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedPlanetParrotBitmapTextureAtlas, this, "planetParrot.png", 2, 2);
		
		
		//Letter-Mo
		mBitmapTextureAtlasMo1 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mMo1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMo1, this,
				"LetterMo/ma.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasMo2 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mMo2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMo2, this,
				"LetterMo/megh.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasMo3 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mMo3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMo3, this,
				"LetterMo/mohis.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasMo4 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mMo4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMo4, this,
				"LetterMo/moi.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasMo5 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mMo5TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMo5, this,
				"LetterMo/mula.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasMo6 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mMo6TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMo6, this,
				"LetterMo/mama.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasMo = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mMoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMo, this,
				"LetterMo/mo.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasWMo1 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mWMo1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWMo1, this,
				"LetterMo/kola.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasWMo2 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mWMo2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWMo2, this,
				"LetterMo/keramBoard.png", 0, 0,  1, 1);
		
		
		//Letter-Bo
		mBitmapTextureAtlasBo1 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBo1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBo1, this,
				"LetterBo/balish.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasBo2 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBo2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBo2, this,
				"LetterBo/ballon.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasBo3 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBo3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBo3, this,
				"LetterBo/boi.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasBo4 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBo4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBo4, this,
				"LetterBo/bok.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasBo5 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBo5TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBo5, this,
				"LetterBo/brinjal.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasBo6 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBo6TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBo6, this,
				"LetterBo/ball.png", 0, 0,  1, 1); 
		
		mBitmapTextureAtlasBo = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mBoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBo, this,
				"LetterBo/bo.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasWBo1 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mWBo1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWBo1, this,
				"LetterBo/robi.png", 0, 0,  1, 1);
		 
		mBitmapTextureAtlasWBo2 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mWBo2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWBo2, this,
				"LetterBo/rocket.png", 0, 0,  1, 1);
		 
		
		//Letter-Raw
		mBitmapTextureAtlasRaw1 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mRaw1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasRaw1, this,
				"LetterRaw/rui.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasRaw2 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mRaw2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasRaw2, this,
				"LetterRaw/rocket.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasRaw3 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mRaw3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasRaw3, this,
				"LetterRaw/robi.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasRaw4 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mRaw4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasRaw4, this,
				"LetterRaw/rongdhonu.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasRaw5 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mRaw5TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasRaw5, this,
				"LetterRaw/rani.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasRaw6 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mRaw6TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasRaw6, this,
				"LetterRaw/ranna.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasRaw = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mRawTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasRaw, this,
				"LetterRaw/raw.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasWRaw1 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mWRaw1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWRaw1, this,
				"LetterRaw/mohis.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasWRaw2 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mWRaw2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWRaw2, this,
				"LetterRaw/boi.png", 0, 0,  1, 1);
		
		//Letter-Toh
		mBitmapTextureAtlasToh1 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mToh1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasToh1, this,
				"LetterToh/table.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasToh2 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mToh2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasToh2, this,
				"LetterToh/taka.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasToh3 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mToh3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasToh3, this,
				"LetterToh/tin.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasToh4 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mToh4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasToh4, this,
				"LetterToh/tob.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasToh5 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mToh5TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasToh5, this,
				"LetterToh/tomato.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasToh6 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mToh6TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasToh6, this,
				"LetterToh/tomtom.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasToh = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mTohTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasToh, this,
				"LetterToh/toh.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasWToh1 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mWToh1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWToh1, this,
				"LetterToh/brinjal.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasWToh2 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mWToh2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWToh2, this,
				"LetterToh/rongdhonu.png", 0, 0,  1, 1);
		
		
		//Letter-To
		mBitmapTextureAtlasTo1 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mTo1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTo1, this,
				"LetterTo/ma.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasTo2 = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mTo2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTo2, this,
				"LetterTo/megh.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasTo3 = new BitmapTextureAtlas(this.getTextureManager(), 150, 152, TextureOptions.BILINEAR);
		mTo3TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTo3, this,
				"LetterTo/mohis-2.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasTo4 = new BitmapTextureAtlas(this.getTextureManager(), 150, 153, TextureOptions.BILINEAR);
		mTo4TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTo4, this,
				"LetterTo/moi-2.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasTo5 = new BitmapTextureAtlas(this.getTextureManager(), 150, 153, TextureOptions.BILINEAR);
		mTo5TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTo5, this,
				"LetterTo/mula-2.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasTo6 = new BitmapTextureAtlas(this.getTextureManager(), 150, 152, TextureOptions.BILINEAR);
		mTo6TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTo6, this,
				"LetterTo/mama-2.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasTo = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		mToTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTo, this,
				"LetterTo/mo.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasWTo1 = new BitmapTextureAtlas(this.getTextureManager(), 120, 120, TextureOptions.BILINEAR);
		mWTo1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWTo1, this,
				"LetterTo/kola-1.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasWTo2 = new BitmapTextureAtlas(this.getTextureManager(), 120, 122, TextureOptions.BILINEAR);
		mWTo2TextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasWTo2, this,
				"LetterTo/keramBoard1.png", 0, 0,  1, 1);
	
		
		try 
		{
			this.mAnimatedJungleParrotBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedJungleParrotBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
		try 
		{
			this.mAnimatedUnderWaterParrotBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedUnderWaterParrotBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
		try 
		{
			this.mAnimatedBeachParrotBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedBeachParrotBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
		try 
		{
			this.mAnimatedPlanetParrotBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedPlanetParrotBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
		mBitmapTextureAtlasJungleBackGround.load();
		mBitmapTextureAtlasBeachBackGround.load();
		mBitmapTextureAtlasUnderWaterBackGround.load();
		mBitmapTextureAtlasPlanetBackGround.load();
		
		mBitmapTextureAtlasBo1.load();
		mBitmapTextureAtlasBo2.load();
		mBitmapTextureAtlasBo3.load();
		mBitmapTextureAtlasBo4.load();
		mBitmapTextureAtlasBo5.load();
		mBitmapTextureAtlasBo6.load();
		mBitmapTextureAtlasBo.load();
		mBitmapTextureAtlasWBo1.load();
		mBitmapTextureAtlasWBo2.load();
		
		mBitmapTextureAtlasMo1.load();
		mBitmapTextureAtlasMo2.load();
		mBitmapTextureAtlasMo3.load();
		mBitmapTextureAtlasMo4.load();
		mBitmapTextureAtlasMo5.load();
		mBitmapTextureAtlasMo6.load();
		mBitmapTextureAtlasMo.load();
		mBitmapTextureAtlasWMo1.load();
		mBitmapTextureAtlasWMo2.load();
		
		mBitmapTextureAtlasRaw1.load();
		mBitmapTextureAtlasRaw2.load();
		mBitmapTextureAtlasRaw3.load();
		mBitmapTextureAtlasRaw4.load();
		mBitmapTextureAtlasRaw5.load();
		mBitmapTextureAtlasRaw6.load();
		mBitmapTextureAtlasRaw.load();
		mBitmapTextureAtlasWRaw1.load();
		mBitmapTextureAtlasWRaw2.load();
		
		mBitmapTextureAtlasToh1.load();
		mBitmapTextureAtlasToh2.load();
		mBitmapTextureAtlasToh3.load();
		mBitmapTextureAtlasToh4.load();
		mBitmapTextureAtlasToh5.load();
		mBitmapTextureAtlasToh6.load();
		mBitmapTextureAtlasToh.load();
		mBitmapTextureAtlasWToh1.load();
		mBitmapTextureAtlasWToh2.load();
		
		mBitmapTextureAtlasTo1.load();
		mBitmapTextureAtlasTo2.load();
		mBitmapTextureAtlasTo3.load();
		mBitmapTextureAtlasTo4.load();
		mBitmapTextureAtlasTo5.load();
		mBitmapTextureAtlasTo6.load();
		mBitmapTextureAtlasTo.load();
		mBitmapTextureAtlasWTo1.load();
		mBitmapTextureAtlasWTo2.load();
		
		mBitmapTextureAtlasBox1.load();
		mBitmapTextureAtlasBox2.load();
	}

	@Override
	protected Scene onCreateScene()
	{
		// TODO Auto-generated method stub
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));
		mScene.setTouchAreaBindingOnActionDownEnabled(true);
		
//		StatusBar.hideStatusBar();
		StatusBar.showStatusBar();
		
		//Getting the menu letter number
		boxGameMenuLetterSelector = Menu.letterNumber;
		
		//Loading the objects according to letter
		LevelResources.loadObjects(boxGameMenuLetterSelector); 
		
		//check collisions
		TimerHandlers.checkObjectCollisions();
		
		//change wrong objects with right ones when it is second level
		if(boxGameMenuLetterSelector==1) 
		{
			if(letterLevelSelector[boxGameMenuLetterSelector] == 1)
			{
				TimerHandlers.ExchangeObjects();
			}
		}
		else if(boxGameMenuLetterSelector==6)
		{
			if(letterLevelSelector[boxGameMenuLetterSelector] == 1)
			{
				TimerHandlers.ExchangeObjects();
			} 
		}
		else if(boxGameMenuLetterSelector==4)
		{
			if(letterLevelSelector[boxGameMenuLetterSelector] == 1)
			{
				TimerHandlers.ExchangeObjects();
			}
		}
		else if(boxGameMenuLetterSelector==19)
		{
			if(letterLevelSelector[boxGameMenuLetterSelector] == 1)
			{
				TimerHandlers.ExchangeObjects();
			}
		}

			
		CreateObjects.create(boxGameMenuLetterSelector);
		
		//getting the context
		BoxGameActivity.context = getApplicationContext();
		
		//playing the introduction sound of parrot
		mScene.registerUpdateHandler(new TimerHandler((float) 0.5,new ITimerCallback()
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				playIntroSound();
			}
		}));
		
		return mScene;
	}
	
	

	public void playIntroSound()
	{
		Functions.audioPlay = true;
		if(boxGameMenuLetterSelector==1)
		{
			Functions.playAudio(R.raw.box_mo);
		}
		else if(boxGameMenuLetterSelector==6)
		{
			Functions.playAudio(R.raw.box_bo);
		}
		else if(boxGameMenuLetterSelector==4)
		{
			Functions.playAudio(R.raw.box_ro);
		}
		else if(boxGameMenuLetterSelector==19)
		{
			Functions.playAudio(R.raw.box_toh);
		}
		
	}
	
	public static void startActivity()
	{
		//Debug.d("level:"+boxGameLevel);
	
		if(boxGameMenuLetterSelector==1)
		{
			if(letterLevelSelector[boxGameMenuLetterSelector] == 0)
			{
				letterLevelSelector[boxGameMenuLetterSelector] = 1;
				
				mScene.unregisterUpdateHandler(timer1);
				BoxGameActivity.boxGameActivityInstance.finish();
				BoxGameActivity.boxGameActivityInstance.startActivity(new Intent(boxGameActivityInstance, BoxGameActivity.class));
			}
			else if(letterLevelSelector[boxGameMenuLetterSelector] == 1)
			{
				mScene.unregisterUpdateHandler(timer1);
				BoxGameActivity.boxGameActivityInstance.finish();
				BoxGameActivity.boxGameActivityInstance.startActivity(new Intent(boxGameActivityInstance, MonkeyGameActivity.class));
		
				letterLevelSelector[boxGameMenuLetterSelector] = 0;
			}
		
		}
		else if(boxGameMenuLetterSelector==6)
		{
			if(letterLevelSelector[boxGameMenuLetterSelector] == 0)
			{
				letterLevelSelector[boxGameMenuLetterSelector] = 1;
				
				mScene.unregisterUpdateHandler(timer1);
				BoxGameActivity.boxGameActivityInstance.finish();
				BoxGameActivity.boxGameActivityInstance.startActivity(new Intent(boxGameActivityInstance, BoxGameActivity.class));
			}
			else if(letterLevelSelector[boxGameMenuLetterSelector] == 1)
			{
				mScene.unregisterUpdateHandler(timer1);
				BoxGameActivity.boxGameActivityInstance.finish();
				BoxGameActivity.boxGameActivityInstance.startActivity(new Intent(boxGameActivityInstance, MonkeyGameActivity.class));
		
				letterLevelSelector[boxGameMenuLetterSelector] = 0;
			}
		}
		else if(boxGameMenuLetterSelector==4)
		{
			if(letterLevelSelector[boxGameMenuLetterSelector] == 0 )
			{
				letterLevelSelector[boxGameMenuLetterSelector] = 1;
				
				mScene.unregisterUpdateHandler(timer1); 
				BoxGameActivity.boxGameActivityInstance.finish();
				BoxGameActivity.boxGameActivityInstance.startActivity(new Intent(boxGameActivityInstance, BoxGameActivity.class));
			}
			else if(letterLevelSelector[boxGameMenuLetterSelector] == 1 )
			{
				mScene.unregisterUpdateHandler(timer1);
				BoxGameActivity.boxGameActivityInstance.finish();
				BoxGameActivity.boxGameActivityInstance.startActivity(new Intent(boxGameActivityInstance, MonkeyGameActivity.class));
		
				letterLevelSelector[boxGameMenuLetterSelector] = 0;
			}
		}
		else if(boxGameMenuLetterSelector==19)
		{
			if(letterLevelSelector[boxGameMenuLetterSelector] == 0 )
			{
				letterLevelSelector[boxGameMenuLetterSelector] = 1;
				
				mScene.unregisterUpdateHandler(timer1);
				BoxGameActivity.boxGameActivityInstance.finish();
				BoxGameActivity.boxGameActivityInstance.startActivity(new Intent(boxGameActivityInstance, BoxGameActivity.class));
			}
			else if(letterLevelSelector[boxGameMenuLetterSelector] == 1)
			{
				mScene.unregisterUpdateHandler(timer1);
				BoxGameActivity.boxGameActivityInstance.finish();
				BoxGameActivity.boxGameActivityInstance.startActivity(new Intent(boxGameActivityInstance, MonkeyGameActivity.class));
		
				letterLevelSelector[boxGameMenuLetterSelector] = 0;
			}
		}
		
	}
	
	
	
	public void setCurrentScene(Scene scene)
	{
		mScene = scene;
		getEngine().setScene(mScene);
	}
}
