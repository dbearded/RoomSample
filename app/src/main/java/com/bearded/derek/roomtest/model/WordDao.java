package com.bearded.derek.roomtest.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAll();

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();
}
