package com.example.pockybossuser.sofeed.models;

import android.hardware.camera2.params.Face;
import android.widget.ImageView;

import com.example.pockybossuser.sofeed.R;
import com.example.pockybossuser.sofeed.models.facebook.FacebookAccount;
import com.example.pockybossuser.sofeed.models.facebook.FacebookComment;
import com.example.pockybossuser.sofeed.models.facebook.FacebookPost;
import com.example.pockybossuser.sofeed.models.instagram.InstagramAccount;
import com.example.pockybossuser.sofeed.models.instagram.InstagramComment;
import com.example.pockybossuser.sofeed.models.twitter.TwitterAccount;
import com.example.pockybossuser.sofeed.models.twitter.TwitterReply;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pockybossuser on 6/2/2016.
 */
public class Storage {
    private static Storage instance = null;
    private List<FacebookAccount> facebookAccountList;
    private List<TwitterAccount> twitterAccountList;
    private List<InstagramAccount> instagramAccountList;
    private List<User> userList;
    private int img_like_resource;
    private int img_comment_resource;
    private int img_reply_resource;
    private int img_retweet_resource;
    private int img_favourite_resource;
    private int img_like_ig_resource;
    private int img_comment_ig_resource;

    private Storage() {
        userList = new ArrayList<User>();
        facebookAccountList = new ArrayList<FacebookAccount>();
        twitterAccountList = new ArrayList<TwitterAccount>();
        instagramAccountList = new ArrayList<InstagramAccount>();

        FacebookAccount bossFacebookAccount = new FacebookAccount("facebook1","123456", R.drawable.boss_facebook_profile,"Supanat Pokturng");
        FacebookAccount nottFacebookAccount = new FacebookAccount("facebook2","123456",R.drawable.nott_facebook_profile,"Patinya Yongyai");
        FacebookAccount netFacebookAccount = new FacebookAccount("facebook3","123456",R.drawable.net_facebook_profile,"Narut Poovorakit");
        FacebookAccount kanoonFacebookAccount = new FacebookAccount("facebook4","123456",R.drawable.kanoon_facebook_profile,"Taweerat Chaiman");
        FacebookAccount nonaeFacebookAccount = new FacebookAccount("facebook5","123456",R.drawable.nonae_facebook_profile,"Chinthiti Wisetsombat");
        FacebookAccount earthFacebookAccount = new FacebookAccount("facebook6","123456",R.drawable.earth_facebook_profile,"Raksit Mantanacharu");
        FacebookAccount peeFacebookAccount = new FacebookAccount("facebook7","123456",R.drawable.pee_facebook_profile,"Thongrapee Pantapatiphan");
        FacebookAccount tanFacebookAccount = new FacebookAccount("facebook8","123456",R.drawable.tan_facebook_profile,"Natanon Poonawagul");

        TwitterAccount bossTwitterAccount = new TwitterAccount("twitter1","123456",R.drawable.boss_facebook_profile,"Pockyboss");
        TwitterAccount nottTwitterAccount = new TwitterAccount("twitter2","123456",R.drawable.nott_facebook_profile,"SAS-Maxnot19");
        TwitterAccount netTwitterAccount = new TwitterAccount("twitter3","123456",R.drawable.net_facebook_profile,"Miracle");
        TwitterAccount kanoonTwitterAccount = new TwitterAccount("twitter4","123456",R.drawable.kanoon_facebook_profile,"Taweesoft");
        TwitterAccount nonaeTwitterAccount = new TwitterAccount("twitter5","123456",R.drawable.nonae_facebook_profile,"Chinonae");
        TwitterAccount earthTwitterAccount = new TwitterAccount("twitter6","123456",R.drawable.earth_facebook_profile,"THMortar");
        TwitterAccount peeTwitterAccount = new TwitterAccount("twitter7","123456",R.drawable.pee_facebook_profile,"CTx");
        TwitterAccount tanTwitterAccount = new TwitterAccount("twitter8","123456",R.drawable.tan_facebook_profile,"Artanzy");

        InstagramAccount bossInstagramAccount = new InstagramAccount("instagram1","123456",R.drawable.boss_facebook_profile,"Pockyboss");
        InstagramAccount nottInstagramAccount = new InstagramAccount("instagram2","123456",R.drawable.nott_facebook_profile,"SAS-Maxnot19");
        InstagramAccount netInstagramAccount = new InstagramAccount("instagram3","123456",R.drawable.net_facebook_profile,"Miracle");
        InstagramAccount kanoonInstagramAccount = new InstagramAccount("instagram4","123456",R.drawable.kanoon_facebook_profile,"Taweesoft");
        InstagramAccount nonaeInstagramAccount = new InstagramAccount("instagram5","123456",R.drawable.nonae_facebook_profile,"Chinonae");
        InstagramAccount earthInstagramAccount = new InstagramAccount("instagram6","123456",R.drawable.earth_facebook_profile,"THMortar");
        InstagramAccount peeInstagramAccount = new InstagramAccount("instagram7","123456",R.drawable.pee_facebook_profile,"CTx");
        InstagramAccount tanInstagramAccount = new InstagramAccount("instagram8","123456",R.drawable.tan_facebook_profile,"Artanzy");

        img_like_resource = R.drawable.like_icon;
        img_comment_resource = R.drawable.comment_icon;
        img_reply_resource = R.drawable.reply_icon;
        img_retweet_resource = R.drawable.retweet_icon;
        img_favourite_resource = R.drawable.favourite_icon;
        img_like_ig_resource = R.drawable.like_ig_icon;
        img_comment_ig_resource = R.drawable.comment_ig_icon;

        facebookAccountList.add(bossFacebookAccount);
        facebookAccountList.add(nottFacebookAccount);
        facebookAccountList.add(netFacebookAccount);
        facebookAccountList.add(kanoonFacebookAccount);
        facebookAccountList.add(nonaeFacebookAccount);
        facebookAccountList.add(earthFacebookAccount);
        facebookAccountList.add(peeFacebookAccount);
        facebookAccountList.add(tanFacebookAccount);

        twitterAccountList.add(bossTwitterAccount);
        twitterAccountList.add(nottTwitterAccount);
        twitterAccountList.add(netTwitterAccount);
        twitterAccountList.add(kanoonTwitterAccount);
        twitterAccountList.add(nonaeTwitterAccount);
        twitterAccountList.add(earthTwitterAccount);
        twitterAccountList.add(peeTwitterAccount);
        twitterAccountList.add(tanTwitterAccount);

        instagramAccountList.add(bossInstagramAccount);
        instagramAccountList.add(nottInstagramAccount);
        instagramAccountList.add(netInstagramAccount);
        instagramAccountList.add(kanoonInstagramAccount);
        instagramAccountList.add(nonaeInstagramAccount);
        instagramAccountList.add(earthInstagramAccount);
        instagramAccountList.add(peeInstagramAccount);
        instagramAccountList.add(tanInstagramAccount);

        bossFacebookAccount.addFriend(nottFacebookAccount);
        bossFacebookAccount.addFriend(netFacebookAccount);
        bossFacebookAccount.addFriend(kanoonFacebookAccount);
        bossFacebookAccount.addFriend(nonaeFacebookAccount);
        bossFacebookAccount.addFriend(earthFacebookAccount);
        bossFacebookAccount.addFriend(peeFacebookAccount);
        bossFacebookAccount.addFriend(tanFacebookAccount);

        nottFacebookAccount.addFriend(bossFacebookAccount);
        nottFacebookAccount.addFriend(kanoonFacebookAccount);
        nottFacebookAccount.addFriend(earthFacebookAccount);
        nottFacebookAccount.addFriend(tanFacebookAccount);

        netFacebookAccount.addFriend(bossFacebookAccount);
        netFacebookAccount.addFriend(earthFacebookAccount);
        netFacebookAccount.addFriend(peeFacebookAccount);

        kanoonFacebookAccount.addFriend(bossFacebookAccount);
        kanoonFacebookAccount.addFriend(nottFacebookAccount);
        kanoonFacebookAccount.addFriend(earthFacebookAccount);
        kanoonFacebookAccount.addFriend(nonaeFacebookAccount);
        kanoonFacebookAccount.addFriend(peeFacebookAccount);

        nonaeFacebookAccount.addFriend(bossFacebookAccount);
        nonaeFacebookAccount.addFriend(kanoonFacebookAccount);
        nonaeFacebookAccount.addFriend(tanFacebookAccount);

        earthFacebookAccount.addFriend(bossFacebookAccount);
        earthFacebookAccount.addFriend(nottFacebookAccount);
        earthFacebookAccount.addFriend(kanoonFacebookAccount);
        earthFacebookAccount.addFriend(tanFacebookAccount);

        peeFacebookAccount.addFriend(bossFacebookAccount);
        peeFacebookAccount.addFriend(netFacebookAccount);
        peeFacebookAccount.addFriend(kanoonFacebookAccount);

        tanFacebookAccount.addFriend(bossFacebookAccount);
        tanFacebookAccount.addFriend(nottFacebookAccount);
        tanFacebookAccount.addFriend(nonaeFacebookAccount);
        tanFacebookAccount.addFriend(earthFacebookAccount);

        bossTwitterAccount.follow(nottTwitterAccount);
        bossTwitterAccount.follow(netTwitterAccount);
        bossTwitterAccount.follow(kanoonTwitterAccount);
        bossTwitterAccount.follow(nonaeTwitterAccount);
        bossTwitterAccount.follow(earthTwitterAccount);
        bossTwitterAccount.follow(peeTwitterAccount);
        bossTwitterAccount.follow(tanTwitterAccount);

        bossInstagramAccount.follow(nottInstagramAccount);
        bossInstagramAccount.follow(netInstagramAccount);
        bossInstagramAccount.follow(kanoonInstagramAccount);
        bossInstagramAccount.follow(nonaeInstagramAccount);
        bossInstagramAccount.follow(earthInstagramAccount);
        bossInstagramAccount.follow(peeInstagramAccount);
        bossInstagramAccount.follow(tanInstagramAccount);

        nottInstagramAccount.post("N i c e  V i e w", R.drawable.post_ig_1);
        nottInstagramAccount.getMyPosts().get(0).setPostTime("Wed, 1 Jun 2016 10:05:00");
        nottInstagramAccount.getMyPosts().get(0).addLike(peeInstagramAccount);
        nottInstagramAccount.getMyPosts().get(0).addLike(kanoonInstagramAccount);
        nottInstagramAccount.getMyPosts().get(0).addLike(bossInstagramAccount);
        nottInstagramAccount.getMyPosts().get(0).addLike(earthInstagramAccount);
        nottInstagramAccount.getMyPosts().get(0).addLike(netInstagramAccount);
        earthInstagramAccount.post("That bridge is so good.", R.drawable.post_ig_2);
        earthInstagramAccount.getMyPosts().get(0).setPostTime("Fri, 3 Jun 2016 17:35:09");
        earthInstagramAccount.getMyPosts().get(0).addLike(peeInstagramAccount);
        earthInstagramAccount.getMyPosts().get(0).addLike(netInstagramAccount);
        earthInstagramAccount.getMyPosts().get(0).addComment(new InstagramComment(nottInstagramAccount, "Godd"));
        peeInstagramAccount.post("Mooooooooooooooooon", R.drawable.post_ig_3);
        peeInstagramAccount.getMyPosts().get(0).setPostTime("Sat, 4 Jun 2016 22:47:33");


        earthTwitterAccount.post("Hello, my followers");
        earthTwitterAccount.getMyPosts().get(0).setPostTime("Wed, 1 Jun 2016 10:05:00");
        earthTwitterAccount.getMyPosts().get(0).addRetweet(bossTwitterAccount);
        earthTwitterAccount.getMyPosts().get(0).addRetweet(peeTwitterAccount);
        earthTwitterAccount.getMyPosts().get(0).addFavourite(bossTwitterAccount);
        earthTwitterAccount.getMyPosts().get(0).addFavourite(nottTwitterAccount);
        earthTwitterAccount.getMyPosts().get(0).addFavourite(kanoonTwitterAccount);
        earthTwitterAccount.getMyPosts().get(0).addReply(new TwitterReply(kanoonTwitterAccount, "Godd"));
        earthTwitterAccount.getMyPosts().get(0).addReply(new TwitterReply(nottTwitterAccount, "WOW"));
        nottTwitterAccount.post("My first tweet");
        nottTwitterAccount.getMyPosts().get(0).setPostTime("Thu, 2 Jun 2016 04:29:59");
        nottTwitterAccount.getMyPosts().get(0).addRetweet(bossTwitterAccount);
        nottTwitterAccount.getMyPosts().get(0).addFavourite(peeTwitterAccount);
        nottTwitterAccount.getMyPosts().get(0).addFavourite(bossTwitterAccount);
        nottTwitterAccount.getMyPosts().get(0).addFavourite(tanTwitterAccount);
        nottTwitterAccount.getMyPosts().get(0).addFavourite(kanoonTwitterAccount);
        netTwitterAccount.post("Test Test 123");
        netTwitterAccount.getMyPosts().get(0).setPostTime("Fri, 3 Jun 2016 11:11:11");
        netTwitterAccount.getMyPosts().get(0).addFavourite(peeTwitterAccount);
        netTwitterAccount.getMyPosts().get(0).addFavourite(bossTwitterAccount);
        netTwitterAccount.getMyPosts().get(0).addFavourite(tanTwitterAccount);
        netTwitterAccount.getMyPosts().get(0).addFavourite(kanoonTwitterAccount);
        tanTwitterAccount.post("impleDateFormat allows you to start by choosing any user-defined patterns for date-time formatting. " +
                "However, you are encouraged to create a date-time formatter with either getTimeInstance, " +
                "getDateInstance, or getDateTimeInstance in DateFormat. Each of these class methods can return a " +
                "date/time formatter initialized with a default format pattern. You may modify the format pattern " +
                "using the applyPattern methods as desired. For more information on using these methods, see DateFormat.");
        tanTwitterAccount.getMyPosts().get(0).setPostTime("Fri, 3 Jun 2016 13:00:01");
        tanTwitterAccount.getMyPosts().get(0).addFavourite(peeTwitterAccount);
        tanTwitterAccount.getMyPosts().get(0).addFavourite(bossTwitterAccount);
        tanTwitterAccount.getMyPosts().get(0).addFavourite(nonaeTwitterAccount);
        tanTwitterAccount.getMyPosts().get(0).addFavourite(kanoonTwitterAccount);
        tanTwitterAccount.getMyPosts().get(0).addReply(new TwitterReply(nottTwitterAccount, "WOW"));
        peeTwitterAccount.post("My name is Thongrapee Panyapatiphan eiei.");
        peeTwitterAccount.getMyPosts().get(0).setPostTime("Sat, 4 Jun 2016 16:59:59");
        peeTwitterAccount.getMyPosts().get(0).addRetweet(peeTwitterAccount);
        peeTwitterAccount.getMyPosts().get(0).addFavourite(kanoonTwitterAccount);


        nottFacebookAccount.post("Hello, my friends");
        nottFacebookAccount.getMyPosts().get(0).setPostTime("Tue, 31 May 2016 10:05:00");
        nottFacebookAccount.getMyPosts().get(0).addLike(kanoonFacebookAccount);
        nottFacebookAccount.getMyPosts().get(0).addComment(new FacebookComment(bossFacebookAccount, "AMAZING"));
        nottFacebookAccount.getMyPosts().get(0).addComment(new FacebookComment(earthFacebookAccount,"123456"));
        kanoonFacebookAccount.post("Taweesoft is coming.");
        kanoonFacebookAccount.getMyPosts().get(0).setPostTime("Mon, 30 May 2016 05:14:25");
        kanoonFacebookAccount.getMyPosts().get(0).addLike(bossFacebookAccount);
        kanoonFacebookAccount.getMyPosts().get(0).addLike(tanFacebookAccount);
        kanoonFacebookAccount.getMyPosts().get(0).addComment(new FacebookComment(nonaeFacebookAccount, "..."));
        kanoonFacebookAccount.post("lol lol");
        kanoonFacebookAccount.getMyPosts().get(1).setPostTime("Sat, 4 Jun 2016 17:55:42");
        kanoonFacebookAccount.getMyPosts().get(1).addLike(tanFacebookAccount);
        kanoonFacebookAccount.getMyPosts().get(1).addLike(nottFacebookAccount);
        kanoonFacebookAccount.getMyPosts().get(1).addComment(new FacebookComment(bossFacebookAccount, "eiei"));
        tanFacebookAccount.post("a b c d e f g h i j k l m n o p q r s t u v w x y z");
        tanFacebookAccount.getMyPosts().get(0).setPostTime("Fri, 3 Jun 2016 06:00:00");
        tanFacebookAccount.getMyPosts().get(0).addLike(nonaeFacebookAccount);
        nonaeFacebookAccount.post("This is my facebook test");
        nonaeFacebookAccount.getMyPosts().get(0).setPostTime("Sat, 4 Jun 2016 07:05:04");
        nonaeFacebookAccount.getMyPosts().get(0).addComment(new FacebookComment(tanFacebookAccount, "mai na leoy"));
    }

    public static Storage getInstance() {
        if( instance == null ) {
            instance = new Storage();
        }

        return instance;
    }

    public List<FacebookAccount> getAllFacebookAccountList() {
        return facebookAccountList;
    }

    public List<TwitterAccount> getAllTwitterAccountList() {
        return twitterAccountList;
    }

    public FacebookAccount getFacebookAccount(FacebookAccount account) {
        FacebookAccount facebookAccount = null;
        for(int i=0 ; i<facebookAccountList.size() ; i++) {
            if(facebookAccountList.get(i).equals(account)) {
                facebookAccount = facebookAccountList.get(i);
                break;
            }
        }
        return facebookAccount;
    }

    public TwitterAccount getTwitterAccount(TwitterAccount account) {
        TwitterAccount twitterAccount = null;
        for(int i=0 ; i<twitterAccountList.size() ; i++) {
            if(twitterAccountList.get(i).equals(account)) {
                twitterAccount = twitterAccountList.get(i);
                break;
            }
        }
        return twitterAccount;
    }

    public List<User> getAllUsers() {
        return this.userList;
    }

    public User getUser(String username, String password) {
        User user = null;
        for(User eachUser : getAllUsers()) {
            if(eachUser.getUsername().equals(username) && eachUser.getPassword().equals(password))
                user = eachUser;
        }
        return user;
    }

    public int getLikeIcon() {
        return this.img_like_resource;
    }

    public int getCommentIcon() {
        return this.img_comment_resource;
    }

    public int getReplyIcon() {
        return img_reply_resource;
    }

    public int getRetweetIcon() {
        return img_retweet_resource;
    }

    public int getFavouriteIcon() {
        return img_favourite_resource;
    }

    public int getLikeIgIcon() {
        return img_like_ig_resource;
    }

    public int getCommentIgIcon() {
        return img_comment_ig_resource;
    }

    public FacebookAccount getFacebookAccountById(String username, String password) {
        FacebookAccount facebookAccount = null;
        for(int i=0 ; i<facebookAccountList.size() ; i++) {
            if(isEquals(username,password,facebookAccountList.get(i))) {
                facebookAccount = facebookAccountList.get(i);
                break;
            }
        }
        return facebookAccount;
    }

    public boolean isEquals(String username, String password, FacebookAccount account) {
        return account.getUsername().equals(username) && account.getPassword().equals(password);
    }

    public TwitterAccount getTwitterAccountById(String username, String password) {
        TwitterAccount twitterAccount = null;
        for(int i=0 ; i<twitterAccountList.size() ; i++) {
            if(isEquals(username,password,twitterAccountList.get(i))) {
                twitterAccount = twitterAccountList.get(i);
                break;
            }
        }
        return twitterAccount;
    }

    public boolean isEquals(String username, String password, TwitterAccount account) {
        return account.getUsername().equals(username) && account.getPassword().equals(password);
    }

    public InstagramAccount getInstagramAccountById(String username, String password) {
        InstagramAccount instagramAccount = null;
        for(int i=0 ; i<instagramAccountList.size() ; i++) {
            if(isEquals(username,password,instagramAccountList.get(i))) {
                instagramAccount = instagramAccountList.get(i);
                break;
            }
        }
        return instagramAccount;
    }

    public boolean isEquals(String username, String password, InstagramAccount account) {
        return account.getUsername().equals(username) && account.getPassword().equals(password);
    }

    public void addUser(User user) {
        this.userList.add(user);
    }
}
