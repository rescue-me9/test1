package gl.grace.lei.Module.Client;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.Gravity;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ArrayList extends PopupWindow {

    /*
     *简洁的Hud
     *Create at 2025.3.18 1:24
     *Author Thunder
     *QQ[1145145313]
     */
    private static Activity Activity;
    private static LinearLayout LinearLayout;
    private static List<String> ArrayList = new ArrayList<String>();
    private static TextView[] Array = new TextView[999];
    private static LinearLayout[] GC = new LinearLayout[999];
    private static LinearLayout[] GD = new LinearLayout[999];
    private static LinearLayout[] GL = new LinearLayout[999];
    private static LinearLayout[] AT = new LinearLayout[999];
    public static boolean text = true;
    public static boolean line = false;
    public static boolean bilateralLine = false;
    public static boolean background = false;
    public static boolean bold = false;
    public static ValueAnimator colorAnimator;
    public static int speed = 150;

    public ArrayList(Activity activity) {
        Activity = activity;
        LinearLayout = new LinearLayout(activity);
        LinearLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        LinearLayout.setOrientation(1);
        LinearLayout.setGravity(Gravity.CENTER | Gravity.RIGHT);
        setAnimationStyle(android.R.style.Animation_Translucent);
        setFocusable(false);
        setTouchable(false);
        setWidth(LayoutParams.WRAP_CONTENT);
        setHeight(LayoutParams.WRAP_CONTENT);
        setContentView(LinearLayout);
        AT[0] = new LinearLayout(Activity);
        AT[0].setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 3));
        initColorAnimation();
    }
    private void initColorAnimation() {
        colorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), 0xFF59B7FF, 0xFF07D8EF, 0xFF6EEFC6, 0xFFCCFCA5, 0xFFFFE082, 0xFFFF967C, 0xFFFF4EB6, 0xFF9C56FF, 0xFF59B7FF);
        colorAnimator.setDuration(5000);
        colorAnimator.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimator.setInterpolator(new LinearInterpolator());
        colorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    updateTextColors(animation.getAnimatedValue());
                }
            });
        colorAnimator.start();
    }

    private void updateTextColors(final int color) {
        for (int mod = 0; mod < ArrayList.size(); mod++) {
            final int finalmod = mod;
            if (Array[mod] != null) {
                new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AT[0].setBackgroundColor(color);
                            Array[finalmod].setTextColor(color);
                            Array[finalmod].setShadowLayer(1, 0, 0, color);
                            Array[finalmod].setGravity(Gravity.CENTER | Gravity.RIGHT);
                            GD[finalmod].setBackgroundColor(color);
                            GL[finalmod].setBackgroundColor(color);
                        }
                    }, speed * mod);
            }
        }
    }
    private static void update() {
        LinearLayout.removeAllViews();
        final Paint paint = new Paint();
        paint.setTextSize(114514);
        Collections.sort(ArrayList, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    float width1 = paint.measureText(s1);
                    float width2 = paint.measureText(s2);
                    return Float.compare(width2, width1);
                }
            });
        if (line) {
            LinearLayout.addView(AT[0]);
        }
        for (int mod = 0; mod < ArrayList.size(); mod++) {
            GC[mod] = new LinearLayout(Activity);
            GC[mod].setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            GC[mod].setGravity(Gravity.CENTER);
            GC[mod].setOrientation(0);
            GL[mod] = new LinearLayout(Activity);
            GL[mod].setLayoutParams(new LinearLayout.LayoutParams(3, LayoutParams.MATCH_PARENT));
            GL[mod].setBackgroundColor(0xFFFFFFFF);
            GD[mod] = new LinearLayout(Activity);
            GD[mod].setLayoutParams(new LinearLayout.LayoutParams(3, LayoutParams.MATCH_PARENT));
            GD[mod].setBackgroundColor(0xFFFFFFFF);
            Array[mod] = new TextView(Activity);
            Array[mod].setText(Tools.FontColor(ArrayList.get(mod)));
            Array[mod].setTextColor(Color.WHITE);
            Array[mod].setGravity(Gravity.CENTER | Gravity.RIGHT);
            Array[mod].setTextSize(13f);
            Array[mod].setPadding(5, 0, 5, 0);
            if (background) {
                Array[mod].setBackgroundColor(0xaa000000);
            }
            if (bold) {
                Array[mod].setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            } else{
                Array[mod].setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
            if (bilateralLine) {
                GC[mod].addView(GL[mod]);
            }
            GC[mod].addView(Array[mod]);
            if (line || bilateralLine) {
                GC[mod].addView(GD[mod]);
            }
            LinearLayout.addView(GC[mod]);
        }
    }

    public static void addArrav(String array) {
        if (ArrayList.contains(array)) return;
        ArrayList.add(array);
        update();
        for (int mod = 0; mod < ArrayList.size(); mod++) {
            if (getTextString(Array[mod]).contains(array)) {
                Array[mod].measure(0, 0);
                ObjectAnimator.ofFloat(GC[mod], "translationX", Array[mod].getMeasuredWidth(), 0, 0).setDuration(400).start();
                for (int i = mod + 1; i < ArrayList.size(); i++) {
                    Array[i].measure(0, 0);
                    ObjectAnimator.ofFloat(GC[i], "translationY", -Array[i].getMeasuredHeight(), 0, 0).setDuration(400).start();
                }
                break;
            }
        }
    }
    public static void addArrav(String array, String details) {
        if (ArrayList.contains(array + ", " + details)) return;
        ArrayList.add(array + ", " + details);
        update();
        for (int mod = 0; mod < ArrayList.size(); mod++) {
            if (getTextString(Array[mod]).contains(array)) {
                Array[mod].measure(0, 0);
                ObjectAnimator.ofFloat(GC[mod], "translationX", Array[mod].getMeasuredWidth(), 0, 0).setDuration(400).start();
                for (int i = mod + 1; i < ArrayList.size(); i++) {
                    Array[i].measure(0, 0);
                    ObjectAnimator.ofFloat(GC[i], "translationY", -Array[i].getMeasuredHeight(), 0, 0).setDuration(400).start();
                }
                break;
            }
        }
    }
    public static void removeArrav(final String array) {
        if (!ArrayList.contains(array)) return;
        for (int mod = 0; mod < ArrayList.size(); mod++) {
            if (getTextString(Array[mod]).contains(array)) {
                Array[mod].measure(0, 0);
                ObjectAnimator.ofFloat(GC[mod], "translationX", 0, Array[mod].getMeasuredWidth()).setDuration(400).start();
                new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ArrayList.remove(array);
                            update();
                        }
                    }, 350);
                for (int i = mod + 1; i < ArrayList.size(); i++) {
                    Array[i].measure(0, 0);
                    ObjectAnimator.ofFloat(GC[i], "translationY", 0, -Array[i - 1].getMeasuredHeight()).setDuration(400).start();
                }
                break;
            }
        }
    }
    public static void removeArrav(final String array, final String details) {
        if (!ArrayList.contains(array + ", " + details)) return;
        for (int mod = 0; mod < ArrayList.size(); mod++) {
            if (getTextString(Array[mod]).contains(array)) {
                Array[mod].measure(0, 0);
                ObjectAnimator.ofFloat(GC[mod], "translationX", 0, Array[mod].getMeasuredWidth()).setDuration(400).start();
                new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ArrayList.remove(array + ", " + details);
                            update();
                        }
                    }, 350);
                for (int i = mod + 1; i < ArrayList.size(); i++) {
                    Array[i].measure(0, 0);
                    ObjectAnimator.ofFloat(GC[i], "translationY", 0, -Array[i - 1].getMeasuredHeight()).setDuration(400).start();
                }
                break;
            }
        }
    }
    public void showAtLocation() {
        showAtLocation(LinearLayout, Gravity.RIGHT | Gravity.TOP, 20, 20);
    }
    public static String getTextString(TextView tv) {
        return tv.getText().toString();
    }
}
