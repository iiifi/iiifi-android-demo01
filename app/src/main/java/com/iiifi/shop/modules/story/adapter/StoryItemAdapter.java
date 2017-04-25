package com.iiifi.shop.modules.story.adapter;

import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.adapter.BaseRecyclerAdapter;
import com.iiifi.shop.constant.IiifiConstant;
import com.iiifi.shop.modules.dynamic.entity.Dynamic;
import com.iiifi.shop.modules.story.entity.Story;

import java.util.List;

/**
 * Created by dmm on 2017/3/29.
 */

public class StoryItemAdapter extends BaseRecyclerAdapter<Story,BaseRecyclerAdapter.BaseViewHolder>{

    public StoryItemAdapter(int layoutResId, List<Story> data) {
        super(layoutResId, data);
    }
    @Override
    protected void bindTheData(BaseRecyclerAdapter.BaseViewHolder holder,Story data, int position) {
        holder.setText(R.id.story,data.getStory());
        holder.setText(R.id.lable,data.getLable());
        holder.setText(R.id.comment_num,data.getCommonNum());
        holder.setText(R.id.create_time,data.getCreateTime());
        holder.setImageUrlResource(R.id.story_img,data.getStoryImg());
    }
}
