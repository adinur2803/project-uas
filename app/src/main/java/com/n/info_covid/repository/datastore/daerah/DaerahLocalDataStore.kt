package com.n.info_covid.repository.datastore.daerah

class DaerahLocalDataStore :
    DaerahlDataStore {
    private var caches = mutableListOf<ResponseDaerah>()

    class ResponseDaerah {

    }

    override suspend fun getDaerah(): MutableList<ResponseDaerah>? =
        if (caches.isNotEmpty()) caches else null

    override suspend fun addAll(data: MutableList<ResponseDaerah>?) {
        data?.let {
            caches = data
        }
    }
}