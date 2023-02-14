package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCheatBinding
private const val EXTRA_ANSWER_IS_TRUE = "com.example.myapplication.answer_is_true"
class CheatActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCheatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_cheat)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}