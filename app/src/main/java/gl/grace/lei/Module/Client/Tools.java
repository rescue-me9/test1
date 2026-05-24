package gl.grace.lei.Module.Client;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Tools {
    
    public static String[][] colors =new String[][]{
        {"功能","</font><font color=#ffffff>"},
        {"状态","</font><font color=#929292>"},
        {",","</font><font color=#acacac>"}
    };
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
    private static String join(Iterator it, String str) {
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
    private static String join(Collection collection, String str) {
        return join(collection.iterator(), str);
    }
    private static String join(String[] strArr, String str) {
        return join(Arrays.asList(strArr), str);
    }
    public static android.text.Spanned FontColor(String text) {
        for (String[] strings : colors) {
            text = join(text.split(strings[0]), strings[1]);
        }
        return android.text.Html.fromHtml(text);
    }
}
