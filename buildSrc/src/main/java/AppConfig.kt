object AppConfig {
    const val applicationId = "es.sdos.android.project"
    const val versionCode = 1
    const val versionName = "1.0"

    const val compileSdkVersion = 28
    const val minSdkVersion = 21
    const val targetSdkVersion = 28
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Modules {
    const val app = ":app"
    const val common = ":common"
    const val navigation = ":navigation"
    const val featureLauncher = ":features:launcher"
    const val featureNews = ":features:news"
    const val dataApi = ":data:api"
    const val dataDatabase = ":data:database"
    const val dataModel = ":data:model"
    const val dataRepository = ":data:repository"
}