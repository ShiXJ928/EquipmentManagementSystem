package com.zq.ems.acty;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.zq.ems.R;
import com.zq.ems.adapter.RemindListAdapter;
import com.zq.ems.bean.RemindBean;

import java.util.ArrayList;
import java.util.List;

import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class RemindListActy extends BaseActy implements IXListViewListener, AdapterView.OnItemClickListener {

    private PullToRefreshSwipeMenuListView listView;
    private List<RemindBean> list;
    private RemindListAdapter adapter;

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
        list.add(new RemindBean("伸缩警棍超期未归", "2018-06-03 18:00"));
        list.add(new RemindBean("2018.06.05出警时未携带强光手电", "2018-06-06 09:05"));
        list.add(new RemindBean("催泪喷射器即将过期，请及时更换", "2018-05-18 20:21"));
//        list.add(new RemindBean("您的设备已经过期", "2018-05-21 14:32"));
        list.add(new RemindBean("对讲机长时间未充电，请及时充电", "2018-06-21 17:22"));
        adapter = new RemindListAdapter(this, list);
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
