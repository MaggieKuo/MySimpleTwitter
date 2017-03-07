package com.mag.codepath.simpletweet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabWidget;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mag.codepath.simpletweet.R;
import com.mag.codepath.simpletweet.TwitterApplication;
import com.mag.codepath.simpletweet.TwitterClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;


public class TimelineActivity extends AppCompatActivity{

    private static final String TAG = TimelineActivity.class.getSimpleName();
    private static final int REQTWEET = 6;
    @BindView(R.id.btnCompose)
    Button btnCompose;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(android.R.id.tabs)
    TabWidget tabs;
//    @BindView(R.id.fragment)
//    android.widget.fragment fragment;
    @BindView(R.id.tab1)
    LinearLayout tab1;
    @BindView(R.id.tab2)
    LinearLayout tab2;
    @BindView(R.id.tab3)
    LinearLayout tab3;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    TwitterClient twitterClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        twitterClient = TwitterApplication.getRestClient();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });


    }
    @OnClick(R.id.btnCompose)
    void onClickCompose(){
//        update("this is a test tweet");
        Intent intent = new Intent(this, ComposeActivity.class);
        startActivityForResult(intent, REQTWEET);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQTWEET:
                if (resultCode == RESULT_OK){
                    String responseBody = data.getStringExtra("responseBody");

                    Toast.makeText(TimelineActivity.this, "success", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setAction("com.mag.codepath.new tweet");
                    intent.putExtra("tweet", responseBody);
                    sendBroadcast(intent);
                }else{

                }
                break;
        }

    }


    public void update(String data) {
        twitterClient.UpdateTimeline(data, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d(TAG, "statusCode = " + statusCode);
                finish();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d(TAG, "statusCode = " + statusCode );
            }
        });

    }

    public interface Statuses{
        void update(String data);
    }
}
