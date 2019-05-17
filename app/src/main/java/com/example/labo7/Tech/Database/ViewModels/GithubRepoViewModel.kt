package com.example.labo7.Tech.Database.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7.Tech.Database.GithubRepo
import com.example.labo7.Tech.Database.Repository.GithubRepoRepository
import com.example.labo7.Tech.Database.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel (app: Application): AndroidViewModel(app){
    private val repository: GithubRepoRepository

    init{
        val repoDao = RoomDB.getInstance(app).repoDao()
        repository = GithubRepoRepository(repoDao)
    }
    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()
}
