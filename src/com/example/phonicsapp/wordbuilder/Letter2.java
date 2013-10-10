package com.example.phonicsapp.wordbuilder;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import com.example.phonicsapp.R;


public class Letter2 extends Sprite 
{
	public static int letter2Count;

	//mo letter
	public Letter2(float pX, float pY, ITextureRegion pTextureRegion, VertexBufferObjectManager vertexBufferObjectManager)
	{
		super(pX, pY, pTextureRegion, vertexBufferObjectManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	{
		switch (pSceneTouchEvent.getAction()) 
		{
		//On touch, enabling the merge
		case TouchEvent.ACTION_DOWN:
			
			Debug.d("pScene:"+pSceneTouchEvent.getX());
			Debug.d("mo.x:"+MainActivity.mo.getX());
			
			//for 'akar' and 'mo'
			if(MainActivity.mergeEnable1==true)
			{
				//'akar - mo' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudioLoop2(R.raw.akar ,R.raw.mo);
			}
			else if(MainActivity.mergeEnable2==true)
			{
				//'ma' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudio(R.raw.ma);
			}
			else if(MainActivity.mergeEnable3==true)
			{
				//'aam' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudio(R.raw.aam);
			}
			else if(MainActivity.mergeEnable4==true)
			{
				//'mo - shorea' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudioLoop2(R.raw.mo, R.raw.shorea);
			}
			else if(MainActivity.mergeEnable5==true)
			{
				if(pSceneTouchEvent.getX() - MainActivity.mo.getX()<100 || MainActivity.mo.getX() - pSceneTouchEvent.getX()<100)
				{
					soundFunction.audioPlay = true;
					soundFunction.playAudio(R.raw.mo);
				}
				else
				{
					//'shorea - akar' Sound
					soundFunction.audioPlay = true;
					soundFunction.playAudioLoop2(R.raw.shorea, R.raw.akar);
				}
			}
			else if(MainActivity.mergeEnable6==true)
			{
				if(pSceneTouchEvent.getX() - MainActivity.mo.getX()<100 || MainActivity.mo.getX() - pSceneTouchEvent.getX()<100)
				{
					soundFunction.audioPlay = true;
					soundFunction.playAudio(R.raw.mo);
				}
				else
				{
					//'akar - shorea' Sound
					soundFunction.audioPlay = true;
					soundFunction.playAudioLoop2(R.raw.akar, R.raw.shorea);
				}
			}
			else if(MainActivity.mergeEnable7==true)
			{
				//'akar - shorea - mo' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudioLoop3(R.raw.shorea, R.raw.akar, R.raw.mo);
			}
			else if(MainActivity.mergeEnable8==true)
			{
				//'akar - shorea - mo' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudioLoop3(R.raw.akar, R.raw.shorea, R.raw.mo);
			}
			else if(MainActivity.mergeEnable9==true)
			{
				//'shorea - mo - akar' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudioLoop3(R.raw.shorea, R.raw.mo, R.raw.akar);
			}
			else if(MainActivity.mergeEnable10==true)
			{
				//'mo - akar - shorea' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudioLoop3(R.raw.mo, R.raw.akar, R.raw.shorea);
			}
			else if(MainActivity.mergeEnable11==true)
			{
				//'mo - shorea - akar' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudioLoop3(R.raw.mo, R.raw.shorea, R.raw.akar);
			}
			else if(MainActivity.mergeEnable12==true)
			{
				//'akar - mo - shorea' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudioLoop3(R.raw.akar, R.raw.mo, R.raw.shorea);
			}
			else
			{
				//'mo' Sound
				soundFunction.audioPlay = true;
				soundFunction.playAudio(R.raw.mo);
			}
			
			break;
			
		//On release stopping the merge
		case TouchEvent.ACTION_UP:
				
			break;
		
		//On Move, making it Drag
		case TouchEvent.ACTION_MOVE:
			
			//for 'akar' and 'mo'
			if(MainActivity.mergeEnable1==true)
			{
				Paths.setPosition(this, Paths.ax1, MainActivity.akar, pSceneTouchEvent);
			}
			//for 'mo' and 'akar'
			else if(MainActivity.mergeEnable2 == true)
			{
				Paths.setPosition(this, Paths.ax2, MainActivity.akar, pSceneTouchEvent);
			}
			//for 'shorea' and 'mo'
			else if(MainActivity.mergeEnable3==true)
			{
				Paths.setPosition(this, Paths.ax1, MainActivity.shorea, pSceneTouchEvent);
			}
			//for 'mo' and 'shorea'
			else if(MainActivity.mergeEnable4==true)
			{
				Paths.setPosition(this, Paths.ax2, MainActivity.shorea, pSceneTouchEvent);
			}
			//for 'shorea' and 'akar'
			else if(MainActivity.mergeEnable7 == true)
			{
				this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.akar.setPosition(pSceneTouchEvent.getX()-100 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.shorea.setPosition(pSceneTouchEvent.getX()-200 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
			}
			else if(MainActivity.mergeEnable8 == true)
			{
				this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.akar.setPosition(pSceneTouchEvent.getX()-200 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.shorea.setPosition(pSceneTouchEvent.getX()-100 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
			}
			else if(MainActivity.mergeEnable9 == true)
			{
				this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.akar.setPosition(pSceneTouchEvent.getX()+100 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.shorea.setPosition(pSceneTouchEvent.getX()-100 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
			}
			else if(MainActivity.mergeEnable10 == true)
			{
				this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.akar.setPosition(pSceneTouchEvent.getX()+100 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.shorea.setPosition(pSceneTouchEvent.getX()+200 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
			}
			else if(MainActivity.mergeEnable11 == true)
			{
				this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.akar.setPosition(pSceneTouchEvent.getX()+200 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.shorea.setPosition(pSceneTouchEvent.getX()+100 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
			}
			else if(MainActivity.mergeEnable12 == true)
			{
				this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.akar.setPosition(pSceneTouchEvent.getX()-100 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
				
				MainActivity.shorea.setPosition(pSceneTouchEvent.getX()+100 - this.getWidth() / 2, 
						pSceneTouchEvent.getY() - this.getHeight() / 2);
			}
			else
			{
				this.setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, 
				pSceneTouchEvent.getY() - this.getHeight() / 2);
			}
			break;
		}

		return true;
	}
}
