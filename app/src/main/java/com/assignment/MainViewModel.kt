package com.assignment

import androidx.lifecycle.ViewModel
import com.assignment.model.MainModel

class MainViewModel:ViewModel() {


    fun getMainMockData():List<MainModel>{
        return mutableListOf<MainModel>().apply {

            add(MainModel.Header(title = "Section One"))
            add(MainModel.Content(R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground, R.drawable.img_profile_doc))

            add(MainModel.Header(title = "Section Two"))
            add(MainModel.Content(R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground, R.drawable.patient))

            add(MainModel.Header(title = "Section Three"))
            add(MainModel.Content(R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background))

            add(MainModel.Header(title = "Section Four"))
            add(MainModel.Content(R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground, com.google.android.material.R.drawable.ic_clock_black_24dp))

            add(MainModel.Header(title = "Section Five"))
            add(MainModel.Content(R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground, com.google.android.material.R.drawable.ic_clock_black_24dp))
        }


    }
}