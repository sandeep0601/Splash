package com.foamkart.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.foamkart.FoamkartApp
import com.foamkart.Helper.SharedPrefData
import com.foamkart.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        setContentView(R.layout.activity_login)

        FoamkartApp.getSharedPreferences(this)
        FoamkartApp.writeStringPreference(SharedPrefData.PREF_F_name,"name1")
        Log.e("@@", FoamkartApp.ReadStringPreferences(SharedPrefData.PREF_F_name).toString())

        btn_login.setOnClickListener {
            startActivity(Intent(this@LoginActivity,DashboardActivity::class.java))
        }
        signuptxt.setOnClickListener {
            startActivity(Intent(this@LoginActivity,SingUp::class.java))
        }
    }
}