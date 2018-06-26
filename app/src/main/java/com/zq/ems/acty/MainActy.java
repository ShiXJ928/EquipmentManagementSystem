package com.zq.ems.acty;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brioal.adtextviewlib.view.ADTextView;
import com.brioal.adtextviewlib.view.OnAdChangeListener;
import com.zq.ems.R;
import com.zq.ems.util.ToastUtil;
import com.zq.ems.util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */

public class MainActy extends BaseActy {

    private LinearLayout ll_equipmenet_list, ll_my_info, ll_remind_list, ll_teaching_materia;
    private ADTextView mADTextView;
    private List<String> texts;
    private ImageView iv_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_main);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, 0, 0, "首页", "超期未还", R.color.bg_blue1, R.color.white);
        iv_bg = (ImageView) findViewById(R.id.iv_bg);
        iv_bg.setImageDrawable(Utility.getBitmap(this, R.drawable.bg_main));
        ll_equipmenet_list = (LinearLayout) findViewById(R.id.ll_equipmenet_list);
        ll_equipmenet_list.setOnClickListener(this);
        ll_my_info = (LinearLayout) findViewById(R.id.ll_my_info);
        ll_my_info.setOnClickListener(this);
        ll_remind_list = (LinearLayout) findViewById(R.id.ll_remind_list);
        ll_remind_list.setOnClickListener(this);
        ll_teaching_materia = (LinearLayout) findViewById(R.id.ll_teaching_materia);
        ll_teaching_materia.setOnClickListener(this);
        mADTextView = (ADTextView) findViewById(R.id.ad_textview);
        texts = new ArrayList<>();
        texts.add("请规范佩带您的单警装备");
        texts.add("请规使用带警用装备");
        texts.add("您的维修申请已审核通过，正在维修中");
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

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_right:
                startActivity(new Intent(MainActy.this, OverdueEquipmentListActy.class));
                break;
            case R.id.ll_equipmenet_list:
                startActivity(new Intent(MainActy.this, EquipmentListActy.class));
                break;
            case R.id.ll_my_info:
                startActivity(new Intent(MainActy.this, RecordListActy.class));
                break;
            case R.id.ll_remind_list:
                startActivity(new Intent(MainActy.this, RemindListActy.class));
                break;
            case R.id.ll_teaching_materia:
                startActivity(new Intent(MainActy.this, TeachingMateriaActy.class));
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
