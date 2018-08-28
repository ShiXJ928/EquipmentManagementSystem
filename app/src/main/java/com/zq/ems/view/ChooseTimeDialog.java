package com.zq.ems.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.zq.ems.R;

import java.util.Calendar;
import java.util.Date;

public class ChooseTimeDialog extends Dialog {
    private TextView sure;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Calendar ca = Calendar.getInstance();

    public interface Onclick {
        void sure(Date d);
    }

    private void assignViews() {
        sure = (TextView) findViewById(R.id.sure);
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        timePicker = (TimePicker) findViewById(R.id.time_picker);
    }

    public ChooseTimeDialog(Context context, final Onclick onclick, Calendar c) {
        super(context, R.style.dialog);
        setContentView(R.layout.dlg_time_choose);
        assignViews();
        timePicker.setVisibility(View.GONE);
        if (c.getTimeInMillis() <= new Date().getTime()) {
            c.setTime(new Date());
        }
        datePicker.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), null);
        datePicker.setMinDate(new Date().getTime() - 1000);
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ca.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                onclick.sure(ca.getTime());
                dismiss();
            }
        });
        ChooseTimeDialog.this.setCanceledOnTouchOutside(true);
    }
}
