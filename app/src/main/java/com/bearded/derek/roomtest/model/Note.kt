package com.bearded.derek.roomtest.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "noteData")
data class Note(@PrimaryKey var id: Int?,
                @ColumnInfo(name = "globally_unique_id") var guid: String,
                @ColumnInfo(name = "model_id") var mid: Int,
                @ColumnInfo(name = "modification") var mod: Int,
                @ColumnInfo(name = "update_sequence_number") var usn: Int,
                @ColumnInfo(name = "tags") var tags: String,
                @ColumnInfo(name = "fields") var flds: String,
                @ColumnInfo(name = "sort_field") var sfld: String,
                @ColumnInfo(name = "field_checksum") var csum: Int,
                @ColumnInfo(name = "flags") var flags: Int,
                @ColumnInfo(name = "data") var data: String) {
    constructor(): this(null, "", 0, 0, 0, "", "", "",
            0, 0, "")
}