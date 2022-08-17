package com.provility.producer.service

import com.provility.producer.model.TapEvent
import com.provility.producer.model.TransitAccount
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class StreamBridgeService(@Autowired val streamBridge: StreamBridge) {

    private val logger = KotlinLogging.logger {}

    fun sendTransitAccountEvent(transitAccount: TransitAccount) {
        val kafkaMessage = MessageBuilder
            .withPayload(transitAccount)
            // Make sure all messages for a given probe go to the same partition to ensure proper ordering
            .setHeader(KafkaHeaders.MESSAGE_KEY, transitAccount.id)
            .build()
        logger.info { "Publishing transit account: Payload: '${kafkaMessage.payload}'" }
        streamBridge.send("transit-account-data-out-0", kafkaMessage)
    }


    fun sendTapEvent(tapEvent: TapEvent) {
        val kafkaMessage = MessageBuilder
            .withPayload(tapEvent)
            // Make sure all messages for a given probe go to the same partition to ensure proper ordering
            .setHeader(KafkaHeaders.MESSAGE_KEY, tapEvent.id)
            .build()
        logger.info { "Publishing tap event: Payload: '${kafkaMessage.payload}'" }
        streamBridge.send("tap-event-data-out-0", kafkaMessage)
    }
}
