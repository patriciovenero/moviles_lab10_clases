package com.miempresa.usosugarormv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lista.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this);

        var usuariorepo = UsuarioRepositorio()
        var listaUsuarios = usuariorepo.listar()


        val adapter = AdaptadorUsuarios(listaUsuarios as ArrayList<Usuario>)
        lista.adapter = adapter

        btnAgregar.setOnClickListener(){
            var crearUsuario = Intent(this,RegistroUsuarios::class.java)
            startActivity(crearUsuario)
        }
    }

    override fun onRestart() {
        super.onRestart()
        var usuarioRepo = UsuarioRepositorio()
        var listarUsuarios = usuarioRepo.listar()

        val adapter = AdaptadorUsuarios(listarUsuarios as ArrayList<Usuario>)
        lista.adapter = adapter
    }
}