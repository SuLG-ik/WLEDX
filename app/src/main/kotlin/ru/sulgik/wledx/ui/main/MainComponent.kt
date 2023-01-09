package ru.sulgik.wledx.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import ru.sulgik.wledx.ui.NavGraphs
import ru.sulgik.wledx.ui.theme.WLEDXTheme

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@Preview(showBackground = true)
@Composable
fun MainApplication() {
    WLEDXTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            val engine = rememberAnimatedNavHostEngine(
                rootDefaultAnimations = RootNavGraphDefaultAnimations(
                    enterTransition = {
                        fadeIn() + scaleIn(
                            spring(
                                dampingRatio = Spring.DampingRatioLowBouncy,
                                stiffness = Spring.StiffnessMediumLow
                            ), initialScale = 0.8f
                        )
                    },
                    exitTransition = { fadeOut() + scaleOut(
                        spring(
                            dampingRatio = Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessMediumLow
                        ), targetScale = 0.8f
                    ) },
                )
            )
            DestinationsNavHost(navGraph = NavGraphs.root, engine = engine)
        }
    }
}

