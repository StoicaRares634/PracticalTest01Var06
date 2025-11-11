package ro.pub.cs.systems.eim.practicaltest01var06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var06SecondaryActivity : AppCompatActivity(){

    companion object {
        const val total_bife = "total_bife"
        const val nr1 = "nr1"
        const val nr2 = "nr2"
        const val nr3 = "nr3"


    }
    var bife = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_secondary)

        val total = intent.getIntExtra(ro.pub.cs.systems.eim.practicaltest01var06.PracticalTest01Var06SecondaryActivity.Companion.total_bife, 0)
        val NR1 = intent.getStringExtra(ro.pub.cs.systems.eim.practicaltest01var06.PracticalTest01Var06SecondaryActivity.Companion.nr1)
        val NR2 = intent.getStringExtra(ro.pub.cs.systems.eim.practicaltest01var06.PracticalTest01Var06SecondaryActivity.Companion.nr2)
        val NR3 = intent.getStringExtra(ro.pub.cs.systems.eim.practicaltest01var06.PracticalTest01Var06SecondaryActivity.Companion.nr3)
        if (NR1 == NR2) {
            if (NR1 == NR3) {
                bife = 0
                if (total == 0) {
                    bife = 100
                } else if (total == 1) {
                    bife = 50
                } else if (total == 2) {
                    bife = 10
                }
                findViewById<TextView>(R.id.Gained).text = "Gained: $bife"

            }
        }

        findViewById<Button>(R.id.okButton).setOnClickListener {
            setResult(bife)
            finish()
        }

        findViewById<Button>(R.id.cancelButton).setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

    }



}