package com.n.info_covid.repository.datastore.negara

class NegaraRemoteDataStore(private val apiService: ApiService) :
    NegaralDataStore {
    class ApiService {

    }

    override suspend fun getNegara(negara: String): ResponseCountries? {
        val response = apiService.getNegara(negara)
        if (response.isSuccessful) return response.body()

        throw IllegalArgumentException()
    }

    override suspend fun addAll(data: ResponseCountries?) {
    }
    }

private fun NegaraRemoteDataStore.ApiService.getNegara(negara: String): Any {

}
