package site.composepreviewer.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dashboard.composeapp.generated.resources.Res
import dashboard.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopBar(
    onLogoClick: () -> Unit = {}
) = Row(
    modifier = Modifier.fillMaxWidth().padding(16.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
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

    DropdownMenu(
        expanded = false,
        onDismissRequest = { /*TODO*/ }
    ) {
        Text("Menu Item 1", modifier = Modifier)
        Text("Menu Item 2", modifier = Modifier)
        Text("Menu Item 3", modifier = Modifier)
    }
}
