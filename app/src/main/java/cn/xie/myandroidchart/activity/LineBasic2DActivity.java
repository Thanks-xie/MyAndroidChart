package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.IChartData;
import cn.xie.myandroidchart.utils.Util;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.github.mikephil.charting.components.Description;

public class LineBasic2DActivity extends BaseActivity {
    private static String TAG = "LineBasic2DActivity";
    private WebView webViewLineBasic2D_1,webViewLineBasic2D_2,webViewLineBasic2D_3,webViewLineBasic2D_4,webViewLineBasic2D_5,webViewLineBasic2D_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_basic2_d);
        initNavBar(true,"折线图");
        initView();
    }

    private void initView() {
        webViewLineBasic2D_1 = findViewById(R.id.lineBasic_1);
        Util.setIChartJSWebView(webViewLineBasic2D_1,this,TAG);
        webViewLineBasic2D_1.loadUrl("file:///android_asset/LineBasic2DActivity_01.html");

        webViewLineBasic2D_2 = findViewById(R.id.lineBasic_2);
        Util.setIChartJSWebView(webViewLineBasic2D_2,this,TAG);
        webViewLineBasic2D_2.loadUrl("file:///android_asset/LineBasic2DActivity_02.html");

        webViewLineBasic2D_3 = findViewById(R.id.lineBasic_3);
        Util.setIChartJSWebView(webViewLineBasic2D_3,this,TAG);
        webViewLineBasic2D_3.loadUrl("file:///android_asset/LineBasic2DActivity_03.html");

        webViewLineBasic2D_4 = findViewById(R.id.lineBasic_4);
        Util.setIChartJSWebView(webViewLineBasic2D_4,this,TAG);
        webViewLineBasic2D_4.loadUrl("file:///android_asset/LineBasic2DActivity_04.html");

        webViewLineBasic2D_5 = findViewById(R.id.lineBasic_5);
        Util.setIChartJSWebView(webViewLineBasic2D_5,this,TAG);
        webViewLineBasic2D_5.loadUrl("file:///android_asset/LineBasic2DActivity_05.html");

        webViewLineBasic2D_6 = findViewById(R.id.lineBasic_6);
        Util.setIChartJSWebView(webViewLineBasic2D_6,this,TAG);
        webViewLineBasic2D_6.loadUrl("file:///android_asset/LineBasic2DActivity_06.html");
    }

    /**
     * 输出log
     * @param data
     */
    @JavascriptInterface
    public void logOut(String data){
        Log.e(TAG, data);
        //下面为折线图随机数
        /*double[] flow = new double[61];
        for(int i=0;i<61;i++){
            flow[i]=Math.floor(Math.random()*(30+((i%12)*5)))+10;
        }
        Log.e(TAG,Util.beanToJson(flow));*/
    }

    /**
     * 图1数据
     * @return
     */
    @JavascriptInterface
    public String getContact1_1(){
        double[] value = {-9,1,12,20,26,30,32,29,22,12,0,-6};
        IChartData iChartData = new IChartData();
        iChartData.setValue(value);
        iChartData.setName("北京");
        iChartData.setLine_width(3);
        iChartData.setColor("#1f7e92");
        return Util.beanToJson(iChartData);
    }
}
