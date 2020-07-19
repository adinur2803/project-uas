package com.n.info_covid.repository.datastore.Banyuwangi

import com.n.info_covid.model.Data

class BanyuwangiLocalDataStore : BanyuwangiDataStore {
    private var caches = Data("1")
    override suspend fun getData(): Data? =
        if (caches.lastUpdated != null) caches else null


    override suspend fun addAll(data: Data?) {
        data?.let {
            caches = data
        }
    }
}