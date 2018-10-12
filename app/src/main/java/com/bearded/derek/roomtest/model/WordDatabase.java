package com.bearded.derek.roomtest.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Word.class}, version = 1)
public abstract class WordDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static WordDatabase INSTANCE;

    static WordDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        WordDatabase.class, "word_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomDatabaseCallback)
                        .build();
                }
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao dao;

        PopulateDbAsync(WordDatabase db) {
            dao = db.wordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            Word word = new Word("Hello");
            dao.insert(word);
            word = new Word("World");
            dao.insert(word);
            return null;
        }
    }

}
