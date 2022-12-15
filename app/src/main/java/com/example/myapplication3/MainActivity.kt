package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var nameEditText : EditText
    lateinit var nextButton2 : Button
    lateinit var nextButton : Button



    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        replaceFragment(Home())

        val  nextButton = findViewById<Button>(R.id.nextButton)

//        nameEditText = findViewById(R.id.nameEditText)

//        nextButton = findViewById(R.id.nextButton)

//        nextButton2 = findViewById(R.id.nextButton2)
//
//        nextButton.setOnClickListener {
//            val name = nameEditText.text.toString()
//
//            val intent = Intent(this, Profile::class.java)
//            intent.putExtra("NAME", name)
//
//            startActivity(intent)
//
//        }
//        nextButton2.setOnClickListener {
//            val name = intent.getStringExtra("NAME")
//            val age = intent.getIntExtra("AGE", 0)
//
//            val intent = Intent(this, Settings::class.java)
//            intent.putExtra("NAME",name)
//            intent.putExtra("AGE", age)
//            startActivity(intent)
//        }


        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){

                R.id.home  -> replaceFragment(Home())
                R.id.profile -> replaceFragment(Profile())
                R.id.settings -> replaceFragment(Settings())


                else ->{


                }


            }
            true

        }

    }

    private  fun replaceFragment(fragment: Fragment){
        val fragmentManager =supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}