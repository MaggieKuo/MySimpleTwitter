package com.mag.codepath.simpletweet.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mag.codepath.simpletweet.R;
import com.mag.codepath.simpletweet.TwitterApplication;
import com.mag.codepath.simpletweet.TwitterClient;
import com.mag.codepath.simpletweet.adapters.TweetsRecyclerAdapter;
import com.mag.codepath.simpletweet.listeners.EndlessRecyclerViewScrollListener;
import com.mag.codepath.simpletweet.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;


/**
 * A placeholder fragment containing a simple view.
 */
public class TimelineActivityFragment extends Fragment {
    private static final String TAG = TimelineActivityFragment.class.getSimpleName();

    @BindView(R.id.recycler_timeline)
    RecyclerView recyclerTimeline;

    private TwitterClient twitterClient;
    private ArrayList<Tweet> tweets;
    private TweetsRecyclerAdapter adapter;
    private EndlessRecyclerViewScrollListener scrollListener;
    BroadcastReceiver receiver;
    Context context;


    public TimelineActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        ButterKnife.bind(this, view);

        twitterClient = TwitterApplication.getRestClient();
        setViews();
        populateTimeline(0, recyclerTimeline);

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        context.unregisterReceiver(receiver);
    }

    private void setViews() {
        tweets = new ArrayList<Tweet>();
        recyclerTimeline.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerTimeline.setLayoutManager(layoutManager);

        adapter = new TweetsRecyclerAdapter(tweets);
        recyclerTimeline.setAdapter(adapter);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.d(TAG, "onLoadMore page="+page + " / total items count = " + totalItemsCount);
                populateTimeline(page, view);

            }
        };

        recyclerTimeline.addOnScrollListener(scrollListener);

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String data = intent.getStringExtra("tweet");
                try {
                    Tweet tweet = Tweet.fromJSON(new JSONObject(data));
                    tweets.add(0, tweet);
                    adapter.notifyItemChanged(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        context.registerReceiver(receiver, new IntentFilter("com.mag.codepath.new tweet"));
    }


    private void populateTimeline(int page, final RecyclerView view) {
        if (tweets!=null) {
//            tweets.clear();
//            adapter.notifyDataSetChanged();
//            scrollListener.resetState();
        }


        twitterClient.getHomeTimeline(page,new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                tweets.addAll(Tweet.fromJSONArray(response));
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyItemRangeInserted(adapter.getItemCount(), tweets.size() - 1);
                    }
                });
//                refreshRecyclerView(tweets);

//                Log.d(TAG, "statusCode = " + statusCode);
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//                super.onFailure(statusCode, headers, responseString, throwable);
                Log.d(TAG, "response string :" + responseString);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.e(TAG, "statusCode="+statusCode);
//                Log.e(TAG, errorResponse.toString());
//                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }


        });
    }



}
