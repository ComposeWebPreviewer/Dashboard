package site.composepreviewer.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dashboard.composeapp.generated.resources.Res
import dashboard.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource
import site.composepreviewer.dashboard.theme.Theme

@Composable
fun TopBar(
    onLogoClick: () -> Unit = {},
    theme: Theme = Theme.LIGHT,
    themeToggle: () -> Unit = {}
) = Row(
    modifier = Modifier.fillMaxWidth().padding(16.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    Row(
        modifier = Modifier.clickable(onClick = onLogoClick),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(64.dp)
        )

        Text(
            text = "Compose Preview",
            style = MaterialTheme.typography.headlineLarge
        )
    }

    Spacer(Modifier.weight(1f))

    IconButton(onClick = themeToggle) {
        Icon(
            imageVector = if (theme == Theme.DARK) Icons.Default.BrightnessHigh else Icons.Default.DarkMode,
            contentDescription = "Toggle Theme"
        )
    }

    DropdownMenu(
        expanded = false,
        onDismissRequest = { /*TODO*/ }
    ) {
        Text("Menu Item 1", modifier = Modifier)
        Text("Menu Item 2", modifier = Modifier)
        Text("Menu Item 3", modifier = Modifier)
    }
}
