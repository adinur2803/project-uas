package com.n.info_covid.repository.datastore.Banyuwangi

class BanyuwangiRoomDatastore (val banyuwangiDao: BanyuwangiDao) : BanyuwangiDataStore {
    override suspend fun getData(): Data? {
        val response = banyuwangiDao.getDaerah()
        return if (response != null) response else null
    }

    override suspend fun addAll(data: Data?) {
        data?.let {
            banyuwangiDao.insertDaerah(it)
        }
    }

}