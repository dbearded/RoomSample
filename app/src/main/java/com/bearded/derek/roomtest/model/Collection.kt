package com.bearded.derek.roomtest.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "collectionData")
data class Collection(@PrimaryKey var id: Int?,
                      @ColumnInfo(name = "created") var crt: Int,
                      @ColumnInfo(name = "modified") var mod: Int,
                      @ColumnInfo(name = "schema_modified") var scm: Int,
                      @ColumnInfo(name = "version") var ver: Int,
                      @ColumnInfo(name = "dirty") var dty: Int,
                      @ColumnInfo(name = "update_sequence_number") var usn: Int,
                      @ColumnInfo(name = "last_sync") var ls: Int,
                      @ColumnInfo(name = "configuration") var conf: String,
                      @ColumnInfo(name = "models") var models: String,
                      @ColumnInfo(name = "decks") var decks: String,
                      @ColumnInfo(name = "deck_configuration") var dconf: String,
                      @ColumnInfo(name = "tags") var tags: String) {
    constructor():this(null, 0, 0, 0, 0, 0, 0, 0,
            "", "", "", "", "")
}