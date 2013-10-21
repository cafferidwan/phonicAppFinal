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
	public static ITextureRegion mbackGroundTextureRegion;
	
	public static ITextureRegion mBox1TextureRegion;
	public static ITextureRegion mBox2TextureRegion;
	
	private BuildableBitmapTextureAtlas mAnimatedBitmapTextureAtlas;
	public static TiledTextureRegion mParrotTextureRegion;
	
	//Letter-Mo
	public static ITextureRegion mMulaTextureRegion;
	public static ITextureRegion mMaTextureRegion;
	public static ITextureRegion mMohisTextureRegion;
	public static ITextureRegion mMeghTextureRegion;
	public static ITextureRegion mMoiTextureRegion;
	public static ITextureRegion mMamaTextureRegion;
	public static ITextureRegion mMoTextureRegion;
	public static ITextureRegion mKolaTextureRegion;
	public static ITextureRegion mKeramBoardTextureRegion;
	
	//Letter-A
	public static ITextureRegion mM1TextureRegion;
	public static ITextureRegion mM2TextureRegion;
	public static ITextureRegion mM3TextureRegion;
	public static ITextureRegion mM4TextureRegion;
	public static ITextureRegion mM5TextureRegion;
	public static ITextureRegion mM6TextureRegion;
	public static ITextureRegion mMATextureRegion;
	public static ITextureRegion mW1TextureRegion;
	public static ITextureRegion mW2TextureRegion;
	
	public static Sprite backGround, openedBox, closedBox;
	static Sprite obj1, obj2, obj3, obj4, obj5, obj6,wrongObj1, wrongObj2;
	static int obj1Sound, obj2Sound, obj3Sound, obj4Sound, obj5Sound, obj6Sound, wrongObj1Sound, wrongObj2Sound, letterSound;
	
	static Letter letter ;
	//Obj1-mula, Obj2-ma, Obj3-mohis, Obj4-megh, Obj5-moi, Obj6-mama, wrongObj1-kola, wrongObj2-keramBoard;
	static AnimatedSprite  parrot;
	public TimerHandler timer1, timer2;
	
	static float obj1X , obj1Y, obj2X, obj2Y, obj3X, obj3Y, obj4X, obj4Y, obj5X, obj5Y, 
				 obj6X, obj6Y, wrongObj1X, wrongObj1Y, wrongObj2X, wrongObj2Y;
	
	static float ImageHight;
	static float ImageWidth;

	static BoxGameActivity boxGameActivityInstance;
	static int bCounter=0;
	static int aCounter=0;
	
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
				this.getTextureManager(), 1800, 1400);

		mbackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "JungleBG.png");
		
		mBox1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "box-15.png");
		mBox2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "box-16.png");
		
		mAnimatedBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 3000, 1015, TextureOptions.NEAREST);
		mParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedBitmapTextureAtlas, this, "parrot.png", 6, 2);
		
		//Letter-Mo
		mMulaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterMo/mula-2.png");
		mMaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterMo/ma.png");
		mMohisTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterMo/mohis-2.png");
		mMeghTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterMo/megh.png");
		mMoiTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterMo/moi-2.png");
		mMamaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterMo/mama-2.png");
		mMoTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterMo/mo.png");
		mKolaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterMo/kola-1.png");
		mKeramBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterMo/keramBoard1.png");
		
		//Letter-A
		mM1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterA/ma.png");
		mM2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterA/mas.png");
		mM3TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterA/mohis-2.png");
		mM4TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterA/mula-2.png");
		mM5TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterA/moi-2.png");
		mM6TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterA/mama-2.png");
		mMATextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterA/mo.png");
		mW1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterA/pineapple.png");
		mW2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "LetterA/keramBoard1.png");
		
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
					startActivity();
				}
				
				if(Functions.collisoinCheck(closedBox, wrongObj1)==1 ||
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
					openedBox.setVisible(true);
					closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						// Create jump
						Functions.jump(wrongObj2, 1);
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
				
				//Mula
				else if(Functions.collisoinCheck(closedBox, obj1)==1 ||
						Functions.collisoinCheck(closedBox, obj1)==2)
				{
					openedBox.setVisible(true);
					closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(obj1);
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
				
				//Ma
				else if(Functions.collisoinCheck(closedBox, obj2)==1 ||
						Functions.collisoinCheck(closedBox, obj2)==2)
				{
					openedBox.setVisible(true);
					closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(obj2);
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
		parrot.setWidth(ImageWidth*1.5f);
		parrot.setHeight(ImageHight*1.5f);
		mScene.registerTouchArea(parrot);
		mScene.attachChild(parrot);
		
		Parrot.parrotPath();
		
		
		mScene.registerUpdateHandler(timer1);
		
		//getting the context
		BoxGameActivity.context = getApplicationContext();
		
		mScene.registerUpdateHandler(new TimerHandler((float) 0.5, new ITimerCallback()
		{
			@Override
			public void onTimePassed(TimerHandler pTimerHandler)
			{
				playIntroSound();
			}
		}));
		
		return mScene;
	}
	
	private void loadObjects(int i) 
	{
		// TODO Auto-generated method stub
		
		//Letter-Mo
		if(i == 1)
		{
			obj1 = new Objects(obj1X, obj1Y, mMulaTextureRegion, getVertexBufferObjectManager());
			obj2 = new Objects(obj2X, obj2Y, mMaTextureRegion, getVertexBufferObjectManager());
			obj3 = new Objects(obj3X, obj3Y, mMohisTextureRegion, getVertexBufferObjectManager());
			obj4 = new Objects(obj4X, obj4Y, mMeghTextureRegion, getVertexBufferObjectManager());
			obj5 = new Objects(obj5X, obj5Y, mMoiTextureRegion, getVertexBufferObjectManager());
			obj6 = new Objects(obj6X, obj6Y, mMamaTextureRegion, getVertexBufferObjectManager());
			wrongObj1 = new Objects(wrongObj1X, wrongObj1Y, mKolaTextureRegion, getVertexBufferObjectManager());
			wrongObj2 = new Objects(wrongObj2X, wrongObj2Y, mKeramBoardTextureRegion, getVertexBufferObjectManager());
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
		//Letter-A
		else if(i == 2)
		{
			obj1 = new Objects(obj1X, obj1Y, mM1TextureRegion, getVertexBufferObjectManager());
			obj2 = new Objects(obj2X, obj2Y, mM2TextureRegion, getVertexBufferObjectManager());
			obj3 = new Objects(obj3X, obj3Y, mM3TextureRegion, getVertexBufferObjectManager());
			obj4 = new Objects(obj4X, obj4Y, mM4TextureRegion, getVertexBufferObjectManager());
			obj5 = new Objects(obj5X, obj5Y, mM5TextureRegion, getVertexBufferObjectManager());
			obj6 = new Objects(obj6X, obj6Y, mM6TextureRegion, getVertexBufferObjectManager());
			wrongObj1 = new Objects(wrongObj1X, wrongObj1Y, mW1TextureRegion, getVertexBufferObjectManager());
			wrongObj2 = new Objects(wrongObj2X, wrongObj2Y, mW2TextureRegion, getVertexBufferObjectManager());
			letter = new Letter(900, CAMERA_HEIGHT-100, 80, 80, mMATextureRegion, getVertexBufferObjectManager());
			
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
	}
	
	public void setCurrentScene(Scene scene)
	{
		mScene = scene;
		getEngine().setScene(mScene);
	}
}
