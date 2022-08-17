package com.provility.producer.controller

data class TapEventV1(val id:String, val serialNumber: String, val type: Long, val tenantId: Long, val validatorId: String, val validatedForRide: Boolean)
