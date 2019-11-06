package cn.xie.myandroidchart.activity;

import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.IChartData;
import cn.xie.myandroidchart.utils.Util;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class Area2DActivity extends BaseActivity {
    private WebView webView;
    private static String TAG = "Area2DActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area2_d);
        initNavBar(true,"Area2D面积图表展示");
        initView();
    }

    private void initView() {
        webView = findViewById(R.id.webView_area2d);
        Util.setIChartJSWebView(webView,this,TAG);

    }

    /**
     * 实现将list转换成json格式字符串，由JS调用此方法
     * @return json格式的字符串
     */
    @JavascriptInterface
    public String getContacts() {
        return  Util.getIChartJSData();
    }

    /**
     * 获取X轴标签值
     * @return
     */
    @JavascriptInterface
    public String getLabels(){
        return Util.getIChartJSLabels();
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
