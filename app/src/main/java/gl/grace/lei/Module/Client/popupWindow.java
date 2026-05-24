package gl.grace.lei.Module.Client;

import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import java.util.Objects;

public class popupWindow extends PopupWindow {
    public popupWindow SF(boolean fa) {
        setFocusable(fa);
        return this;
    }
    public popupWindow ST(boolean ta) {
        setTouchable(ta);
        return this;
    }
    public popupWindow SC(boolean ca) {
        setClippingEnabled(ca);
        return this;
    }
    public popupWindow SO(boolean oa) {
        setOutsideTouchable(oa);
        return this;
    }
    public popupWindow Anim(String anim) {
        if (anim == null || anim.equals("Di")) {
            setAnimationStyle(android.R.style.Animation_Dialog);
        } else if (anim.equals("In")) {
            setAnimationStyle(android.R.style.Animation_InputMethod);
        } else if (anim.equals("To")) {
            setAnimationStyle(android.R.style.Animation_Toast);
        } else if (anim.equals("Tr")) {
            setAnimationStyle(android.R.style.Animation_Translucent);
        } else if (anim.equals("Ac")) {
            setAnimationStyle(android.R.style.Animation_Activity);
        }
        return this;
    }
    public popupWindow gravity(View view, String gravity, Object X, Object Y) {
        if (view instanceof LinearLayout) {
            setContentView((LinearLayout)(view));
        } else if (view instanceof FrameLayout) {
            setContentView((FrameLayout)(view));
        }
        if (Objects.equals(gravity, "CT")) {
            showAtLocation(view, Gravity.CENTER | Gravity.TOP, (Integer) X, (Integer) Y);
        } else if (Objects.equals(gravity, "CC")) {
            showAtLocation(view, Gravity.CENTER, (Integer) X, (Integer) Y);
        } else if (Objects.equals(gravity, "CB")) {
            showAtLocation(view, Gravity.CENTER | Gravity.BOTTOM, (Integer) X, (Integer) Y);
        } else if (Objects.equals(gravity, "LT")) {
            showAtLocation(view, Gravity.LEFT | Gravity.TOP, (Integer) X, (Integer) Y);
        } else if (Objects.equals(gravity, "LC")) {
            showAtLocation(view, Gravity.LEFT | Gravity.CENTER, (Integer) X, (Integer) Y);
        } else if (Objects.equals(gravity, "LB")) {
            showAtLocation(view, Gravity.LEFT | Gravity.BOTTOM, (Integer) X, (Integer) Y);
        } else if (Objects.equals(gravity, "RT")) {
            showAtLocation(view, Gravity.RIGHT | Gravity.TOP, (Integer) X, (Integer) Y);
        } else if (Objects.equals(gravity, "RC")) {
            showAtLocation(view, Gravity.RIGHT | Gravity.CENTER, (Integer) X, (Integer) Y);
        } else if (Objects.equals(gravity, "RB")) {
            showAtLocation(view, Gravity.RIGHT | Gravity.BOTTOM, (Integer) X, (Integer) Y);
        }
        return this;
    }
    public popupWindow WH(Object W, Object H) {        
        setWidth((Integer) W);
        setHeight((Integer) H);
        return this;
    }
}
