package com.example.pockybossuser.sofeed.models.instagram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class InstagramPost {

    private InstagramAccount account;
    private String caption;
    private int srcPostImg;
    private List<InstagramComment> comments;
    private List<InstagramAccount> likeList;
    private long postTime;

    public InstagramPost(InstagramAccount account, String caption, int srcPostImg) {
        this.account = account;
        this.caption = caption;
        this.srcPostImg = srcPostImg;
        this.postTime = System.currentTimeMillis();

        this.comments = new ArrayList<InstagramComment>();
        this.likeList = new ArrayList<InstagramAccount>();
    }

    public InstagramAccount getAccount() {
        return account;
    }

    public String getCaption() {
        return caption;
    }

    public int getSrcPostImg() {
        return srcPostImg;
    }

    public long getPostTime() {
        return postTime;
    }

    public List<InstagramAccount> getLikeList() {
        return likeList;
    }

    public List<InstagramComment> getComments() {
        return comments;
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

    public int getNumLikes() {
        return this.getLikeList().size();
    }

    public void addComment(InstagramComment comment) {
        this.getComments().add(comment);
    }

    public void addLike(InstagramAccount account) {
        this.likeList.add(account);
    }

    public void removeLike(InstagramAccount account) {
        this.likeList.remove(account);
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
