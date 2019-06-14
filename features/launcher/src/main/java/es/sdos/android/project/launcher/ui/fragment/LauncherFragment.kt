package es.sdos.android.project.launcher.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.sdos.android.project.common.di.GoogleViewModelFactory
import es.sdos.android.project.common.ui.fragment.BaseFragment
import es.sdos.android.project.common.ui.viewmodel.BaseViewModel
import es.sdos.android.project.launcher.databinding.FragmentLauncherBinding
import es.sdos.android.project.launcher.ui.viewmodel.LauncherViewModel
import javax.inject.Inject

class LauncherFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: GoogleViewModelFactory<LauncherViewModel>
    private val viewModel: LauncherViewModel by lazy { viewModelFactory.get() }

    private lateinit var binding: FragmentLauncherBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLauncherBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.start()
    }

}