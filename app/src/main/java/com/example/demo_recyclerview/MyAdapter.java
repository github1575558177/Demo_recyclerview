package com.example.demo_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 刘荣达 on 0009,2016/8/9.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> mDatas;
    private LayoutInflater mInflater;
    private int mItemViewResId;

    private OnItemClickListener mOnItemClickListener;

    public MyAdapter(Context context, List<String> datas, int itemViewResId) {
        mInflater = LayoutInflater.from(context);
        mDatas = datas;
        mItemViewResId = itemViewResId;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(mItemViewResId, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() { // 注意itemView是事件源，是RecyclerView.ViewHolder中的常量
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition(); //注意这里的pos的获取方法
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    removeData(pos); // 长按删除指定项
                    return true; //这里返回true，表示消费此事件，默认是false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //指定位置添加一项，相当于插入
    public void addData(int position, String data) {
        mDatas.add(position, data);
        notifyItemInserted(position);//注意这里写的是notifyItemInserted()，比notifyDataSetChanged() 高效
    }

    public void removeData(int position){
        mDatas.remove(position);
        notifyItemRemoved(position); //还有一个 notifyItemChanged(); 方法，当某一项内容改变时使用
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv_num);}
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
}
