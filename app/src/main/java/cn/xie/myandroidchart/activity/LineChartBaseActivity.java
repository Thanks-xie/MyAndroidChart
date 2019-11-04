package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.utils.MyLargeValueFormatter;
import cn.xie.myandroidchart.utils.Util;
import cn.xie.myandroidchart.views.MyCustomMarkerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class LineChartBaseActivity extends BaseActivity {
    private LineChart lineChart;
    private MyLargeValueFormatter largeValueFormatter;
    private MyCustomMarkerView myCustomMarkerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart_base);
        context = this;
        initNavBar(true,"LineChart之基础折线图");
        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //公司1数据
        List<Entry> company1 = new ArrayList<>();
        company1.add(new Entry(0,14800000f));
        company1.add(new Entry(1,19900000f));
        company1.add(new Entry(2,15500000f));
        company1.add(new Entry(3,18800000f));

        LineDataSet dataSet1 = new LineDataSet(company1,"幻灵通讯技术有限公司");
        dataSet1.setColor(ColorTemplate.getHoloBlue());
        dataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);

        //公司2数据
        List<Entry> company2 = new ArrayList<>();
        company2.add(new Entry(0,19800000f));
        company2.add(new Entry(1,14900000f));
        company2.add(new Entry(2,18500000f));
        company2.add(new Entry(3,16800000f));

        LineDataSet dataSet2 = new LineDataSet(company2,"幻灵新能源有限公司");
        dataSet2.setColor(ColorTemplate.JOYFUL_COLORS[1]);
        dataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);


        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet1);
        dataSets.add(dataSet2);

        LineData lineData = new LineData(dataSets);
        //设置折线图每个节点显示值单位(K)
        lineData.setValueFormatter(largeValueFormatter);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        //单位
        largeValueFormatter = new MyLargeValueFormatter();
        largeValueFormatter.setSuffix(Util.getTurnoverUnit());

        lineChart = findViewById(R.id.base_lineChart);
        //X轴设置
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(true);
        xAxis.setAvoidFirstLastClipping(true);
        xAxis.setValueFormatter(Util.getQuarterValue());
        xAxis.setGranularity(1f);

        //Y轴设置
        YAxis yLeftAxis = lineChart.getAxisLeft();
        yLeftAxis.setEnabled(true);
        yLeftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yLeftAxis.setDrawZeroLine(true);
        yLeftAxis.setZeroLineColor(Color.BLUE);
        yLeftAxis.setValueFormatter(largeValueFormatter);
        yLeftAxis.setAxisMinimum(0f);

        YAxis yRightAxis = lineChart.getAxisRight();
        yRightAxis.setEnabled(false);

        //设置动画
        lineChart.animateXY(1000,1000);

        //设置表注解label
        Legend legend = lineChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setDrawInside(true);

        String descriptionStr = "公司季度营业额";
        Util.setDescriptionPosition(this,lineChart,descriptionStr);

        lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                myCustomMarkerView = new MyCustomMarkerView(context,R.layout.custom_marker_view_layout);
                myCustomMarkerView.setChartView(lineChart);
                lineChart.setMarker(myCustomMarkerView);
            }

            @Override
            public void onNothingSelected() {
            }
        });

    }
}
