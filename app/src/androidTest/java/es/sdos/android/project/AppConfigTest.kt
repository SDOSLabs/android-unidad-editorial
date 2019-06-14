package es.sdos.android.project

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotEquals

import org.junit.Test
import org.junit.runner.RunWith


/**
 * Check packageName was changed
 */
@RunWith(AndroidJUnit4::class)
class AppConfigTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        assertNotEquals("es.sdos.android.project", appContext.packageName)
    }
}
