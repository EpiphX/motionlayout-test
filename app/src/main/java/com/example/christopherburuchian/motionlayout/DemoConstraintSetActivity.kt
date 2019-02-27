package com.example.christopherburuchian.motionlayout

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.demo_constraint_set_initial_state.*

class DemoConstraintSetActivity : BaseDemoActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val initialState = ConstraintSet()
        initialState.clone(cl)

        val finalState = ConstraintSet()
        finalState.clone(this, R.layout.demo_constraint_set_final_state)

        var set = false
        ivDalvik.setOnClickListener {

            TransitionManager.beginDelayedTransition(cl)
            val constraints = if (set) {
                initialState
            } else {
                finalState
            }
            constraints.applyTo(cl)
            set = !set
        }
    }
}