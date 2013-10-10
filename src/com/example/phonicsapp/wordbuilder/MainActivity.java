package com.example.phonicsapp.wordbuilder;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.input.touch.detector.ClickDetector;
import org.andengine.input.touch.detector.SurfaceScrollDetector;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import com.example.phonicsapp.R;

import android.view.Display;


public class MainActivity extends SimpleBaseGameActivity 
{
	// ===========================================================
	// Constants
	// ===========================================================

	public static int CAMERA_WIDTH;
	public static int CAMERA_HEIGHT;
	public String DEBUG_TAG = MainActivity.class.getSimpleName();
	// ===========================================================
	// Fields
	// ===========================================================

	private Camera mCamera;
	public static Scene mScene;
	
    // Scrolling
    public static SurfaceScrollDetector mScrollDetector;
    public static ClickDetector mClickDetector;

	// Bitmap Texture For Bangla 'A' Letter

	private BuildableBitmapTextureAtlas mBitmapTextureAtlas;
	private ITextureRegion mBackGroundTextureRegion;
	private ITextureRegion mAkarTextureRegion;
	private ITextureRegion mMOTextureRegion;
	private ITextureRegion mMaTextureRegion;
	private ITextureRegion mShoreaTextureRegion;
	private ITextureRegion mScissorTextureRegion;
	
	public static float centerX, centerY;

	public static Sprite maImage, backGround;
	public static Letter1 akar;
	public static Letter2 mo;
	public static Letter3 shorea;
	public static Scissor Scissor;
	
	static MainActivity activity;
	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	public static boolean mergeEnable1 = false;
	public static boolean mergeEnable2 = false;
	public static boolean mergeEnable3 = false;
	public static boolean mergeEnable4 = false;
	public static boolean mergeEnable5 = false;
	public static boolean mergeEnable6 = false;
	public static boolean mergeEnable7 = false;
	public static boolean mergeEnable8 = false;
	public static boolean mergeEnable9 = false;
	public static boolean mergeEnable10 = false;
	public static boolean mergeEnable11 = false;
	public static boolean mergeEnable12 = false;
	
	public static int count1, count2, count3, count4, count5, count6, count7, count8;
	
	@Override
	public EngineOptions onCreateEngineOptions()
	{
		// TODO Auto-generated method stub
		activity = this;
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_WIDTH = display.getWidth();
		CAMERA_HEIGHT = display.getHeight();

		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		EngineOptions en = new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,
						   new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
		// Setting MuliTouch
		en.getTouchOptions().setNeedsMultiTouch(true);

		return en;
	}

	@Override
	protected void onCreateResources() 
	{
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("WordBuilding/");

		this.mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 2512, 2512);

		this.mBackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "jungle.png");
		this.mAkarTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "1.png");
		this.mMOTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "mo.png");
		this.mMaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "ma.png");
		this.mShoreaTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "a.png");
		this.mScissorTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "scissor.png");

		try
		{
			this.mBitmapTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 0, 0));
			this.mBitmapTextureAtlas.load();
		} 
		catch (TextureAtlasBuilderException e) 
		{
			Debug.e(e);
		}

	}

	@Override
	protected Scene onCreateScene() 
	{
		// TODO Auto-generated method stub
		this.mEngine.registerUpdateHandler(new FPSLogger());
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));
		mScene.setTouchAreaBindingOnActionDownEnabled(true);
		
		backGround = new Sprite(0, 0, mBackGroundTextureRegion, getVertexBufferObjectManager());
		mScene.attachChild(backGround);
		backGround.setWidth(CAMERA_WIDTH);
		backGround.setHeight(CAMERA_HEIGHT);
		
		centerX = (CAMERA_WIDTH - this.mAkarTextureRegion.getWidth()) / 2;
		centerY = (CAMERA_HEIGHT - this.mAkarTextureRegion.getHeight()) / 2;
		
		
		//Setting the maImage invisible
		maImage = new Sprite(CAMERA_WIDTH/2-150 , 0, this.mMaTextureRegion, this.getVertexBufferObjectManager());
		mScene.attachChild(maImage);
		maImage.setWidth(CAMERA_WIDTH/4);
		maImage.setHeight(CAMERA_HEIGHT/2);
		maImage.setVisible(true);
		
		mScene.registerUpdateHandler(new TimerHandler((float) 0.09, true,
				new ITimerCallback()
		{
					@Override
					public void onTimePassed(TimerHandler pTimerHandler) 
					{
						// TODO Auto-generated method stub
						
//						if()
//						{
//							
//						}
						
						//checking the scissor
						if(Scissor.getX()!= CAMERA_WIDTH- CAMERA_WIDTH/5 && Scissor.getY()!= CAMERA_HEIGHT-CAMERA_HEIGHT/4 && Scissor.scissorGate==1)
						{
							Scissor.scissorGate = 0;
							Paths.scissorPath();
						}
						
						if(mergeEnable1== true)
						{
							Debug.d("mergeEnable1 is up");
						}
						 if(mergeEnable2== true)
						{
							Debug.d("mergeEnable2 is up");
						}
						 if(mergeEnable3== true)
						{
							Debug.d("mergeEnable3 is up");
						}
						 if(mergeEnable4== true)
						{
							Debug.d("mergeEnable4 is up");
						}
						 if(mergeEnable5== true)
						{
							Debug.d("mergeEnable5 is up");
						}
						 if(mergeEnable6== true)
						{
							Debug.d("mergeEnable6 is up");
						}
						 if(mergeEnable7== true)
						{
							Debug.d("mergeEnable7 is up");
						}
						 if(mergeEnable7== true)
						{
							Debug.d("mergeEnable7 is up");
						}
						if(mergeEnable8== true)
						{
							Debug.d("mergeEnable8 is up");
						}
						if(mergeEnable9== true)
						{
							Debug.d("mergeEnable9 is up");
						}
						if(mergeEnable10== true)
						{
							Debug.d("mergeEnable10 is up");
						}
						if(mergeEnable11== true)
						{
							Debug.d("mergeEnable11 is up");
						}
						if(mergeEnable12== true)
						{
							Debug.d("mergeEnable12 is up");
						}
						
						
						////////////////////////////////////////////////
						// Calculating if 'mo' is in the range of 'akar'
						if (mo.getX() - akar.getX() > 90
								&& mo.getX() - akar.getX() < 110
								&& mo.getY() - akar.getY() < 25
								&& mo.getY() - akar.getY() > -25)
						{
							if (mo.getX() == akar.getX() + 100)
							{
								if(Scissor.collidesWith(akar) && Scissor.collidesWith(mo))
								{
									count1++;
									if(count1 == 1)
									{
										mergeEnable1 = false;
										mergeEnable2 = false;
										Paths.splitPath();
									}
								}
							
							}
							//If letters are in the range but not merged, then enable merging
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudioLoop2(R.raw.akar ,R.raw.mo);
								
								mergeEnable1 = true;
								mergeEnable2 = false;
								mergeEnable3 = false;
								mergeEnable4 = false;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = false;
								mergeEnable8 = false;
								mergeEnable9 = false;
								mergeEnable10 = false;
								mergeEnable11 = false;
								mergeEnable12 = false;
							}

						}
						// Calculating if 'akar' is in the range of 'mo'----making 'ma' word
						else if (akar.getX() - mo.getX() > 90
								&& akar.getX() - mo.getX() < 110
								&& akar.getY() - mo.getY() < 25
								&& akar.getY() - mo.getY() > -25) 
						{
							if (mo.getX() + 100 == akar.getX()) 
							{
								//Setting the maImage visible when the letters are merged
								//maImage.setVisible(true);
								
								if(Scissor.collidesWith(akar) && Scissor.collidesWith(mo))
								{
									count2++;
									if(count2 == 1)
									{
										mergeEnable1 = false;
										mergeEnable2 = false;
										Paths.splitPath();
									}
								}
							}
							//If letters are in the range but not merged, then enable merging
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudio(R.raw.ma);
								
								mergeEnable1 = false;
								mergeEnable2 = true;
								mergeEnable3 = false;
								mergeEnable4 = false;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = false;
								mergeEnable8 = false;
								mergeEnable9 = false;
								mergeEnable10 = false;
								mergeEnable11 = false;
								mergeEnable12 = false;
							}
						}
						else
						{
							//Setting the maImage invisible when the letters are not merged
							//maImage.setVisible(false);
						}
						//////////////////////////////////////////////////
						// Calculating if 'mo' is in the range of 'shorea'
						 if (mo.getX() - shorea.getX() > 90
								&& mo.getX() - shorea.getX() < 110
								&& mo.getY() - shorea.getY() < 25
								&& mo.getY() - shorea.getY() > -25)
						{
							if (mo.getX() == shorea.getX() + 100)
							{
								if(Scissor.collidesWith(shorea) && Scissor.collidesWith(mo))
								{
									count3++;
									if(count3 == 1)
									{
										mergeEnable3 = false;
										mergeEnable4 = false;
										Paths.splitPath();
									}
								}
								
							}
							//If letters are in the range but not merged, then enable merging
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudio(R.raw.aam);

								mergeEnable1 = false;
								mergeEnable2 = false;
								mergeEnable3 = true;
								mergeEnable4 = false;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = false;
								mergeEnable8 = false;
								mergeEnable9 = false;
								mergeEnable10 = false;
								mergeEnable11 = false;
								mergeEnable12 = false;
							}

						}
						// Calculating if 'shorea' is in the range of 'mo'----making 'ma' word
						else if (shorea.getX() - mo.getX() > 90
								&& shorea.getX() - mo.getX() < 110
								&& shorea.getY() - mo.getY() < 25
								&& shorea.getY() - mo.getY() > -25) 
						{
							if (mo.getX() + 100 == shorea.getX()) 
							{
								//Setting the maImage visible when the letters are merged
								//maImage.setVisible(true);
								
								if(Scissor.collidesWith(shorea) && Scissor.collidesWith(mo))
								{
									count4++;
									if(count4 == 1)
									{
										mergeEnable3 = false;
										mergeEnable4 = false;
										Paths.splitPath();
									}
								}
							}
							//If letters are in the range but not merged, then enable merging
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudioLoop2(R.raw.mo, R.raw.shorea);
								
								mergeEnable1 = false;
								mergeEnable2 = false;
								mergeEnable3 = false;
								mergeEnable4 = true;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = false;
								mergeEnable8 = false;
								mergeEnable9 = false;
								mergeEnable10 = false;
								mergeEnable11 = false;
								mergeEnable12 = false;
							}
						}
						
						 //////////////////////////////////////////////////
						 // Calculating if 'akar' is in the range of 'shorea'
						 if (akar.getX() - shorea.getX() > 90
								 && akar.getX() - shorea.getX() < 110
								 && akar.getY() - shorea.getY() < 25
								 && akar.getY() - shorea.getY() > -25)
						 {
							 if (akar.getX() == shorea.getX() + 100)
							 {
								 if(Scissor.collidesWith(shorea) && Scissor.collidesWith(akar))
								 {
									 count5++;
									 if(count5 == 1)
									 {
										 mergeEnable5 = false;
										 mergeEnable6 = false;
										 Paths.splitPath();
									 }
								 }
			
							 }
							 //If letters are in the range but not merged, then enable merging
							 else
							 {
								 //play sound on join
								 soundFunction.audioPlay = true;
								 soundFunction.playAudioLoop2(R.raw.shorea, R.raw.akar);
								 
								 mergeEnable1 = false;
								 mergeEnable2 = false;
								 mergeEnable3 = false;
								 mergeEnable4 = false;
							     mergeEnable5 = true;
								 mergeEnable6 = false;
								 mergeEnable7 = false;
								 mergeEnable8 = false;
								 mergeEnable9 = false;
								 mergeEnable10 = false;
								 mergeEnable11 = false;
								 mergeEnable12 = false;
								 
							 }

						 }
						// Calculating if 'shorea' is in the range of 'akar'----making 'ma' word
						else if (shorea.getX() - akar.getX() > 90
								&& shorea.getX() - akar.getX() < 110
								&& shorea.getY() - akar.getY() < 25
								&& shorea.getY() - akar.getY() > -25) 
						{
							if (akar.getX() + 100 == shorea.getX()) 
							{
								//Setting the maImage visible when the letters are merged
								//maImage.setVisible(true);

								if(Scissor.collidesWith(shorea) && Scissor.collidesWith(akar))
								{
									count6++;
									if(count6 == 1)
									{
										mergeEnable5 = false;
										mergeEnable6 = false;
										Paths.splitPath();
									}
								}
							}
							//If letters are in the range but not merged, then enable merging
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudioLoop2(R.raw.akar, R.raw.shorea);
								
								mergeEnable1 = false;
								mergeEnable2 = false;
								mergeEnable3 = false;
								mergeEnable4 = false;
							    mergeEnable5 = false;
								mergeEnable6 = true;
								mergeEnable7 = false;
								mergeEnable8 = false;
								mergeEnable9 = false;
								mergeEnable10 = false;
								mergeEnable11 = false;
								mergeEnable12 = false;
							}
						}
						 
						//////////////////////////////////////////////////
						//1.'shorea'-'akar'-'mo'
						if(mo.getX() - akar.getX() > 90
								&& mo.getX() - akar.getX() < 110
								&& mo.getY() - akar.getY() < 25
								&& mo.getY() - akar.getY() > -25 
								&&
								akar.getX() - shorea.getX() > 90
								&& akar.getX() - shorea.getX() < 110
								&& akar.getY() - shorea.getY() < 25
								&& akar.getY() - shorea.getY() > -25)
						{ 
							if(mo.getX() == akar.getX() + 100 && akar.getX() == shorea.getX() + 100)
							{
								 if(Scissor.collidesWith(akar) && Scissor.collidesWith(mo))
								 {
									 mergeEnable7 = false;
									 mergeEnable5 = false;
								 }
								 else if(Scissor.collidesWith(shorea) && Scissor.collidesWith(akar))
								 {
									 mergeEnable7 = false;
									 mergeEnable1 = false;
								 }
							}
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudioLoop3(R.raw.shorea, R.raw.akar, R.raw.mo);
								
								mergeEnable1 = false;
								mergeEnable2 = false;
								mergeEnable3 = false;
								mergeEnable4 = false;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = true;
								mergeEnable8 = false;
								mergeEnable9 = false;
								mergeEnable10 = false;
								mergeEnable11 = false;
								mergeEnable12 = false;
								
							}
						}

						//2.'akar'-'shorea'-'mo'
						if(mo.getX() - shorea.getX() > 90
								&& mo.getX() - shorea.getX() < 110
								&& mo.getY() - shorea.getY() < 25
								&& mo.getY() - shorea.getY() > -25
								&&
								shorea.getX() - akar.getX() > 90
								&& shorea.getX() - akar.getX() < 110
								&& shorea.getY() - akar.getY() < 25
								&& shorea.getY() - akar.getY() > -25)
						{ 
							if(mo.getX() == shorea.getX() + 100 && akar.getX() + 100 == shorea.getX())
							{
								 if(Scissor.collidesWith(shorea) && Scissor.collidesWith(mo))
								 {
									 mergeEnable8 = false;
									 mergeEnable3 = false;
								 }
								 else if(Scissor.collidesWith(shorea) && Scissor.collidesWith(akar))
								 {
									 mergeEnable8 = false;
									 mergeEnable6 = false; 
								 } 
							}
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudioLoop3(R.raw.akar, R.raw.shorea, R.raw.mo);
								
								mergeEnable1 = false;
								mergeEnable2 = false;
								mergeEnable3 = false;
								mergeEnable4 = false;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = false;
								mergeEnable8 = true;
								mergeEnable9 = false;
								mergeEnable10 = false;
								mergeEnable11 = false;
								mergeEnable12 = false;
							}
						}
						
						//3.'akar'-'mo'-'shorea'
						if(akar.getX() - mo.getX() > 90
								&& akar.getX() - mo.getX() < 110
								&& akar.getY() - mo.getY() < 25
								&& akar.getY() - mo.getY() > -25
								&&
								mo.getX() - shorea.getX() > 90
								&& mo.getX() - shorea.getX() < 110
								&& mo.getY() - shorea.getY() < 25
								&& mo.getY() - shorea.getY() > -25)
						{ 
							if(mo.getX() + 100 == akar.getX() && mo.getX() == shorea.getX() + 100)
							{
								 if(Scissor.collidesWith(akar) && Scissor.collidesWith(mo))
								 {
									 mergeEnable9 = false;
									 mergeEnable2 = false;
								 }
								 else if(Scissor.collidesWith(shorea) && Scissor.collidesWith(mo))
								 {
									 mergeEnable9 = false;
									 mergeEnable3 = false;
								 } 
							}
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudioLoop3(R.raw.akar, R.raw.shorea, R.raw.mo);
								
								mergeEnable1 = false;
								mergeEnable2 = false;
								mergeEnable3 = false;
								mergeEnable4 = false;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = false;
								mergeEnable8 = false;
								mergeEnable9 = true;
								mergeEnable10 = false;
								mergeEnable11 = false;
								mergeEnable12 = false;
							}
						}
						
						//4.'mo'-'akar'-'shorea'
						if(akar.getX() - mo.getX() > 90
								&& akar.getX() - mo.getX() < 110
								&& akar.getY() - mo.getY() < 25
								&& akar.getY() - mo.getY() > -25
								&&
								shorea.getX() - akar.getX() > 90
								&& shorea.getX() - akar.getX() < 110
								&& shorea.getY() - akar.getY() < 25
								&& shorea.getY() - akar.getY() > -25)
						{ 
							if(mo.getX() + 100 == akar.getX() && akar.getX() + 100 == shorea.getX())
							{
								 if(Scissor.collidesWith(akar) && Scissor.collidesWith(mo))
								 {
									 mergeEnable10 = false;
									 mergeEnable2 = false;
								 }
								 else if(Scissor.collidesWith(shorea) && Scissor.collidesWith(akar))
								 {
									 mergeEnable10 = false;
									 mergeEnable6 = false;
								 } 
							}
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudioLoop3(R.raw.mo, R.raw.akar, R.raw.shorea);
							
								mergeEnable1 = false;
								mergeEnable2 = false;
								mergeEnable3 = false;
								mergeEnable4 = false;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = false;
								mergeEnable8 = false;
								mergeEnable9 = false;
								mergeEnable10 = true;
								mergeEnable11 = false;
								mergeEnable12 = false;
							}
						}
						
						//5.'mo'-'shorea'-'akar'
						if(shorea.getX() - mo.getX() > 90
								&& shorea.getX() - mo.getX() < 110
								&& shorea.getY() - mo.getY() < 25
								&& shorea.getY() - mo.getY() > -25
								&&
								akar.getX() - shorea.getX() > 90
								 && akar.getX() - shorea.getX() < 110
								 && akar.getY() - shorea.getY() < 25
								 && akar.getY() - shorea.getY() > -25)
						{ 
							if(mo.getX() + 100 == shorea.getX() && akar.getX() == shorea.getX() + 100)
							{
								 if(Scissor.collidesWith(mo) && Scissor.collidesWith(shorea))
								 {
									 mergeEnable11 = false;
									 mergeEnable4 = false;
								 }
								 else if(Scissor.collidesWith(shorea) && Scissor.collidesWith(akar))
								 {
									 mergeEnable11 = false;
									 mergeEnable5 = false;
								 } 
							}
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudioLoop3(R.raw.mo, R.raw.shorea, R.raw.akar);
								
								mergeEnable1 = false;
								mergeEnable2 = false;
								mergeEnable3 = false;
								mergeEnable4 = false;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = false;
								mergeEnable8 = false;
								mergeEnable9 = false;
								mergeEnable10 = false;
								mergeEnable11 = true;
								mergeEnable12 = false;
							}
						}
						
						//6.'akar'-'mo'-'shorea'
						if(mo.getX() - akar.getX() > 90
								&& mo.getX() - akar.getX() < 110
								&& mo.getY() - akar.getY() < 25
								&& mo.getY() - akar.getY() > -25
								&&
								shorea.getX() - mo.getX() > 90
								&& shorea.getX() - mo.getX() < 110
								&& shorea.getY() - mo.getY() < 25
								&& shorea.getY() - mo.getY() > -25)
						{
							if(mo.getX() == akar.getX() + 100 && mo.getX() + 100 == shorea.getX())
							{
								 if(Scissor.collidesWith(mo) && Scissor.collidesWith(shorea))
								 {
									 mergeEnable12 = false;
									 mergeEnable4 = false;
								 }
								 else if(Scissor.collidesWith(akar) && Scissor.collidesWith(mo))
								 {
									 mergeEnable12 = false;
									 mergeEnable1 = false;
								 } 
							}
							else
							{
								//play sound on join
								soundFunction.audioPlay = true;
								soundFunction.playAudioLoop3(R.raw.akar, R.raw.mo, R.raw.shorea);
								
								mergeEnable1 = false;
								mergeEnable2 = false;
								mergeEnable3 = false;
								mergeEnable4 = false;
								mergeEnable5 = false;
								mergeEnable6 = false;
								mergeEnable7 = false;
								mergeEnable8 = false;
								mergeEnable9 = false;
								mergeEnable10 = false;
								mergeEnable11 = false;
								mergeEnable12 = true;
							}
						}
					}
				}));

		// Bangla Letter 'Akar'
		akar = new Letter1(centerX, centerY, this.mAkarTextureRegion, getVertexBufferObjectManager());
		mScene.registerTouchArea(akar);
		mScene.attachChild(akar);
		
		// Bangla Letter 'MO'
		mo = new Letter2(centerX + 200, centerY, this.mMOTextureRegion, getVertexBufferObjectManager());
		mScene.registerTouchArea(mo);
		mScene.attachChild(mo);
		
		// Bangla Letter 'shorea'
		shorea = new Letter3(centerX, centerY+200, this.mShoreaTextureRegion, getVertexBufferObjectManager());
		mScene.registerTouchArea(shorea);
		mScene.attachChild(shorea);

		// Scissor
		Scissor = new Scissor(MainActivity.CAMERA_WIDTH - MainActivity.CAMERA_WIDTH/5, MainActivity.CAMERA_HEIGHT - MainActivity.CAMERA_HEIGHT/4,
		mScissorTextureRegion, getVertexBufferObjectManager());
		mScene.registerTouchArea(Scissor);
		mScene.attachChild(Scissor);
		Scissor.setWidth((float) (80));
		Scissor.setHeight(87);
		
		return mScene;
	}
	
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		
		if(soundFunction.mediaPlayer!= null)
		{
			soundFunction.mediaPlayer.release();
			soundFunction.mediaPlayer = null;
		}
		
		if(soundFunction.mediaPlayer1!= null)
		{
			soundFunction.mediaPlayer1.release();
			soundFunction.mediaPlayer1 = null;
		}
		
		if(soundFunction.mediaPlayer2!= null)
		{
			soundFunction.mediaPlayer2.release();
			soundFunction.mediaPlayer2 = null;
		}
	}
		
}
