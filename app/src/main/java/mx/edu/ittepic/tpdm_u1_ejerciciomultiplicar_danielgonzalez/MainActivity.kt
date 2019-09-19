package mx.edu.ittepic.tpdm_u1_ejerciciomultiplicar_danielgonzalez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    var a : EditText ?=null
    var b : EditText ?=null
    var resultadoLayou : LinearLayout ?=null
    var boton : Button ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a = findViewById(R.id.numeroa)
        b = findViewById(R.id.numerob)
        resultadoLayou = findViewById(R.id.resultadoLinear)
        boton = findViewById(R.id.botonCalcular)

        boton?.setOnClickListener {
            if(a?.text.toString().isEmpty()==true||b?.text.toString().isEmpty()==true){
                val alerta = AlertDialog.Builder(this)
                alerta.setTitle("ATENCION").setMessage("Llena Ambos Campos De Texto")
                    .setPositiveButton("ACEPTAR"){dialogInterface, i ->  }
                    .show()
                return@setOnClickListener
            }else {
                resultadoLayou?.removeAllViews()
                var numero = a?.text.toString().toInt()
                var numero2 = 0
                numero2 = b?.text.toString().toInt()
                (1..numero2).forEach {
                    var resultado = numero * it
                    var texto = TextView(this)
                    texto.setText("" + numero + " x " + "$it" + " = " + resultado)
                    resultadoLayou?.addView(texto)
                }
            }
        }
    }
}
