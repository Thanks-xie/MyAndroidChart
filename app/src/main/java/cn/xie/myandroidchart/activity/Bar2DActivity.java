package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.Contact;
import cn.xie.myandroidchart.domain.IChartData;
import cn.xie.myandroidchart.domain.Pie3DChart;
import cn.xie.myandroidchart.utils.Util;

import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Bar2DActivity extends BaseActivity {
    private static String TAG = "Bar2DActivity";
    private WebView webViewBar2D_1,webViewBar2D_2,webViewBar2D_3,webViewBar2D_4,webViewBar2D_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar2_d);
        initNavBar(true,"Bar2D条形图");
        initView();
    }

    private void initView() {
        webViewBar2D_1 = findViewById(R.id.webView_bar2d_1);
        Util.setIChartJSWebView(webViewBar2D_1,this,TAG);
        webViewBar2D_1.loadUrl("file:///android_asset/Bar2DActivity_01.html");

        webViewBar2D_2 = findViewById(R.id.webView_bar2d_2);
        Util.setIChartJSWebView(webViewBar2D_2,this,TAG);
        webViewBar2D_2.loadUrl("file:///android_asset/Bar2DActivity_02.html");

        webViewBar2D_3 = findViewById(R.id.webView_bar2d_3);
        Util.setIChartJSWebView(webViewBar2D_3,this,TAG);
        webViewBar2D_3.loadUrl("file:///android_asset/Bar2DActivity_03.html");

        webViewBar2D_4 = findViewById(R.id.webView_bar2d_4);
        Util.setIChartJSWebView(webViewBar2D_4,this,TAG);
        webViewBar2D_4.loadUrl("file:///android_asset/Bar2DActivity_04.html");

        webViewBar2D_5 = findViewById(R.id.webView_bar2d_5);
        Util.setIChartJSWebView(webViewBar2D_5,this,TAG);
        webViewBar2D_5.loadUrl("file:///android_asset/Bar2DActivity_05.html");

    }

    /**
     * 图一数据
     * @return
     */
    @JavascriptInterface
    public String getContact1_1(){
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("IE", 32.85, "#a5c2d5"));
        contactList.add(new Contact("Chrome", 33.59, "#cbab4f"));
        contactList.add(new Contact("Firefox", 22.85, "#76a871"));
        contactList.add(new Contact("Safari", 7.39, "#9f7961"));
        contactList.add(new Contact("Opera", 1.63, "#a56f8f"));
        contactList.add(new Contact("Other", 1.69, "#6f83a5"));
        String json = null;
        try {
            JSONArray array = new JSONArray();
            for (Contact contact : contactList) {

                JSONObject item = new JSONObject();
                item.put("name", contact.getName());
                item.put("value", contact.getValue());
                item.put("color", contact.getColor());
                array.put(item);
            }
            json = array.toString();
            Log.i(TAG, json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
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
     * 图二数据
     * @return
     */
    @JavascriptInterface
    public String getContact2_1(){
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("鞋区", 6078, "#97b3bc"));
        contactList.add(new Contact("运动区", 5845, "#FF3333"));
        contactList.add(new Contact("女装区", 5008, "#cd5c5c"));
        contactList.add(new Contact("户外区", 2662, "#006666"));
        contactList.add(new Contact("休闲区", 2445, "#CC3333"));
        contactList.add(new Contact("皮具区", 2389, "#9d4a4a"));
        contactList.add(new Contact("男装区", 2147, "#CCFF66"));
        contactList.add(new Contact("内衣区", 2135, "#9d4a4a"));
        contactList.add(new Contact("儿童区", 820, "#5d7f97"));
        contactList.add(new Contact("租赁", 763, "#33FF33"));
        contactList.add(new Contact("服饰区", 421, "#330099"));
        contactList.add(new Contact("家居区", 272, "#33FF99"));
        contactList.add(new Contact("毛纺区", 261, "#ffdead"));
        contactList.add(new Contact("羽绒服区", 252, "#CC3399"));
        String json = null;
        try {
            JSONArray array = new JSONArray();
            for (Contact contact : contactList) {

                JSONObject item = new JSONObject();
                item.put("name", contact.getName());
                item.put("value", contact.getValue());
                item.put("color", contact.getColor());
                array.put(item);
            }
            json = array.toString();
            Log.i(TAG, json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
    /**
     * 图三数据
     * @return
     */
    @JavascriptInterface
    public String getContact3_1(){
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("天语", 2.83, "#4572a7"));
        contactList.add(new Contact("苹果", 3.44, "#4572a7"));
        contactList.add(new Contact("HTC", 3.66, "#4572a7"));
        contactList.add(new Contact("金立", 4.58, "#4572a7"));
        contactList.add(new Contact("中兴", 6.56, "#4572a7"));
        contactList.add(new Contact("酷派", 6.85, "#4572a7"));
        contactList.add(new Contact("诺基亚", 9.42, "#4572a7"));
        contactList.add(new Contact("华为", 9.54, "#4572a7"));
        contactList.add(new Contact("联想", 11.00, "#4572a7"));
        contactList.add(new Contact("三星", 15.73, "#4572a7"));
        String json = null;
        try {
            JSONArray array = new JSONArray();
            for (Contact contact : contactList) {

                JSONObject item = new JSONObject();
                item.put("name", contact.getName());
                item.put("value", contact.getValue());
                item.put("color", contact.getColor());
                array.put(item);
            }
            json = array.toString();
            Log.i(TAG, json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
    /**
     * 图四数据
     * @return
     */
    @JavascriptInterface
    public String getContact4_1(){
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Renren", 33.1, "#b5bcc5"));
        contactList.add(new Contact("Facebook", 19.14, "#b5bcc5"));
        contactList.add(new Contact("StumbleUpon", 13.97, "#b5bcc5"));
        contactList.add(new Contact("Reddit", 7.44, "#b5bcc5"));
        contactList.add(new Contact("Hi5", 5.22, "#b5bcc5"));
        contactList.add(new Contact("LinkedIn", 4.85, "#b5bcc5"));
        contactList.add(new Contact("Twitter", 4.59, "#b5bcc5"));
        contactList.add(new Contact("Other", 11.68, "#b5bcc5"));
        String json = null;
        try {
            JSONArray array = new JSONArray();
            for (Contact contact : contactList) {

                JSONObject item = new JSONObject();
                item.put("name", contact.getName());
                item.put("value", contact.getValue());
                item.put("color", contact.getColor());
                array.put(item);
            }
            json = array.toString();
            Log.i(TAG, json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
    /**
     * 图五数据
     * @return
     */
    @JavascriptInterface
    public String getContact5_1(){
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Google", 91.17, "#a5c2d5"));
        contactList.add(new Contact("Bing", 3.22, "#cbab4f"));
        contactList.add(new Contact("Yahoo!", 2.95, "#76a871"));
        contactList.add(new Contact("Babylon", 0.54, "#9f7961"));
        contactList.add(new Contact("Baidu", 0.45, "#a56f8f"));
        contactList.add(new Contact("Other", 1.67, "#db9034"));
        String json = null;
        try {
            JSONArray array = new JSONArray();
            for (Contact contact : contactList) {

                JSONObject item = new JSONObject();
                item.put("name", contact.getName());
                item.put("value", contact.getValue());
                item.put("color", contact.getColor());
                array.put(item);
            }
            json = array.toString();
            Log.i(TAG, json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
