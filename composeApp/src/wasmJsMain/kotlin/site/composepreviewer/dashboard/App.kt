package site.composepreviewer.dashboard

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import io.github.taz03.compose.web.navigator.NavController
import io.github.taz03.compose.web.navigator.NavHost
import kotlinx.browser.localStorage
import org.w3c.dom.get
import org.w3c.dom.set
import site.composepreviewer.dashboard.components.TopBar
import site.composepreviewer.dashboard.pages.home.Home
import site.composepreviewer.dashboard.pages.login.Login
import site.composepreviewer.dashboard.theme.DashboardTheme
import site.composepreviewer.dashboard.theme.Theme

@Composable
fun App() {
    val navController = remember { NavController() }
    var currentTheme by remember { mutableStateOf(localStorage[Theme::class.toString()]?.let(Theme::valueOf) ?: Theme.LIGHT) }

    DashboardTheme(currentTheme) {
        Scaffold(
            topBar = {
                TopBar(
                    theme = currentTheme,
                    themeToggle = {
                        currentTheme = if (currentTheme == Theme.LIGHT) Theme.DARK else Theme.LIGHT
                        localStorage[Theme::class.toString()] = currentTheme.name
                    }
                )
            },
            containerColor = MaterialTheme.colorScheme.background
        ) {
            NavHost(navController = navController) {
                route("/") {
                    Login()
                }

                route("/login") {
                    Home()
                }
            }
        }
    }
}
