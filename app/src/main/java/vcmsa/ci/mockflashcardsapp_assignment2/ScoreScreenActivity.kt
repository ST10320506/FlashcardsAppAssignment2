package vcmsa.ci.mockflashcardsapp_assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreenActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }// end of ViewCompat

        //Declaring the GUI variables on the score screen
        val tvScoreTitle = findViewById<TextView>(R.id.tvScoreTitle)
        val btnLeaveApp = findViewById<Button>(R.id.btnLeaveApp)
        val btnReviewAnswers = findViewById<Button>(R.id.BtnReview)
        //Reference: https://youtu.be/K13fR2RHTak - Liehan Els, 2025. Coding up the Quiz app with lots of debugging. [video online] Available at: <https://youtu.be/K13fR2RHTak> [Accessed 21 May 2025].
        //Intent is created to pass and display the users score on the score screen
        val score = intent.getIntExtra("score", 0)
        tvScoreTitle.text = "Your score is $score out of 5"

        //Declaring leave app button function so when clicked it will navigate to the main screen activity
        btnLeaveApp.setOnClickListener {
            finish()
        }

        //Declaring review answeres button function so users can navigate to the review screen if they want to review the questions and answers
        btnReviewAnswers.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
            finish()
        }
    }// end of onCreate
}// end of ScoreScreen Activity