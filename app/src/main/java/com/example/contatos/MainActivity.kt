package com.example.contatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.contatos.model.Contact

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TODO remover botão (foi usado só pra testar uma funcionalidade)
        findViewById<Button>(R.id.teste).setOnClickListener {
            val contact = Contact(1, "1", null, "1")
            startActivity(Intent(this, ContactActivity::class.java).apply {
                putExtra("contact", contact)
            })
        }
    }
}