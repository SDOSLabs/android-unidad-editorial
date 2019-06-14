package es.sdos.android.project.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import es.sdos.android.project.App
import es.sdos.android.project.NavHostActivity
import javax.inject.Singleton

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindNavHostActivity(): NavHostActivity

}
