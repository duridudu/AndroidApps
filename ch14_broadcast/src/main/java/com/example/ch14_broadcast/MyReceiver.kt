package com.example.ch14_broadcast

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("RECEIVER^^", intent?.action.toString())
        val custom = intent?.action.toString()
        if (intent.action.equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "전원 연결 상태",LENGTH_SHORT ).show()
        }
        else if (intent.action.equals(Intent.ACTION_POWER_DISCONNECTED ))  {
            Toast.makeText(context, "전원 해제 상태", LENGTH_SHORT).show()
        }
       else if (custom.equals("CUSTOM_CLICK")){
            Log.d("RECEIVER2^^", custom)
            Toast.makeText(context, "클릭", LENGTH_SHORT).show()
        }
    }
}