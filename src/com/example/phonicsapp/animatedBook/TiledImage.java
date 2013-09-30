package com.example.phonicsapp.animatedBook;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.FadeInModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.IModifier;

import com.example.phonicsapp.R;
import android.content.Context;
import android.media.MediaPlayer;

public class TiledImage extends Sprite
{
	
	Sprite Letter,s;
	IEntity en ;
	static boolean audioPlay= false;
	static int ObjNo=1, audio, audioPlayCount=0;
	static float APPEARING_TIME=3f;
	static MediaPlayer mediaPlayer;
	static Context con;
	
	public TiledImage(float pX, float pY, float pWidth, float pHeight,ITextureRegion pTextureRegion,VertexBufferObjectManager vertexBufferObjectManager, int voice, Context cont) 
	{
		super(pX, pY, pWidth, pHeight, pTextureRegion, vertexBufferObjectManager);
		con=cont;
		ObjNo++;
		audioPlayCount=0;
		audio = voice;
		audioPlay = false;
		mediaPlayer= new MediaPlayer();
		this.Letter = new Sprite(pX, pY, pTextureRegion, vertexBufferObjectManager) 
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY)
			{
				switch (pSceneTouchEvent.getAction()) 
				{
					case TouchEvent.ACTION_DOWN:
					{
						this.setScale(1.09f);	
						break;
					}
					case TouchEvent.ACTION_MOVE:
					{
						break;
					}
					case TouchEvent.ACTION_UP:
					{
						this.setScale(1.0f);	
						audioPlay = true;
						playAudio(audio);
						break;
					}
					default:
					{
	
					}
				}
				return false;
			}
		};
		en = new Entity(0,0);
		s = new Sprite(0,0, AnimatedBookActivity.SpriteBgTextureReason, vertexBufferObjectManager);
		Letter.setWidth(pHeight);
		Letter.setHeight(pHeight);		
		s.setWidth(pHeight);
		s.setHeight(pHeight);
		s.setZIndex(-1);
		s.setAlpha(0.8f);
		Letter.attachChild(s);
		
		s.setVisible(false);
		Letter.setVisible(false);	
		
		AnimateImage();
	}
	
	void AnimateImage() 
	{
		DelayModifier dMod = new DelayModifier(ObjNo * 6,new IEntityModifierListener()
		{
					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0, 
								IEntity arg1)
					{
						Letter.setVisible(true);
						s.setVisible(true);
						
						audioPlay = true;
						playAudio(R.raw.m_moi);
						
						audioPlayCount++;
						if(audioPlayCount==6)
						{
							audioPlay = true;
							AnimatedBookActivity.ArrowTouchEnable = true;
							//ObjNo=0;
						}
					}
				});
		FadeInModifier macch_fim2 = new FadeInModifier(APPEARING_TIME);
		SequenceEntityModifier macch_sm = new SequenceEntityModifier(dMod,macch_fim2);
		
		Letter.registerEntityModifier(macch_sm);
		
		
	}
	//Audio play Function
	public static void playAudio(int val)
	{
		if(audioPlay)
		{
			if(!mediaPlayer.isPlaying())
			{
				mediaPlayer.reset();
				mediaPlayer = MediaPlayer.create(AnimatedBookActivity.context, val);
					
				try 
				{
					mediaPlayer.start();
					mediaPlayer.setLooping(false);
				} 
				catch (IllegalStateException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			audioPlay = true;
		}
	}
	
}
 