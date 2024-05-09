package org.d3if3168.assessment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val ttl: String,
    val email: String,
    val notelp: String,
    val zodiak: String
)
