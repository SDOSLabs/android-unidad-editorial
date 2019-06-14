package es.sdos.android.project.repository

import androidx.lifecycle.LiveData
import es.sdos.android.project.api.NewsDatasource
import es.sdos.android.project.api.dto.NewsDetailResponseDTO
import es.sdos.android.project.api.dto.NewsListResponseDTO
import es.sdos.android.project.database.dao.NewsDao
import es.sdos.android.project.model.News
import es.sdos.android.project.repository.mapper.NewsMapper.newsDboToModel
import es.sdos.android.project.repository.mapper.NewsMapper.newsDtoToModel
import es.sdos.android.project.repository.mapper.NewsMapper.newsModelToDbo
import es.sdos.android.project.repository.util.NetworkBoundResource
import es.sdos.android.project.repository.util.Resource
import kotlinx.coroutines.Deferred

interface NewsRepository {
    suspend fun getNewsWithCache(forceRefresh: Boolean = false): LiveData<Resource<List<News>>>
    suspend fun getNewsDetailWithCache(forceRefresh: Boolean = false, id: Long): LiveData<Resource<News>>
}

class NewsRepositoryImpl(
    private val datasource: NewsDatasource,
    private val dao: NewsDao
) : NewsRepository {

    /**
     * Suspended function that will get a list of [News]
     * whether in cache (SQLite) or via network (API).
     * [NetworkBoundResource] is responsible to handle this behavior.
     */
    override suspend fun getNewsWithCache(forceRefresh: Boolean): LiveData<Resource<List<News>>> {
        return object : NetworkBoundResource<List<News>, NewsListResponseDTO>() {

            override fun processResponse(response: NewsListResponseDTO): List<News>
                    = response.items.map(::newsDtoToModel)

            override suspend fun saveCallResults(result: List<News>)
                    = dao.save(result.map(::newsModelToDbo))

            override fun shouldFetch(data: List<News>?): Boolean
                    = data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<News>
                    = dao.getNewsList().map(::newsDboToModel)

            override suspend fun requestCallAsync(): NewsListResponseDTO
                    = datasource.fetchNewsAsync()

        }.build().asLiveData()
    }

    /**
     * Suspended function that will get details of a [News]
     * whether in cache (SQLite) or via network (API).
     * [NetworkBoundResource] is responsible to handle this behavior.
     */
    override suspend fun getNewsDetailWithCache(forceRefresh: Boolean, id: Long): LiveData<Resource<News>> {
        return object : NetworkBoundResource<News, NewsDetailResponseDTO>() {

            override fun processResponse(response: NewsDetailResponseDTO): News
                    = newsDtoToModel(response.item)

            override suspend fun saveCallResults(result: News)
                    = dao.save(newsModelToDbo(result))

            override fun shouldFetch(data: News?): Boolean
                    = data == null
                    || data.haveToRefreshFromNetwork()
                    || data.body.isNullOrEmpty()
                    || forceRefresh

            override suspend fun loadFromDb(): News
                    = newsDboToModel(dao.getNews(id))

            override suspend fun requestCallAsync(): NewsDetailResponseDTO
                    = datasource.fetchNewsDetailAsync(id)

        }.build().asLiveData()
    }

}