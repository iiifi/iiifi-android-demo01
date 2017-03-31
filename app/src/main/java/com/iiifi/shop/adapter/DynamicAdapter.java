package com.iiifi.shop.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.BaseRecyclerAdapter;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.entity.Dynamic;
import java.util.List;

/**
 * Created by dmm on 2017/3/31.
 */

public class DynamicAdapter extends BaseRecyclerAdapter<Dynamic,BaseRecyclerAdapter.BaseViewHolder>{


    public DynamicAdapter(int layoutResId, List<Dynamic> data) {
        super(layoutResId, data);
    }


    @Override
    public void bindTheData(BaseViewHolder holder, Dynamic data, int position) {
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
        holder.setText(R.id.comment,String.valueOf(data.getCommentNum()));
        if(IiifiConstant.TRUE.equals(data.getIsStar())){
            holder.setImageLocalResource(R.id.star,R.mipmap.icon_star_sel);
        }
        holder.setText(R.id.star_num,String.valueOf(data.getStarNum()));
    }
}
