package com.example.phonicsapp.monkeyGame;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;

import com.example.phonicsapp.wordbuilder.MainActivity;

public class MonkeyGameTimerHandlers 
{

	// selecting random items
	public static void selectRandromObjects() 
	{
		//Choosing random items and playing
		MonkeyGameActivity.timer1 = new TimerHandler(5, true,new ITimerCallback() 
		{
					@Override
					public void onTimePassed(TimerHandler pTimerHandler)
					{
						// TODO Auto-generated method stub

						// Loading the Objects according to the game letter
						MonkeyGameLevelResources.LoadObjects(MonkeyGameActivity.monkeyGameMenuLetterSelector);

						MonkeyGameActivity.randomItem = (int) (Math.random() * 6);
						MonkeyGameActivity.randomItem1 = (int) (Math.random() * 6);
						if (MonkeyGameActivity.randomItem == MonkeyGameActivity.randomItem1)
						{
							MonkeyGameActivity.randomItem1 = MonkeyGameActivity.randomItem1 + 2;
						}

						if (MonkeyGameActivity.randomItem == 0
								&& MonkeyGameActivity.randomItem1 == 1
								|| MonkeyGameActivity.randomItem == 1
								&& MonkeyGameActivity.randomItem1 == 0) 
						{
							MonkeyGameActivity.randomItem1 = MonkeyGameActivity.randomItem1 + 2;
						}
						
						if(MonkeyGameActivity.monkeyGameMenuLetterSelector==1)
						{
							setLevelObject();
						}
						else if(MonkeyGameActivity.monkeyGameMenuLetterSelector==6)
						{
							setLevelObject();
						}
						else if(MonkeyGameActivity.monkeyGameMenuLetterSelector==4)
						{
							setLevelObject();
						}
						else if(MonkeyGameActivity.monkeyGameMenuLetterSelector==19)
						{
							setLevelObject();
						}

		
					}
				});
		
		MonkeyGameActivity.mScene.registerUpdateHandler(MonkeyGameActivity.timer1);
	}
	
	//setting the line(stright/zig zag) of objects according to the level
	public static void setLevelObject()
	{
		
		switch (MonkeyGameActivity.randomItem) 
		{
		case 0:
			GameObjects.wrongObj1(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 1);
			break;

		case 1:
			GameObjects.wrongObj2(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 1);
			break;

		case 2:
			GameObjects.obj1(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 1);
			break;

		case 3:
			GameObjects.obj2(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 1);
			break;

		case 4:
			GameObjects.obj3(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 1);
			break;

		case 5:
			GameObjects.obj4(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 1);
			break;

		default:
			// GameObjects.obj3(2,1);
			break;
		}

		switch (MonkeyGameActivity.randomItem1)
		{
		case 0:
			GameObjects.wrongObj1(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 2);
			break;

		case 1:
			GameObjects.wrongObj2(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 2);
			break;

		case 2:
			GameObjects.obj1(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 2);
			break;

		case 3:
			GameObjects.obj2(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 2);
			break;

		case 4:
			GameObjects.obj3(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 2);
			break;

		case 5:
			GameObjects.obj4(MonkeyGameActivity.monkeyGameLevelSelector1[MonkeyGameActivity.monkeyGameMenuLetterSelector], 2);
			break;

		default:
			// GameObjects.obj3(2,2);
			break;
		}
	}
}
