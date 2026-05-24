package gl.grace.lei;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import gl.grace.lei.Module.Client.Tools;
import gl.grace.lei.Module.Hacker.dexLoad;

public class MainActivity extends Activity {
//2025年 9.6 菜鸡开源
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setSubtitle("Create in GraceLei. ");
        LinearLayout layout = new LinearLayout(this);
        //layout.setBackgroundColor(0xFF5D5D5D);
        setContentView(layout);
        dexLoad.load(this);
        //Tools.hideStatusBar(this);
    }

}
