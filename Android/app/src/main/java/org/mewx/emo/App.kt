package org.mewx.emo;

import android.app.Application
import android.content.Context

/**
 * Hope the context not necessary to be fetched here :P
 * Created by MewX on 1/15/2017.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        var context: Context? = null
            private set
    }
}
