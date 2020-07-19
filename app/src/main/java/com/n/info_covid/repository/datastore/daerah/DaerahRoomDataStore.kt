package com.n.info_covid.repository.datastore.daerah

import...

class DaerahRoomDataStore(val daerahDao: DaerahDao) : DaerahlDataStore {
    override suspend fun getDaerah(): MutableList<ResponseDaerah>? {
        val listDaerah = daerahDao.getDaerah()
        val response = mutableListOf<ResponseDaerah>()
        for (res in listDaerah) {
            response.add(ResponseDaerah(res))
        }
        return if (!response.isEmpty()) response else null
    }
    override suspend fun addAll(data: MutableList<ResponseDaerah>?) {
        data?.let {
            for (data in it) {
                daerahDao.insertDaerah(data.attributes!!)
            }
        }
    }


}