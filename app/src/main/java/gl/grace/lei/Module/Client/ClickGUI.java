package gl.grace.lei.Module.Client;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Random;
import gl.grace.lei.Module.Hacker.dexLoad;
import gl.grace.lei.Module.interfacer.UI;


public class ClickGUI extends PopupWindow {

    /*
     *简洁的Hud
     *Create at 2025.3.18 19:42
     *Author Thunder
     *QQ[1145145313]
     */
    private static Activity Activity;
    private static LinearLayout LinearLayout;
    private String[] 网易云= {
        "规矩为盘侓为棋世间万法皆可寻从来是疯魔道痴俯仰问阴阳乾坤 百万年筹谋积蓄 待今朝 无极永生",
        "无论最后生疏成什么样子，曾经对你的好都是真的，就算终有一散，也别辜负相遇，希望你不后悔认识我，也是真的快乐过",
        "我们在年少时并不知道,有些乐章,一旦开始,\n唱的就是曲终人散\n不可能的事\n别问别等别期待\n差点忘了,你身边除了我还有别人陪你,所以不会难过,你有很多人可以替代我,而我没有,不过没关系,我本来就是一个人",
        "鱼那么信任水，水却把鱼给煮了；树叶那么信任风，风却把树叶吹落了；我那么信任你，你却把我伤害了…...后来终于知道，把鱼煮了的不是水，而是火；把树叶吹落的不是风，而是秋天；伤害我的不是你，是我的自作多情",
        "I don't look at the moon or you, so you and the moon are all in the dark.\n我不看月亮也不看你，这样你和月亮都蒙在鼓里\nI look at the moon and you, you think I only like the moon, but only the moon knows that I like you.我看月亮也看你，你以为我只喜欢月亮，可只有月亮知道我喜欢你",
        "玫瑰在海里燃烧 我的爱在烈火中绽放.\n𝓡𝓸𝓼𝓮𝓼 𝓫𝓾𝓻𝓷 𝓲𝓷 𝓽𝓱𝓮 𝓼𝓮𝓪 𝓪𝓷𝓭 𝓶𝔂 𝓵𝓸𝓿𝓮 𝓫𝓵𝓸𝓸𝓶𝓼 𝓲𝓷",
        "梦到到一个卖花的，两手空空对我说：“人要先感受幸福，才能看到玫瑰。”"
    };

    private TextView 内容;
    private Random random;
    private LinearLayout 世界;
    private LinearLayout 攻击;
    private LinearLayout 移动;
    private LinearLayout 渲染;
    private LinearLayout 脚本;
    private LinearLayout 界面;
    private LinearLayout fu;
    private LinearLayout 世界_;

    private LinearLayout 攻击_;

    private LinearLayout 移动_;

    private LinearLayout 渲染_;

    private LinearLayout 脚本_;

    private LinearLayout 界面_;

    public ClickGUI(Activity activity) {
        Activity = activity;
        //核心
        LinearLayout = new LinearLayout(activity);
        LinearLayout.setLayoutParams(new LayoutParams((int)(getMaxWidth() * 0.66f), (int)(getMinHeight() * 0.68f)));
        LinearLayout.setGravity(Gravity.CENTER);
        LinearLayout.setBackground(Drawable(0x8c909090, 30));
        setAnimationStyle(android.R.style.Animation_Translucent);
        setFocusable(false);
        setTouchable(true);
        setWidth((int)(getMaxWidth() * 0.66f));
        setHeight((int)(getMinHeight() * 0.68f));
        setContentView(LinearLayout);
        //核心

        LinearLayout Main = new LinearLayout(activity);
        Main.setLayoutParams(new LayoutParams((int)(getMaxWidth() * 0.66f), (int)(getMinHeight() * 0.68f)));
        Main.setOrientation(0);
        Main.setGravity(Gravity.CENTER);
        Main.setPadding(15, 15, 15, 15);
        LinearLayout.addView(Main);

        LinearLayout menu = new LinearLayout(activity);
        menu.setLayoutParams(new LayoutParams((int)(getMaxWidth() * 0.17f), (int)(getMinHeight() * 0.65f)));
        menu.setBackground(Drawable(0xDD484848, 25));
        menu.setOrientation(1);
        menu.setGravity(Gravity.CENTER | Gravity.TOP);
        Main.addView(menu);

        添加间隔(menu, 0, 15, 0, 0);

        LinearLayout edit = new LinearLayout(activity);
        edit.setLayoutParams(new LayoutParams((int)(getMaxWidth() * 0.15f), (int)(getMinHeight() * 0.065f)));
        edit.setBackground(Drawable(0x8Cffffff, 15));
        edit.setGravity(Gravity.LEFT | Gravity.CENTER);
        menu.addView(edit);

        TextView title = new TextView(activity);
        title.setHint("搜索...");
        title.setPadding(15, 5, 15, 5);
        title.setTextSize(12);
        title.setGravity(Gravity.LEFT | Gravity.CENTER);
        edit.addView(title);

        添加间隔(menu, 0, 15, 0, 0);

        世界 = 添加按钮(menu, "世界", true, new OnClickListener(){
                @Override
                public void onClick(View va) {
                    世界.setBackground(Drawable(0xddffffff, 15));
                    攻击.setBackground(Drawable(0x88ffffff, 15));
                    移动.setBackground(Drawable(0x88ffffff, 15));
                    渲染.setBackground(Drawable(0x88ffffff, 15));
                    脚本.setBackground(Drawable(0x88ffffff, 15));
                    界面.setBackground(Drawable(0x88ffffff, 15));
                    世界_.setVisibility(View.VISIBLE);
                    攻击_.setVisibility(View.GONE);
                    移动_.setVisibility(View.GONE);
                    渲染_.setVisibility(View.GONE);
                    脚本_.setVisibility(View.GONE);
                    界面_.setVisibility(View.GONE);
                }
            });
        攻击 = 添加按钮(menu, "攻击", false, new OnClickListener(){
                @Override
                public void onClick(View va) {
                    世界.setBackground(Drawable(0x88ffffff, 15));
                    攻击.setBackground(Drawable(0xddffffff, 15));
                    移动.setBackground(Drawable(0x88ffffff, 15));
                    渲染.setBackground(Drawable(0x88ffffff, 15));
                    脚本.setBackground(Drawable(0x88ffffff, 15));
                    界面.setBackground(Drawable(0x88ffffff, 15));
                    世界_.setVisibility(View.GONE);
                    攻击_.setVisibility(View.VISIBLE);
                    移动_.setVisibility(View.GONE);
                    渲染_.setVisibility(View.GONE);
                    脚本_.setVisibility(View.GONE);
                    界面_.setVisibility(View.GONE);
                }
            });
        移动 = 添加按钮(menu, "移动", false, new OnClickListener(){
                @Override
                public void onClick(View va) {
                    世界.setBackground(Drawable(0x88ffffff, 15));
                    攻击.setBackground(Drawable(0x88ffffff, 15));
                    移动.setBackground(Drawable(0xddffffff, 15));
                    渲染.setBackground(Drawable(0x88ffffff, 15));
                    脚本.setBackground(Drawable(0x88ffffff, 15));
                    界面.setBackground(Drawable(0x88ffffff, 15));
                    世界_.setVisibility(View.GONE);
                    攻击_.setVisibility(View.GONE);
                    移动_.setVisibility(View.VISIBLE);
                    渲染_.setVisibility(View.GONE);
                    脚本_.setVisibility(View.GONE);
                    界面_.setVisibility(View.GONE);
                }
            });
        渲染 = 添加按钮(menu, "渲染", false, new OnClickListener(){
                @Override
                public void onClick(View va) {
                    世界.setBackground(Drawable(0x88ffffff, 15));
                    攻击.setBackground(Drawable(0x88ffffff, 15));
                    移动.setBackground(Drawable(0x88ffffff, 15));
                    渲染.setBackground(Drawable(0xddffffff, 15));
                    脚本.setBackground(Drawable(0x88ffffff, 15));
                    界面.setBackground(Drawable(0x88ffffff, 15));
                    世界_.setVisibility(View.GONE);
                    攻击_.setVisibility(View.GONE);
                    移动_.setVisibility(View.GONE);
                    渲染_.setVisibility(View.VISIBLE);
                    脚本_.setVisibility(View.GONE);
                    界面_.setVisibility(View.GONE);
                }
            });
        脚本 = 添加按钮(menu, "脚本", false, new OnClickListener(){
                @Override
                public void onClick(View va) {
                    世界.setBackground(Drawable(0x88ffffff, 15));
                    攻击.setBackground(Drawable(0x88ffffff, 15));
                    移动.setBackground(Drawable(0x88ffffff, 15));
                    渲染.setBackground(Drawable(0x88ffffff, 15));
                    脚本.setBackground(Drawable(0xddffffff, 15));
                    界面.setBackground(Drawable(0x88ffffff, 15));
                    世界_.setVisibility(View.GONE);
                    攻击_.setVisibility(View.GONE);
                    移动_.setVisibility(View.GONE);
                    渲染_.setVisibility(View.GONE);
                    脚本_.setVisibility(View.VISIBLE);
                    界面_.setVisibility(View.GONE);
                }
            });
        界面 = 添加按钮(menu, "界面", false, new OnClickListener(){
                @Override
                public void onClick(View va) {
                    世界.setBackground(Drawable(0x88ffffff, 15));
                    攻击.setBackground(Drawable(0x88ffffff, 15));
                    移动.setBackground(Drawable(0x88ffffff, 15));
                    渲染.setBackground(Drawable(0x88ffffff, 15));
                    脚本.setBackground(Drawable(0x88ffffff, 15));
                    界面.setBackground(Drawable(0xddffffff, 15));
                    世界_.setVisibility(View.GONE);
                    攻击_.setVisibility(View.GONE);
                    移动_.setVisibility(View.GONE);
                    渲染_.setVisibility(View.GONE);
                    脚本_.setVisibility(View.GONE);
                    界面_.setVisibility(View.VISIBLE);
                }
            });

        TextView 作者的话 = new TextView(activity);
        作者的话.setText("作者的话");
        作者的话.setTextColor(0xFFffffff);
        作者的话.setTextSize(12);
        作者的话.setGravity(Gravity.CENTER | Gravity.CENTER);
        menu.addView(作者的话);

        ScrollView ScrollView = new ScrollView(Activity);
        ScrollView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        menu.addView(ScrollView);

        LinearLayout 每日一言 = new LinearLayout(activity);
        每日一言.setOrientation(1);
        每日一言.setGravity(Gravity.CENTER);
        ScrollView.addView(每日一言);
        random = new Random();
        内容 = new TextView(activity);
        内容.setTextColor(0xFFffffff);
        内容.setTextSize(10);
        内容.setGravity(Gravity.CENTER | Gravity.LEFT);
        每日一言.addView(内容);

        fu = new LinearLayout(activity);
        fu.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        fu.setOrientation(1);
        Main.addView(fu);
        世界_ = 世界(fu);
        世界_.setVisibility(View.VISIBLE);
        攻击_ = 攻击(fu);
        攻击_.setVisibility(View.GONE);
        移动_ = 移动(fu);
        移动_.setVisibility(View.GONE);
        渲染_ = 渲染(fu);
        渲染_.setVisibility(View.GONE);
        脚本_ = 脚本(fu);
        脚本_.setVisibility(View.GONE);
        界面_ = 界面(fu);
        界面_.setVisibility(View.GONE);
    }
    public void showAtLocation() {
        内容.setText(网易云[random.nextInt(网易云.length)]);
        showAtLocation(LinearLayout, Gravity.CENTER | Gravity.CENTER, 0, 0);
    }
    private int getMaxWidth() {
        return Math.max(local.W(), local.H());
    }
    private int getMinHeight() {
        return Math.min(local.W(), local.H());
    }
    private GradientDrawable Drawable(int color, int cor) {
        GradientDrawable GradientDrawable = new GradientDrawable();
        GradientDrawable.setColor(color);
        GradientDrawable.setCornerRadius(cor);
        return GradientDrawable;
    }
    private void 添加间隔(LinearLayout v, int l, int t, int r, int b) {
        LinearLayout 间隔 = new LinearLayout(Activity);
        间隔.setPadding(l, t, r, b);
        v.addView(间隔);
    }
    private LinearLayout 添加按钮(final LinearLayout v, String 按钮, boolean 状态, final OnClickListener click) {
        添加间隔(v, 0, 5, 0, 5);
        final LinearLayout edit = new LinearLayout(Activity);
        edit.setLayoutParams(new LayoutParams((int)(getMaxWidth() * 0.15f), (int)(getMinHeight() * 0.065f)));
        if (状态) {
            edit.setBackground(Drawable(0xddffffff, 15));
        } else {
            edit.setBackground(Drawable(0x88ffffff, 15));
        }
        edit.setGravity(Gravity.CENTER | Gravity.CENTER);
        v.addView(edit);
        TextView title = new TextView(Activity);
        title.setText(按钮);
        title.setTextColor(0xffffffff);
        title.setPadding(15, 5, 15, 5);
        title.setTextSize(14);
        title.setGravity(Gravity.CENTER | Gravity.CENTER);
        edit.addView(title);
        edit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View va) {
                    click.onClick(v);
                }
            });
        return edit;
    }
    private void addSwitch(final LinearLayout v, String func, final OnClickListener click, boolean 调节, final OnClickListener tjclick) {
        添加间隔(v, 0, 10, 0, 0);
        LinearLayout 列表 = new LinearLayout(Activity);
        列表.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        列表.setOrientation(0);
        列表.setBackground(Drawable(0x88ffffff, 15));
        列表.setGravity(Gravity.CENTER);
        v.addView(列表);
        TextView 标题 = new TextView(Activity);
        标题.setText(func);
        标题.setTextColor(0xFFffffff);
        标题.setTextSize(13);
        标题.setPadding(15, 15, 15, 15);
        标题.setShadowLayer(1, 0, 0, 0xFFFFFFFF);
        标题.setGravity(Gravity.LEFT | Gravity.CENTER);
        列表.addView(标题);
        LinearLayout 开关 = new LinearLayout(Activity);
        开关.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        开关.setGravity(Gravity.CENTER | Gravity.RIGHT);
        开关.setPadding(0,0,20,0);
        列表.addView(开关);
        if (调节) {
            LinearLayout 调 = new LinearLayout(Activity);
            调.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            调.setGravity(Gravity.CENTER);
            调.setBackground(Drawable(0x8Cffffff, 30));
            开关.addView(调);
            TextView 齿轮 = new TextView(Activity);
            齿轮.setText("⚙️️");
            齿轮.setTextColor(0xFFffffff);
            齿轮.setTextSize(14);
            齿轮.setPadding(10, 10, 10, 10);
            齿轮.setShadowLayer(1, 0, 0, 0xFFFFFFFF);
            齿轮.setGravity(Gravity.CENTER);
            调.addView(齿轮);
            调.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View va) {
                        tjclick.onClick(v);
                    }
                });
        }
        开关.addView(new MSwitch(Activity).onClick(click));
        添加间隔(v, 0, 10, 0, 0);
    }
    private LinearLayout 世界(LinearLayout v) {
        LinearLayout function = new LinearLayout(Activity);
        function.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        function.setOrientation(1);
        v.addView(function);
        TextView 标题 = new TextView(Activity);
        标题.setText("世界");
        标题.setTextColor(0xFFffffff);
        标题.setTextSize(18);
        标题.setPadding(25, 15, 15, 15);
        标题.setShadowLayer(1, 0, 0, 0xFFFFFFFF);
        标题.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        标题.setGravity(Gravity.LEFT | Gravity.CENTER);
        function.addView(标题);
        ScrollView ScrollView = new ScrollView(Activity);
        ScrollView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        function.addView(ScrollView);
        LinearLayout 功能 = new LinearLayout(Activity);
        功能.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        功能.setOrientation(1);
        功能.setPadding(25, 0, 0, 0);
        ScrollView.addView(功能);
        addSwitch(功能, "自动破坏", null, false, null);
        addSwitch(功能, "AntiWeb", null, false, null);
        addSwitch(功能, "范围破坏", null, false, null);
        addSwitch(功能, "点击破坏", null, false, null);
        addSwitch(功能, "点击传送", null, false, null);
        addSwitch(功能, "飞行状态", null, false, null);
        return function;
    }
    private LinearLayout 攻击(LinearLayout v) {
        LinearLayout function = new LinearLayout(Activity);
        function.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        function.setOrientation(1);
        v.addView(function);
        TextView 标题 = new TextView(Activity);
        标题.setText("攻击");
        标题.setTextColor(0xFFffffff);
        标题.setTextSize(18);
        标题.setPadding(25, 15, 15, 15);
        标题.setShadowLayer(1, 0, 0, 0xFFFFFFFF);
        标题.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        标题.setGravity(Gravity.LEFT | Gravity.CENTER);
        function.addView(标题);
        ScrollView ScrollView = new ScrollView(Activity);
        ScrollView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        function.addView(ScrollView);
        LinearLayout 功能 = new LinearLayout(Activity);
        功能.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        功能.setOrientation(1);
        功能.setPadding(25, 0, 0, 0);
        ScrollView.addView(功能);
        addSwitch(功能, "杀戮光环", new View.OnClickListener(){
                @Override
                private boolean a;
                public void onClick(View va) {
                    a = !a;
                    if (a) {
                        dexLoad.ArrayList.addArrav("杀戮光环", "Multi");
                    } else {
                        dexLoad.ArrayList.removeArrav("杀戮光环", "Multi");
                    }
                }
            }, false, null);
        addSwitch(功能, "自动瞄准", new View.OnClickListener(){
                @Override
                private boolean a;
                public void onClick(View va) {
                    a = !a;
                    if (a) {
                        dexLoad.ArrayList.addArrav("自动瞄准");
                    } else {
                        dexLoad.ArrayList.removeArrav("自动瞄准");
                    }
                }
            }, false, null);
        addSwitch(功能, "百米大刀", new View.OnClickListener(){
                @Override
                private boolean a;
                public void onClick(View va) {
                    a = !a;
                    if (a) {
                        dexLoad.ArrayList.addArrav("百米大刀", "Multi");
                    } else {
                        dexLoad.ArrayList.removeArrav("百米大刀", "Multi");
                    }
                }
            }, false, null);
        addSwitch(功能, "战斗机器人", new View.OnClickListener(){
                @Override
                private boolean a;
                public void onClick(View va) {
                    a = !a;
                    if (a) {
                        dexLoad.ArrayList.addArrav("战斗机器人");
                    } else {
                        dexLoad.ArrayList.removeArrav("战斗机器人");
                    }
                }
            }, false, null);
        addSwitch(功能, "分离摄像机", new View.OnClickListener(){
                @Override
                private boolean a;
                public void onClick(View va) {
                    a = !a;
                    if (a) {
                        dexLoad.ArrayList.addArrav("分离摄像机");
                    } else {
                        dexLoad.ArrayList.removeArrav("分离摄像机");
                    }
                }
            }, false, null);
        addSwitch(功能, "无敌模式", new View.OnClickListener(){
                @Override
                private boolean a;
                public void onClick(View va) {
                    a = !a;
                    if (a) {
                        dexLoad.ArrayList.addArrav("无敌模式", "HYT");
                    } else {
                        dexLoad.ArrayList.removeArrav("无敌模式", "HYT");
                    }
                }
            }, false, null);
        return function;
    }
    private LinearLayout 移动(LinearLayout v) {
        LinearLayout function = new LinearLayout(Activity);
        function.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        function.setOrientation(1);
        v.addView(function);
        TextView 标题 = new TextView(Activity);
        标题.setText("移动");
        标题.setTextColor(0xFFffffff);
        标题.setTextSize(18);
        标题.setPadding(25, 15, 15, 15);
        标题.setShadowLayer(1, 0, 0, 0xFFFFFFFF);
        标题.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        标题.setGravity(Gravity.LEFT | Gravity.CENTER);
        function.addView(标题);
        ScrollView ScrollView = new ScrollView(Activity);
        ScrollView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        function.addView(ScrollView);
        LinearLayout 功能 = new LinearLayout(Activity);
        功能.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        功能.setOrientation(1);
        功能.setPadding(25, 0, 0, 0);
        ScrollView.addView(功能);
        addSwitch(功能, "平飞", null, false, null);
        addSwitch(功能, "踏空", null, false, null);
        addSwitch(功能, "兔子跳", null, false, null);
        addSwitch(功能, "自伤飞行", null, false, null);
        return function;
    }
    private LinearLayout 渲染(LinearLayout v) {
        LinearLayout function = new LinearLayout(Activity);
        function.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        function.setOrientation(1);
        v.addView(function);
        TextView 标题 = new TextView(Activity);
        标题.setText("渲染");
        标题.setTextColor(0xFFffffff);
        标题.setTextSize(18);
        标题.setPadding(25, 15, 15, 15);
        标题.setShadowLayer(1, 0, 0, 0xFFFFFFFF);
        标题.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        标题.setGravity(Gravity.LEFT | Gravity.CENTER);
        function.addView(标题);
        ScrollView ScrollView = new ScrollView(Activity);
        ScrollView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        function.addView(ScrollView);
        LinearLayout 功能 = new LinearLayout(Activity);
        功能.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        功能.setOrientation(1);
        功能.setPadding(25, 0, 0, 0);
        ScrollView.addView(功能);
        addSwitch(功能, "绘制", null, false, null);
        addSwitch(功能, "大陀螺", null, false, null);
        addSwitch(功能, "缓慢挥手", null, false, null);
        addSwitch(功能, "攻击特效", null, false, null);
        return function;
    }
    private LinearLayout 脚本(LinearLayout v) {
        LinearLayout function = new LinearLayout(Activity);
        function.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        function.setOrientation(1);
        v.addView(function);
        TextView 标题 = new TextView(Activity);
        标题.setText("脚本");
        标题.setTextColor(0xFFffffff);
        标题.setTextSize(18);
        标题.setPadding(25, 15, 15, 15);
        标题.setShadowLayer(1, 0, 0, 0xFFFFFFFF);
        标题.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        标题.setGravity(Gravity.LEFT | Gravity.CENTER);
        function.addView(标题);
        ScrollView ScrollView = new ScrollView(Activity);
        ScrollView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        function.addView(ScrollView);
        LinearLayout 功能 = new LinearLayout(Activity);
        功能.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        功能.setOrientation(1);
        功能.setPadding(25, 0, 0, 0);
        ScrollView.addView(功能);
        addSwitch(功能, "退出", null, false, null);
        return function;
    }
    private LinearLayout 界面(LinearLayout v) {
        final UI UI = new UI(Activity);
        LinearLayout function = new LinearLayout(Activity);
        function.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        function.setOrientation(1);
        v.addView(function);
        TextView 标题 = new TextView(Activity);
        标题.setText("界面");
        标题.setTextColor(0xFFffffff);
        标题.setTextSize(18);
        标题.setPadding(25, 15, 15, 15);
        标题.setShadowLayer(1, 0, 0, 0xFFFFFFFF);
        标题.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        标题.setGravity(Gravity.LEFT | Gravity.CENTER);
        function.addView(标题);
        ScrollView ScrollView = new ScrollView(Activity);
        ScrollView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        function.addView(ScrollView);
        LinearLayout 功能 = new LinearLayout(Activity);
        功能.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int)(getMinHeight() * 0.65f)));
        功能.setOrientation(1);
        功能.setPadding(25, 0, 0, 0);
        ScrollView.addView(功能);
        addSwitch(功能, "开启HUD", new View.OnClickListener(){
                @Override
                private boolean a;
                public void onClick(View va) {
                    a = !a;
                    if (a) {
                        dexLoad.ArrayList.showAtLocation();
                    } else {
                        dexLoad.ArrayList.dismiss();
                    }
                }
            }, true, new OnClickListener(){
                @Override
                public void onClick(View va) {
                    UI.show();
                }
            });
        addSwitch(功能, "开启Notice", null, false, null);
        return function;
    }
}
