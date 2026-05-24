package gl.grace.lei.Module.Client;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

public class MSwitch extends View {
    private Paint Apaint;
    private Paint Bpaint;
    private Paint Cpaint;
	static TextView t;
    private int offBackGroundColor = local.hexColor("#F4F4F4");
    private int onBackGroundColor = local.hexColor("#9198E5");
    private int BackGroundColor = offBackGroundColor;
    private int offThumbColor = local.hexColor("#aaaaaa");
    private int onThumbColor = local.hexColor("#ffffff");
    private int ThumbColor = offThumbColor;
    private int BackGroundShadowColor = local.hexColor("#000000");
    private int ThumbShadowColor = local.hexColor("#000000");
    private int BackGroundShadowRadius = 0;
    private int ThumbShadowRadius = 0;
    private OnClickListener onClickListener;
    private boolean SwitchOn = false;
    private float ThumbX = local.dip2px(14);
    public MSwitch(Context context) {
        super(context);
        init();
    }
    public MSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
    public MSwitch(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        init();
    }
    private void init() {
        Apaint = new Paint();
        Bpaint = new Paint();
        Cpaint = new Paint();
	}
    private void drawThumb(Canvas canvas) {
        canvas.drawCircle(ThumbX, (float) getHeight() / 2, local.dip2px(7), Cpaint);
        invalidate();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void drawBackGround(Canvas canvas) {
        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), 90, 90, Apaint);
        canvas.drawRoundRect(local.dip2px(3), local.dip2px(3), getWidth() - local.dip2px(3), getHeight() - local.dip2px(3), 90, 90, Bpaint);
        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        Apaint.setColor(local.hexColor("#00000000"));

        Bpaint.setColor(BackGroundColor);
        Bpaint.setShadowLayer(BackGroundShadowRadius, 0, 0, BackGroundShadowColor);

        Cpaint.setColor(ThumbColor);
        Cpaint.setShadowLayer(ThumbShadowRadius, 0, 0, ThumbShadowColor);

        drawBackGround(canvas);
        drawThumb(canvas);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        widthMeasureSpec = 120;
        heightMeasureSpec = 70;
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }
    public MSwitch setCheck(boolean b) {
        this.SwitchOn = b;
        if (b) {
            ThumbX = 80;
            ThumbColor = onThumbColor;
            BackGroundColor = onBackGroundColor;
            invalidate();
        }
        return this;
    }
    public MSwitch setBackGroundColor(int onBackGroundColor, int offBackGroundColor) {
        this.onBackGroundColor = onBackGroundColor;
        this.offBackGroundColor = offBackGroundColor;
        invalidate();
        return this;
    }
    public MSwitch setBackGroundShadow(int backGroundShadowRadius, int backGroundShadowColor) {
        this.BackGroundShadowRadius = backGroundShadowRadius;
        this.BackGroundShadowColor = backGroundShadowColor;
        invalidate();
        return this;
    }
    public MSwitch setThumbColor(int onThumbColor, int offThumbColor) {
        this.onThumbColor = onThumbColor;
        this.offThumbColor = offThumbColor;
        invalidate();
        return this;
    }
    public MSwitch setThumbShadow(int thumbShadowRadius, int thumbShadowColor) {
        this.ThumbShadowRadius = thumbShadowRadius;
        this.ThumbShadowColor = thumbShadowColor;
        invalidate();
        return this;
    }
    public MSwitch onClick(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }
    public void OnAnimator() {
        new Animator().OfFloat(local.dip2px(14), getWidth() - local.dip2px(14))
			.Duration(400)
			.RepeatCount(0)
			.addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator valueAnimator) {
					ThumbX = (float) valueAnimator.getAnimatedValue();
					postInvalidateOnAnimation();
				}
			})
			.Interpolator(new OvershootInterpolator())
			.Start();
        new Animator().OfInt(offBackGroundColor, onBackGroundColor)
			.Duration(400)
			.RepeatCount(0)
			.addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator valueAnimator) {
					BackGroundColor = (int) valueAnimator.getAnimatedValue();
				}
			})
			.Evaluator(new ArgbEvaluator())
			.Start();
        new Animator().OfInt(offThumbColor, onThumbColor)
			.Duration(400)
			.RepeatCount(0)
			.addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator valueAnimator) {
					ThumbColor = (int) valueAnimator.getAnimatedValue();
				}
			})
			.Evaluator(new ArgbEvaluator())
			.Start();
        SwitchOn = true;
    }

    public void OffAnimator() {
        new Animator().OfFloat(getWidth() - local.dip2px(14), local.dip2px(14))
			.Duration(400)
			.RepeatCount(0)
			.addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator valueAnimator) {
					ThumbX = (float) valueAnimator.getAnimatedValue();
					postInvalidateOnAnimation();
				}
			})
			.Interpolator(new OvershootInterpolator())
			.Start();
        new Animator().OfInt(onBackGroundColor, offBackGroundColor)
			.Duration(400)
			.RepeatCount(0)
			.addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator valueAnimator) {
					BackGroundColor = (int) valueAnimator.getAnimatedValue();
				}
			})
			.Evaluator(new ArgbEvaluator())
			.Start();
        new Animator().OfInt(onThumbColor, offThumbColor)
			.Duration(400)
			.RepeatCount(0)
			.addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator valueAnimator) {
					ThumbColor = (int) valueAnimator.getAnimatedValue();
				}
			})
			.Evaluator(new ArgbEvaluator())
			.Start();
        SwitchOn = false;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (SwitchOn) {
                    OffAnimator();

                } else {
                    OnAnimator();

                }
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                return true;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
            default:
                return super.onTouchEvent(event);
        }
    }
}
