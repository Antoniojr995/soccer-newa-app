package com.dio.soccernews.data.remota;

import com.dio.soccernews.domain.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerNewApi {

    @GET("news.json")
    Call<List<News>> getNews();
}
