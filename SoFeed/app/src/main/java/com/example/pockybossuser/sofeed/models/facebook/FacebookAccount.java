package com.example.pockybossuser.sofeed.models.facebook;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pockybossuser on 6/2/2016.
 */
public class FacebookAccount {

    private String username;
    private String password;
    private int srcProfile;
    private String name;
    private List<FacebookAccount> friends;
    private List<FacebookPost> timeline;
    private List<FacebookPost> myPosts;

    public FacebookAccount(String username, String password, int srcProfile, String name) {

        this.username = username;
        this.password = password;
        this.srcProfile = srcProfile;
        this.name = name;

        friends = new ArrayList<FacebookAccount>();
        timeline = new ArrayList<FacebookPost>();
        myPosts =  new ArrayList<FacebookPost>();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getSrcProfile() {
        return srcProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FacebookAccount> getFriends() {
        return friends;
    }

    public List<FacebookPost> getTimeline() {
        List<FacebookPost> timeline = new ArrayList<FacebookPost>();
        List<FacebookAccount> accountList = this.getFriends();
        accountList.add(this);

        for(FacebookAccount account : accountList) {
            for(FacebookPost post : account.getMyPosts()) {
                timeline.add(post);
            }
        }

        Collections.sort(timeline, new FacebookPostComparator());

        return timeline;
    }

    public void addFriend(FacebookAccount account) {
        this.friends.add(account);
    }

    public boolean equals(FacebookAccount account) {
        return this.getName().equals(account.getName());
    }

    public List<FacebookPost> getMyPosts() {
        return myPosts;
    }

    public void post(String text) {
        FacebookPost post = new FacebookPost(this,text);
        this.myPosts.add(post);
    }

}
