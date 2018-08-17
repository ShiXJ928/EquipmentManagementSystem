package com.zq.ems.acty;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.zq.ems.R;
import com.zq.ems.adapter.LendEquipmentListAdapter;
import com.zq.ems.adapter.OverdueEquipmentListAdapter;
import com.zq.ems.bean.OverdueEquipmentBean;

import java.util.ArrayList;
import java.util.List;

import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;

/**
 * Created by Administrator on 2018/6/8.
 */

public class LendEquipmentListActy extends BaseActy implements IXListViewListener, AdapterView.OnItemClickListener {

    private PullToRefreshSwipeMenuListView listView;
    private List<OverdueEquipmentBean> list;
    private LendEquipmentListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_lead_equipment_list);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "借出装备", null, R.color.bg_blue1, R.color.white);
        listView = (PullToRefreshSwipeMenuListView) findViewById(R.id.list);
        list = new ArrayList<>();
        //到期
        list.add(new OverdueEquipmentBean("催泪喷射器", "2018-06-04", "2018-04-22", "张三"));
        list.add(new OverdueEquipmentBean("防弹背心", "2018-05-18", "2018-02-27", "张三"));
        list.add(new OverdueEquipmentBean("发光指挥棒", "2018-05-31", "2018-05-16", "张三"));
        list.add(new OverdueEquipmentBean("防弹防刺服", "2018-06-07", "2018-06-01", "刘明"));
        adapter = new LendEquipmentListAdapter(this, list);
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
