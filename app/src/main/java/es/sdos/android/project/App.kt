package es.sdos.android.project

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import es.sdos.android.project.di.DaggerAppComponent
import javax.inject.Inject

open class App: Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        this.injectMembers()
        super.onCreate()
    }

    private fun injectMembers() {
        DaggerAppComponent
            .builder()
            .application(this)
            .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}