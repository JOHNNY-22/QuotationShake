package dadm.juaalgo7.quotationshake.ui.newquotation

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.google.android.material.snackbar.Snackbar
import dadm.juaalgo7.quotationshake.R
import dadm.juaalgo7.quotationshake.databinding.FragmentNewQuotatioinBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewQuotationFragment : Fragment(R.layout.fragment_new_quotatioin), MenuProvider{
    private val viewModel: NewQuotationViewModel by viewModels();
    private var _binding: FragmentNewQuotatioinBinding? = null;
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotatioinBinding.bind(view)
        viewModel.userName.observe(viewLifecycleOwner) {
            binding.tvWelcome.text = getString(R.string.refresh, it)
        }

        viewModel.Quotation.observe(viewLifecycleOwner) { it.author
            binding.tvQuotation.text = it?.text
            binding.tvAuthor.text = it?.author ?: "anonymous"
        }
        viewModel.isRefreshing.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it
        }
        viewModel.isGreetingsVisible.observe(viewLifecycleOwner) {
            binding.tvWelcome.visibility = if (it) View.VISIBLE else View.GONE
        }
        viewModel.isButtonVisible.observe(viewLifecycleOwner) {
            binding.btnAddToFavourites.visibility = if (it) View.VISIBLE else View.GONE
        }
        viewModel.areError.observe(viewLifecycleOwner) {
           if (it != null) {
               Snackbar.make(view, it.toString(), Snackbar.LENGTH_LONG).show()
           }
            viewModel.resetError()
        }

        binding.swipeRefresh.setOnRefreshListener{
            viewModel.getNewQuotation()
        }
        binding.btnAddToFavourites.setOnClickListener {
            viewModel.addToFavourites()
        }
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

        menuInflater.inflate(R.menu.menu_new_quotation, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.refresh -> {
                viewModel.getNewQuotation()
                true
            }
            else -> false
        }
    }
}