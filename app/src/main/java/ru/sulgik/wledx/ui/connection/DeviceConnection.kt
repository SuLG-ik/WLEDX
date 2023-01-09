package ru.sulgik.wledx.ui.connection

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ru.sulgik.wledx.ui.destinations.ManualConnectionScreenDestination
import ru.sulgik.wledx.ui.view.BottomScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun DeviceConnectionScreen(navigator: DestinationsNavigator) {
    BottomScaffold(
        image = Icons.Outlined.Settings,
        modifier = Modifier.fillMaxSize(),
        topBar = { DeviceConnectionTopBar() },
        content = {
            DeviceConnectionBottomBar(
                onDiscovery = { /*TODO*/ },
                onManual = { navigator.navigate(ManualConnectionScreenDestination) },
            )
        },
    )
}

@Composable
fun DeviceConnectionBottomBar(
    onDiscovery: () -> Unit,
    onManual: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        OutlinedButton(onClick = onDiscovery, enabled = false, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Поиск устройства")
        }
        OutlinedButton(onClick = onManual, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Ручная настройка")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceConnectionTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Новое устройство") },
        modifier = modifier,
    )
}