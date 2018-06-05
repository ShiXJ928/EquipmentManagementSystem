package com.zq.ems.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.acty.BaseActy;
import com.zq.ems.bean.EquipmentBean;
import com.zq.ems.util.Utility;

import java.util.List;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class EquipmentListAdapter extends BaseAdapter {

    private List<EquipmentBean> list;
    private BaseActy context;
    private LayoutInflater mInflater;

    public EquipmentListAdapter(Context context, List<EquipmentBean> list) {
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
        EquipmentBean bean = list.get(position);
        // 判断convertView的状态，来达到复用效果
        if (null == convertView) {
            //如果convertView为空，则表示第一次显示该条目，需要创建一个view
            view = View.inflate(context, R.layout.item_equipment, null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            holder.tv_time = (TextView) view.findViewById(R.id.tv_time);
            holder.tv_statue = (TextView) view.findViewById(R.id.tv_statue);
            holder.iv_head = (ImageView) view.findViewById(R.id.iv_head);
            // 将holder与view进行绑定
            view.setTag(holder);
        } else {
            //否则表示可以复用convertView
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_name.setText("装备名称："+bean.getName());
        holder.tv_statue.setText("装备状态："+bean.getStautes());
        if (!bean.getTime().equals("")) {
            holder.tv_time.setText("上次充电时间：" + bean.getTime());
        } else {
            holder.tv_time.setText("非充电设备");
        }
        Utility.displayImage(bean.getPhotoPath(), holder.iv_head, R.drawable.fail_image);
        return view;
    }

    public class ViewHolder {
        ImageView iv_head;
        TextView tv_name, tv_time, tv_statue;
    }
}
