package es.sdos.android.project.news.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import es.sdos.android.project.common.di.GoogleViewModelFactory
import es.sdos.android.project.common.ui.fragment.BaseFragment
import es.sdos.android.project.common.ui.viewmodel.BaseViewModel
import es.sdos.android.project.news.R
import es.sdos.android.project.news.databinding.FragmentNewsListBinding
import es.sdos.android.project.news.ui.adapter.NewsListAdapter
import es.sdos.android.project.news.ui.viewmodel.NewsListViewModel
import javax.inject.Inject

class NewsListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: GoogleViewModelFactory<NewsListViewModel>
    private val viewModel: NewsListViewModel by lazy { viewModelFactory.get() }

    private lateinit var binding: FragmentNewsListBinding
    private lateinit var adapter: NewsListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        configureRecycler(binding.newsListListNews)
        return binding.root
    }

    override fun getViewModel(): BaseViewModel = viewModel

    private fun configureRecycler(recyclerView: RecyclerView) {
        adapter = NewsListAdapter(viewModel)
        recyclerView.adapter = adapter

        context?.let {
            val dividerItem = DividerItemDecoration(it, DividerItemDecoration.VERTICAL)
            val verticalDivider = ContextCompat.getDrawable(it, R.drawable.divider__news_list)
            dividerItem.setDrawable(verticalDivider!!)
            recyclerView.addItemDecoration(dividerItem)
        }
    }

    override fun getExtras(): FragmentNavigator.Extras {
        return adapter.getExtras() ?: super.getExtras()
    }
}