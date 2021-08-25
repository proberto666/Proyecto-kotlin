package com.example.kotlin_tarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity() : AppCompatActivity() {
    lateinit var ListaPlantas: MutableList<Planta>
    var ContadorAgua : Int = 0
    var numeroDePlanta : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ListaPlantas= mutableListOf<Planta>()
        var txtInfo = findViewById<TextView>(R.id.txtInfo)
        txtInfo.text = "Crea una nueva planta!"
    }

    fun onFertilizar(view: View){
        if(ListaPlantas.lastIndex!=-1) {
            var plantaOnScreen: Any = ListaPlantas.get(numeroDePlanta)
            if (plantaOnScreen is Lavanda) {
                Toast.makeText(this, plantaOnScreen.Fertilizar(), Toast.LENGTH_SHORT).show()
            } else if (plantaOnScreen is PeaceLily) {
                Toast.makeText(this, plantaOnScreen.Fertilizar(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onPodar(view: View){
        if(ListaPlantas.lastIndex!=-1) {
            var plantaOnScreen: Any = ListaPlantas.get(numeroDePlanta)
            if (plantaOnScreen is Lavanda) {
                Toast.makeText(this, plantaOnScreen.Podar(), Toast.LENGTH_SHORT).show()
            } else if (plantaOnScreen is PeaceLily) {
                Toast.makeText(this, plantaOnScreen.Podar(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onRegar(view: View){
        if(ListaPlantas.lastIndex!= -1) {
            var plantaOnScreen: Any = ListaPlantas.get(numeroDePlanta)
            if (plantaOnScreen is Lavanda) {
                Toast.makeText(this, plantaOnScreen.Regar(), Toast.LENGTH_SHORT).show()
            } else if (plantaOnScreen is PeaceLily) {
                Toast.makeText(this, plantaOnScreen.Regar(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onSiguiente(view: View){
        if(ListaPlantas.lastIndex!= -1) {
            if (numeroDePlanta == ListaPlantas.lastIndex) {
                numeroDePlanta = 0
            } else {
                numeroDePlanta += 1
            }
            txtDisplay(numeroDePlanta)
        }
    }

    fun onAnterior(view: View){
        if(ListaPlantas.lastIndex!= -1){
            if(numeroDePlanta == 0 ){
                numeroDePlanta=ListaPlantas.lastIndex
            }else{
                numeroDePlanta-=1
            }
            txtDisplay(numeroDePlanta)
        }
    }

    fun onNuevo(view: View){
       var numRandom = Random.nextInt(0,10)
        if(numRandom%2 == 0){
            var plantaObjeto = PeaceLily(nombreAleatorio(), 0, 0, true,
                0, Random.nextInt(1,10))
            ListaPlantas.add(plantaObjeto)
        }else {
            var plantaObjeto = Lavanda(
                nombreAleatorio(), 0, 0, true, 0,
                Random.nextInt(10,15))
            ListaPlantas.add(plantaObjeto);
        }
        numeroDePlanta = ListaPlantas.lastIndex
        txtDisplay(numeroDePlanta)
    }

    fun txtDisplay(index: Int){
        var txtInfo = findViewById<TextView>(R.id.txtInfo)
        var plantaOnScreen : Any =ListaPlantas.get(index)
        if (plantaOnScreen is Lavanda){
            txtInfo.text = "Nombre: " + plantaOnScreen.nombre +
                    "\n Altura: " + plantaOnScreen.Altura +
                    "\n Viva?: "+plantaOnScreen.Viva
        }else if(plantaOnScreen is PeaceLily){
            txtInfo.text = "Nombre: " + plantaOnScreen.nombre +
                    "\n # de hojas: " + plantaOnScreen.NumHojas +
                    "\n Viva?: "+plantaOnScreen.Viva
        }
    }

    fun nombreAleatorio():String{
        var numRandom = Random.nextInt(0,19)
        var Nombres : List<String> = listOf("Luna", "Nala", "Kira", "Lola",
            "Bimba", "Mia", "Noa", "Kiara", "Dana", "Gala", "Coco", "Thor", "Max",
            "Rocky", "Toby", "Simba", "Leo", "Lucas", "Zeus", "Bruno")
        return Nombres.get(numRandom)
    }
}