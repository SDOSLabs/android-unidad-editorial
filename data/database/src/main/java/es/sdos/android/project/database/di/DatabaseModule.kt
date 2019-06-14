package es.sdos.android.project.database.di

import android.content.Context
import dagger.Module
import dagger.Provides
import es.sdos.android.project.database.AppRoomDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun appRoomDatabaseProvider(context: Context) =
        AppRoomDatabase.buildDatabase(context)

    @Provides
    fun newsDaoProvider(database: AppRoomDatabase) =
        database.newsDao()

}
