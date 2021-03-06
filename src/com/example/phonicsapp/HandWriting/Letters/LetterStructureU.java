package com.example.phonicsapp.HandWriting.Letters;

import org.andengine.entity.sprite.AnimatedSprite;
import com.example.phonicsapp.R;
import com.example.phonicsapp.HandWriting.Duster.Duster;
import com.example.phonicsapp.HandWriting.Popup.PopUp;
import com.example.phonicsapp.HandWriting.banglaletterwriting.GameActivity;
import com.example.phonicsapp.HandWriting.banglaletterwriting.NumberSprites;
import com.example.phonicsapp.HandWriting.banglaletterwriting.StructureDrawAnimation;

public class LetterStructureU
{

	//create numberSprite and cursor
	public static void createNumberSpriteAndCursor()
	{
			 
		//creating the first line of numbers
		GameActivity.spriteCounterLimit = 4;
		StructureDrawAnimation.scale(GameActivity.moOutLineX + 70 - 100, GameActivity.moOutLineY - 20, 1);
					
		//creating the fish cursor
		GameActivity.cursor = new AnimatedSprite(GameActivity.moOutLineX, GameActivity.moOutLineY, 
				GameActivity.mFishTextureRegion, GameActivity.vertexBufferObjectManager);
		GameActivity.cursor.animate(new long[]{100, 100, 100, 100, 100, 100}, 0, 5, true);
		GameActivity.cursor.setZIndex(3);
		GameActivity.mScene.attachChild(GameActivity.cursor);
					
		//setting the cursor to top of first number sprite
		NumberSprites.setCursorPosition(GameActivity.numberSprites[1]);
				
	}
		
	//Creating the structure for the Letter by positioning co-ordinates and also drawing with chalk
	public static void getStructure(float x, float y)
	{
			
		if(GameActivity.state==1)
		{
			//Drawing the chalk
			StructureDrawAnimation.Draw(x, y); 
			
			//setting the position of posX, posY
			GameActivity.posX = GameActivity.numberSprites[1].getX()+GameActivity.numberSprites[1].getWidth()/2-20;
			GameActivity.posY = GameActivity.numberSprites[1].getY()+GameActivity.numberSprites[1].getHeight()/2-20;

			if( 
				   GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
				||GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
					)
			{ 
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[1]);
					
				//if out of the area the remove white chalks
				for(int a=0; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				}
				
			}
			//if in the area and collides the right number sprite then remove and pass to the next number sprite
			else 
			{
				NumberSprites.setCursorRotation(x, y);
					
				remove(2, 1,2);
			}
				
		}  
		else if(GameActivity.state==2)
		{
			StructureDrawAnimation.Draw(x, y);
				
			GameActivity.posX = GameActivity.numberSprites[2].getX()+GameActivity.numberSprites[2].getWidth()/2-20;
			GameActivity.posY = GameActivity.numberSprites[2].getY()+GameActivity.numberSprites[2].getHeight()/2-20;

			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
					 ||GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[2]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					}
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(3,2,3);
				}
			}
			else if(GameActivity.state==3)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[3].getX()+GameActivity.numberSprites[3].getWidth()/2-20;
				GameActivity.posY = GameActivity.numberSprites[3].getY()+GameActivity.numberSprites[3].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 ||GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
					|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
					|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
					)
				{
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[3]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
							//if wrong and not shaking the shake as wrong signal
							if(GameActivity.isShaking == false)
							{
								StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);

							}
						}
					}
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(4,3,4);
				}
			}
			else if(GameActivity.state==4)
			{
				GameActivity.mScene.detachChild(GameActivity.numberSprites[4]);
				//creating new line of numbers
				GameActivity.spriteCounterLimit=7;
				StructureDrawAnimation.scale(GameActivity.moOutLineX +50,
						GameActivity.moOutLineY-20, GameActivity.spriteCounter); 
				GameActivity.state=5;
			}
			else if(GameActivity.state==5)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[5].getX()+GameActivity.numberSprites[5].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[5].getY()+GameActivity.numberSprites[5].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
						)
				{
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[5]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					}
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(6,5,6);
				}
			}
			else if(GameActivity.state==6)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[6].getX()+GameActivity.numberSprites[6].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[6].getY()+GameActivity.numberSprites[6].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[6]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					}
					
				}
				else 
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(7,6,7);
				}
			}  
			else if(GameActivity.state==7)
			{
				GameActivity.spriteCounterLimit=9;
				StructureDrawAnimation.scale(GameActivity.moOutLineX-50*GameActivity.spriteCounter +530 ,
						GameActivity.moOutLineY-30*GameActivity.spriteCounter + 310, GameActivity.spriteCounter); 
				GameActivity.state=8;
			}
			else if(GameActivity.state==8)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[7].getX()+GameActivity.numberSprites[7].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[7].getY()+GameActivity.numberSprites[7].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70  
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[7]);
					
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
				}
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(8,7,9);
				}
			}
			else if(GameActivity.state==9)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[8].getX()+GameActivity.numberSprites[8].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[8].getY()+GameActivity.numberSprites[8].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>90 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-80 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[8]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(9,8,10);
				} 
			}
			else if(GameActivity.state==10)
			{
				GameActivity.spriteCounterLimit=12;
				StructureDrawAnimation.scale(GameActivity.moOutLineX+40*GameActivity.spriteCounter -355 ,
						GameActivity.moOutLineY+50*GameActivity.spriteCounter-330, GameActivity.spriteCounter); 
				GameActivity.state=11;
			} 
			
			else if(GameActivity.state==11)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[9].getX()+GameActivity.numberSprites[9].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[9].getY()+GameActivity.numberSprites[9].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[9]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(10,9,12);
				}
			}
			else if(GameActivity.state==12)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[10].getX()+GameActivity.numberSprites[10].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[10].getY()+GameActivity.numberSprites[10].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-80 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[10]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(11,10,13);
				}
			}
			else if(GameActivity.state==13)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[11].getX()+GameActivity.numberSprites[11].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[11].getY()+GameActivity.numberSprites[11].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-80 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[11]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
		                
					remove(12,11,14);
				}
			}
			else if(GameActivity.state==14)
			{
				GameActivity.mScene.detachChild(GameActivity.numberSprites[12]);
				GameActivity.spriteCounterLimit=15;
				StructureDrawAnimation.scale(GameActivity.moOutLineX+130 , 
						80+GameActivity.moOutLineY-70*GameActivity.spriteCounter+810, GameActivity.spriteCounter); 
				GameActivity.state=15; 
			}
			else if(GameActivity.state==15)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[13].getX()+GameActivity.numberSprites[13].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[13].getY()+GameActivity.numberSprites[13].getHeight()/2-20;
				
				//rect(MainActivity.posX, MainActivity.posY);
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[13]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(14,13,16);
				}
			}
			else if(GameActivity.state==16)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[14].getX()+GameActivity.numberSprites[14].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[14].getY()+GameActivity.numberSprites[14].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -80 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>80 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>80 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-80 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[14]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
		                
					remove(15,14,17);
				}
			} 
			else if(GameActivity.state==17)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[14].getX()+GameActivity.numberSprites[14].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[14].getY()+GameActivity.numberSprites[14].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[14]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(15,14,29); 
				}
			} 
			else if(GameActivity.state==19)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[15].getX()+GameActivity.numberSprites[15].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[15].getY()+GameActivity.numberSprites[15].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
						)
				{
					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[15]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
					
					remove(16,15,20); 
				}
			}
			else if(GameActivity.state==20)
			{
				StructureDrawAnimation.Draw(x, y);
				
				GameActivity.posX = GameActivity.numberSprites[16].getX()+GameActivity.numberSprites[16].getWidth()/2-20; 
				GameActivity.posY = GameActivity.numberSprites[16].getY()+GameActivity.numberSprites[16].getHeight()/2-20;
				
				if(
						 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -70 
						 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>70 
							|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-70 
						)
				{

					
					//set the cursor to the last collided number sprite
					NumberSprites.setCursorPosition(GameActivity.numberSprites[16]);
					
					//if out of the area the remove white chalks
					for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
					{
						GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						}
					} 
					
				} 
				else
				{
					//Move the cursor with touch
					NumberSprites.setCursorRotation(x, y);
		                
					remove(17,16,21); 
				}
			}
		}
		
		
		
	public static void Structure()
	{
		
		if(GameActivity.spriteCounterLimit == 4)
		{
			GameActivity.spriteCounter++;
			StructureDrawAnimation.scale(GameActivity.moOutLineX+70*GameActivity.spriteCounter - 100, 
					GameActivity.moOutLineY -20, GameActivity.spriteCounter);
		}
		else if(GameActivity.spriteCounterLimit == 7)
		{
			GameActivity.spriteCounter++;
			StructureDrawAnimation.scale(GameActivity.moOutLineX+50 ,
					GameActivity.moOutLineY+60*GameActivity.spriteCounter - 320,
					GameActivity.spriteCounter);
		}
		else if(GameActivity.spriteCounterLimit == 9) 
		{
			GameActivity.spriteCounter++;
			StructureDrawAnimation.scale(GameActivity.moOutLineX-50*GameActivity.spriteCounter +580 ,
					GameActivity.moOutLineY-30*GameActivity.spriteCounter + 430,
					GameActivity.spriteCounter);
		}
		else if(GameActivity.spriteCounterLimit == 12)
		{
			GameActivity.spriteCounter++;
			StructureDrawAnimation.scale(GameActivity.moOutLineX-40*GameActivity.spriteCounter +430 ,
					GameActivity.moOutLineY-80*GameActivity.spriteCounter+980,
					GameActivity.spriteCounter);
		}
		else if(GameActivity.spriteCounterLimit == 15)
		{
			GameActivity.spriteCounter++;
			StructureDrawAnimation.scale(GameActivity.moOutLineX-90*GameActivity.spriteCounter+1310 , 
					70+GameActivity.moOutLineY-50*GameActivity.spriteCounter+560,
					GameActivity.spriteCounter);
		}
	}
	
	//when a sprite collides a number sprite then it is called;
	//it removes the number sprite and enables the next state for drawing
	public static void remove(int collisionSprite, int removeSpriteNumber, int stateNumber)
	{
		
		if(GameActivity.whiteChalk[GameActivity.aCounter].collidesWith(GameActivity.numberSprites[collisionSprite]))
		{
			//removing when it is in the last state
			if(collisionSprite == 15)
			{ 
				GameActivity.mScene.detachChild(GameActivity.numberSprites[15]);
				
				//trigger for taking screen shot
				GameActivity.screenShotCounter = 1;
				//create book icon
				PopUp.createBookIcon();
				//start duster
				Duster.startDuster();
				
				GameActivity.isActionMoving = false;
				
				//start the hand tutorial 
//				MainActivity.tutorialCounter++;
//				if(MainActivity.tutorialCounter==1)
//				{
//					HandTutorial.handTutorialCreate();
//				}
			}
			GameActivity.mScene.detachChild(GameActivity.numberSprites[removeSpriteNumber]);
			GameActivity.numberSprites[removeSpriteNumber].setY(GameActivity.CAMERA_HEIGHT+500);
			GameActivity.wCounter =GameActivity. aCounter+2;
			GameActivity.state = stateNumber;
			
			//play sound
			GameActivity.audioPlay = true;
			NumberSprites.playAudio(R.raw.star);
			
		}
	}
	
}
