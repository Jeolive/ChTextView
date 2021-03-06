package com.olive.stextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.olive.stextview.animatetext.AnvilText;
import com.olive.stextview.animatetext.EvaporateText;
import com.olive.stextview.animatetext.FallText;
import com.olive.stextview.animatetext.IHText;
import com.olive.stextview.animatetext.LineText;
import com.olive.stextview.animatetext.PixelateText;
import com.olive.stextview.animatetext.RainBowText;
import com.olive.stextview.animatetext.ScaleText;
import com.olive.stextview.animatetext.SparkleText;
import com.olive.stextview.animatetext.TyperText;


/**
 * Animate TextView
 */
public class HTextView extends TextView {

    private IHText mIHText = new ScaleText();
    private AttributeSet attrs;
    private int defStyle;

    public HTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public HTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public HTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }


    private void init(AttributeSet attrs, int defStyle) {

        this.attrs = attrs;
        this.defStyle = defStyle;

        // Get the attributes array
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs,  R.styleable.HTextView);
        final int animateType = typedArray.getInt( R.styleable.HTextView_animateType, 0);
        final String fontAsset = typedArray.getString( R.styleable.HTextView_fontAsset);

        // Set custom typeface
        if (fontAsset != null && !fontAsset.trim().isEmpty()) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), fontAsset));
        }

        switch (animateType) {
            case 0:
                mIHText = new ScaleText();
                break;
            case 1:
                mIHText = new EvaporateText();
                break;
            case 2:
                mIHText = new FallText();
                break;
            case 3:
                mIHText = new SparkleText();
                break;
            case 4:
                mIHText = new AnvilText();
                break;
            case 5:
                mIHText = new LineText();
                break;
            case 6:
                mIHText = new PixelateText();
                break;
            case 7:
                mIHText = new TyperText();
                break;
            case 8:
                mIHText = new RainBowText();
                break;
//            <enum name="scale" value="0"/>
//            <enum name="evaporate" value="1"/>
//            <enum name="fall" value="2"/>
//            <enum name="sparkle" value="3"/>
//            <enum name="anvil" value="4"/>
//            <enum name="line" value="5"/>
//            <enum name="pixelate" value="6"/
        }
        typedArray.recycle();
        initHText(attrs, defStyle);
    }

    private void initHText(AttributeSet attrs, int defStyle) {
        mIHText.init(this, attrs, defStyle);
    }


    public void animateText(CharSequence text) {
        mIHText.animateText(text);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mIHText.onDraw(canvas);
    }

    public void reset(CharSequence text) {
        mIHText.reset(text);
    }

    public void setAnimateType(HTextViewType type) {
        switch (type) {
            case SCALE:
                mIHText = new ScaleText();
                break;
            case EVAPORATE:
                mIHText = new EvaporateText();
                break;
            case FALL:
                mIHText = new FallText();
                break;
            case PIXELATE:
                mIHText = new PixelateText();
                break;
            case ANVIL:
                mIHText = new AnvilText();
                break;
            case SPARKLE:
                mIHText = new SparkleText();
                break;
            case LINE:
                mIHText = new LineText();
                break;
            case TYPER:
                mIHText = new TyperText();
                break;
            case RAINBOW:
                mIHText = new RainBowText();
                break;
        }

        initHText(attrs, defStyle);
    }
}
