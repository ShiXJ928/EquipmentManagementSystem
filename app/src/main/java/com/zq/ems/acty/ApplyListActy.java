package com.zq.ems.acty;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.zq.ems.R;
import com.zq.ems.adapter.ApplyListAdapter;
import com.zq.ems.bean.ApplyBean;

import java.util.ArrayList;
import java.util.List;

import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;

/**
 * Created by SXJ on 2018/8/15 15:26
 * E-Mail Address：2394905398@qq.com
 */

public class ApplyListActy extends BaseActy implements IXListViewListener, AdapterView.OnItemClickListener {

    private PullToRefreshSwipeMenuListView listView;
    private List<ApplyBean> list;
    private ApplyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.acty_list);
        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "审批列表", "历史记录", R.color.bg_blue1, R.color.white);
        listView = (PullToRefreshSwipeMenuListView) findViewById(R.id.list);
        list = new ArrayList<>();
        adapter = new ApplyListAdapter(this, list);
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
