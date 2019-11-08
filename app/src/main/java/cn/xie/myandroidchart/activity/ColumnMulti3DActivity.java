package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.IChartData;
import cn.xie.myandroidchart.utils.Util;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class ColumnMulti3DActivity extends BaseActivity {
    private static String TAG = "ColumnMulti3DActivity";
    private WebView webViewColumnMulti3D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column_multi3_d);
        initNavBar(true,"ColumnMulti3D簇状图");
        initView();
    }

    private void initView() {
        webViewColumnMulti3D = findViewById(R.id.columnMulti3D_1);
        Util.setIChartJSWebView(webViewColumnMulti3D,this,TAG);
        webViewColumnMulti3D.loadUrl("file:///android_asset/ColumnMulti3DActivity.html");
    }
    /**
     * 图1数据1
     * @return
     */
    @JavascriptInterface
    public String getContact1_1(){
        double[] values = {321,384,447,504,546,566,608,640,662,682};
        IChartData iChartData1_1 = new IChartData();
        iChartData1_1.setName("普通高等教育本专科招生人数");
        iChartData1_1.setColor("#de9972");
        iChartData1_1.setValue(values);
        return Util.beanToJson(iChartData1_1);
    }
    /**
     * 图1数据2
     * @return
     */
    @JavascriptInterface
    public String getContact1_2(){
        double[] values = {474,516,566,656,748,810,812,869,870,809};
        IChartData iChartData1_2 = new IChartData();
        iChartData1_2.setName("各类中等职业教育招生人数");
        iChartData1_2.setColor("#28847f");
        iChartData1_2.setValue(values);
        return Util.beanToJson(iChartData1_2);
    }
    /**
     * 图1数据3
     * @return
     */
    @JavascriptInterface
    public String getContact1_3(){
        double[] values = {677,752,822,878,871,840,837,830,836,851};
        IChartData iChartData1_3 = new IChartData();
        iChartData1_3.setName("全国普通高中招生人数");
        iChartData1_3.setColor("#90abc0");
        iChartData1_3.setValue(values);
        return Util.beanToJson(iChartData1_3);
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
