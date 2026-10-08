package com.rayxaus.tusky.ui.screenTwo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.rayxaus.tusky.R
import com.rayxaus.tusky.ui.screenOne.ScreenOne
import com.rayxaus.tusky.ui.theme.TuskyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTwo() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.primary,
                    subtitleContentColor = MaterialTheme.colorScheme.secondary,
                ),
                title = {
                    Text(
                        text = "Nice TopBar"
                    )
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "This is screen two! What r u doing here?")
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "cool illustration"
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true,
    device = "spec:parent=pixel_5,navigation=buttons"
)
@Composable
private fun ScreenTwoPreview() {
    TuskyTheme {
        ScreenTwo()
    }
}

@PreviewLightDark
@Composable
private fun ScreenTwoPreviewWithThemes() {
    TuskyTheme {
        ScreenTwo()
    }
}