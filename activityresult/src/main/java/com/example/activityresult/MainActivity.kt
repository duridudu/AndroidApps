package com.example.activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Id = findViewById<TextView>(R.id.tvId)
        val Pw = findViewById<TextView>(R.id.tvPassword)
        val bt = findViewById<Button>(R.id.btMain)

        // sub 액티비티를 실행하는 동작
        bt.setOnClickListener {
            val intent = Intent(this,SubActivity::class.java)
            resultLauncher.launch(intent)
        }

        // sub 액티비티에서 되돌아올 때 수행할 동작
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            result -> if (result.resultCode == RESULT_OK){
                val id = result.data?.getStringExtra("Id")?:""
                val password = result.data?.getStringExtra("Password")?:""

                Id.setText(id)
                Pw.setText(password)
        }
        }
    }
}