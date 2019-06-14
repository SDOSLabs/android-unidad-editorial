package es.sdos.android.project.news.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.sdos.android.project.common.ui.viewmodel.BaseViewModel
import es.sdos.android.project.common.util.Event
import es.sdos.android.project.model.News
import es.sdos.android.project.news.R
import es.sdos.android.project.news.domain.GetNewsDetailUseCase
import es.sdos.android.project.repository.AppDispatchers
import es.sdos.android.project.repository.util.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsDetailViewModel @Inject constructor(
    private val getNewsDetailUseCase: GetNewsDetailUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    //region private fields
    private var id: Long = 0
    private val newsDetailMediator = MediatorLiveData<Resource<News>>()
    private var newsDetailSource: LiveData<Resource<News>> = MutableLiveData()
    private var newsDetail = MutableLiveData<News>()
    //endregion

    //region public
    fun getNewsDetailResource() = newsDetailMediator as LiveData<Resource<News>>

    fun getNewsDetail() = newsDetail as LiveData<News>

    fun loadDataWhenActivityStarts(id: Long) {
        this.id = id
        getNewsDetail(false)
    }
    //endregion

    //region Private methods

    private fun getNewsDetail(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main) {
        newsDetailMediator.removeSource(newsDetailSource) // We make sure there is only one source of livedata (allowing us properly refresh)
        withContext(dispatchers.io) {
            newsDetailSource = getNewsDetailUseCase(id, false)
        }
        newsDetailMediator.addSource(newsDetailSource) {
            newsDetailMediator.value = it
            if (it.data != null) {
                newsDetail.value = it.data
            }
            if (it.status == Resource.Status.ERROR) {
                snackbarError.value = Event(R.string.an_error_happened)
            }
        }
    }
    //endregion

}