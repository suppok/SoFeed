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
import com.example.pockybossuser.sofeed.models.facebook.FacebookPost;

import java.util.List;

/**
 * Created by pockybossuser on 6/3/2016.
 */
public class FacebookPostAdapter extends RecyclerView.Adapter<FacebookPostAdapter.MyViewHolder>{

    private List<FacebookPost> posts;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView img_profile;
        TextView name_profile;
        TextView post_time;
        TextView post_text;
        ImageView img_like;
        TextView like;
        ImageView img_comment;
        TextView comment;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            this.img_profile = (ImageView)itemView.findViewById(R.id.img_profile);
            this.name_profile = (TextView)itemView.findViewById(R.id.tv_profile_name);
            this.post_time = (TextView)itemView.findViewById(R.id.tv_post_time);
            this.post_text = (TextView)itemView.findViewById(R.id.tv_post_text);
            this.img_like = (ImageView)itemView.findViewById(R.id.img_like);
            this.like = (TextView)itemView.findViewById(R.id.tv_like);
            this.img_comment = (ImageView)itemView.findViewById(R.id.img_comment);
            this.comment = (TextView)itemView.findViewById(R.id.tv_comment);
        }
    }

    public FacebookPostAdapter(List<FacebookPost> posts) {
        this.posts = posts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.facebook_post_card_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        ImageView img_profile = holder.img_profile;
        TextView name_profile = holder.name_profile;
        TextView post_time = holder.post_time;
        TextView post_text = holder.post_text;
        ImageView img_like = holder.img_like;
        TextView like = holder.like;
        ImageView img_comment = holder.img_comment;
        TextView comment = holder.comment;

        FacebookPost post = posts.get(listPosition);
        img_profile.setImageResource(post.getAccount().getSrcProfile());
        name_profile.setText(post.getAccount().getName());
        post_time.setText(post.getPostTimeSimplyForm());
        post_text.setText(post.getPostText());
        img_like.setImageResource(Storage.getInstance().getLikeIcon());
        like.setText(String.valueOf(post.getNumLikes()));
        img_comment.setImageResource(Storage.getInstance().getCommentIcon());
        comment.setText(String.valueOf(post.getNumComments()));
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
