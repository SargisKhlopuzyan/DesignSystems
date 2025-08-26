package com.sargis.khlopuzyan.designsystems.ui.theme.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.designsystems.ui.theme.AppTheme

object InfoCardDefaults {
    @Immutable
    data class Colors(
        val backgroundColor: Color,
        val titleColor: Color,
        val buttonColor: Color,
        val buttonContentColor: Color,
        val amountColor: Color,
        val contentColor: Color,
    )

    @Immutable
    data class Sizes(
        val cornerRadius: Dp,
        val padding: Dp,
    )

    @Composable
    fun colors(
        backgroundColor: Color = Color(0xFF008080),
        titleColor: Color = Color.White,
        buttonColor: Color = Color.White,
        buttonContainerColor: Color = backgroundColor,
        amountColor: Color = Color.White,
        contentColor: Color = Color.White,
    ) = Colors(
        backgroundColor = backgroundColor,
        titleColor = titleColor,
        buttonColor = buttonColor,
        buttonContentColor = buttonContainerColor,
        amountColor = amountColor,
        contentColor = contentColor
    )

    @Composable
    fun sizes(
        cornerRadius: Dp = 8.dp,
        padding: Dp = 16.dp,
    ) = Sizes(cornerRadius, padding)
}

@Composable
fun InfoCard(
    modifier: Modifier = Modifier,
    titleText: String,
    buttonTitle: String,
    amount: String,
    content: @Composable () -> Unit,
    colors: InfoCardDefaults.Colors = InfoCardDefaults.colors(),
    sizes: InfoCardDefaults.Sizes = InfoCardDefaults.sizes(),
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(sizes.cornerRadius))
            .background(colors.backgroundColor)
            .padding(sizes.padding),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = titleText,
                color = colors.titleColor
            )

            Button(
                modifier = Modifier
                    .defaultMinSize(minHeight = 1.dp)
                    .padding(vertical = 0.dp),
                contentPadding = PaddingValues(horizontal = 12.dp),


                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.buttonColor,
                    contentColor = colors.buttonContentColor
                ),
                shape = AppTheme.shape.button,
                onClick = onClick
            ) {
                Text(text = buttonTitle)
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null)
            }
        }
        Text(
            text = amount,
            style = AppTheme.typography.titleLarge,
            color = colors.amountColor
        )

        Surface(
            color = Color.Transparent,
            contentColor = colors.contentColor
        ) {
            content()
        }
    }
}

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(50.dp)),
    progress: () -> Float,
    color: Color,
) {
    LinearProgressIndicator(
        modifier = modifier,
        progress = progress,
        trackColor = color.copy(0.3f),
        color = color,
        drawStopIndicator = {},
        gapSize = 0.dp,
        strokeCap = StrokeCap.Butt
    )
}

@Preview(showBackground = true)
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, backgroundColor = 0xFFFFFF)
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun InfoCardPreview() {
    AppTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            InfoCard(
                titleText = "Weekly Goal",
                buttonTitle = "Create new goal",
                amount = "N/A",
                content = {
                    Text(
                        text = "You haven't created any goals yet",
                    )
                },
                onClick = {}
            )

            InfoCard(
                titleText = "Current Steps Count",
                buttonTitle = "Update weekly goal",
                amount = "52.74 k",
                content = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(text = "Your current steps progress")
                        ProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(50.dp)),
                            color = Color.White,
                            progress = { 0.7f }
                        )
                    }
                },
                colors = InfoCardDefaults.colors(
                    backgroundColor = Color(0xFFFF9528)
                ),
                onClick = {}
            )

            InfoCard(
                titleText = "Current Weight",
                buttonTitle = "Create new goal",
                amount = "91.4 kg",
                content = {
                    Text(text = "You haven't created any weight goals yet")
                },
                colors = InfoCardDefaults.colors(
                    backgroundColor = Color.White,
                    titleColor = Color.Black,
                    buttonColor = Color(0xFF008080),
                    buttonContainerColor = Color.White,
                    amountColor = Color.Black,
                    contentColor = Color.Black,
                ),
                onClick = {}
            )

            InfoCard(
                titleText = "Weight Goal Progress",
                buttonTitle = "Update weight goal",
                amount = "89.3 kg",
                content = {
                    ProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(50.dp)),
                        color = Color(0xFFFF9528),
                        progress = { 0.7f },
                    )
                },
                colors = InfoCardDefaults.colors(
                    backgroundColor = Color(0xFFFFE6CC),
                    titleColor = Color.Black,
                    buttonColor = Color(0xFF008080),
                    buttonContainerColor = Color.White,
                    amountColor = Color.Black,
                    contentColor = Color.Black,
                ),
                onClick = {}
            )
        }
    }
}