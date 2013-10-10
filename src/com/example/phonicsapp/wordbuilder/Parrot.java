package com.example.phonicsapp.wordbuilder;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.IModifier;

import android.os.Handler;

public class Parrot extends AnimatedSprite{

	AnimatedSprite anm1; 
	Handler handler;
	int timeRemaining = 30;
	
	public Parrot(float pX, float pY, float pWidth, float pHeight,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pWidth, pHeight, pTiledTextureRegion, pVertexBufferObjectManager);
		// TODO Auto-generated constructor stub
		
		anm1 = new AnimatedSprite(pX, pY, pTiledTextureRegion, this.getVertexBufferObjectManager()){
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				// Log.d("TitledImage", "Before ");
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN: {
					//sprite3.playAudio(R.raw.parrot_helpbuildingword);
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
		MainActivity.mCurrentScene.registerTouchArea(anm1);
		anm1.setWidth(pWidth);
		anm1.setHeight(pHeight);
		anm1.setFlippedHorizontal(true);
	}
	public void normalState(){
		anm1.animate(new long[]{900, 0,0}, 0, 2, true);
	}
	public void uPState(){
		anm1.animate(new long[]{0,900,0 }, 0, 2, true);
		DelayModifier dm = new DelayModifier(3,new IEntityModifierListener() {
			
			@Override
			public void onModifierStarted(IModifier<IEntity> arg0,
					IEntity arg1) {
				
			}

			@Override
			public void onModifierFinished(IModifier<IEntity> arg0,
						IEntity arg1) {
				normalState();
				}
		});
		anm1.registerEntityModifier(dm);
	}
	public void downState(){
		anm1.animate(new long[]{0,0,900 }, 0, 2, true);
DelayModifier dm = new DelayModifier(2,new IEntityModifierListener() {
			
			@Override
			public void onModifierStarted(IModifier<IEntity> arg0,
					IEntity arg1) {
				
			}

			@Override
			public void onModifierFinished(IModifier<IEntity> arg0,
						IEntity arg1) {
				normalState();
				}
		});
		anm1.registerEntityModifier(dm);
	}
}
