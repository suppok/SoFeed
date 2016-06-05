package com.example.pockybossuser.sofeed.models.twitter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class TwitterPost {

    private TwitterAccount account;
    private List<TwitterReply> replies;
    private String postText;
    private List<TwitterAccount> retweetList;
    private List<TwitterAccount> favouriteList;
    private long postTime;

    public TwitterPost(TwitterAccount account, String postText) {
        this.account = account;
        this.postText = postText;
        replies = new ArrayList<TwitterReply>();
        retweetList = new ArrayList<TwitterAccount>();
        favouriteList = new ArrayList<TwitterAccount>();
        this.postTime = System.currentTimeMillis();
    }

    public TwitterAccount getAccount() {
        return account;
    }

    public List<TwitterReply> getReplies() {
        return this.replies;
    }

    public String getPostText() {
        return postText;
    }

    public long getPostTime() {
        return postTime;
    }

    public List<TwitterAccount> getFavouriteList() {
        return favouriteList;
    }

    public List<TwitterAccount> getRetweetList() {
        return retweetList;
    }

    public String getPostTimeSimplyForm() {
        String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String stringDate = sdf.format(new Date(this.getPostTime()));
        return stringDate;
    }

    public int getNumReplies() {
        return this.getReplies().size();
    }

    public int getNumRetweets() {
        return this.getRetweetList().size();
    }

    public int getNumFavourtie() {
        return this.getFavouriteList().size();
    }

    public void addRetweet(TwitterAccount account) {
        this.retweetList.add(account);
    }

    public void removeRetweet(TwitterAccount account) {
        this.retweetList.remove(account);
    }

    public void addFavourite(TwitterAccount account) {
        this.favouriteList.add(account);
    }

    public void removeFacourite(TwitterAccount account) {
        this.favouriteList.remove(account);
    }

    public void addReply(TwitterReply reply) {
        this.getReplies().add(reply);
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
