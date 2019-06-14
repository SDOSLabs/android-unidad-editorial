package es.sdos.android.project.common.ui.binding

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import es.sdos.android.project.repository.util.Resource
import androidx.core.view.ViewCompat.setAlpha
import android.view.animation.AlphaAnimation
import android.view.animation.Animation.INFINITE
import android.view.animation.Animation.REVERSE


object CommonBinding {

    @BindingAdapter("refreshResource")
    @JvmStatic
    fun <T> refreshResource(view: SwipeRefreshLayout, resource: Resource<T>?) {
        Log.d(CommonBinding::class.java.simpleName, "Resource: $resource")
        if (resource != null) {
            view.isRefreshing = false
        }
    }

    @BindingAdapter("skeletonLoading")
    @JvmStatic
    fun <T> skeletonLoading(view: View, resource: Resource<T>?) {
        Log.d(CommonBinding::class.java.simpleName, "Resource: $resource")
        if (resource != null) {
            val isLoading = resource.status == Resource.Status.LOADING
            if(isLoading && view.animation == null) {
                view.visibility = View.VISIBLE
                val animation1 = AlphaAnimation(1.0f, 0.5f)
                animation1.duration = 500
                animation1.repeatMode = REVERSE
                animation1.repeatCount = INFINITE
                view.startAnimation(animation1)
            } else {
                view.clearAnimation()
                view.visibility = View.GONE
            }
        }
    }

    @BindingAdapter("showWhenLoading")
    @JvmStatic
    fun <T> showWhenLoading(view: View, resource: Resource<T>?) {
        Log.d(CommonBinding::class.java.simpleName, "Resource: $resource")
        if (resource != null) {
            val isLoading = resource.status == Resource.Status.LOADING
            view.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    @BindingAdapter("hideWhenLoading")
    @JvmStatic
    fun <T> hideWhenLoading(view: View, resource: Resource<T>?) {
        Log.d(CommonBinding::class.java.simpleName, "Resource: $resource")
        if (resource != null) {
            val isLoading = resource.status == Resource.Status.LOADING
            view.visibility = if (isLoading) View.INVISIBLE else View.VISIBLE
        }
    }

}
