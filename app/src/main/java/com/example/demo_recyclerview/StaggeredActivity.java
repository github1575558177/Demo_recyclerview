package com.example.demo_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘荣达 on 0009,2016/8/9.
 */
public class StaggeredActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initData();

        mAdapter = new MyAdapter(this, mDatas, R.layout.item_recyclerview_grid);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        //1.
        //mAdapter = new MyAdapter(this, mDatas, R.layout.item_recyclerview_grid);
        //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));//这个和GridLayoutManager显示的是一样的,都是垂直滑动的

        //2.
        mAdapter = new MyAdapter(this, mDatas, R.layout.item_recyclerview_grid2);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));//这个是水平滑动，不过item的布局文件也要稍微该一下，所以mAdapter要新创建一个


        //加入分割线（RecyclerView布局中没有divider或dividerHeight这样的属性）
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerGridItemDecoration.VERTICAL_LIST));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecyclerView.setAdapter(mAdapter);

        initEvent();
    }

    private void initEvent() {
        mAdapter.setmOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(StaggeredActivity.this, position + " click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(StaggeredActivity.this, position + " long click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'y'; i++) {
            mDatas.add("" + (char) i);
        }
    }
}
