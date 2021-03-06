package com.pany.withrooms.database.repos

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.pany.withrooms.viewmodel.ReposViewModel
import java.lang.IllegalArgumentException

class ViewModelRepoFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReposViewModel::class.java)){
            val db = Room.databaseBuilder(activity.applicationContext, AppRepoDataBase::class.java, "repo_table").build()
            @Suppress("unused")
            return ReposViewModel(db.reposDao()) as T
        }
        throw IllegalArgumentException("Unchecked ViewModel class")
    }
}