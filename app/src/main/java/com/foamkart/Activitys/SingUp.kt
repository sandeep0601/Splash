package com.foamkart.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.foamkart.R
import com.foamkart.databinding.ActivityLoginBinding
import com.foamkart.databinding.ActivitySingUpBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_login
import kotlinx.android.synthetic.main.activity_sing_up.*

class SingUp : AppCompatActivity() {
    lateinit var binding: ActivitySingUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
//        setContentView(R.layout.activity_sing_up)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sing_up)

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this@SingUp,DashboardActivity::class.java))
            finish()
        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this@SingUp,LoginActivity::class.java))
            finish()
        }
    }
}