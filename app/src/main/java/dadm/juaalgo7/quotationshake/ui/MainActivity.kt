package dadm.juaalgo7.quotationshake.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import dadm.juaalgo7.quotationshake.R
import dadm.juaalgo7.quotationshake.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
lateinit var navController: NavController
class MainActivity : AppCompatActivity(), MenuProvider{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        (binding.btvw as NavigationBarView).setupWithNavController(navController)
        setSupportActionBar(binding.materialToolbar)
        var apbar = AppBarConfiguration(setOf(R.id.newQuotationFragment, R.id.settingsFragment, R.id.favouritesFragment))
        setupActionBarWithNavController(navController,apbar)
        addMenuProvider(this)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_about, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        navController.navigate(R.id.aboutDialogFragment)
        return true;
    }
}