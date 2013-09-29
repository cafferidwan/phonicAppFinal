package com.example.phonicsapp.animatedBook;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.IModifier;

import com.example.phonicsapp.R;
import com.example.phonicsapp.R.raw;

import android.content.Context;


public class Parrot extends AnimatedSprite 
{
	AnimatedSprite parrotFlying;
	Context cont;
	VertexBufferObjectManager vobm;
	Sprite Next, mLetter;
	ITextureRegion LetterTextureReason;

	public Parrot(float pX, float pY, float pWidth, float pHeight, ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObject, int audio, Context con, ITextureRegion pTextureRegion)
	{
		super(pX, pY, pWidth, pHeight, pTiledTextureRegion, pVertexBufferObject);
		vobm = pVertexBufferObject;
		cont = con;
		LetterTextureReason = pTextureRegion;
		mLetter = new Sprite(pX, pY, pTextureRegion, pVertexBufferObject);

		this.parrotFlying = new AnimatedSprite(pX, pY, pWidth, pHeight,
				pTiledTextureRegion, vobm)
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
			{
				switch (pSceneTouchEvent.getAction()) 
				{
				case TouchEvent.ACTION_DOWN:
				{
					break;
				}
				case TouchEvent.ACTION_MOVE:
				{

					break;
				}
				case TouchEvent.ACTION_UP: 
				{
					TiledImage.audioPlay = true;
					TiledImage.playAudio(R.raw.mo);
					break;
				}
				default:
				{

				}
				}
				return false;
			}
		};
		parrotFlying.animate(new long[] { 200, 200, 200, 200, 200, 200, 200,
				200 }, 0, 7, true);
		parrotFlying.setFlippedHorizontal(true);
		parrotFlying.setHeight(BaseActivity.CAMERA_HIGHT / 2);
		parrotFlying.setWidth(BaseActivity.CAMERA_WIDTH / 4);
		mLetter.setHeight(BaseActivity.CAMERA_HIGHT / 6);
		mLetter.setWidth(BaseActivity.CAMERA_WIDTH / 8);
		loadMparrot();

	}

	void loadMparrot()
	{
		MoveModifier mMod = new MoveModifier(4.0f,
				BaseActivity.CAMERA_WIDTH + 100,
				BaseActivity.CAMERA_WIDTH - 250,
				BaseActivity.CAMERA_HIGHT / 10.55f,
				BaseActivity.CAMERA_HIGHT / 10.55f);
		MoveModifier mModLetter = new MoveModifier(4.0f,
				BaseActivity.CAMERA_WIDTH + 100,
				BaseActivity.CAMERA_WIDTH - 220,
				BaseActivity.CAMERA_HIGHT / 2.1f,
				BaseActivity.CAMERA_HIGHT / 2.1f);
		DelayModifier dMod = new DelayModifier(1,
				new IEntityModifierListener()
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
						TiledImage.audioPlay = true;
						TiledImage.playAudio(R.raw.parrot_introducing_mo);
					}
				});
		SequenceEntityModifier macch_sm = new SequenceEntityModifier(mMod, dMod);
		SequenceEntityModifier mLetter_sm = new SequenceEntityModifier(mModLetter, dMod);
		
		parrotFlying.registerEntityModifier(macch_sm);
		mLetter.registerEntityModifier(mLetter_sm);
	}

	void createNextArrow(float pX, float pY, float pWidth, float pHeight,
			ITextureRegion pTextureRegion, int voice) 
	{
		this.Next = new Sprite(pX, pY, pTextureRegion, this.vobm)
		{
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
			{
				switch (pSceneTouchEvent.getAction())
				{
					case TouchEvent.ACTION_DOWN: 
					{
						break;
					}
					case TouchEvent.ACTION_MOVE: 
					{
						break;
					}
					case TouchEvent.ACTION_UP:
					{
						BaseActivity.mMainScene.detachChildren();
						break;
					}
					default: 
					
				}
				return false;
			}
		};
	}
}
