package ru.sulgik.wledx.vm.manualconnection

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.sulgik.wledx.data.DeviceStatus
import ru.sulgik.wledx.repository.device.DeviceRepository
import javax.inject.Inject

@HiltViewModel
class ManualConnectionViewModel @Inject constructor(
    private val repository: DeviceRepository,
) : ViewModel() {

    var state by mutableStateOf(State())
        private set


    fun connectToDevice(deviceAddress: String) {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            state = try {
                val status = repository.loadStatus(deviceAddress)
                State(status = status)
            } catch (e: Exception) {
                State(error = State.Error.Unknown(e))
            }
        }
    }

    data class State(
        val status: DeviceStatus? = null,
        val isLoading: Boolean = false,
        val error: Error? = null,
    ) {
        sealed interface Error {
            @JvmInline
            value class Unknown(val exception: Exception) : Error
        }
    }

}