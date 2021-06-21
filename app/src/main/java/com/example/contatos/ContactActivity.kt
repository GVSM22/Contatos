package com.example.contatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contatos.model.Contact

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        val contact: Contact? = intent.getSerializableExtra("contact") as? Contact
    }
}