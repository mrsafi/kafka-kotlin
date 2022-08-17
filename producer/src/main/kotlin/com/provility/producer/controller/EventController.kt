package com.provility.producer.controller

import com.provility.producer.service.EventService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/event")
class EventController(private val eventService: EventService) {

    @PostMapping("/transit-account")
    fun sendTransitAccountEvent(@RequestBody @Validated transitAccountV1: TransitAccountV1) = eventService.sendTransitAccountEvent(transitAccountV1)


    @PostMapping("/tap-event")
    fun sendTapEvent(@RequestBody @Validated tapEventV1: TapEventV1) = eventService.sendTapEvent(tapEventV1)


}
