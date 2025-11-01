import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    sourceSets.commonMain.dependencies {
        implementation(libs.ktor.client.core)
        implementation(libs.ktor.client.cio)
        implementation(libs.ktor.client.contentNegotiation)
        implementation(libs.ktor.serialization.json)
    }
}
