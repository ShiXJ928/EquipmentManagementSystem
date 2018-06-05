package com.zq.ems.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.acty.BaseActy;
import com.zq.ems.bean.RemindBean;

import java.util.List;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class RemindListAdapter extends BaseAdapter {

    private List<RemindBean> list;
    private BaseActy context;
    private LayoutInflater mInflater;

    public RemindListAdapter(Context context, List<RemindBean> list) {
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
        RemindBean bean = list.get(position);
        // 判断convertView的状态，来达到复用效果
        if (null == convertView) {
            //如果convertView为空，则表示第一次显示该条目，需要创建一个view
            view = View.inflate(context, R.layout.item_remind, null);
            holder = new ViewHolder();
            holder.tv_content = (TextView) view.findViewById(R.id.tv_content);
            holder.tv_time = (TextView) view.findViewById(R.id.tv_time);
            // 将holder与view进行绑定
            view.setTag(holder);
        } else {
            //否则表示可以复用convertView
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_content.setText(bean.getContent());
        holder.tv_time.setText(bean.getTime());
        return view;
    }

    public class ViewHolder {
        TextView tv_content, tv_time;
    }
}
