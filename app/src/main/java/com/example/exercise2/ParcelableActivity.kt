package com.example.exercise2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        // ボタンのクリック処理
        findViewById<Button>(R.id.button_start_activity_for_result).setOnClickListener {
            // 設定
            val parcelableData = ParcelableData("山田花子", 18, "北海道在住")
            val intent = Intent(this, StartActivityForResult::class.java).also {
                it.putExtra(PARCELABLE_KEY, parcelableData)
            }
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var resultText: String? = null
        when (requestCode) {
            REQUEST_CODE -> {
                when (resultCode) {
                    RESULT_OK -> {
                        resultText = data?.getStringExtra(StartActivityForResult.RESULT_KEY)
                    }
                    RESULT_CANCELED -> {
                        resultText = data?.getStringExtra(StartActivityForResult.RESULT_KEY)
                    }
                }
            }
        }

        findViewById<TextView>(R.id.text_result).text = resultText
    }

    companion object {
        const val PARCELABLE_KEY = "parcelable_key"
        const val REQUEST_CODE = 1000
    }
}