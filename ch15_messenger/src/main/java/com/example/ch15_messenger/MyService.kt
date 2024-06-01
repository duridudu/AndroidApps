package com.example.ch15_messenger

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.widget.Toast

class MyService : Service() {
    // 난 메신저를 쓸거다
    private lateinit var messenger: Messenger

    override fun onCreate() {
        super.onCreate()
        // 메신저를 만들때엔 메신저 객체에 핸들러를 매개변수로 넘겨줘야한다.
        messenger = Messenger(IncomingHandler())
    }
    override fun onBind(intent: Intent): IBinder {
        // onBind에서 메신저의 바인더를 리턴해줌
        return messenger.binder
    }

    private inner class IncomingHandler: Handler(){
        // 핸들러는 말그대로,, 어떻게 핸들할 것이다를 담고 있다
        // 메세지 객체는 핸들러를 통해 메시지 큐에 전달된다.
        override fun handleMessage(msg: Message) {
            when (msg.what){
                MSG_HELLO -> {
                    // 처리할 내용
                    showToast("hello from client~")
                }

                else -> super.handleMessage(msg)
            }

        }

    }
    companion object {
        const val MSG_HELLO = 1
    }

    // 토스트 메시지를 띄우는 함수
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}