package com.hendev.progresbarsliderraiting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            progressBar.visibility = View.VISIBLE
        }

        btnEnd.setOnClickListener {
            progressBar.visibility = View.INVISIBLE
        }

        seekBarN.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = "Sonuç : $progress"
                //textView.text = progress.toString();
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                textView.text = "Ayar Değiştiriliyor"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                textView.text = "Ayar Değiştirildi. Durum: ${seekBarN.progress.toString()}"
            }
        })

        textView.text = seekBarN.progress.toString()

        btnShow.setOnClickListener {

            val pb_progress = seekBarN.progress
            val _rating = ratingBar2.rating

            textView.text = "Bar : $pb_progress Rating : $_rating"

        }


    }
}