package site.composepreviewer.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
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
    val navController = rememberSaveable { NavController() }
    var currentTheme by remember { mutableStateOf(localStorage[Theme::class.toString()]?.let(Theme::valueOf) ?: Theme.LIGHT) }

    DashboardTheme {
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
        ) { paddingValues ->
            Column(Modifier.fillMaxSize().padding(paddingValues)) {
                NavHost(navController = navController) {
                    route("/") {
                        Home()
                    }

                    route("/login") {
                        Login()
                    }
                }
            }
        }
    }
}
