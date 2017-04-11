package com.iiifi.shop.common.base.adapter;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iiifi.shop.activity.R;

import java.util.ArrayList;
import java.util.List;

/*
 * 文件名:    BaseRecyclerAdapter
 * 创建时间:  2017/3/20 on 9:42
 * 描述:     TODO RecyclerView的封装适配器
 */
public  class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>
        implements View.OnClickListener, View.OnLongClickListener {
    /**
     * 内容上下文
     */
    private Context context;

    /**
     * 数据源
     */
    private List<T> data;
    /**
     * 布局资源id
     */
    private int layoutResId;

    /**
     * Item点击事件
     */
    private onItemClickListener clickListener;
    /**
     * Item长按事件
     */
    private onItemLongClickListener longListener;


    public BaseRecyclerAdapter(int layoutResId, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : data;
        if (layoutResId != 0) {
            this.layoutResId = layoutResId;
        } else {
            throw new NullPointerException("请设置Item资源id");
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context==null){
            context=parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        return (VH) new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        //设置Item的点击事件
        holder.itemView.setOnClickListener(this);
        //设置Item的长按事件
        holder.itemView.setOnLongClickListener(this);
        holder.itemView.setTag(position);
        bindTheData(holder, data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 清除数据
     */
    public void clearData() {
        if (data != null && data.size() > 0) {
            data.clear();
        }
        notifyDataSetChanged();
    }

    /**
     * 绑定数据
     *
     * @param holder 视图管理者
     * @param data   数据源
     */
    protected  void bindTheData(VH holder, T data, int position){};

    @Override
    public void onClick(View v) {
        //点击回调
        if (clickListener != null) {
            clickListener.onItemClick((Integer) v.getTag(), v);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        //长按回调
        return longListener != null && longListener.onItemLonClick((Integer) v.getTag(), v);
    }

    /**
     * 设置点击监听
     *
     * @param clickListener 监听器
     */
    public void setClickListener(onItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    /**
     * 设置长按监听
     *
     * @param longListener 监听器
     */
    public void setLongListener(onItemLongClickListener longListener) {
        this.longListener = longListener;
    }

    interface onItemClickListener {
        void onItemClick(int position, View v);
    }

    interface onItemLongClickListener {
        boolean onItemLonClick(int position, View v);
    }


    /*********************************************
     * 基础视图管理者
     *********************************************/
    public class BaseViewHolder extends RecyclerView.ViewHolder {
        /**
         * 集合类，layout里包含的View,以view的id作为key，value是view对象
         */
        private SparseArray<View> mViews;

        public BaseViewHolder(View itemView) {
            super(itemView);
            mViews = new SparseArray<>();
        }

        public <T extends View> T findViewById(int viewId) {
            View view = mViews.get(viewId);
            if (view == null) {
                view = itemView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T) view;
        }

        /**
         * 设置文本资源
         * @param viewId view id
         * @param s      字符
         */
        public TextView setText(int viewId, CharSequence s) {
            TextView view = findViewById(viewId);
            view.setText(s);
            return view;
        }

        /**
         * 设置图片本地资源
         * @param viewId     view id
         * @param imageResId 图片资源id
         */
        public ImageView setImageLocalResource(int viewId, @DrawableRes int imageResId) {
            ImageView view = findViewById(viewId);
            Glide.with(context).load(R.mipmap.icon_star_sel).into(view);
            return view;
        }

        /**
         * 设置图片网络资源
         * @param viewId     view id
         * @param imgUrl 图片路径
         */
        public ImageView setImageUrlResource(int viewId, String imgUrl) {
            ImageView view = findViewById(viewId);
            Glide.with(context).load(imgUrl).into(view);
            return view;
        }
    }
}