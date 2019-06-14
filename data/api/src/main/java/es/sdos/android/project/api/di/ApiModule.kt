package es.sdos.android.project.api.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import es.sdos.android.project.api.NewsDatasource
import es.sdos.android.project.api.NewsService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        private const val BASE_URL = "https://e00-apps-ue.uecdn.es/pruebas/test/"
    }

    @Provides
    fun interceptorProvider(): Interceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)

    @Provides
    fun okHttpClientProvider(interceptor: Interceptor) =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    fun gsonProvider() =
        GsonBuilder()
        .setDateFormat("dd/MM/yyyy HH:mm")
        .create()

    @Provides
    @Singleton
    fun retrofitProvider(okHttpClient: OkHttpClient, gson: Gson) =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun newsServiceProvider(retrofit: Retrofit) =
        retrofit.create(NewsService::class.java)

    @Provides
    fun newsDatasourceProvider(newsService: NewsService) =
            NewsDatasource(newsService)

}
