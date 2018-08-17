package com.zq.ems.acty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.adapter.EnterApplyEquipmentListAdapter;
import com.zq.ems.bean.ApplyEquipmentBean;

import java.util.List;

import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;

/**
 * Created by SXJ on 2018/8/15 14:18
 * E-Mail Address：2394905398@qq.com
 */

public class EnterApplyEquipmentActy extends BaseActy implements IXListViewListener, AdapterView.OnItemClickListener {

    private EnterApplyEquipmentListAdapter adapter;
    private List<ApplyEquipmentBean> applyEquipmentBeanList;
    private PullToRefreshSwipeMenuListView listView;
    private TextView tv_submit;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_enter_apply_equipment);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "装备申请确认", null, R.color.bg_blue1, R.color.white);
        intent = getIntent();
        applyEquipmentBeanList = intent.getParcelableArrayListExtra("list");
        listView = (PullToRefreshSwipeMenuListView) findViewById(R.id.list);
        adapter = new EnterApplyEquipmentListAdapter(this, applyEquipmentBeanList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setPullRefreshEnable(false);
        listView.setPullLoadEnable(false);
        listView.setXListViewListener(this);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
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
