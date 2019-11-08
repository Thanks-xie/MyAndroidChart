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

public class Column3DActivity extends BaseActivity {
    private static String TAG = "Column3DActivity";
    private WebView webViewColumn3D_1,webViewColumn3D_2,webViewColumn3D_3,webViewColumn3D_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column3_d);
        initNavBar(true,"Column3D之柱形图");
        initView();
    }

    private void initView() {
        webViewColumn3D_1 = findViewById(R.id.column3d_1);
        Util.setIChartJSWebView(webViewColumn3D_1,this,TAG);
        webViewColumn3D_1.loadUrl("file:///android_asset/Column3DActivity_01.html");

        webViewColumn3D_2 = findViewById(R.id.column3d_2);
        Util.setIChartJSWebView(webViewColumn3D_2,this,TAG);
        webViewColumn3D_2.loadUrl("file:///android_asset/Column3DActivity_02.html");

        webViewColumn3D_3 = findViewById(R.id.column3d_3);
        Util.setIChartJSWebView(webViewColumn3D_3,this,TAG);
        webViewColumn3D_3.loadUrl("file:///android_asset/Column3DActivity_03.html");

        webViewColumn3D_4 = findViewById(R.id.column3d_4);
        Util.setIChartJSWebView(webViewColumn3D_4,this,TAG);
        webViewColumn3D_4.loadUrl("file:///android_asset/Column3DActivity_04.html");
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
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("IE8", 40.59, "#3A68D3"));
        contacts.add(new Contact("IE6", 19.1, "#3895BF"));
        contacts.add(new Contact("Chrome", 13.68, "#2A962A"));
        contacts.add(new Contact("IE9", 10.91, "#4267BE"));
        contacts.add(new Contact("搜狗高速", 6.19, "#9F2626"));
        contacts.add(new Contact("IE7", 1.48, "#4F7DE7"));
        contacts.add(new Contact("奇虎360", 1.35, "#7A3C9C"));
        contacts.add(new Contact("Maxthon", 1.27, "#B97944"));
        contacts.add(new Contact("Firefox", 1.18, "#782A56"));
        contacts.add(new Contact("其他", 4.26, "#484848"));
        String json = null;
        try {
            JSONArray array = new JSONArray();
            for (Contact contact : contacts) {

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
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Alex", 25, "#849fb4"));
        contacts.add(new Contact("Mark", 35, "#bf9d32"));
        contacts.add(new Contact("David", 42.3, "#728f1b"));
        contacts.add(new Contact("Graham", 35.3, "#bf784c"));
        contacts.add(new Contact("John", 31.3, "#2f8586"));
        String json = null;
        try {
            JSONArray array = new JSONArray();
            for (Contact contact : contacts) {

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
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Alex", 25, "#849fb4"));
        contacts.add(new Contact("Mark", 35, "#bf9d32"));
        contacts.add(new Contact("David", 42.3, "#728f1b"));
        contacts.add(new Contact("Graham", 35.3, "#bf784c"));
        contacts.add(new Contact("John", 31.3, "#2f8586"));
        String json = null;
        try {
            JSONArray array = new JSONArray();
            for (Contact contact : contacts) {

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
