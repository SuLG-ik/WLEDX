package ru.sulgik.wledx.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.sulgik.wledx.data.DeviceStatusState.PlaylistState.*
import ru.sulgik.wledx.data.Nightlight.Mode.*
import ru.sulgik.wledx.utils.IntToEnumSerializer

@Serializable
data class DeviceStatus(
    val state: DeviceStatusState,
)


@Serializable
data class DeviceStatusState(
    @SerialName("on")
    val isEnabled: Boolean,
    @SerialName("bri")
    val brightness: Int,
    val transition: Int,
    @SerialName("ps")
    val preset: Int,
    @SerialName("pl")
    @Serializable(PlaylistStateSerializer::class)
    val playlist: PlaylistState,
    @SerialName("nl")
    val nightlight: Nightlight,
) {
    enum class PlaylistState {
        @SerialName("-1")
        OFF,

        @SerialName("0")
        ON,
    }
}

@Serializable
data class Nightlight(
    @SerialName("on")
    val isEnabled: Boolean,
    @SerialName("dur")
    val durationInMinutes: Int,
    @Serializable(NightlightModeSerializer::class)
    val mode: Mode,
) {
    enum class Mode {
        INSTANT, FADE, COLOR_FADE, SUNRISE;
    }
}

object PlaylistStateSerializer :
    IntToEnumSerializer<DeviceStatusState.PlaylistState>("PlaylistState") {

    override fun DeviceStatusState.PlaylistState.toInt(): Int {
        return when (this) {
            OFF -> -1
            ON -> 0
        }
    }

    override fun Int.toState(): DeviceStatusState.PlaylistState {
        return when (this) {
            -1 -> OFF
            0 -> ON
            else -> OFF
        }
    }


}

object NightlightModeSerializer :
    IntToEnumSerializer<Nightlight.Mode>(" NightlightMode") {

    override fun Nightlight.Mode.toInt(): Int {
        return when (this) {
            INSTANT -> 0
            FADE -> 1
            COLOR_FADE -> 2
            SUNRISE -> 3
        }
    }

    override fun Int.toState(): Nightlight.Mode {
        return when (this) {
            0 -> INSTANT
            1 -> FADE
            2 -> COLOR_FADE
            3 -> SUNRISE
            else -> { INSTANT }
        }
    }


}