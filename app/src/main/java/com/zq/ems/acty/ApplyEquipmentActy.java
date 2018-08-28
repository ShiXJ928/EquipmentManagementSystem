package com.zq.ems.acty;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zq.ems.R;
import com.zq.ems.adapter.ApplyEquipmentListAdapter;
import com.zq.ems.adapter.SpinnerAdapter;
import com.zq.ems.bean.ApplyEquipmentBean;
import com.zq.ems.bean.TypeBean;
import com.zq.ems.util.Dimension;
import com.zq.ems.util.ToastUtil;
import com.zq.ems.util.Utility;
import com.zq.ems.view.ChooseTimeDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;
import edu.swu.pulltorefreshswipemenulistview.library.swipemenu.bean.SwipeMenu;
import edu.swu.pulltorefreshswipemenulistview.library.swipemenu.bean.SwipeMenuItem;
import edu.swu.pulltorefreshswipemenulistview.library.swipemenu.interfaces.OnMenuItemClickListener;
import edu.swu.pulltorefreshswipemenulistview.library.swipemenu.interfaces.SwipeMenuCreator;

/**
 * Created by SXJ on 2018/8/9 16:46
 * E-Mail Address：2394905398@qq.com
 */

public class ApplyEquipmentActy extends BaseActy implements IXListViewListener, AdapterView.OnItemClickListener {

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private SpinnerAdapter adapter1;
    private SpinnerAdapter adapter2;
    private SpinnerAdapter adapter3;
    private List<TypeBean> list;
    private List<String> stringList1;
    private List<String> stringList2;
    private List<String> stringList3;
    private ArrayList<ApplyEquipmentBean> applyEquipmentBeanList;
    private ApplyEquipmentListAdapter adapter;
    private PullToRefreshSwipeMenuListView listView;
    private TextView tv_submit,tv_time;
    private Intent intent;
    private Calendar ca = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_appaly_equipment);

        initView();
        initCreator();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, R.drawable.icon_add, "装备申请", null, R.color.bg_blue1, R.color.white);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        list = JSON.parseArray("[{\n" +
                "\t\"name1\": \"大类1\",\n" +
                "\t\"list\": [{\n" +
                "\t\t\"name2\": \"小类11\",\n" +
                "\t\t\"list\": [{\n" +
                "\t\t\t\"name3\": \"类型111\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型112\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型113\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型114\"\n" +
                "\t\t}]\n" +
                "\t}, {\n" +
                "\t\t\"name2\": \"小类12\",\n" +
                "\t\t\"list\": [{\n" +
                "\t\t\t\"name3\": \"类型121\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型122\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型123\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型124\"\n" +
                "\t\t}]\n" +
                "\t}]\n" +
                "}, {\n" +
                "\t\"name1\": \"大类2\",\n" +
                "\t\"list\": [{\n" +
                "\t\t\"name2\": \"小类21\",\n" +
                "\t\t\"list\": [{\n" +
                "\t\t\t\"name3\": \"类型211\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型212\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型213\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型214\"\n" +
                "\t\t}]\n" +
                "\t}, {\n" +
                "\t\t\"name2\": \"小类22\",\n" +
                "\t\t\"list\": [{\n" +
                "\t\t\t\"name3\": \"类型221\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型222\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型223\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型224\"\n" +
                "\t\t}]\n" +
                "\t}]\n" +
                "}, {\n" +
                "\t\"name1\": \"大类3\",\n" +
                "\t\"list\": [{\n" +
                "\t\t\"name2\": \"小类31\",\n" +
                "\t\t\"list\": [{\n" +
                "\t\t\t\"name3\": \"类型311\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型312\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型313\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型314\"\n" +
                "\t\t}]\n" +
                "\t}, {\n" +
                "\t\t\"name2\": \"小类32\",\n" +
                "\t\t\"list\": [{\n" +
                "\t\t\t\"name3\": \"类型321\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型322\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型323\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"name3\": \"类型324\"\n" +
                "\t\t}]\n" +
                "\t}]\n" +
                "}]", TypeBean.class);
        stringList1 = new ArrayList<>();
        stringList2 = new ArrayList<>();
        stringList3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            stringList1.add(list.get(i).getName1());
        }
        adapter1 = new SpinnerAdapter(this, stringList1);
        spinner1.setAdapter(adapter1);
        adapter2 = new SpinnerAdapter(ApplyEquipmentActy.this, stringList2);
        spinner2.setAdapter(adapter2);
        adapter3 = new SpinnerAdapter(ApplyEquipmentActy.this, stringList3);
        spinner3.setAdapter(adapter3);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                stringList2.clear();
                for (int i = 0; i < list.get(position).getList().size(); i++) {
                    stringList2.add(list.get(position).getList().get(i).getName2());
                }
                Log.e("------------->", "spinner1点击");
                adapter2.notifyDataSetChanged();
                spinner2.setSelection(0, true);
                stringList3.clear();
                for (int i = 0; i < list.get(position).getList().get(0).getList().size(); i++) {
                    stringList3.add(list.get(position).getList().get(0).getList().get(i).getName3());
                }
                adapter3.notifyDataSetChanged();
                spinner3.setSelection(0, true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                stringList3.clear();
                for (int i = 0; i < list.get(spinner1.getSelectedItemPosition()).getList().get(position).getList().size(); i++) {
                    stringList3.add(list.get(spinner1.getSelectedItemPosition()).getList().get(position).getList().get(i).getName3());
                }
                Log.e("------------->", "spinner2点击");
//                spinner3.setSelection(0, true);
                adapter3.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //让第一个数据项已经被选中
        spinner1.setSelection(0, true);
        applyEquipmentBeanList = new ArrayList<>();
        listView = (PullToRefreshSwipeMenuListView) findViewById(R.id.list);
        adapter = new ApplyEquipmentListAdapter(this, applyEquipmentBeanList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setPullRefreshEnable(false);
        listView.setPullLoadEnable(false);
        listView.setXListViewListener(this);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_time.setOnClickListener(this);
        tv_time.setText(Utility.getNowTime("yyyy-MM-dd"));
        tv_submit = (TextView) findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(this);
    }

    private void initCreator() {
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @TargetApi(23)
            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem deleteitem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteitem.setBackground(new ColorDrawable(getResources().getColor(R.color.bg_red)));
                // set item width
                deleteitem.setWidth(Dimension.dp2px(90));
                // set item title
                deleteitem.setTitle("删除");
                // set item title fontsize
                deleteitem.setTitleSize(18);
                // set item title font color
                deleteitem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(deleteitem);
            }
        };
        // set creator
        listView.setMenuCreator(creator);

//         step 2. listener item click event
        listView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        //删除
                        applyEquipmentBeanList.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_left:
                finish();
                break;
            case R.id.tb_right:
                int i = 0;
                for (ApplyEquipmentBean bean : applyEquipmentBeanList) {
                    if (spinner3.getSelectedItem().toString().equals(bean.getName())) {
                        i++;
                        ToastUtil.show("装备申请已经加入");
                        break;
                    }
                }
                if (i == 0) {
                    applyEquipmentBeanList.add(new ApplyEquipmentBean(spinner3.getSelectedItem().toString(), 1));
                    adapter.notifyDataSetChanged();
//                    Log.e("-------->", spinner3.getSelectedItem().toString());
                }
                break;
            case R.id.tv_time:
                new ChooseTimeDialog(this, new ChooseTimeDialog.Onclick() {
                    @Override
                    public void sure(Date d) {
                        ca.setTime(d);
                        tv_time.setText(Utility.dateToStr(d,"yyyy-MM-dd"));
                    }
                }, ca).show();
                break;
            case R.id.tv_submit:
                if (applyEquipmentBeanList.size() == 0) {
                    ToastUtil.show("申请列表不能为空");
                } else {
                    intent = new Intent(ApplyEquipmentActy.this, EnterApplyEquipmentActy.class);
                    intent.putExtra("list", applyEquipmentBeanList);
                    startActivity(intent);
                }
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
