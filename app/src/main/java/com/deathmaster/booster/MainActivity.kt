
package com.deathmaster.booster

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.BLACK
        window.navigationBarColor = Color.BLACK

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(24, 35, 24, 24)
        root.setBackgroundColor(Color.rgb(12, 12, 12))

        val title = TextView(this)
        title.text = "☠ DEATH MASTER"
        title.textSize = 28f
        title.gravity = Gravity.CENTER
        title.setTextColor(Color.RED)
        root.addView(title)

        val subtitle = TextView(this)
        subtitle.text = "ULTIMATE GAMING COMPANION"
        subtitle.gravity = Gravity.CENTER
        subtitle.setTextColor(Color.WHITE)
        subtitle.setPadding(0, 15, 0, 30)
        root.addView(subtitle)

        addButton(root, "BATTERY SETTINGS") {
            startActivity(Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS))
        }

        addButton(root, "APP MANAGEMENT") {
            startActivity(Intent(Settings.ACTION_APPLICATION_SETTINGS))
        }

        addButton(root, "DISPLAY SETTINGS") {
            startActivity(Intent(Settings.ACTION_DISPLAY_SETTINGS))
        }

        val info = TextView(this)
        info.text = "\nGaming tips:\n\n" +
                "• Close unused apps.\n" +
                "• Keep storage free.\n" +
                "• Use suitable game graphics.\n" +
                "• Avoid excessive heating.\n\n" +
                "DEATH MASTER v1.0"
        info.textSize = 16f
        info.setTextColor(Color.WHITE)
        root.addView(info)

        setContentView(root)
    }

    private fun addButton(
        root: LinearLayout,
        label: String,
        action: () -> Unit
    ) {
        val button = Button(this)
        button.text = label
        button.setOnClickListener { action() }

        root.addView(button)
    }
}
