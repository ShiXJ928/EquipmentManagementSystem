package com.zq.ems.acty;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brioal.adtextviewlib.view.ADTextView;
import com.brioal.adtextviewlib.view.OnAdChangeListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.zq.ems.R;
import com.zq.ems.application.App;
import com.zq.ems.util.ToastUtil;
import com.zq.ems.util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */

public class MainActy extends BaseActy {

    private LinearLayout ll_equipmenet_list, ll_equipment_apply, ll_message, ll_car_apply;
    private ADTextView mADTextView;
    private List<String> texts;
    private ImageView iv_bg;
    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_main);

        initView();
        initMenu();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.icon_menu, 0, "首页", null, R.color.bg_blue1, R.color.white);
        iv_bg = (ImageView) findViewById(R.id.iv_bg);
        iv_bg.setImageDrawable(Utility.getBitmap(this, R.drawable.bg_main));
        ll_equipmenet_list = (LinearLayout) findViewById(R.id.ll_equipmenet_list);
        ll_equipmenet_list.setOnClickListener(this);
        ll_equipment_apply = (LinearLayout) findViewById(R.id.ll_equipment_apply);
        ll_equipment_apply.setOnClickListener(this);
        ll_message = (LinearLayout) findViewById(R.id.ll_message);
        ll_message.setOnClickListener(this);
        ll_car_apply = (LinearLayout) findViewById(R.id.ll_car_apply);
        ll_car_apply.setOnClickListener(this);
        mADTextView = (ADTextView) findViewById(R.id.ad_textview);
        texts = new ArrayList<>();
        texts.add("请规范佩带您的单警装备");
        texts.add("请规使用警用装备");
        texts.add("您的维修申请已审核通过，正在维修");
        mADTextView.setInterval(2000);
        mADTextView.init(texts, new OnAdChangeListener() {
            @Override
            public void DiyTextView(TextView textView, final int index) {
                textView.setTextSize(20);
                textView.setTextColor(Color.RED);
//                SpannableStringBuilder builder = new SpannableStringBuilder(textView.getText());
//                builder.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                textView.setText(builder);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }

        });
    }

    private void initMenu() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.3f);
        menu.setOffsetFadeDegree(0.4f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.ll_menu);
        findViewById(R.id.ll_info).setOnClickListener(this);
        findViewById(R.id.ll_apply).setOnClickListener(this);
        findViewById(R.id.ll_materia).setOnClickListener(this);
        findViewById(R.id.ll_lead).setOnClickListener(this);
        findViewById(R.id.ll_pwd).setOnClickListener(this);
        findViewById(R.id.ll_out).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_left:
                menu.showMenu(true);
                break;
            case R.id.ll_equipmenet_list:
                startActivity(new Intent(MainActy.this, EquipmentListActy.class));
                break;
            case R.id.ll_equipment_apply:
                startActivity(new Intent(MainActy.this, ApplyEquipmentActy.class));
                break;
            case R.id.ll_message:
                startActivity(new Intent(MainActy.this, RemindListActy.class));
                break;
            case R.id.ll_car_apply:
                break;
            case R.id.ll_info:
                startActivity(new Intent(MainActy.this, MyInfoActy.class));
                break;
            case R.id.ll_apply:
                startActivity(new Intent(MainActy.this, ApplyListActy.class));
                break;
            case R.id.ll_materia:
                startActivity(new Intent(MainActy.this, TeachingMateriaActy.class));
                break;
            case R.id.ll_pwd:
                startActivity(new Intent(MainActy.this, ChangePwdActy.class));
                break;
            case R.id.ll_out:
                App.loginOut();
                finish();
                startActivity(new Intent(MainActy.this, LoginActy.class));
                break;
            case R.id.ll_lead:
//                startActivity(new Intent(MainActy.this, OverdueEquipmentListActy.class));
                startActivity(new Intent(MainActy.this, LendEquipmentListActy.class));
                break;
        }
    }

    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long secondTime = System.currentTimeMillis();
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (secondTime - firstTime < 2000) {
                System.exit(0);
            } else {
                ToastUtil.show("再按一次退出程序");
                firstTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
