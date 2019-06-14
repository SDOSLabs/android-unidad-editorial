package es.sdos.android.project.common.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import es.sdos.android.project.common.ui.fragment.BaseFragment

@Module
abstract class CommonFragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindBaseFragment(): BaseFragment

}
