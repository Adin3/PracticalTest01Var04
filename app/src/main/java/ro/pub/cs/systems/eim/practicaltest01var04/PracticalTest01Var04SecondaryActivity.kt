package ro.pub.cs.systems.eim.practicaltest01var04

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var04SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var04_secondary)


        val input1 = intent.getStringExtra(Constants.INPUT1)
        val input2 = intent.getStringExtra(Constants.INPUT2)

        var dinput1: TextView = findViewById(R.id.input1)
        var dinput2: TextView = findViewById(R.id.input2)
        dinput1.setText(input1)
        dinput2.setText(input2)

        val okButton = findViewById<Button>(R.id.ok_button)
        okButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        val cancelButton = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}