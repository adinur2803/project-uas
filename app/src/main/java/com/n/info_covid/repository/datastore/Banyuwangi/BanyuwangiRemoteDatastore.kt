package com.n.info_covid.repository.datastore.Banyuwangi

import...

class BanyuwangiRemoteDatastore (private val apiService: ApiService) : BanyuwangiDataStore {
    override suspend fun getData(): Data? {
        val caches = apiService.getBanyuwangi()
        if (caches.isSuccessful) return caches.body()?.data

        throw IllegalArgumentException()
    }

    override suspend fun addAll(data: Data?) {}


}
