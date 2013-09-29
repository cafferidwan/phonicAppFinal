package com.example.phonicsapp.animatedBook;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class ProgressBar extends HUD 
{
    // ===========================================================
    // Constants          
    // ===========================================================
    private static final float FRAME_LINE_WIDTH = 5f;
    // ===========================================================          
    // Fields        
    // ===========================================================
    private final Line[] mFrameLines = new Line[4];
    private final Rectangle mBackgroundRectangle;
    private final Rectangle mProgressRectangle;
    private VertexBufferObjectManager vbom;
    
    private float mPixelsPerPercentRatio;
    // ===========================================================          
    // Constructors          
    // ===========================================================
    public ProgressBar(final Camera pCamera, final float pX, final float pY, final float pWidth, final float pHeight,VertexBufferObjectManager tvbom) {
            super();
            super.setCamera(pCamera);
            vbom = tvbom;
            this.mBackgroundRectangle = new Rectangle(pX, pY, pWidth, pHeight, tvbom);
           
            this.mFrameLines[0] = new Line(pX, pY, pX+pWidth, pY, FRAME_LINE_WIDTH, tvbom); //Top line.
            this.mFrameLines[1] = new Line(pX + pWidth, pY, pX + pWidth, pY + pHeight, FRAME_LINE_WIDTH, tvbom); //Right line.
            this.mFrameLines[2] = new Line(pX + pWidth, pY + pHeight, pX, pY + pHeight, FRAME_LINE_WIDTH, tvbom); //Bottom line.
            this.mFrameLines[3] = new Line(pX, pY + pHeight, pX, pY, FRAME_LINE_WIDTH, tvbom); //Left line.
           
            this.mProgressRectangle = new Rectangle(pX, pY, pWidth, pHeight, tvbom);
           
            super.attachChild(this.mBackgroundRectangle); //This one is drawn first.
            super.attachChild(this.mProgressRectangle); //The progress is drawn afterwards.
            for(int i = 0; i < this.mFrameLines.length; i++)
                    super.attachChild(this.mFrameLines[i]); //Lines are drawn last, so they'll override everything.
           
            this.mPixelsPerPercentRatio = pWidth / 100;
    }
    // ===========================================================          
    // Getter & Setter          
    // ===========================================================
    public ProgressBar setBackColor(final float pRed, final float pGreen, final float pBlue, final float pAlpha) {
            this.mBackgroundRectangle.setColor(pRed, pGreen, pBlue, pAlpha);
            return this;
    }
    public ProgressBar setFrameColor(final float pRed, final float pGreen, final float pBlue, final float pAlpha) {
            for(int i = 0; i < this.mFrameLines.length; i++)
                    this.mFrameLines[i].setColor(pRed, pGreen, pBlue, pAlpha);
            return this;
    }
    public ProgressBar setProgressColor(final float pRed, final float pGreen, final float pBlue, final float pAlpha) {
            this.mProgressRectangle.setColor(pRed, pGreen, pBlue, pAlpha);
            return this;
    }
    /**
     * Set the current progress of this progress bar.
     * @param pProgress is <b> BETWEEN </b> 0 - 100.
     */
    public ProgressBar setProgress(final float pProgress) {
            if(pProgress < 0)
                    this.mProgressRectangle.setWidth(0); //This is an internal check for my specific game, you can remove it.
            this.mProgressRectangle.setWidth(this.mPixelsPerPercentRatio * pProgress);
            return this;
    }
    // ===========================================================          
    // Methods for/from SuperClass/Interfaces          
    // ===========================================================  
   
    // ===========================================================          
    // Methods          
    // ===========================================================  
    //example use object.setWidth(float original_width, float intended_capacity);
    public ProgressBar setWidth(float width1, float width2){
        this.mPixelsPerPercentRatio = width1/width2;
        return this;
    }
    // ===========================================================          
    // Inner and Anonymous Classes          
    // ===========================================================  
   
}