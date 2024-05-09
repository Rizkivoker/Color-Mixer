package org.d3if3168.assessment2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3168.assessment2.model.Contact

@Dao
interface ContactData {

    @Insert
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Query("SELECT * FROM Contact ORDER BY nama ASC")
    fun getContact(): Flow<List<Contact>>

    @Query("SELECT * FROM contact WHERE id = :id")
    suspend fun getContactById(id: Long): Contact?

    @Query("DELETE FROM Contact WHERE id = :id")
    suspend fun deleteContactById(id: Long)
}