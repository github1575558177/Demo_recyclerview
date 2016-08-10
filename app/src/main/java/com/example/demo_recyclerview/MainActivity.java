package com.example.demo_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLiear, btnGrid, btnStaggered, btnStaggered2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnLiear.setOnClickListener(this);
        btnGrid.setOnClickListener(this);
        btnStaggered.setOnClickListener(this);
        btnStaggered2.setOnClickListener(this);
    }

    private void initView() {
        btnLiear = (Button) findViewById(R.id.btn_linear);
        btnGrid = (Button) findViewById(R.id.btn_gridlayout);
        btnStaggered = (Button) findViewById(R.id.btn_staggeredgridlayout);
        btnStaggered2 = (Button) findViewById(R.id.btn_staggeredgridlayout2);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_linear){
            Intent intent = new Intent(this, LinearActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.btn_gridlayout) {
            Intent intent = new Intent(this, GridActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.btn_staggeredgridlayout) {
            Intent intent = new Intent(this, StaggeredActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.btn_staggeredgridlayout2) {
            Intent intent = new Intent(this, StaggeredGridLayoutActivity.class);
            startActivity(intent);
        }
    }
}
