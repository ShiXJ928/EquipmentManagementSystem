package com.zq.ems.acty;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.zq.ems.R;
import com.zq.ems.adapter.CarListAdapter;
import com.zq.ems.bean.Car;

import java.util.ArrayList;
import java.util.List;

import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;

/**
 * Created by SXJ on 2018/7/19 09:48
 * E-Mail Address：2394905398@qq.com
 */

public class ApplyCarListActy extends BaseActy implements IXListViewListener, AdapterView.OnItemClickListener{

    private PullToRefreshSwipeMenuListView listView;
    private List<Car> list;
    private CarListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_list);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "提醒消息", null, R.color.bg_blue1, R.color.white);
        listView = (PullToRefreshSwipeMenuListView) findViewById(R.id.list);
        list = new ArrayList<>();
        for (int i=0;i<24;i++){
            list.add(new Car());
        }
        adapter = new CarListAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setPullRefreshEnable(false);
        listView.setPullLoadEnable(false);
        listView.setXListViewListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_left:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
