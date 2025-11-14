package site.composepreviewer.dashboard.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

enum class Theme {
    LIGHT, DARK
}

@Composable
fun DashboardTheme(
    theme: Theme = Theme.LIGHT,
    content: @Composable () -> Unit
) = MaterialTheme(
    colorScheme = if (theme == Theme.DARK) darkScheme else lightScheme,
    typography = appTypography(),
    content = content
)
