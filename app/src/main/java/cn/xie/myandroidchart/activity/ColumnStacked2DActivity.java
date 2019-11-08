package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.IChartData;
import cn.xie.myandroidchart.utils.Util;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class ColumnStacked2DActivity extends BaseActivity {
    private WebView webViewColumnStacked2D_1,webViewColumnStacked2D_2;
    private static String TAG = "ColumnStacked2DActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column_stacked2_d);
        initNavBar(true,"ColumnStacked2D堆积图");
        initView();
    }

    private void initView() {
        webViewColumnStacked2D_1 = findViewById(R.id.columnStacked2d_1);
        Util.setIChartJSWebView(webViewColumnStacked2D_1,this,TAG);
        webViewColumnStacked2D_1.loadUrl("file:///android_asset/ColumnStacked2DActivity_01.html");

        webViewColumnStacked2D_2 = findViewById(R.id.columnStacked2d_2);
        Util.setIChartJSWebView(webViewColumnStacked2D_2,this,TAG);
        webViewColumnStacked2D_2.loadUrl("file:///android_asset/ColumnStacked2DActivity_02.html");
    }
    /**
     * 输出log
     * @param data
     */
    @JavascriptInterface
    public void logOut(String data){
        Log.e(TAG,data);
    }

    /**
     * 图一数据1
     * @return
     */
    @JavascriptInterface
    public String getContact1_1(){
        double[] vlaue = {45,52,54,60};
        IChartData iChartData1_1 = new IChartData();
        iChartData1_1.setColor("#4f81bd");
        iChartData1_1.setName("一月");
        iChartData1_1.setValue(vlaue);
        return Util.beanToJson(iChartData1_1);
    }
    /**
     * 图一数据2
     * @return
     */
    @JavascriptInterface
    public String getContact1_2(){
        double[] vlaue = {60,80,105,80};
        IChartData iChartData1_1 = new IChartData();
        iChartData1_1.setColor("#4f81bd");
        iChartData1_1.setName("二月");
        iChartData1_1.setValue(vlaue);
        return Util.beanToJson(iChartData1_1);
    }
    /**
     * 图一数据3
     * @return
     */
    @JavascriptInterface
    public String getContact1_3(){
        double[] vlaue = {50,70,120,100};
        IChartData iChartData1_1 = new IChartData();
        iChartData1_1.setColor("#98c045");
        iChartData1_1.setName("三月");
        iChartData1_1.setValue(vlaue);
        return Util.beanToJson(iChartData1_1);
    }

    /**
     * 图二数据1
     * @return
     */
    @JavascriptInterface
    public String getContact2_1(){
        double[] vlaue = {54841,72400,76776,83361};
        IChartData iChartData1_1 = new IChartData();
        iChartData1_1.setColor("#32bdbc");
        iChartData1_1.setName("直营店");
        iChartData1_1.setValue(vlaue);
        return Util.beanToJson(iChartData1_1);
    }
    /**
     * 图2数据2
     * @return
     */
    @JavascriptInterface
    public String getContact2_2(){
        double[] vlaue = {22790,33284,52148,68333};
        IChartData iChartData1_1 = new IChartData();
        iChartData1_1.setColor("#d75a5e");
        iChartData1_1.setName("加盟店");
        iChartData1_1.setValue(vlaue);
        return Util.beanToJson(iChartData1_1);
    }

}
