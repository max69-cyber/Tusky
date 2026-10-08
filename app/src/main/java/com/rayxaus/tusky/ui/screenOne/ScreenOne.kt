package com.rayxaus.tusky.ui.screenOne

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.rayxaus.tusky.R
import com.rayxaus.tusky.ui.theme.TuskyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenOne() {
    val users = remember { mutableStateListOf<String>() }
    val listState = rememberLazyListState()

    LaunchedEffect(users.lastIndex) {
        if (users.isNotEmpty()) {
            listState.animateScrollToItem(users.lastIndex)
        }
    }

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
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Main icon"
                    )
                },
                actions = {
                    IconButton(
                        onClick = { users.add("User ${users.size}") }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_sentiment_satisfied),
                            contentDescription = "Add greeting"
                        )
                    }
                    IconButton(
                        onClick = { users.removeLastOrNull() }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_sentiment_dissatisfied),
                            contentDescription = "Delete greeting"
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
//        Column(modifier = Modifier.padding(innerPadding)) {
//            for (name in users) {
//                Greeting(
//                    name = name
//                )
//            }
//        }
        LazyColumn(
            modifier = Modifier.padding(innerPadding).fillMaxWidth(),
            state = listState
        ) {
            items(users.size) {
                Greeting(
                    name = users[it]
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true,
    device = "spec:parent=pixel_5,navigation=buttons"
)
@Composable
private fun ScreenOnePreview() {
    TuskyTheme {
        ScreenOne()
    }
}

@PreviewLightDark
@Composable
private fun ScreenOnePreviewWithThemes() {
    TuskyTheme {
        ScreenOne()
    }
}