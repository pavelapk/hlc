package com.tap.hlc

import kotlin.jvm.JvmInline
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@JvmInline
value class NodeID(val identifier: String) {

    companion object {

        @OptIn(ExperimentalUuidApi::class)
        fun mint(uuid: Uuid = Uuid.random()) = NodeID(uuid.toHexString().takeLast(16))
    }
}
