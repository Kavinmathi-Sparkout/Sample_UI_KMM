package org.example.eventBus

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class SecondScreen {
    fun startListeningForEvents() {
        // Listen for events from the bus
        MainScope().launch {
            EventBusManager.listenForEvents().collect { event ->
                println("Screen B received event: ${event.payload}")
                // Handle the received event here (e.g., update UI, etc.)
            }
        }
    }
}