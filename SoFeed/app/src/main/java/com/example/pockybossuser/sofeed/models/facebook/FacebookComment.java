package com.example.pockybossuser.sofeed.models.facebook;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pockybossuser on 6/2/2016.
 */
public class FacebookComment {
    private FacebookAccount account;
    private String commentText;
    private List<FacebookAccount> likesList;
    private long commentTime;

    public FacebookComment(FacebookAccount account, String commentText) {
        this.commentText = commentText;
        this.account = account;
        this.commentTime = System.currentTimeMillis();
        this.likesList = new ArrayList<FacebookAccount>();
    }

    public List<FacebookAccount> getLikesList() {
        return likesList;
    }

    public void setLikesList(List<FacebookAccount> likesList) {
        this.likesList = likesList;
    }

    public void addLike(FacebookAccount account) {
        likesList.add(account);
    }

    public void removeLike(FacebookAccount account) {
        likesList.remove(account);
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public FacebookAccount getAccount() {
        return account;
    }

    public void setAccount(FacebookAccount account) {
        this.account = account;
    }

    public long getCommentTime() {
        return this.commentTime;
    }

    public String getCommentTimeSimplyForm() {
        String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String stringDate = sdf.format(new Date(this.getCommentTime()));
        return stringDate;
    }

    public int getNumLikes() {
        return this.likesList.size();
    }

}
