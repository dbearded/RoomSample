package com.bearded.derek.roomtest.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "graveData")
data class Grave(@ColumnInfo(name = "update_sequence_number") var usn: Int,
                 @ColumnInfo(name = "original_id") var oid: Int,
                 @ColumnInfo(name = "type") var type: Int) {
    constructor():this(0, 0, 0)
}