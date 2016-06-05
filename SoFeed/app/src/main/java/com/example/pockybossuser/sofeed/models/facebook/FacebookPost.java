package com.example.pockybossuser.sofeed.models.facebook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pockybossuser on 6/2/2016.
 */
public class FacebookPost {

    private FacebookAccount account;
    private List<FacebookComment> comments;
    private String postText;
    private List<FacebookAccount> likeList;
    private long postTime;


    public FacebookPost(FacebookAccount account, String postText) {
        this.account = account;
        this.postText = postText;
        comments = new ArrayList<FacebookComment>();
        likeList = new ArrayList<FacebookAccount>();
        postTime = System.currentTimeMillis() + 39600000;
    }

    public FacebookAccount getAccount() {
        return account;
    }

    public void setAccount(FacebookAccount account) {
        this.account = account;
    }

    public List<FacebookComment> getComments() {
        return comments;
    }

    public String getPostText() {
        return postText;
    }

    public List<FacebookAccount> getLikeList() {
        return likeList;
    }

    public int getNumLikes() {
        return this.likeList.size();
    }

    public long getPostTime() {
        return postTime;
    }

    public void addComment(FacebookComment comment) {
        this.comments.add(comment);
    }

    public void addLike(FacebookAccount account) {
        this.likeList.add(account);
    }

    public void removeLike(FacebookAccount account) {
        this.likeList.remove(account);
    }

    public String getPostTimeSimplyForm() {
        String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String stringDate = sdf.format(new Date(this.getPostTime()));
        return stringDate;
    }

    public int getNumComments() {
        return this.getComments().size();
    }

    public void setPostTime(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
            Date date = sdf.parse(time);
            this.postTime = date.getTime();
        } catch (ParseException e) {
            return;
        }
    }
}
