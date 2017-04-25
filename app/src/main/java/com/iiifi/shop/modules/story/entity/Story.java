package com.iiifi.shop.modules.story.entity;

/**
 * Created by dmm on 2017/4/25.
 */

public class Story {
    private String id;
    private String story;
    private String lable;
    private String commonNum;
    private String createTime;
    private String storyImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getCommonNum() {
        return commonNum;
    }

    public void setCommonNum(String commonNum) {
        this.commonNum = commonNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStoryImg() {
        return storyImg;
    }

    public void setStoryImg(String storyImg) {
        this.storyImg = storyImg;
    }
}
