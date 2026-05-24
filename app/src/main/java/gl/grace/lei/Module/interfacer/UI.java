package gl.grace.lei.Module.interfacer;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import gl.grace.lei.Module.Client.popupWindow;
import gl.grace.lei.Module.Hacker.dexLoad;

public class UI {
    private static Activity activity;
    private popupWindow DPopupWindow;
	public static String Simple;

    public UI(Activity Activity) {
        activity = Activity;
		Simple = this.getClass().getSimpleName();
        DPopupWindow = new popupWindow().Anim("To").SF(true).ST(true).WH((int)(absWidth() * 0.7f), LayoutParams.WRAP_CONTENT);
        DPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        LinearLayout layout = new LinearLayout(Activity);
        layout.setLayoutParams(new LayoutParams((int)(absWidth() * 0.7f), LayoutParams.WRAP_CONTENT));
        layout.setGravity(Gravity.CENTER | Gravity.CENTER);
        layout.setBackground(Drawable(0xFFF6F6F6, 20, 2, 0xFFFDCDCDC));
        layout.setOrientation(1);

		TextView Name = new TextView(Activity);
		Name.setText(Simple);
		Name.setTextSize(18);
		Name.setPadding(0, 15, 0, 15);
		Name.setGravity(Gravity.CENTER);
		layout.addView(Name);

		final TextView Fov = new TextView(Activity);
		Fov.setText("渐变速度: 5000");
		Fov.setTextSize(14);
		Fov.setPadding(15, 15, 15, 15);
		Fov.setGravity(Gravity.CENTER | Gravity.LEFT);
		layout.addView(Fov);

		SeekBar SeekBar2 = new SeekBar(activity);
        SeekBar2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        SeekBar2.setMin(3000);
        SeekBar2.setMax(10000);
        SeekBar2.setProgress(5000);
		layout.addView(SeekBar2);

		SeekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    Fov.setText("渐变速度: " + i);
                    dexLoad.ArrayList.colorAnimator.setDuration(i);
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
            
        final TextView 间隔 = new TextView(Activity);
        间隔.setText("渐变间隔: 150");
        间隔.setTextSize(14);
        间隔.setPadding(15, 15, 15, 15);
        间隔.setGravity(Gravity.CENTER | Gravity.LEFT);
        layout.addView(间隔);

        SeekBar SeekBar3 = new SeekBar(activity);
        SeekBar3.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        SeekBar3.setMin(10);
        SeekBar3.setMax(500);
        SeekBar3.setProgress(150);
        layout.addView(SeekBar3);

        SeekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    间隔.setText("渐变间隔: " + i);
                    dexLoad.ArrayList.speed=(i);
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
            
		final CheckBox shortcuts = new CheckBox(activity);
		shortcuts.setText("单文本显示");
		shortcuts.setGravity(Gravity.CENTER | Gravity.LEFT);
		shortcuts.setTextSize(14);
        shortcuts.setChecked(true);
		layout.addView(shortcuts);
        final CheckBox shortcuts1 = new CheckBox(activity);
        shortcuts1.setText("线条显示");
        shortcuts1.setGravity(Gravity.CENTER | Gravity.LEFT);
        shortcuts1.setTextSize(14);
		layout.addView(shortcuts1);
        final CheckBox shortcuts2 = new CheckBox(activity);
        shortcuts2.setText("双线条显示");
        shortcuts2.setGravity(Gravity.CENTER | Gravity.LEFT);
        shortcuts2.setTextSize(14);
		layout.addView(shortcuts2);
        CheckBox shortcuts3 = new CheckBox(activity);
        shortcuts3.setText("背景颜色");
        shortcuts3.setGravity(Gravity.CENTER | Gravity.LEFT);
        shortcuts3.setTextSize(14);
		layout.addView(shortcuts3);
        CheckBox shortcuts4 = new CheckBox(activity);
        shortcuts4.setText("字体设置");
        shortcuts4.setGravity(Gravity.CENTER | Gravity.LEFT);
        shortcuts4.setTextSize(14);
		layout.addView(shortcuts4);

		shortcuts.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
                    shortcuts.setChecked(true);
					shortcuts1.setChecked(false);
                    shortcuts2.setChecked(false);
                    dexLoad.ArrayList.text = true;
                    dexLoad.ArrayList.line = false;
                    dexLoad.ArrayList.bilateralLine = false;
				}
			});
        shortcuts1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    shortcuts.setChecked(false);
                    shortcuts1.setChecked(true);
                    shortcuts2.setChecked(false);
                    dexLoad.ArrayList.text = false;
                    dexLoad.ArrayList.line = true;
                    dexLoad.ArrayList.bilateralLine = false;
                }
			});
        shortcuts2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    shortcuts.setChecked(false);
                    shortcuts1.setChecked(false);
                    shortcuts2.setChecked(true);
                    dexLoad.ArrayList.text = false;
                    dexLoad.ArrayList.line = false;
                    dexLoad.ArrayList.bilateralLine = true;
                }
			});
        shortcuts3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    dexLoad.ArrayList.background = !dexLoad.ArrayList.background;
                }
			});
		LinearLayout buttonView = new LinearLayout(Activity);
        buttonView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        buttonView.setGravity(Gravity.CENTER | Gravity.RIGHT);
		buttonView.setPadding(15, 15, 40, 15);
		layout.addView(buttonView);

		LinearLayout button = new LinearLayout(Activity);
        button.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		button.setPadding(15, 10, 40, 15);
		buttonView.addView(button);

		TextView Click = new TextView(Activity);
		Click.setText("确定");
		Click.setTextSize(14);
		Click.setGravity(Gravity.CENTER);
		button.addView(Click);
		DPopupWindow.setContentView(layout);



		button.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					DPopupWindow.dismiss();
				}
			});





    }
    static GradientDrawable Drawable(int color, int cor, int str, int s) {
        GradientDrawable GradientDrawable = new GradientDrawable();
        GradientDrawable.setColor(color);
        GradientDrawable.setCornerRadius(cor);
		GradientDrawable.setStroke(str, s);
        return GradientDrawable;
    }
    public void show() {
        DPopupWindow.showAtLocation(DPopupWindow.getContentView(), Gravity.CENTER | Gravity.CENTER, 0, 0);
    }

	static int absWidth() {
		return Math.max(getWindowsWidth(), getWindowsHeight());
	}

	static int absHeight() {
		return Math.min(getWindowsWidth(), getWindowsHeight());
	}

	static int getWindowsWidth() {
        return activity.getResources().getDisplayMetrics().widthPixels;
    }

    static int getWindowsHeight() {
        return activity.getResources().getDisplayMetrics().heightPixels;
    }

}
