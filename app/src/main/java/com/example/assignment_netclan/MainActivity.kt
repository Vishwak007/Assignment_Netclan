package com.example.assignment_netclan
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var expand1:RelativeLayout
    lateinit var expand2:RelativeLayout
    lateinit var expand3:RelativeLayout
    lateinit var btnCont1:LinearLayout
    lateinit var btnCont2:LinearLayout
    lateinit var btnCont3:LinearLayout
    lateinit var cnfmBtn1:TextView
    lateinit var cnfmBtn2:TextView
    lateinit var cnfmBtn3:TextView
    lateinit var animation:Animation
    var iVisibleCont1 = false
    var iVisibleCont2 = false
    var iVisibleCont3 = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changestatusBarColor()
        initializeAll()
        clickButton()
    }

    private fun clickButton() {
        btnCont1.setOnClickListener(this)
        btnCont2.setOnClickListener(this)
        btnCont3.setOnClickListener(this)
        cnfmBtn1.setOnClickListener(this)
        cnfmBtn2.setOnClickListener(this)
        cnfmBtn3.setOnClickListener(this)
    }

    private fun initializeAll() {
        expand1 = findViewById(R.id.expand1)
        expand2 = findViewById(R.id.expand2)
        expand3 = findViewById(R.id.expand3)
        btnCont1 = findViewById(R.id.btn_cont1)
        btnCont2 = findViewById(R.id.btn_cont2)
        btnCont3 = findViewById(R.id.btn_cont3)
        cnfmBtn1 = findViewById(R.id.btn_cnfm_1)
        cnfmBtn2 = findViewById(R.id.btn_cnfm_2)
        cnfmBtn3 = findViewById(R.id.btn_cnfm_3)
        animation = AnimationUtils.loadAnimation(
                this, R.anim.blink_anim)
    }

    private fun changestatusBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.statusBarColor)
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when(p0.id){
                R.id.btn_cont1 -> {
                    if (! iVisibleCont1){
                        expand1.visibility = View.VISIBLE
                        expand2.visibility = View.GONE
                        expand3.visibility = View.GONE
                        iVisibleCont1 = true
                        iVisibleCont2 = false
                        iVisibleCont3 = false
                        btnCont1.startAnimation(animation)
                    }


                }
                R.id.btn_cont2 -> {
                    if (! iVisibleCont2){
                        expand1.visibility = View.GONE
                        expand2.visibility = View.VISIBLE
                        expand3.visibility = View.GONE
                        iVisibleCont1 = false
                        iVisibleCont2 = true
                        iVisibleCont3 = false
                        btnCont2.startAnimation(animation)
                    }
                }
                R.id.btn_cont3 -> {
                    if (! iVisibleCont1){
                        expand1.visibility = View.GONE
                        expand2.visibility = View.GONE
                        expand3.visibility = View.VISIBLE
                        iVisibleCont1 = false
                        iVisibleCont2 = false
                        iVisibleCont3 = true
                        btnCont3.startAnimation(animation)

                    }
                }
                else -> {
                    val intent = Intent(this, PersonalActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }
}