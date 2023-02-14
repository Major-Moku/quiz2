package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.QuoteSpan
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    private lateinit var trueButton: Button
//    private lateinit var falseButton:Button

    private val questionBank = listOf(
        Questions(R.string.question_australia, true),
        Questions(R.string.question_asia, false),
        Questions(R.string.question_oceans,true)
    )
    private var currentIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        trueButton = findViewById(R.id.true_button)
        binding.trueButton.setOnClickListener{view: View ->
//            Toast.makeText(
//                this,
//                R.string.correct_toast,
//                Toast.LENGTH_SHORT
//            ).show()
            checkAnswer(true)
        }
//        falseButton = findViewById(R.id.false_button)
        binding.falseButton.setOnClickListener{view: View ->
//            Toast.makeText(
//                this,
//                R.string.incorrect_toast,
//                Toast.LENGTH_SHORT
//            ).show()
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener { view: View ->
            currentIndex = (currentIndex+1)%questionBank.size
//            val questionTextResId = questionBank[currentIndex].textResId
//            binding.questionTextView.setText(questionTextResId)
            updateQuestion()
        }

        binding.cheatButton.setOnClickListener{
            val intent = Intent(this, CheatActivity::class.java)
            val answerIsTrue: Boolean = questionBank[currentIndex].answer
            intent.putExtra(CheatActivity.EX)
            startActivity(intent)
        }

//        val questionTextResId = questionBank[currentIndex].textResId
//        binding.questionTextView.setText(questionTextResId)
        updateQuestion()
    }

    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(answer: Boolean){
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if(answer == correctAnswer){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}