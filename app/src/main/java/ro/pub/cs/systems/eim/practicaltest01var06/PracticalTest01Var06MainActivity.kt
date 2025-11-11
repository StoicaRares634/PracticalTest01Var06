package ro.pub.cs.systems.eim.practicaltest01var06

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06MainActivity : AppCompatActivity() {

    var rndm = 0

    private val secondaryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            Toast.makeText(this, result.resultCode, Toast.LENGTH_SHORT).show()

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val play = findViewById<Button>(R.id.button_play)
        val checkBoxAndroid = findViewById<CheckBox>(R.id.checkbox_android)
        val checkBoxKotlin = findViewById<CheckBox>(R.id.checkbox_kotlin)
        val checkBoxYunara = findViewById<CheckBox>(R.id.checkbox_yunara)

        val listener = View.OnClickListener {

            if (!checkBoxAndroid.isChecked) {
                rndm = (1..3).random()
                checkBoxAndroid.text = rndm.toString()
            }
            if (!checkBoxKotlin.isChecked) {
                rndm = (1..3).random()
                checkBoxKotlin.text = rndm.toString()
            }
            if (!checkBoxYunara.isChecked) {
                rndm = (1..3).random()
                checkBoxYunara.text = rndm.toString()
            }

        }

        play.setOnClickListener(listener)

        findViewById<Button>(R.id.navigate_to_second_activity).setOnClickListener {
            var count = 0
            if (checkBoxAndroid.isChecked) {
                count++

            }
            if (checkBoxKotlin.isChecked) {
                count++

            }
            if (checkBoxYunara.isChecked) {
                count++

            }
            val intent = Intent(this, PracticalTest01Var06SecondaryActivity::class.java)
            intent.putExtra(PracticalTest01Var06SecondaryActivity.total_bife, count)
            intent.putExtra(PracticalTest01Var06SecondaryActivity.nr1, checkBoxAndroid.text)
            intent.putExtra(PracticalTest01Var06SecondaryActivity.nr2, checkBoxKotlin.text)
            intent.putExtra(PracticalTest01Var06SecondaryActivity.nr3, checkBoxYunara.text)
            secondaryLauncher.launch(intent)
        }



    }
}