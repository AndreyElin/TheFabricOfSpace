package andrey.elin.thefabricofspace

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TheFabricOfSpace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadTheme()
        setContentView(R.layout.activity_the_fabric_of_space)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TFOSFragment.newInstance())
                .commitNow()
        }
    }

    private fun loadTheme() {
        val pref: SharedPreferences? = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        when (pref?.getInt("THEME", 0)) {
            0 -> setTheme(R.style.Theme_TheFabricOfSpace_MarsTheme)
            1 -> setTheme(R.style.Theme_TheFabricOfSpace_MoonTheme)
            2 -> setTheme(R.style.Theme_TheFabricOfSpace)
        }
    }
}