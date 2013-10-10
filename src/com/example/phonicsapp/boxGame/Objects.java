package com.example.phonicsapp.boxGame;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import com.example.phonicsapp.R;
import com.example.phonicsapp.R.raw;

public class Objects extends Sprite
{

	public static boolean touchFlag;
	
	int i =0;
	public Objects(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager VertexBufferObject) 
	{
		super(pX, pY, pTextureRegion, VertexBufferObject);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
			final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
	{
		switch (pSceneTouchEvent.getAction())
		{
			case TouchEvent.ACTION_DOWN:
			{
				touchFlag = true;
				break;
			}
			case TouchEvent.ACTION_MOVE: 
			{
				this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				if(pSceneTouchEvent.getX()- this.getWidth()/2 == BoxGameActivity.moi.getX() && 
						pSceneTouchEvent.getY()- this.getHeight()/2 == BoxGameActivity.moi.getY())
				{
					i++;
					if(i==1)
					{
						Functions.audioPlay = true;
						Functions.playAudio(R.raw.moi);
					}
				}
				
				else if(pSceneTouchEvent.getX()- this.getWidth()/2 == BoxGameActivity.ma.getX() && 
						pSceneTouchEvent.getY()- this.getHeight()/2 == BoxGameActivity.ma.getY())
				{
					i++;
					if(i==1)
					{
						Functions.audioPlay = true;
						Functions.playAudio(R.raw.ma);
					}
				}
				else if(pSceneTouchEvent.getX()- this.getWidth()/2 == BoxGameActivity.mula.getX() && 
						pSceneTouchEvent.getY()- this.getHeight()/2 == BoxGameActivity.mula.getY())
				{
					i++;
					if(i==1)
					{
						Functions.audioPlay = true;
						Functions.playAudio(R.raw.mula);
					}
				}
				else if(pSceneTouchEvent.getX()- this.getWidth()/2 == BoxGameActivity.megh.getX() && 
						pSceneTouchEvent.getY()- this.getHeight()/2 == BoxGameActivity.megh.getY())
				{
					i++;
					if(i==1)
					{
						Functions.audioPlay = true;
						Functions.playAudio(R.raw.megh);
					}
				}
				else if(pSceneTouchEvent.getX()- this.getWidth()/2 == BoxGameActivity.mohis.getX() && 
						pSceneTouchEvent.getY()- this.getHeight()/2 == BoxGameActivity.mohis.getY())
				{
					i++;
					if(i==1)
					{
						Functions.audioPlay = true;
						Functions.playAudio(R.raw.mohis);
					}
				}
				else if(pSceneTouchEvent.getX()- this.getWidth()/2 == BoxGameActivity.mama.getX() && 
						pSceneTouchEvent.getY()- this.getHeight()/2 == BoxGameActivity.mama.getY())
				{
					i++;
					if(i==1)
					{
						Functions.audioPlay = true;
						Functions.playAudio(R.raw.mama);
					}
				}
				else if(pSceneTouchEvent.getX()- this.getWidth()/2 == BoxGameActivity.keramBoard.getX() && 
						pSceneTouchEvent.getY()- this.getHeight()/2 == BoxGameActivity.keramBoard.getY())
				{
					i++;
					if(i==1)
					{
						Functions.audioPlay = true;
						Functions.playAudio(R.raw.keram);
					}
				}
				else if(pSceneTouchEvent.getX()- this.getWidth()/2 == BoxGameActivity.kola.getX() && 
						pSceneTouchEvent.getY()- this.getHeight()/2 == BoxGameActivity.kola.getY())
				{
					i++;
					if(i==1)
					{
						Functions.audioPlay = true;
						Functions.playAudio(R.raw.kola);
					}
				}
				
				
				break;
			}
			case TouchEvent.ACTION_UP:
			{
				i=0;
				
				touchFlag = false;
				BoxGameActivity.bCounter=0;
				
				break;
			}
		}
		return true;
	}
				
}
