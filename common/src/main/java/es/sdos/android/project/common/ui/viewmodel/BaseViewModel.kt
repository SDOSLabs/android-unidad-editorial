package es.sdos.android.project.common.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import es.sdos.android.project.common.util.Event
import es.sdos.android.project.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    // FOR NAVIGATION
    private val navigation = MutableLiveData<Event<NavigationCommand>>()
    fun getNavigation() = navigation as LiveData<Event<NavigationCommand>>

    // FOR ERROR HANDLER
    protected val snackbarError = MutableLiveData<Event<Int>>()
    fun getSnackbarError() = snackbarError as LiveData<Event<Int>>

    /**
     * Convenient method to handle navigation from a [ViewModel]
     */
    fun navigate(directions: NavDirections) {
        navigation.value = Event(NavigationCommand.To(directions))
    }

    fun navigateBack() {
        navigation.value = Event(NavigationCommand.Back)
    }
}