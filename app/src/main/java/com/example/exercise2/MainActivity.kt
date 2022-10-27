package com.example.exercise2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Parcelableボタンクリック処理
        findViewById<Button>(R.id.parcelable_button).setOnClickListener {
            // 設定
            val parcelableData = ParcelableData("山田太郎", 22, "東京都在住")
            val intent = Intent(this, ParcelableActivity::class.java).also {
                it.putExtra(PARCEL_KEY, parcelableData)
            }
            startActivity(intent)
        }
    }

    companion object {
        const val PARCEL_KEY = "parcel_key"
    }
}