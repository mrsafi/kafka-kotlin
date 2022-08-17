package com.provility.consumer.config

import com.provility.consumer.model.TapEvent
import com.provility.consumer.model.TransitAccount
import mu.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import java.util.function.Consumer

@Configuration
class KafkaConsumerConfiguration {

    private val logger = KotlinLogging.logger {}

    @Bean
    fun processTransitAccountData(): Consumer<Message<TransitAccount>> =
        Consumer { transitAccountMessage ->
            try {
                val transitAccount = transitAccountMessage.payload
                logger.info { "Transit account payload: $transitAccount" }
            } catch (e: Exception) {
                logger.error {
                    "Error processing transit account : " +
                            "'${transitAccountMessage.payload}': '${e.message}'"
                }
            }
        }


    @Bean
    fun processTapEventData(): Consumer<Message<TapEvent>> =
        Consumer { tapEventMessage ->
            try {
                val transitAccount = tapEventMessage.payload
                logger.info { "Tap event payload: $transitAccount" }
            } catch (e: Exception) {
                logger.error {
                    "Error processing tap event : " +
                            "'${tapEventMessage.payload}': '${e.message}'"
                }
            }
        }
}
