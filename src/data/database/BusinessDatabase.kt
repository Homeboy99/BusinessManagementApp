package com.example.businessmanagementapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.businessmanagementapp.data.entities.Customer
import com.example.businessmanagementapp.data.dao.CustomerDao

@Database(entities = [Customer::class], version = 1, exportSchema = false)
abstract class BusinessDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao

    companion object {
        @Volatile private var INSTANCE: BusinessDatabase? = null

        fun getDatabase(context: Context): BusinessDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BusinessDatabase::class.java,
                    "business_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
