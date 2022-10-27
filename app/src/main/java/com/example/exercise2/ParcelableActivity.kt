package com.example.exercise2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ParcelableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        var receivedName: String? = null
        var receivedAge: Int = 0
        var receivedAddress: String? = null

        // Intentの受け取り
        if (intent != null) {
            // データの取り出し
            val parcel = intent.getParcelableExtra<ParcelableData>(MainActivity.PARCEL_KEY)
            receivedName = parcel?.name
            receivedAge = parcel?.age ?: 0
            receivedAddress = parcel?.address
        }

        // Viewへのセット
        findViewById<TextView>(R.id.text_name).text = receivedName
        findViewById<TextView>(R.id.text_age).text = receivedAge.toString()
        findViewById<TextView>(R.id.text_address).text = receivedAddress
    }
}