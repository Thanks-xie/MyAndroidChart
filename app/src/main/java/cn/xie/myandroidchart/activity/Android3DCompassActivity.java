package cn.xie.myandroidchart.activity;

import androidx.appcompat.app.AppCompatActivity;
import cn.xie.myandroidchart.R;
import cn.xie.myandroidchart.views.Compass3DView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Android3DCompassActivity extends BaseActivity {
    private Compass3DView compass3DView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android3_dcompass);
        initNavBar(true,"3D指南针");
        initView();
    }

    private void initView() {
        compass3DView = findViewById(R.id.compass_3d);
    }
}
