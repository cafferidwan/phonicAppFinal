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
import org.andengine.util.debug.Debug;
import org.andengine.util.modifier.ease.EaseSineInOut;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

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
	
	public static Sprite backGround, moi, mama, tala, langol, banana, megh, mohis, monkey1, banana2, monkey2;
	public static Camera mCamera;

	public static BitmapTextureAtlas mBitmapTextureAtlasMoi;
	public static BitmapTextureAtlas mBitmapTextureAtlasMama;
	public static BitmapTextureAtlas mBitmapTextureAtlasTala;
	public static BitmapTextureAtlas mBitmapTextureAtlasLangol;
	public static BitmapTextureAtlas mBitmapTextureAtlasBanana;
	public static BitmapTextureAtlas mBitmapTextureAtlasMegh;
	public static BitmapTextureAtlas mBitmapTextureAtlasMohis;
	
	public static BitmapTextureAtlas mBitmapTextureAtlasM1, mBitmapTextureAtlasM2;
	
	public static Scene mScene;
	public static ITextureRegion mFaceTextureRegionMoi;
	public static ITextureRegion mFaceTextureRegionMama;
	public static ITextureRegion mFaceTextureRegionTala;
	public static ITextureRegion mFaceTextureRegionLangol;
	public static ITextureRegion mFaceTextureRegionBanana;
	public static ITextureRegion mFaceTextureRegionMegh;
	public static ITextureRegion mFaceTextureRegionMohis;
	
	public static ITextureRegion mFaceTextureRegionM1, mFaceTextureRegionM2;
	
	static float mFaceCount = -60;

	public static int aCount = 0;
	public static int randomItem, randomItem1;
	
	public static Sprite[] position = new Sprite[7];
	public static float bananaX, bananaY;
	
	static float ImageHeight;
	static float ImageWidth;
	
	static float ImageHeightObjects;
	static float ImageWidthObjects;
	
	public static VertexBufferObjectManager vbo;
	static Boolean audioPlay = false;
	static MediaPlayer mediaPlayer = new MediaPlayer();
	
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
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		ImageHeight = CAMERA_HEIGHT/1.1f;
		ImageWidth = CAMERA_WIDTH/6.0f;
		
		ImageHeightObjects = CAMERA_HEIGHT/6.0f;
		ImageWidthObjects = CAMERA_WIDTH/8.5f;
		
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	}

	@Override
	public void onCreateResources() 
	{
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("monkeyGameGfx/");
		
		mBitmapAtlas = new BitmapTextureAtlas(getTextureManager(), 1600, 864,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		mTexture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapAtlas, getAssets(), "bg-1.png", 0, 0);

		mBitmapTextureAtlasMoi = new BitmapTextureAtlas(getTextureManager(), 120, 120, TextureOptions.BILINEAR);
		mBitmapTextureAtlasMama = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasTala = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasLangol = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasBanana = new BitmapTextureAtlas(getTextureManager(), 200, 200);
		mBitmapTextureAtlasMegh = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		mBitmapTextureAtlasMohis = new BitmapTextureAtlas(getTextureManager(), 120, 120);
		
		mBitmapTextureAtlasM1 = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		mBitmapTextureAtlasM2 = new BitmapTextureAtlas(getTextureManager(), 208, 682, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		
		mFaceTextureRegionMoi = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMoi, this, "moi-2.png", 0, 0);
		mFaceTextureRegionMama = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMama, this, "mama-2.png",0,0);
		mFaceTextureRegionTala = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasTala, this, "tala.png",0,0);
		mFaceTextureRegionLangol = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasLangol, this, "langol.png",0,0);
		mFaceTextureRegionBanana = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasBanana, this, "banana.png",0,0);
		mFaceTextureRegionMegh = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMegh, this, "megh-2.png",0,0);
		mFaceTextureRegionMohis = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasMohis, this, "mohis-2.png",0,0);
		
		
		mFaceTextureRegionM1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasM1, this, "m1.png",0,0);
		mFaceTextureRegionM2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mBitmapTextureAtlasM2, this, "m2.png",0,0);
		
		
		mBitmapAtlas.load();
		
		mBitmapTextureAtlasMoi.load();
		mBitmapTextureAtlasMama.load();
		mBitmapTextureAtlasTala.load();
		mBitmapTextureAtlasLangol.load();
		mBitmapTextureAtlasBanana.load();
		mBitmapTextureAtlasMegh.load();
		mBitmapTextureAtlasMohis.load();
		
		mBitmapTextureAtlasM1.load();
		mBitmapTextureAtlasM2.load();
		
	}
	
	@Override
	public Scene onCreateScene() 
	{
		/* Just a simple */
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));
		vbo = getVertexBufferObjectManager();
		
		
		backGround = new Sprite(0, 0, mTexture,getVertexBufferObjectManager());
		backGround.setWidth(CAMERA_WIDTH);
		backGround.setHeight(CAMERA_HEIGHT);
		mScene.attachChild(backGround);
		
		mScene.registerUpdateHandler(new TimerHandler(5, true,new ITimerCallback()
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				// TODO Auto-generated method stub
				


				randomItem = (int)(Math.random()*6);
				randomItem1 = (int)(Math.random()*6);
				if(randomItem == randomItem1)
				{
					randomItem1 = randomItem1+1;
				}
				
				switch(randomItem)
				{
					case 0:
							GameObjects.moi(1);
					break;
					
					case 1:
							GameObjects.mama(1);
					break;
					
					case 2:
							GameObjects.tala(1);
					break;
					
					case 3:
							GameObjects.langol(1);
					break;
					
					case 4:
							GameObjects.mohis(1);
					break;
						
					case 5:
							GameObjects.megh(1);
					break;

					default:

					break;
				}
				
				switch(randomItem1)
				{
					case 0:
							GameObjects.moi(2);
					break;
					
					case 1:
							GameObjects.mama(2);
					break;
					
					case 2:
							GameObjects.tala(2);
					break;
					
					case 3:
							GameObjects.langol(2);
					break;
					
					case 4:
							GameObjects.mohis(2);
					break;
						
					case 5:
							GameObjects.megh(2);
					break;
					
					default:

					break;
				}
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
			removeFace((Sprite) pTouchArea);
			return true;
		}
		return false;
	}

	public static void removeFace(Sprite pTouchArea)
	{
		// TODO Auto-generated method stub
		
		if((Sprite)pTouchArea==tala)
		{
			audioPlay = true;
			playAudio(R.raw.tala);
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
			if(position[aCount]==null)
			{

			}
			else
			{
				bananaX=position[aCount].getX();
				bananaY=position[aCount].getY();
				
				monkey1();
			}
		}
		else if((Sprite)pTouchArea==langol)
		{
			audioPlay = true;
			playAudio(R.raw.langol);
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
			if(position[aCount]==null)
			{

			}
			else
			{
				bananaX=position[aCount].getX();
				bananaY=position[aCount].getY();
				
				monkey1();
			}
		}

		else if((Sprite)pTouchArea==mama)
		{
			audioPlay = true;
			playAudio(R.raw.mama);
			addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
		}
		else if((Sprite)pTouchArea==megh)
		{
			audioPlay = true;
			playAudio(R.raw.megh);
			addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
		}
		else if((Sprite)pTouchArea==moi)
		{
			audioPlay = true;
			playAudio(R.raw.moi);
			addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
		} 
		else if((Sprite)pTouchArea==mohis)
		{
			audioPlay = true;
			playAudio(R.raw.mohis);
			addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
			mScene.unregisterTouchArea(pTouchArea);
			mScene.detachChild(pTouchArea);
		}

	}

	private static void addFace(final float pX, final float pY) 
	{
		distance = (float) (CAMERA_WIDTH/5.3 )-5;
		mFaceCount = mFaceCount+distance;
		aCount = aCount+1;
		
		if(aCount==5)
		{

			mScene.clearUpdateHandlers();
			mScene.clearEntityModifiers();
			mScene.clearTouchAreas();
			mScene.clearChildScene();
			
			mScene.registerUpdateHandler(new TimerHandler(2, new ITimerCallback() 
			{
				
				@Override
				public void onTimePassed(TimerHandler pTimerHandler)
				{
					// TODO Auto-generated method stub
					startActivity();
				}
			}));
		}
			position[aCount] = new Sprite(0, 50 , mFaceTextureRegionBanana,MonkeyGameActivity.vbo);
			position[aCount].setWidth(ImageWidthObjects);
			position[aCount].setHeight(ImageHeightObjects);
			final Path bananaPath = new Path(2).to(CAMERA_WIDTH/2, -50).to(mFaceCount, CAMERA_HEIGHT - CAMERA_HEIGHT/3 + 30 );
			
				position[aCount].registerEntityModifier(new PathModifier(1, bananaPath, null, new IPathModifierListener() {
				@Override
				public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) {
					Debug.d("onPathStarted");
				}

				@Override
				public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) {
					Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				}

				@Override
				public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) {
					Debug.d("onPathWaypointFinished: " + pWaypointIndex);
				}

				@Override
				public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity)
				{
					Debug.d("onPathFinished");
					
					bananaX=position[aCount].getX();
					bananaY=position[aCount].getY();
				}
			}, EaseSineInOut.getInstance()));
		
			mScene.attachChild(position[aCount]);
			mScene.registerTouchArea(position[aCount]);
		}

	
	
	public static void monkey1()
	{
		monkey1 = new Sprite(0, 50, mFaceTextureRegionM1, MonkeyGameActivity.vbo);
		monkey1.setWidth(ImageWidth);
		monkey1.setHeight(ImageHeight);
		mScene.attachChild(monkey1);
		monkey1.setVisible(true);
		
		final Path monkey1Path = new Path(2).to(CAMERA_WIDTH/2,-400).to(bananaX,(float) (bananaY-CAMERA_HEIGHT/1.4)); 
		monkey1.registerEntityModifier(new PathModifier(2, monkey1Path, null, new IPathModifierListener() 
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				Debug.d("onPathStarted");
			}

			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}

			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex)
			{
				Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity)
			{
				Debug.d("onPathFinished");
				monkey1.setVisible(false);
				mFaceCount=mFaceCount-distance;
				
				monkey2();
			}
		}, EaseSineInOut.getInstance()));
	}
	
	public static void monkey2()
	{
		monkey2 = new Sprite(bananaX, (float) (bananaY-CAMERA_HEIGHT/1.4), mFaceTextureRegionM2, MonkeyGameActivity.vbo);
		monkey2.setWidth(ImageWidth);
		monkey2.setHeight(ImageHeight);
		mScene.attachChild(monkey2);
		
		final Path monkey2Path = new Path(2).to(bananaX,(float) (bananaY-CAMERA_HEIGHT/1.4)).to(CAMERA_WIDTH/2,-500);
		monkey2.registerEntityModifier(new PathModifier((float)1.5, monkey2Path, null, new IPathModifierListener()
		{
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				Debug.d("onPathStarted");
			}
			@Override
			public void onPathWaypointStarted(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				Debug.d("onPathWaypointStarted:  " + pWaypointIndex);
				
			}
			@Override
			public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) 
			{
				Debug.d("onPathWaypointFinished: " + pWaypointIndex);
			}

			@Override
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) 
			{
				Debug.d("onPathFinished");
				monkey2.setVisible(false);
			}
		}, EaseSineInOut.getInstance()));
		
		mScene.detachChild(position[aCount]);
		position[aCount]=null;
		aCount = aCount - 1;
	}
	
	public static void startActivity()
	{
		activity.finish();
		activity.startActivity(new Intent(activity, MonkeyGameActivity.class));
		aCount = 0;
		mFaceCount = -60;
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