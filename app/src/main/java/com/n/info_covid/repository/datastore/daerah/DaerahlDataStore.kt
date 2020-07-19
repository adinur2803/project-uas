package com.n.info_covid.repository.datastore.daerah

interface DaerahlDataStore {
    suspend fun getDaerah(): MutableList<ResponseDaerah>?
    suspend fun addAll(data: MutableList<ResponseDaerah>?)

    interface ResponseDaerah {

    }
}