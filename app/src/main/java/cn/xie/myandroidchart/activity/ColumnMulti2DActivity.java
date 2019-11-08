package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.IChartData;
import cn.xie.myandroidchart.domain.Pie3DChart;
import cn.xie.myandroidchart.utils.Util;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class ColumnMulti2DActivity extends BaseActivity {

    private static String TAG = "ColumnMulti2DActivity";
    private WebView webViewColumnMulti2D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column_multi2_d);
        initNavBar(true,"ColumnMulti2D多数据簇状图");
        initView();
    }

    private void initView() {
        webViewColumnMulti2D = findViewById(R.id.columnMulti2D_1);
        Util.setIChartJSWebView(webViewColumnMulti2D,this,TAG);
        webViewColumnMulti2D.loadUrl("file:///android_asset/ColumnMulti2DActivity.html");
    }

    /**
     * 图六数据
     * @return
     */
    @JavascriptInterface
    public String getContact1_1(){
        double[] values = {45,52,54,74,90,84};
        IChartData iChartData06_1 = new IChartData();
        iChartData06_1.setName("DPS01A");
        iChartData06_1.setColor("#47b2c8");
        iChartData06_1.setValue(values);
        return Util.beanToJson(iChartData06_1);
    }
    /**
     * 图六数据
     * @return
     */
    @JavascriptInterface
    public String getContact1_2(){
        double[] values = {60,80,105,125,108,120};
        IChartData iChartData06_2 = new IChartData();
        iChartData06_2.setName("DPS01B");
        iChartData06_2.setColor("#db6086");
        iChartData06_2.setValue(values);
        return Util.beanToJson(iChartData06_2);
    }
    /**
     *
     * @param data
     */
    @JavascriptInterface
    public void logOut(String data){
        Log.e(TAG,data);
    }
}
