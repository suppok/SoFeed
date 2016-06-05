package com.example.pockybossuser.sofeed.models.instagram;

import java.util.Comparator;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class InstagramPostComparator implements Comparator<InstagramPost> {
    @Override
    public int compare(InstagramPost lhs, InstagramPost rhs) {
        return (int)(rhs.getPostTime() - lhs.getPostTime());
    }
}
