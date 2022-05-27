package com.training.db_pry.core

import android.content.Context

class SharePreferenceManager {
    companion object{
        var NAME_PREFERENCE = "ExampleDB"

        fun getString(context:Context, key: String, defaultString:String =""):String? {
            var sharedPreferences = context.getSharedPreferences(NAME_PREFERENCE, Context.MODE_PRIVATE)
            var emailTxt = sharedPreferences.getString(key,defaultString)
            return emailTxt
        }

        fun putString(context:Context, key: String, value:String){
            var sharedPreferences = context.getSharedPreferences(NAME_PREFERENCE, Context.MODE_PRIVATE)
            var editor = sharedPreferences.edit()
            editor.putString(key,value)
            editor.commit()
        }
    }

}