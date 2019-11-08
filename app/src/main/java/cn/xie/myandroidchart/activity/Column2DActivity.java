package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.domain.Contact;
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

public class Column2DActivity extends BaseActivity {
    private static  String TAG = "Column2DActivity";
    private WebView webViewColumn2D_1,webViewColumn2D_2,webViewColumn2D_3,webViewColumn2D_4,webViewColumn2D_5,webViewColumn2D_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column2_d);
        initNavBar(true,"Column2D柱状图");
        initView();
    }

    private void initView() {
        webViewColumn2D_1 = findViewById(R.id.column2d_1);
        Util.setIChartJSWebView(webViewColumn2D_1,this,TAG);
        webViewColumn2D_1.loadUrl("file:///android_asset/Column2DActivity_01.html");

        webViewColumn2D_2 = findViewById(R.id.column2d_2);
        Util.setIChartJSWebView(webViewColumn2D_2,this,TAG);
        webViewColumn2D_2.loadUrl("file:///android_asset/Column2DActivity_02.html");

        webViewColumn2D_3 = findViewById(R.id.column2d_3);
        Util.setIChartJSWebView(webViewColumn2D_3,this,TAG);
        webViewColumn2D_3.loadUrl("file:///android_asset/Column2DActivity_03.html");

        webViewColumn2D_4 = findViewById(R.id.column2d_4);
        Util.setIChartJSWebView(webViewColumn2D_4,this,TAG);
        webViewColumn2D_4.loadUrl("file:///android_asset/Column2DActivity_04.html");

        webViewColumn2D_5 = findViewById(R.id.column2d_5);
        Util.setIChartJSWebView(webViewColumn2D_5,this,TAG);
        webViewColumn2D_5.loadUrl("file:///android_asset/Column2DActivity_05.html");

        webViewColumn2D_6 = findViewById(R.id.column2d_6);
        Util.setIChartJSWebView(webViewColumn2D_6,this,TAG);
        webViewColumn2D_6.loadUrl("file:///android_asset/Column2DActivity_06.html");
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
     * 图一数据
     * @return
     */
    @JavascriptInterface
    public String getContact1_1(){
        List<Contact> contactList = Util.getContacts();
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
     * 图二数据
     * @return
     */
    @JavascriptInterface
    public String getContact2_1(){
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
     * 图三数据
     * @return
     */
    @JavascriptInterface
    public String getContact3_1(){
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("H", 7, "#a5c2d5"));
        contactList.add(new Contact("E", 5, "#cbab4f"));
        contactList.add(new Contact("L", 12, "#76a871"));
        contactList.add(new Contact("L", 12, "#76a871"));
        contactList.add(new Contact("O", 15, "#a56f8f"));
        contactList.add(new Contact("W", 13, "#c12c44"));
        contactList.add(new Contact("O", 15, "#a56f8f"));
        contactList.add(new Contact("R", 18, "#9f7961"));
        contactList.add(new Contact("L", 12, "#76a871"));
        contactList.add(new Contact("D", 4, "#6f83a5"));
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
        contactList.add(new Contact("MISE", 55.11, "#4572a7"));
        contactList.add(new Contact("Firefox", 29.84, "#aa4643"));
        contactList.add(new Contact("Chrome", 24.88, "#89a54e"));
        contactList.add(new Contact("Safari", 6.77, "#80699b"));
        contactList.add(new Contact("Opera", 2.02, "#3d96ae"));
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
        contactList.add(new Contact("广东", 104303132, "#4572a7"));
        contactList.add(new Contact("山东", 95793065, "#4572a7"));
        contactList.add(new Contact("河南", 94023567, "#4572a7"));
        contactList.add(new Contact("四川", 80418200, "#4572a7"));
        contactList.add(new Contact("江苏", 78659903, "#4572a7"));
        contactList.add(new Contact("河北", 71854202, "#4572a7"));
        contactList.add(new Contact("湖南", 65683722, "#4572a7"));
        contactList.add(new Contact("安徽", 59500510, "#4572a7"));
        contactList.add(new Contact("湖北", 57237740, "#4572a7"));
        contactList.add(new Contact("浙江", 54426891, "#4572a7"));
        contactList.add(new Contact("广西", 46026629, "#4572a7"));
        contactList.add(new Contact("云南", 45966239, "#4572a7"));
        contactList.add(new Contact("江西", 44567475, "#4572a7"));
        contactList.add(new Contact("辽宁", 43746323, "#4572a7"));
        contactList.add(new Contact("黑龙江", 38312224, "#4572a7"));
        contactList.add(new Contact("陕西", 37327378, "#4572a7"));
        contactList.add(new Contact("福建", 36327378, "#4572a7"));
        contactList.add(new Contact("山西", 35712111, "#4572a7"));
        contactList.add(new Contact("贵州", 34746468, "#4572a7"));
        contactList.add(new Contact("重庆", 28846170, "#4572a7"));
        contactList.add(new Contact("吉林", 27462297, "#4572a7"));
        contactList.add(new Contact("内蒙古", 24706321, "#4572a7"));
        contactList.add(new Contact("上海", 23019148, "#4572a7"));
        contactList.add(new Contact("新疆", 21813334, "#4572a7"));
        contactList.add(new Contact("北京", 19612368, "#4572a7"));
        contactList.add(new Contact("海南", 8671518, "#4572a7"));
        contactList.add(new Contact("宁夏", 6301350, "#4572a7"));
        contactList.add(new Contact("青海", 5626722, "#4572a7"));
        contactList.add(new Contact("西藏", 3002166, "#4572a7"));
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
     * 图六数据
     * @return
     */
    @JavascriptInterface
    public String getContact6_1(){
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("MAY\n2011", 0.4, "#c52120"));
        contactList.add(new Contact("JUN\n2011", 0.6, "#c52120"));
        contactList.add(new Contact("JUL\n2011", 1, "#c52120"));
        contactList.add(new Contact("AUG\n2011", 1.2, "#c52120"));
        contactList.add(new Contact("SEP\n2011", 2, "#c52120"));
        contactList.add(new Contact("OCT\n2011", 3.2, "#c52120"));
        contactList.add(new Contact("NOV\n2011", 4.8, "#c52120"));
        contactList.add(new Contact("DEC\n2011", 7.8, "#c52120"));
        contactList.add(new Contact("JAN\n2012", 11.8, "#c52120"));
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
