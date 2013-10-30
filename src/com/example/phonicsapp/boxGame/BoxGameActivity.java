package com.example.phonicsapp.boxGame;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
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
	
	private BuildableBitmapTextureAtlas mBitmapTextureAtlas;
	private BuildableBitmapTextureAtlas mBitmapTextureAtlas1;
	public static ITextureRegion mbackGroundTextureRegion;
	
	public static ITextureRegion mBox1TextureRegion;
	public static ITextureRegion mBox2TextureRegion;
	
	private BuildableBitmapTextureAtlas mAnimatedBitmapTextureAtlas;
	public TiledTextureRegion mParrotTextureRegion;
	
	//Letter-A
	public static ITextureRegion mA1TextureRegion;
	public static ITextureRegion mA2TextureRegion;
	public static ITextureRegion mA3TextureRegion;
	public static ITextureRegion mA4TextureRegion;
	public static ITextureRegion mA5TextureRegion;
	public static ITextureRegion mA6TextureRegion;
	public static ITextureRegion mATextureRegion;
	public static ITextureRegion mWA1TextureRegion;
	public static ITextureRegion mWA2TextureRegion;
	
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
	
	//Letter-Ko
	public static ITextureRegion mKo1TextureRegion;
	public static ITextureRegion mKo2TextureRegion;
	public static ITextureRegion mKo3TextureRegion;
	public static ITextureRegion mKo4TextureRegion;
	public static ITextureRegion mKo5TextureRegion;
	public static ITextureRegion mKo6TextureRegion;
	public static ITextureRegion mKoTextureRegion;
	public static ITextureRegion mWKo1TextureRegion;
	public static ITextureRegion mWKo2TextureRegion;
	
	//Letter-Lo
	public static ITextureRegion mLo1TextureRegion;
	public static ITextureRegion mLo2TextureRegion;
	public static ITextureRegion mLo3TextureRegion;
	public static ITextureRegion mLo4TextureRegion;
	public static ITextureRegion mLo5TextureRegion;
	public static ITextureRegion mLo6TextureRegion;
	public static ITextureRegion mLoTextureRegion;
	public static ITextureRegion mWLo1TextureRegion;
	public static ITextureRegion mWLo2TextureRegion;
	
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
	
	
	public static Sprite backGround, openedBox, closedBox;
	static Sprite obj1, obj2, obj3, obj4, obj5, obj6,wrongObj1, wrongObj2;
	static int obj1Sound, obj2Sound, obj3Sound, obj4Sound, obj5Sound, obj6Sound, wrongObj1Sound, wrongObj2Sound, letterSound;
	
	static Letter letter ;
	//Obj1-mula, Obj2-ma, Obj3-mohis, Obj4-megh, Obj5-moi, Obj6-mama, wrongObj1-kola, wrongObj2-keramBoard;
	static AnimatedSprite  parrot;
	public TimerHandler timer1, timer2, timer3;
	
	static float obj1X , obj1Y, obj2X, obj2Y, obj3X, obj3Y, obj4X, obj4Y, obj5X, obj5Y, 
				 obj6X, obj6Y, wrongObj1X, wrongObj1Y, wrongObj2X, wrongObj2Y;
	
	static float ImageHight;
	static float ImageWidth;

	static BoxGameActivity boxGameActivityInstance;
	static int bCounter=0;
	static int aCounter=0;
	public static String DEBUG_TAG = BoxGameActivity.class.getSimpleName();
	int i=0;
	
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
		
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	}

	@Override
	protected void onCreateResources() 
	{
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("BoxGameGfx/");

		mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(
				this.getTextureManager(), 1600, 1200);
		mBitmapTextureAtlas1 = new BuildableBitmapTextureAtlas(
				this.getTextureManager(), 1600, 1200);

		mbackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "JungleBG.png");
		
		mBox1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "box-15.png");
		mBox2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "box-16.png");
		
		mAnimatedBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1000, 338, TextureOptions.NEAREST);
		mParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedBitmapTextureAtlas, this, "parrot1.png", 6, 2);
		
		
		//Letter-A
		mA1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterA/ma.png");
		mA2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterA/mas.png");
		mA3TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterA/mohis-2.png");
		mA4TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterA/mula-2.png");
		mA5TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterA/moi-2.png");
		mA6TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterA/mama-2.png");
		mATextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterA/mo.png");
		mWA1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterA/pineapple.png");
		mWA2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterA/keramBoard1.png");
				
				
		//Letter-Mo
		mMo1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterMo/mula-2.png");
		mMo2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterMo/ma.png");
		mMo3TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterMo/mohis-2.png");
		mMo4TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterMo/megh.png");
		mMo5TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterMo/moi-2.png");
		mMo6TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterMo/mama-2.png");
		mMoTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterMo/mo.png");
		mWMo1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterMo/kola-1.png");
		mWMo2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterMo/keramBoard1.png");
		
		//Letter-Ko
		mKo1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterKo/ma.png");
		mKo2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterKo/mas.png");
		mKo3TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterKo/mohis-2.png");
		mKo4TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterKo/mula-2.png");
		mKo5TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterKo/moi-2.png");
		mKo6TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterKo/mama-2.png");
		mKoTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterKo/mo.png");
		mWKo1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterKo/pineapple.png");
		mWKo2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterKo/keramBoard1.png");
		
		//Letter-Lo
		mLo1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterLo/ma.png");
		mLo2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterLo/mas.png");
		mLo3TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterLo/mohis-2.png");
		mLo4TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterLo/mula-2.png");
		mLo5TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterLo/moi-2.png");
		mLo6TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterLo/mama-2.png");
		mLoTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterLo/mo.png");
		mWLo1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterLo/pineapple.png");
		mWLo2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterLo/keramBoard1.png");
		
		//Letter-To
		mTo1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterTo/mula-2.png");
		mTo2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterTo/ma.png");
		mTo3TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterTo/mohis-2.png");
		mTo4TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterTo/megh.png");
		mTo5TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterTo/moi-2.png");
		mTo6TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterTo/mama-2.png");
		mToTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterTo/mo.png");
		mWTo1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterTo/kola-1.png");
		mWTo2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "LetterTo/keramBoard1.png");
		
		try 
		{
			this.mBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
					BitmapTextureAtlas>(0, 0, 0));
			this.mBitmapTextureAtlas.load();
		} 
		
		catch (TextureAtlasBuilderException e)
		{
			Debug.e(e);
		}
		
		try 
		{
			this.mBitmapTextureAtlas1.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
					BitmapTextureAtlas>(0, 0, 0));
			this.mBitmapTextureAtlas1.load();
		} 
		
		catch (TextureAtlasBuilderException e)
		{
			Debug.e(e);
		}
		
		try 
		{
			this.mAnimatedBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.mAnimatedBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}
		
		
		//timer1 for checking if the any object collides with the box
		timer1 = new TimerHandler(1.0f/120, true, new ITimerCallback()
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				// TODO Auto-generated method stub
				//if all the items are in the box
				if(!(obj3.getX()>=0) && !(obj2.getX()>=0) && !(obj6.getX()>=0) && !(obj4.getX()>=0) && !(obj1.getX()>=0) && !(obj5.getX()>=0))
				{
					i++;
					if(i==1)
					{
						startActivity();
					}
				}

				
				//Mula
				if(Functions.collisoinCheck(closedBox, obj1)==1 ||
						Functions.collisoinCheck(closedBox, obj1)==2)
				{
					openedBox.setVisible(true);
					closedBox.setVisible(false);
				
					if(Objects.touchFlag == false )
					{
						Functions.fadeOut(obj1);
					}
				}
				//Ma
				else if(Functions.collisoinCheck(closedBox, obj2)==1 ||
						Functions.collisoinCheck(closedBox, obj2)==2)
				{
					if(Functions.disableCol == 0)
					{
						openedBox.setVisible(true);
						closedBox.setVisible(false);
				
						if(Objects.touchFlag == false )
						{
							Functions.fadeOut(obj2);
						}
					}
					else
					{
						openedBox.setVisible(false);
						closedBox.setVisible(true);
					}
				}
				
				//Mohis
				else if(Functions.collisoinCheck(closedBox, obj3)==1 ||
						Functions.collisoinCheck(closedBox, obj3)==2)
				{
					openedBox.setVisible(true);
					closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(obj3);
					}
				}
				
				//Megh
				else if(Functions.collisoinCheck(closedBox, obj4)==1 ||
						Functions.collisoinCheck(closedBox, obj4)==2)
				{
					openedBox.setVisible(true);
					closedBox.setVisible(false);
		
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(obj4);
					}
				}
				
				//Moi
				else if(Functions.collisoinCheck(closedBox, obj5)==1 ||
						Functions.collisoinCheck(closedBox, obj5)==2)
				{
					openedBox.setVisible(true);
					closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(obj5);
					}
				}
				
				//Mama
				else if(Functions.collisoinCheck(closedBox, obj6)==1 ||
						Functions.collisoinCheck(closedBox, obj6)==2)
				{
					openedBox.setVisible(true);
					closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(obj6);
					}
				}
				
				else if(Functions.collisoinCheck(closedBox, wrongObj1)==1 ||
						Functions.collisoinCheck(closedBox, wrongObj1)==2)
				{
					openedBox.setVisible(true);
					closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						// Create jump
						Functions.jump(wrongObj1, 0);
					}
				}
				
				//Keram board
				else if(Functions.collisoinCheck(closedBox, wrongObj2)==1 ||
						Functions.collisoinCheck(closedBox, wrongObj2)==2)
				{
					if(Functions.disableCol == 0)
					{
					openedBox.setVisible(true);
					closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						// Create jump
						Functions.jump(wrongObj2, 1);
					}
					}else 
					{
						openedBox.setVisible(false);
						closedBox.setVisible(true);
					}
				}
				
				else
				{
					openedBox.setVisible(false);
					closedBox.setVisible(true);
				}
			}
		});
		
	}

	@Override
	protected Scene onCreateScene()
	{
		// TODO Auto-generated method stub
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));
		mScene.setTouchAreaBindingOnActionDownEnabled(true);
		
		StatusBar.hideStatusBar();
		
		//Loading the objects according to letter
		loadObjects(2);
		
		backGround = new Sprite(0, 0, mbackGroundTextureRegion, getVertexBufferObjectManager());
		backGround.setHeight(CAMERA_HEIGHT);
		backGround.setWidth(CAMERA_WIDTH);
		mScene.attachChild(backGround);
		
		openedBox = new Sprite(CAMERA_WIDTH/2-100, CAMERA_HEIGHT/2, mBox1TextureRegion, getVertexBufferObjectManager());
		//openedBox.setWidth(ImageWidth*1.5f);
		//openedBox.setHeight(ImageHight*1.5f);
		mScene.attachChild(openedBox);
		openedBox.setVisible(false);
		
		//closed box
		closedBox = new Sprite(CAMERA_WIDTH/2-100, CAMERA_HEIGHT/2, mBox2TextureRegion, getVertexBufferObjectManager());
		//closedBox.setWidth(ImageWidth*1.5f);
		//closedBox.setHeight(ImageHight*1.5f);
		mScene.attachChild(closedBox);
		closedBox.setVisible(true);
		
//		obj1.setWidth(ImageWidth);
//		obj1.setHeight(ImageHight);
		mScene.registerTouchArea(obj1);
		mScene.attachChild(obj1);
		
//		ma.setWidth(ImageWidth);
//		ma.setHeight(ImageHight);
		mScene.registerTouchArea(obj2);
		mScene.attachChild(obj2);
		
//		obj3.setWidth(ImageWidth);
//		obj3.setHeight(ImageHight);
		mScene.registerTouchArea(obj3);
		mScene.attachChild(obj3);
		
//		obj4.setWidth(ImageWidth);
//		obj4.setHeight(ImageHight);
		mScene.registerTouchArea(obj4);
		mScene.attachChild(obj4);
		
		mScene.registerTouchArea(obj5);
		mScene.attachChild(obj5);
		
//		obj6.setWidth(ImageWidth);
//		obj6.setHeight(ImageHight);
		mScene.registerTouchArea(obj6);
		mScene.attachChild(obj6);
	
//		wrongObj1.setWidth(ImageWidth);
//		wrongObj1.setHeight(ImageHight);
		mScene.registerTouchArea(wrongObj1);
		mScene.attachChild(wrongObj1);
		
//		wrongObj2.setWidth(ImageWidth);
//		wrongObj2.setHeight(ImageHight);
		mScene.registerTouchArea(wrongObj2);
		mScene.attachChild(wrongObj2);
		
		mScene.registerTouchArea(letter);
		mScene.attachChild(letter);
		
		parrot = new Parrot(CAMERA_WIDTH+500, CAMERA_HEIGHT/2-50, mParrotTextureRegion, this.getVertexBufferObjectManager());
		parrot.animate(new long[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}, 0, 11, true);
		parrot.setFlippedHorizontal(true);
//		parrot.setWidth(ImageWidth*1.5f);
//		parrot.setHeight(ImageHight*1.5f);
		mScene.registerTouchArea(parrot);
		mScene.attachChild(parrot);
		
		Parrot.parrotPath();
		
		
		mScene.registerUpdateHandler(timer1);
		
		//getting the context
		BoxGameActivity.context = getApplicationContext();
		
		mScene.registerUpdateHandler(new TimerHandler((float) 0.5,new ITimerCallback()
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				playIntroSound();
			}
		}));
		
		timer2 = new TimerHandler( (float) 5, true, new ITimerCallback() 
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				// TODO Auto-generated method stub
				
				if(Objects.touchFlag1 == false)
				{
					if(!(obj1.getX()>=0) || !(wrongObj1.getX()>=0))
					{ 
//						Log.d("a.x",""+a.getX());
//						Log.d("b.x",""+b.getX());
					}
					else
					{
					Functions.ExchangePosition(obj1, wrongObj1);
					Functions.ExchangePosition(wrongObj1, obj1);
					}
				}
				
			}
		});
		mScene.registerUpdateHandler(timer2);
	
		timer3 = new TimerHandler( (float) 3.5, true, new ITimerCallback() 
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				// TODO Auto-generated method stub
				  
				if(Objects.touchFlag2 == false)
				{ 
					if(!(obj2.getX()>=0) || !(wrongObj2.getX()>=0))
					{ 
//						Log.d("a.x",""+a.getX());
//						Log.d("b.x",""+b.getX());
					}
					else
					{
					Functions.ExchangePosition(obj2, wrongObj2);
					Functions.ExchangePosition(wrongObj2, obj2);
					}
					
				}
			}
		});
		mScene.registerUpdateHandler(timer3);
		
		return mScene;
	}
	
	private void loadObjects(int i) 
	{
		// TODO Auto-generated method stub
		
		//Letter-A
		if(i == 1)
		{
			obj1 = new Objects(obj1X, obj1Y, mA1TextureRegion, getVertexBufferObjectManager());
			obj2 = new Objects(obj2X, obj2Y, mA2TextureRegion, getVertexBufferObjectManager());
			obj3 = new Objects(obj3X, obj3Y, mA3TextureRegion, getVertexBufferObjectManager());
			obj4 = new Objects(obj4X, obj4Y, mA4TextureRegion, getVertexBufferObjectManager());
			obj5 = new Objects(obj5X, obj5Y, mA5TextureRegion, getVertexBufferObjectManager());
			obj6 = new Objects(obj6X, obj6Y, mA6TextureRegion, getVertexBufferObjectManager());
			wrongObj1 = new Objects(wrongObj1X, wrongObj1Y, mWMo1TextureRegion, getVertexBufferObjectManager());
			wrongObj2 = new Objects(wrongObj2X, wrongObj2Y, mWMo2TextureRegion, getVertexBufferObjectManager());
			letter = new Letter(900, CAMERA_HEIGHT-100, 80, 80, mATextureRegion, getVertexBufferObjectManager());
			
			obj1Sound = R.raw.mula;
			obj2Sound = R.raw.ma;
			obj3Sound = R.raw.mohis;
			obj4Sound = R.raw.megh;
			obj5Sound = R.raw.moi;
			obj6Sound = R.raw.mama;
			wrongObj1Sound = R.raw.kola;
			wrongObj2Sound = R.raw.keram;
			letterSound = R.raw.mo;
		}
		//Letter-Mo
		else if(i == 2)
		{
			obj1 = new Objects(obj1X, obj1Y, mMo1TextureRegion, getVertexBufferObjectManager());
			obj2 = new Objects(obj2X, obj2Y, mMo2TextureRegion, getVertexBufferObjectManager());
			obj3 = new Objects(obj3X, obj3Y, mMo3TextureRegion, getVertexBufferObjectManager());
			obj4 = new Objects(obj4X, obj4Y, mMo4TextureRegion, getVertexBufferObjectManager());
			obj5 = new Objects(obj5X, obj5Y, mMo5TextureRegion, getVertexBufferObjectManager());
			obj6 = new Objects(obj6X, obj6Y, mMo6TextureRegion, getVertexBufferObjectManager());
			wrongObj1 = new Objects(wrongObj1X, wrongObj1Y, mWMo1TextureRegion, getVertexBufferObjectManager());
			wrongObj2 = new Objects(wrongObj2X, wrongObj2Y, mWMo2TextureRegion, getVertexBufferObjectManager());
			letter = new Letter(900, CAMERA_HEIGHT-100, 80, 80, mMoTextureRegion, getVertexBufferObjectManager());
			
			obj1Sound = R.raw.mula;
			obj2Sound = R.raw.ma;
			obj3Sound = R.raw.mohis;
			obj4Sound = R.raw.megh;
			obj5Sound = R.raw.moi;
			obj6Sound = R.raw.mama;
			wrongObj1Sound = R.raw.kola;
			wrongObj2Sound = R.raw.keram;
			letterSound = R.raw.mo;
		}
		//Letter-Ko
		else if(i == 3)
		{
			obj1 = new Objects(obj1X, obj1Y, mKo1TextureRegion, getVertexBufferObjectManager());
			obj2 = new Objects(obj2X, obj2Y, mKo2TextureRegion, getVertexBufferObjectManager());
			obj3 = new Objects(obj3X, obj3Y, mKo3TextureRegion, getVertexBufferObjectManager());
			obj4 = new Objects(obj4X, obj4Y, mKo4TextureRegion, getVertexBufferObjectManager());
			obj5 = new Objects(obj5X, obj5Y, mKo5TextureRegion, getVertexBufferObjectManager());
			obj6 = new Objects(obj6X, obj6Y, mKo6TextureRegion, getVertexBufferObjectManager());
			wrongObj1 = new Objects(wrongObj1X, wrongObj1Y, mWKo1TextureRegion, getVertexBufferObjectManager());
			wrongObj2 = new Objects(wrongObj2X, wrongObj2Y, mWKo2TextureRegion, getVertexBufferObjectManager());
			letter = new Letter(900, CAMERA_HEIGHT-100, 80, 80, mKoTextureRegion, getVertexBufferObjectManager());
			
			obj1Sound = R.raw.kola;
			obj2Sound = R.raw.langol;
			obj3Sound = R.raw.mula;
			obj4Sound = R.raw.shorea;
			obj5Sound = R.raw.ma;
			obj6Sound = R.raw.mohis;
			wrongObj1Sound = R.raw.aam;
			wrongObj2Sound = R.raw.keram;
			letterSound = R.raw.akar;
		}

		//Letter-Lo
		else if(i == 4)
		{
			obj1 = new Objects(obj1X, obj1Y, mLo1TextureRegion, getVertexBufferObjectManager());
			obj2 = new Objects(obj2X, obj2Y, mLo2TextureRegion, getVertexBufferObjectManager());
			obj3 = new Objects(obj3X, obj3Y, mLo3TextureRegion, getVertexBufferObjectManager());
			obj4 = new Objects(obj4X, obj4Y, mLo4TextureRegion, getVertexBufferObjectManager());
			obj5 = new Objects(obj5X, obj5Y, mLo5TextureRegion, getVertexBufferObjectManager());
			obj6 = new Objects(obj6X, obj6Y, mLo6TextureRegion, getVertexBufferObjectManager());
			wrongObj1 = new Objects(wrongObj1X, wrongObj1Y, mWLo1TextureRegion, getVertexBufferObjectManager());
			wrongObj2 = new Objects(wrongObj2X, wrongObj2Y, mWLo2TextureRegion, getVertexBufferObjectManager());
			letter = new Letter(900, CAMERA_HEIGHT-100, 80, 80, mLoTextureRegion, getVertexBufferObjectManager());
					
			obj1Sound = R.raw.kola;
			obj2Sound = R.raw.langol;
			obj3Sound = R.raw.mula;
			obj4Sound = R.raw.shorea;
			obj5Sound = R.raw.ma;
			obj6Sound = R.raw.mohis;
			wrongObj1Sound = R.raw.aam;
			wrongObj2Sound = R.raw.keram;
			letterSound = R.raw.akar;
		}
		
		//Letter-To
		else if(i == 5)
		{
			obj1 = new Objects(obj1X, obj1Y, mTo1TextureRegion, getVertexBufferObjectManager());
			obj2 = new Objects(obj2X, obj2Y, mTo2TextureRegion, getVertexBufferObjectManager());
			obj3 = new Objects(obj3X, obj3Y, mTo3TextureRegion, getVertexBufferObjectManager());
			obj4 = new Objects(obj4X, obj4Y, mTo4TextureRegion, getVertexBufferObjectManager());
			obj5 = new Objects(obj5X, obj5Y, mTo5TextureRegion, getVertexBufferObjectManager());
			obj6 = new Objects(obj6X, obj6Y, mTo6TextureRegion, getVertexBufferObjectManager());
			wrongObj1 = new Objects(wrongObj1X, wrongObj1Y, mWTo1TextureRegion, getVertexBufferObjectManager());
			wrongObj2 = new Objects(wrongObj2X, wrongObj2Y, mWTo2TextureRegion, getVertexBufferObjectManager());
			letter = new Letter(900, CAMERA_HEIGHT-100, 80, 80, mToTextureRegion, getVertexBufferObjectManager());
							
			obj1Sound = R.raw.kola;
			obj2Sound = R.raw.langol;
			obj3Sound = R.raw.mula;
			obj4Sound = R.raw.shorea;
			obj5Sound = R.raw.ma;
			obj6Sound = R.raw.mohis;
			wrongObj1Sound = R.raw.aam;
			wrongObj2Sound = R.raw.keram;
			letterSound = R.raw.akar;
		}
	}

	public void playIntroSound()
	{
		Functions.audioPlay = true;
		Functions.playAudio(R.raw.parrot_intro);
		
	}
	
	public void startActivity()
	{
		mScene.unregisterUpdateHandler(timer1);
		finish();
		startActivity(new Intent(this, MonkeyGameActivity.class));
		i=0;
	}
	
	public void setCurrentScene(Scene scene)
	{
		mScene = scene;
		getEngine().setScene(mScene);
	}
}
