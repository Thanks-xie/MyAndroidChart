package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class IChartJSActivity extends BaseActivity {
    private ListView listView;
    private Context context;
    private ArrayAdapter adapter;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ichart_js);
        context = this;
        initNavBar(true,"基于IChartJS实现Android图表");
        initView();
        initData();
    }

    private void initData() {
        dataList.add("Area2D");
        dataList.add("Bar2D");
        dataList.add("BarMulti2D");
        dataList.add("BarStacked2D");
        dataList.add("Column2D");
        dataList.add("Column3D");
        dataList.add("ColumnMulti2D");
        dataList.add("ColumnMulti3D");
        dataList.add("ColumnStacked2D");
        dataList.add("ColumnStacked3D");
        dataList.add("Coordinate2D");
        dataList.add("Coordinate3D");
        dataList.add("Donut2D");
        dataList.add("LineBasic2D");
        dataList.add("Pie2D");
        dataList.add("Pie3D");
        dataList.add("Sector2D");
        dataList.add("Sector3D");
        adapter = new ArrayAdapter(context,android.R.layout.simple_expandable_list_item_1,dataList);
        listView.setAdapter(adapter);

    }

    private void initView() {
        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chart = dataList.get(position);
                switch (chart){
                    case "Area2D":
                        Intent intent = new Intent(context,Area2DActivity.class);
                        startActivity(intent);
                        break;
                    case "Bar2D":
                        Intent intentBar2D = new Intent(context,Bar2DActivity.class);
                        startActivity(intentBar2D);
                        break;
                    case "BarMulti2D":
                        Intent BarMulti2D = new Intent(context,BarMulti2DActivity.class);
                        startActivity(BarMulti2D);
                        break;
                    case "BarStacked2D":
                        Intent BarStacked2D = new Intent(context,BarStacked2DActivity.class);
                        startActivity(BarStacked2D);
                        break;
                    case "Column2D":
                        break;
                    case "Column3D":
                        break;
                    case "ColumnMulti2D":
                        break;
                    case "ColumnMulti3D":
                        break;
                    case "ColumnStacked2D":
                        break;
                    case "ColumnStacked3D":
                        break;
                    case "Coordinate2D":
                        break;
                    case "Coordinate3D":
                        break;
                    case "Donut2D":
                        break;
                    case "LineBasic2D":
                        break;
                    case "Pie2D":
                        break;
                    case "Pie3D":
                        break;
                    case "Sector2D":
                        break;
                    case "Sector3D":
                        break;
                        default:break;
                }
            }
        });

    }
}
