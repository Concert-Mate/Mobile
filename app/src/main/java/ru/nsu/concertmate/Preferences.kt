package ru.nsu.concertmate

import android.content.Context
import android.content.SharedPreferences

object Preferences {

    private const val PREF_NAME = "MySharedPref"
    private const val ACCESS_FIREBASE_TOKEN_KEY = "ACCESSTOKEN"

    private const val TOKEN_KEY = "TOKEN"

    private const val REFRESH_TOKEN_KEY = "REFRESH_TOKEN"

    fun setFireBaseAccessToken(context: Context, token: String?) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(ACCESS_FIREBASE_TOKEN_KEY, token)
        editor.apply()
    }

    fun getFireBaseAccessToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(ACCESS_FIREBASE_TOKEN_KEY, null)
    }

    fun setToken(context: Context, token: String?) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN_KEY, token)
        editor.apply()
    }

    fun getToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(TOKEN_KEY, null)
    }

    fun setRefreshToken(context: Context, token: String?) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(REFRESH_TOKEN_KEY, token)
        editor.apply()
    }

    fun getRefreshToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(REFRESH_TOKEN_KEY, null)
    }
}
