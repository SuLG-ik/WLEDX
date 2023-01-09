package ru.sulgik.wledx.ui.splash

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object SplashConfiguration {

    val splashSize: Dp
        @Composable get() {
            val configuration = LocalConfiguration.current
            Log.d("config", LocalConfiguration.current.toString())
            if (configuration.screenHeightDp < 500)
                return 175.dp
            if (configuration.screenHeightDp < 300)
                return 50.dp
            return 250.dp
        }

    val contentSpacedBy: Dp
        @Composable get() {
            val configuration = LocalConfiguration.current
            Log.d("config", LocalConfiguration.current.toString())
            if (configuration.screenHeightDp < 400)
                return 15.dp
            if (configuration.screenHeightDp < 300)
                return 5.dp
            return 25.dp
        }

    val buttonSize: Dp
        @Composable get() {
            val configuration = LocalConfiguration.current
            if (configuration.screenHeightDp < 200)
                return 25.dp
            return 50.dp
        }

    val textStyle: TextStyle
        @Composable get() {
            val configuration = LocalConfiguration.current
            if (configuration.screenHeightDp < 200)
                return MaterialTheme.typography.bodyMedium
            return MaterialTheme.typography.bodyLarge
        }

}