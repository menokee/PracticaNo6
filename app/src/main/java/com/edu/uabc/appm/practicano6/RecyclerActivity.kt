package com.edu.uabc.appm.practicano6

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.edu.uabc.appm.practicano6.modelo.User2
import com.google.gson.Gson
import java.net.HttpURLConnection
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.progressDialog
import org.jetbrains.anko.uiThread
import java.net.URL

class RecyclerActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        //var recibelista: ArrayList<User2> = intent.getStringArrayListExtra("milista")
        //var recibelista: ArrayList<User2> = intent.getSerializableExtra("milista") as ArrayList<User2>

        val dialog = progressDialog(message = "En proceso", title = "Consumiendo Datos")
        dialog.show()
        doAsync {
            val result = URL("https://jsonplaceholder.typicode.com/todos").readText()
            uiThread {
                Log.d("Request", result)

                var gson: Gson = Gson()
                //var usuarios = gson.fromJson(result, Array<User2>::class.java)
                var usuarios = Gson().fromJson(result, Array<User2>::class.java).toMutableList()
                // startActivity<RecyclerActivity>("milista" to usuarios)
                setUpRecyclerView(usuarios)


                dialog.cancel()
                longToast("Terminado")
            }
        }


    }

    fun setUpRecyclerView(recibejson: MutableList<User2>) {
        lateinit var mRecyclerView : RecyclerView
        val mAdapter : RecyclerAdapter = RecyclerAdapter()

        mRecyclerView = findViewById(R.id.rvListaJson) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(recibejson, this)
        mRecyclerView.adapter = mAdapter
    }




}