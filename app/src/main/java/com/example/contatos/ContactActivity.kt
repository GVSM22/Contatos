package com.example.contatos

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.contatos.model.Contact

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        val contact: Contact? = intent.getSerializableExtra("contact") as? Contact
        val callBtn: Button = findViewById(R.id.callButton)

        callBtn.setOnClickListener {
            val newIntent = Intent(Intent.ACTION_DIAL, Uri.parse(contact?.phoneNumber?.trim()))
            startActivity(newIntent)
        }
    }
}