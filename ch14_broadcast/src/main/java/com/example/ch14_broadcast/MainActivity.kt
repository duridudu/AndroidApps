package com.example.ch14_broadcast

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ch14_broadcast.R
import com.example.ch14_broadcast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 리시버 객체 생성
    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        receiver = MyReceiver()
        // 인텐트 필터 설정 (내가 수신할 이벤트들 설정)
        val filter = IntentFilter(Intent.ACTION_POWER_CONNECTED).apply {
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction("CUSTOM_CLICK")
        }
        // 리시버 등록
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(receiver, filter, RECEIVER_EXPORTED)
        }else {
            registerReceiver(receiver, filter)
        }

        binding.button.setOnClickListener {
            val intent = Intent("CUSTOM_CLICK")
            sendBroadcast(intent)
        }

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun sendBroadcast(intent: Intent?) {
        super.sendBroadcast(intent)
    }
}