package es.sdos.android.project.database.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "News")
data class NewsDBO(
    @PrimaryKey
    val id: Long,
    val title: String,
    val subtitle: String,
    val body: String?,
    val date: Date,

    var lastRefreshed: Date = Date(1)
)