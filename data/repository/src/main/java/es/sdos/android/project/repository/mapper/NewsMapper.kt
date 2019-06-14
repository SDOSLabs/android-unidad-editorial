package es.sdos.android.project.repository.mapper

import es.sdos.android.project.api.dto.NewsDTO
import es.sdos.android.project.database.dbo.NewsDBO
import es.sdos.android.project.model.News

object NewsMapper{

    fun newsDtoToModel(dto: NewsDTO) =
        News(dto.id, dto.title, dto.subtitle, dto.body, dto.date)

    fun newsModelToDbo(model: News) =
        NewsDBO(model.id, model.title, model.subtitle, model.body, model.date, model.lastRefreshed)

    fun newsDboToModel(dbo: NewsDBO) =
        News(dbo.id, dbo.title, dbo.subtitle, dbo.body, dbo.date, dbo.lastRefreshed)
}
