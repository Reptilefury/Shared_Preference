package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.renderscript.Sampler

class Prefs(context: Context) {
    private val APP_PREF_0 = "AppPrefZero"
    private val preferences: SharedPreferences =
        context.getSharedPreferences( APP_PREF_0,Context.MODE_PRIVATE)
    private val APP_PREF_1 = "AppPrefOne"
    private val APP_PREF_2 = "AppPrefTwo"
    private val preferences1:SharedPreferences= context.getSharedPreferences(APP_PREF_1,Context.MODE_PRIVATE)
    private  val preferences2:SharedPreferences = context.getSharedPreferences(APP_PREF_2,Context.MODE_PRIVATE)
    private val APP_PREF3 = "AppPrefThree"
    private val preferences3:SharedPreferences = context.getSharedPreferences(APP_PREF3,Context.MODE_PRIVATE)
    private val Mike_Tyson = " Iron Mike Tyson"
    private val  Legend:SharedPreferences = context.getSharedPreferences(Mike_Tyson, Context.MODE_PRIVATE)

     private  val APP_PREF_INT_EXAMPLE = "intExamplePref"
    var intExamplePref:Int
    get() = preferences.getInt(APP_PREF_INT_EXAMPLE, -1)
    set(value) = preferences.edit().putInt(APP_PREF_INT_EXAMPLE,value).apply()



}
