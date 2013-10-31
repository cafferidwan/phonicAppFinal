package com.example.phonicsapp.animatedBook;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
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
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import com.example.phonicsapp.R;
import com.example.phonicsapp.boxGame.BoxGameActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Display;

public class AnimatedBookActivity extends SimpleBaseGameActivity 
{
	public static int CAMERA_HEIGHT;
	public static int CAMERA_WIDTH;
	public static Context context;
	public static Camera mCamera;
	static float ImageWidth;
	static float ImageHeight;
	
	
	static int NextCount=1;
	static boolean ArrowTouchEnable = false;
	
	static float ImagePosX;
	static float ImagePosY;
	
	//Background 
	public static BuildableBitmapTextureAtlas BgBuildableBitmapTextureAtlas;
	public static ITextureRegion BgTextureRegion;
	public static ITextureRegion SpriteBgTextureRegion;
	public static Scene mMainScene;
	public static Sprite BgSprite;
	public static Sprite NextSprite;
	public static Sprite SpriteBg;
	
	//Letters 
	public static BuildableBitmapTextureAtlas LetterBuildableBitmapTextureAtlas;
	
	//Letter images 1 Aaa
	public static ITextureRegion MangoTextureRegion;
	public static ITextureRegion AppleTextureRegion;
	public static ITextureRegion GingerTextureRegion;
	public static ITextureRegion PineappleTextureRegion;
	public static ITextureRegion PotatoTextureRegion;
	public static ITextureRegion SkyTextureRegion;
	
	//Letter images 2 Moo
	public static BuildableBitmapTextureAtlas Letter2BuildableBitmapTextureAtlas;
	public static ITextureRegion MaTextureRegion;
	public static ITextureRegion MamaTextureRegion;
	public static ITextureRegion MoiTextureRegion;
	public static ITextureRegion MeghTextureRegion;
	public static ITextureRegion MulaTextureRegion;
	public static ITextureRegion MohisTextureRegion;
	
	//Letter images 3 Taa
	public static BuildableBitmapTextureAtlas Letter3BuildableBitmapTextureAtlas;
	public static ITextureRegion SelfTextureRegion;
	public static ITextureRegion TalTextureRegion;
	public static ITextureRegion TalaTextureRegion;
	public static ITextureRegion TaraTextureRegion;
	public static ITextureRegion TuliTextureRegion;
	public static ITextureRegion TamaTextureRegion;
	
	//Letter images 4 Laa
	public static BuildableBitmapTextureAtlas Letter4BuildableBitmapTextureAtlas;
	public static ITextureRegion LalTextureRegion;
	public static ITextureRegion LangolTextureRegion;
	public static ITextureRegion LataTextureRegion;
	public static ITextureRegion LatimTextureRegion;
	public static ITextureRegion LauuTextureRegion;
	public static ITextureRegion LebuTextureRegion;
	
	//Letter images 5 Ko
	public static BuildableBitmapTextureAtlas Letter5BuildableBitmapTextureAtlas;
	public static ITextureRegion KakTextureRegion;
	public static ITextureRegion KaramTextureRegion;
	public static ITextureRegion KolaTextureRegion;
	public static ITextureRegion KolTextureRegion;
	public static ITextureRegion KolomTextureRegion;
	public static ITextureRegion KomlaTextureRegion;
	
	//Next Arrow
	public static ITextureRegion NextTextureRegion;
	
	//Parrot image Flying
	public BitmapTextureAtlas ParrotBitmapTextureAtlus;
	public static TiledTextureRegion ParrotTextureRegion;

	//Letter 
	public static BuildableBitmapTextureAtlas LetterAllBuildableBitmapTextureAtlas;
	public static ITextureRegion LetterKoTextureRegion;
	public static ITextureRegion LetterMoTextureRegion;
	public static ITextureRegion LetterLaTextureRegion;
	public static ITextureRegion LetterToTextureRegion;
	public static ITextureRegion LetterAaaTextureRegion;
	
	public static VertexBufferObjectManager vertexBufferObjectManager;
	
	@Override
	public EngineOptions onCreateEngineOptions() 
	{
		// TODO Auto-generated method stub
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HEIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();
		
		ImageHeight = CAMERA_HEIGHT/2.5f;
		ImageWidth = CAMERA_WIDTH/4.5f;
		
		ImagePosX = CAMERA_WIDTH/100;
		ImagePosY = CAMERA_HEIGHT/20;
		
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);		
		
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
	}
	@Override
	protected void onCreateResources() 
	{
		// TODO Auto-generated method stub
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("AnimatedBookGfx/");
		BgBuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(getTextureManager(), 1800, 1432,TextureOptions.DEFAULT);
		BgTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "jungle16.png");
		
		//Letter Image
		LetterBuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(getTextureManager(), 1400, 900,TextureOptions.DEFAULT);
		
		SpriteBgTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "spritebg.png");
		
		MangoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/mango2.png");
		AppleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/apple.png");
		GingerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/ginger.png");
		PineappleTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/pineapple.png");
		PotatoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/potato.png");
		SkyTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "grp1/sky.png");
		NextTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterBuildableBitmapTextureAtlas, this, "a.png");
		
		//Letter Group 2 Moo
		Letter2BuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(getTextureManager(), 1200, 800,TextureOptions.DEFAULT);
		MaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/ma.png");
		MamaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/mama.png");
		MulaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/mula.png");
		MeghTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/megh.png");
		MoiTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/moi.png");
		MohisTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter2BuildableBitmapTextureAtlas, this, "grp2/mohish.png");
		
		//Letter Group 3 Taa 
		Letter3BuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(getTextureManager(), 1300, 800,TextureOptions.DEFAULT);
		SelfTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/shelfe.png");
		TalTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tal.png");
		TalaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tala.png");
		TaraTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tara.png");
		TuliTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tulee.png");
		TamaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter3BuildableBitmapTextureAtlas, this, "grp3/tama.png");
				
		//Letter Group 4 Laa
		Letter4BuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(getTextureManager(), 1200, 800,TextureOptions.DEFAULT);
		LalTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/lal.png");
		LangolTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/langol.png");
		LataTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/lata.png");
		LatimTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/latim.png");
		LauuTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/lauu.png");
		LebuTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter4BuildableBitmapTextureAtlas, this, "grp4/lebu.png");
								
		//Letter Group 5 Ko
		Letter5BuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(getTextureManager(), 1200, 800,TextureOptions.DEFAULT);
		KakTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/kak.png");
		KaramTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/karam.png");
		KolTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/kol.png");
		KolaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/kola.png");
		KolomTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/kolom.png");
		KomlaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(Letter5BuildableBitmapTextureAtlas, this, "grp5/komla.png");
					
		// Letter All 
		LetterAllBuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(getTextureManager(), 1200, 1200,TextureOptions.DEFAULT);
		LetterKoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp5/letter_ko.png");
		LetterMoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp2/letter_mo.png");
		LetterLaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp4/letter_lo.png");
		LetterToTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp3/letter_to.png");
		LetterAaaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(LetterAllBuildableBitmapTextureAtlas, this, "grp1/letter_aa.png");
		
		ParrotBitmapTextureAtlus = new BitmapTextureAtlas(getTextureManager(), 1000, 338,TextureOptions.DEFAULT);
		ParrotTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(ParrotBitmapTextureAtlus, this, "parrot1.png",0,0,6,2);
		
		
		try
		{
			BgBuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			BgBuildableBitmapTextureAtlas.load();
			
			LetterBuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			LetterBuildableBitmapTextureAtlas.load();
			Letter2BuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			Letter2BuildableBitmapTextureAtlas.load();
			Letter3BuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			Letter3BuildableBitmapTextureAtlas.load();
			Letter4BuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			Letter4BuildableBitmapTextureAtlas.load();
			Letter5BuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			Letter5BuildableBitmapTextureAtlas.load();
			LetterAllBuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			LetterAllBuildableBitmapTextureAtlas.load();
			
			ParrotBitmapTextureAtlus.load();
			
		} 
		catch (TextureAtlasBuilderException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected Scene onCreateScene() 
	{
		
		mEngine.registerUpdateHandler(new FPSLogger());
		mMainScene = new Scene();
		
		vertexBufferObjectManager = getVertexBufferObjectManager();
		AnimatedBookActivity.context = getApplicationContext();
		
		mMainScene.setTouchAreaBindingOnActionMoveEnabled(true);
		
		BgSprite = new Sprite(0, 0, BgTextureRegion,vertexBufferObjectManager);
		BgSprite.setHeight(CAMERA_HEIGHT);
		BgSprite.setWidth(CAMERA_WIDTH);
		mMainScene.attachChild(BgSprite);
						
		nextStage(2);
		return mMainScene;
	}
	  public  void nextStage(int stage)
	  {
		  TiledImage.ObjNo = 1;
		if(stage == 1)
		{
			loadImage1(MangoTextureRegion,R.raw.mama);
			loadImage2(AppleTextureRegion,R.raw.mama);
			loadImage3(GingerTextureRegion,R.raw.mama);
			loadImage4(PineappleTextureRegion,R.raw.mama);
			loadImage5(PotatoTextureRegion,R.raw.mama);
			loadImage6(SkyTextureRegion,R.raw.mama);
			loadParrotAndNext(ParrotTextureRegion,NextTextureRegion,LetterAaaTextureRegion);
		}
		//'mo' letter
		else if(stage == 2)
		{
			loadImage1(MamaTextureRegion,R.raw.mama);
			loadImage2(MaTextureRegion,R.raw.ma);
			loadImage3(MohisTextureRegion,R.raw.mohis);
			loadImage4(MulaTextureRegion,R.raw.mula);
			loadImage5(MoiTextureRegion,R.raw.moi);
			loadImage6(MeghTextureRegion,R.raw.megh);
			loadParrotAndNext(ParrotTextureRegion,NextTextureRegion,LetterMoTextureRegion);
		}
		else if(stage == 3)
		{
			Letter2BuildableBitmapTextureAtlas.clearTextureAtlasSources();
			loadImage1(SelfTextureRegion,R.raw.mama);
			loadImage2(TalTextureRegion,R.raw.mama);
			loadImage3(TalaTextureRegion,R.raw.mama);
			loadImage4(TaraTextureRegion,R.raw.mama);
			loadImage5(TuliTextureRegion,R.raw.mama);
			loadImage6(TamaTextureRegion,R.raw.mama);
			loadParrotAndNext(ParrotTextureRegion,NextTextureRegion,LetterToTextureRegion);
		}
		else if(stage == 4)
		{
			Letter3BuildableBitmapTextureAtlas.clearTextureAtlasSources();
			Log.d("TitledImage", " In 4 ");
			loadImage1(LalTextureRegion,R.raw.mama);
			loadImage2(LangolTextureRegion,R.raw.mama);
			loadImage3(LataTextureRegion,R.raw.mama);
			loadImage4(LatimTextureRegion,R.raw.mama);
			loadImage5(LauuTextureRegion,R.raw.mama);
			loadImage6(LebuTextureRegion,R.raw.mama);
			loadParrotAndNext(ParrotTextureRegion,NextTextureRegion,LetterLaTextureRegion);
		}
		else if(stage == 5)
		{
			Letter3BuildableBitmapTextureAtlas.clearTextureAtlasSources();
			loadImage1(KakTextureRegion,R.raw.mama);
			loadImage2(KaramTextureRegion,R.raw.mama);
			loadImage3(KolTextureRegion,R.raw.mama);
			loadImage4(KolaTextureRegion,R.raw.mama);
			loadImage5(KolomTextureRegion,R.raw.mama);
			loadImage6(KomlaTextureRegion,R.raw.mama);
			loadParrotAndNext(ParrotTextureRegion,NextTextureRegion,LetterKoTextureRegion);
		}
	}
	
	static void loadImage1(ITextureRegion r1, int voice)
	{
		TiledImage t1 = new TiledImage(ImagePosX, ImagePosY, ImageWidth , ImageHeight, r1, vertexBufferObjectManager,voice,AnimatedBookActivity.context);
		mMainScene.registerTouchArea(t1.Letter);
		mMainScene.attachChild(t1.Letter);
	}
	
	static void loadImage2(ITextureRegion r1, int voice)
	{
		TiledImage t2 = new TiledImage(ImagePosX+(CAMERA_WIDTH*0.22f), ImagePosY, ImageWidth , ImageHeight, r1, vertexBufferObjectManager,voice,AnimatedBookActivity.context);
		mMainScene.registerTouchArea(t2.Letter);
		mMainScene.attachChild(t2.Letter);
	}
	
	static void loadImage3(ITextureRegion r1,int voice)
	{
		TiledImage t3 = new TiledImage(ImagePosX+(CAMERA_WIDTH*0.44f), ImagePosY, ImageWidth , ImageHeight, r1, vertexBufferObjectManager,voice,AnimatedBookActivity.context);
		mMainScene.registerTouchArea(t3.Letter);
		mMainScene.attachChild(t3.Letter);
		
	}
	
	static void loadImage4(ITextureRegion r1,int voice)
	{
		TiledImage t4 = new TiledImage(ImagePosX, ImagePosY+(CAMERA_HEIGHT*0.44f), ImageWidth , ImageHeight,r1 , vertexBufferObjectManager,voice,AnimatedBookActivity.context);
		mMainScene.registerTouchArea(t4.Letter);
		mMainScene.attachChild(t4.Letter);
		
	}
	
	static void loadImage5(ITextureRegion r1, int voice)
	{
		TiledImage t5 = new TiledImage(ImagePosX+(CAMERA_WIDTH*0.22f), ImagePosY+(CAMERA_HEIGHT*0.44f), ImageWidth , ImageHeight, r1, vertexBufferObjectManager,voice,AnimatedBookActivity.context);
		mMainScene.registerTouchArea(t5.Letter);
		mMainScene.attachChild(t5.Letter);
		
	}
	
	static void loadImage6(ITextureRegion r1 , int voice)
	{
		TiledImage t6 = new TiledImage(ImagePosX+(CAMERA_WIDTH*0.44f), ImagePosY+(CAMERA_HEIGHT*0.44f), ImageWidth , ImageHeight, r1, vertexBufferObjectManager,voice,AnimatedBookActivity.context);
		mMainScene.registerTouchArea(t6.Letter);
		mMainScene.attachChild(t6.Letter);
		
	}
	
	 void loadParrotAndNext(TiledTextureRegion p , ITextureRegion n,ITextureRegion l)
	{
		Parrot p1 = new Parrot(CAMERA_WIDTH + 200,CAMERA_WIDTH - 250, CAMERA_HEIGHT / 2 ,CAMERA_HEIGHT / 2, p, vertexBufferObjectManager, R.raw.mama, AnimatedBookActivity.context,l);
		mMainScene.registerTouchArea(p1.parrotFlying);
		mMainScene.attachChild(p1.parrotFlying);
		createNextArrow(CAMERA_WIDTH-100f, CAMERA_HEIGHT-100f, 200f, 200f, n, 1);
		mMainScene.registerTouchArea(NextSprite);
		mMainScene.attachChild(NextSprite);
		mMainScene.attachChild(p1.mLetter);
		mMainScene.sortChildren();
	}
	void createNextArrow(float pX, float pY, float pWidth, float pHeight,ITextureRegion pTextureRegion, int voice)
	{
		NextSprite = new Sprite(pX, pY, pTextureRegion, vertexBufferObjectManager)
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
			{
				switch (pSceneTouchEvent.getAction()) 
				{
					case TouchEvent.ACTION_DOWN:
					{
						break;
					}
					case TouchEvent.ACTION_MOVE: 
					{
						break;
					}
					case TouchEvent.ACTION_UP: 
					{
						if(ArrowTouchEnable)
						{
							ArrowTouchEnable = false;
							startActivity();
							/*
							AnimatedBookActivity.mMainScene.detachChildren();
							mMainScene.attachChild(BgSprite);
							TiledImage.ObjNo = 0;
							NextCount++;
							nextStage(NextCount);
							*/
						}
						break;
					}
					default:
					{
	
					}
				}
				return false;
			}
		};
	}
	
	void startActivity()
	{
		finish();
		startActivity(new Intent(this, BoxGameActivity.class));
	}
}
