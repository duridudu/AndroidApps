package com.example.ch15_messenger

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var messenger : Messenger? = null
    private var bound = false

    // 서비스컴포넌트 쓸 것이니 서비스 커넥션 생성
    private val serviceConnection = object: ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            // 서비스와 바인딩되는 메신저 객체 생성
            // 서비스 컴포넌트의 onBind에서 반환한 messenger.bind를 IBinder형태로 받아와서 넣어줌
            messenger = Messenger(p1)
            bound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            messenger = null
            bound = false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MyService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)

        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener {
            sendMessageToService()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (bound){
            unbindService(serviceConnection)
            bound = false
        }
    }

    private fun sendMessageToService(){
        if (!bound) return
        // 메시지를 얻기 위해 사용. 메세지풀에서 가져옴
        val message = Message.obtain(null, MyService.MSG_HELLO, 0,0)
        try{
            // 메신저 클래스의 기본 메소드. 메세지 객체를 넣어서 보내면 메신저의 handleMessage로 넘어감
            messenger?.send(message)
        }catch(e:RemoteException){
            e.printStackTrace()
        }
    }
}