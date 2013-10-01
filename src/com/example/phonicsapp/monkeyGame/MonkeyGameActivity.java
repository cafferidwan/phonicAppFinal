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
import org.andengine.entity.util.FPSLogger;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;
import org.andengine.util.modifier.ease.EaseSineInOut;

import android.util.Log;


public class MonkeyGameActivity  extends SimpleBaseGameActivity implements IOnAreaTouchListener {
	// ===========================================================
	// Constants
	// ===========================================================
	
	private static final int CAMERA_WIDTH = 320;
	private static final int CAMERA_HEIGHT = 480;
	public String DEBUG_TAG = MonkeyGameActivity.class.getSimpleName();
	// ===========================================================
	// Fields
	// ===========================================================
	
	private BitmapTextureAtlas texImage;
	private TextureRegion regImage;
	
	public Sprite sprImage, croc, pen, ball, banana, jacKFruit, keramBoard, monkey1, monkey2, monkey3;
	private Camera mCamera;

	private BitmapTextureAtlas mBitmapTextureAtlasCroc;
	private BitmapTextureAtlas mBitmapTextureAtlasPen;
	private BitmapTextureAtlas mBitmapTextureAtlasBall;
	private BitmapTextureAtlas mBitmapTextureAtlasBanana;
	private BitmapTextureAtlas mBitmapTextureAtlasJackFruit;
	private BitmapTextureAtlas mBitmapTextureAtlasKeramBoard;
	
	private BitmapTextureAtlas mBitmapTextureAtlasM1;
	private BitmapTextureAtlas mBitmapTextureAtlasM2;
	private BitmapTextureAtlas mBitmapTextureAtlasM3;
	
	
	
	private Scene mMainScene;
	private ITextureRegion mFaceTextureRegionCroc;
	private ITextureRegion mFaceTextureRegionPen;
	private ITextureRegion mFaceTextureRegionBall;
	private ITextureRegion mFaceTextureRegionBanana;
	private ITextureRegion mFaceTextureRegionJackFruit;
	private ITextureRegion mFaceTextureRegionKeramBoard;
	
	private ITextureRegion mFaceTextureRegionM1, mFaceTextureRegionM2, mFaceTextureRegionM3;
	
	private int mFaceCount = -50, aCount = 0;
	//private Sound ballSound, crocSound, keramSound, penSound, jackFruitSound, bananaSound;
	private int randomItem;
	
	private Sprite[] position = new Sprite[7];
	private float bananaX, bananaY;
	
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
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		EngineOptions en = new EngineOptions(true,
				ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);

		en.getAudioOptions().setNeedsSound(true);
		return en;
	}

	@Override
	public void onCreateResources() 
	{
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("monkeyGameGfx/");
		
		texImage = new BitmapTextureAtlas(this.getTextureManager(), 512, 512,TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		regImage = BitmapTextureAtlasTextureRegionFactory.createFromAsset(texImage, this.getAssets(), "background.png", 0, 0);

		this.mBitmapTextureAtlasCroc = new BitmapTextureAtlas(this.getTextureManager(), 256, 128, TextureOptions.BILINEAR);
		this.mBitmapTextureAtlasPen = new BitmapTextureAtlas(this.getTextureManager(), 256, 128);
		this.mBitmapTextureAtlasBall = new BitmapTextureAtlas(this.getTextureManager(), 256, 128);
		this.mBitmapTextureAtlasBanana = new BitmapTextureAtlas(this.getTextureManager(), 40, 52);
		this.mBitmapTextureAtlasJackFruit = new BitmapTextureAtlas(this.getTextureManager(), 256, 128);
		this.mBitmapTextureAtlasKeramBoard = new BitmapTextureAtlas(this.getTextureManager(), 256, 128);
		
		this.mBitmapTextureAtlasM1 = new BitmapTextureAtlas(this.getTextureManager(), 340, 80, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		this.mBitmapTextureAtlasM2 = new BitmapTextureAtlas(this.getTextureManager(), 40, 52, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		this.mBitmapTextureAtlasM3 = new BitmapTextureAtlas(this.getTextureManager(), 340, 80, TextureOptions.BILINEAR_PREMULTIPLYALPHA );
		
		this.mFaceTextureRegionCroc = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlasCroc, this, "croc.png", 0, 50);
		this.mFaceTextureRegionPen = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlasPen, this, "pen.png",0,50);
		this.mFaceTextureRegionBall = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlasBall, this, "foot.png",20,60);
		this.mFaceTextureRegionBanana = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlasBanana, this, "ban.png",0,0);
		this.mFaceTextureRegionJackFruit = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlasJackFruit, this, "jacks.png",20,60);
		this.mFaceTextureRegionKeramBoard = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlasKeramBoard, this, "karam.png",0,50);
		
		
		this.mFaceTextureRegionM1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlasM1, this, "monkey.png",0,0);
		this.mFaceTextureRegionM2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlasM2, this, "ban.png",0,0);
		this.mFaceTextureRegionM3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlasM3, this, "monkey.png",0,0);
		
		
		texImage.load();
		
		this.mBitmapTextureAtlasCroc.load();
		this.mBitmapTextureAtlasPen.load();
		this.mBitmapTextureAtlasBall.load();
		this.mBitmapTextureAtlasBanana.load();
		this.mBitmapTextureAtlasJackFruit.load();
		this.mBitmapTextureAtlasKeramBoard.load();
		
		this.mBitmapTextureAtlasM1.load();
		this.mBitmapTextureAtlasM2.load();
		this.mBitmapTextureAtlasM3.load();
		
	}
	
	@Override
	public Scene onCreateScene() 
	{
		this.mEngine.registerUpdateHandler(new FPSLogger());

		/* Just a simple */
		this.mMainScene = new Scene();
		mMainScene.setBackground(new Background(Color.WHITE));

		
		sprImage = new Sprite(0, 0, regImage,this.getVertexBufferObjectManager());
		mMainScene.attachChild(sprImage);
		
		mMainScene.registerUpdateHandler(new TimerHandler(5, true,new ITimerCallback()
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				// TODO Auto-generated method stub
				
				randomItem = (int)(Math.random()*8);
				Log.d(DEBUG_TAG, "randomItem "+randomItem);
				switch(randomItem)
				{
					case 0:
							croc();
					break;
					
					case 1:
							pen();
					break;
					
					case 2:
							ball();
					break;
					
					case 3:
							ball();
					break;
					
					case 4:
							keramBoard();
					break;
						
					case 5:
							jackFruit();
					break;
					
					case 6:
							ball();
					break;
				
					case 7:
							ball();
					break;
					
					default:
						    ball();
					break;
				}
			}
		}));
		
		
		this.mMainScene.setOnAreaTouchListener(this);
		return this.mMainScene;
	}

	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,ITouchArea pTouchArea, float pTouchAreaLocalX,float pTouchAreaLocalY) 
	{
		// TODO Auto-generated method stub
		
		if (pSceneTouchEvent.isActionDown()) 
		{
			this.removeFace((Sprite) pTouchArea);
			return true;
		}
		return false;
	}

	private void removeFace(Sprite pTouchArea)
	{
		// TODO Auto-generated method stub
		
		if((Sprite)pTouchArea==ball)
		{
			//MainActivity.this.ballSound.play();
			this.mMainScene.unregisterTouchArea(pTouchArea);
			this.mMainScene.detachChild(pTouchArea);
			if(position[aCount]==null)
			{
				//Toast.makeText(getBaseContext(), "There is no Banana",Toast.LENGTH_SHORT ).show();
			}
			else
			{
				bananaX=position[aCount].getX();
				bananaY=position[aCount].getY();
				
				monkey1();
			}
		}

		else if((Sprite)pTouchArea==pen)
		{
			//MainActivity.this.penSound.play();
			addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
			this.mMainScene.unregisterTouchArea(pTouchArea);
			this.mMainScene.detachChild(pTouchArea);
		}
		else if((Sprite)pTouchArea==jacKFruit)
		{
			//MainActivity.this.jackFruitSound.play();
			addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
			this.mMainScene.unregisterTouchArea(pTouchArea);
			this.mMainScene.detachChild(pTouchArea);
		}
		else if((Sprite)pTouchArea==croc)
		{
			//MainActivity.this.crocSound.play();
			addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
			this.mMainScene.unregisterTouchArea(pTouchArea);
			this.mMainScene.detachChild(pTouchArea);
		}
		else if((Sprite)pTouchArea==keramBoard)
		{
			//MainActivity.this.keramSound.play();
			addFace(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
			this.mMainScene.unregisterTouchArea(pTouchArea);
			this.mMainScene.detachChild(pTouchArea);
		}
		else if((Sprite)pTouchArea==position[aCount])
		{
			//MainActivity.this.bananaSound.play();
		}
		
		System.gc();
	}

	private void addFace(final float pX, final float pY) 
	{
		this.mFaceCount = mFaceCount+95;
		this.aCount = aCount+1;
		
		if(aCount==5)
		{

			mMainScene.clearUpdateHandlers();
			mMainScene.clearEntityModifiers();
			mMainScene.clearTouchAreas();
			mMainScene.clearChildScene();
			
			mMainScene.registerUpdateHandler(new TimerHandler(2, new ITimerCallback() {
				
				@Override
				public void onTimePassed(TimerHandler pTimerHandler)
				{
					// TODO Auto-generated method stub
					MonkeyGameActivity.this.finish();
					//startActivity(new Intent(getBaseContext(),menu.class));
				}
			}));
			
			//MainActivity.this.finish();
		}
//		else
//		{
			position[aCount] = new Sprite(0, 50 , this.mFaceTextureRegionBanana,this.getVertexBufferObjectManager());
			final Path bananaPath = new Path(2).to(300, 150).to(40, this.mFaceCount );
			/* Add the proper animation when a waypoint of the path is passed. */
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
				public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
					Debug.d("onPathFinished");
				

					bananaX=position[aCount].getX();
					bananaY=position[aCount].getY();
				}
			}, EaseSineInOut.getInstance()));
		
			this.mMainScene.attachChild(position[aCount]);
			this.mMainScene.registerTouchArea(position[aCount]);
		}
//	}
	public void croc()
	{
		croc = new Sprite(0, 0, this.mFaceTextureRegionCroc, this.getVertexBufferObjectManager()); 
		
		final Path crocPath = new Path(2).to(100, CAMERA_HEIGHT).to(100, -250 );
		croc.registerEntityModifier(new PathModifier(5, crocPath, null, new IPathModifierListener() {
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
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
				Debug.d("onPathFinished");
				
				///mMainScene.detachChild(MainActivity.this.croc);
				//croc=null;
			}
		}, EaseSineInOut.getInstance()));
		this.mMainScene.attachChild(croc);
		this.mMainScene.registerTouchArea(croc);
	}
	
	public void jackFruit()
	{
		jacKFruit = new Sprite(0, 50, this.mFaceTextureRegionJackFruit, this.getVertexBufferObjectManager());
		final Path jackFruitPath = new Path(2).to(100, 0).to(100, CAMERA_HEIGHT );
		jacKFruit.registerEntityModifier(new PathModifier(5, jackFruitPath, null, new IPathModifierListener() {
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
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		this.mMainScene.attachChild(jacKFruit);
		this.mMainScene.registerTouchArea(jacKFruit);
		
	}
	
	public void pen()
	{
		pen = new Sprite(0, 50, this.mFaceTextureRegionPen, this.getVertexBufferObjectManager());
		
		final Path penPath = new Path(2).to(200, 0).to(200, CAMERA_HEIGHT );
		pen.registerEntityModifier(new PathModifier(5, penPath, null, new IPathModifierListener() {
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
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		this.mMainScene.attachChild(pen);
		this.mMainScene.registerTouchArea(pen);
	}
	
	public void keramBoard()
	{
		
		keramBoard = new Sprite(0, 50, this.mFaceTextureRegionKeramBoard, this.getVertexBufferObjectManager());
		final Path keramPath = new Path(2).to(100, 0).to(100, CAMERA_HEIGHT );
		keramBoard.registerEntityModifier(new PathModifier(5, keramPath, null, new IPathModifierListener() {
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
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		this.mMainScene.attachChild(keramBoard);
		this.mMainScene.registerTouchArea(keramBoard);
	}
	
	public void monkey1()
	{
		monkey1 = new Sprite(0, 50, this.mFaceTextureRegionM1, this.getVertexBufferObjectManager());
		this.mMainScene.attachChild(monkey1);
		monkey1.setVisible(true);
		
		final Path monkey1Path = new Path(2).to(300, 150).to(bananaX+40,bananaY+10);
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
				mFaceCount=mFaceCount-95;
				
				monkey2();
			}
		}, EaseSineInOut.getInstance()));
	}
	
	public void monkey2()
	{
		monkey3 = new Sprite(bananaX+30, bananaY+5, this.mFaceTextureRegionM3, this.getVertexBufferObjectManager());
		this.mMainScene.attachChild(monkey3);
		
		final Path monkey3Path = new Path(2).to(bananaX+30, bananaY+5).to(400,150);
		monkey3.registerEntityModifier(new PathModifier(2, monkey3Path, null, new IPathModifierListener() {
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
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
				Debug.d("onPathFinished");
				
			}
		}, EaseSineInOut.getInstance()));
		
		monkey2 = new Sprite(bananaX, bananaY, this.mFaceTextureRegionM2, this.getVertexBufferObjectManager());
		this.mMainScene.attachChild(monkey2);
		
		
		final Path monkey2Path = new Path(2).to(bananaX, bananaY).to(375,150);
		monkey2.registerEntityModifier(new PathModifier(2, monkey2Path, null, new IPathModifierListener() {
			@Override
			public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) {
				Debug.d("onPathStarted");
				
				mMainScene.detachChild(position[aCount]);
				position[aCount]=null;
				aCount = aCount - 1;
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
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
	}
	
	public void ball()
	{
		ball = new Sprite(0, 50, this.mFaceTextureRegionBall, this.getVertexBufferObjectManager());
		
		final Path ballPath = new Path(2).to(100, 0).to(100, CAMERA_HEIGHT );
		ball.registerEntityModifier(new PathModifier(4, ballPath, null, new IPathModifierListener() {
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
			public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
				Debug.d("onPathFinished");
			}
		}, EaseSineInOut.getInstance()));
		this.mMainScene.attachChild(ball);
		this.mMainScene.registerTouchArea(ball);
	}

	
	
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}