package com.dio.soccernews.data.remota.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.dio.soccernews.domain.News;

import java.util.List;

@Dao
public interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(News news);

    @Query("SELECT * FROM news WHERE favorite = 1")
    List<News> loadfavorteNews();

}
