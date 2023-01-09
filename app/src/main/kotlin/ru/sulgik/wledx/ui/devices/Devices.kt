package ru.sulgik.wledx.ui.devices

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun DevicesListScreen() {
    Scaffold(
        topBar = {
            DevicesListTopBar()
        },
        modifier = Modifier.fillMaxSize()
    ) {
        DevicesListContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevicesListContent(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        content = {
            items(100) {
                ListItem(
                    headlineText = {
                        Text("item $it")
                    }
                )
            }
        })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevicesListTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Список устройств")
        },
        modifier = modifier,
    )
}