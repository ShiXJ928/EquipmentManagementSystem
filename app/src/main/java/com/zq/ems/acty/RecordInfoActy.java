package com.zq.ems.acty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.adapter.RecordInfoAdapter;
import com.zq.ems.bean.EquipmentBean;
import com.zq.ems.bean.RecordBean;
import com.zq.ems.util.FullyGridLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AIERXUAN on 2018/6/21.
 */

public class RecordInfoActy extends BaseActy {

    private RecyclerView recyclerView;
    private List<String> list;
    private RecordInfoAdapter adapter;
    private RecyclerView unrecyclerView;
    private List<String> unlist;
    private RecordInfoAdapter unadapter;
    private Intent intent;
    private RecordBean recordBean;
    private TextView tv_title, tv_un_title, tv_nodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_record_info);
        initView();
    }

    private void initView() {
        intent = getIntent();
        recordBean = intent.getParcelableExtra("recordbean");
        initTitleBar(R.id.title, R.drawable.back, 0, recordBean.getLogtime().replace("T", " "), null, R.color.bg_blue1, R.color.white);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_un_title = (TextView) findViewById(R.id.tv_un_title);
        tv_nodata = (TextView) findViewById(R.id.tv_nodata);
        tv_title.setText("已" + recordBean.getAction() + "设备");
        tv_un_title.setText("未" + recordBean.getAction() + "设备");
        tv_nodata.setText("已全部" + recordBean.getAction());
        tv_nodata.setVisibility(View.GONE);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new FullyGridLayoutManager(this, 3));
        list = new ArrayList<>();
        List<String> stringList;
        String str1[] = recordBean.getTools().split(",");
        String str2[] = recordBean.getRightTools().split(",");
        list = Arrays.asList(str1);
        stringList = Arrays.asList(str2);
        adapter = new RecordInfoAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        unrecyclerView = (RecyclerView) findViewById(R.id.un_recycler_view);
        unrecyclerView.setLayoutManager(new FullyGridLayoutManager(this, 3));
        unlist = new ArrayList<>();
        if (recordBean.getMissQty() == 0) {
            tv_nodata.setVisibility(View.VISIBLE);
            unrecyclerView.setVisibility(View.GONE);
        } else {
            for (String strAll : stringList) {
                int i = 0;
                for (String strHas : list) {
                    if (strHas.equals(strAll)) {
                        i = 1;
                        break;
                    }
                }
                if (i==0){
                    unlist.add(strAll);
                }
            }
        }
        unadapter = new RecordInfoAdapter(this, unlist);
        unrecyclerView.setAdapter(unadapter);
        unrecyclerView.setHasFixedSize(true);
        unrecyclerView.setNestedScrollingEnabled(false);
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
}
