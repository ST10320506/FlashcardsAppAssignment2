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

        //GUI declarations
        val tvScoreTitle = findViewById<TextView>(R.id.tvScoreTitle)
        val btnLeaveApp = findViewById<Button>(R.id.btnLeaveApp)
        val btnReviewAnswers = findViewById<Button>(R.id.BtnReview)
        val score = intent.getIntExtra("score", 0)
        tvScoreTitle.text = "Your score is $score out of 5"

        btnLeaveApp.setOnClickListener {
            finish()
        }

        btnReviewAnswers.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
            finish()
        }
    }// end of onCreate
}// end of ScoreScreen Activity