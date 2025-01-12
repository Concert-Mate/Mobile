package ru.nsu.concertmate

import android.content.Context
import android.content.SharedPreferences

object Preferences {

    private const val PREF_NAME = "MySharedPref"
    private const val ACCESS_TOKEN_KEY = "ACCESSTOKEN"

    // Сохранить токен
    fun setAccessToken(context: Context, token: String?) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(ACCESS_TOKEN_KEY, token)
        editor.apply()
    }

    // Извлечь токен
    fun getAccessToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(ACCESS_TOKEN_KEY, null)
    }
}
