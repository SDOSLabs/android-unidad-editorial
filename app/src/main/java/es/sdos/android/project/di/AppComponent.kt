package es.sdos.android.project.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import es.sdos.android.project.App
import es.sdos.android.project.common.di.CommonFragmentBuilder
import es.sdos.android.project.launcher.di.LauncherFragmentBuilder
import es.sdos.android.project.news.di.NewsFragmentBuilder
import es.sdos.android.project.repository.di.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class,
    RepositoryModule::class,
    CommonFragmentBuilder::class,
    LauncherFragmentBuilder::class,
    NewsFragmentBuilder::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
