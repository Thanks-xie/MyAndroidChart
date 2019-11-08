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
        dataList.add("LineBasic2D");
        
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
                        Intent intentBarMulti2D = new Intent(context,BarMulti2DActivity.class);
                        startActivity(intentBarMulti2D);
                        break;
                    case "BarStacked2D":
                        Intent intentBarStacked2D = new Intent(context,BarStacked2DActivity.class);
                        startActivity(intentBarStacked2D);
                        break;
                    case "Column2D":
                        Intent intentColumn2D = new Intent(context,Column2DActivity.class);
                        startActivity(intentColumn2D);
                        break;
                    case "Column3D":
                        Intent intentColumn3D = new Intent(context,Column3DActivity.class);
                        startActivity(intentColumn3D);
                        break;
                    case "ColumnMulti2D":
                        Intent intentColumnMulti2D = new Intent(context,ColumnMulti2DActivity.class);
                        startActivity(intentColumnMulti2D);
                        break;
                    case "ColumnMulti3D":
                        Intent intentColumnMulti3D = new Intent(context,ColumnMulti3DActivity.class);
                        startActivity(intentColumnMulti3D);
                        break;
                    case "ColumnStacked2D":
                        Intent intentColumnStacked2D = new Intent(context,ColumnStacked2DActivity.class);
                        startActivity(intentColumnStacked2D);
                        break;
                    case "ColumnStacked3D":
                        Intent intentColumnStacked3D = new Intent(context,ColumnStacked3DActivity.class);
                        startActivity(intentColumnStacked3D);
                        break;
                    case "LineBasic2D":
                        Intent intentLineBasic2D = new Intent(context,LineBasic2DActivity.class);
                        startActivity(intentLineBasic2D);
                        break;
                        default:break;
                }
            }
        });

    }
}
