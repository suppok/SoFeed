package com.example.pockybossuser.sofeed.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pockybossuser.sofeed.R;
import com.example.pockybossuser.sofeed.models.Storage;
import com.example.pockybossuser.sofeed.models.User;
import com.example.pockybossuser.sofeed.models.facebook.FacebookPost;
import com.example.pockybossuser.sofeed.models.views.FacebookPostAdapter;

import java.util.List;

public class FacebookActivity extends AppCompatActivity {

    private User user;
    private static FacebookPostAdapter adapter;
    private static RecyclerView recyclerView;
    private static List<FacebookPost> posts;
    private String post_text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
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

        posts = user.getFacebookAccount().getTimeline();
        adapter = new FacebookPostAdapter(posts);
        recyclerView.setAdapter(adapter);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Facebook");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00E676")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_facebook, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_facebook) {
            Intent intent = new Intent(FacebookActivity.this, FacebookActivity.class);
            intent.putExtra("User",user.getUsername());
            intent.putExtra("Pass",user.getPassword());
            startActivity(intent);
            finish();
        }

        else if(id == R.id.action_twitter) {
            Intent intent = new Intent(FacebookActivity.this, TwitterActivity.class);
            intent.putExtra("User",user.getUsername());
            intent.putExtra("Pass",user.getPassword());
            startActivity(intent);
            finish();
        }

        else if(id == R.id.action_instagram) {
            Intent intent = new Intent(FacebookActivity.this, InstagramActivity.class);
            intent.putExtra("User",user.getUsername());
            intent.putExtra("Pass",user.getPassword());
            startActivity(intent);
            finish();
        }

        else if(id == R.id.action_post) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("What's up ?");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    post_text = input.getText().toString();
                    user.getFacebookAccount().post(post_text);
                    Intent intent = new Intent(FacebookActivity.this, FacebookActivity.class);
                    intent.putExtra("User",user.getUsername());
                    intent.putExtra("Pass", user.getPassword());
                    Toast.makeText(FacebookActivity.this, "Post successful", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    finish();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }

}
