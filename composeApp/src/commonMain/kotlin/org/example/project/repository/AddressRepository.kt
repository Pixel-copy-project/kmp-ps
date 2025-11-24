package org.example.project.repository

import org.example.project.utill.Address

interface AddressRepository {
    suspend fun getAddressList(): List<Address>
}