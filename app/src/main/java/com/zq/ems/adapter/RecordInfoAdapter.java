package com.zq.ems.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.net.NetUrl;
import com.zq.ems.util.Utility;

import java.util.List;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class RecordInfoAdapter extends RecyclerView.Adapter<RecordInfoAdapter.ViewHolder> {
    private List<String> data;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;//用来计算Child位置
    private Context context;

    public RecordInfoAdapter(Context context, List<String> data) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv_name;
//        TextView tv_type;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
//            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    /**
     * 创建VIewHolder，导入布局，实例化itemView
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_record_info, parent, false);

        return new ViewHolder(itemView);
    }

    /**
     * 绑定VIewHolder，加载数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_name.setText(data.get(position));//加载数据
        Utility.displayImage(NetUrl.URL + "/images/" + data.get(position) + ".jpg", holder.iv, R.drawable.fail_image);
//        if (position % 4 == 1) {
//            holder.tv_type.setText("未领取");
//            holder.tv_type.setTextColor(context.getResources().getColor(R.color.bg_red));
//        } else {
//            holder.tv_type.setText("已领取");
//            holder.tv_type.setTextColor(context.getResources().getColor(R.color.bg_green));
//        }
    }

    /**
     * 数据源的数量，item的个数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    /**
     * 适配器绑定到RecyclerView 的时候，回将绑定适配器的RecyclerView 传递过来
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }
}
