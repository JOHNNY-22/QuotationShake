package dadm.juaalgo7.quotationshake.ui.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.juaalgo7.quotationshake.R
import dadm.juaalgo7.quotationshake.databinding.FragmentNewQuotatioinBinding


class NewQuotationFragment : Fragment(R.layout.fragment_new_quotatioin) {
    private var _binding: FragmentNewQuotatioinBinding? = null;
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotatioinBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}