package dadm.juaalgo7.quotationshake.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import dadm.juaalgo7.quotationshake.R
import dadm.juaalgo7.quotationshake.databinding.FragmentFavouritesBinding
import dadm.juaalgo7.quotationshake.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment: PreferenceFragmentCompat()  {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_settings, rootKey)

    }
}