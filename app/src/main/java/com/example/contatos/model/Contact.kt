package com.example.contatos.model

import java.io.Serializable

class Contact(
    val id: Int,
    var name: String,
    var urlPhoto: String?,
    var phoneNumber: String
) : Serializable
