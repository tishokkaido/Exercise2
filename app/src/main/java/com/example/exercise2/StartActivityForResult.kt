package com.example.exercise2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StartActivityForResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_for_result)

        var receivedName: String? = null
        var receivedAge: Int = 0
        var receivedAddress: String? = null

        // Intentの受け取り
        intent?.let {
            val parcel = intent.getParcelableExtra<ParcelableData>(ParcelableActivity.PARCELABLE_KEY)
            receivedName = parcel?.name
            receivedAge = parcel?.age ?: 0
            receivedAddress = parcel?.address
        }

        // Viewへのセット
        findViewById<TextView>(R.id.text_name).text = receivedName
        findViewById<TextView>(R.id.text_age).text = receivedAge.toString()
        findViewById<TextView>(R.id.text_address).text = receivedAddress

        // OKボタンのクリック処理
        findViewById<Button>(R.id.button_ok).setOnClickListener {
            intent.putExtra(RESULT_KEY, "OK：確認しました")
            setResult(RESULT_OK, intent)
            finish()
        }

        // CANCELボタンのクリック処理
        findViewById<Button>(R.id.button_cancel).setOnClickListener {
            intent.putExtra(RESULT_KEY, "キャンセル：入力しなおしてください")
            setResult(RESULT_CANCELED, intent)
            finish()
        }
    }

    companion object {
        const val RESULT_KEY = "result_key"
    }
}