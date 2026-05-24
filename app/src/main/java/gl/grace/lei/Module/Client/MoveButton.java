package gl.grace.lei.Module.Client;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MoveButton extends PopupWindow {

    private Activity activity;
    private int X=0;
    private int Y=0;
    private boolean canmove=false;
    private TextView title;
    private LinearLayout layout;
    static int ColorGradual,ColorGradual2;
    static TextView t;
    public static int[] ObjectColor = new int[]{0xFF59B7FF,0xFF07D8EF,0xFF6EEFC6,0xFFCCFCA5,0xFFFFE082,0xFFFF967C,0xFFFF4EB6,0xFF9C56FF};

    public MoveButton(Activity context, String name, final OnClickListener click) {
        super(context);
        activity = context;
        layout = new LinearLayout(activity);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        layout.setGravity(Gravity.CENTER);
        layout.setBackground(DrawableRectangle(0x8C000000, ColorGradual, ColorGradual2));
        ObjectAnimator ViewAnimtor = ObjectAnimator.ofInt(t, "BackgroundColor", ObjectColor);
        ViewAnimtor.setDuration(3500);
        ViewAnimtor.setEvaluator(new ArgbEvaluator());
        ViewAnimtor.setRepeatCount(ValueAnimator.INFINITE);
        ViewAnimtor.setRepeatMode(ValueAnimator.REVERSE);
        ViewAnimtor.start();
        ViewAnimtor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    ColorGradual = animator.getAnimatedValue();
                    layout.setBackground(DrawableRectangle(0x8C000000, ColorGradual, ColorGradual2));
                }
            });
        new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ObjectAnimator ViewAnimtor = ObjectAnimator.ofInt(t, "BackgroundColor", ObjectColor);
                    ViewAnimtor.setDuration(3500);
                    ViewAnimtor.setEvaluator(new ArgbEvaluator());
                    ViewAnimtor.setRepeatCount(ValueAnimator.INFINITE);
                    ViewAnimtor.setRepeatMode(ValueAnimator.REVERSE);
                    ViewAnimtor.start();
                    ViewAnimtor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animator) {
                                ColorGradual2 = animator.getAnimatedValue();
                            }
                        });
                }
            }, 150);
        title = new TextView(activity);
        title.setText(name);
        title.setTextColor(Color.GRAY);
        title.setPadding(25, 18, 25, 18);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(15);
        layout.addView(title);
        setContentView(layout);
		setBackgroundDrawable(new ColorDrawable(0x00000000));
		setWidth(LayoutParams.WRAP_CONTENT);
		setHeight(LayoutParams.WRAP_CONTENT);
		setFocusable(false);
        setTouchable(true);
        layout.setOnClickListener(new View.OnClickListener() {
                @Override
                private boolean enable;
                public void onClick(View v) {
                    if (click != null) {
                        click.onClick(v);
                    }
                    enable = !enable;
                    if (enable) {
                        new Animator().OfInt(Color.GRAY, 0xffffffff)
                            .Duration(400)
                            .RepeatCount(0)
                            .addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    title.setTextColor(valueAnimator.getAnimatedValue());
                                }
                            })
                            .Evaluator(new ArgbEvaluator())
                            .Start();
                    } else {
                        new Animator().OfInt(0xffffffff, Color.GRAY)
                            .Duration(400)
                            .RepeatCount(0)
                            .addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    title.setTextColor(valueAnimator.getAnimatedValue());
                                }
                            })
                            .Evaluator(new ArgbEvaluator())
                            .Start();
                    }
                }
            });
        layout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    canmove = true;
                    return false;
                }
            });
        layout.setOnTouchListener(new View.OnTouchListener() {
                private float lastX;
                private float lastY;
                private int opMPX = X;
                private int opMPY = Y;
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    int action = event.getAction();
                    if (action == MotionEvent.ACTION_DOWN) {
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                    } else if (action == MotionEvent.ACTION_MOVE && canmove) {
                        float nowX = (int) event.getRawX();
                        float nowY = (int) event.getRawY();
                        float tranX = (int) (nowX) - (int) (lastX);
                        float tranY = (int) (nowY) - (int) (lastY);
                        opMPX += tranX;
                        opMPY += tranY;
                        update(opMPX, opMPY, -1, -1);
                        lastX = (int) nowX;
                        lastY = (int) nowY;
                        X = opMPX;
                        Y = opMPY;
                    } else if (action == MotionEvent.ACTION_UP) {
                        canmove = false;
                    }
                    return false;
                }
            });
    }
    public void showView() {
        this.showAtLocation(this.getContentView(), Gravity.CENTER | Gravity.CENTER, X, Y);
	}
    static GradientDrawable drawable(int color, int cor) {
        final GradientDrawable background = new GradientDrawable();
        background.setColor(color);
        background.setCornerRadius(cor);
        return background;
    }
    static GradientDrawable DrawableRectangle(int color, int color1, int color2) {
        GradientDrawable GradientDrawable=new GradientDrawable();
        GradientDrawable.setCornerRadius(15);
        GradientDrawable.setColor(color);
        GradientDrawable.setShape(GradientDrawable.RECTANGLE);
        GradientDrawable.setStroke(5, color1);
        GradientDrawable.setStroke(5, color2);
        GradientDrawable.setGradientType(android.graphics.drawable.GradientDrawable.LINEAR_GRADIENT);
        GradientDrawable.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.BL_TR);
        return GradientDrawable;
	}
    public static void setEnable(final MoveButton v, boolean enable) {
        if (enable) {
            new Animator().OfInt(Color.GRAY, 0xffffffff)
                .Duration(400)
                .RepeatCount(0)
                .addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        v.title.setTextColor(valueAnimator.getAnimatedValue());
                    }
                })
                .Evaluator(new ArgbEvaluator())
                .Start();
        } else {
            new Animator().OfInt(0xffffffff, Color.GRAY)
                .Duration(400)
                .RepeatCount(0)
                .addUpdateListeners(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        v.title.setTextColor(valueAnimator.getAnimatedValue());
                    }
                })
                .Evaluator(new ArgbEvaluator())
                .Start();
        }
    }
}
