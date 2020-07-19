package com.n.info_covid.repository.datastore.daerah


import...
class DaerahRemoteDataStore(private val apiService: ApiService) :

    DaerahlDataStore {
    override suspend fun getDaerah(): MutableList<ResponseDaerah>? {
        val response = apiService.getDaerah()
        if (response.isSuccessful) return response.body()

        throw IllegalArgumentException()
    }

    override suspend fun addAll(data: MutableList<ResponseDaerah>?) {
    }

}