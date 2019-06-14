package es.sdos.android.project.news.domain

import androidx.lifecycle.LiveData
import es.sdos.android.project.model.News
import es.sdos.android.project.repository.NewsRepository
import es.sdos.android.project.repository.util.Resource
import javax.inject.Inject

class GetNewsListUseCase @Inject constructor(private val repository: NewsRepository) {

    suspend operator fun invoke(forceRefresh: Boolean = false): LiveData<Resource<List<News>>> {
        return repository.getNewsWithCache(forceRefresh)
    }

}
