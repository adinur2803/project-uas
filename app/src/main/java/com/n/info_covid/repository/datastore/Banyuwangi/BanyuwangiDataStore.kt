package com.n.info_covid.repository.datastore.Banyuwangi

import com.n.info_covid.model.Data

interface BanyuwangiDataStore {

    suspend fun getData(): Data?
    suspend fun addAll(data: Data?)