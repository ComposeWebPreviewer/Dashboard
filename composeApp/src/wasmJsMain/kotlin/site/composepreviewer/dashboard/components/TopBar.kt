package site.composepreviewer.dashboard.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import dashboard.composeapp.generated.resources.Res
import dashboard.composeapp.generated.resources.logo
import io.github.taz03.compose.web.navigator.NavController
import io.github.taz03.compose.web.navigator.Route
import org.jetbrains.compose.resources.painterResource
import site.composepreviewer.dashboard.theme.Theme

@Composable
fun TopBar(
    navController: NavController,
    onLogoClick: () -> Unit = {},
    theme: Theme = Theme.LIGHT,
    themeToggle: () -> Unit = {},
) = Column(Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surfaceContainer)) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .clickable(onClick = onLogoClick)
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(42.dp)
            )

            Text(
                text = "Compose Preview",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(Modifier.weight(1f))

        IconButton(onClick = themeToggle) {
            Icon(
                imageVector = if (theme == Theme.DARK) Icons.Default.BrightnessHigh else Icons.Default.DarkMode,
                contentDescription = "Toggle Theme"
            )
        }

        var dropdownExpanded by remember { mutableStateOf(false) }
        Box {
            SecondaryButton(
                onClick = { dropdownExpanded = !dropdownExpanded },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Account",
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline
                )

                Icon(
                    imageVector = if (dropdownExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }

            DropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = { dropdownExpanded = false },
                shape = MaterialTheme.shapes.small,
                containerColor = MaterialTheme.colorScheme.surfaceContainer,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            ) {
                DropdownRow(
                    onClick = { navController.navigate(Route("/pricing")) },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Payments,
                            contentDescription = null
                        )
                    },
                    text = "Pricing"
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 4.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outline
                )

                DropdownRow(
                    onClick = { navController.navigate(Route("/login")) },
                    icon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Login,
                            contentDescription = null
                        )
                    },
                    text = "Log in"
                )

                DropdownRow(
                    onClick = { navController.navigate(Route("/signup")) },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.PersonAdd,
                            contentDescription = null
                        )
                    },
                    text = "Sign up"
                )
            }
        }
    }

    HorizontalDivider()
}

@Composable
private fun DropdownRow(
    onClick: () -> Unit,
    icon: @Composable (() -> Unit),
    text: String,
) = Row(
    modifier = Modifier.fillMaxWidth()
        .clickable(onClick = onClick)
        .padding(horizontal = 12.dp, vertical = 4.dp)
        .padding(end = 12.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp)
) {
    icon()
    Text(text)
}
