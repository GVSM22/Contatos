package com.example.contatos.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class ContactDBHelper(context: Context) :
    SQLiteOpenHelper(context, "database_name", null, 1) {


    private val SQL_CREATE_CONTACT_TABLE =
        """
            CREATE TABLE ${ContactDB.ContactEntity.TABLE_NAME} (
                ${BaseColumns._ID} INTEGER PRIMARY KEY,
                ${ContactDB.ContactEntity.NAME} TEXT,
                ${ContactDB.ContactEntity.URL_PHOTO} TEXT
            )
        """

    private val SQL_DROP_CONTACTS =
        "DROP TABLE IF EXISTS ${ContactDB.ContactEntity.TABLE_NAME}"


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_CONTACT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DROP_CONTACTS)
        onCreate(db)
    }
}