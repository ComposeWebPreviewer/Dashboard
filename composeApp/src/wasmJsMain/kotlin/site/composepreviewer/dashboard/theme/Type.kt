package site.composepreviewer.dashboard.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dashboard.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font

@Composable
fun appTypography(): Typography {
    val jetbrainsMono = FontFamily(
        Font(
            resource = Res.font.JetBrainsMono_Bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_BoldItalic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.JetBrainsMono_ExtraBold,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_ExtraBoldItalic,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.JetBrainsMono_ExtraLight,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_ExtraLightItalic,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.JetBrainsMono_Italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.JetBrainsMono_Light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_LightItalic,
            weight = FontWeight.Light,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.JetBrainsMono_Medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_MediumItalic,
            weight = FontWeight.Medium,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.JetBrainsMono_Regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_SemiBold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_SemiBoldItalic,
            weight = FontWeight.SemiBold,
            style = FontStyle.Italic
        ),
        Font(
            resource = Res.font.JetBrainsMono_Thin,
            weight = FontWeight.Thin,
            style = FontStyle.Normal
        ),
        Font(
            resource = Res.font.JetBrainsMono_ThinItalic,
            weight = FontWeight.Thin,
            style = FontStyle.Italic
        )
    )

    return MaterialTheme.typography.copy(
        displayLarge = MaterialTheme.typography.displayLarge.copy(fontFamily = jetbrainsMono),
        displayMedium = MaterialTheme.typography.displayMedium.copy(fontFamily = jetbrainsMono),
        displaySmall = MaterialTheme.typography.displaySmall.copy(fontFamily = jetbrainsMono),
        headlineLarge = MaterialTheme.typography.headlineLarge.copy(fontFamily = jetbrainsMono),
        headlineMedium = MaterialTheme.typography.headlineMedium.copy(fontFamily = jetbrainsMono),
        headlineSmall = MaterialTheme.typography.headlineSmall.copy(fontFamily = jetbrainsMono),
        titleLarge = MaterialTheme.typography.titleLarge.copy(fontFamily = jetbrainsMono),
        titleMedium = MaterialTheme.typography.titleMedium.copy(fontFamily = jetbrainsMono),
        titleSmall = MaterialTheme.typography.titleSmall.copy(fontFamily = jetbrainsMono),
        bodyLarge = MaterialTheme.typography.bodyLarge.copy(fontFamily = jetbrainsMono),
        bodyMedium = MaterialTheme.typography.bodyMedium.copy(fontFamily = jetbrainsMono),
        bodySmall = MaterialTheme.typography.bodySmall.copy(fontFamily = jetbrainsMono),
        labelLarge = MaterialTheme.typography.labelLarge.copy(fontFamily = jetbrainsMono),
        labelMedium = MaterialTheme.typography.labelMedium.copy(fontFamily = jetbrainsMono),
        labelSmall = MaterialTheme.typography.labelSmall.copy(fontFamily = jetbrainsMono)
    )
}
