package com.sitiaisyah.idn.likeunlike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sitiaisyah.idn.likeunlike.data.MainViewModel
import com.sitiaisyah.idn.likeunlike.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.mainBinding = mainViewModel
        binding.lifecycleOwner = this

        binding.imageFood = getDrawable(R.drawable.macaron)

    }
}
