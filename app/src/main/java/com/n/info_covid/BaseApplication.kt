package com.n.info_covid

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.os.Build

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initRepo()
        easyPref()
        notificationsChanel()

    }

    private fun initRepo() {
        val apiServiceNegara = RetrofitBuilder.apiService(Constant.URL_NEGARA)
        val apiServiceDaerah = RetrofitBuilder.apiService(Constant.URL_DAERAH)
        val apiServiceBwx = RetrofitBuilder.apiService(Constant.URL_BANYUWANGI)

        val appDatabase = AppDatabase.getInstance(this)

        RepositoryNegara.instance.apply {
            init(
                NegaraRoomDataStore(appDatabase.negaraDao()),
                NegaraRemoteDataStore(apiServiceNegara)
            )
        }

        RepositoryDaerah.instance.apply {
            init(
                DaerahRoomDataStore(appDatabase.daerahDao()),
                DaerahRemoteDataStore(apiServiceDaerah)
            )
        }

        RepositoryBanyuwangi.instance.apply {
            init(
                BanyuwangiRoomDataStore(appDatabase.banyuwangiDao()),
                BanyuwangiRemoteDataSotre(apiServiceBwx)
            )
        }
    }

    private fun easyPref() {
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }

    private fun notificationsChanel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.chanel_name)
            val desc = getString(R.string.chanel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChancel = NotificationChannel(Constant.CHANEL_ID, name, importance)
            mChancel.description = desc
            // Register the channel with the system;
            // you can't change the importance
            // or other notification behaviors after this
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChancel)
        }
    }

}