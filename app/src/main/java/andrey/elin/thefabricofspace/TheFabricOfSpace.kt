package andrey.elin.thefabricofspace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TheFabricOfSpace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_fabric_of_space)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TFOSFragment.newInstance())
                .commitNow()
        }
    }
}