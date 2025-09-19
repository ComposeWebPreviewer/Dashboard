package site.composepreviewer.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.window
import site.composepreviewer.dashboard.pages.home.Home
import site.composepreviewer.dashboard.pages.login.Login
import site.composepreviewer.dashboard.theme.DashboardTheme

@Composable
fun App() {
    var location by remember { mutableStateOf(window.location.pathname) }
    var initialized by remember { mutableStateOf(false) }
    LaunchedEffect(location) {
        if (!initialized) {
            initialized = true
            return@LaunchedEffect
        }

        window.history.pushState(null, "", location)
    }
    window.addEventListener("popstate") {
        location = window.location.pathname
    }

    DashboardTheme {
        when (location) {
            "/login" -> Login()
            "/" -> Home()
        }
    }
}
