@file:Suppress("unused")

package com.provility.consumer.serdes

import com.provility.consumer.model.TransitAccount
import org.springframework.kafka.support.serializer.JsonDeserializer

class TransitAccountDataDeserializer : JsonDeserializer<TransitAccount>()
