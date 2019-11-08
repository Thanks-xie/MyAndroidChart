package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.IChartData;
import cn.xie.myandroidchart.utils.Util;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class ColumnStacked3DActivity extends BaseActivity {
    private WebView webViewColumnStacked3D_1,webViewColumnStacked3D_2;
    private static String TAG = "ColumnStacked3DActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column_stacked3_d);
        initNavBar(true,"ColumnStacked3D堆积图");
        initView();
    }

    private void initView() {
        webViewColumnStacked3D_1 = findViewById(R.id.columnStacked3d_1);
        Util.setIChartJSWebView(webViewColumnStacked3D_1,this,TAG);
        webViewColumnStacked3D_1.loadUrl("file:///android_asset/ColumnStacked3DActivity_01.html");

        webViewColumnStacked3D_2 = findViewById(R.id.columnStacked3d_2);
        Util.setIChartJSWebView(webViewColumnStacked3D_2,this,TAG);
        webViewColumnStacked3D_2.loadUrl("file:///android_asset/ColumnStacked3DActivity_02.html");
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
     * 图2数据1
     * @return
     */
    @JavascriptInterface
    public String getContact2_1(){
        double[] vlaue = {9,12,10,11,16};
        IChartData iChartData2_1 = new IChartData();
        iChartData2_1.setColor("#e0b645");
        iChartData2_1.setName("便利店");
        iChartData2_1.setValue(vlaue);
        return Util.beanToJson(iChartData2_1);
    }
    /**
     * 图2数据2
     * @return
     */
    @JavascriptInterface
    public String getContact2_2(){
        double[] vlaue = {60,80,105,80};
        IChartData iChartData2_2 = new IChartData();
        iChartData2_2.setColor("#7876ba");
        iChartData2_2.setName("超市");
        iChartData2_2.setValue(vlaue);
        return Util.beanToJson(iChartData2_2);
    }
    /**
     * 图2数据3
     * @return
     */
    @JavascriptInterface
    public String getContact2_3(){
        double[] vlaue = {50,70,120,100};
        IChartData iChartData2_3 = new IChartData();
        iChartData2_3.setColor("#6b8439");
        iChartData2_3.setName("大型超市");
        iChartData2_3.setValue(vlaue);
        return Util.beanToJson(iChartData2_3);
    }
}
