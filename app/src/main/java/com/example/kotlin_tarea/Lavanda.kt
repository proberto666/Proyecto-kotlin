package com.example.kotlin_tarea

import kotlin.random.Random

class Lavanda constructor(var nombre:String, NivelAgua: Int, NivelFertilizante: Int,
              Viva: Boolean, Semillas:Int?,var Altura:Int ): Planta(NivelAgua, NivelFertilizante, Viva, Semillas) {

    fun Podar() : String{
        var numRandom = Random.nextInt(0,10)
        var Semillas = if (numRandom==0) null else numRandom
        if(Semillas==null) {return "No dejó semillas"}
        else {return "Tienes " + Semillas + "semillas"}
    }

    fun SetMuerta():String{
        Viva=false
        return "Tu planta "+nombre+" acaba de morir :("
    }

    fun Regar():String{
        NivelAgua=100
        return "Planta Hidratada con éxito"
    }

    fun Fertilizar(): String{
        NivelFertilizante = 100
        var numRandom = Random.nextInt(0,10)
        if(numRandom>5){
            Altura=numRandom-5
        }
        return Crecer(Altura)
    }

    fun Crecer(cm: Int?): String{
        if(cm != null){
            return "Tu planta creció "+ cm + " cm"
        }else{
            return "Planta fertilizada con éxito"
        }
    }
}