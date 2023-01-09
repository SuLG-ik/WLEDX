package ru.sulgik.wledx.repository.device

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.sulgik.wledx.data.DeviceStatus
import javax.inject.Inject

class KtorDeviceRepository @Inject constructor(
    private val client: HttpClient,
): DeviceRepository {

    override suspend fun loadStatus(address: String): DeviceStatus {
        val response = client.get("http://$address/json")
        return response.body()
    }

}