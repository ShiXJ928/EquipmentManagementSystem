package com.zq.ems.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.acty.BaseActy;
import com.zq.ems.bean.Car;

import java.util.List;

/**
 * Created by SXJ on 2018/7/19 09:58
 * E-Mail Address：2394905398@qq.com
 */

public class CarListAdapter extends BaseAdapter{
    private List<Car> list;
    private BaseActy context;
    private LayoutInflater mInflater;

    public CarListAdapter(Context context, List<Car> list) {
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
        Car bean = list.get(position);
        // 判断convertView的状态，来达到复用效果
        if (null == convertView) {
            //如果convertView为空，则表示第一次显示该条目，需要创建一个view
            view = View.inflate(context, R.layout.item_car, null);
            holder = new ViewHolder();
//            holder.tv_content = (TextView) view.findViewById(R.id.tv_content);
//            holder.tv_time = (TextView) view.findViewById(R.id.tv_time);
            // 将holder与view进行绑定
            view.setTag(holder);
        } else {
            //否则表示可以复用convertView
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        return view;
    }

    public class ViewHolder {
    }
}
