package com.bitcode.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        mt("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

/*        NotificationManagerCompat.from(this)
            .notify(
                1,
                NotificationCompat.Builder()
            )*/

        mt("onStartCommand: start id: ${startId}")
        mt(intent?.getStringExtra("path")!!)
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onDestroy() {
        mt("onDestroy")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun mt(text : String) {
        Log.e("tag", text)
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}