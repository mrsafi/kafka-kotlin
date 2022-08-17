package com.provility.producer.service

import com.provility.producer.controller.TapEventV1
import com.provility.producer.controller.TransitAccountV1
import com.provility.producer.model.TapEvent
import com.provility.producer.model.TransitAccount
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class EventService(val streamBridgeService: StreamBridgeService) {

     fun sendTransitAccountEvent(transitAccountV1: TransitAccountV1) {
        val nextInt = Random.nextInt(10)
         streamBridgeService.sendTransitAccountEvent(
            TransitAccount(
                id = nextInt.toString(), serialNumber = transitAccountV1.serialNumber, type = transitAccountV1.type, tenantId = transitAccountV1.tenantId
            )
        )
    }

    fun sendTapEvent(tapEventV1: TapEventV1) {
        streamBridgeService.sendTapEvent(
            TapEvent(
                id = tapEventV1.id, serialNumber = tapEventV1.serialNumber, type = tapEventV1.type, tenantId = tapEventV1.tenantId,
                validatorId = tapEventV1.validatorId, validatedForRide = tapEventV1.validatedForRide
            )
        )
    }
}
