package com.iiifi.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.BaseRecyclerAdapter;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.entity.Dynamic;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dmm on 2017/3/29.
 */

public class DynamicItemAdapter extends BaseRecyclerAdapter<Dynamic,BaseRecyclerAdapter.BaseViewHolder>{

    public DynamicItemAdapter(int layoutResId, List<Dynamic> data) {
        super(layoutResId, data);
    }
    @Override
    protected void bindTheData(BaseRecyclerAdapter.BaseViewHolder holder, Dynamic data, int position) {
        holder.setImageUrlResource(R.id.photo,data.getPhoto());
        holder.setText(R.id.nick_name,data.getNickName());
        holder.setText(R.id.create_time,data.getCreateTime());
        holder.setText(R.id.client_type,data.getClientType());
        holder.setText(R.id.content,data.getContent());
        holder.setText(R.id.send_addr,data.getSendAddr());
        if(IiifiConstant.TRUE.equals(data.getIsCollection())){
            holder.setImageLocalResource(R.id.collection,R.mipmap.icon_collection_sel);
        }
        holder.setText(R.id.collection_num,String.valueOf(data.getCollectionNum()));
        holder.setText(R.id.comment_num,String.valueOf(data.getCommentNum()));
        if(IiifiConstant.TRUE.equals(data.getIsStar())){
            holder.setImageLocalResource(R.id.star,R.mipmap.icon_star_sel);
        }
        holder.setText(R.id.star_num,String.valueOf(data.getStarNum()));
    }
}
