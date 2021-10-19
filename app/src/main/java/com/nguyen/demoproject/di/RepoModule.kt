package com.nguyen.demoproject.di

import com.nguyen.demoproject.api.service.HiringService
import com.nguyen.demoproject.db.DemoDatabase
import com.nguyen.demoproject.repo.HiringRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideItemRepository(api: HiringService, db: DemoDatabase): HiringRepository {
        return HiringRepository(api, db)
    }

}