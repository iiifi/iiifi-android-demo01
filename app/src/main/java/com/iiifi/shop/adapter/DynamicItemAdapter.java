package com.iiifi.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.entity.Dynamic;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dmm on 2017/3/29.
 */

public class DynamicItemAdapter extends ArrayAdapter<Dynamic> {

    private int resourceId;

    public List<Dynamic> dynamicList;

    public DynamicItemAdapter(Context context, int resource,List<Dynamic> objects) {
        super(context, resource,objects);
        resourceId=resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Dynamic dynamic=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.photo= (CircleImageView) view.findViewById(R.id.photo);
            viewHolder.nickName= (TextView) view.findViewById(R.id.nick_name);
            viewHolder.createTime= (TextView) view.findViewById(R.id.create_time);
            viewHolder.clientType= (TextView) view.findViewById(R.id.client_type);
            viewHolder.content= (TextView) view.findViewById(R.id.content);
            viewHolder.sendAddr= (TextView) view.findViewById(R.id.send_addr);
            viewHolder.collection= (ImageView) view.findViewById(R.id.collection);
            viewHolder.collectionNum= (TextView) view.findViewById(R.id.collection_num);
            viewHolder.comment= (ImageView) view.findViewById(R.id.comment);
            viewHolder.commentNum= (TextView) view.findViewById(R.id.comment_num);
            viewHolder.star= (ImageView) view.findViewById(R.id.star);
            viewHolder.starNum= (TextView) view.findViewById(R.id.star_num);
            viewHolder.share= (ImageView) view.findViewById(R.id.share);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        Glide.with(getContext()).load(dynamic.getPhoto()).into(viewHolder.photo);
        viewHolder.nickName.setText(dynamic.getNickName());
        viewHolder.createTime.setText(dynamic.getCreateTime());
        viewHolder.clientType.setText(dynamic.getClientType());
        viewHolder.content.setText(dynamic.getContent());
        viewHolder.sendAddr.setText(dynamic.getSendAddr());
        if(IiifiConstant.TRUE.equals(dynamic.getIsCollection())){
            Glide.with(getContext()).load(R.mipmap.icon_collection_sel).into(viewHolder.collection);
        }
      /*  viewHolder.collectionNum.setText(dynamic.getCollectionNum());
        viewHolder.commentNum.setText(dynamic.getCommentNum());
        if(IiifiConstant.TRUE.equals(dynamic.getIsStar())){
            Glide.with(getContext()).load(R.mipmap.icon_star_sel).into(viewHolder.star);
        }
        viewHolder.starNum.setText(dynamic.getStarNum());*/
        return view;
    }
    class ViewHolder{
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
    }


}
