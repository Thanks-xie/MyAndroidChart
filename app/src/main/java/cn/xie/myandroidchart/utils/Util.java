package cn.xie.myandroidchart.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import com.google.gson.Gson;

import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;

import cn.xie.myandroidchart.domain.Contact;
import cn.xie.myandroidchart.domain.IChartData;

/**
 * @author xiejinbo
 * @date 2019/11/4 0004 13:20
 */
public class Util {


    /**
     * 营业额单位
     * @return
     */
    public static String[] getTurnoverUnit(){
        String[] suffix   = {"元","万元","亿元"};
        return suffix;
    }

    /**
     * 获取季度值
     * @return
     */
    public static ValueFormatter getQuarterValue(final XAxis xAxis){
        final String[] quarters = new String[] { "第一季度", "第二季度", "第三季度", "第四季度" };
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                //这里是兼容数组越界的错误
                int index = (int) value;
                if (index < 0 || index >= xAxis.getLabelCount()) {
                    return "";
                } else {
                    return quarters[(int) Math.abs(value)];
                }
            }
        };
        return formatter;
    }
    /**
     * 设置描述文本位置：居中
     */
    public static void setDescriptionPosition(Context context, LineChart lineChart, String descriptionStr) {
        Description description = new Description();

        description.setTextAlign(Paint.Align.CENTER);
        description.setText(descriptionStr);
        description.setTextSize(16f);
        description.setTextColor(ColorTemplate.getHoloBlue());
        description.setTypeface(Typeface.DEFAULT_BOLD);

        // 获取屏幕中间x 轴的像素坐标
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);


        // y轴像素坐标，获取文本高度（dp）+上方间隔12dp 转换为像素
        Paint paint = new Paint();
        paint.setTextSize(14f);
        float x = (dm.widthPixels- Utils.calcTextWidth(paint,descriptionStr))/2;
        float height = Utils.calcTextHeight(paint, descriptionStr);
        float y = Utils.convertDpToPixel(height + 280);

        description.setPosition(x, y);

        lineChart.setDescription(description);
        lineChart.setExtraBottomOffset(40f);
    }
    /**
     * 设置描述文本位置：居中
     */
    public static void setDescriptionPosition(Context context, BarChart barChart, String descriptionStr) {
        Description description = new Description();

        description.setTextAlign(Paint.Align.CENTER);
        description.setText(descriptionStr);
        description.setTextSize(16f);
        description.setTextColor(ColorTemplate.getHoloBlue());
        description.setTypeface(Typeface.DEFAULT_BOLD);

        // 获取屏幕中间x 轴的像素坐标
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);


        // y轴像素坐标，获取文本高度（dp）+上方间隔12dp 转换为像素
        Paint paint = new Paint();
        paint.setTextSize(14f);
        float x = (dm.widthPixels- Utils.calcTextWidth(paint,descriptionStr))/2;
        float height = Utils.calcTextHeight(paint, descriptionStr);
        float y = Utils.convertDpToPixel(height + 280);

        description.setPosition(x, y);

        barChart.setDescription(description);
        barChart.setExtraBottomOffset(40f);
    }

    /**
     * 创建一个list将所需要的contact对象添加到list中
     * @return
     */
    public static List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("IE", 32.85, "#a5c2d5"));
        contacts.add(new Contact("Chrome", 33.59, "#cbab4f"));
        contacts.add(new Contact("Firefox", 22.85, "#76a871"));
        contacts.add(new Contact("Safari", 7.39, "#9f7961"));
        contacts.add(new Contact("Opera", 1.63, "#a56f8f"));
        contacts.add(new Contact("Other", 1.69, "#6f83a5"));
        return contacts;
    }
    /**
     * 把每个节点数据转换成JSON
     * @return
     */
    public static String getIChartJSData() {
        double[] values = {2680,2200,1014,2590,2800,3200,2184,3456,2693,2064,2414,2044};
        IChartData iChartData = new IChartData();
        iChartData.setLine_width(2);
        iChartData.setName("A产品");
        iChartData.setColor("#D81B60");
        iChartData.setValue(values);
        return beanToJson(iChartData);
    }

    /**
     * 对象转JSON
     * @param bean
     * @return
     */
    public static String beanToJson(Object bean) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(bean);
        return jsonStr;
    }

    public static String getIChartJSLabels(){
        String[] labels = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
        JSONArray root = new JSONArray();
        try {
            for(int i = 0; i < labels.length; ++i){
                root.put(labels[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root.toString();
    }

    /**
     * 设置webView,并添加与JS交互依赖
     * @param webView
     * @param object
     * @param tag
     */
    @SuppressLint("JavascriptInterface")
    public static void setIChartJSWebView(WebView webView,Object object,String tag){
        webView.getSettings().setJavaScriptEnabled(true); // 允许使用javascript脚本语言
        webView.getSettings().setBuiltInZoomControls(true); // 设置可以缩放
        // 设置javaScript可用于操作object类
        webView.addJavascriptInterface(object,tag);
        //设置自适应屏幕，两者合用
        webView.getSettings().setUseWideViewPort(true); //将图片调整到适合webview的大小
        webView.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
    }

}
