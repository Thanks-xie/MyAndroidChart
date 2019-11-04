package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AndroidBarChartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_bar_chart);
        initNavBar(true,"BarChart");
    }

    /**
     * BarChart之基础直方图
     * @param view
     */
    public void onBarChartBaseClick(View view) {
        Intent intent = new Intent(this,BarChartBaseActivity.class);
        startActivity(intent);
    }
}
