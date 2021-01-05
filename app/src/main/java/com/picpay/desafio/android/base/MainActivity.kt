package com.picpay.desafio.android.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.picpay.desafio.android.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}