package com.example.pockybossuser.sofeed.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pockybossuser.sofeed.R;
import com.example.pockybossuser.sofeed.models.Storage;
import com.example.pockybossuser.sofeed.models.User;
import com.example.pockybossuser.sofeed.models.instagram.InstagramPost;
import com.example.pockybossuser.sofeed.models.views.InstagramPostAdapter;

import java.util.List;

public class InstagramActivity extends AppCompatActivity {

    private User user;
    private static InstagramPostAdapter adapter;
    private static RecyclerView recyclerView;
    private static List<InstagramPost> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        String username = getIntent().getStringExtra("User");
        String password = getIntent().getStringExtra("Pass");
        user = Storage.getInstance().getUser(username,password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initComponents();
    }

    public void initComponents() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        posts = user.getInstagramAccount().getTimeline();
        adapter = new InstagramPostAdapter(posts);
        recyclerView.setAdapter(adapter);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Instagram");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00E676")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instagram, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_facebook) {
            Intent intent = new Intent(InstagramActivity.this, FacebookActivity.class);
            intent.putExtra("User",user.getUsername());
            intent.putExtra("Pass",user.getPassword());
            startActivity(intent);
            finish();
        }

        else if(id == R.id.action_twitter) {
            Intent intent = new Intent(InstagramActivity.this, TwitterActivity.class);
            intent.putExtra("User",user.getUsername());
            intent.putExtra("Pass",user.getPassword());
            startActivity(intent);
            finish();
        }

        else if(id == R.id.action_instagram) {
            Intent intent = new Intent(InstagramActivity.this, InstagramActivity.class);
            intent.putExtra("User",user.getUsername());
            intent.putExtra("Pass",user.getPassword());
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
