package vcmsa.ci.mockflashcardsapp_assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashcardScreenActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } //end of ViewCompat

        //Declaring variables on the Flashcard activity screen GUI
        val tvQuestionTitle = findViewById<TextView>(R.id.tvQuestion)
        val radioGroupAnswers = findViewById<RadioGroup>(R.id.rdGrpAnswers)
        val btnNextQuestion = findViewById<Button>(R.id.BtnNextQuestion)

        //Arrays created for the flashcard questions and answers
        //Reference: https://github.com/liehanels/QuizzApp - Liehan Els, 2025. Liehan had written code to show how to create an array. [online] Available at: <https://github.com/liehanels/QuizzApp> [Accessed 21 May 2025].
        //Reference: https://youtu.be/K13fR2RHTak - Liehan Els, 2025. Coding up the Quiz app with lots of debugging. [video online] Available at: <https://youtu.be/K13fR2RHTak> [Accessed 21 May 2025].

        //Array of Questions based on the history of South African Apartheid
        val historyQuestions = arrayOf(
            "1. Apartheid was a policy or system of segregation or discrimination on the grounds of race.", //- true
            "2. Apartheid ended in 1974.", //ended in 1994 - false
            "3. Nelson Mandela was South Africa's first black president in 1994.", // - true
            "4. Nelson Mandela was imprisoned for 30 years before becoming president of South Africa.", //imprisoned for 27 years - false
            "5. Pass laws required black South African to carry passbooks to enter white areas." // - true
        )

        //Array of True and False options users can choose from using radio buttons
        val historyAnswerChoices = arrayOf(
            arrayOf("True", "False"),
            arrayOf("True", "False"),
            arrayOf("True", "False"),
            arrayOf("True", "False"),
            arrayOf("True", "False")
        )

        // Array to store the users answers
        var userAnswers = arrayOfNulls<String>(5)

        //Array of the correct answers to the apartheid questions
        val historyAnswers = arrayOf(
            "True",
            "False",
            "True",
            "False",
            "True"
        )

        //counter variable to keep track of each question user got correct
        var counter = 0
        //score variable to keep track of the score as user answers the questions
        var score = 0
        //check variable to display 'correct/incorrect' to the user when true/false is chosen
        var check = 0

        //Reference: https://youtu.be/K13fR2RHTak - Liehan Els, 2025. Coding up the Quiz app with lots of debugging. [video online] Available at: <https://youtu.be/K13fR2RHTak> [Accessed 21 May 2025].
        //for loop to display question and true/false choices to the user
        tvQuestionTitle.text = historyQuestions[counter]
        for (i in 0 until radioGroupAnswers.childCount) {
            val radioButton = radioGroupAnswers.getChildAt(i) as RadioButton
            radioButton.text = historyAnswerChoices[counter][i]
        }

        //Declaring the next question button function that when clicked it will go through and display each question
        btnNextQuestion.setOnClickListener {
            if (counter < 5) {

                var selectedAnswer = radioGroupAnswers.checkedRadioButtonId
               //Reference: https://youtu.be/K13fR2RHTak - Liehan Els, 2025. Coding up the Quiz app with lots of debugging. [video online] Available at: <https://youtu.be/K13fR2RHTak> [Accessed 21 May 2025].
               //if...else statement to check if user has selected an answer
                if (selectedAnswer != -1) {
                    val selectedRbtn = findViewById<RadioButton>(selectedAnswer)
                    userAnswers[counter] = selectedRbtn.text.toString()
                    Log.d("userAnswer", userAnswers[counter].toString())
                    counter++
                } else {
                    Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                //Reference: https://youtu.be/K13fR2RHTak - Liehan Els, 2025. Coding up the Quiz app with lots of debugging. [video online] Available at: <https://youtu.be/K13fR2RHTak> [Accessed 21 May 2025].
                //if...else statement to check if the user has answered all questions
                if (counter < 5) {
                    tvQuestionTitle.text = historyQuestions[counter]
                    for (i in 0 until radioGroupAnswers.childCount) {
                        val radioButton = radioGroupAnswers.getChildAt(i) as RadioButton
                        radioButton.text = historyAnswerChoices[counter][i]
                    }
                    radioGroupAnswers.clearCheck()
                } else {
                    for (i in 0 until 5) {
                        if (userAnswers[i] == historyAnswers[i]) {
                            //score++ is used to check if the users answers match the history answers coded
                            score++
                        }
                    }
                    //Log statement used to check the users score
                    Log.d("score", score.toString())
                    //Intent code used to naviagte from Flashcard screen to score screen once all questions have been answered
                    //Reference: https://youtu.be/K13fR2RHTak - Liehan Els, 2025. Coding up the Quiz app with lots of debugging. [video online] Available at: <https://youtu.be/K13fR2RHTak> [Accessed 21 May 2025].
                    val intent = Intent(this, ScoreScreenActivity::class.java)
                        .putExtra("score", score)
                    startActivity(intent)
                    finish()
                }

                //Reference: https://youtu.be/K13fR2RHTak - Liehan Els, 2025. Coding up the Quiz app with lots of debugging. [video online] Available at: <https://youtu.be/K13fR2RHTak> [Accessed 21 May 2025].
                //if...else statement to check if user has selected the correct answer
                if (userAnswers[check] == historyAnswers[check]) {
                    //Toast message display correct if user chooses correct answer
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                    //check++ is used to check if the users answers match the history answers coded
                    check++
                } else {
                    //Toast message display incorrect if user chooses incorrect answer
                    Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                    check++
                }
            }
        }
    }//end of onCreate
}//end of FlashcardScreen Activity