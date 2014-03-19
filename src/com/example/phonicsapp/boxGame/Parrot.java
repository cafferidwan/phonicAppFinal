package com.example.phonicsapp.boxGame;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.ParallelEntityModifier;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.PathModifier.IPathModifierListener;
import org.andengine.entity.modifier.PathModifier.Path;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.IModifier;
import org.andengine.util.modifier.ease.EaseBounceOut;

import com.example.phonicsapp.R;


public class Parrot extends AnimatedSprite
{

	public Parrot(float pX, float pY, ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager vertexBufferObjectManager)
	{
		super(pX, pY, pTiledTextureRegion, vertexBufferObjectManager);
		// TODO Auto-generated constructor stub

	}
	
	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
	{
		switch (pSceneTouchEvent.getAction()) 
		{
			case TouchEvent.ACTION_DOWN:
			
				Functions.audioPlay = true;
				Functions.playAudio(R.raw.parrot_intro);
				
			break;
			
			case TouchEvent.ACTION_UP:
				
			break;
		
			case TouchEvent.ACTION_MOVE:
				
			break;
		}

		return true;
	}

	static void parrotPath() 
	{
		
//		final Path path = new Path(2).to(BoxGameActivity.CAMERA_WIDTH, BoxGameActivity.CAMERA_HEIGHT / 2 -340).to(BoxGameActivity.CAMERA_WIDTH - 350,
//				BoxGameActivity.CAMERA_HEIGHT / 2 - 340);
//		BoxGameActivity.parrot.registerEntityModifier(new ParallelEntityModifier( new PathModifier(
//				(float) 4.3, path, null, new IPathModifierListener() 
//				{
//					@Override
//					public void onPathStarted(final PathModifier pPathModifier,
//							final IEntity pEntity)
//					{
//						BoxGameActivity.parrot.animate(new long[]{0, 0, 150, 150}, 0, 3, true);
//					}
//					@Override
//					public void onPathWaypointStarted(final PathModifier pPathModifier,
//							final IEntity pEntity, final int pWaypointIndex) 
//					{
//
//					}
//					@Override
//					public void onPathWaypointFinished(final PathModifier pPathModifier,
//							final IEntity pEntity, final int pWaypointIndex) 
//					{
//
//					}
//					@Override
//					public void onPathFinished(final PathModifier pPathModifier,
//							final IEntity pEntity) 
//					{
//						BoxGameActivity.parrot.animate(new long[]{150, 150, 0, 0}, 0, 3, true);
//					}
//				})));

		/////////////////////
		MoveModifier mMod = new MoveModifier(4, BoxGameActivity.CAMERA_WIDTH , BoxGameActivity.CAMERA_WIDTH - 350, 
				BoxGameActivity.CAMERA_HEIGHT / 2 -340, BoxGameActivity.CAMERA_HEIGHT / 2 - 340);
		
		MoveModifier mModLetter = new MoveModifier(4, BoxGameActivity.CAMERA_WIDTH  ,BoxGameActivity.CAMERA_WIDTH - 180,
				BoxGameActivity.CAMERA_HEIGHT / 2 -80, BoxGameActivity.CAMERA_HEIGHT / 2 - 80);
		
		DelayModifier dMod = new DelayModifier((float) 0.1,new IEntityModifierListener()
		{

					@Override
					public void onModifierStarted(IModifier<IEntity> arg0,
							IEntity arg1) 
					{
						BoxGameActivity.parrot.animate(new long[]{0, 0, 150, 150}, 0, 3, true);
					}

					@Override
					public void onModifierFinished(IModifier<IEntity> arg0,
							IEntity arg1)
					{
						//playAudio(R.raw.parrot_introducing_mo);
						//mLetter.setVisible(false);
						BoxGameActivity.parrot.animate(new long[]{150, 150, 0, 0}, 0, 3, true);
					}
				});
		
		SequenceEntityModifier parrot_sm = new SequenceEntityModifier(mMod,dMod);
		SequenceEntityModifier mLetter_sm = new SequenceEntityModifier(mModLetter,dMod);
		
		BoxGameActivity.parrot.registerEntityModifier(parrot_sm);
		BoxGameActivity.letter.registerEntityModifier(mLetter_sm);
		
	}
}
