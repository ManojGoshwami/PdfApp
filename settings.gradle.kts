pluginManagement {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven { url = uri("https://www.jitpack.io" ) }

        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io" ) }

        jcenter()
    }
}

rootProject.name = "PdfApp"
include(":app")
