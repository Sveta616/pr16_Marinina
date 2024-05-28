package com.example.pr16_m

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

@SuppressLint("CustomSplashScreen")
class Splashscreen : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var vperedButton: Button
    private lateinit var nazadButton: Button
    private lateinit var questionTextView: TextView
    private var questionBank = listOf(
        Question(R.string.q_t1, true),
        Question(R.string.q_t2, false),
        Question(R.string.q_t3, true),
        Question(R.string.q_t4, true),
        Question(R.string.q_t5, true)
    )
    private var currentindex = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        trueButton = findViewById(R.id.but)
        falseButton = findViewById(R.id.false_button)
        vperedButton = findViewById(R.id.bvpered)
        nazadButton = findViewById(R.id.bnazad)
        questionTextView = findViewById(R.id.qtext)
        trueButton.setOnClickListener { view: View -> checkAnswer(true)}
        falseButton.setOnClickListener { view: View -> checkAnswer(false)}
        val questTextResId = questionBank[currentindex].textResId
        questionTextView.setText(questTextResId)
        vperedButton.setOnClickListener { currentindex = (currentindex + 1) % questionBank.size
            updateQuestion()}
        updateQuestion()
        }

        private fun updateQuestion() {
            val questionTextResId = questionBank[currentindex].textResId
            questionTextView.setText(questionTextResId)
        }

        private fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = questionBank[currentindex].answer
            val messageResId = if (userAnswer == correctAnswer) {
                R.string.correct_toast
            } else {
                R.string.incorrect_toast
            }
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
        }
    }




