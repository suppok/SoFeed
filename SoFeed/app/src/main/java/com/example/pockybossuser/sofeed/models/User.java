package com.example.pockybossuser.sofeed.models;

import com.example.pockybossuser.sofeed.models.facebook.FacebookAccount;
import com.example.pockybossuser.sofeed.models.instagram.InstagramAccount;
import com.example.pockybossuser.sofeed.models.twitter.TwitterAccount;

/**
 * Created by pockybossuser on 6/2/2016.
 */
public class User {
    private String username;
    private String password;
    private FacebookAccount facebookAccount;
    private TwitterAccount twitterAccount;
    private InstagramAccount instagramAccount;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setFacebookAccount(FacebookAccount account) {
        this.facebookAccount = account;
    }

    public void setTwitterAccount(TwitterAccount account) {
        this.twitterAccount = account;
    }

    public void setInstagramAccount(InstagramAccount account) {
        this.instagramAccount = account;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public FacebookAccount getFacebookAccount() {
        return this.facebookAccount;
    }

    public TwitterAccount getTwitterAccount() {
        return this.twitterAccount;
    }

    public InstagramAccount getInstagramAccount() {
        return this.instagramAccount;
    }

    public void setFacebookAccountById(String username, String password) {
        this.setFacebookAccount(Storage.getInstance().getFacebookAccountById(username,password));
    }

    public void setTwitterAccountById(String username, String password) {
        this.setTwitterAccount(Storage.getInstance().getTwitterAccountById(username,password));
    }

    public void setInstagramAccountById(String username, String password) {
        this.setInstagramAccount(Storage.getInstance().getInstagramAccountById(username,password));
    }


}
