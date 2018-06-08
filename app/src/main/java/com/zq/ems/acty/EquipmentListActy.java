package com.zq.ems.acty;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.zq.ems.R;
import com.zq.ems.adapter.EquipmentListAdapter;
import com.zq.ems.bean.EquipmentBean;

import java.util.ArrayList;
import java.util.List;

import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class EquipmentListActy extends BaseActy implements IXListViewListener, AdapterView.OnItemClickListener {

    private PullToRefreshSwipeMenuListView listView;
    private List<EquipmentBean> list;
    private EquipmentListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_list);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "我的设备", null, R.color.bg_blue1, R.color.white);
        listView = (PullToRefreshSwipeMenuListView) findViewById(R.id.list);
        list = new ArrayList<>();
        //到期
        list.add(new EquipmentBean("drawable://" + R.drawable.tear_ejector, "催泪喷射器", "使用中", "2018-09-22", 1));
        list.add(new EquipmentBean("drawable://" + R.drawable.riot_helmet, "防暴头盔", "使用中", "2019-05-12", 1));
        //充电
        list.add(new EquipmentBean("drawable://" + R.drawable.interphone, "对讲机", "使用中", "2018-05-20", 2));
        list.add(new EquipmentBean("drawable://" + R.drawable.shoulder_lamp, "肩灯", "使用中", "2018-05-17", 2));
        list.add(new EquipmentBean("drawable://" + R.drawable.flashlight, "强光手电", "使用中", "2018-06-01", 2));
        list.add(new EquipmentBean("drawable://" + R.drawable.law_enforcement_instrument, "执法仪", "使用中", "2018-06-04", 2));
        //其他
        list.add(new EquipmentBean("drawable://" + R.drawable.multifunction_belt, "多功能腰带", "在库", "", 3));
        list.add(new EquipmentBean("drawable://" + R.drawable.cut_resistant_gloves, "防割手套", "使用中", "", 3));
        list.add(new EquipmentBean("drawable://" + R.drawable.telescopic_baton, "伸缩警棍", "使用中", "", 3));
        list.add(new EquipmentBean("drawable://" + R.drawable.handcuffs, "手铐", "使用中", "", 3));

        //        list.add(new EquipmentBean("drawable://" + R.drawable.electric_horn, "电喇叭", "使用中", "2018-05-20 17:20"));
//        list.add(new EquipmentBean("drawable://" + R.drawable.luminescent_baton, "发光指挥棒", "使用中", "2018-05-17 08:56"));
//        list.add(new EquipmentBean("drawable://" + R.drawable.reflective_vest, "反光背心", "使用中", ""));
//        list.add(new EquipmentBean("drawable://" + R.drawable.riot_shield, "防暴盾牌", "使用中", ""));
//        list.add(new EquipmentBean("drawable://" + R.drawable.bulletproof_vest, "防弹背心", "维修中", "2018-06-01 10:18"));
//        list.add(new EquipmentBean("", "防弹防刺服", "维修中", ""));
//        list.add(new EquipmentBean("", "防弹头盔", "", ""));
//        list.add(new EquipmentBean("", "喊话器", "", ""));
//        list.add(new EquipmentBean("", "警戒带", "", ""));
//        list.add(new EquipmentBean("", "警绳", "", ""));
//        list.add(new EquipmentBean("", "警用急救包", "", ""));
//        list.add(new EquipmentBean("", "警用执勤灯", "", ""));
//        list.add(new EquipmentBean("", "救生绳", "", ""));
//        list.add(new EquipmentBean("", "路障破胎器", "", ""));
//        list.add(new EquipmentBean("", "勤务头盔", "", ""));
//        list.add(new EquipmentBean("", "伸缩锥型路障", "", ""));
//        list.add(new EquipmentBean("", "停车示意牌", "", ""));
//        list.add(new EquipmentBean("", "应急灯", "", ""));
//        list.add(new EquipmentBean("", "约束带", "", ""));

        adapter = new EquipmentListAdapter(this, list);
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
