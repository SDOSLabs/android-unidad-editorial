package es.sdos.android.project.api

import es.sdos.android.project.api.dto.NewsDetailResponseDTO
import es.sdos.android.project.api.dto.NewsListResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {

    @GET("articles.json")
    suspend fun fetchNewsAsync() : NewsListResponseDTO

    @GET("detail/{id}.json")
    suspend fun fetchNewsDetailAsync(@Path("id") id: Long) : NewsDetailResponseDTO
}