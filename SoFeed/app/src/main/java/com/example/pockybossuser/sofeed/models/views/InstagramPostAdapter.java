
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
import com.example.pockybossuser.sofeed.models.instagram.InstagramPost;

import java.util.List;

/**
 * Created by pockybossuser on 6/4/2016.
 */
public class InstagramPostAdapter extends RecyclerView.Adapter<InstagramPostAdapter.MyInstagramViewHolder> {

    private List<InstagramPost> posts;

    public static class MyInstagramViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView img_profile;
        TextView name_profile;
        TextView post_time;
        TextView caption;
        ImageView img_post;
        ImageView img_like;
        TextView like;
        ImageView img_comment;
        TextView comment;

        public MyInstagramViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            this.img_profile = (ImageView)itemView.findViewById(R.id.img_profile);
            this.name_profile = (TextView)itemView.findViewById(R.id.tv_profile_name);
            this.post_time = (TextView)itemView.findViewById(R.id.tv_post_time);
            this.caption = (TextView)itemView.findViewById(R.id.tv_post_text);
            this.img_post = (ImageView)itemView.findViewById(R.id.img_post);
            this.img_like = (ImageView)itemView.findViewById(R.id.img_like);
            this.like = (TextView)itemView.findViewById(R.id.tv_like);
            this.img_comment = (ImageView)itemView.findViewById(R.id.img_comment);
            this.comment = (TextView)itemView.findViewById(R.id.tv_comment);
        }
    }

    public InstagramPostAdapter(List<InstagramPost> posts) {
        this.posts = posts;
    }

    @Override
    public MyInstagramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.instagram_post_card_layout, parent, false);

        MyInstagramViewHolder myViewHolder = new MyInstagramViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyInstagramViewHolder holder, final int listPosition) {
        ImageView img_profile = holder.img_profile;
        TextView name_profile = holder.name_profile;
        TextView post_time = holder.post_time;
        TextView caption = holder.caption;
        ImageView img_post = holder.img_post;
        ImageView img_like = holder.img_like;
        TextView like = holder.like;
        ImageView img_comment = holder.img_comment;
        TextView comment = holder.comment;

        InstagramPost post = posts.get(listPosition);
        img_profile.setImageResource(post.getAccount().getSrcProfile());
        name_profile.setText(post.getAccount().getName());
        post_time.setText(post.getPostTimeSimplyForm());
        caption.setText(post.getCaption());
        img_post.setImageResource(post.getSrcPostImg());
        img_like.setImageResource(Storage.getInstance().getLikeIgIcon());
        like.setText(String.valueOf(post.getNumLikes()));
        img_comment.setImageResource(Storage.getInstance().getCommentIgIcon());
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
