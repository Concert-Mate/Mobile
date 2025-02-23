package ru.nsu.concertmate

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import io.swagger.client.apis.UsersControllerApi


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
        var api: UsersControllerApi = UsersControllerApi()
    }

}