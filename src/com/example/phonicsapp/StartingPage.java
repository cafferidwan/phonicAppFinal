package com.example.phonicsapp;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;
import android.content.Context;
import android.view.Display;

public class StartingPage extends SimpleBaseGameActivity
{

	static int CAMERA_WIDTH;
	static int CAMERA_HEIGHT;

	public Camera mCamera;
	public static Scene mScene;
	static Context context;
	
	public static StartingPage instace;
	
	private BuildableBitmapTextureAtlas mBitmapTextureAtlas, mBitmapTextureAtlas1;
	public static ITextureRegion mKolomTextureRegion, mBoardTextureRegion, mParrotTextureRegion;
	public static ITextureRegion mMoTextureRegion;
	
	public static ITextureRegion mbackGroundTextureRegion, mbackGround2TextureRegion;
	
	public static Sprite backGround, backGround2;
	public static Sprite parrot, board, kolom;
	public static Sprite mo;
	
	public static VertexBufferObjectManager vertexBufferObjectManager;
	
	@Override
	public EngineOptions onCreateEngineOptions()
	{
		// TODO Auto-generated method stub
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HEIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();
		
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	
	}

	@Override
	protected void onCreateResources() 
	{
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");

		mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(
				getTextureManager(), 1600, 1200);
		
		mBitmapTextureAtlas1 = new BuildableBitmapTextureAtlas(
				getTextureManager(), 1600, 1200);

		mbackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "bg-1.png");
		mbackGround2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "bg-2.png");
		
		mKolomTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "kolom-2.png");
		mBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "board.png");
		mParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "parrot-3.png");
		
		mMoTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "mo.png");
		
		try 
		{
			mBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
					BitmapTextureAtlas>(0, 0, 0));
			mBitmapTextureAtlas.load();
		} 
		
		catch (TextureAtlasBuilderException e)
		{
			Debug.e(e);
		}
		try 
		{
			mBitmapTextureAtlas1.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource,
					BitmapTextureAtlas>(0, 0, 0));
			mBitmapTextureAtlas1.load();
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
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));
		mScene.setTouchAreaBindingOnActionDownEnabled(true);
		
		backGround = new Sprite(0, 0, mbackGroundTextureRegion, getVertexBufferObjectManager());
		backGround.setHeight(CAMERA_HEIGHT);
		backGround.setWidth(CAMERA_WIDTH);
		mScene.attachChild(backGround);
		
		parrot = new Sprite(CAMERA_WIDTH/3-200, CAMERA_HEIGHT-300, mParrotTextureRegion, getVertexBufferObjectManager())
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
					case TouchEvent.ACTION_DOWN:
					
						this.setScale((float) 1.2);
						
						mScene = new MenuPage();
						setCurrentScene(mScene);
						
					break;
					
					case TouchEvent.ACTION_UP:
						
						this.setScale((float) 1.0);
						
					break;
				}

				return true;
			}
		};
		Debug.d("CAMERA_HEIGHT:"+CAMERA_HEIGHT);
		Debug.d("CAMERA_WIDTH:"+CAMERA_WIDTH);
		//parrot.setHeight((float) (CAMERA_HEIGHT / 3.065));
		//parrot.setWidth((float) (CAMERA_WIDTH / 3.6));
		mScene.registerTouchArea(parrot);
		mScene.attachChild(parrot);
		
		kolom = new Sprite(CAMERA_WIDTH/2-100, CAMERA_HEIGHT-250, mKolomTextureRegion, getVertexBufferObjectManager())
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
				case TouchEvent.ACTION_DOWN:
					
					this.setScale((float) 1.2);
				break;
				case TouchEvent.ACTION_UP:
					
					this.setScale((float) 1.0);
				break;
				}

				return true;
			}
		};
		//kolom.setHeight(CAMERA_HEIGHT/3);
		//kolom.setWidth(CAMERA_WIDTH/3);
		mScene.registerTouchArea(kolom);
		mScene.attachChild(kolom);

		board = new Sprite(CAMERA_WIDTH/2+130, CAMERA_HEIGHT-250, mBoardTextureRegion, getVertexBufferObjectManager())
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
				case TouchEvent.ACTION_DOWN:
					
					this.setScale((float) 1.1);
				break;
				case TouchEvent.ACTION_UP:
					
					this.setScale((float) 1.0);
				break;
				}

				return true;
			}
		};
		board.setHeight(CAMERA_HEIGHT/3);
		board.setWidth(CAMERA_WIDTH/3-60);
		mScene.registerTouchArea(board);
		mScene.attachChild(board);
		
		vertexBufferObjectManager = getVertexBufferObjectManager();
		
		return mScene;
	}

	public static StartingPage getSharedInstances()
	{
		return instace;
	}
	
	public void setCurrentScene(Scene scene)
	{
		mScene = scene;
		getEngine().setScene(mScene);
	}

}
