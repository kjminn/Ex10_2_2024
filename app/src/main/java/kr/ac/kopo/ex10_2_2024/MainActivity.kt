package kr.ac.kopo.ex10_2_2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var voteCount = IntArray(9)

        for(i in 0..8)
            voteCount[i] = 0

        var image = arrayOfNulls<ImageView>(9)

        var imageId = arrayOf(R.id.img01, R.id.img02, R.id.img03, R.id.img04, R.id.img05, R.id.img06, R.id.img07, R.id.img08, R.id.img09)

        var imgName = arrayOf("뉴진스의 다니엘", "뉴진스의 민지", "아이브의 장원영", "아이브의 가을", "뉴진스의 하니", "뉴진스의 혜인", "아이브의 리즈", "아이브의 이서", "아이브의 레이")

        for(i in imageId.indices){
//            ImageView객체의 참조값을 배열에 저장
            image[i] = findViewById<ImageView>(imageId[i])
            image[i]!!.setOnClickListener {
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i] + ": 총 "+ voteCount[i] +"표", Toast.LENGTH_SHORT).show()
            }
        }

        var btnDone = findViewById<Button>(R.id.btnDone)
        btnDone.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("imgName", imgName)
            intent.putExtra("voteCount", voteCount)
            startActivity(intent)
        }
    }
}