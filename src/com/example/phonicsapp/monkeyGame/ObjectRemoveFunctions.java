package com.example.phonicsapp.monkeyGame;

import org.andengine.entity.sprite.Sprite;

import android.media.MediaPlayer;

public class ObjectRemoveFunctions
{

	public static void removeFace(Sprite pTouchArea)
	{
		// TODO Auto-generated method stub
		if ((Sprite) pTouchArea == MonkeyGameActivity.wrongObj1)
		{
			MonkeyGameActivity.audioPlay = true;
			playAudio(MonkeyGameActivity.wrongObj1Sound);
			MonkeyGameActivity.mScene.unregisterTouchArea(pTouchArea);
			MonkeyGameActivity.mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(MonkeyGameActivity.obj3);
			GameObjects.fadeOut(MonkeyGameActivity.obj1);
			GameObjects.fadeOut(MonkeyGameActivity.obj4);
			GameObjects.fadeOut(MonkeyGameActivity.obj2);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj2);

			if (MonkeyGameActivity.position[MonkeyGameActivity.aCount] == null) 
			{

			} 
			else
			{
				MonkeyGameActivity.value = 1;
			}
		} 
		else if ((Sprite) pTouchArea == MonkeyGameActivity.wrongObj2)
		{
			MonkeyGameActivity.audioPlay = true;
			playAudio(MonkeyGameActivity.wrongObj2Sound);
			MonkeyGameActivity.mScene.unregisterTouchArea(pTouchArea);
			MonkeyGameActivity.mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(MonkeyGameActivity.obj3);
			GameObjects.fadeOut(MonkeyGameActivity.obj1);
			GameObjects.fadeOut(MonkeyGameActivity.obj4);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj1);
			GameObjects.fadeOut(MonkeyGameActivity.obj2);

			if (MonkeyGameActivity.position[MonkeyGameActivity.aCount] == null) 
			{

			}
			else 
			{
				MonkeyGameActivity.value = 1;
			}
		}

		else if ((Sprite) pTouchArea == MonkeyGameActivity.obj1)
		{
			MonkeyGameActivity.audioPlay = true;
			playAudio(MonkeyGameActivity.obj1Sound);
			MonkeyGameActivity.bananaValue = 1;
			MonkeyGameActivity.mScene.unregisterTouchArea(pTouchArea);
			MonkeyGameActivity.mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(MonkeyGameActivity.obj3);
			GameObjects.fadeOut(MonkeyGameActivity.obj2);
			GameObjects.fadeOut(MonkeyGameActivity.obj4);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj1);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj2);
		}
		else if ((Sprite) pTouchArea == MonkeyGameActivity.obj2) 
		{
			MonkeyGameActivity.audioPlay = true;
			playAudio(MonkeyGameActivity.obj2Sound);
			MonkeyGameActivity.bananaValue = 1;
			MonkeyGameActivity.mScene.unregisterTouchArea(pTouchArea);
			MonkeyGameActivity.mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(MonkeyGameActivity.obj3);
			GameObjects.fadeOut(MonkeyGameActivity.obj1);
			GameObjects.fadeOut(MonkeyGameActivity.obj4);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj1);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj2);
		} 
		else if ((Sprite) pTouchArea == MonkeyGameActivity.obj3) 
		{
			MonkeyGameActivity.audioPlay = true;
			playAudio(MonkeyGameActivity.obj3Sound);
			MonkeyGameActivity.bananaValue = 1;
			MonkeyGameActivity.mScene.unregisterTouchArea(pTouchArea);
			MonkeyGameActivity.mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(MonkeyGameActivity.obj2);
			GameObjects.fadeOut(MonkeyGameActivity.obj1);
			GameObjects.fadeOut(MonkeyGameActivity.obj4);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj1);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj2);
		} 
		else if ((Sprite) pTouchArea == MonkeyGameActivity.obj4) 
		{
			MonkeyGameActivity.audioPlay = true;
			playAudio(MonkeyGameActivity.obj4Sound);
			MonkeyGameActivity.bananaValue = 1;
			MonkeyGameActivity.mScene.unregisterTouchArea(pTouchArea);
			MonkeyGameActivity.mScene.detachChild(pTouchArea);
			GameObjects.fadeOut(MonkeyGameActivity.obj3);
			GameObjects.fadeOut(MonkeyGameActivity.obj1);
			GameObjects.fadeOut(MonkeyGameActivity.obj2);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj1);
			GameObjects.fadeOut(MonkeyGameActivity.wrongObj2);
		}
	}

	// Audio play Function
	public static void playAudio(int val) 
	{
		if (MonkeyGameActivity.audioPlay) 
		{
			if (!MonkeyGameActivity.mediaPlayer.isPlaying()) 
			{
				MonkeyGameActivity.mediaPlayer.reset();
				MonkeyGameActivity.mediaPlayer = MediaPlayer.create(MonkeyGameActivity.MonkeyGameActivityActivity, val);

				try 
				{
					MonkeyGameActivity.mediaPlayer.start();
					MonkeyGameActivity.mediaPlayer.setLooping(false);
				} 
				catch (IllegalStateException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			MonkeyGameActivity.audioPlay = true;
		}
	}
}
