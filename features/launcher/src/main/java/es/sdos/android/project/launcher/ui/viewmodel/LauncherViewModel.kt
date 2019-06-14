package es.sdos.android.project.launcher.ui.viewmodel

import android.os.CountDownTimer
import es.sdos.android.project.common.ui.viewmodel.BaseViewModel
import es.sdos.android.project.launcher.ui.fragment.LauncherFragmentDirections
import javax.inject.Inject


class LauncherViewModel @Inject constructor() : BaseViewModel() {

    fun start() {
        object : CountDownTimer(2000, 2000) {

            override fun onTick(millisUntilFinished: Long) {
                // No-op
            }

            override fun onFinish() {
                navigate(LauncherFragmentDirections.goToNewsListFragment())
            }
        }.start()
    }

}