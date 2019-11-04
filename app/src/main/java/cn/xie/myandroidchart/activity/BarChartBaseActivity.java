package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.utils.MyLargeValueFormatter;
import cn.xie.myandroidchart.utils.Util;
import cn.xie.myandroidchart.views.MyCustomMarkerView;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ColorFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BarChartBaseActivity extends BaseActivity {
    private BarChart barChart;
    private MyLargeValueFormatter myLargeValueFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart_base);
        initNavBar(true,"BarChart之基础直方图");
        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        List<BarEntry> valsComp1 = new ArrayList<BarEntry>();
        List<BarEntry> valsComp2 = new ArrayList<BarEntry>();
        //幻灵新能源公司四个季度收入
        valsComp1.add(new BarEntry(0, 1009000f));
        valsComp1.add(new BarEntry(1, 1408000f));
        valsComp1.add(new BarEntry(2, 1205000f));
        valsComp1.add(new BarEntry(3, 1855000f));
        BarDataSet barDataSet1 = new BarDataSet(valsComp1,"幻灵新能源技术公司");
        barDataSet1.setColor(ColorTemplate.JOYFUL_COLORS[0]);

        //幻灵智能通信公司四个季度收入
        valsComp2.add(new BarEntry(0, 1308000f));
        valsComp2.add(new BarEntry(1, 1150000f));
        valsComp2.add(new BarEntry(2, 1006000f));
        valsComp2.add(new BarEntry(3, 1255000f));
        BarDataSet barDataSet2 = new BarDataSet(valsComp2,"幻灵智能通信技术公司");
        barDataSet2.setColor(ColorTemplate.getHoloBlue());


        BarData barData = new BarData(barDataSet1,barDataSet2);
        barData.setValueFormatter(myLargeValueFormatter);
        barData.setValueTextColor(getResources().getColor(R.color.colorAccent));
        //设置柱子宽度,(barWidth+barSpace)*2+groupSpace=1
        float groupSpace = 0.1f;
        float barSpace = 0.05f;
        float barWidth = 0.4f;
        barData.setBarWidth(barWidth);
        barData.groupBars(0, groupSpace, barSpace);
        barChart.setData(barData);
        barChart.getBarData().setBarWidth(barWidth);
        //下面三行为设置X轴标签居中显示，且让所有图在当前页显示完
        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0 +barChart.getBarData().getGroupWidth(groupSpace, barSpace) * 4);
        barChart.getXAxis().setCenterAxisLabels(true);//设置标签居中

        barChart.setFitBars(true); //X轴自适应所有柱形图
        barChart.invalidate();

    }

    /**
     * 初始化布局
     */
    private void initView() {
        //单位
        myLargeValueFormatter = new MyLargeValueFormatter();
        myLargeValueFormatter.setSuffix(Util.getTurnoverUnit());

        barChart = findViewById(R.id.base_barChart);
        barChart.animateXY(1000,1000);
        //设置表注解label
        Legend legend = barChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        //legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(true);

        //X轴设置
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(true);
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setLabelCount(4);
        xAxis.setValueFormatter(Util.getQuarterValue(xAxis));
        xAxis.setGranularity(1f);

        //Y轴设置
        YAxis yLeftAxis = barChart.getAxisLeft();
        yLeftAxis.setEnabled(true);
        yLeftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yLeftAxis.setDrawZeroLine(true);
        yLeftAxis.setZeroLineColor(Color.BLUE);
        yLeftAxis.setValueFormatter(myLargeValueFormatter);
        yLeftAxis.setAxisMinimum(0f);
        //左侧Y轴网格线设置为虚线
        yLeftAxis.enableGridDashedLine(10f, 10f, 0f);

        YAxis yRightAxis = barChart.getAxisRight();
        yRightAxis.setEnabled(false);

        //设置动画
        barChart.animateXY(1000,1000);

        String descriptionStr = "公司季度营业额";
        Util.setDescriptionPosition(this,barChart,descriptionStr);

    }
}
