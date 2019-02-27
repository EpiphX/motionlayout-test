package com.example.christopherburuchian.motionlayout

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DemoAdapter.Listener {
    private val data = listOf(
        DemoAdapter.Demo(
            "ConstraintSet Demo",
            R.layout.demo_constraint_set_initial_state,
            DemoConstraintSetActivity::class.java
        ),
        DemoAdapter.Demo("Basic Example", R.layout.basic_example),
        DemoAdapter.Demo("Navigation Bar Example", R.layout.navigation_bar_example),
        DemoAdapter.Demo("Light / Dark Mode Example", R.layout.light_and_dark_mode_example)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = DemoAdapter(this, data)
        rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    override fun onDemoSelected(demo: DemoAdapter.Demo) {
        val intent = Intent(this, demo.activity).apply {
            putExtra(BaseDemoActivity.LAYOUT_ID, demo.layout)
            putExtra(BaseDemoActivity.TITLE, demo.title)
        }
        startActivity(intent)
    }
}

