package es.sdos.android.project.model

import java.util.*
import java.util.concurrent.TimeUnit

data class News(
    val id: Long,
    val title: String,
    val subtitle: String,
    val body: String?,
    val date: Date,

    var lastRefreshed: Date = Date(1)
) {
    /**
     * We consider that an [News] is outdated when the last time
     * we fetched it was more than 10 minutes
     */
    fun haveToRefreshFromNetwork(): Boolean =
        TimeUnit.MILLISECONDS.toMinutes(Date().time - lastRefreshed.time) >= 10
}