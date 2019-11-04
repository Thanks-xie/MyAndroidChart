package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AndroidLineChartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_line_chart);
        initNavBar(true,"LineChart");
    }

    /**
     * LineChart之基础折线图
     * @param view
     */
    public void onLineChartBaseClick(View view) {
        Intent intent = new Intent(this,LineChartBaseActivity.class);
        startActivity(intent);
    }
}
