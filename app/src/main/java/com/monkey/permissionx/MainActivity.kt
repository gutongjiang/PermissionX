package com.monkey.permissionx

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.permissionx.monkey.PermissionX

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PermissionX.request(
            this,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) { allGranted, deniedList ->
            if (allGranted) {
                Toast.makeText(this, "权限申请成功", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "申请失败 $deniedList", Toast.LENGTH_SHORT).show()
            }
        }
    }

}