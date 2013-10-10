package com.example.phonicsapp.wordbuilder;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.color.Color;

import android.util.Log;

public class GroupSprite extends Rectangle{

	public static Rectangle myRectangle;
	
	static String TAG ="Group Sprite";
	/**
	 * @param myRectangle
	 */
	public GroupSprite(float pX, float pY, float pWidth, float pHeight,
			VertexBufferObjectManager pSpriteVertexBufferObject) {
		super(pX, pY, pWidth, pHeight,pSpriteVertexBufferObject);
		myRectangle = new Rectangle(pX, pY, pWidth, pHeight,pSpriteVertexBufferObject) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN: {
					break;
				}
				case TouchEvent.ACTION_MOVE: {
					myRectangle.setPosition(pSceneTouchEvent.getX()- myRectangle.getWidth() / 2,pSceneTouchEvent.getY() - myRectangle.getHeight()/ 2);
					break;
				}
				case TouchEvent.ACTION_UP: {
					for(int i = 0;i< this.getChildCount();i++){
						Log.d(TAG, "Sprite: X " + this.getChildByIndex(i).getX() + "Y: " + this.getChildByIndex(i).getY());
					}
					break;
				}
				default: {

				}
				}
				return true;
			}
		};
		myRectangle.setColor(Color.BLUE);
		
	}
}
