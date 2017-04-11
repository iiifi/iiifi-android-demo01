package com.iiifi.shop.modules.dynamic.entity;

import java.util.List;

/**
 * Created by dmm on 2017/3/29.
 */

public class Dynamic {

    private String FALSE="0";
    private String TRUE="1";

    private String id;
    private String userId;
    private String nickName;
    private String photo;
    private String content;
    private int commentNum;
    private int starNum;
    private int collectionNum;
    private int browseNum;
    private String sendAddr;
    private String clientType;
    private String isCollection;
    private String isStar;
    private String createTime;
    private List<String> dynamicImg;
    private List<String> dynamicLable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getStarNum() {
        return starNum;
    }

    public void setStarNum(int starNum) {
        this.starNum = starNum;
    }

    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }

    public int getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(int browseNum) {
        this.browseNum = browseNum;
    }

    public String getSendAddr() {
        return sendAddr;
    }

    public void setSendAddr(String sendAddr) {
        this.sendAddr = sendAddr;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(String isCollection) {
        this.isCollection = isCollection;
    }

    public String getIsStar() {
        return isStar;
    }

    public void setIsStar(String isStar) {
        this.isStar = isStar;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<String> getDynamicImg() {
        return dynamicImg;
    }

    public void setDynamicImg(List<String> dynamicImg) {
        this.dynamicImg = dynamicImg;
    }

    public List<String> getDynamicLable() {
        return dynamicLable;
    }

    public void setDynamicLable(List<String> dynamicLable) {
        this.dynamicLable = dynamicLable;
    }
}
