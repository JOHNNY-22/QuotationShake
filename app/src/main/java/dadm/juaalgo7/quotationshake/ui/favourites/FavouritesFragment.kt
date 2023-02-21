package dadm.juaalgo7.quotationshake.ui.favourites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.juaalgo7.quotationshake.R
import dadm.juaalgo7.quotationshake.databinding.FragmentFavouritesBinding
import dadm.juaalgo7.quotationshake.databinding.FragmentNewQuotatioinBinding

class FavouritesFragment: Fragment(R.layout.fragment_favourites) {
    private var _binding: FragmentFavouritesBinding? = null;
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}