package ru.sulgik.wledx.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sulgik.wledx.repository.device.DeviceRepository
import ru.sulgik.wledx.repository.device.KtorDeviceRepository

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindDeviceRepository(impl: KtorDeviceRepository): DeviceRepository

}