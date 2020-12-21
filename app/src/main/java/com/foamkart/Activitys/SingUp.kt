package com.foamkart.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.foamkart.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_login
import kotlinx.android.synthetic.main.activity_sing_up.*

class SingUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        setContentView(R.layout.activity_sing_up)

        btn_login.setOnClickListener {
            startActivity(Intent(this@SingUp,DashboardActivity::class.java))
        }
        btn_sinin.setOnClickListener {
            startActivity(Intent(this@SingUp,LoginActivity::class.java))
        }
    }
}