package com.utez.edu.examenunidad1coscarbarrios

import com.utez.edu.examenunidad1coscarbarrios.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val formatDecimalFormat = DecimalFormat("#.00")

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //spinner uno

        val opcion: Spinner = findViewById(R.id.opcion)
        ArrayAdapter.createFromResource(
            this,
            R.array.opcion,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            opcion.adapter = adapter
        }

        //spinner dos
        val equipos: Spinner = findViewById(R.id.equipos)
        ArrayAdapter.createFromResource(
            this,
            R.array.equipos,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            equipos.adapter = adapter
        }
        val boton=binding.enviar
        boton.setOnClickListener {
            val opcion = opcion.selectedItem.toString()
            val equiposO = equipos.selectedItem.toString()
            val dato1 = binding.dato1.text.toString()
            val dato2 = binding.dato2.text.toString()
            val resultado = binding.resultado
            if (dato1.isNotEmpty() || dato2.isNotEmpty())
                //primer spinner
                when(opcion){
                    in "Saludo"->{
                        var resultadoS="Hola $dato1 $dato2"
                        resultado.text = "$resultadoS"
                    }
                    in "Partido"->{
                        when(equiposO){
                            in "Chivas"->{
                               try {
                                   if (dato1>dato2){
                                       resultado.text = "Chivas Gano!!!"
                                   }else{
                                       resultado.text = "Equipo contrario gano!!!"
                                   }
                               } catch (e: java.lang.Exception){
                                   resultado.text = "Baboso asi no se usa!!!"
                               }
                            }
                            in "America"->{
                                try {
                                    if (dato1>dato2){
                                        resultado.text = "America Gano!!!"
                                    }else{
                                        resultado.text = "Equipo contrario gano!!!"
                                    }
                                } catch (e: java.lang.Exception){
                                    resultado.text = "Baboso asi no se usa!!!"
                                }
                            }
                            in "Cruz azul"->{
                                try {
                                    if (dato1>dato2){
                                        resultado.text = "Cruz azul Gano!!!"
                                    }else{
                                        resultado.text = "Equipo contrario gano!!!"
                                    }
                                } catch (e: java.lang.Exception){
                                    resultado.text = "Baboso asi no se usa!!!"
                                }
                            }
                            in "Pumas"->{
                                try {
                                    if (dato1>dato2){
                                        resultado.text = "Pumas Gano!!!"
                                    }else{
                                        resultado.text = "Equipo contrario gano!!!"
                                    }
                                } catch (e: java.lang.Exception){
                                    resultado.text = "Baboso asi no se usa!!!"
                                }
                            }
                        }
                    }
            }else{
                Toast.makeText(getApplicationContext(), "Campos vacios!!!", Toast.LENGTH_LONG).show();
            }

        }


    }
}