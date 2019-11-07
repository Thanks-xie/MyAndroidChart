package cn.xie.myandroidchart.activity;

import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.IChartBorder;
import cn.xie.myandroidchart.domain.IChartData;
import cn.xie.myandroidchart.domain.IChartTitle;
import cn.xie.myandroidchart.utils.Util;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class Area2DActivity extends BaseActivity {
    private WebView webView,webView02,webView03;
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
        webView.loadUrl("file:///android_asset/Area2DActivity.html");
        webView02 = findViewById(R.id.webView_area2d_02);
        Util.setIChartJSWebView(webView02,this,TAG);
        webView02.loadUrl("file:///android_asset/Area2DActivity2.html");
        webView03 = findViewById(R.id.webView_area2d_03);
        Util.setIChartJSWebView(webView03,this,TAG);
        webView03.loadUrl("file:///android_asset/Area2DActivity3.html");
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

    /**
     * 图2数据源1
     * @return
     */
    @JavascriptInterface
    public String getContacts02_1(){
        double[] values = {4,16,18,24,32,36,38,38,36,26,20,14};
        IChartData iChartData02_1 = new IChartData();
        iChartData02_1.setLine_width(2);
        iChartData02_1.setName("上海");
        iChartData02_1.setColor("#aad0db");
        iChartData02_1.setValue(values);
        return Util.beanToJson(iChartData02_1);
    }
    /**
     * 图2数据源2
     * @return
     */
    @JavascriptInterface
    public String getContacts02_2(){
        double[] values = {-9,1,12,20,26,30,32,29,22,12,0,-6};
        IChartData iChartData02_2 = new IChartData();
        iChartData02_2.setLine_width(2);
        iChartData02_2.setName("北京");
        iChartData02_2.setColor("#f68f70");
        iChartData02_2.setValue(values);
        return Util.beanToJson(iChartData02_2);
    }

    /**
     * 设置图表1的title
     * @return
     */
    @JavascriptInterface
    public String getArea2DTitle1(){
        float[]  width = {0,0,4,0}; //只显示下边框
        IChartBorder iChartBorder = new IChartBorder();
        iChartBorder.setColor("#173a4e");
        iChartBorder.setEnable(true);
        iChartBorder.setWidth(width);

        IChartTitle iChartTitle = new IChartTitle();
        iChartTitle.setText("A产品2019年度订单数据分析");
        iChartTitle.setHeight(40);
        iChartTitle.setColor("#eff4f8");
        iChartTitle.setBackground_color("#1c4156");
        iChartTitle.setBorder(iChartBorder);

        return Util.beanToJson(iChartTitle);
    }

    /**
     * 图3数据源1
     * @return
     */
    @JavascriptInterface
    public String getContacts03_1(){
        double[] values = {4,16,18,20,32,36,38,38,36,26,20,14};
        IChartData iChartData03_1 = new IChartData();
        iChartData03_1.setLine_width(2);
        iChartData03_1.setName("上海");
        iChartData03_1.setColor("#dad81f");
        iChartData03_1.setValue(values);
        return Util.beanToJson(iChartData03_1);
    }
    /**
     * 图3数据源2
     * @return
     */
    @JavascriptInterface
    public String getContacts03_2(){
        double[] values = {2,12,14,20,28,32,34,36,33,24,14,4};
        IChartData iChartData03_2 = new IChartData();
        iChartData03_2.setLine_width(2);
        iChartData03_2.setName("北京");
        iChartData03_2.setColor("#1f7e92");
        iChartData03_2.setValue(values);
        return Util.beanToJson(iChartData03_2);
    }
    /**
     * 图3数据源3
     * @return
     */
    @JavascriptInterface
    public String getContacts03_3(){
        double[] values = {1,12,18,20,28,34,36,34,31,27,24,6};
        IChartData iChartData03_3 = new IChartData();
        iChartData03_3.setLine_width(2);
        iChartData03_3.setName("西安");
        iChartData03_3.setColor("#76a871");
        iChartData03_3.setValue(values);
        return Util.beanToJson(iChartData03_3);
    }
    /**
     * 图3数据源4
     * @return
     */
    @JavascriptInterface
    public String getContacts03_4(){
        double[] values = {3,13,14,20,28,32,34,36,30,24,14,4};
        IChartData iChartData03_4 = new IChartData();
        iChartData03_4.setLine_width(2);
        iChartData03_4.setName("天津");
        iChartData03_4.setColor("#6f83a5");
        iChartData03_4.setValue(values);
        return Util.beanToJson(iChartData03_4);
    }
}
