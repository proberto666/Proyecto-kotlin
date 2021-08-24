package com.example.kotlin_tarea

import kotlin.random.Random

class PeaceLily constructor(var nombre:String, NivelAgua: Int, NivelFertilizante: Int,
Viva: Boolean, Semillas:Int? ,var NumHojas:Int ): Planta(NivelAgua, NivelFertilizante, Viva, Semillas){

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

    fun Fertilizar(){
        NivelFertilizante = 100
        var numRandom = Random.nextInt(0,30)
        if(numRandom>10){
            NumHojas=numRandom-10
            Crecer(NumHojas)
        }
    }

    fun Crecer(num: Int?): String{
        if(num != null){
            return "Tu planta tiene "+ num + " hojas y flores nuevas"
        }else{
            return "Planta fertilizada con éxito"
        }
    }
}