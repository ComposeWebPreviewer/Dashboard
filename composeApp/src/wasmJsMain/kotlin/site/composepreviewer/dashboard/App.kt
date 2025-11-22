package site.composepreviewer.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.onClick
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import io.github.taz03.compose.web.navigator.NavController
import io.github.taz03.compose.web.navigator.NavHost
import kotlinx.browser.localStorage
import org.w3c.dom.get
import org.w3c.dom.set
import site.composepreviewer.dashboard.components.TopBar
import site.composepreviewer.dashboard.pages.home.Home
import site.composepreviewer.dashboard.pages.login.Login
import site.composepreviewer.dashboard.pages.signup.Signup
import site.composepreviewer.dashboard.theme.DashboardTheme
import site.composepreviewer.dashboard.theme.Theme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun App() {
    val navController = rememberSaveable { NavController() }
    var currentTheme by remember { mutableStateOf(localStorage[Theme::class.toString()]?.let(Theme::valueOf) ?: Theme.LIGHT) }

    val focusManager = LocalFocusManager.current

    DashboardTheme(currentTheme) {
        Scaffold(
            modifier = Modifier.onClick(onClick = focusManager::clearFocus),
            topBar = {
                TopBar(
                    navController = navController,
                    theme = currentTheme,
                    themeToggle = {
                        currentTheme = if (currentTheme == Theme.LIGHT) Theme.DARK else Theme.LIGHT
                        localStorage[Theme::class.toString()] = currentTheme.name
                    }
                )
            },
            containerColor = MaterialTheme.colorScheme.surface
        ) { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavHost(navController = navController) {
                    route("/") {
                        Home()
                    }

                    route("/login") {
                        Login(navController)
                    }

                    route("/signup") {
                        Signup()
                    }
                }
            }
        }
    }
}
