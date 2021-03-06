package com.foamkart.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.foamkart.FoamkartApp
import com.foamkart.Helper.SharedPrefData
import com.foamkart.R
import com.foamkart.databinding.ActivityDashboardBinding
import com.foamkart.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        startActivity(Intent(this@LoginActivity,DashboardActivity::class.java))

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this@LoginActivity,DashboardActivity::class.java))
            finish()
        }
        binding.btnSingUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity,SingUp::class.java))
        }
    }
}