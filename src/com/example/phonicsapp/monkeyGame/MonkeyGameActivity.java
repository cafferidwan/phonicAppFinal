package com.example.phonicsapp.monkeyGame;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
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
import org.andengine.util.modifier.ease.EaseSineInOut;
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
	static MonkeyGameActivity activity;
	
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
	
	//Letter-mo
	public static BitmapTextureAtlas mBitmapTextureAtlasMoi;
	public static BitmapTextureAtlas mBitmapTextureAtlasMama;
	public static BitmapTextureAtlas mBitmapTextureAtlasTala;
	public static BitmapTextureAtlas mBitmapTextureAtlasLangol;
	public static BitmapTextureAtlas mBitmapTextureAtlasMegh;
	public static BitmapTextureAtlas mBitmapTextureAtlasMohis;
	
	public static ITextureRegion mFaceTextureRegionMoi;
	public static ITextureRegion mFaceTextureRegionMama;
	public static ITextureRegion mFaceTextureRegionTala;
	public static ITextureRegion mFaceTextureRegionLangol;
	public static ITextureRegion mFaceTextureRegionMegh;
	public static ITextureRegion mFaceTextureRegionMohis;
	
	//Letter-a
	public BitmapTextureAtlas mBitmapTextureAtlasMach;
	public BitmapTextureAtlas mBitmapTextureAtlasMula;
	public BitmapTextureAtlas mBitmapTextureAtlasPen;
	public BitmapTextureAtlas mBitmapTextureAtlasAnaros;
	public BitmapTextureAtlas mBitmapTextureAtlasMa;
	public BitmapTextureAtlas mBitmapTextureAtlasMohis1;
	
	public static ITextureRegion mFaceTextureRegionMach;
	public static ITextureRegion mFaceTextureRegionMula;
	public static ITextureRegion mFaceTextureRegionPen;
	public static ITextureRegion mFaceTextureRegionAnaros;
	public static ITextureRegion mFaceTextureRegionMa;
	public static ITextureRegion mFaceTextureRegionMohis1;
	
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
		activity = this;
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
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("monkeyGameGfx/");
		
		mBitmapAtlas = new BitmapTextureAtlas(getTextureManager(), 1600, 868,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mTexture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapAtlas, getAssets(), "bg-3.png", 0, 0);

		//Letter-Mo
		mBitmapTextureAtlasMoi = new BitmapTextureAtlas(getTextureManager(), 120, 120, TextureOptions.BILINEAR);
		mBitmapTextureAtlasMama = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasTala = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasLangol = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasMegh = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasMohis = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		
		mFaceTextureRegionMoi = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMoi, this, "LetterMo/moi-2.png", 0, 0);
		mFaceTextureRegionMama = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMama, this, "LetterMo/mama-2.png",0,0);
		mFaceTextureRegionMegh = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMegh, this, "LetterMo/megh.png",0,0);
		mFaceTextureRegionMohis = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMohis, this, "LetterMo/mohis-2.png",0,0);
		mFaceTextureRegionTala = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTala, this, "LetterMo/tala.png",0,0);
		mFaceTextureRegionLangol = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasLangol, this, "LetterMo/langol.png",0,0);
		
		//Letter-A
		mBitmapTextureAtlasMach = new BitmapTextureAtlas(getTextureManager(), 120, 120, TextureOptions.BILINEAR);
		mBitmapTextureAtlasMula = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasPen = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasAnaros = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasMa = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasMohis1 = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		
		mFaceTextureRegionMach = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMach, this, "LetterA/keramBoard1.png", 0, 0);
		mFaceTextureRegionMula = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMula, this, "LetterA/mas.png",0,0);
		mFaceTextureRegionPen = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasPen, this, "LetterA/ma.png",0,0);
		mFaceTextureRegionAnaros = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasAnaros, this, "LetterA/pineapple.png",0,0);
		mFaceTextureRegionMa = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMa, this, "LetterA/mula-2.png",0,0);
		mFaceTextureRegionMohis1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMohis1, this, "LetterA/mohis-2.png",0,0);
		
		//Fixed Objects- monkey1, monkey2, banana
		mBitmapTextureAtlasM1 = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasM2 = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasBanana = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		
		mFaceTextureRegionM1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasM1, this, "m4.png",0,0);
		mFaceTextureRegionM2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasM2, this, "m3.png",0,0);
		mFaceTextureRegionBanana = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBanana, this, "banana-1.png",0,0);
		
		
		mBitmapAtlas.load();
		
		//Letter-mo
		mBitmapTextureAtlasMoi.load();
		mBitmapTextureAtlasMama.load();
		mBitmapTextureAtlasTala.load();
		mBitmapTextureAtlasLangol.load();
		mBitmapTextureAtlasMegh.load();
		mBitmapTextureAtlasMohis.load();
		
		//Letter-A
		mBitmapTextureAtlasMach.load();
		mBitmapTextureAtlasMula.load();
		mBitmapTextureAtlasPen.load();
		mBitmapTextureAtlasAnaros.load();
		mBitmapTextureAtlasMa.load();
		mBitmapTextureAtlasMohis1.load();
		
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
		
		mScene.registerUpdateHandler(new TimerHandler(1, true, new ITimerCallback() 
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) 
			{
				// TODO Auto-generated method stub
				
				if(value == 1)
				{
					monkey1();
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
					addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
				}
			}
		}));
		
		//Choosing random items 
		mScene.registerUpdateHandler(new TimerHandler(5, true, new ITimerCallback()
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				// TODO Auto-generated method stub
				
				//Loading the Objects according to the game content
				LoadObjects(1);
				
				randomItem = (int)(Math.random()*6);
				randomItem1 = (int)(Math.random()*6);
				if(randomItem == randomItem1 )
				{
					randomItem1 = randomItem1+2;
				}
				
				if(randomItem == 0 &&  randomItem1==1 || randomItem == 1 &&  randomItem1==0)
				{
					randomItem1 = randomItem1+2;
				}
				switch(randomItem)
				{
					case 0:
							GameObjects.wrongObj1(1);
					break;
					
					case 1:
							GameObjects.wrongObj2(1);
					break;
					
					case 2:
							GameObjects.obj1(1);
					break;
					
					case 3:
							GameObjects.obj2(1);
					break;
					
					case 4:
							GameObjects.obj4(1);
					break;
						
					case 5:
							GameObjects.obj3(1);
					break;

					default:
							GameObjects.obj3(1);
					break;
				}
				
				switch(randomItem1)
				{
					case 0:
						GameObjects.wrongObj1(2);
					break;
			
					case 1:
						GameObjects.wrongObj2(2);
					break;
			
					case 2:
						GameObjects.obj1(2);
					break;
			
					case 3:
						GameObjects.obj2(2);
					break;
			
					case 4:
						GameObjects.obj4(2);
					break;
				
					case 5:
						GameObjects.obj3(2);
					break;
					
					default:
							GameObjects.obj1(2);
					break;
				}
			}
		}));
		
		mScene.setOnAreaTouchListener(this);
		return mScene;
	}

	public static void LoadObjects(int i) 
	{
		// TODO Auto-generated method stub
		if(i == 1)
		{
			obj1 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMoi, MonkeyGameActivity.vbo);
			obj2 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMama, MonkeyGameActivity.vbo);
			obj3 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMegh, MonkeyGameActivity.vbo);
			obj4 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMohis, MonkeyGameActivity.vbo);
		
			wrongObj1 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionTala, MonkeyGameActivity.vbo);	
			wrongObj2 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionLangol, MonkeyGameActivity.vbo);
			
			obj1Sound = R.raw.moi;
			obj2Sound = R.raw.mama;
			obj3Sound = R.raw.megh;
			obj4Sound = R.raw.mohis;
			
			wrongObj1Sound = R.raw.tala;
			wrongObj2Sound = R.raw.langol;
		}
		else if(i == 2)
		{
			obj1 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMach, MonkeyGameActivity.vbo);
			obj2 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMula, MonkeyGameActivity.vbo);
			obj3 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMegh, MonkeyGameActivity.vbo);
			obj4 = new Sprite(0, 0, MonkeyGameActivity.mFaceTextureRegionMohis1, MonkeyGameActivity.vbo);
		
			wrongObj1 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionPen, MonkeyGameActivity.vbo);	
			wrongObj2 = new Sprite(0, 50, MonkeyGameActivity.mFaceTextureRegionAnaros, MonkeyGameActivity.vbo);
			
			obj1Sound = R.raw.mo;
			obj2Sound = R.raw.mula;
			obj3Sound = R.raw.megh;
			obj4Sound = R.raw.mohis;
			
			wrongObj1Sound = R.raw.akar;
			wrongObj2Sound = R.raw.aam;
		}
	}

	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,ITouchArea pTouchArea, float pTouchAreaLocalX,float pTouchAreaLocalY) 
	{
		// TODO Auto-generated method stub
		
		if (pSceneTouchEvent.isActionDown()) 
		{
			removeFace((Sprite) pTouchArea);
			return true;
		}
		return false;
	}

	public static void removeFace(Sprite pTouchArea)
	{
		// TODO Auto-generated method stub
		
		if((Sprite)pTouchArea==wrongObj1)
		{
			audioPlay = true;
			playAudio(wrongObj1Sound);
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(obj3);
			GameObjects.fadeOut(obj1);
			GameObjects.fadeOut(obj4);
			GameObjects.fadeOut(obj2);
			GameObjects.fadeOut(wrongObj2);

			if(position[aCount]==null)
			{

			}
			else
			{
				value = 1;
			}
		}
		else if((Sprite)pTouchArea==wrongObj2)
		{
			audioPlay = true;
			playAudio(wrongObj2Sound);
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(obj3);
			GameObjects.fadeOut(obj1);
			GameObjects.fadeOut(obj4);
			GameObjects.fadeOut(wrongObj1);
			GameObjects.fadeOut(obj2);
			
			if(position[aCount]==null)
			{

			}
			else
			{	
				value = 1;
			}
		}
		
		else if((Sprite)pTouchArea==obj1)
		{
			audioPlay = true;
			playAudio(obj1Sound);
			bananaValue = 1;
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(obj3);
			GameObjects.fadeOut(obj2);
			GameObjects.fadeOut(obj4);
			GameObjects.fadeOut(wrongObj1);
			GameObjects.fadeOut(wrongObj2);
		} 
		else if((Sprite)pTouchArea==obj2)
		{
			audioPlay = true;
			playAudio(obj2Sound);
			bananaValue = 1;
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(obj3);
			GameObjects.fadeOut(obj1);
			GameObjects.fadeOut(obj4);
			GameObjects.fadeOut(wrongObj1);
			GameObjects.fadeOut(wrongObj2);
		}
		else if((Sprite)pTouchArea==obj3)
		{
			audioPlay = true;
			playAudio(obj3Sound);
			bananaValue = 1;
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(obj2);
			GameObjects.fadeOut(obj1);
			GameObjects.fadeOut(obj4);
			GameObjects.fadeOut(wrongObj1);
			GameObjects.fadeOut(wrongObj2);
		}
		else if((Sprite)pTouchArea==obj4)
		{
			audioPlay = true;
			playAudio(obj4Sound);
			bananaValue = 1;
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(obj3);
			GameObjects.fadeOut(obj1);
			GameObjects.fadeOut(obj2);
			GameObjects.fadeOut(wrongObj1);
			GameObjects.fadeOut(wrongObj2);
		}

	}

	public void addFace(final float pX, final float pY) 
	{
		distance = (float) (CAMERA_WIDTH/5.3 );
		mFaceCount = mFaceCount+distance;
		aCount = aCount+1;
		bananaValue = 0;
		
		if(aCount==5)
		{

			mScene.clearUpdateHandlers();
			mScene.clearEntityModifiers();
			mScene.clearTouchAreas();
			mScene.clearChildScene();
			//Finishing the game
			mScene.registerUpdateHandler(new TimerHandler(2, new ITimerCallback() 
			{
				
				@Override
				public void onTimePassed(TimerHandler pTimerHandler)
				{
					// TODO Auto-generated method stub
					aCount = 0;
					mFaceCount = -100;
					startActivity();
				}
			}));
		}
			position[aCount] = new Sprite(0, 50 , mFaceTextureRegionBanana,MonkeyGameActivity.vbo); 
			mScene.attachChild(position[aCount]);
			mScene.registerTouchArea(position[aCount]);
			
			position[aCount].setWidth(ImageWidthObjects-22);
			position[aCount].setHeight(ImageHeightObjects-22);
			final Path bananaPath = new Path(2).to(CAMERA_WIDTH/2, -100).to(mFaceCount, CAMERA_HEIGHT - CAMERA_HEIGHT/3 + 30 );
			
			position[aCount].registerEntityModifier(new PathModifier((float) 1, bananaPath, null, new IPathModifierListener() 
			{
				@Override
				public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
				{
					//Debug.d("onPathStarted");
				}

				@Override
				public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
				{
					//Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				}

				@Override
				public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
				{
					//Debug.d("onPathWaypointFinished: " + pWaypointIndex);
				}

				@Override
				public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity)
				{
					//Debug.d("onPathFinished");
					
				}
			}, EaseSineInOut.getInstance()));
		}

	public static void monkey1()
	{
		monkey1 = new Sprite(0, 50, mFaceTextureRegionM1, MonkeyGameActivity.vbo);
		monkey1.setWidth(ImageWidth);
		monkey1.setHeight(ImageHeight);
		mScene.attachChild(monkey1);
		monkey1.setVisible(true);
		
		value = 0;
		
		final Path monkey1Path = new Path(2).to(CAMERA_WIDTH/2,-400).to(position[aCount].getX(),(float) (position[aCount].getY()-CAMERA_HEIGHT/1.4)); 
		monkey1.registerEntityModifier(new PathModifier((float) 1.1, monkey1Path, null, new IPathModifierListener() 
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				//Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				//Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity)
			{
				//Debug.d("onPathFinished");
				monkey1.setVisible(false);
				mFaceCount=mFaceCount-distance;
				
				monkey2();
			}
		}, EaseSineInOut.getInstance()));
	}
	
	public static void monkey2()
	{
		monkey2 = new Sprite(position[aCount].getX(), (float) (position[aCount].getY()-CAMERA_HEIGHT/1.4), mFaceTextureRegionM2, MonkeyGameActivity.vbo);
		monkey2.setWidth(ImageWidth);
		monkey2.setHeight(ImageHeight);
		mScene.attachChild(monkey2);
		
		final Path monkey2Path = new Path(2).to(position[aCount].getX(),(float) (position[aCount].getY()-CAMERA_HEIGHT/1.4)).to(CAMERA_WIDTH/2,-600);
		monkey2.registerEntityModifier(new PathModifier((float)1.1, monkey2Path, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//Debug.d("onPathStarted");
			}
			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				//Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}
			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				//Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				//Debug.d("onPathFinished");
				monkey2.setVisible(false);
			}
		}, EaseSineInOut.getInstance()));
		
		mScene.detachChild(position[aCount]);
		position[aCount]=null;
		aCount = aCount - 1;
	}
	
	public void startActivity()
	{
		activity.finish();
		activity.startActivity(new Intent(activity, GameMainPage.class));
	}
	
	//Audio play Function
	public static void playAudio(int val)
	{
		if(audioPlay)
		{
			if(!mediaPlayer.isPlaying())
			{
				mediaPlayer.reset();
				mediaPlayer = MediaPlayer.create(activity, val);
					
				try 
				{
					mediaPlayer.start();
					mediaPlayer.setLooping(false);
				} 
				catch (IllegalStateException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			audioPlay = true;
		}
	}
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}