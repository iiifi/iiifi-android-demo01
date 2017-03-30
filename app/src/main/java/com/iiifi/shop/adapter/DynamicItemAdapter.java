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
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.entity.Dynamic;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dmm on 2017/3/29.
 */

public class DynamicItemAdapter extends RecyclerView.Adapter<DynamicItemAdapter.ViewHolder> {

    private Context mContext;
    private List<Dynamic> dynamicList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView photo;//头像
        TextView nickName;//昵称
        TextView createTime;//创建时间
        TextView clientType;//客户端类型
        TextView content;//内容
        TextView sendAddr;//发动态位置
        ImageView collection;//收藏
        TextView  collectionNum;//收藏数
        ImageView comment;//评论
        TextView commentNum;//评论数
        ImageView star;//点赞
        TextView starNum;//点赞数
        ImageView share;//分享
        public ViewHolder(View view){
            super(view);
            photo= (CircleImageView) view.findViewById(R.id.photo);
            nickName= (TextView) view.findViewById(R.id.nick_name);
            createTime= (TextView) view.findViewById(R.id.create_time);
            clientType= (TextView) view.findViewById(R.id.client_type);
            content= (TextView) view.findViewById(R.id.content);
            sendAddr= (TextView) view.findViewById(R.id.send_addr);
            collection= (ImageView) view.findViewById(R.id.collection);
            collectionNum= (TextView) view.findViewById(R.id.collection_num);
            comment= (ImageView) view.findViewById(R.id.comment);
            commentNum= (TextView) view.findViewById(R.id.comment_num);
            star= (ImageView) view.findViewById(R.id.star);
            starNum= (TextView) view.findViewById(R.id.star_num);
            share= (ImageView) view.findViewById(R.id.share);
        }
    }
    public DynamicItemAdapter(List<Dynamic> dynamicList ){
        this.dynamicList=dynamicList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DynamicItemAdapter.ViewHolder holder, int position) {
        Dynamic dynamic=dynamicList.get(position);
        Glide.with(mContext).load(dynamic.getPhoto()).into(holder.photo);
        holder.nickName.setText(dynamic.getNickName());
        holder.createTime.setText(dynamic.getCreateTime());
        holder.clientType.setText(dynamic.getClientType());
        holder.content.setText(dynamic.getContent());
        holder.sendAddr.setText(dynamic.getSendAddr());
        if(IiifiConstant.TRUE.equals(dynamic.getIsCollection())){
            Glide.with(mContext).load(R.mipmap.icon_collection_sel).into(holder.collection);
        }
        holder.collectionNum.setText(String.valueOf(dynamic.getCollectionNum()));
        holder.commentNum.setText(String.valueOf(dynamic.getCommentNum()));
        if(IiifiConstant.TRUE.equals(dynamic.getIsStar())){
            Glide.with(mContext).load(R.mipmap.icon_star_sel).into(holder.star);
        }
        holder.starNum.setText(String.valueOf(dynamic.getStarNum()));
    }

    @Override
    public int getItemCount() {
        return dynamicList.size();
    }
}
