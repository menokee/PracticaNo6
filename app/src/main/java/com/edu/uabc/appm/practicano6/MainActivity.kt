package com.edu.uabc.appm.practicano6

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
//import com.edu.uabc.appm.practicano6.modelo.User
import com.edu.uabc.appm.practicano6.modelo.User2
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.async
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var urlConnection:HttpURLConnection
    lateinit var reader:BufferedReader
    lateinit var result:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carrera = listOf("Ingeniero de Computacón", "Lic. en Informática", "Lic. Comunicación", "Otras")
        selector("Que carrera estudiaste?", carrera) { sel  ->
            var titulo = findViewById<TextView>(R.id.textView2)
            titulo.text = carrera[sel]
            if (sel == 0) {toast(" Es la mejor carrera que pudisye estudiar")}
            else {toast("Algo es algo!...")}
        }

        fab.setOnClickListener { view ->
            //Crear alertas
            alert("Deseas consumir un webservice?", "Accesando a un WebService en RV") {
                yesButton { toast("Invocando recycler view...")
                    startActivity<RecyclerActivity>()
                    /*val dialog = progressDialog(message = "En proceso", title = "Consumiendo Datos")
                            dialog.show()
                            doAsync {
                                val result = URL("https://jsonplaceholder.typicode.com/todos").readText()
                                uiThread {
                                    Log.d("Request", result)

                                    var gson: Gson = Gson()
                                    //var usuarios = gson.fromJson(result, Array<User2>::class.java)
                                    var usuarios = Gson().fromJson(result, Array<User2>::class.java).toMutableList()
                                   // startActivity<RecyclerActivity>("milista" to usuarios)



                                    dialog.cancel()
                            longToast("Terminado")
                        }
                    }*/
                }
                noButton {toast("Proceso Cancelado...")
                    //startActivity<RecyclerActivity>
                }
            }.show()
        }
    }
}
