package es.sdos.android.project.api

class NewsDatasource(private val newsService: NewsService) {

    suspend fun fetchNewsAsync() = newsService.fetchNewsAsync()

    suspend fun fetchNewsDetailAsync(id: Long) = newsService.fetchNewsDetailAsync(id)

}