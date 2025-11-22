import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.webNavigator)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets.commonMain.dependencies {
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.ui)
        implementation(compose.components.resources)
        implementation(compose.materialIconsExtended)

        implementation(libs.androidx.lifecycle.viewmodel)

        implementation(libs.compose.material3)
        implementation(libs.compose.material3.windowSize)

        implementation(libs.web.navigator)
    }
}
