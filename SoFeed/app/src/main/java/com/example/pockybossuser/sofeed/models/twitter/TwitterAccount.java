package com.example.pockybossuser.sofeed.models.twitter;

import com.example.pockybossuser.sofeed.models.facebook.FacebookPost;
import com.example.pockybossuser.sofeed.models.facebook.FacebookPostComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class TwitterAccount {

    private String username;
    private String password;
    private int srcProfile;
    private String name;
    private List<TwitterAccount> followers;
    private List<TwitterAccount> followings;
    private List<TwitterPost> timeline;
    private List<TwitterPost> myPosts;

    public TwitterAccount(String username, String password, int srcProfile, String name ) {
        this.username = username;
        this.password = password;
        this.srcProfile = srcProfile;
        this.name = name;

        this.followers = new ArrayList<TwitterAccount>();
        this.followings = new ArrayList<TwitterAccount>();
        this.timeline = new ArrayList<TwitterPost>();
        this.myPosts = new ArrayList<TwitterPost>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getSrcProfile() {
        return srcProfile;
    }

    public String getName() {
        return name;
    }

    public List<TwitterAccount> getFollowers() {
        return followers;
    }

    public List<TwitterAccount> getFollowings() {
        return followings;
    }

    public List<TwitterPost> getTimeline() {
        List<TwitterPost> timeline = new ArrayList<TwitterPost>();
        List<TwitterAccount> accountList = this.getFollowings();
        accountList.add(this);

        for(TwitterAccount account : accountList) {
            for(TwitterPost post : account.getMyPosts()) {
                timeline.add(post);
            }
        }

        Collections.sort(timeline, new TwitterPostComparator());

        return timeline;
    }

    public List<TwitterPost> getMyPosts() {
        return myPosts;
    }

    public void follow(TwitterAccount account) {
        this.followings.add(account);
        account.getFollowers().add(this);
    }

    public void post(String text) {
        TwitterPost post = new TwitterPost(this,text);
        this.myPosts.add(post);
    }


}
