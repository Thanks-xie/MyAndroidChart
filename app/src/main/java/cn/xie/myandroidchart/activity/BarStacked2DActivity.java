package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.IChartData;
import cn.xie.myandroidchart.utils.Util;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class BarStacked2DActivity extends BaseActivity {
    private static String TAG = "BarStacked2DActivity";
    private WebView webViewBarStacked2D_1,webViewBarStacked2D_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_stacked2_d);
        initNavBar(true,"BarStacked2D之簇状图");
        initView();
    }

    private void initView() {
        webViewBarStacked2D_1 = findViewById(R.id.webView_barStacked2D_1);
        Util.setIChartJSWebView(webViewBarStacked2D_1,this,TAG);
        webViewBarStacked2D_1.loadUrl("file:///android_asset/BarStacked2DActivity_01.html");

        webViewBarStacked2D_2 = findViewById(R.id.webView_barStacked2D_2);
        Util.setIChartJSWebView(webViewBarStacked2D_2,this,TAG);
        webViewBarStacked2D_2.loadUrl("file:///android_asset/BarStacked2DActivity_02.html");
    }
    /**
     * 图1数据1
     * @return
     */
    @JavascriptInterface
    public String getContact1_1(){
        double[] values = {2.75,2.92,4.31,4.95,4.6,4.32,4.32,2.97};
        IChartData iChartData01_1 = new IChartData();
        iChartData01_1.setName("Jan-Sep");
        iChartData01_1.setColor("#ECAD55");
        iChartData01_1.setValue(values);
        return Util.beanToJson(iChartData01_1);
    }
    /**
     * 图1数据2
     * @return
     */
    @JavascriptInterface
    public String getContact1_2(){
        double[] values = {3.4,3.57,4.49,6.05,5.4,4.87,4.48,3.22};
        IChartData iChartData01_2 = new IChartData();
        iChartData01_2.setName("Oct-Dec");
        iChartData01_2.setColor("#47AAB3");
        iChartData01_2.setValue(values);
        return Util.beanToJson(iChartData01_2);
    }
    /**
     * 图2数据1
     * @return
     */
    @JavascriptInterface
    public String getContact2_1(){
        double[] values = {54841,72400,76776,83361};
        IChartData iChartData02_1 = new IChartData();
        iChartData02_1.setName("直营店");
        iChartData02_1.setColor("#338f61");
        iChartData02_1.setValue(values);
        return Util.beanToJson(iChartData02_1);
    }
    /**
     * 图2数据2
     * @return
     */
    @JavascriptInterface
    public String getContact2_2(){
        double[] values = {22790,33284,52148,68333};
        IChartData iChartData02_2 = new IChartData();
        iChartData02_2.setName("加盟店");
        iChartData02_2.setColor("#44BF82");
        iChartData02_2.setValue(values);
        return Util.beanToJson(iChartData02_2);
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
