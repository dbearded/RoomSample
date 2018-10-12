package com.bearded.derek.roomtest.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "reviewData")
data class ReviewLog(@PrimaryKey var id: Int?,
                     @ColumnInfo(name = "card_id") var cid: Int,
                     @ColumnInfo(name = "update_sequence") var usn: Int,
                     @ColumnInfo(name = "ease") var ease: Int,
                     @ColumnInfo(name = "interval") var ivl: Int,
                     @ColumnInfo(name = "last_interval") var lastIvl: Int,
                     @ColumnInfo(name = "factor") var factor: Int,
                     @ColumnInfo(name = "time") var time: Int,
                     @ColumnInfo(name = "type") var type: Int) {
    constructor():this(null, 0, 0, 0, 0, 0, 0, 0,
            0)
}