package com.bitcode.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bitcode.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mt("onCreate : MainActivity")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.loadUrl("https://bitcode.in")

        binding.btnStart.setOnClickListener {
            var intent = Intent(this, MyService::class.java)
            intent.putExtra("path", binding.edtInfo.text.toString())
            startService(intent)
        }

        binding.btnStop.setOnClickListener {
            var intent = Intent(this, MyService::class.java)
            stopService(intent)
        }

        binding.btnStartMainAct.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        mt("onNewIntent ${intent.hashCode()}")
    }
}