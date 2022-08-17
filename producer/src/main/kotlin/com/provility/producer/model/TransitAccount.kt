package com.provility.producer.model

import java.time.ZonedDateTime.now

data class TransitAccount(
    val id: String,
    val serialNumber: String,
    val type: Long,
    val tenantId: Long,
    val timestamp: String = now().toString(),
)
