package com.example.phonicsapp.HandWriting.banglaletterwriting;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.ScreenCapture;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;
import com.example.phonicsapp.HandWriting.Animation.AnimationDrawTutorial;
import com.example.phonicsapp.HandWriting.Objects.createObjects;
import com.example.phonicsapp.HandWriting.ScreenShoot.BitmapTextureAtlasSource;
import android.media.MediaPlayer;
import android.view.Display;

public class GameActivity extends BaseGameActivity implements IOnSceneTouchListener 
	{

	public static int CAMERA_WIDTH, CAMERA_HEIGHT;
	public Camera mCamera;
	public static Scene mScene;
	public static Scene menuScene;
	public static VertexBufferObjectManager vertexBufferObjectManager;
	public static GameActivity MainActivityInstace;

	
	public static ITextureRegion mMoFilledTextureRegion, mAaFilledTextureRegion,
								mEFilledTextureRegion, mHoFilledTextureRegion,
								mRawFilledTextureRegion, mKoFilledTextureRegion,
								mBoFilledTextureRegion, mTalibashaFilledTextureRegion,
								mLoFilledTextureRegion, mPoFilledTextureRegion,
								mGoFilledTextureRegion, mKhoFilledTextureRegion,
								mChoFilledTextureRegion, mNoFilledTextureRegion,
								mAFilledTextureRegion, mDoFilledTextureRegion,
								mUFilledTextureRegion, mToFilledTextureRegion,
								mTohFilledTextureRegion, mDohFilledTextureRegion,
								mUkarFilledTextureRegion, mEkarFilledTextureRegion,
								mAkarFilledTextureRegion, mAakarFilledTextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasMoFilled, mBitmapTextureAtlasAaFilled,
									mBitmapTextureAtlasEFilled, mBitmapTextureAtlasHoFilled,
									mBitmapTextureAtlasRawFilled, mBitmapTextureAtlasKoFilled,
									mBitmapTextureAtlasBoFilled, mBitmapTextureAtlasTalibashaFilled,
									mBitmapTextureAtlasLoFilled, mBitmapTextureAtlasPoFilled,
									mBitmapTextureAtlasGoFilled, mBitmapTextureAtlasKhoFilled,
									mBitmapTextureAtlasChoFilled, mBitmapTextureAtlasNoFilled,
									mBitmapTextureAtlasAFilled, mBitmapTextureAtlasDoFilled,
									mBitmapTextureAtlasUFilled, mBitmapTextureAtlasToFilled,
									mBitmapTextureAtlasTohFilled, mBitmapTextureAtlasDohFilled,
									mBitmapTextureAtlasUkarFilled, mBitmapTextureAtlasEkarFilled,
									mBitmapTextureAtlasAkarFilled, mBitmapTextureAtlasAakarFilled;
	
	
	
	public static BitmapTextureAtlas 
	 mBitmapTextureAtlasAaOutLine, mBitmapTextureAtlasEOutLine,
	 mBitmapTextureAtlasRawOutLine, mBitmapTextureAtlasKoOutLine,
	 mBitmapTextureAtlasBoOutLine, mBitmapTextureAtlasTalibaShaOutLine,
	 mBitmapTextureAtlasLoOutLine, mBitmapTextureAtlasPoOutLine,
	 mBitmapTextureAtlasGoOutLine, mBitmapTextureAtlasHoOutLine,
	 mBitmapTextureAtlasKhoOutLine, mBitmapTextureAtlasChoOutLine,
	 mBitmapTextureAtlasNoOutLine, mBitmapTextureAtlasAOutLine,
	 mBitmapTextureAtlasDoOutLine, mBitmapTextureAtlasUOutLine,
	 mBitmapTextureAtlasToOutLine, mBitmapTextureAtlasTohOutLine,
	 mBitmapTextureAtlasDohOutLine, mBitmapTextureAtlasUkarOutLine,
	 mBitmapTextureAtlasEkarOutLine, mBitmapTextureAtlasAkarOutLine,
	 mBitmapTextureAtlasAakarOutLine;
	 
	public static ITextureRegion mAaOutLineTextureRegion, 
	mEOutLineTextureRegion, mRawOutLineTextureRegion,
	mKoOutLineTextureRegion, mBoOutLineTextureRegion,
	mTalibaShaOutLineTextureRegion, mLoOutLineTextureRegion,
	mPoOutLineTextureRegion, mGoOutLineTextureRegion,
	mHoOutLineTextureRegion, mMoOutLineTextureRegion,
	mKhoOutLineTextureRegion, mChoOutLineTextureRegion,
	mNoOutLineTextureRegion, mAOutLineTextureRegion,
	mDoOutLineTextureRegion, mUOutLineTextureRegion,
	mToOutLineTextureRegion, mTohOutLineTextureRegion,
	mDohOutLineTextureRegion, mUkarOutLineTextureRegion,
	mEkarOutLineTextureRegion, mAkarOutLineTextureRegion,
	mAakarOutLineTextureRegion;
	
	//Menu Items
	public static BitmapTextureAtlas[][] mBitmapTextureAtlasMenuLetters = new BitmapTextureAtlas[50][50];
	public static ITextureRegion[][] mMenuTextureRegionMenuLetters =  new ITextureRegion[50][50];
	
	public static ITextureRegion mbackGroundTextureRegion,
			mBlackBoardTextureRegion, mSlidingScreenTextureRegion,
			mWhiteChalkTextureRegion, mCursorTextureRegion,
			mPopUpBlackBoardTextureRegion, mBookIconRegion,
			mCreatePopUpRegion, mCorrectLetterRegion, 
			mHandTutorialTextureRegion,	mCrossRegion,
			mDusterTextureRegion, mHomeButtoTextureRegion; 
	

	private BuildableBitmapTextureAtlas mAnimatedBitmapTextureAtlas,
							mAnimatedMonkeyBitmapTextureAtlas;
	public static TiledTextureRegion mFishTextureRegion,
							mMonkeyTextureRegion;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasBlackBoard,
	mBitmapTextureAtlasMoOutLine, mBitmapTextureAtlasBackGround,
	mBitmapTextureAtlasWhiteChalk, mBitmapTextureAtlasCursor,
	mBitmapTextureAtlasHomeButton;
	
	
	public static BitmapTextureAtlas mBitmapTextureAtlasPieceChalk,
	 mBitmapTextureAtlasBookIcon, mBitmapTextureAtlasHandWirtingBook,
	 mBitmapTextureAtlasBoard, mBitmapTextureAtlasHandCross, 
	 mBitmapTextureAtlasDuster, mBitmapTextureAtlasMonkeyBrush,
	 mBitmapTextureAtlasHandTutorial;

	//Menu Items
	public static BitmapTextureAtlas mBitmapTextureAtlasMenuBackground;
	public static ITextureRegion mMenuBackGroundTextureRegion;
	
	
	public static BitmapTextureAtlas[] mBitmapTextureAtlasNumber = new BitmapTextureAtlas[25];
	public static ITextureRegion[] mTextureRegionNumber = new ITextureRegion[25];
	public static Sprite[] numberSprites = new Sprite[25];
	public static Sprite[] whiteChalk = new Sprite[5000];
	public static Sprite[] tutorialWhiteChalk = new Sprite[5000];
	
	public static Sprite backGround, blackBoard, OutLine, homeButton;
	public static Sprite bookIcon, handTutorial, duster, slidingScreen;
	public static Sprite createPopUp, correctLetter, drawnPicture, cross, board;
	public static AnimatedSprite cursor;
	public static AnimatedSprite monkeyTutorial;
	public static Rectangle rectangle;
	public static float moOutLineX, moOutLineY;

	public static String DEBUG_TAG = GameActivity.class.getSimpleName();
	
	public static int iCounter, screenShotCounter, shakeCounter = 0, sCounter, wCounter;
	public static int aCounter = 0, bCounter, serialCounter = 1, totalLoadNumberPic = 20;
	public static int monkeyTutorialStart;
	public static int spriteCounter, dusterCounter, dusterFinishCounter ;
	public static int spriteCounterLimit;
	public static int  state = 0;
	public static Rectangle rect;
	public static float posX;
	public static float posY;
	public static boolean isShaking, isPopupActive,
						  isHandTutorialActive, isActionMoving;
	public static int touch, popUpValue, tutorialCounter;
	public static int soundCounter;
	public static Boolean audioPlay = false;
	static MediaPlayer mediaPlayer = new MediaPlayer();
	public static TimerHandler timer1;
	
	//Screen Shot texture
	public static ScreenCapture screenCapture;
	public static TextureRegion textureRegion;
	public static BitmapTextureAtlas texture;
	public static BitmapTextureAtlasSource source;
	public static int changeTexture = 0;
	public static boolean screenShot = false;
	public static int viewWidth, viewHeight;
	
	public static int letter;
	
	//Splash Screen 
	BitmapTextureAtlas splashTextureAtlas;
	TextureRegion splashTextureRegion;
	public Sprite splash;
	public Scene splashScene;
	
	private BuildableBitmapTextureAtlas mAnimatedSplashBitmapTextureAtlas;
	public static TiledTextureRegion mAnimatedSplashTextureRegion;
	public AnimatedSprite animatedSplash;

	
	@Override
	public EngineOptions onCreateEngineOptions()
	{
		// TODO Auto-generated method stub
		MainActivityInstace = this;
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HEIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();

		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws Exception
	{
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("iWriteGFX/");
		
		mAnimatedSplashBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 2000, 267, TextureOptions.NEAREST);
		mAnimatedSplashTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedSplashBitmapTextureAtlas, this, "monkeyTutorial.png", 10, 1); 
		
		try 
		{
			this.mAnimatedSplashBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedSplashBitmapTextureAtlas.load();
		}
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
        splashTextureAtlas = new BitmapTextureAtlas(this.getTextureManager(), 500, 500, TextureOptions.DEFAULT);
        splashTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas,
        		this, "juggleMonkey.png", 0, 0);
        splashTextureAtlas.load();
		
        pOnCreateResourcesCallback.onCreateResourcesFinished();
		
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws Exception 
	{
		// TODO Auto-generated method stub
		initSplashScene();
        pOnCreateSceneCallback.onCreateSceneFinished(this.splashScene);
	}
	
	@Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback)
			throws Exception
	{
		// TODO Auto-generated method stub
		
		
		mEngine.registerUpdateHandler(new TimerHandler(1f, new ITimerCallback() 
		{
            public void onTimePassed(final TimerHandler pTimerHandler) 
            {
                mEngine.unregisterUpdateHandler(pTimerHandler);
               
                loadResources();
                loadScenes();
                splash.detachSelf();
                mEngine.setScene(mScene);
            }

		}));
		
		pOnPopulateSceneCallback.onPopulateSceneFinished();

	}
	
	public void initSplashScene() 
	{
		// TODO Auto-generated method stub
		splashScene = new Scene();
		splash = new Sprite(0, 0, splashTextureRegion, vertexBufferObjectManager)
		{
    		@Override
            protected void preDraw(GLState pGLState, Camera pCamera) 
    		{
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
    	};
    	splash.setScale((float) 0.6);
    	splash.setPosition((CAMERA_WIDTH - splash.getWidth()) * 0.5f, (CAMERA_HEIGHT - splash.getHeight()) * 0.5f);
    	splashScene.attachChild(splash);
		
//		animatedSplash = new AnimatedSprite(0, 0, mAnimatedSplashTextureRegion, vertexBufferObjectManager) 
//    	{
//    		@Override
//            protected void preDraw(GLState pGLState, Camera pCamera) 
//    		{
//                super.preDraw(pGLState, pCamera);
//                pGLState.enableDither();
//            }
//    	};
//    	
//    	//animatedSplash.setScale(1.5f);
//    	animatedSplash.setPosition((CAMERA_WIDTH - animatedSplash.getWidth()) * 0.5f, (CAMERA_HEIGHT - animatedSplash.getHeight()) * 0.5f);
//    	splashScene.attachChild(animatedSplash);
//		animatedSplash.animate(new long[] { 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100 }, 0, 9, true);
		
	}
	
	public void loadResources() 
	{
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("iWriteGFX/FilledLetters/");
		
		mBitmapTextureAtlasMoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mMoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMoFilled, this,
				"moFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasAaFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mAaFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasAaFilled, this,
				"aaFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasEFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mEFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasEFilled, this,
				"eFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasHoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mHoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHoFilled, this,
				"hoFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasRawFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mRawFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasRawFilled, this,
				"rawFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasKoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mKoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasKoFilled, this,
				"koFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasBoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mBoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBoFilled, this,
				"boFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasTalibashaFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mTalibashaFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTalibashaFilled, this,
				"talibashaFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasLoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mLoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasLoFilled, this,
				"loFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasPoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mPoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasPoFilled, this,
				"poFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasGoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mGoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasGoFilled, this,
				"goFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasKhoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mKhoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasKhoFilled, this,
				"khoFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasChoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mChoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasChoFilled, this,
				"choFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasNoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mNoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasNoFilled, this,
				"noFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasAFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mAFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasAFilled, this,
				"aFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasDoFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mDoFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasDoFilled, this,
				"doFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasUFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mUFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasUFilled, this,
				"uFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasToFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mToFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasToFilled, this,
				"toFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasTohFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mTohFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTohFilled, this,
				"tohFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasDohFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mDohFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasDohFilled, this,
				"dohFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasUkarFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mUkarFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasUkarFilled, this,
				"ukarFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasEkarFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mEkarFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasEkarFilled, this,
				"ekarFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasAkarFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mAkarFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasAkarFilled, this,
				"akarFilled.png", 0, 0,  1, 1);
		
		mBitmapTextureAtlasAakarFilled = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		mAakarFilledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasAakarFilled, this,
				"aakarFilled.png", 0, 0,  1, 1);
		
		
		
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("iWriteGFX/LetterOutLine/");
		
		
		mBitmapTextureAtlasAaOutLine= new BitmapTextureAtlas(this.getTextureManager(), 700, 600, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasEOutLine= new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasRawOutLine= new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasKoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasBoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasTalibaShaOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasLoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasPoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasGoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasHoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasKhoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasChoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasNoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasAOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasDoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasUOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasToOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasTohOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasDohOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasUkarOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasEkarOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasAkarOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasAakarOutLine = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
		
		
		
		
		mAaOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasAaOutLine, this,
				"aaExample.png", 0, 0,  1, 1);
		
		mEOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasEOutLine, this,
				"eExample.png", 0, 0,  1, 1);
		
		mRawOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasRawOutLine, this,
				"rawExample.png", 0, 0,  1, 1);
		
		mKoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasKoOutLine, this,
				"koExample.png", 0, 0,  1, 1);
		
		mBoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBoOutLine, this,
				"boExample.png", 0, 0,  1, 1);
		
		mTalibaShaOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTalibaShaOutLine, this,
				"talibaShaExample.png", 0, 0,  1, 1);
		
		mLoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasLoOutLine, this,
				"loExample.png", 0, 0,  1, 1);
		
		mPoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasPoOutLine, this,
				"poExample.png", 0, 0,  1, 1);
		
		mGoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasGoOutLine, this,
				"goExample.png", 0, 0,  1, 1);
		
		mHoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHoOutLine, this,
				"hoExample.png", 0, 0,  1, 1);
		
		mKhoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasKhoOutLine, this,
				"khoExample.png", 0, 0,  1, 1);
		
		mChoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasChoOutLine, this,
				"choExample.png", 0, 0,  1, 1);
		
		mNoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasNoOutLine, this,
				"noExample.png", 0, 0,  1, 1);
		
		mAOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasAOutLine, this,
				"aExample.png", 0, 0,  1, 1);
		
		mDoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasDoOutLine, this,
				"doExample.png", 0, 0,  1, 1);
		
		mUOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasUOutLine, this,
				"uExample.png", 0, 0,  1, 1);
		
		mToOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasToOutLine, this,
				"toExample.png", 0, 0,  1, 1);
		
		mTohOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasTohOutLine, this,
				"tohExample.png", 0, 0,  1, 1);
		
		mDohOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasDohOutLine, this,
				"dohExample.png", 0, 0,  1, 1);
		
		mUkarOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasUkarOutLine, this,
				"ukarExample.png", 0, 0,  1, 1);
		
		mEkarOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasEkarOutLine, this,
				"ekarExample.png", 0, 0,  1, 1);
		
		mAkarOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasAkarOutLine, this,
				"akarExample.png", 0, 0,  1, 1);
		
		mAakarOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasAakarOutLine, this,
				"aakarExample.png", 0, 0,  1, 1);
		
		
		
		//Menu images
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("iWriteGFX/");
		mBitmapTextureAtlasMenuBackground= new BitmapTextureAtlas(this.getTextureManager(), 1600, 864, TextureOptions.BILINEAR);
		mMenuBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
				mBitmapTextureAtlasMenuBackground, this, "JungleBG.png", 0, 0, 1, 1);
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("iWriteGFX/MenuLetters/");
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=4; j++)
			{
				mBitmapTextureAtlasMenuLetters[i][j] = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);
				mMenuTextureRegionMenuLetters[i][j] = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMenuLetters[i][j], this,
					i+""+j+".png", 0, 0,  1, 1);
			}
		}
		
		
		//Background images
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("iWriteGFX/");

		mBitmapTextureAtlasBackGround = new BitmapTextureAtlas(this.getTextureManager(), 1600, 864, TextureOptions.BILINEAR);

		mBitmapTextureAtlasBlackBoard = new BitmapTextureAtlas(this.getTextureManager(), 400, 400, TextureOptions.BILINEAR);

		mBitmapTextureAtlasMoOutLine = new BitmapTextureAtlas(this.getTextureManager(), 254, 262, TextureOptions.BILINEAR);

		mBitmapTextureAtlasWhiteChalk = new BitmapTextureAtlas(this.getTextureManager(), 50, 50, TextureOptions.BILINEAR);

		mBitmapTextureAtlasHomeButton = new BitmapTextureAtlas(this.getTextureManager(), 150, 150, TextureOptions.BILINEAR);

		
		//popup
		mBitmapTextureAtlasBookIcon = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasHandWirtingBook = new BitmapTextureAtlas(this.getTextureManager(), 1600, 800, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasBoard = new BitmapTextureAtlas(this.getTextureManager(), 600, 800, TextureOptions.BILINEAR);
		 
		mBitmapTextureAtlasHandCross = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasDuster = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasMonkeyBrush = new BitmapTextureAtlas(this.getTextureManager(), 1300, 600, TextureOptions.BILINEAR);

		mBitmapTextureAtlasHandTutorial = new BitmapTextureAtlas(this.getTextureManager(), 100, 100, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasDuster = new BitmapTextureAtlas(this.getTextureManager(), 200, 200, TextureOptions.BILINEAR);
		
		mBitmapTextureAtlasMonkeyBrush = new BitmapTextureAtlas(this.getTextureManager(), 1300, 600, TextureOptions.BILINEAR);

		//popup
		mBookIconRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBookIcon, this,
				"bookIcon.png", 0, 0,  1, 1);
				
		mCreatePopUpRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHandWirtingBook, this,
				"handwritingbook.png", 0, 0,  1, 1);
				
		mCrossRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHandCross, this,
				"cross.png", 0, 0,  1, 1);
		
		mDusterTextureRegion =  BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasDuster, this,
				"duster.png", 0, 0,  1, 1);
				
		mHandTutorialTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasHandTutorial, this,
				"hand.png", 0, 0,  1, 1);
		
		mPopUpBlackBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasBoard, this,
				"board3.png", 0, 0,  1, 1); 
		
		mDusterTextureRegion =  BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasDuster, this,
				"duster.png", 0, 0,  1, 1);
		
		mSlidingScreenTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBitmapTextureAtlasMonkeyBrush, this,
				"monkeyBrush3.png", 0, 0,  1, 1);

		
		
		// All the numbers
		for (int i = 1; i <= totalLoadNumberPic; i++) 
		{
			mBitmapTextureAtlasNumber[i] = new BitmapTextureAtlas(
					this.getTextureManager(), 150, 150, TextureOptions.BILINEAR);
		}

		mbackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasBackGround, this,
						"JungleBG.png", 0, 0, 1, 1);

		mBlackBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasBlackBoard, this,
						"board2.png", 0, 0, 1, 1);

		mMoOutLineTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasMoOutLine, this,
						"moOutlineCrop.png", 0, 0, 1, 1);

		mWhiteChalkTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasWhiteChalk, this,
						"chalk2.png", 0, 0, 1, 1);
		
		mHomeButtoTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(mBitmapTextureAtlasHomeButton, this,
						"homeButton.png", 0, 0, 1, 1);

		// All the numbers
		for (int i = 1; i <= 4; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + i + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 5; i <= 7; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-4) + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 8; i <= 9; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-7) + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 10; i <= 13; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-9) + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 14; i <= 17; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-13) + ".png", 0, 0, 1, 1);
		}
		
		for (int i = 18; i <= 20; i++) 
		{
			mTextureRegionNumber[i] = BitmapTextureAtlasTextureRegionFactory
					.createTiledFromAsset(mBitmapTextureAtlasNumber[i], this,
							"Number" + (i-17) + ".png", 0, 0, 1, 1);
		}
		
		mBitmapTextureAtlasBackGround.load();
		mBitmapTextureAtlasBlackBoard.load();
		mBitmapTextureAtlasWhiteChalk.load();
		mBitmapTextureAtlasHomeButton.load();
		
		mBitmapTextureAtlasBookIcon.load();
		mBitmapTextureAtlasHandWirtingBook.load();
		mBitmapTextureAtlasBoard.load();
		mBitmapTextureAtlasHandCross.load();
		mBitmapTextureAtlasDuster.load();
		mBitmapTextureAtlasMonkeyBrush.load();
		mBitmapTextureAtlasHandTutorial.load();
		
		mBitmapTextureAtlasMoFilled.load();
		mBitmapTextureAtlasAaFilled.load();
		mBitmapTextureAtlasEFilled.load();
		mBitmapTextureAtlasHoFilled.load();
		mBitmapTextureAtlasRawFilled.load();
		mBitmapTextureAtlasKoFilled.load();
		mBitmapTextureAtlasBoFilled.load();
		mBitmapTextureAtlasTalibashaFilled.load();
		mBitmapTextureAtlasLoFilled.load();
		mBitmapTextureAtlasPoFilled.load();
		mBitmapTextureAtlasGoFilled.load();
		mBitmapTextureAtlasKhoFilled.load();
		mBitmapTextureAtlasChoFilled.load();
		mBitmapTextureAtlasNoFilled.load();
		mBitmapTextureAtlasAFilled.load();
		mBitmapTextureAtlasDoFilled.load();
		mBitmapTextureAtlasUFilled.load();
		mBitmapTextureAtlasToFilled.load();
		mBitmapTextureAtlasTohFilled.load();
		mBitmapTextureAtlasDohFilled.load();
		mBitmapTextureAtlasUkarFilled.load();
		mBitmapTextureAtlasEkarFilled.load();
		mBitmapTextureAtlasAkarFilled.load();
		mBitmapTextureAtlasAakarFilled.load();
		
		
		mBitmapTextureAtlasMoOutLine.load();
		mBitmapTextureAtlasAaOutLine.load();
		mBitmapTextureAtlasEOutLine.load();
		mBitmapTextureAtlasRawOutLine.load();
		mBitmapTextureAtlasKoOutLine.load();
		mBitmapTextureAtlasBoOutLine.load();
		mBitmapTextureAtlasTalibaShaOutLine.load();
		mBitmapTextureAtlasLoOutLine.load();
		mBitmapTextureAtlasPoOutLine.load();
		mBitmapTextureAtlasGoOutLine.load(); 
		mBitmapTextureAtlasHoOutLine.load();
		mBitmapTextureAtlasKoOutLine.load();
		mBitmapTextureAtlasKhoOutLine.load();
		mBitmapTextureAtlasChoOutLine.load();
		mBitmapTextureAtlasNoOutLine.load();
		mBitmapTextureAtlasAOutLine.load();
		mBitmapTextureAtlasDoOutLine.load();
		mBitmapTextureAtlasUOutLine.load();
		mBitmapTextureAtlasToOutLine.load();
		mBitmapTextureAtlasTohOutLine.load();
		mBitmapTextureAtlasDohOutLine.load();
		mBitmapTextureAtlasUkarOutLine.load();
		mBitmapTextureAtlasEkarOutLine.load();
		mBitmapTextureAtlasAkarOutLine.load();
		mBitmapTextureAtlasAakarOutLine.load();
		
		//Menu
		mBitmapTextureAtlasMenuBackground.load();
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=4; j++)
			{
				mBitmapTextureAtlasMenuLetters[i][j].load();
			}
		}
		
		// All the numbers
		for (int i = 1; i <= totalLoadNumberPic; i++) 
		{
			mBitmapTextureAtlasNumber[i].load();
		}

		mAnimatedBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 614, 104, TextureOptions.NEAREST);
		mFishTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedBitmapTextureAtlas, this, "fish.png", 6, 1);
		
		try 
		{
			this.mAnimatedBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
		mAnimatedMonkeyBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 2000, 267, TextureOptions.NEAREST);
		mMonkeyTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedMonkeyBitmapTextureAtlas, this, "monkeyTutorial.png", 10, 1);
		
		try 
		{
			this.mAnimatedMonkeyBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedMonkeyBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
	}
	
	public void loadScenes() 
	{
		// TODO Auto-generated method stub
		mScene = new Scene();
		mScene.setOnSceneTouchListener(this);
		
		//Initializing all the variables
		vertexBufferObjectManager = getVertexBufferObjectManager();
		
		serialCounter = 1;
		sCounter = 0;
		wCounter = 0;
		monkeyTutorialStart = 0;
		state = 0;
		spriteCounter = 1;
		spriteCounterLimit = 0;
		posX = 0;
		posY = 0;
		isShaking = false;
		isPopupActive  = false;
		isHandTutorialActive = false;
		isActionMoving = true;
		touch = 0;
		soundCounter=0;
		bCounter = 0;
		changeTexture = 0;
		screenShotCounter = 0;
		tutorialCounter = 0;
		dusterCounter = 0;
		dusterFinishCounter = 0;
		letter = 0;

		//getting the renderView width and height for taking the screen shot
		viewWidth = GameActivity.MainActivityInstace.mRenderSurfaceView.getWidth() - 470;
		viewHeight = GameActivity.MainActivityInstace.mRenderSurfaceView.getHeight() - 90;
		
		moOutLineX = CAMERA_WIDTH / 2 - 130;
		moOutLineY = CAMERA_HEIGHT / 2 - 130;
		
		//Timer for drawing during monkey Tutorial
		AnimationDrawTutorial.animationDrawTimer();
		mScene.registerUpdateHandler(timer1);
				
		//1.Mo 2.Aa 3.e 4.Raw 5.Ko 6.Bo 7.TalibaSha 8.Lo 9.Po 10.Go 11.Ho
		//12.Kho 13.Cho 14.No 15.A 16.Do 17.U 18.To 19.Toh 20.Doh 21.Ukar
		//22.Ekar 23.Akar 24.Aakar
		 
//		//choose the letter with number
		GameActivity.letter = HandWritingMenu.letterNumber; 
//		//create objects
		createObjects.createObject();
//		
//		//create book icon
////		PopUp.createBookIcon();
////		HandTutorial.handTutorialCreate();
//
//		//create number with cursor
//		//AnimationDrawTutorial.createNumberSpriteAndCursor(2);
	}

	// to change the current main scene
	public static void setCurrentScene(Scene scene) 
	{
	    mScene = scene;
	    GameActivity.MainActivityInstace.getEngine().setScene(mScene);
	}
	
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) 
	{
		// TODO Auto-generated method stub
		return Touch.touchEvent(pSceneTouchEvent);
	}

}
