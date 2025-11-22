package site.composepreviewer.dashboard.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

object SecondaryButtonDefaults {
    val shape: Shape
        @Composable get() = MaterialTheme.shapes.small

    @Composable
    fun colors(
        containerColor: Color = MaterialTheme.colorScheme.secondary,
        contentColor: Color = MaterialTheme.colorScheme.onSecondary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
        disabledContentColor: Color = Color.Unspecified
    ): ButtonColors = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )
}

@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = SecondaryButtonDefaults.shape,
    colors: ButtonColors = SecondaryButtonDefaults.colors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (RowScope.() -> Unit)
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    shape = shape,
    colors = colors,
    elevation = elevation,
    border = border,
    contentPadding = contentPadding,
    interactionSource = interactionSource,
    content = content
)
