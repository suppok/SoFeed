package com.example.pockybossuser.sofeed.models.views;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pockybossuser.sofeed.R;
import com.example.pockybossuser.sofeed.models.Storage;
import com.example.pockybossuser.sofeed.models.twitter.TwitterPost;

import java.util.List;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class TwitterPostAdapter extends RecyclerView.Adapter<TwitterPostAdapter.MyTwitterViewHolder>{

    private List<TwitterPost> posts;

    public static class MyTwitterViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView img_profile;
        TextView name_profile;
        TextView post_time;
        TextView post_text;
        ImageView img_reply;
        TextView reply;
        ImageView img_retweet;
        TextView retweet;
        ImageView img_favourite;
        TextView favourite;

        public MyTwitterViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            this.img_profile = (ImageView) itemView.findViewById(R.id.img_profile);
            this.name_profile = (TextView) itemView.findViewById(R.id.tv_profile_name);
            this.post_time = (TextView) itemView.findViewById(R.id.tv_post_time);
            this.post_text = (TextView) itemView.findViewById(R.id.tv_post_text);
            this.img_reply = (ImageView) itemView.findViewById(R.id.img_reply);
            this.reply = (TextView) itemView.findViewById(R.id.tv_reply);
            this.img_retweet = (ImageView) itemView.findViewById(R.id.img_retweet);
            this.retweet = (TextView) itemView.findViewById(R.id.tv_retweet);
            this.img_favourite = (ImageView) itemView.findViewById(R.id.img_favourite);
            this.favourite = (TextView) itemView.findViewById(R.id.tv_favourite);
        }
    }

    public TwitterPostAdapter(List<TwitterPost> posts) {
        this.posts = posts;
    }

    @Override
    public MyTwitterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.twitter_post_card_layout, parent, false);

        MyTwitterViewHolder myTwitterViewHolder = new MyTwitterViewHolder(view);
        return myTwitterViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyTwitterViewHolder holder, final int listPosition) {
        ImageView img_profile = holder.img_profile;
        TextView name_profile = holder.name_profile;
        TextView post_time = holder.post_time;
        TextView post_text = holder.post_text;
        ImageView img_reply = holder.img_reply;
        TextView reply = holder.reply;
        ImageView img_retweet = holder.img_retweet;
        TextView retweet = holder.retweet;
        ImageView img_favourite = holder.img_favourite;
        TextView favourite = holder.favourite;

        TwitterPost post = posts.get(listPosition);

        img_profile.setImageResource(post.getAccount().getSrcProfile());
        name_profile.setText(post.getAccount().getName());
        post_time.setText(post.getPostTimeSimplyForm());
        post_text.setText(post.getPostText());
        img_reply.setImageResource(Storage.getInstance().getReplyIcon());
        reply.setText(String.valueOf(post.getNumReplies()));
        img_retweet.setImageResource(Storage.getInstance().getRetweetIcon());
        retweet.setText(String.valueOf(post.getNumRetweets()));
        img_favourite.setImageResource(Storage.getInstance().getFavouriteIcon());
        favourite.setText(String.valueOf(post.getNumFavourtie()));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
