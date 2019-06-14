package es.sdos.android.project.news.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import es.sdos.android.project.news.ui.fragment.NewsDetailFragment
import es.sdos.android.project.news.ui.fragment.NewsListFragment

@Module
abstract class NewsFragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindNewsListFragment(): NewsListFragment

    @ContributesAndroidInjector
    internal abstract fun bindNewsDetailFragment(): NewsDetailFragment

}
