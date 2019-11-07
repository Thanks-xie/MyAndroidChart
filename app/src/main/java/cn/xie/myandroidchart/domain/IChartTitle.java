package cn.xie.myandroidchart.domain;

/**
 * @author xiejinbo
 * @date 2019/11/7 0007 9:47
 */
public class IChartTitle {
    private String text;
    private String color;
    private String background_color;
    private float height;
    private IChartBorder border;

    public IChartBorder getBorder() {
        return border;
    }

    public void setBorder(IChartBorder border) {
        this.border = border;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackground_color() {
        return background_color;
    }

    public void setBackground_color(String background_color) {
        this.background_color = background_color;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
