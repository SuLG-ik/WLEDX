package ru.sulgik.wledx.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

abstract class IntToEnumSerializer<T : Enum<T>>(name: String) : KSerializer<T> {


    abstract fun T.toInt(): Int

    abstract fun Int.toState(): T

    override fun deserialize(decoder: Decoder): T {
        return decoder.decodeInt().toState()
    }

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeInt(value.toInt())
    }

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(name, PrimitiveKind.INT)

}