package cn.xie.myandroidchart.domain;

/**
 * 封装数据的实体类
 * @author xiejinbo
 * @date 2019/11/5 0005 13:42
 */
public class Contact {
    private String name; // 浏览器的名称
    private double value; // 浏览器对应的所占市场份额值
    private String color; // 在柱形图中所显示的颜色

    /**
     * 构造函数
     * @param name 浏览器的名称
     * @param value 浏览器对应的所占市场份额值
     * @param color 在柱形图中所显示的颜色
     */
    public Contact(String name, double value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    // 下面是三个实例变量的getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

}
