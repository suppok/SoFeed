package com.example.pockybossuser.sofeed.models.instagram;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class InstagramComment {

    private InstagramAccount account;
    private String comment;
    private long commentTime;

    public InstagramComment(InstagramAccount account, String comment) {
        this.account = account;
        this.comment = comment;
        this.commentTime = System.currentTimeMillis();
    }

    public InstagramAccount getAccount() {
        return account;
    }

    public String getComment() {
        return comment;
    }

    public long getCommentTime() {
        return commentTime;
    }

    public String getCommentTimeSimplyForm() {
        String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String stringDate = sdf.format(new Date(this.getCommentTime()));
        return stringDate;
    }
}
