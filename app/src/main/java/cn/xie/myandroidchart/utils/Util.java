package cn.xie.myandroidchart.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;

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
    public static ValueFormatter getQuarterValue(){
        final String[] quarters = new String[] { "第一季度", "第二季度", "第三季度", "第四季度" };
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return quarters[(int) value];
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
}
