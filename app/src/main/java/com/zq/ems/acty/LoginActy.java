package com.zq.ems.acty;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.application.App;
import com.zq.ems.util.ToastUtil;
import com.zq.ems.util.Utility;

/**
 * Created by Administrator on 2018/4/16.
 */

public class LoginActy extends BaseActy {

    private EditText et_account, et_pwd;
    private TextView tv_login;
    private ImageView iv_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_login);

        initView();
    }

    private void initView() {
        iv_bg = (ImageView) findViewById(R.id.iv_bg);
        iv_bg.setImageDrawable(Utility.getBitmap(this, R.drawable.bg_login));
        et_account = (EditText) findViewById(R.id.et_account);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_login.setOnClickListener(this);
        et_account.setText(App.sharedUtility.getAccount());
        et_pwd.setText(App.sharedUtility.getPwd());
        et_account.setText(App.sharedUtility.getAccount());
        et_pwd.setText(App.sharedUtility.getPwd());
//        if (App.sharedUtility.getPwd() == null || App.sharedUtility.getPwd().equals("")) {
//
//        } else {
//            login();
//        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_login:
                if (et_account.getText().toString().equals("")) {
                    ToastUtil.show("用户名不能为空!");
                    break;
                }
                if (et_pwd.getText().toString().equals("")) {
                    ToastUtil.show("密码不能为空!");
                    break;
                }
                if (et_pwd.getText().toString().equals("111111") || et_account.getText().toString().equals("zqtest")) {
                    login();
                }else {
                    ToastUtil.show("账号或密码错误!");
                }
                break;
        }
    }

    private void login() {
        App.sharedUtility.setAccount(et_account.getText().toString());
        App.sharedUtility.setPwd(et_pwd.getText().toString());
        startActivity(new Intent(LoginActy.this, MainActy.class));
        finish();
//        dlg.show();
//        JSONObject post = new JSONObject();
//        post.put("email", et_account.getText().toString());
//        post.put("passwd", et_pwd.getText().toString());
//        new NetPostMethod(this, NetUrl.POST_LOGIN, App.cachedThreadPool, post) {
//
//            @Override
//            public void runSuccsess(Result r) {
//
//            }
//
//            @Override
//            public void serverfail() {
//                dlg.dismiss();
//                showServerWarinning();
//            }
//
//            @Override
//            public void runfail(Context ctx, String message) {
//                dlg.dismiss();
//                showFailWarinning(ctx, message);
//            }
//        };
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
