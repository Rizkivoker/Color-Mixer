package org.d3if3168.assessment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.d3if3168.assessment2.database.ContactData
import org.d3if3168.assessment2.model.Contact

class MainViewModel(val dao: ContactData) : ViewModel() {

    val data: StateFlow<List<Contact>> = dao.getContact().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

    suspend fun getContactById(id: Long): Contact? {
        return dao.getContactById(id)
    }

    fun insert(nama: String, ttl: String, email: String, notelp: String, zodiak: String) {
        val contact = Contact(
            nama = nama,
            ttl = ttl,
            email = email,
            notelp = notelp,
            zodiak = zodiak
        )
        viewModelScope.launch {
            dao.insert(contact)
        }

    }

    fun update(nama : String, ttl: String, email: String, notelp: String , zodiak: String , id : Long){
        val contact = Contact(
            id = id,
            nama = nama,
            ttl = ttl,
            email = email,
            notelp = notelp,
            zodiak = zodiak,
        )
        viewModelScope.launch {
            dao.update(contact)
        }
    }

    fun deleteOutfitsDaoById(id: Long){
        viewModelScope.launch {
            dao.deleteContactById(id)
        }
    }

}