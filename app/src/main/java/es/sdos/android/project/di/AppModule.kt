package es.sdos.android.project.di

import android.content.Context
import dagger.Module
import dagger.Provides
import es.sdos.android.project.App
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(app: App): Context = app

}
