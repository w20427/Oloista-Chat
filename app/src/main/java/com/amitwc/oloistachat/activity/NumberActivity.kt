package com.amitwc.oloistachat.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amitwc.oloistachat.MainActivity
import com.amitwc.oloistachat.R
import com.amitwc.oloistachat.databinding.ActivityNumberBinding
import com.google.firebase.auth.FirebaseAuth

class NumberActivity : AppCompatActivity() {

 private lateinit  var binding : ActivityNumberBinding
 private lateinit var  auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()

        if (auth.currentUser!= null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        binding.button.setOnClickListener{
            if(binding.phoneNumber.text!!.isEmpty()){
                Toast.makeText(this,"Please Enter Your Phone Number!!",Toast.LENGTH_SHORT).show()
            }else{
                var intent = Intent(this,OtpActivity::class.java)
                intent.putExtra("number",binding.phoneNumber.text!!.toString())
                startActivity(intent)
            }
        }
    }
}