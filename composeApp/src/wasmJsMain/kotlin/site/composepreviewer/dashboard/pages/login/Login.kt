package site.composepreviewer.dashboard.pages.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.taz03.compose.web.navigator.NavController
import io.github.taz03.compose.web.navigator.Route
import site.composepreviewer.dashboard.components.PrimaryButton
import site.composepreviewer.dashboard.components.SecondaryButton
import site.composepreviewer.dashboard.components.TertiaryButton
import site.composepreviewer.dashboard.components.TextButton
import site.composepreviewer.dashboard.components.TextField
import site.composepreviewer.dashboard.pages.login.viewmodel.LoginViewModel

@Composable
fun Login(
    navController: NavController,
    viewModel: LoginViewModel = viewModel { LoginViewModel() }
) {
    Column(
        modifier = Modifier.width(350.dp)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Log in",
            fontWeight = FontWeight.ExtraBold,
            textDecoration = TextDecoration.Underline,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(Modifier.height(8.dp))

        TextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Email or Username",
            placeholder = "name@example.com"
        )

        var showPassword by remember { mutableStateOf(false) }
        TextField(
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            modifier = Modifier.fillMaxWidth(),
            label = "Password",
            placeholder = "8-12 characters",
            trailingIcon = {
                IconButton({ showPassword = !showPassword }) {
                    if (showPassword) Icon(
                        imageVector = Icons.Default.VisibilityOff,
                        contentDescription = "Hide password"
                    )
                    else Icon(
                        imageVector = Icons.Default.Visibility,
                        contentDescription = "Show password"
                    )
                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
        )

        PrimaryButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Log in")
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Don't have an account?")
            Spacer(Modifier.width(4.dp))
            TextButton(
                text = "Sign up",
                onClick = { navController.navigate(Route("/signup")) }
            )
        }
    }
}
