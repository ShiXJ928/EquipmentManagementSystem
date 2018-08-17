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
import com.zq.ems.bean.ApplyEquipmentBean;
import com.zq.ems.util.ToastUtil;

import java.util.List;

/**
 * Created by SXJ on 2018/8/14 10:21
 * E-Mail Address：2394905398@qq.com
 */

public class ApplyEquipmentListAdapter extends BaseAdapter {

    private List<ApplyEquipmentBean> list;
    private BaseActy context;
    private LayoutInflater mInflater;

    public ApplyEquipmentListAdapter(Context context, List<ApplyEquipmentBean> list) {
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
        final ApplyEquipmentBean bean = list.get(position);
        // 判断convertView的状态，来达到复用效果
        if (null == convertView) {
            //如果convertView为空，则表示第一次显示该条目，需要创建一个view
            view = View.inflate(context, R.layout.item_apply_equipment, null);
            holder = new ViewHolder();
            // 将holder与view进行绑定
            holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            holder.tv_num = (TextView) view.findViewById(R.id.tv_num);
            holder.iv_add = (ImageView) view.findViewById(R.id.iv_add);
            holder.iv_delete = (ImageView) view.findViewById(R.id.iv_delete);
            view.setTag(holder);
        } else {
            //否则表示可以复用convertView
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_name.setText(bean.getName());
        holder.tv_num.setText(bean.getNum() + "");
        holder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bean.setNum(bean.getNum() + 1);
                notifyDataSetChanged();
            }
        });
        holder.iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bean.getNum() == 1) {
                    ToastUtil.show("数量为1，不能再减少了");
                } else {
                    bean.setNum(bean.getNum() - 1);
                    notifyDataSetChanged();
                }
            }
        });
        return view;
    }

    public class ViewHolder {
        TextView tv_name, tv_num;
        ImageView iv_add, iv_delete;
    }
}