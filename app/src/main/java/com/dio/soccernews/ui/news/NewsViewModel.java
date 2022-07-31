package com.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dio.soccernews.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        //TODO Remover Mock de Noticias
        List<News> news = new ArrayList<>();
        news.add(new News("Ferroviaria tem desfalque importante","\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\""));
        news.add(new News("Ferroviaria jogar sabado.","\"There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain...\"\n"));
        news.add(new News("Copa do mundo Feminina tem data prevista para começar","\"There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain...\"\n"));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getmNews() {
        return this.news;
    }
}