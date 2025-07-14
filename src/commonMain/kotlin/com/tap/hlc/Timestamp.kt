package com.tap.hlc

import kotlin.jvm.JvmInline
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@JvmInline
value class Timestamp(val epochMillis: Long) {
    @OptIn(ExperimentalTime::class)
    companion object {
        fun now(clock: Clock) = Timestamp(clock.now().toEpochMilliseconds())
    }
}
