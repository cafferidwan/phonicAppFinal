package com.example.phonicsapp.wordbuilder;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.example.phonicsapp.R;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class CharactorObject extends Sprite {

	Sprite sprite1;
	Context con ;
	int audio;
	MediaPlayer mediaPlayer3 = new MediaPlayer();
	
	public CharactorObject(float pX, float pY, float pWidth, float pHeight,
			ITextureRegion pTextureRegion,VertexBufferObjectManager pSpriteVertexBufferObject, int voice) {
		super(pX, pY, pWidth, pHeight, pTextureRegion,pSpriteVertexBufferObject);
		
	sprite1 = new Sprite(pX, pY, pTextureRegion, pSpriteVertexBufferObject) {
		@Override
		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
				final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
			// Log.d("TitledImage", "Before ");
			switch (pSceneTouchEvent.getAction()) {
			case TouchEvent.ACTION_DOWN: {
				if(audio !=0){
					if(MainActivity.isMaa){
						sprite3.playAudio(audio);
					}
					else{
						sprite3.playAudio(R.raw.aam1);
					}
				}
				
					break;
				}
				case TouchEvent.ACTION_MOVE: {
					
					break;
				}
				case TouchEvent.ACTION_UP: {
					
					break;
				}
				default: {
	
				}
			}
			return true;
		}
	};
	audio = voice;
	MainActivity.mCurrentScene.registerTouchArea(sprite1);
	sprite1.setHeight(pHeight);
	sprite1.setWidth(pWidth);
	}
	
	void playAudio(int val) {
		
		if(/*mediaPlayer.isPlaying() == false &&*/ val !=0){
			mediaPlayer3.reset();
		mediaPlayer3 = MediaPlayer.create(con,val);
			try {				
				mediaPlayer3.start();
				mediaPlayer3.setLooping(false);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
