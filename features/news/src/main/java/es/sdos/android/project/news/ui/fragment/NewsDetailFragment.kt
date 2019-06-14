package es.sdos.android.project.news.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import es.sdos.android.project.common.di.GoogleViewModelFactory
import es.sdos.android.project.common.ui.fragment.BaseFragment
import es.sdos.android.project.common.ui.viewmodel.BaseViewModel
import es.sdos.android.project.news.databinding.FragmentNewsDetailBinding
import es.sdos.android.project.news.ui.viewmodel.NewsDetailViewModel
import javax.inject.Inject

class NewsDetailFragment : BaseFragment(), Transition.TransitionListener {

    @Inject
    lateinit var viewModelFactory: GoogleViewModelFactory<NewsDetailViewModel>
    private val viewModel: NewsDetailViewModel by lazy { viewModelFactory.get() }

    private val args: NewsDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val enterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        enterTransition.addListener(this)
        sharedElementEnterTransition = enterTransition
        sharedElementReturnTransition = enterTransition
        postponeEnterTransition()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getNewsDetail().observe(this, Observer {
            startPostponedEnterTransition()
        })
        viewModel.loadDataWhenActivityStarts(args.id)

    }

    override fun getViewModel(): BaseViewModel = viewModel

    //region Transition Listener
    override fun onTransitionEnd(transition: Transition) {
        binding.newsDetailLabelBody.animate().setDuration(400).alpha(1f).start()
        binding.newsDetailLabelDate.animate().setDuration(400).alpha(1f).start()
    }

    override fun onTransitionResume(transition: Transition) {
        //No op
    }

    override fun onTransitionPause(transition: Transition) {
        //No op
    }

    override fun onTransitionCancel(transition: Transition) {
        //No op
    }

    override fun onTransitionStart(transition: Transition) {
        //No op
    }
    //endregion
}