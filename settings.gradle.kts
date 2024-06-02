pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GreetingCard"
include(":app")
include(":ch15_messenger")
include(":ch15_aidl")
include(":ch15_outer")
include(":ch15_service")

