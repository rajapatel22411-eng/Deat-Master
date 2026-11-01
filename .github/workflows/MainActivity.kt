package com.deathmaster.booster

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {
    private val bg = Color.rgb(10, 10, 10)
    private val panel = Color.rgb(27, 27, 27)
    private val red = Color.rgb(255, 59, 48)
    private val white = Color.WHITE
    private val muted = Color.rgb(185, 185, 185)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = bg
        window.navigationBarColor = bg

        val scroll = ScrollView(this)
        scroll.setBackgroundColor(bg)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(22, 28, 22, 28)
        }
        scroll.addView(root)

        val title = TextView(this).apply {
            text = "☠  DEATH MASTER"
            textSize = 27f
            setTextColor(red)
            gravity = Gravity.CENTER
            typeface = android.graphics.Typeface.DEFAULT_BOLD
        }
        root.addView(title, matchWrap())

        val subtitle = TextView(this).apply {
            text = "LIGHTWEIGHT GAME COMPANION"
            textSize = 11f
            letterSpacing = 0.16f
            setTextColor(muted)
            gravity = Gravity.CENTER
            setPadding(0, 8, 0, 22)
        }
        root.addView(subtitle, matchWrap())

        val status = TextView(this).apply {
            text = "DEVICE PROFILE\\nVivo Y17 (1901) • Android gaming tools"
            textSize = 15f
            setTextColor(white)
            setPadding(18, 18, 18, 18)
            setBackgroundColor(panel)
        }
        root.addView(status, matchWrap())

        addSection(root, "QUICK TOOLS")
        addAction(root, "Battery settings", "Open Android battery controls") {
            openSettings(Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS))
        }
        addAction(root, "App settings", "Manage or close apps you are not using") {
            openSettings(Intent(Settings.ACTION_APPLICATION_SETTINGS))
        }
        addAction(root, "Display settings", "Adjust brightness and screen timeout") {
            openSettings(Intent(Settings.ACTION_DISPLAY_SETTINGS))
        }
        addAction(root, "Storage settings", "Check free storage space") {
            openSettings(Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS))
        }

        addSection(root, "BEFORE PLAYING")
        val tips = TextView(this).apply {
            text = "1. Close apps you do not need.\\n\\n" +
                "2. Keep some storage space free.\\n\\n" +
                "3. Lower in-game graphics if the phone gets hot or frames drop.\\n\\n" +
                "4. Avoid playing while charging if the phone becomes warm.\\n\\n" +
                "5. Use a stable network connection."
            textSize = 14f
            setTextColor(white)
            setPadding(18, 18, 18, 18)
            setBackgroundColor(panel)
        }
        root.addView(tips, matchWrap())

        val note = TextView(this).apply {
            text = "\\nHONEST PERFORMANCE NOTE\\nThis app does not overclock the phone, magically clear RAM, or guarantee zero lag/heat. Android controls hardware and background processes. These shortcuts help you manage settings safely."
            textSize = 12f
            setTextColor(muted)
            setPadding(4, 18, 4, 10)
        }
        root.addView(note, matchWrap())
        setContentView(scroll)
    }

    private fun addSection(root: LinearLayout, label: String) {
        val t = TextView(this).apply {
            text = label
            textSize = 12f
            typeface = android.graphics.Typeface.DEFAULT_BOLD
            setTextColor(red)
            setPadding(2, 24, 2, 10)
        }
        root.addView(t, matchWrap())
    }

    private fun addAction(root: LinearLayout, label: String, detail: String, action: () -> Unit) {
        val box = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 14, 16, 14)
            setBackgroundColor(panel)
        }
        val t = TextView(this).apply {
            text = label
            textSize = 16f
            typeface = android.graphics.Typeface.DEFAULT_BOLD
            setTextColor(white)
        }
        val d = TextView(this).apply {
            text = detail
            textSize = 12f
            setTextColor(muted)
            setPadding(0, 5, 0, 0)
        }
        box.addView(t, matchWrap())
        box.addView(d, matchWrap())
        box.setOnClickListener { action() }
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.bottomMargin = 10
        root.addView(box, params)
    }

    private fun openSettings(intent: Intent) {
        try {
            startActivity(intent)
        } catch (_: Exception) {
            startActivity(Intent(Settings.ACTION_SETTINGS))
        }
    }

    private fun matchWrap() = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
}
