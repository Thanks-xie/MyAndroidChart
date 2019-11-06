package cn.xie.myandroidchart.domain;

import android.webkit.JavascriptInterface;

/**
 * Data字节实体类
 * @author xiejinbo
 * @date 2019/11/6 0006 14:50
 */
public class IChartData {
    private String name;  //name值
    private String color; //折线颜色和区域背景色
    private int line_width; //折线宽度
    private int[] value; //折线节点值
    @JavascriptInterface
    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }
    @JavascriptInterface
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JavascriptInterface
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @JavascriptInterface
    public int getLine_width() {
        return line_width;
    }

    public void setLine_width(int line_width) {
        this.line_width = line_width;
    }
}
