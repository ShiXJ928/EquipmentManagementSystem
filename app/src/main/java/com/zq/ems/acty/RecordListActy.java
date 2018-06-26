package com.zq.ems.acty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.alibaba.fastjson.JSON;
import com.zq.ems.R;
import com.zq.ems.adapter.RecordListAdapter;
import com.zq.ems.application.App;
import com.zq.ems.bean.RecordBean;
import com.zq.ems.bean.Result;
import com.zq.ems.net.NetGetMethod;
import com.zq.ems.net.NetUrl;

import java.util.ArrayList;
import java.util.List;

import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;

/**
 * Created by AIERXUAN on 2018/6/21.
 */

public class RecordListActy extends BaseActy implements IXListViewListener, AdapterView.OnItemClickListener {

    private PullToRefreshSwipeMenuListView listView;
    private List<RecordBean> list;
    private RecordListAdapter adapter;

    private interface refreshSuccess {
        void success();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_record_list);

        initView();
        getRecordList(new refreshSuccess() {
            @Override
            public void success() {
                adapter.notifyDataSetChanged();
                dlg.dismiss();
            }
        });
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "出入信息", null, R.color.bg_blue1, R.color.white);
        listView = (PullToRefreshSwipeMenuListView) findViewById(R.id.list);
        list = new ArrayList<>();
        adapter = new RecordListAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setPullRefreshEnable(true);
        listView.setPullLoadEnable(false);
        listView.setXListViewListener(this);
    }

    private void getRecordList(final refreshSuccess success) {
        dlg.show();
        new NetGetMethod(this, NetUrl.GET_RECORD_LIST, App.cachedThreadPool) {

            @Override
            public void runSuccsess(final Result r) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();
                        list.addAll(JSON.parseArray(r.getRecords().toString(), RecordBean.class));
                        success.success();
                    }
                });
            }

            @Override
            public void serverfail() {
                showServerWarinning();
            }

            @Override
            public void runfail(Context ctx, String message) {
                showFailWarinning(ctx, message);
            }

            @Override
            public void netfinal() {
                super.netfinal();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dlg.dismiss();
                    }
                });
            }
        };
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
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(RecordListActy.this, RecordInfoActy.class);
        intent.putExtra("recordbean", list.get(position - 1));
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        getRecordList(new refreshSuccess() {
            @Override
            public void success() {
                listView.stopRefresh();
                adapter.notifyDataSetChanged();
                dlg.dismiss();
            }
        });
    }

    @Override
    public void onLoadMore() {

    }
}
