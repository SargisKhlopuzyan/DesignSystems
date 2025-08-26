package com.sargis.khlopuzyan.designsystems

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sargis.khlopuzyan.designsystems.ui.theme.AppTheme
import com.sargis.khlopuzyan.designsystems.ui.theme.composables.InfoCard
import com.sargis.khlopuzyan.designsystems.ui.theme.composables.InfoCardDefaults
import com.sargis.khlopuzyan.designsystems.ui.theme.composables.ProgressIndicator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = AppTheme.colorScheme.background,
                    contentColor = AppTheme.colorScheme.background
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
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
        }
    }
}