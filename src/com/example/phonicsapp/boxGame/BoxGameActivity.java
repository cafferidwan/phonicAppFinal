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
import org.andengine.input.touch.TouchEvent;
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
	public static ITextureRegion mMulaTextureRegion;
	public static ITextureRegion mKolaTextureRegion;
	public static ITextureRegion mMaTextureRegion;
	
	public static ITextureRegion mMohisTextureRegion;
	public static ITextureRegion mbackGroundTextureRegion;
	public static ITextureRegion mKeramBoardTextureRegion;
	public static ITextureRegion mMeghTextureRegion;
	public static ITextureRegion mMoiTextureRegion;
	public static ITextureRegion mMoTextureRegion;
	public static ITextureRegion mMamaTextureRegion;
	
	public static ITextureRegion mBox1TextureRegion;
	public static ITextureRegion mBox2TextureRegion;
	
	private BuildableBitmapTextureAtlas mAnimatedBitmapTextureAtlas;
	public static TiledTextureRegion mParrotTextureRegion;
	public static TiledTextureRegion mBoxTextureRegion;
	
	public static Sprite backGround, mula, kola, ma, mohis, keramBoard, megh, moi, mama;
	static Sprite mo;
	static AnimatedSprite  parrot;
	public TimerHandler timer1, timer2;
	
	static float mulaX , mulaY, kolaX, kolaY, maX, maY, mohisX, 
		  mohisY, keramBoardX, keramBoardY, meghX, meghY, moiX, moiY, mamaX, mamaY;
	static Sprite openedBox, closedBox;
	
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
		
		ImageHight = CAMERA_HEIGHT/4.5f;
		ImageWidth = CAMERA_WIDTH/6.5f;
		
		mulaX = CAMERA_WIDTH/2 - CAMERA_WIDTH/4;
		mulaY =	CAMERA_HEIGHT/2 - CAMERA_HEIGHT/4;
		
		mamaX = CAMERA_WIDTH/2 - CAMERA_WIDTH/4;
		mamaY =	CAMERA_HEIGHT - CAMERA_HEIGHT/4;
		
		kolaX = 50;
		kolaY = CAMERA_HEIGHT-CAMERA_HEIGHT/4;
		
		maX = 50;
		maY = CAMERA_HEIGHT/2 - CAMERA_HEIGHT/4;
		
		mohisX = CAMERA_WIDTH - 150;
		mohisY = CAMERA_HEIGHT/2;
		
		keramBoardX = CAMERA_WIDTH - CAMERA_WIDTH/4 -50;
		keramBoardY = CAMERA_HEIGHT-130;
		
		meghX = CAMERA_WIDTH - 150;
		meghY = CAMERA_HEIGHT-CAMERA_HEIGHT/4;
		
		moiX = CAMERA_WIDTH/2;
		moiY = CAMERA_HEIGHT/2 - CAMERA_HEIGHT/4;
		
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	
	}

	@Override
	protected void onCreateResources() 
	{
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("BoxGameGfx/");

		this.mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(
				this.getTextureManager(), 1600, 1200);

		BoxGameActivity.mbackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "JungleBG.png");
		BoxGameActivity.mMulaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "mula-2.png");
		BoxGameActivity.mKolaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "kola-1.png");
		
		BoxGameActivity.mMaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "ma-2.png");
		BoxGameActivity.mMohisTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "mohis-2.png");
		BoxGameActivity.mKeramBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "keramBoard1.png");
		BoxGameActivity.mMeghTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "megh-2.png");
		BoxGameActivity.mMoiTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "moi-2.png");
		BoxGameActivity.mMamaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "mama-2.png");
		BoxGameActivity.mMoTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "mo.png");
		
		BoxGameActivity.mBox1TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "box-15.png");
		BoxGameActivity.mBox2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "box-16.png");
		
		mAnimatedBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 1000, 554, TextureOptions.NEAREST);
		BoxGameActivity.mParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mAnimatedBitmapTextureAtlas, this, "p5.png", 5, 2);
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
		
		
		try {
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
				if(!(mohis.getX()>=0) && !(ma.getX()>=0) && !(mama.getX()>=0) && !(megh.getX()>=0) && !(mula.getX()>=0) && !(moi.getX()>=0))
				{
					startActivity();
				}
				
				if(Functions.collisoinCheck(closedBox, kola)==1 ||
						Functions.collisoinCheck(closedBox, kola)==2)
				{
					BoxGameActivity.openedBox.setVisible(true);
					BoxGameActivity.closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						// Create jump
						Functions.jump(kola, 0);
					}
				}
				
				//Keram board
				else if(Functions.collisoinCheck(closedBox, keramBoard)==1 ||
						Functions.collisoinCheck(closedBox, keramBoard)==2)
				{
					BoxGameActivity.openedBox.setVisible(true);
					BoxGameActivity.closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						// Create jump
						Functions.jump(keramBoard, 1);
					}
				}
				
				//Mohis
				else if(Functions.collisoinCheck(closedBox, mohis)==1 ||
						Functions.collisoinCheck(closedBox, mohis)==2)
				{
					BoxGameActivity.openedBox.setVisible(true);
					BoxGameActivity.closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(mohis);
					}
				}
				
				//Megh
				else if(Functions.collisoinCheck(closedBox, megh)==1 ||
						Functions.collisoinCheck(closedBox, megh)==2)
				{
					BoxGameActivity.openedBox.setVisible(true);
					BoxGameActivity.closedBox.setVisible(false);
		
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(megh);
					}
				}
				
				//Mula
				else if(Functions.collisoinCheck(closedBox, mula)==1 ||
						Functions.collisoinCheck(closedBox, mula)==2)
				{
					BoxGameActivity.openedBox.setVisible(true);
					BoxGameActivity.closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(mula);
					}
				}
				
				//Moi
				else if(Functions.collisoinCheck(closedBox, moi)==1 ||
						Functions.collisoinCheck(closedBox, moi)==2)
				{
					BoxGameActivity.openedBox.setVisible(true);
					BoxGameActivity.closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(moi);
					}
				}
				
				//Ma
				else if(Functions.collisoinCheck(closedBox, ma)==1 ||
						Functions.collisoinCheck(closedBox, ma)==2)
				{
					BoxGameActivity.openedBox.setVisible(true);
					BoxGameActivity.closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(ma);
					}
				}
				
				//Mama
				else if(Functions.collisoinCheck(closedBox, mama)==1 ||
						Functions.collisoinCheck(closedBox, mama)==2)
				{
					BoxGameActivity.openedBox.setVisible(true);
					BoxGameActivity.closedBox.setVisible(false);
				
					if(Objects.touchFlag == false)
					{
						Functions.fadeOut(mama);
					}
				}
				
				else
				{
					BoxGameActivity.openedBox.setVisible(false);
					BoxGameActivity.closedBox.setVisible(true);
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
		
		backGround = new Sprite(0, 0, mbackGroundTextureRegion, getVertexBufferObjectManager());
		backGround.setHeight(CAMERA_HEIGHT);
		backGround.setWidth(CAMERA_WIDTH);
		mScene.attachChild(backGround);
		
		//opened box-y:160
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
		
		parrot = new Parrot(BoxGameActivity.CAMERA_WIDTH+500, BoxGameActivity.CAMERA_HEIGHT/2-50, mParrotTextureRegion, this.getVertexBufferObjectManager());
		parrot.animate(new long[]{150, 150, 150, 150, 150, 150, 150, 150, 150, 150}, 0, 9, true);
		parrot.setFlippedHorizontal(true);
		parrot.setWidth(ImageWidth*1.5f);
		parrot.setHeight(ImageHight*1.5f);
		mScene.registerTouchArea(parrot);
		mScene.attachChild(parrot);
		
		mama = new Objects(mamaX, mamaY, mMamaTextureRegion, getVertexBufferObjectManager());
		mama.setWidth(ImageWidth);
		mama.setHeight(ImageHight);
		mScene.registerTouchArea(mama);
		mScene.attachChild(mama);
		
		kola = new Objects(kolaX, kolaY, mKolaTextureRegion, getVertexBufferObjectManager());
		kola.setWidth(ImageWidth);
		kola.setHeight(ImageHight);
		mScene.registerTouchArea(kola);
		mScene.attachChild(kola);
		
		mula = new Objects(mulaX, mulaY, mMulaTextureRegion, getVertexBufferObjectManager());
		mula.setWidth(ImageWidth);
		mula.setHeight(ImageHight);
		mScene.registerTouchArea(mula);
		mScene.attachChild(mula);
		
		ma = new Objects(maX, maY, mMaTextureRegion, getVertexBufferObjectManager());
		ma.setWidth(ImageWidth);
		ma.setHeight(ImageHight);
		mScene.registerTouchArea(ma);
		mScene.attachChild(ma);
		
		mohis = new Objects(mohisX, mohisY, mMohisTextureRegion, getVertexBufferObjectManager());
		mohis.setWidth(ImageWidth);
		mohis.setHeight(ImageHight);
		mScene.registerTouchArea(mohis);
		mScene.attachChild(mohis);
		
		keramBoard = new Objects(keramBoardX, keramBoardY, mKeramBoardTextureRegion, getVertexBufferObjectManager());
		keramBoard.setWidth(ImageWidth);
		keramBoard.setHeight(ImageHight);
		mScene.registerTouchArea(keramBoard);
		mScene.attachChild(keramBoard);
		
		megh = new Objects(meghX, meghY, mMeghTextureRegion, getVertexBufferObjectManager());
		megh.setWidth(ImageWidth);
		megh.setHeight(ImageHight);
		mScene.registerTouchArea(megh);
		mScene.attachChild(megh);
		
		moi = new Objects(moiX, moiY, mMoiTextureRegion, getVertexBufferObjectManager());
		mScene.registerTouchArea(moi);
		mScene.attachChild(moi);
		
		mo = new Sprite(900, CAMERA_HEIGHT-100, mMoTextureRegion, getVertexBufferObjectManager())
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
					case TouchEvent.ACTION_DOWN:
					
						Functions.audioPlay = true;
						Functions.playAudio(R.raw.mo);
						
					break;
				}

				return true;
			}
		};
		mo.setHeight(60);
		mo.setWidth(60);
		mScene.attachChild(mo);
		
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
