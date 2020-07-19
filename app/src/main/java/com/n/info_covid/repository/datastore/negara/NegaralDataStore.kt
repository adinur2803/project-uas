package com.n.info_covid.repository.datastore.negara

interface NegaralDataStore {
    suspend fun getNegara(negara: String): ResponseCountries?
    suspend fun addAll(data: ResponseCountries?)
}