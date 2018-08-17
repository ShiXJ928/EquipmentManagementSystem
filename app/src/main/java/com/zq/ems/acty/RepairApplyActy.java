package com.zq.ems.acty;

import android.os.Bundle;
import android.view.View;

import com.zq.ems.R;

/**
 * Created by SXJ on 2018/8/10 09:51
 * E-Mail Address：2394905398@qq.com
 */

public class RepairApplyActy extends BaseActy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_repair_apply);

        initView();
    }

    private void initView(){
        initTitleBar(R.id.title, R.drawable.back, 0, "维修申请", null, R.color.bg_blue1, R.color.white);
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
