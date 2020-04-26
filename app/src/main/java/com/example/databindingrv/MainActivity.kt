package com.example.databindingrv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindingrv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val pojoAdapter = PojoAdapter()

        binding.recyclerView.apply {
            adapter = pojoAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        pojoAdapter.submitList(generatePojoList())
    }
}
