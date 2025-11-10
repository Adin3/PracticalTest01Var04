package ro.pub.cs.systems.eim.practicaltest01var04

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

object Constants {
    const val INPUT1 = "input1"
    const val INPUT2 = "input2"
}
class PracticalTest01Var04MainActivity : AppCompatActivity() {


    private lateinit var input1: EditText
    private lateinit var input2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var04_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        input1.setText("Perfect Student")
        input2.setText("341C1")

        val info = findViewById<TextView>(R.id.info)
        val display = findViewById<Button>(R.id.display)
        display.setOnClickListener {
            var inp = "" + input1.text.toString()
            if (input1.text.toString() == "" && input1.text.toString() == "") {
                Toast.makeText(applicationContext,"Nu merge"
                    , Toast.LENGTH_LONG).show()
            } else {
                info.setText(inp)
            }
        }

        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show()
            }
            else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result CANCELED", Toast.LENGTH_LONG).show()
            }
        }

        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.navigate_to_second_activity)
        navigateToSecondaryActivityButton.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var04SecondaryActivity::class.java)
            intent.putExtra(Constants.INPUT1, input1.text.toString())
            intent.putExtra(Constants.INPUT2, input2.text.toString())
            activityResultsLauncher.launch(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(Constants.INPUT1, input1.text.toString())
        outState.putString(Constants.INPUT2, input2.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey(Constants.INPUT1) && savedInstanceState.containsKey(Constants.INPUT2)) {
            input1.setText(savedInstanceState.getString(Constants.INPUT1))
            input2.setText(savedInstanceState.getString(Constants.INPUT2))
        }
    }
}