package com.foamkart.Activitys

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.foamkart.R

class SplachScreen : AppCompatActivity() {
    var CAMERA_PERMISSION_CODE = 100
    var STORAGE_PERMISSION_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach_screen)

/*        checkPermission(
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_NUMBERS,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ), CAMERA_PERMISSION_CODE
        )*/

        Handler().postDelayed(Runnable {
//            val mainIntent = Intent(this@SplachScreen,MainActivity::class.java)
            val mainIntent = Intent(this@SplachScreen,LoginActivity::class.java)
            this@SplachScreen.startActivity(mainIntent)
            this@SplachScreen.finish()
        },3000)




    }

    fun checkPermission(permission: Array<out String>, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                this@SplachScreen,
                permission[0]
            ) === PackageManager.PERMISSION_DENIED
        ) {

            ActivityCompat.requestPermissions(
                this@SplachScreen, permission,
                requestCode
            )
        } else {
            /*Toast.makeText(
                this@DashboardActivity,
                "Permission already granted",
                Toast.LENGTH_SHORT
            ).show()*/





        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.size > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(
                    this,
                    "Camera Permission Granted",
                    Toast.LENGTH_SHORT
                )
                    .show();
            } else {
                Toast.makeText(this, "Camera Permission Denied",Toast.LENGTH_SHORT).show();
                val requiredPermission = Manifest.permission.CAMERA
                val checkVal: Int = checkCallingOrSelfPermission(requiredPermission)

                if (checkVal == PackageManager.PERMISSION_GRANTED) {
                    Log.e(">>", "if")

                } else {
                    Log.e(">>", "else")
                    startActivity(
                        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + this.packageName)))
                }
            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.size > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(
                    this,
                    "Storage Permission Denied",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

    }


}