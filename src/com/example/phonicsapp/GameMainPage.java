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

import com.example.phonicsapp.animatedBook.AnimatedBookActivity;
import com.example.phonicsapp.boxGame.BoxGameActivity;
import com.example.phonicsapp.monkeyGame.MonkeyGameActivity;
import com.example.phonicsapp.wordbuilder.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.view.Display;


public class GameMainPage extends SimpleBaseGameActivity
{

	static int CAMERA_WIDTH;
	static int CAMERA_HEIGHT;

	public Camera mCamera;
	public static Scene mScene;
	static Context context;
	
	public static GameMainPage GameMainPageInstace;
	
	private BuildableBitmapTextureAtlas mBitmapTextureAtlas, mBitmapTextureAtlas1;
	public static ITextureRegion mKolomTextureRegion, mBoardTextureRegion, mParrotTextureRegion;
	public static ITextureRegion mMoTextureRegion;
	
	public static ITextureRegion mbackGroundTextureRegion, mbackGround2TextureRegion;
	
	public static Sprite backGround, backGround2;
	public static Sprite parrot, board, monkey;
	public static Sprite mo;
	
	public static VertexBufferObjectManager vertexBufferObjectManager;
	
	public static GameMainPage getSharedInstances()
	{
		return GameMainPageInstace;
	}
	
	@Override
	public EngineOptions onCreateEngineOptions()
	{
		// TODO Auto-generated method stub
		GameMainPageInstace = this;
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
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gameMenuGfx/");

		mBitmapTextureAtlas = new BuildableBitmapTextureAtlas(
				getTextureManager(), 2600, 2200);
		
		mBitmapTextureAtlas1 = new BuildableBitmapTextureAtlas(
				getTextureManager(), 2600, 2200);

		mbackGroundTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "bg3.png");
		mbackGround2TextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas1, this, "bg.png");
		
		mKolomTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "monkey.png");
		mBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "board.png");
		mParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(this.mBitmapTextureAtlas, this, "parrot.png");
		
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
		
		
		GameMainPage.context = getApplicationContext();
		
		backGround = new Sprite(0, 0, mbackGroundTextureRegion, getVertexBufferObjectManager());
		backGround.setHeight(CAMERA_HEIGHT);
		backGround.setWidth(CAMERA_WIDTH);
		mScene.attachChild(backGround);
		
		parrot = new Sprite(CAMERA_WIDTH/5-200, CAMERA_HEIGHT/2-150, mParrotTextureRegion, getVertexBufferObjectManager())
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
		mScene.registerTouchArea(parrot);
		mScene.attachChild(parrot);
		parrot.setWidth(CAMERA_WIDTH/3.0f);
		parrot.setHeight(CAMERA_HEIGHT/2.5f);
		
		monkey = new Sprite(CAMERA_WIDTH/2 - 20, 0, mKolomTextureRegion, getVertexBufferObjectManager())
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
		mScene.registerTouchArea(monkey);
		mScene.attachChild(monkey);
//		monkey.setWidth(CAMERA_WIDTH/6.6f);
//		monkey.setHeight((float) (CAMERA_HEIGHT/2.2));

		board = new Sprite(CAMERA_WIDTH-230, CAMERA_HEIGHT/2-20, mBoardTextureRegion, getVertexBufferObjectManager())
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
				case TouchEvent.ACTION_DOWN:
					this.setScale((float) 1.1);
					startActivityWordBuild();
				break;
				case TouchEvent.ACTION_UP:
					
					this.setScale((float) 1.0);
				break;
				}

				return true;
			}
		};
		mScene.registerTouchArea(board);
		mScene.attachChild(board);
//		board.setWidth(CAMERA_WIDTH/5.3f);
//		board.setHeight(CAMERA_HEIGHT/2.2f);
		
		vertexBufferObjectManager = getVertexBufferObjectManager();
		
		return mScene;
	}

	void startActivity()
	{
		finish();
		startActivity(new Intent(this, AnimatedBookActivity.class));
	}
	
	public void setCurrentScene(Scene scene)
	{
		mScene = scene;
		getEngine().setScene(mScene);
	}
	public void startActivityWordBuild()
	{
		finish();
		startActivity(new Intent(getBaseContext(), MainActivity.class));
	}

}
