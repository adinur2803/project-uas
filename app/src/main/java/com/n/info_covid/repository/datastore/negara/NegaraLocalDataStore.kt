package com.n.info_covid.repository.datastore.negara

class NegaraLocalDataStore :
    NegaralDataStore {
    private var caches = ResponseCountries("indonesia")
    override suspend fun getNegara(negara: String): ResponseCountries? =
        if (caches.cases != null) caches else null

    override suspend fun addAll(data: ResponseCountries?) {
        data?.let {
            caches = data
        }
    }

}