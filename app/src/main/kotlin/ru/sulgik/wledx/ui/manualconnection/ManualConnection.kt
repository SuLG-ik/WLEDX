package ru.sulgik.wledx.ui.manualconnection

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import ru.sulgik.wledx.ui.view.BottomScaffold
import ru.sulgik.wledx.vm.manualconnection.ManualConnectionViewModel

@Destination
@Composable
fun ManualConnectionScreen(
    connectionViewModel: ManualConnectionViewModel = hiltViewModel(),
) {
    val state = connectionViewModel.state
    var address by rememberSaveable { mutableStateOf("") }
    LaunchedEffect(key1 = state, block = {
        Log.d("state", "$state")
    })
    BottomScaffold(
        image = Icons.Outlined.Info,
        topBar = { ManualConnectionTopBar() },
        modifier = Modifier.fillMaxSize(),
    ) {
        ManualConnectionContent(
            address = address,
            onEdit = { address = it.filterNot(Char::isWhitespace) },
            isLoading = state.isLoading,
            onComplete = {
                connectionViewModel.connectToDevice(address)
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManualConnectionTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Подключение вручную")
        },
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManualConnectionContent(
    address: String,
    onEdit: (String) -> Unit,
    isLoading: Boolean,
    onComplete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedTextField(
            value = address,
            onValueChange = onEdit,
            label = { Text("Адрес устройства") },
            placeholder = { Text("xxx.xxx.xxx.xxx") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            OutlinedButton(
                onClick = onComplete,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = false)
            ) {
                Text(text = "Подключиться")
            }
            AnimatedVisibility(isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(25.dp))
            }
        }
    }
}