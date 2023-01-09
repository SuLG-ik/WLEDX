package ru.sulgik.wledx.repository.device

import ru.sulgik.wledx.data.DeviceStatus

interface DeviceRepository {

    suspend fun loadStatus(address: String): DeviceStatus

}