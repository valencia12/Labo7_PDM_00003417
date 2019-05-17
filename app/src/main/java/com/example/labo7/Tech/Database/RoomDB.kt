package com.example.labo7.Tech.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB: RoomDatabase(){
    abstract fun repoDao(): githubDAO

    companion object {
        private var INSTANCE: RoomDB? = null

        fun getInstance(Appcontext: Context): RoomDB{ /* EL appcontext, envia el contexto no de la actividad, si no el contexto  de la app*/
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(Appcontext, RoomDB:: class.java, "RepoDB").build()
                INSTANCE = instance
                return instance
            }

        }

    }
}