package com.example.intentappmrning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var btnSms:Button
    private lateinit var btnEmail:Button
    private lateinit var btnCamera:Button
    private lateinit var btnShare:Button
    private lateinit var btnMpesa:Button
    private lateinit var btnCall:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSms = findViewById(R.id.btnsms)
        btnEmail = findViewById(R.id.btnemail)
        btnCamera = findViewById(R.id.btncamera)
        btnShare = findViewById(R.id.btnshare)
        btnMpesa = findViewById(R.id.btnmpesa)
        btnCall = findViewById(R.id.btncall)

        btnSms.setOnClickListener {
            val uri: Uri=Uri.parse("sms to :0790404990")
            val intent = Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("sms_body","vipi boss siku mingi")
            startActivity(intent)
        }
        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","elikibetael4@gmail.com",null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT,"Dear Sir/Madam, I'm applying for an Underwater Ceramics Technician")
            startActivity(Intent.createChooser(emailIntent,"Send email..."))
        }
        btnCamera.setOnClickListener {
            val takePictureIntent =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent,1)
        }
        btnMpesa.setOnClickListener {
            val simToolKitIntent =applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitIntent?.let { startActivity((it)) }

        }
        btnShare.setOnClickListener {

        }

    }
}