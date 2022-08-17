package com.provility.consumer.model

import java.time.ZonedDateTime

data class TapEvent(val id:String, val serialNumber: String, val type: Long, val tenantId: Long, val validatorId: String, val validatedForRide: Boolean, val validationTime:ZonedDateTime = ZonedDateTime.now())
