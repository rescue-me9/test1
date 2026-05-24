package gl.grace.lei.Module.Hacker;

import android.app.Activity;
import android.os.Handler;
import gl.grace.lei.Module.Client.ArrayList;
import gl.grace.lei.Module.Client.SuspendClick;
import gl.grace.lei.Module.Client.Notice;
import gl.grace.lei.Module.Client.ClickGUI;
import gl.grace.lei.Module.Client.MoveButton;

public class dexLoad {

    public static ArrayList ArrayList;
    public static SuspendClick SuspendClick;
    public static Notice Notice;
    public static ClickGUI ClickGUI;

    public static void load(final Activity activity) {
        new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ArrayList = new ArrayList(activity);
                    SuspendClick = new SuspendClick(activity);
                    Notice = new Notice(activity);
                    ClickGUI = new ClickGUI(activity);
                    new MoveButton(activity,"Killaura",null).showView();
                    
                    SuspendClick.showAtLocation();
                }
            }, 1000);
    }


}
