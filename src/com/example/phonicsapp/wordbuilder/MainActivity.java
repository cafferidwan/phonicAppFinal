package com.example.phonicsapp.wordbuilder;

import java.util.ArrayList;
import java.util.Timer;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.ITouchArea;
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
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseActivity;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import com.example.phonicsapp.GameMainPage;
import com.example.phonicsapp.R;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Display;

public class MainActivity extends SimpleBaseGameActivity {

	public static int CAMERA_WIDTH;
	public static int CAMERA_HEIGHT;
	public static Scene mCurrentScene;
	public static Scene mCurrentScene1;
	public static BaseActivity instance;
	public Camera mCamera;
	public static boolean isMove =true;	
	public static int ma_amm_secuenceCount;
	
	//public static Entity en1 = new Entity();
	
	
	public Sprite BgSprite;
	public static Sprite sprite1,sprite2,buttonHome;
	public static ArrayList<sprite2> SpriteList;
	public static VertexBufferObjectManager vobm;	
	public static ArrayList<sprite3> SpriteContainer;
	public static ArrayList<sprite3> SpriteContainer1;
	
	public static sprite2 sp1,sp2,sp3,spg;
	public static sprite3 sp3a,sp3b,sp3c,sp3d;
	public static CharactorObject c1,cAmm;
	public static Parrot anm1;
	public static EngineOptions engOps;
	
	public static boolean isMaa=true,isAmm=false;
	
	public static BuildableBitmapTextureAtlas BgBuildableBitmapTextureAtlas;
	public BitmapTextureAtlas ParrotBitmapTextureAtlus;
	public static ITextureRegion BgTextureReason;
	public static ITextureRegion Letter1TextureReason;
	public static ITextureRegion Letter2TextureReason;
	public static ITextureRegion Letter3TextureReason;
	public static ITextureRegion MaTextureReason;
	public static ITextureRegion KachiTextureReason;
	public static ITextureRegion ParrotUpTextureReason;
	public static ITextureRegion ParrotDownTextureReason;
	public static TiledTextureRegion ParrotTextureReason;
	private static MediaPlayer mediaPlayer;
	public static ITextureRegion AmmTextureReason;
	public static ITextureRegion ButtonHomeTextureReason;
	
	public static int[] tracksContainer = new int[3];
	public static int audioIndexCounter=0;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		Display display = getWindowManager().getDefaultDisplay();
		CAMERA_HEIGHT = display.getHeight();
		CAMERA_WIDTH = display.getWidth();
		instance = this;
		ma_amm_secuenceCount = 0;
		MainActivity.isMaa = true;
		MainActivity.isAmm = false;
		tracksContainer[0]=R.raw.aakar;
		tracksContainer[1]=R.raw.shoroa;
		tracksContainer[2]=R.raw.mo;
		
		//vobm = getVertexBufferObjectManager();
		SpriteList = new ArrayList<sprite2>();
		SpriteContainer = new ArrayList<sprite3>();
		SpriteContainer1 = new ArrayList<sprite3>();
	    mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
	    engOps = new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), mCamera);
		engOps.getTouchOptions().setNeedsMultiTouch(true);
	    return engOps; 
	}

	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("WordBuildingGfx/");
		BgBuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 2900, 2532,TextureOptions.DEFAULT);
		MainActivity.BgTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "jungle16.png");
		MainActivity.Letter1TextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "akar.png");
		MainActivity.Letter2TextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "shoroa.png");
		MainActivity.Letter3TextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "mo.png");
		MainActivity.MaTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "ma.png");
		MainActivity.AmmTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "amm.png");
		MainActivity.KachiTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "kachi.png");
		MainActivity.ParrotUpTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "parrot_up.png");
		//this.ParrotDownTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "parrot_down.png");
		MainActivity.ButtonHomeTextureReason = BitmapTextureAtlasTextureRegionFactory.createFromAsset(BgBuildableBitmapTextureAtlas, this, "button_home.png");
		
		ParrotBitmapTextureAtlus = new BitmapTextureAtlas(this.getTextureManager(), 1200, 400,TextureOptions.DEFAULT);
		MainActivity.ParrotTextureReason = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(ParrotBitmapTextureAtlus, this, "sprite_parrot4.png",0,0,3,1);
		try {
			BgBuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			BgBuildableBitmapTextureAtlas.load();
			ParrotBitmapTextureAtlus.load();

		} catch (TextureAtlasBuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub
		mCurrentScene = new Scene();
		mCurrentScene.setTouchAreaBindingOnActionMoveEnabled(true);
	    mCurrentScene.setBackground(new Background(0.09804f, 0.7274f, 0.8f));
	    
		BgSprite = new Sprite(0, 0, BgTextureReason, getVertexBufferObjectManager());
	    BgSprite.setHeight(CAMERA_HEIGHT);
		BgSprite.setWidth(CAMERA_WIDTH);
		mCurrentScene.attachChild(BgSprite);
		mCurrentScene.setUserData("MainScene");
		
		loadHomeButton();
		
		//myRectangle1 = new GroupSprite(110f, 110f, 50f, 30f, this.getVertexBufferObjectManager());
		//myRectangle1.myRectangle.attachChild(en1);
		//en1.setUserData("Entity1");
//		mCurrentScene.attachChild(myRectangle1.myRectangle);
//		mCurrentScene.registerTouchArea(myRectangle1.myRectangle);
		
		sp3a = new sprite3(CAMERA_WIDTH - 350, CAMERA_HEIGHT - 150, 100f, 100f, Letter1TextureReason, getVertexBufferObjectManager(),1,R.raw.aakar,getApplicationContext());
		sp3b = new sprite3(CAMERA_WIDTH - 500, CAMERA_HEIGHT - 150, 100f, 100f, Letter2TextureReason, getVertexBufferObjectManager(),1,R.raw.shoroa,getApplicationContext());
		sp3c = new sprite3(CAMERA_WIDTH - 650, CAMERA_HEIGHT - 150, 100f, 100f, Letter3TextureReason, getVertexBufferObjectManager(),1,R.raw.mo,getApplicationContext());
		sp3d = new sprite3(CAMERA_WIDTH - 150, CAMERA_HEIGHT - 150, 100f, 100f, KachiTextureReason, getVertexBufferObjectManager(),1,0,getApplicationContext());
		c1 = new CharactorObject(CAMERA_WIDTH/2 - 150, CAMERA_HEIGHT/2 - 200, 170f, 200f, MaTextureReason, getVertexBufferObjectManager(),R.raw.ma);
		cAmm = new CharactorObject(CAMERA_WIDTH/2 - 150, CAMERA_HEIGHT/2 - 200, 170f, 170f, AmmTextureReason, getVertexBufferObjectManager(),R.raw.aam1);
		//buttonHome= new CharactorObject(10,10, 50f, 50f, ButtonHomeTextureReason, getVertexBufferObjectManager(),0);
		Parrot parrot = new Parrot(CAMERA_WIDTH -200, CAMERA_HEIGHT/4-100, 200, 200, ParrotTextureReason, this.getVertexBufferObjectManager());
		anm1 = parrot;
		anm1.normalState();
		
		sp3a.s3 = sp3a;
		sp3b.s3 = sp3b;
		sp3c.s3 = sp3c;
		sp3d.s3 = sp3d;
		
		sp3a.sprite1.setUserData("akar");
		sp3b.sprite1.setUserData("shoroa");
		sp3c.sprite1.setUserData("mo");
		
		sp3a.sprite1.setZIndex(100);
		sp3b.sprite1.setZIndex(2000);
		sp3c.sprite1.setZIndex(30000);
		
		SpriteContainer1.add(sp3a);
		SpriteContainer1.add(sp3b);
		SpriteContainer1.add(sp3c);
		
		sp3d.sprite1.setZIndex(9998);
		mCurrentScene.attachChild(sp3d.sprite1);
		mCurrentScene.attachChild(c1.sprite1);
		mCurrentScene.attachChild(sp3a.sprite1);
		mCurrentScene.attachChild(sp3b.sprite1);	
		mCurrentScene.attachChild(sp3c.sprite1);	
		
		mCurrentScene.attachChild(anm1.anm1);
		
		
		sp3d.sizzer = true;		
		
		mCurrentScene.sortChildren();
		return mCurrentScene;
	}
	
	public static int getIndexOfSprite(Sprite s){
		
		if (MainActivity.SpriteList.contains(s)){
			return MainActivity.SpriteList.indexOf(s);
		}
		return 0; 
	}
	
	public static sprite3 getColliedobj(sprite3 sp){
		Sprite spr = new Sprite(sp.sprite1.getX() , sp.sprite1.getY(), MainActivity.Letter1TextureReason, MainActivity.vobm);
		Sprite spr2 = new Sprite(sp.sprite1.getX() , sp.sprite1.getY(), MainActivity.Letter1TextureReason, MainActivity.vobm);
		//MainActivity.mCurrentScene.attachChild(spr);
		spr.setVisible(false);
		spr.setHeight(sp.sprite1.getHeight());
		spr.setWidth(sp.sprite1.getWidth() + 20);
		
		spr2.setVisible(false);
		spr2.setHeight(sp.sprite1.getHeight());
		spr2.setWidth(sp.sprite1.getWidth() + 20 );
	    for(int i = 0;  i< SpriteContainer1.size();i++)
	    {
	    	spr2.setPosition(SpriteContainer1.get(i).sprite1.getX(), SpriteContainer1.get(i).sprite1.getY());
	    	//Log.d("chk colution ", "Size " + SpriteList.size() +"array list : " + SpriteList.get(i).sprite1.getUserData());	
	    	try {
				
	       if(spr2.collidesWith(spr) && !(SpriteContainer1.get(i).sprite1).equals(sp.sprite1) && (!(SpriteContainer.contains(SpriteContainer1.get(i))) || sp.single)){
	    	
	    	  // Log.d("chk colution ", "input sprite: " + sp.getUserData() +" array list sprite : " + SpriteList.get(i).sprite1.getUserData());
	    	   float y1,y2,x1,x2,w1,w2,h1,h2; 
	    	   y2 = SpriteContainer1.get(i).sprite1.getY();
	    	   x2 = SpriteContainer1.get(i).sprite1.getX();
	    	   w2 = SpriteContainer1.get(i).sprite1.getWidth();
	    	   h2 = SpriteContainer1.get(i).sprite1.getHeight();
	    	   y1 = sp.sprite1.getY();
	    	   x1 = sp.sprite1.getX();
	    	   w1 = sp.sprite1.getWidth();
	    	   h1 = sp.sprite1.getHeight();
	    	   
	    	   if((x2+w2 >= x1-10 && (x2+w2 <= x1+10)) || (x1+w1 >= x2 - 10 && x1+w1 <= x2 + 10)){
	    		  // if(){
	    			   return SpriteContainer1.get(i); 
	    		  // }
	    	   }
	    	   
	    	  /* if(((x1+w1)>x2 || x1<(w2+x2)) && ((y1+h1)>y2 || y2>(h1+y1))){
		    	   if(Math.abs(y1-y2) < 10 && Math.abs(y1-y2) >= -1) {
		    		   Log.d("chk colution ", "Y1-Y2 : " + Math.abs(y1-y2));
		    		   return SpriteContainer1.get(i);
		    	   }		    	  
	    	   }*/
    		   //return SpriteContainer1.get(i);
	        }
	    	} catch (Exception e) {
				// TODO: handle exception
	    		Log.d("chk colution ", "e : " + e.getMessage());
			}
	      /* else if(SpriteContainer1.get(i).sprite1.collidesWith(sp) && !(SpriteContainer1.get(i).sprite1).equals(sp))
	       	{
	    	  // Log.d("chk colution ", "input sprite: " + sp.getUserData() +" array list sprite : " + SpriteList.get(i).sprite1.getUserData());
	    	   return SpriteContainer1.get(i);
	        }*/
	     }
	   // sp.setWidth(sp.getWidth()+20);
		return null;
	}
	public static sprite2 getColliedSprite(Sprite sp){
	    for(int i = 0;  i< SpriteList.size();i++)
	    {
	    	//Log.d("chk colution ", "Size " + SpriteList.size() +"array list : " + SpriteList.get(i).sprite1.getUserData());	    	
	       if(SpriteList.get(i).sprite1.collidesWith(sp) && !(SpriteList.get(i).sprite1).equals(sp))
	       	{
	    	  // Log.d("chk colution ", "input sprite: " + sp.getUserData() +" array list sprite : " + SpriteList.get(i).sprite1.getUserData());
    		   return SpriteList.get(i);
	        }
	       else if(SpriteList.get(i).sprite1.collidesWith(sp) && !(SpriteList.get(i).sprite1).equals(sp))
	       	{
	    	  // Log.d("chk colution ", "input sprite: " + sp.getUserData() +" array list sprite : " + SpriteList.get(i).sprite1.getUserData());
	    	   return SpriteList.get(i);
	        }
	     }

		return null;
	}
	public static void sortSpriteContainer(){
		sprite3 s3;
		for(int i=0;i<SpriteContainer.size();i++){
			for(int j=0;j<SpriteContainer.size()-1;j++){
				if(SpriteContainer.get(j).sprite1.getX()>SpriteContainer.get(j+1).sprite1.getX()){
					s3 = SpriteContainer.get(j);
					SpriteContainer.set(j, SpriteContainer.get(j+1));
					SpriteContainer.set(j+1,s3);				
				}
			}
		}
		rePosition();
	}
	public static void rePosition(){
		for(int i=1;i<SpriteContainer.size();i++){
			SpriteContainer.get(i).sprite1.setPosition(SpriteContainer.get(i-1).sprite1.getX()+SpriteContainer.get(i-1).sprite1.getWidth(),SpriteContainer.get(i-1).sprite1.getY());
		}
	}
	
	public static void makeGroup(sprite2 s1){
		mCurrentScene.detachChild(s1.sprite1);
		spg.sprite1.attachChild(s1.sprite1);
		s1.frizz = true;
		//if(spg.sprite1.getChildCount() !=0 ){
			s1.sprite1.setPosition(spg.sprite1.getChildCount()*100, spg.sprite1.getChildCount()*100);
			spg.setWidth(spg.sprite1.getChildCount()*100);
		//}
		s1.sprite1.setPosition(0f, 0f);
		
	}
	public static void reposition(){
		for(int i=0; i < spg.sprite1.getChildCount(); i++ ){
			spg.getChildByIndex(i).setPosition(2*100, 0);
			spg.setWidth(spg.sprite1.getChildCount()*100);
		}
		
	}
	public static boolean allowJoin (Sprite mo, Sprite akar){
		if (mo.getX() - akar.getX() > 105 && mo.getX() - akar.getX() < 180 && mo.getY() - akar.getY() < 25 && mo.getY() - akar.getY() > -25)
		{
			return true;
		}
		else if (akar.getX() - mo.getX() > 105 && akar.getX() - mo.getX() < 180 && akar.getY() - mo.getY() < 25 && akar.getY() - mo.getY() > -25) 
		{
			return true;
		}
		return false;
		
	}
	public void loadHomeButton(){
		buttonHome = new Sprite(10, 10, ButtonHomeTextureReason,vobm){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				// Log.d("TitledImage", "Before ");
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN: {
					
						finish();
						startActivity(new Intent(getBaseContext(), GameMainPage.class));
					
						break;
					}
					case TouchEvent.ACTION_MOVE: {
						
						break;
					}
					case TouchEvent.ACTION_UP: {
						MainActivity.mCurrentScene.detachChild(buttonHome);
						break;
					}
					default: {
		
					}
				}
				return true;
			}
		};
		buttonHome.setWidth(70f);
		buttonHome.setHeight(70f);
		mCurrentScene.registerTouchArea(buttonHome);
		mCurrentScene.attachChild(buttonHome);
	}
	
	
	public static void updatePos(Spriteobject s, int x, int y) {
	    s.updatePosition(x, y);
	}
	public static BaseActivity getSharedInstance() {
	    return instance;
	}
	 
	// to change the current main scene
	public void setCurrentScene(Scene scene) {
	    mCurrentScene = scene;
	    getEngine().setScene(mCurrentScene);
	}
	 

}
