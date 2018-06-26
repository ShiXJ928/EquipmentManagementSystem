package com.zq.ems.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.acty.BaseActy;
import com.zq.ems.bean.RecordBean;

import java.util.List;

/**
 * Created by AIERXUAN on 2018/6/21.
 */

public class RecordListAdapter extends BaseAdapter {

    private List<RecordBean> list;
    private BaseActy context;
    private LayoutInflater mInflater;

    public RecordListAdapter(Context context, List<RecordBean> list) {
        mInflater = LayoutInflater.from(context);
        this.context = (BaseActy) context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view;
        ViewHolder holder = null;
        RecordBean bean = list.get(position);
        // 判断convertView的状态，来达到复用效果
        if (null == convertView) {
            //如果convertView为空，则表示第一次显示该条目，需要创建一个view
            view = View.inflate(context, R.layout.item_record, null);
            holder = new ViewHolder();
            holder.tv_action = (TextView) view.findViewById(R.id.tv_action);
            holder.tv_time = (TextView) view.findViewById(R.id.tv_time);
            holder.tv_num1 = (TextView) view.findViewById(R.id.tv_num1);
            holder.tv_num2 = (TextView) view.findViewById(R.id.tv_num2);
            // 将holder与view进行绑定
            view.setTag(holder);
        } else {
            //否则表示可以复用convertView
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_action.setText(bean.getAction());
        holder.tv_time.setText(bean.getLogtime().replace("T", " "));
        holder.tv_num1.setText(bean.getRightQty() + "");
        holder.tv_num2.setText(bean.getMissQty() + "");
        return view;
    }

    public class ViewHolder {
        TextView tv_action, tv_time, tv_num1, tv_num2;
    }
}
