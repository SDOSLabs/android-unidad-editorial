package es.sdos.android.project.launcher.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import es.sdos.android.project.launcher.ui.fragment.LauncherFragment

@Module
abstract class LauncherFragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindLauncherFragment(): LauncherFragment
}
