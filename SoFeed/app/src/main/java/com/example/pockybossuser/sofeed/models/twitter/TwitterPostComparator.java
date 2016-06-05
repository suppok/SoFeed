package com.example.pockybossuser.sofeed.models.twitter;

import java.util.Comparator;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class TwitterPostComparator implements Comparator<TwitterPost> {
    @Override
    public int compare(TwitterPost lhs, TwitterPost rhs) {
        return (int)(rhs.getPostTime() - lhs.getPostTime());
    }
}
