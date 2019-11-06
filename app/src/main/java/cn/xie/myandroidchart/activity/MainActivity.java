package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Android图表之LineChart
     * @param view
     */
    public void onLineChartClick(View view) {
        Intent intent = new Intent(this,AndroidLineChartActivity.class);
        startActivity(intent);
    }

    /**
     * Android图表之BarChart
     * @param view
     */
    public void onBarChartClick(View view) {
        Intent intent = new Intent(this,AndroidBarChartActivity.class);
        startActivity(intent);
    }

    /**
     * Android3D之指南针
     * @param view
     */
    public void on3DWordClick(View view) {
        Intent intent = new Intent(this,Android3DCompassActivity.class);
        startActivity(intent);
    }

    /**
     * Android3D之IChartJS
     * @param view
     */
    public void onIChartJSClick(View view) {
        Intent intent = new Intent(this,AndroidIChartJSActivity.class);
        startActivity(intent);
    }

    /**
     * 基于IChartJS实现Android图表
     * @param view
     */
    public void onIChartJSListClick(View view) {
        Intent intent = new Intent(this,IChartJSActivity.class);
        startActivity(intent);
    }
}
