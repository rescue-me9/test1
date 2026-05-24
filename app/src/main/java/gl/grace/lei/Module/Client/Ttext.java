package gl.grace.lei.Module.Client;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;

import java.util.Objects;


public class Ttext extends TextView{
    private Context ct1;
    public Ttext(Context context){
        super(context);
        ct1=context;
    }
    @SuppressLint("RtlHardcoded")
    /*重心*/
    public Ttext gravity(String gravity){
        if(Objects.equals(gravity, "LT")){
            setGravity(Gravity.LEFT|Gravity.TOP);
        }else if(Objects.equals(gravity, "LC")){
            setGravity(Gravity.LEFT|Gravity.CENTER);
        }else if(Objects.equals(gravity, "LB")){
            setGravity(Gravity.LEFT|Gravity.BOTTOM);
        }else if(Objects.equals(gravity, "CT")){
            setGravity(Gravity.CENTER|Gravity.TOP);
        }else if(Objects.equals(gravity, "CC")){
            setGravity(Gravity.CENTER);
        }else if(Objects.equals(gravity, "CB")){
            setGravity(Gravity.CENTER|Gravity.TOP);
        }else if(Objects.equals(gravity, "RT")){
            setGravity(Gravity.RIGHT|Gravity.TOP);
        }else if(Objects.equals(gravity, "RC")){
            setGravity(Gravity.RIGHT|Gravity.CENTER);
        }else if(Objects.equals(gravity, "RB")){
            setGravity(Gravity.RIGHT|Gravity.BOTTOM);
		}
        return this;
    }
    /*文本*/
    public Ttext Text(Object text){
        if(text instanceof android.text.Spanned){
            setText((android.text.Spanned)(text));
        }else{
            setText((String)(text));
        }
        return this;
    }
    /*大小*/
    public Ttext Size(int size){
            setTextSize(size);
        return this;
    }
    /*颜色*/
    public Ttext Color(String color){
        if(color!=null){
            setTextColor(hexColor(color));
		}
        return this;
    }
    public Ttext Blur(final int r){
        final View view=this;
        post(new Runnable() {
            @Override
            public void run() {
                setBackground(BlurUtil.Blur(ct1,view,r));
            }
        });
        return this;
    }
    /*父组件*/
    public Ttext children(View view){
        if (view instanceof LinearLayout){
            ((LinearLayout) view).addView(this);
        }if (view instanceof ScrollView){
            ((ScrollView) view).addView(this);
        }if (view instanceof FrameLayout){
            ((FrameLayout) view).addView(this);
        }
        return this;
    }
	private static int hexColor(String c) {
        return android.graphics.Color.parseColor(c);
    }
}
