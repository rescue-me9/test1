package gl.grace.lei.Module.Client;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class local {
    /*颜色库*/
    //算法来自于Answer
    public static GradientDrawable roundBG(Object hex,Object round, String f, Object s) {
        if (isArray(hex)) {
            String[] hex2=(String[])hex;
            return  roundRect(new int[]{hexColor(hex2[0]),hexColor(hex2[1])},round,f,0);
        } else {
            return  roundRect(hexColor((String)(hex)), round, f, s);
        }
    }
    public static GradientDrawable roundBGS(Object hex, Object round, String f, Object s) {
        return roundRect(hex,round,f,s);
    }
    public static GradientDrawable roundRect(Object arr, Object arr2, String f, Object s) {

        int[] arrs;
        float[] arrs2;
        GradientDrawable.Orientation jb = null;
        int type = 0;
        GradientDrawable background =new GradientDrawable();
        if (!isArray(arr)) {
            arrs = new int[]{(int)arr,(int)arr,(int)arr};
            background.setColors(arrs);
        } else {
            background.setColors((int[])(arr));
        }
        if (!isArray(arr2)) {
            arrs2 = new float[]{Float.parseFloat(arr2 + ""),Float.parseFloat(arr2 + ""),Float.parseFloat(arr2 + ""),Float.parseFloat(arr2 + ""),Float.parseFloat(arr2 + ""),Float.parseFloat(arr2 + ""),Float.parseFloat(arr2 + ""),Float.parseFloat(arr2 + "")};
            background.setCornerRadii(arrs2);
        } else {
            int[] arr2s=(int[])(arr2);
            arrs2 = new float[]{Float.parseFloat(arr2s[0] + ""),Float.parseFloat(arr2s[0] + ""),Float.parseFloat(arr2s[1] + ""),Float.parseFloat(arr2s[1] + ""),Float.parseFloat(arr2s[2] + ""),Float.parseFloat(arr2s[2] + ""),Float.parseFloat(arr2s[3] + ""),Float.parseFloat(arr2s[3] + "")};
            background.setCornerRadii(arrs2);
        }
        if (arr2 == null) {
            float[] arr2s=new float[]{10,10,10,10,10,10,10,10};
            background.setCornerRadii(arr2s);     
        }
        if (f.equals("TB")) {
            jb = GradientDrawable.Orientation.TOP_BOTTOM;//左右
        } else if (f.equals("LR")) {
            jb = GradientDrawable.Orientation.LEFT_RIGHT;//右上
        } else if (f.equals("RT")) {
            jb = GradientDrawable.Orientation.BL_TR;//右下
        } else if (f.equals("RB")) {
            jb = GradientDrawable.Orientation.TL_BR;
        }
        if ((int) s == 0) {
            type = GradientDrawable.LINEAR_GRADIENT;
        } else if ((int)s == 1) {
            type = GradientDrawable.RADIAL_GRADIENT;
        } else if ((int)s == 2) {
            type = GradientDrawable.SWEEP_GRADIENT;
        }
        background.setShape(GradientDrawable.RECTANGLE);
        background.setGradientType(type);
        background.setOrientation(jb);
        return background;}


    public static int hexColor(String c) {
        return android.graphics.Color.parseColor(c);
    }

    public static boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass().isArray();
    }
    /*获取屏幕大小*/
    public static int W() {
        return (int)(Resources.getSystem().getDisplayMetrics().widthPixels);
    }
    public static int H() {
        return (int)(Resources.getSystem().getDisplayMetrics().heightPixels);
    }
    public static int dip2px(int value){
       return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,Resources.getSystem().getDisplayMetrics());
    }
    /*关闭状态栏*/
    public static void hideStatusBar(Activity activity) {
        if (activity == null) return;
        Window window = activity.getWindow();
        if (window == null) return;
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        WindowManager.LayoutParams lp = window.getAttributes();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        window.setAttributes(lp);
    }
    //文本颜色 by:Answer
    public static String[][] Color =new String[][]{
        {" "," &nbsp;"},
        {"\n","<br/>"},
        {"§l","</b><b>"},
        {"§m","</del><del>"},
        {"§n","</ins><ins>"},
        {"§o","</i><i>"},
        {"§r","</font></b></del></ins></i>"},
        {"§0","</font><font color=#000000>"},
        {"§1","</font><font color=#0000AA>"},
        {"§2","</font><font color=#00AA00>"},
        {"§3","</font><font color=#00AAAA>"},
        {"§4","</font><font color=#AA0000>"},
        {"§5","</font><font color=#AA00AA>"},
        {"§6","</font><font color=#FFAA00>"},
        {"§7","</font><font color=#cccccc>"},
        {"§8","</font><font color=#555555>"},
        {"§9","</font><font color=#5555FF>"},
        {"§a","</font><font color=#55FF55>"},
        {"§b","</font><font color=#55FFFF>"},
        {"§c","</font><font color=#FF5555>"},
        {"§d","</font><font color=#FF55FF>"},
        {"§e","</font><font color=#FFFF55>"},
        {"§f","</font><font color=#FFFFFF>"}
    };

    public static String join(Iterator it, String str) {
        if (!it.hasNext()) {
            return "";
        }
        String start = it.next().toString();
        if (!it.hasNext()) {
            return start;
        }
        StringBuilder sb = new StringBuilder(64).append(start);
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public static String join(Collection collection, String str) {
        return join(collection.iterator(), str);
    }


    public static String join(String[] strArr, String str) {
        return join(Arrays.asList(strArr), str);
    }

    public static android.text.Spanned FontColor(String text) {
        for (String[] strings : Color) {
            text = join(text.split(strings[0]), strings[1]);
        }
        return android.text.Html.fromHtml(text);
    }
    //结束
    
    //创建文件夹
    public static void InputFolder(String path) {
        File dirPath = new File(path);
        if (!dirPath.isDirectory()) {
            dirPath.mkdirs();
        }
    }
    //检测文件是否存在
    public static boolean CheckFiles(String data) {
        return new File(data).isFile();
    }

    //创建文件
    public static void InputData(String path, String data) {
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(path);
            fos.write(data.getBytes("UTF8"));
        } catch (Throwable e) {} finally {if (fos != null)try {fos.close();} catch (Throwable e) {}} 
    }
    //读取文件by:Answer
    public static String ReadData(String strFilePath) {
        String content = ""; //文件内容字符串
        //打开文件
        File file = new File(strFilePath);
        //如果path是传递过来的参数，可以做一个非目录的判断
        if (file.isDirectory()) {
            //  Log.d("The File doesn't not exist.");
        } else {
            try {
                InputStream instream = new FileInputStream(file);
                if (instream != null) {
                    InputStreamReader inputreader = new InputStreamReader(instream);
                    BufferedReader buffreader = new BufferedReader(inputreader);
                    String line;
                    //分行读取
                    while ((line = buffreader.readLine()) != null) {
                        content += line + "\n";
                    }               
                    instream.close();
                }
            } catch (java.io.FileNotFoundException e) {
                //Log.d("TestFile", "The File doesn't not exist.");
            } catch (IOException e) {
                //Log.d("TestFile", e.getMessage());
            }
        }
        return content;
    }
    /*移动*/
    public static TranslateAnimation UIMove(final View view, Object type, int x1, int x2, int y1, int y2, int time) {
        int tp = Animation.RELATIVE_TO_SELF;
        TranslateAnimation translateAnimation = new TranslateAnimation(tp, (int)(x1 * 0.01), tp, (int)(x2 * 0.01), tp, (int)(y1 * 0.01), tp, (int)(y2 * 0.01));
        if (type == "FS" || type == null) {
            tp = Animation.RELATIVE_TO_SELF;
        } else
        if (type == "TP") {
            tp = Animation.RELATIVE_TO_PARENT;
        } else
        if (type == "EA") {
            tp = Animation.ABSOLUTE;
        }
        translateAnimation.setDuration(time);
        translateAnimation.setRepeatCount(0);
        //translateAnimation.setRepeatMode(Animation.REVERSE);
        //translateAnimation.setZAdjustment(Animation.ZORDER_TOP);//设置永远在最顶端，不被其他控件遮挡
        if (view != null) {
            view.startAnimation(translateAnimation);
        }
        return translateAnimation;
    }
    //旋转
    public static RotateAnimation UIRotate(final View view, Object type, int A, int B, float x, float y, int time) {
        int tp = Animation.RELATIVE_TO_SELF;
        if (type == "FS" || type == null) {
            tp = Animation.RELATIVE_TO_SELF;
        } else
        if (type == "TP") {
            tp = Animation.RELATIVE_TO_PARENT;
        } else
        if (type == "EA") {
            tp = Animation.ABSOLUTE;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(A, B, tp, x , tp, y);
        rotateAnimation.setDuration(time);//设置周期
        rotateAnimation.setRepeatCount(0);//设置次数
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        //启动动画
        view.startAnimation(rotateAnimation);
        return rotateAnimation;
    }
    //收缩
    public static ScaleAnimation UIShrink(final View view, Object type, float x1, float x2, float y1, float y2, float x, float y, int time) {
        int tp = Animation.RELATIVE_TO_PARENT;
        if (type == "FS" || type == null) {
            tp = Animation.RELATIVE_TO_SELF;
        } else if (type == "TP") {
            tp = Animation.RELATIVE_TO_PARENT;
        } else if (type == "EA") {
            tp = Animation.ABSOLUTE;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(x1, x2, y1, y2, tp, x, tp, y);
        scaleAnimation.setDuration(time);
        scaleAnimation.setRepeatCount(0);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setZAdjustment(Animation.ZORDER_TOP);//设置永远在最顶端，不被其他控件遮挡
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
        return scaleAnimation;
	}
    //淡化
    public static AlphaAnimation UIFadein(final View view, int A, int B, int time) {
        AlphaAnimation alphaAnimation = new AlphaAnimation((int)(A * 0.01), (int)(B * 0.01));
        alphaAnimation.setDuration(time);
        alphaAnimation.setRepeatCount(0);
        alphaAnimation.setRepeatMode(Animation.REVERSE);//设置相反运行模式
        alphaAnimation.setFillAfter(true);//设置是否显示动画运行完成后状态
        //启动动画
        view.startAnimation(alphaAnimation);
        return alphaAnimation;
    }
    //缩放
    public static ScaleAnimation UIZoom(final View view, String type, float In, float out, int time) {
        return UIShrink(view, type, In, out, In, out, 0.5f, 0.5f, time);
    };
    //水平
    public static TranslateAnimation UILevel(View view, String type, int In, int out, int time) {
        return UIMove(view, type, In, out, 0, 0, time);
    };
    //垂直
    public static TranslateAnimation UIPlumb(View view, final int In, int out, int time) {
        return UIMove(view, "TP", 0, 0, In, out, time);
    };
    //揭露
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
            }};
        view.setVisibility(View.VISIBLE);
        view.getViewTreeObserver().addOnGlobalLayoutListener(layoutListener);
        return layoutListener;
	}
    //属性动画
    public static ObjectAnimator objectAnimator;
    public static ObjectAnimator ObjectAnimator(View view, String ofProp, int time, String Animationmode, int value1, int value2, boolean repeat, boolean flat, String mode, int frequency) {
        if(Objects.equals(ofProp, "ofFloat")){
        objectAnimator = ObjectAnimator.ofFloat(view, Animationmode, value1, value2);
        }else if(Objects.equals(ofProp, "ofInt")){
        objectAnimator = ObjectAnimator.ofInt(view, Animationmode, value1, value2);
        }
        objectAnimator.setDuration(time);
        objectAnimator.setRepeatCount(frequency);
        if (repeat) {
            objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        }

        if (flat) {
            objectAnimator.setEvaluator(new ArgbEvaluator());
        }

        if (Objects.equals(mode, "") | mode == null) {
            objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        }
        if (Objects.equals(mode, "REVERSE")) {
            objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        }
        //objectAnimator.setInterpolator(new OvershootInterpolator());//动画会超过目标值一些，然后再弹回来
        objectAnimator.start();
        return objectAnimator;
	}
    
    public static ValueAnimator ValueAnimatorAGB(final View view, Object value1, Object value2, int time, int frequency, final Object fillet, final String f) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt((int)value1, (int)value2);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int values = (int) animation.getAnimatedValue();
                    view.setBackgroundDrawable(local.roundBGS(values, fillet, f, 0));
                }
            });
        valueAnimator.setDuration(time);
        valueAnimator.setRepeatCount(frequency);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.start();
        return valueAnimator;
    }
    public static ValueAnimator valueAnimator;
    public static ValueAnimator ValueAnimator(String ofProp, int value1, int value2, int time, int frequency,boolean inter,boolean arg, ValueAnimator.AnimatorUpdateListener set) {

        if(ofProp=="ofInt") {
            valueAnimator = ValueAnimator.ofInt( value1,  value2);
        }else
        if(ofProp=="ofFloat"){
            valueAnimator = ValueAnimator.ofFloat( value1,  value2);
        }
        addUpdateListeners(set, valueAnimator);
        valueAnimator.setDuration(time);
        valueAnimator.setRepeatCount(frequency);
        if(arg){
            valueAnimator.setEvaluator(new ArgbEvaluator());
        }
        if(inter){
            valueAnimator.setInterpolator(new OvershootInterpolator());//动画会超过目标值一些，然后再弹回来
        }
        //valueAnimator.setInterpolator(new LinearInterpolator());//匀速
        valueAnimator.start();
        return valueAnimator;
    }

    public static void addUpdateListeners(final ValueAnimator.AnimatorUpdateListener add, ValueAnimator vt) {
        if (add != null) {
            vt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //int values = (int) animation.getAnimatedValue();
                    add.onAnimationUpdate(animation);
                    }
                });
        }
    }

    /*水波纹*/
    
}
