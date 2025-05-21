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

        //Declaring variables on the main activity user interface
        val btnStartQuiz = findViewById<Button>(R.id.BtnStart)

        //Declaring the start quiz button function that when clicked it will navigate to the flashcard screen
        btnStartQuiz.setOnClickListener {
            //Intent code is used to navigate from the main activity to the flashcard screen
            //Reference: https://github.com/liehanels/UserInterface - Liehan Els, 2025. Liehan had written code to show how to navigate between two screens/activities. [online] Available at: <https://github.com/liehanels/UserInterface> [Accessed 21 May 2025].
            val intent = Intent(this, FlashcardScreenActivity::class.java)
            startActivity(intent)
            finish()
        }
    } // end of onCreate
} //end of MainActivity