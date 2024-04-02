package com.amitwc.oloistachat

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.amitwc.oloistachat.activity.NumberActivity
import com.amitwc.oloistachat.adapter.ViewPagerAdapter
import com.amitwc.oloistachat.databinding.ActivityMainBinding
import com.amitwc.oloistachat.ui.CallFragment
import com.amitwc.oloistachat.ui.ChatFragment
import com.amitwc.oloistachat.ui.StatusFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

private  var binding:ActivityMainBinding?= null
    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(ChatFragment())
        fragmentArrayList.add(StatusFragment())
        fragmentArrayList.add(CallFragment())


        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null){
            startActivity(Intent(this,NumberActivity::class.java))
            finish()
        }



        val adapter = ViewPagerAdapter(this,supportFragmentManager,fragmentArrayList)

        binding!!.viewPager.adapter  = adapter

        binding!!.tabs.setupWithViewPager(binding!!.viewPager)




    }
}