 package com.example.phonicsapp.wordbuilder;

import java.util.ArrayList;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.IModifier;

import com.example.phonicsapp.R;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.Log;

public class sprite3 extends Sprite implements OnCompletionListener {

	Sprite sprite1;
	sprite3 s3,collution,left,right;
	boolean single=true;
	boolean sizzer=false;
	float px=5000f,py=5000f;
	int voice,currentTrack=0;
	static Context con ;
	MediaPlayer mediaPlayer = new MediaPlayer();
	static MediaPlayer mediaPlayer1 = new MediaPlayer();
	int audioIndex;
	
	//boolean isActiveMove = true;
	float delay = 0.2f;
	int[] tracks = new int[3];
	

	public sprite3(float pX, float pY, float pWidth, float pHeight,ITextureRegion pTextureRegion,
			VertexBufferObjectManager pSpriteVertexBufferObject, final int a, int audio,Context cont) {
		super(pX, pY, pWidth, pHeight, pTextureRegion,pSpriteVertexBufferObject);
		audioIndex = MainActivity.audioIndexCounter;
		MainActivity.audioIndexCounter++;
		sprite1 = new Sprite(pX, pY, pTextureRegion, pSpriteVertexBufferObject) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				// Log.d("TitledImage", "Before ");
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN: {
					px= pSceneTouchEvent.getX();
					py = pSceneTouchEvent.getY();
					
					sprite1.setZIndex(30000);
					MainActivity.mCurrentScene.sortChildren();
					
					if(single){
						playAudio(voice);
					}
					else{
						tellWord();
					}
					break;
				}
				case TouchEvent.ACTION_MOVE: {
					if(s3.sizzer == false && MainActivity.isMove){
					 if(s3.single){
						//sprite1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
						 
						if(px ==5000 && py == 5000 ){
							px= pSceneTouchEvent.getX();
							py = pSceneTouchEvent.getY();
						}
						sprite1.setPosition((sprite1.getX()+(pSceneTouchEvent.getX()-px)),(sprite1.getY() + (pSceneTouchEvent.getY()-py)));
						px= pSceneTouchEvent.getX();
						py = pSceneTouchEvent.getY();
						
						Log.d("POSITION " + sprite1.getUserData(), " X " + sprite1.getX() +" Y  : " + sprite1.getY());
						collution = MainActivity.getColliedobj(s3);
					//	Log.d("Sprite3", "Collution " + collution);
						if(collution != null && MainActivity.allowJoin(sprite1, collution.sprite1)){
							smooth_join(s3,collution);
							
							collution.single = false;
							s3.single = false;
							LeftRight(s3, collution);
							if(!MainActivity.SpriteContainer.contains(s3)){
								MainActivity.SpriteContainer.add(s3);
							}
							if(!MainActivity.SpriteContainer.contains(collution)){
								MainActivity.SpriteContainer.add(collution);
							}
							
							//Log.d("Tauch move after ", "A: " + s3.sprite1.getX() + " B: " + collution.sprite1.getX());
							//s3.sprite1.setPosition(s3.sprite1.getX() - 20, s3.sprite1.getY());
							//collution.sprite1.setPosition(collution.sprite1.getX() - 20, collution.sprite1.getY());
							MainActivity.sortSpriteContainer();
							tellWord();
						}
					}
					else if(!s3.single && MainActivity.isMove){
						// joint obj
						float px = sprite1.getX(),py = sprite1.getY();					
						//Log.d("Sprite3", " X: " +px + " Y: "+ py);
						sprite1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
						
						float nx = sprite1.getX() - px,ny = sprite1.getY() - py;
						for(int i = 0;i< MainActivity.SpriteContainer.size();i++){
							if(!(MainActivity.SpriteContainer.get(i).sprite1.equals(sprite1))){
								Log.d("Sprite3", "Joint "+ MainActivity.SpriteContainer.get(i).sprite1.getUserData()+" X: " + MainActivity.SpriteContainer.get(i).sprite1.getX() + " Y: "+ MainActivity.SpriteContainer.get(i).sprite1.getY());
								MainActivity.SpriteContainer.get(i).sprite1.setPosition(MainActivity.SpriteContainer.get(i).sprite1.getX() + nx  ,	MainActivity.SpriteContainer.get(i).sprite1.getY() + ny );
							
								collution = MainActivity.getColliedobj(MainActivity.SpriteContainer.get(i));
								//	Log.d("Sprite3", "Collution " + collution);
									if(collution != null && MainActivity.allowJoin(MainActivity.SpriteContainer.get(i).sprite1, collution.sprite1)){
										smooth_join(MainActivity.SpriteContainer.get(i),collution);
										
										collution.single = false;
										LeftRight(s3, collution);
										/*if(!MainActivity.SpriteContainer.contains(s3)){
											MainActivity.SpriteContainer.add(s3);
										}*/
										if(!MainActivity.SpriteContainer.contains(collution)){
											MainActivity.SpriteContainer.add(collution);
										}
										MainActivity.sortSpriteContainer();
									}
							}
						}
					}
				}
					else{
						if(s3.sizzer == true){
							sprite1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
							sizzer(sprite1);
						}
					}
					
					break;
				}
				case TouchEvent.ACTION_UP: {
					//if(s3.sizzer == true){
						MoveModifier mf = new MoveModifier(0.2f, MainActivity.sp3d.sprite1.getX(), MainActivity.CAMERA_WIDTH-150f, MainActivity.sp3d.sprite1.getY(), MainActivity.CAMERA_HEIGHT -150);
						MainActivity.sp3d.sprite1.registerEntityModifier(mf);
						//sprite1.setPosition((MainActivity.CAMERA_WIDTH)-150,(MainActivity.CAMERA_HEIGHT) -150);
					//}
						if(s3.sizzer == true){
							sprite1.setZIndex(300);
						} else {
							sprite1.setZIndex(3);
						}
					
					MainActivity.mCurrentScene.sortChildren();

					break;
				}
				default: {

				}
				}
				return true	 ;
			}
		};
		MainActivity.mCurrentScene.registerTouchArea(sprite1);
		voice = audio;
		con = cont;
		//sprite1.setAlpha(0.5f);
		sprite1.setHeight(pHeight);
		sprite1.setWidth(pWidth);
		//sprite1.setZIndex(1);
	}
	void sizzer(Sprite sp){
		ArrayList<sprite3> sizerTouched = new ArrayList<sprite3>();
		//MainActivity.sortSpriteContainer();
		for(int i = 0;  i< MainActivity.SpriteContainer.size();i++)
	    {
//	    	//Log.d("chk colution ", "Size " + SpriteList.size() +"array list : " + SpriteList.get(i).sprite1.getUserData());	    	
	       if(MainActivity.SpriteContainer.get(i).sprite1.collidesWith(sp) && !(MainActivity.SpriteContainer.get(i).sprite1).equals(sp))
	       	{
	    	   sizerTouched.add(MainActivity.SpriteContainer.get(i));
	    	   Log.d("chk colution ", "Sizzer: " + sp.getUserData() +" array list sprite : " + MainActivity.SpriteContainer.get(i).sprite1.getUserData());
	        }
	       else if(MainActivity.SpriteContainer.get(i).sprite1.collidesWith(sp) && !(MainActivity.SpriteContainer.get(i).sprite1).equals(sp))
	       	{
	    	   sizerTouched.add(MainActivity.SpriteContainer.get(i));
	        }
	     }
		
		if(sizerTouched.size()==2){
			/*sprite1.setPosition((MainActivity.CAMERA_WIDTH)-150,(MainActivity.CAMERA_HEIGHT) -150);*/
			MoveModifier mf = new MoveModifier(0.5f, sprite1.getX(), MainActivity.CAMERA_WIDTH-150f, sprite1.getY(), MainActivity.CAMERA_HEIGHT -150);
			sprite1.registerEntityModifier(mf);
			
			int index1 = MainActivity.SpriteContainer.indexOf(sizerTouched.get(0));
			int index2 = MainActivity.SpriteContainer.indexOf(sizerTouched.get(1));
			
			if(index1 >=0 && index2>=0){
				smooth_split(MainActivity.SpriteContainer.get(index1),(MainActivity.SpriteContainer.get(index2)));
			}
		}
	}
	
	void smooth_join(sprite3 s1, sprite3 s2){
		Log.d("chk anim ", "X " + s1.sprite1.getX() + " Y: " + s1.sprite1.getY()+" || S2  X " + s2.sprite1.getX() + " Y: " + s2.sprite1.getY());
		MoveModifier mf = new MoveModifier(0.5f, s1.sprite1.getX(),s2.sprite1.getX(),s1.sprite1.getY(),s1.sprite1.getY());	
		
		DelayModifier dm5 = new DelayModifier(delay,new IEntityModifierListener() {
		
			@Override
			public void onModifierStarted(IModifier<IEntity> arg0,
					IEntity arg1) {
				MainActivity.isMove = false;
			}

			@Override
			public void onModifierFinished(IModifier<IEntity> arg0,
						IEntity arg1) {
				MainActivity.isMove = true;
				}
		});
		//SequenceEntityModifier sqf = new SequenceEntityModifier(mf,dm5);
		if(s1.sprite1.getX()<s2.sprite1.getX()){
		//sqf.reset();
		//s1.registerEntityModifier(mf);
			
			if(MainActivity.SpriteContainer.contains(s1)){
				//MainActivity.SpriteContainer.get(1).sprite1.setPosition(MainActivity.SpriteContainer.get(1).sprite1.getX()-10, MainActivity.SpriteContainer.get(0).sprite1.getY());
				s2.sprite1.setPosition(s2.sprite1.getX()-10, s1.sprite1.getY());
			}
			else{
				s1.sprite1.setPosition(s1.sprite1.getX()+10, s2.sprite1.getY());
			}
			
		}
		else{
			
			if(MainActivity.SpriteContainer.contains(s1)){
				s2.sprite1.setPosition(s2.sprite1.getX()+10, s1.sprite1.getY());
			}
			else{
				s1.sprite1.setPosition(s1.sprite1.getX()-10, s2.sprite1.getY());
			}
		}
		
	}
	void smooth_split(sprite3 s1, sprite3 s2){
		
		for(int i = MainActivity.SpriteContainer.indexOf(s2);i<MainActivity.SpriteContainer.size();i++){
			MoveXModifier mMfs1 = new MoveXModifier(.3f, MainActivity.SpriteContainer.get(i).sprite1.getX(), MainActivity.SpriteContainer.get(i).sprite1.getX()+15);
			MainActivity.SpriteContainer.get(i).sprite1.registerEntityModifier(mMfs1);
		}
		for(int i= 0;i <=MainActivity.SpriteContainer.indexOf(s1);i++){
			MoveXModifier mMfs1 = new MoveXModifier(.3f, MainActivity.SpriteContainer.get(i).sprite1.getX(), MainActivity.SpriteContainer.get(i).sprite1.getX() - 15);
			MainActivity.SpriteContainer.get(i).sprite1.registerEntityModifier(mMfs1);
		}
		//MainActivity.SpriteContainer.size(); 
		if(MainActivity.SpriteContainer.indexOf(s1) ==0 || MainActivity.SpriteContainer.indexOf(s1) ==MainActivity.SpriteContainer.size()-1){
			s1.single = true;
			MainActivity.SpriteContainer.remove(s1);
		}
		else //(MainActivity.SpriteContainer.indexOf(s2) ==0 || MainActivity.SpriteContainer.indexOf(s2) ==MainActivity.SpriteContainer.size()-1)
			{
			s2.single = true;
			MainActivity.SpriteContainer.remove(s2);
		}
		
		
		if(MainActivity.SpriteContainer.size()==1){ 
			MainActivity.SpriteContainer.get(0).single=true;
			MainActivity.SpriteContainer.clear();
		}
	}
	
	boolean LeftRight (sprite3 s1, sprite3 s2){
		
		if(s1.sprite1.getX()<s2.sprite1.getX()){
			s2.left = s1;
			s1.right = s2;
			Log.d("SPRITE3 ", "LeftRight:In S1<S2  S1.X "+ s1.sprite1.getX() + "S2.X : " + s2.sprite1.getX());
		}
		else if(s1.sprite1.getX()>s2.sprite1.getX()){
			s1.left = s2;
			s2.right = s1;
			Log.d("SPRITE3 ", "LeftRight: In S1>S2 S1.X "+ s1.sprite1.getX() + "S2.X : " + s2.sprite1.getX());
		}
		return false;
	}
	boolean isRight (sprite3 thisSprite, sprite3 colliedSprite){
		
		if(thisSprite.sprite1.getX()>colliedSprite.sprite1.getX()){
			
			Log.d("SPRITE3 ", "LeftRight:In S1<S2  S1.X "+ thisSprite.sprite1.getX() + "S2.X : " + colliedSprite.sprite1.getX());
			return true;
		}
		
		return false;
	}
	
void tellWord(){
	DelayModifier dm1 = new DelayModifier(4,new IEntityModifierListener() {
		
		@Override
		public void onModifierStarted(IModifier<IEntity> arg0,
				IEntity arg1) {
			
		}
		@Override
		public void onModifierFinished(IModifier<IEntity> arg0,
					IEntity arg1) {
			 MainActivity.mCurrentScene.detachChild(MainActivity.c1.sprite1);
			 MainActivity.mCurrentScene.attachChild(MainActivity.cAmm.sprite1);
			 MainActivity.c1.sprite1.reset();
			 MainActivity.mCurrentScene.sortChildren();
			 MainActivity.c1.sprite1.setZIndex(-10000);
			 //MainActivity.loadHomeButton();
			 MainActivity.isAmm=true;
			}
	});
	DelayModifier dm2 = new DelayModifier(4,new IEntityModifierListener() {
		
		@Override
		public void onModifierStarted(IModifier<IEntity> arg0,
				IEntity arg1) {
			
		}

		@Override
		public void onModifierFinished(IModifier<IEntity> arg0,
					IEntity arg1) {
			MainActivity.mCurrentScene.detachChild(MainActivity.cAmm.sprite1);
			MainActivity.mCurrentScene.attachChild(MainActivity.c1.sprite1);
			//MainActivity.loadHomeButton();
			}
	});
	boolean chk = false;
	if(MainActivity.SpriteContainer.size()==2){
		if(MainActivity.SpriteContainer.get(0).equals(MainActivity.sp3c) && MainActivity.SpriteContainer.get(1).equals(MainActivity.sp3a) ){
			playAudio(R.raw.ma1);
			MainActivity.anm1.uPState();
			if(MainActivity.isMaa ){
				/*if(MainActivity.isAmm){
					MainActivity.anm1.uPState();
				}else{
					MainActivity.anm1.downState();
				}*/
				MainActivity.isMaa = false;
				if(MainActivity.ma_amm_secuenceCount == 0){ 	
					MainActivity.anm1.uPState();
					MainActivity.ma_amm_secuenceCount ++;
					MainActivity.c1.sprite1.registerEntityModifier(dm1);
					MainActivity.cAmm.sprite1.unregisterEntityModifier(dm2); 
				}
			}
			chk = true; 
		}
		else if(MainActivity.SpriteContainer.get(0).equals(MainActivity.sp3b) && MainActivity.SpriteContainer.get(1).equals(MainActivity.sp3c)){
			playAudio(R.raw.aam);
			MainActivity.anm1.uPState();
			/*if(!MainActivity.isMaa){//if maa
				MainActivity.anm1.downState(); 
			}
			else if(!MainActivity.isAmm){
				MainActivity.anm1.downState();
			}
			else{
				MainActivity.anm1.uPState();
			}*/
			chk = true;
			/*if(MainActivity.ma_amm_secuenceCount == 1 && !MainActivity.isMaa){
				MainActivity.isMaa = true;
				MainActivity.ma_amm_secuenceCount ++;
				MainActivity.cAmm.sprite1.registerEntityModifier(dm2);
				MainActivity.c1.sprite1.unregisterEntityModifier(dm1);
			}*/
			 
		}
		else{
 			multipleAudio();
 			MainActivity.anm1.downState();
		}
	}
	/*else if(!chk){
		for(int i=0;i< MainActivity.SpriteContainer.size();i++){
			
		}
	}*/
	else if(MainActivity.SpriteContainer.size()>2){
		multipleAudio();
		MainActivity.anm1.downState();
	}
}
  static void playAudio(int val) {
	
	if(/*mediaPlayer.isPlaying() == false &&*/ val !=0){
		mediaPlayer1.reset();
	mediaPlayer1 = MediaPlayer.create(con,val);
		try {				
			mediaPlayer1.start();
			mediaPlayer1.setLooping(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 void multipleAudio(){
	 try {
		
	      for(int i=0;i< MainActivity.SpriteContainer.size();i++){
	    	  tracks[i]= MainActivity.tracksContainer[MainActivity.SpriteContainer.get(i).audioIndex]; 
	      }
	      mediaPlayer = MediaPlayer.create(con, tracks[0]);
	      mediaPlayer.setOnCompletionListener(this);
	      currentTrack=0;
	      mediaPlayer.start();
	 } catch (Exception e) {
			// TODO: handle exception
		}
	}
 
@Override
public void onCompletion(MediaPlayer mp) {
	try{
	mp.release();
    if (currentTrack < MainActivity.SpriteContainer.size()-1) {
      currentTrack++;
      mp = MediaPlayer.create(con, tracks[currentTrack]);
      mp.setOnCompletionListener(this);
      mp.start();
    }
	}catch(Exception e){
		
	}
}
	
}
