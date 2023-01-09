package ru.sulgik.wledx.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ru.sulgik.wledx.ui.destinations.DeviceConnectionScreenDestination
import ru.sulgik.wledx.ui.destinations.DevicesListScreenDestination

@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            SplashConfiguration.contentSpacedBy,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            Icons.Outlined.Favorite,
            contentDescription = null,
            modifier = Modifier.size(SplashConfiguration.splashSize),
            tint = Color.Magenta,
        )
        Text(
            "Добро пожаловать в WLEDX",
            style = SplashConfiguration.textStyle,
            textAlign = TextAlign.Center,
        )
        FilledTonalIconButton(
            onClick = {
                navigator.popBackStack()
                navigator.navigate(DeviceConnectionScreenDestination)
            },
            modifier = Modifier.size(SplashConfiguration.buttonSize)
        ) {
            Icon(
                Icons.Outlined.ArrowForward,
                contentDescription = null,
                modifier = Modifier,
            )
        }
    }
}
