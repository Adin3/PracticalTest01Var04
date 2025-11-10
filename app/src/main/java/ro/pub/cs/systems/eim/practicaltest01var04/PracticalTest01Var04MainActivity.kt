package ro.pub.cs.systems.eim.practicaltest01var04

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

    }
}