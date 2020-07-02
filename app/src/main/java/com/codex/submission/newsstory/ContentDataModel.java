package com.codex.submission.newsstory;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContentDataModel {

    @SerializedName("title")
    private String contentTitle;

    @SerializedName("descendants")
    private int contentTotalComments;

    @SerializedName("score")
    private int contentScore;

    public ContentDataModel(String contentTitle, int contentTotalComments, int contentScore) {
        this.contentTitle = contentTitle;
        this.contentTotalComments = contentTotalComments;
        this.contentScore = contentScore;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public int getContentTotalComments() {
        return contentTotalComments;
    }

    public int getContentScore() {
        return contentScore;
    }
}
