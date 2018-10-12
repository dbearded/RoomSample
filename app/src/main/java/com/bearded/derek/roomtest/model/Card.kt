package com.bearded.derek.roomtest.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cardData")
data class Card(@PrimaryKey var id: Int?,
                @ColumnInfo(name = "note_id") var nid: Int,
                @ColumnInfo(name = "deck_id") var did: Int,
                @ColumnInfo(name = "ordinal") var ord: Int,
                @ColumnInfo(name = "modification_time") var mod: Int,
                @ColumnInfo(name = "update_sequence") var usn: Int,
                @ColumnInfo(name = "type") var type: Int,
                @ColumnInfo(name = "queue") var queue: Int,
                @ColumnInfo(name = "due") var due: Int,
                @ColumnInfo(name = "interval") var ivl: Int,
                @ColumnInfo(name = "factor") var factor: Int,
                @ColumnInfo(name = "repetitions") var reps: Int,
                @ColumnInfo(name = "lapses") var lapses: Int,
                @ColumnInfo(name = "left") var left: Int,
                @ColumnInfo(name = "original_due") var odue: Int,
                @ColumnInfo(name = "original_deck_id") var odid: Int,
                @ColumnInfo(name = "flags") var flags: Int,
                @ColumnInfo(name = "data") var data: String) {
    constructor():this(null, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, "")
}