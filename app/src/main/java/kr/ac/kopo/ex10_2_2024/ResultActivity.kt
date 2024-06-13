package kr.ac.kopo.ex10_2_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var intent = intent

        var imgName = intent.getStringArrayExtra("imgName");
        var voteCount = intent.getIntArrayExtra("voteCount");

        var text = arrayOfNulls<TextView>(imgName!!.size)
        var ratingBar = arrayOfNulls<RatingBar>(imgName!!.size)

        var textId = arrayOf(R.id.text01, R.id.text02, R.id.text03, R.id.text04, R.id.text05, R.id.text06, R.id.text07, R.id.text08, R.id.text09)
        var ratingBarId = arrayOf(R.id.r1, R.id.r2, R.id.r3, R.id.r4, R.id.r5, R.id.r6, R.id.r7, R.id.r8, R.id.r9)

        for (i in textId!!.indices){
            text[i] = findViewById<TextView>(textId[i])
            ratingBar[i] = findViewById<RatingBar>(ratingBarId[i])
            text[i]!!.setText(imgName[i])
            ratingBar[i]!!.rating = voteCount!![i].toFloat()
        }

        var btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            finish()
        }
    }
}