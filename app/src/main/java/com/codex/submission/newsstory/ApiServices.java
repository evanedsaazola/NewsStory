package com.codex.submission.newsstory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("v0/askstories.json")
    Call<List<Integer>> getAskStory();

    @GET("v0/item/{id}.json")
    Call<ContentDataModel> getAskStoryById(@Path("id") int id);

}
