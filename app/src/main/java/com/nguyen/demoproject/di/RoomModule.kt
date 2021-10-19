package com.nguyen.demoproject.di

import android.content.Context
import androidx.room.Room
import com.nguyen.demoproject.db.DemoDatabase
import com.nguyen.demoproject.db.DemoDatabase.Companion.DATABASE_NAME
import com.nguyen.demoproject.db.dao.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): DemoDatabase {
        return Room
            .databaseBuilder(
                context,
                DemoDatabase::class.java,
                DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()

    }

    @Singleton
    @Provides
    fun provideItemDao(db: DemoDatabase): ItemDao{
        return db.itemDao()
    }

}