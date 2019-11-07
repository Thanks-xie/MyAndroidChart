package cn.xie.myandroidchart.domain;

import android.webkit.JavascriptInterface;

/**
 * @author xiejinbo
 * @date 2019/11/7 0007 9:56
 */
public class IChartBorder {
    private boolean enable;
    private float[] width;
    private String color;

    @JavascriptInterface
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @JavascriptInterface
    public float[] getWidth() {
        return width;
    }

    public void setWidth(float[] width) {
        this.width = width;
    }

    @JavascriptInterface
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
