package org.example.eventBus

import com.hoc081098.channeleventbus.ChannelEvent
import com.hoc081098.channeleventbus.ChannelEventKey

// Define a shared event type
data class ScreenEvent(val payload: String) : ChannelEvent<ScreenEvent> {
    override val key get() = Key
    companion object Key : ChannelEventKey<ScreenEvent>(ScreenEvent::class)
}
