package dadm.juaalgo7.quotationshake.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.juaalgo7.quotationshake.R
import dadm.juaalgo7.quotationshake.databinding.FragmentFavouritesBinding
import dadm.juaalgo7.quotationshake.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment: Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null;
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}