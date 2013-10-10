package com.example.phonicsapp.wordbuilder;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;

public class Spriteobject extends Sprite {

	Sprite sprite1;
	IEntity EnSp = new Entity();
	Spriteobject spo,colution;
	boolean coll_chk = true;
	//int a = 1;
	
	public Spriteobject(float pX, float pY, float pWidth, float pHeight,ITextureRegion pTextureRegion,VertexBufferObjectManager pSpriteVertexBufferObject,final int a) {
		super(pX, pY, pWidth, pHeight, pTextureRegion, pSpriteVertexBufferObject);
		// TODO Auto-generated constructor stub
		
		sprite1 = new Sprite(pX, pY, pTextureRegion,getVertexBufferObjectManager()) {
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				// Log.d("TitledImage", "Before ");
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_DOWN: {
					sprite1.setScale(1.09f);					
					break;
				}
				case TouchEvent.ACTION_MOVE: {
					//Log.d("Move ", "move  X:" + pTouchAreaLocalX + " move Y: " + pTouchAreaLocalY);					
					sprite1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
					//if(en.getChildCount()>0){
					//MainActivity.en1.setPosition(pSceneTouchEvent.getX() - sprite1.getWidth() / 2,	pSceneTouchEvent.getY() - sprite1.getHeight() / 2);
					//}
						
						//Log.d("Entity ", "Is Null : " + EnSp.getFirstChild());
						/*colution =  MainActivity.getColliedSprite(spo);
						if(coll_chk){
							Log.d("Collied Letter ", "Is collied : " + colution.sprite1.getUserData());						
							int numChil = MainActivity.en1.getChildCount();
							Log.d("Collied Letter ", "Number Of Child : " + numChil);
							if(MainActivity.en1.getChildCount()!=0){
								for(int i=0;i<numChil;i++){
									Log.d("Collied Letter ", "Inside for");
									if(!(MainActivity.en1.getChildByIndex(i) == sprite1)){
//										MainActivity.mCurrentScene.detachChild(sprite1);
//										MainActivity.en1.attachChild(sprite1);
										Log.d("Collied Letter ", "Inside if");
									}
								}
							}
							else{
//								MainActivity.mCurrentScene.detachChild(sprite1);
//								MainActivity.en1.attachChild(sprite1);
								Log.d("Collied Letter ", "Inside else");
							}
							//coll_chk = false;
						}
						*/
						
					break;
				}
				case TouchEvent.ACTION_UP: {
					sprite1.setScale(1.0f);
					break;
				}
				default: {

				}
				}
				return true;
			}
		};
		sprite1.setHeight(pHeight);
		sprite1.setWidth(pWidth);
		
	}
	void updatePosition(int x, int y){
		sprite1.setPosition(x, y);
	}

}
