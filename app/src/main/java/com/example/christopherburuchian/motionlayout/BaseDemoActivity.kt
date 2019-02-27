package com.example.christopherburuchian.motionlayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = intent.getIntExtra(LAYOUT_ID, R.layout.demo_constraint_set_initial_state)
        setContentView(layout)

        val intentTitle = intent.getStringExtra(TITLE)
        intentTitle?.let {
            title = it
        }
    }

    companion object {
        const val LAYOUT_ID = "LAYOUT_ID"
        const val TITLE = "TITLE"
    }
}