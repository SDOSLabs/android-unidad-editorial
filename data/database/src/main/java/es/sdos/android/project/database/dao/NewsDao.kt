package es.sdos.android.project.database.dao

import androidx.room.Dao
import androidx.room.Query
import es.sdos.android.project.database.dbo.NewsDBO
import java.util.*

@Dao
abstract class NewsDao : BaseDao<NewsDBO>() {

    @Query("SELECT * FROM News ORDER BY date DESC")
    abstract suspend fun getNewsList(): List<NewsDBO>

    @Query("SELECT * FROM News WHERE id = :id LIMIT 1")
    abstract suspend fun getNews(id: Long): NewsDBO

    /**
     * Each time we save a news, we update its 'lastRefreshed' field
     * This allows us to know when we have to refresh its data
     */
    suspend fun save(news: NewsDBO) {
        insert(news.apply { lastRefreshed = Date() })
    }

    /**
     * When we save a list of news don't update its 'lastRefreshed'field
     * Only update when is fetched from detail WS
     */
    suspend fun save(news: List<NewsDBO>) {
        insert(news)
    }
}