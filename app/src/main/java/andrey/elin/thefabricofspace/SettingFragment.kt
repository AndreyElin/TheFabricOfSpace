package andrey.elin.thefabricofspace

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.bottom_sheet_layout.*
import kotlinx.android.synthetic.main.fragment_setting.*


class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chipGroup.setOnCheckedChangeListener { chipGroup, position ->
            chipGroup.findViewById<Chip>(position)?.let {
                mars_chip.setOnClickListener {
                    changeTheme(0)
                    Toast.makeText(context, "Выбрана тема Марс", Toast.LENGTH_SHORT).show()
                }
                moon_chip.setOnClickListener {
                    changeTheme(1)
                    Toast.makeText(context, "Выбрана тема Луна", Toast.LENGTH_SHORT).show()
                }
                earth_chip.setOnClickListener {
                    changeTheme(2)
                    Toast.makeText(context, "Выбрана тема Земля", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun changeTheme(count: Int) {

        val pref: SharedPreferences? =
            activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor? = pref?.edit()
        editor?.apply {
            putInt("THEME", count)
        }?.apply()

        activity?.recreate()

    }

}