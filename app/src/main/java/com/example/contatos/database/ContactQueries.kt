package com.example.contatos.database

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import com.example.contatos.model.Contact

class ContactQueries(context: Context) {

    private val dbHelper = ContactDBHelper(context)

    fun insertContact(contact: Contact): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(ContactDB.ContactEntity.NAME, contact.name)
            put(ContactDB.ContactEntity.URL_PHOTO, contact.urlPhoto)
            put(ContactDB.ContactEntity.NUMBER, contact.phoneNumber)
        }
        return db.insert(ContactDB.ContactEntity.TABLE_NAME, null, values)
    }

    fun getContacts(): MutableList<Contact> {
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            ContactDB.ContactEntity.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            "${ContactDB.ContactEntity.NAME} DESC"
        )
        val contacts = mutableListOf<Contact>()
        with(cursor) {
            while(moveToNext()) {
                val id = getInt(getColumnIndex(BaseColumns._ID))
                val name = getString(getColumnIndex(ContactDB.ContactEntity.NAME))
                val urlPhoto = getString(getColumnIndex(ContactDB.ContactEntity.URL_PHOTO))
                val phoneNumber = getString(getColumnIndex(ContactDB.ContactEntity.NUMBER))
                contacts.add(Contact(id, name, urlPhoto, phoneNumber))
            }
        }
        return contacts
    }

    fun getContacts(contactName: String): MutableList<Contact> {
        val db = dbHelper.readableDatabase

        val selection = "${ContactDB.ContactEntity.NAME} = ?"
        val selectionArgs = arrayOf(contactName)

        val cursor = db.query(
            ContactDB.ContactEntity.TABLE_NAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            "${ContactDB.ContactEntity.NAME} DESC"
        )
        val contacts = mutableListOf<Contact>()
        with(cursor) {
            while(moveToNext()) {
                val id = getInt(getColumnIndex(BaseColumns._ID))
                val name = getString(getColumnIndex(ContactDB.ContactEntity.NAME))
                val urlPhoto = getString(getColumnIndex(ContactDB.ContactEntity.URL_PHOTO))
                val phoneNumber = getString(getColumnIndex(ContactDB.ContactEntity.NUMBER))
                contacts.add(Contact(id, name, urlPhoto, phoneNumber))
            }
        }
        return contacts
    }

}