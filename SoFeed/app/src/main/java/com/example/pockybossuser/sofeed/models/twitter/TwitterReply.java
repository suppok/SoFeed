package com.example.pockybossuser.sofeed.models.twitter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class TwitterReply {

    private TwitterAccount account;
    private String replyText;
    private long replyTime;

    public TwitterReply(TwitterAccount account, String replyText) {
        this.account = account;
        this.replyText = replyText;
        replyTime = System.currentTimeMillis();
    }

    public long getReplyTime() {
        return replyTime;
    }

    public TwitterAccount getAccount() {
        return account;
    }

    public String getReplyTimeSimplyForm() {
        String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String stringDate = sdf.format(new Date(this.getReplyTime()));
        return stringDate;
    }
}
