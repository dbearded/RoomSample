package com.bearded.derek.roomtest.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    public WordRepository(Application application) {
        WordDatabase db = WordDatabase.getInstance(application);
        wordDao = db.wordDao();
        allWords = wordDao.getAll();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insert(Word word) {
        new InsertAsyncTask(wordDao).execute(word);
    }

    public static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao dao;

        InsertAsyncTask(WordDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            dao.insert(words[0]);

            return null;
        }
    }
}
