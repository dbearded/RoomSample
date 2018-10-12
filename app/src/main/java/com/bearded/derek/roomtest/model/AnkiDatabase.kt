package com.bearded.derek.roomtest.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import java.util.concurrent.CopyOnWriteArraySet

@Database(entities = [Card::class], version = 1, exportSchema = false)
abstract class AnkiDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao

    companion object {

        private var INSTANCE: AnkiDatabase? = null

        fun getInstance(context: Context): AnkiDatabase? {
            if (INSTANCE == null) {
                synchronized(AnkiDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AnkiDatabase::class.java, "anki.db")
                            .build()
                }
            }

            return INSTANCE
        }
    }
}