package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val resultado_IMC = findViewById<TextView>(R.id.textviewIMC)
        val resultado_Clasificacao = findViewById<TextView>(R.id.textviewClassificacao)
        val result = intent.getFloatExtra("Extra_IMC", 0.1f)

        resultado_IMC.text = result.toString()


        val classificacao = if(result < 18.5){
            "ABAIXO DO PESO"
        }else if(result >= 18.5 && result < 24.9){
            "PESO IDEAL"
        }else if(result >= 25 && result < 29.9){
            "SOBREPESO"
        }else if(result >= 30 && result < 39.9){
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }

        resultado_Clasificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}