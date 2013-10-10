package com.example.phonicsapp.wordbuilder;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;

public class sizzer extends Sprite {

	Sprite sprite1;
	
	public sizzer(float pX, float pY, float pWidth, float pHeight,
			ITextureRegion pTextureRegion,VertexBufferObjectManager pSpriteVertexBufferObject, final int a) {
		super(pX, pY, pWidth, pHeight, pTextureRegion,pSpriteVertexBufferObject);
	
	sprite1 = new Sprite(pX, pY, pTextureRegion, pSpriteVertexBufferObject) {
		@Override
		public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
				final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
			// Log.d("TitledImage", "Before ");
			switch (pSceneTouchEvent.getAction()) {
			case TouchEvent.ACTION_DOWN: {
				
					break;
				}
				case TouchEvent.ACTION_MOVE: {
					sprite1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
					break;
				}
				case TouchEvent.ACTION_UP: {
					sprite1.setPosition((MainActivity.CAMERA_WIDTH)-150,(MainActivity.CAMERA_HEIGHT) -150);
					break;
				}
				default: {
	
				}
			}
			return true;
		}
	};
	MainActivity.mCurrentScene.registerTouchArea(sprite1);
	sprite1.setHeight(pHeight);
	sprite1.setWidth(pWidth);
	sprite1.setZIndex(3);
	}
}
