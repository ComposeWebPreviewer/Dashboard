package site.composepreviewer.dashboard.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun DashboardTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) = MaterialTheme(
    colorScheme = if (darkTheme) darkScheme else lightScheme,
    typography = appTypography(),
    content = content
)
