package com.zq.ems.acty;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zq.ems.R;
import com.zq.ems.application.App;
import com.zq.ems.util.ToastUtil;

/**
 * Created by sxj on 2016/10/20.
 */
public class ChangePwdActy extends BaseActy {

    private EditText et_old_pwd, et_new_pwd, et_enter_pwd;
    private Button btn_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_change_pwd);

        initView();
    }

    public void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "修改密码", null, R.color.bg_blue1, R.color.white);
        et_old_pwd = (EditText) findViewById(R.id.et_old_pwd);
        et_new_pwd = (EditText) findViewById(R.id.et_new_pwd);
        et_enter_pwd = (EditText) findViewById(R.id.et_enter_pwd);
        btn_enter = (Button) findViewById(R.id.btn_enter);
        btn_enter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_left:
                finish();
                break;
            case R.id.btn_enter:
                if (et_old_pwd.getText().toString().equals("") || et_new_pwd.getText().toString().equals("") || et_enter_pwd.getText().toString().equals("")) {
                    ToastUtil.show("输入不能为空");
                    break;
                }
                if (!et_new_pwd.getText().toString().equals(et_enter_pwd.getText().toString())) {
                    ToastUtil.show("两次密码不一致");
                    break;
                }
                if (et_old_pwd.getText().toString().equals(et_new_pwd.getText().toString())) {
                    ToastUtil.show("新密码和就旧密码不能相同");
                    break;
                }
                if (!et_old_pwd.getText().toString().equals(App.sharedUtility.getPwd())) {
                    ToastUtil.show("原密码输入错误");
                    break;
                }
                ToastUtil.show("保存成功");
                break;
        }
    }
}
