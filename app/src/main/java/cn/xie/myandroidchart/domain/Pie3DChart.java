package cn.xie.myandroidchart.domain;

import android.webkit.JavascriptInterface;

import java.nio.file.Path;

/**
 * @author xiejinbo
 * @date 2019/11/5 0005 15:42
 */
public class Pie3DChart {
    //图表宽度
    private float pieWidth;
    //图表高度
    private float pieHeight;
    //获得标题
    private String title;
    //半径
    private float pieRadius;
    //厚度
    private float pieZHigh;
    //标注
    private String footnote;
    //图例的水平对齐方式
    private String align;
    //获得图例的垂直对齐方式
    private String vAlign;
    //图例的行数
    private int row;


    @JavascriptInterface
    public float getPieWidth() {
        return pieWidth;
    }

    public void setPieWidth(float pieWidth) {
        this.pieWidth = pieWidth;
    }
    @JavascriptInterface
    public float getPieHeight() {
        return pieHeight;
    }

    public void setPieHeight(float pieHeight) {
        this.pieHeight = pieHeight;
    }
    @JavascriptInterface
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JavascriptInterface
    public float getPieRadius() {
        return pieRadius;
    }

    public void setPieRadius(float pieRadius) {
        this.pieRadius = pieRadius;
    }
    @JavascriptInterface
    public float getPieZHigh() {
        return pieZHigh;
    }

    public void setPieZHigh(float pieZHigh) {
        this.pieZHigh = pieZHigh;
    }
    @JavascriptInterface
    public String getFootnote() {
        return footnote;
    }

    public void setFootnote(String footnote) {
        this.footnote = footnote;
    }
    @JavascriptInterface
    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }
    @JavascriptInterface
    public String getvAlign() {
        return vAlign;
    }

    public void setvAlign(String vAlign) {
        this.vAlign = vAlign;
    }
    @JavascriptInterface
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
