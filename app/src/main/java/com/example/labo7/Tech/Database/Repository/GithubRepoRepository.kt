package com.example.labo7.Tech.Database.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7.Tech.Database.GithubRepo
import com.example.labo7.Tech.Database.githubDAO

class GithubRepoRepository(private val repoDao: githubDAO){

    @WorkerThread /*hAY QUE ESPECIFICARLE EL THREAD AL SUSPEND*/
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }
    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}