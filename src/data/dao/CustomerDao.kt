package com.example.businessmanagementapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.businessmanagementapp.data.entities.Customer

@Dao
interface CustomerDao {

    @Query("SELECT * FROM customers ORDER BY name")
    fun getAllCustomers(): LiveData<List<Customer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer)

    @Update
    suspend fun updateCustomer(customer: Customer)

    @Delete
    suspend fun deleteCustomer(customer: Customer)
}
