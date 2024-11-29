package org.example.eventBus

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class FirstScreen {
    fun onEventTriggered() {
        // Sending event from Screen A with some payload
        MainScope().launch {
            EventBusManager.sendEvent(ScreenEvent("Hello from Screen A!"))
        }
    }
}