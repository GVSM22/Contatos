package com.example.contatos.database

import android.provider.BaseColumns

object ContactDB {

    object ContactEntity : BaseColumns {
        const val TABLE_NAME = "contacts"
        const val NAME = "name"
        const val URL_PHOTO = "url_photo"
        const val NUMBER = "phone_number"
    }
}