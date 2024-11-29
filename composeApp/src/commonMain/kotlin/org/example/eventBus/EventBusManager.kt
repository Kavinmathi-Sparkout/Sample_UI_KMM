package org.example.eventBus

import com.hoc081098.channeleventbus.ChannelEventBus
import kotlinx.coroutines.flow.Flow

object EventBusManager {
    // Create the shared instance of ChannelEventBus
    private val eventBus = ChannelEventBus()
    // Method to send an event from any screen
    fun sendEvent(event: ScreenEvent) {
        eventBus.send(event)
    }
    // Method to listen for events in another screen
    fun listenForEvents(): Flow<ScreenEvent> {
        return eventBus.receiveAsFlow(ScreenEvent)
    }
}