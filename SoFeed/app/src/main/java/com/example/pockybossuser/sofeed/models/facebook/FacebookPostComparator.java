package com.example.pockybossuser.sofeed.models.facebook;

import com.example.pockybossuser.sofeed.models.facebook.FacebookPost;

import java.util.Comparator;

/**
 * Created by pockybossuser on 6/3/2016.
 */
public class FacebookPostComparator implements Comparator<FacebookPost> {
    @Override
    public int compare(FacebookPost lhs, FacebookPost rhs) {
        return (int)(rhs.getPostTime() - lhs.getPostTime());
    }
}
