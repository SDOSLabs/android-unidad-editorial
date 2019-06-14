package es.sdos.android.project.api.dto

import java.util.*

data class NewsDTO(
    val id: Long,
    val title: String,
    val subtitle: String,
    val body: String?,
    val date: Date
)