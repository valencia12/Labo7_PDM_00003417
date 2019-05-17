package com.example.labo7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.labo7.Tech.Database.GithubRepo
import com.example.labo7.Tech.Database.ViewModels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        bt_add.setOnClickListener{
            val name = et_name.text.toString()
            if(name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }
        viewModel.getAll().observe(this, Observer { repos ->

            Log.d("LISTA DE REPOS", "_____________________________________________")
            for (repo  in repos){
                Log.d("Lista de repos", repo.name)
            }
        })
    }
}
