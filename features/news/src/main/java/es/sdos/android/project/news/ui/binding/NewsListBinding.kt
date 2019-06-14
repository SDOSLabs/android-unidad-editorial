package es.sdos.android.project.news.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import es.sdos.android.project.model.News
import es.sdos.android.project.news.ui.adapter.NewsListAdapter
import es.sdos.android.project.repository.util.Resource

object NewsListBinding {

    @BindingAdapter("newsListItems")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, resource: Resource<List<News>>?) {
        with(recyclerView.adapter as NewsListAdapter) {
            resource?.data?.let { updateData(it) }
        }
    }

}
