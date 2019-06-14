package es.sdos.android.project.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import es.sdos.android.project.model.News
import es.sdos.android.project.news.R
import es.sdos.android.project.news.databinding.RowNewsListBinding
import es.sdos.android.project.news.ui.viewmodel.NewsListViewModel

class NewsListAdapter(private val viewModel: NewsListViewModel) : RecyclerView.Adapter<NewsListViewHolder>() {

    private val news: MutableList<News> = mutableListOf()
    private var extras: FragmentNavigator.Extras? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder(RowNewsListBinding.inflate(LayoutInflater.from(parent.context), parent, false), this)

    override fun getItemCount(): Int =
        news.size

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) =
        holder.bind(news[position], viewModel)

    fun updateData(items: List<News>) {
        val diffCallback = NewsListDiffCallback(news, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        news.clear()
        news.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    fun getExtras(): FragmentNavigator.Extras? {
        return extras
    }

    fun setExtras(extras: FragmentNavigator.Extras) {
        this.extras = extras
    }

}

class NewsListViewHolder(private val binding: RowNewsListBinding, private val adapter: NewsListAdapter) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {

            ViewCompat.setTransitionName(binding.newsListRowLabelTitle, getString(R.string.transition__title))
            ViewCompat.setTransitionName(binding.newsListRowLabelSubtitle, getString(R.string.transition__subtitle))

            adapter.setExtras(
                FragmentNavigatorExtras(
                    binding.newsListRowLabelTitle to getString(R.string.transition__title),
                    binding.newsListRowLabelSubtitle to getString(R.string.transition__subtitle)
                )
            )
            binding.news?.let { news -> binding.viewmodel?.onNewsClick(news) }
        }
    }

    fun bind(news: News, viewModel: NewsListViewModel) {
        binding.news = news
        binding.viewmodel = viewModel
    }

    private fun getString(int: Int): String {
        return binding.root.context.getString(int)
    }

}

class NewsListDiffCallback(private val oldList: List<News>, private val newList: List<News>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].title == newList[newItemPosition].title
    }

}
