package dadm.juaalgo7.quotationshake.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dadm.juaalgo7.quotationshake.R
import dadm.juaalgo7.quotationshake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}