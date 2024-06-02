package com.example.ch15_aidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    private val binder = object : IMyAidlInterface.Stub(){
        override fun showToastMessage(message : String){
        // Display a toast message
            message?.let {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
            }
        }

    }
}