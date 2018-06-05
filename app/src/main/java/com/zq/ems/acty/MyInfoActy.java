package com.zq.ems.acty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.application.App;
import com.zq.ems.util.ToastUtil;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class MyInfoActy extends BaseActy {

    private EditText et_name;
    private TextView tv_place, tv_type, tv_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_my_info);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "我的信息", "修改密码", R.color.bg_blue1, R.color.white);
        et_name = (EditText) findViewById(R.id.et_name);
        et_name.setText(App.sharedUtility.getName());
        tv_place = (TextView) findViewById(R.id.tv_place);
        tv_type = (TextView) findViewById(R.id.tv_type);
        tv_place.setText("苏州市局");
        tv_type.setText("辅警");
        tv_save = (TextView) findViewById(R.id.tv_save);
        tv_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_left:
                finish();
                break;
            case R.id.tv_right:
                startActivity(new Intent(MyInfoActy.this, ChangePwdActy.class));
                break;
            case R.id.tv_save:
                if (et_name.getText().toString().equals("")) {
                    ToastUtil.show("姓名不能为空");
                    break;
                }
                App.sharedUtility.setName(et_name.getText().toString());
                ToastUtil.show("保存成功");
                finish();
                break;
        }
    }
}
