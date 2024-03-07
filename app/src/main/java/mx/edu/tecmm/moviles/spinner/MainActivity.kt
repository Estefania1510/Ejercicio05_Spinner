package mx.edu.tecmm.moviles.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var txtTitulo: TextView
    lateinit var spLenguaje: Spinner
    lateinit var txtDescripcion: TextView
    val lenguaje = arrayOf("PHP", "JAVA", "KOTLIN", "JAVASCRIPT", "RUBY", "C", "SWIFT")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtTitulo = findViewById(R.id.txtTitulo)
        spLenguaje = findViewById(R.id.spLenguaje)
        txtDescripcion = findViewById(R.id.txtDescripcion)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item,lenguaje)
        spLenguaje.adapter=adaptador
        spLenguaje.onItemSelectedListener=this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.v("App Spinner", "Seleccionaste uno")
        val lenguaje = lenguaje[position]
        txtTitulo.text = lenguaje
        val descripcion = when(lenguaje){
            "PHP"-> "Es un lenguaje para el backend de las paginas"
            "JAVA"-> "Es un lenguaje utilizado ampliamente en el desarrollo de aplicaciones empresariales y Android."
            "KOTLIN"-> "Es un lenguaje moderno que se ejecuta en la máquina virtual de Java (JVM), utilizado especialmente para el desarrollo de aplicaciones Android."
            "JAVASCRIPT"-> "Es un lenguaje interpretado que se utiliza principalmente para agregar interactividad y dinamismo a las páginas web."
            "RUBY"->  "Es un lenguaje dinámico de alto nivel, conocido por su elegancia y facilidad de uso, especialmente en el desarrollo web con Ruby on Rails."
            "C"-> "Es un lenguaje de programación de bajo nivel ampliamente utilizado en el desarrollo de sistemas operativos y aplicaciones de alto rendimiento."
            "SWIFT"-> "Es un lenguaje de programación desarrollado por Apple, utilizado para crear aplicaciones iOS, macOS, watchOS y tvOS, conocido por su modernidad y seguridad."


            else -> "No se ha definido"
        }
        txtDescripcion.text = descripcion
        //Log.w("App Spinner", "$lenguaje")
        //Log.w("App Spinner", "${view!!.id}")

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}