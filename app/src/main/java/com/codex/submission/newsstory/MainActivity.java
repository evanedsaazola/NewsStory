package com.codex.submission.newsstory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ContentAdapter contentAdapter;
    private ArrayList<ContentDataModel> contentDataModelArrayList = new ArrayList<>();

    private RecyclerView rv_story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_story = findViewById(R.id.rvMainStoryList);
        setData();
    }

    private void setData() {
        final ApiServices apiServices = ApiClient.getClient(this).create(ApiServices.class);
        apiServices.getAskStory().enqueue(new Callback<List<Integer>>() {
            @Override
            public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                List<Integer> askStories = response.body();
                for (int i = 0; i < askStories.size(); i++) {
                    apiServices.getAskStoryById(askStories.get(i)).enqueue(new Callback<ContentDataModel>() {
                        @Override
                        public void onResponse(Call<ContentDataModel> call, Response<ContentDataModel> response) {
                            String storyTitle = response.body().getContentTitle();
                            int storyTotalComment = response.body().getContentTotalComments();
                            int storyScore = response.body().getContentScore();

                            contentDataModelArrayList.add(new ContentDataModel(storyTitle, storyTotalComment, storyScore));
                            contentAdapter = new ContentAdapter(contentDataModelArrayList, getApplicationContext());
                            rv_story.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                            rv_story.setAdapter(contentAdapter);
                        }

                        @Override
                        public void onFailure(Call<ContentDataModel> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Integer>> call, Throwable t) {

            }
        });
    }
}