package com.example.contatos


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.contatos.model.Contact


class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        val contact: Contact? = intent.getSerializableExtra("contact") as? Contact
        val callBtn: Button = findViewById(R.id.callButton)

        callBtn.setOnClickListener {
            val newIntent = Intent(Intent.ACTION_DIAL)
            val tel = contact?.phoneNumber?.trim()
            newIntent.data = Uri.parse("tel:$tel")
            startActivity(newIntent)
        }

        val callImg: ImageView = findViewById(R.id.contactPhoto)
        callImg.setOnClickListener {
            val i = Intent(
                Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )

            startActivity(i)
        }
    }
}