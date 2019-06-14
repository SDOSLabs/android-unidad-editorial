package es.sdos.android.project.repository.di

import dagger.Module
import dagger.Provides
import es.sdos.android.project.api.NewsDatasource
import es.sdos.android.project.api.di.ApiModule
import es.sdos.android.project.database.dao.NewsDao
import es.sdos.android.project.database.di.DatabaseModule
import es.sdos.android.project.repository.AppDispatchers
import es.sdos.android.project.repository.NewsRepository
import es.sdos.android.project.repository.NewsRepositoryImpl
import kotlinx.coroutines.Dispatchers

@Module(includes = [DatabaseModule::class, ApiModule::class])
class RepositoryModule {

    @Provides
    fun appDispatchersProvider() =
        AppDispatchers(Dispatchers.Main, Dispatchers.IO)

    @Provides
    fun newsRepositoryProvider(datasource: NewsDatasource, dao: NewsDao) =
        NewsRepositoryImpl(datasource, dao) as NewsRepository

}
