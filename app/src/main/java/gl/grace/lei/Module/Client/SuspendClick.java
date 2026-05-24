package gl.grace.lei.Module.Client;

import android.animation.Animator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import gl.grace.lei.Module.Hacker.dexLoad;
import gl.grace.lei.Module.base64;
import java.io.IOException;
import java.io.InputStream;

public class SuspendClick {
    Activity activity;
	public static int GRAY = Color.GRAY;
    PopupWindow PopupWindow;
    int X=150,Y=150;
	float rippleX,rippleY;
    boolean canmove=false,moveFX = false;
    LinearLayout mBlur;
    PopupWindow bwBlur;
    int size = 100;
    //private final String imageBase64 = base64.base64;
    public SuspendClick(Activity Activity) {
        activity = Activity;
        PopupWindow = new PopupWindow();
		PopupWindow.setAnimationStyle(android.R.style.Animation_Toast);
        PopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
		PopupWindow.setTouchable(true);
		PopupWindow.setFocusable(false);
		PopupWindow.setWidth(size);
		PopupWindow.setHeight(size);
        final LinearLayout layout = new LinearLayout(Activity);
        layout.setLayoutParams(new LayoutParams(size, size));
        layout.setGravity(Gravity.CENTER | Gravity.CENTER);
        layout.setBackground(Drawable(0xFFFFFFFF, 25));
        /*byte[] decoded = Base64.decode(imageBase64, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decoded, 0, decoded.length);
        ImageView icon = new ImageView(Activity);
        icon.setImageBitmap(bitmap);
        layout.addView(icon, -1, -1);*/
        layout.setOnClickListener(new OnClickListener(){
                @Override
                private boolean a;
                public void onClick(View p1) {
                    a = !a;
                    dexLoad.Notice.addNotice("ClickGui", a);
                    if (a) {
                        dexLoad.ClickGUI.showAtLocation();
                    } else {
                        dexLoad.ClickGUI.dismiss();
                    }
                }
            });

        PopupWindow.setContentView(layout);

        layout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    canmove = true;
                    moveFX = true;
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
                        layout.animate().scaleX(0.85f).scaleY(0.85f).setDuration(100).start();
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                    } else if (action == MotionEvent.ACTION_MOVE && canmove) {
                        float nowX = (int) event.getRawX();
                        float nowY = (int) event.getRawY();
                        float tranX = (int) (nowX) - (int) (lastX);
                        float tranY = (int) (nowY) - (int) (lastY);
                        opMPX -= tranX;
                        opMPY += tranY;
                        PopupWindow.update(opMPX, opMPY, -1, -1);
                        lastX = (int) nowX;
                        lastY = (int) nowY;
                        rippleX = lastX;
                        rippleY = lastY;
                        X = opMPX;
                        Y = opMPY;
                        if (moveFX) {
                            moveFX = false;
                            LinearLayout m = new LinearLayout(activity);
                            m.setBackgroundColor(0x50777778);
                            m.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                            final PopupWindow bw = new PopupWindow();
                            bw.setAnimationStyle(android.R.style.Animation_Dialog);
                            bw.setWidth(-1);
                            bw.setHeight(-1);
                            bw.setFocusable(true);
                            bw.setTouchable(true);
                            bw.setOutsideTouchable(true);
                            bw.setClippingEnabled(true);
                            bw.setBackgroundDrawable(new ColorDrawable(0));
                            bw.setContentView(m);
                            bw.showAtLocation(activity.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
                            UIReveal(m, (int) rippleX, (int) rippleY, 0, (int) (Math.max(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels) * 1.2f), 1000);
                            UIFadein(m, 100, 0, 800);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        bw.dismiss();
                                    }
                                }, 1000);
                        }
                    } else if (action == MotionEvent.ACTION_UP) {
                        canmove = false;
                        layout.animate().scaleX(1f).scaleY(1f).setDuration(300).start();
                    }
                    return false;
                }
            });
    }
    static GradientDrawable Drawable(int color, int cor) {
        GradientDrawable GradientDrawable = new GradientDrawable();
        GradientDrawable.setColor(color);
        GradientDrawable.setCornerRadius(cor);
        return GradientDrawable;
    }
    public void showAtLocation() {
        PopupWindow.showAtLocation(PopupWindow.getContentView(), Gravity.RIGHT | Gravity.TOP, 150, 150);
    }
	public static ViewTreeObserver.OnGlobalLayoutListener UIReveal(final LinearLayout view, final int x, final int y, final int startRadius, final int endRadius, final int time) {
        final ViewTreeObserver.OnGlobalLayoutListener layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Animator animator = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    animator = ViewAnimationUtils.createCircularReveal(view, x, y, (float) startRadius, (float) endRadius);
                }
                if (animator != null) {
                    animator.setDuration(time);//动画持续的时长
                }
                if (animator != null) {
                    animator.start();
                }
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        };
        view.setVisibility(View.VISIBLE);
        view.getViewTreeObserver().addOnGlobalLayoutListener(layoutListener);
        return layoutListener;
    }

    public static AlphaAnimation UIFadein(final View view, int A, int B, int time) {
        AlphaAnimation alphaAnimation = new AlphaAnimation((int) (A * 0.01), (int) (B * 0.01));
        alphaAnimation.setDuration(time);
        alphaAnimation.setRepeatCount(0);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
        return alphaAnimation;
    }
}
