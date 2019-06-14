package es.sdos.android.project.news.ui.viewmodel

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.sdos.android.project.common.ui.viewmodel.BaseViewModel
import es.sdos.android.project.common.util.Event
import es.sdos.android.project.model.News
import es.sdos.android.project.news.R
import es.sdos.android.project.news.domain.GetNewsListUseCase
import es.sdos.android.project.news.ui.fragment.NewsListFragmentDirections
import es.sdos.android.project.repository.AppDispatchers
import es.sdos.android.project.repository.util.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsListViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    companion object {
        val nightModeConfiguration = MutableLiveData<Int>()
    }

    //region private fields
    private val newsListMediator = MediatorLiveData<Resource<List<News>>>()
    private var newsListSource: LiveData<Resource<List<News>>> = MutableLiveData()
    //endregion

    //region public
    fun getNewsList() = newsListMediator as LiveData<Resource<List<News>>>

    fun refreshNews() {
        getNewsList(true)
    }

    fun onNewsClick(news: News) {
        navigate(NewsListFragmentDirections.goToNewsDetailFragment(news.id))
    }

    fun onNightModeSwitch() {
        if (AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES) {
            nightModeConfiguration.postValue(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            nightModeConfiguration.postValue(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
    //endregion

    //region Private methods
    init {
        getNewsList(false)
    }

    private fun getNewsList(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main) {
        newsListMediator.removeSource(newsListSource) // We make sure there is only one source of livedata (allowing us properly refresh)
        withContext(dispatchers.io) {
            newsListSource = getNewsListUseCase(forceRefresh = forceRefresh)
        }
        newsListMediator.addSource(newsListSource) {
            newsListMediator.value = it
            if (it.status == Resource.Status.ERROR) {
                snackbarError.value = Event(R.string.an_error_happened)
            }
        }
    }
    //endregion

}