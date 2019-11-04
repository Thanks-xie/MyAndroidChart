package cn.xie.myandroidchart.activity;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.xie.myandroidchart.R;

/**
 * @author xiejinbo
 * @date 2019/11/4 0004 11:34
 */
public class BaseActivity extends Activity {
    private ImageView navBack;
    private TextView navTitle;

    /**
     * 初始化标题栏
     * @param isshow 返回键是否显示
     * @param title title值
     */
    protected void initNavBar(boolean isshow,String title){
        navBack = findViewById(R.id.nav_back);
        navTitle = findViewById(R.id.nav_title);

        navTitle.setText(title);
        navBack.setVisibility(isshow? View.VISIBLE:View.GONE);

        navBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


}
