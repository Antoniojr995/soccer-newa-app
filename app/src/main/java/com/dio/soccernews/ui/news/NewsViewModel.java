package com.dio.soccernews.ui.news;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.dio.soccernews.data.remota.SoccerNewApi;
import com.dio.soccernews.data.remota.local.AppDatabase;
import com.dio.soccernews.domain.News;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    public enum State {
        DOING, DONE, ERROR;
    }

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final MutableLiveData<List<State>> state = new MutableLiveData<>();
    private final SoccerNewApi api;

    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://antoniojr995.github.io/soccer-newa-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SoccerNewApi.class);

        this.findNews();

    }


    private void findNews() {
        state.setValue(Collections.singletonList(State.DOING));
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful()) {
                    news.setValue(response.body());
                    state.setValue(Collections.singletonList(State.DONE));
                }else {
                    state.setValue(Collections.singletonList(State.ERROR));
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //TODO falar se der erro
            }
        });
    }

    public LiveData<List<News>> getmNews() {
        return this.news;
    }
    public LiveData<List<State>> getState() {
        return this.state;
    }
}