package com.example.signupsignin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.common.internal.Objects
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class sign : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signup=findViewById<Button>(R.id.etsubmitButton)
        val etname=findViewById<TextInputEditText>(R.id.etname)
        val etgender=findViewById<TextInputEditText>(R.id.etgender)
        val etmail=findViewById<TextInputEditText>(R.id.etphone)
        val etpassword=findViewById<TextInputEditText>(R.id.etpassword)
        val  etcpassword=findViewById<TextInputEditText>(R.id.etcpasswoed)

        signup.setOnClickListener {
            val name=etname.text.toString()
            val mail=etmail.text.toString()
            val gender=etgender.text.toString()
            val password=etpassword.text.toString()
            val cpassword=etcpassword.text.toString()

            val user=User(name,mail,gender,password,cpassword)

            database= FirebaseDatabase.getInstance().getReference("Users")
            database.child(password).setValue(user).addOnSuccessListener {


                Toast.makeText(this,"Your Registration Completed",Toast.LENGTH_SHORT).show()
            }
//                .addOnSuccessListener({
//                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
//            })

        }
    }
}