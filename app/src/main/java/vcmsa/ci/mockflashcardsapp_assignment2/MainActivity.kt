package vcmsa.ci.mockflashcardsapp_assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } //end of ViewCompat

        //Declaring variables - enter username ?
        val btnStartQuiz = findViewById<Button>(R.id.BtnStart)

        btnStartQuiz.setOnClickListener {
            //reference: Liehans class activity - Userinterface activity
            //Click Start button to navigate to the flashcard screen and start quiz
            val intent = Intent(this, FlashcardScreenActivity::class.java)
            startActivity(intent)
            finish()
        }

    } // end of onCreate
} //end of MainActivity