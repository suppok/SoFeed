package com.example.pockybossuser.sofeed.models.instagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class InstagramAccount {

    private String username;
    private String password;
    private int srcProfile;
    private String name;
    private List<InstagramAccount> followers;
    private List<InstagramAccount> followings;
    private List<InstagramPost> timeline;
    private List<InstagramPost> myPosts;

    public InstagramAccount(String username, String password, int srcProfile, String name) {
        this.username = username;
        this.password = password;
        this.srcProfile = srcProfile;
        this.name = name;

        followers = new ArrayList<InstagramAccount>();
        followings = new ArrayList<InstagramAccount>();
        timeline = new ArrayList<InstagramPost>();
        myPosts = new ArrayList<InstagramPost>();
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

    public List<InstagramAccount> getFollowers() {
        return followers;
    }

    public List<InstagramAccount> getFollowings() {
        return followings;
    }

    public List<InstagramPost> getTimeline() {
        List<InstagramPost> timeline = new ArrayList<InstagramPost>();
        List<InstagramAccount> accountList = this.getFollowings();
        accountList.add(this);

        for(InstagramAccount account : accountList) {
            for(InstagramPost post : account.getMyPosts()) {
                timeline.add(post);
            }
        }

        Collections.sort(timeline, new InstagramPostComparator());

        return timeline;
    }

    public List<InstagramPost> getMyPosts() {
        return myPosts;
    }

    public void follow(InstagramAccount account) {
        this.followings.add(account);
        account.getFollowers().add(this);
    }

    public void post(String text, int srcPostImg) {
        InstagramPost post = new InstagramPost(this,text,srcPostImg);
        this.myPosts.add(post);
    }
}
