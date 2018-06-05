package com.zq.ems.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zq.ems.R;
import com.zq.ems.bean.TeachingMateriaBean;
import com.zq.ems.util.Utility;

import java.util.List;

/**
 * Created by AIERXUAN on 2018/6/2.
 */

public class TeachingMateriaAdapter extends RecyclerView.Adapter<TeachingMateriaAdapter.ViewHolder> implements View.OnClickListener {
    private List<TeachingMateriaBean> data;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;//用来计算Child位置
    private OnItemClickListener onItemClickListener;

    //对外提供接口初始化方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public TeachingMateriaAdapter(Context context, List<TeachingMateriaBean> data) {
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
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
        View itemView = inflater.inflate(R.layout.item_teaching_materia, parent, false);

        //导入itemView，为itemView设置点击事件
        itemView.setOnClickListener(this);
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
        holder.tv_name.setText(data.get(position).getName());//加载数据
        switch (data.get(position).getType()) {
            case "mp4":
                Utility.displayImage(data.get(position).getPhotoPath(), holder.iv, R.drawable.fail_image);
                break;
            case "pdf":
                Utility.displayImage("drawable://" + R.drawable.pdf, holder.iv, R.drawable.fail_image);
                break;
            case "word":
                Utility.displayImage("drawable://" + R.drawable.word, holder.iv, R.drawable.fail_image);
                break;
            case "excel":
                Utility.displayImage("drawable://" + R.drawable.exal, holder.iv, R.drawable.fail_image);
                break;
            case "pptx":
                Utility.displayImage("drawable://" + R.drawable.ppt, holder.iv, R.drawable.fail_image);
                break;
            default:
                Utility.displayImage(data.get(position).getPhotoPath(), holder.iv, R.drawable.fail_image);
                break;
        }

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

    /**
     * @param v 点击的View
     */
    @Override
    public void onClick(View v) {
        //RecyclerView可以计算出这是第几个Child
        int childAdapterPosition = mRecyclerView.getChildAdapterPosition(v);
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(childAdapterPosition, data.get(childAdapterPosition));
        }
    }

    /**
     * 接口回调
     * 1、定义接口，定义接口中的方法
     * 2、在数据产生的地方持有接口，并提供初始化方法，在数据产生的时候调用接口的方法
     * 3、在需要处理数据的地方实现接口，实现接口中的方法，并将接口传递到数据产生的地方
     */
    public interface OnItemClickListener {
        void onItemClick(int position, TeachingMateriaBean model);
    }
}
