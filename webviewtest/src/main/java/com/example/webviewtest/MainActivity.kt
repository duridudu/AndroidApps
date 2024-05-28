package com.example.webviewtest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast
import com.example.webviewtest.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webview = binding.webview
        webview.settings.javaScriptEnabled = true
        webview.loadUrl("file:///android_asset/sample.html")
        webview.addJavascriptInterface(WebInterface(this), "TestApi")
    }

    class WebInterface(private val mContext: Context) {
        // 웹뷰 -> 앱으로 데이터 전달
        @JavascriptInterface
        fun showToast(toast: String){
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
        }

        // 앱 -> 웹뷰로 데이터 전달
        @JavascriptInterface
        fun getJsonData(): String {
            // JSON 데이터를 문자열로 반환
            return createJsonData().toString()
        }

        private fun createJsonData(): Any {
            val jsonObject = JSONObject()
            jsonObject.put("종목코드", "종목명")
            jsonObject.put("종목코드", "현재가")
            jsonObject.put("종목코드", "등락율")
            return jsonObject
        }
    }
}