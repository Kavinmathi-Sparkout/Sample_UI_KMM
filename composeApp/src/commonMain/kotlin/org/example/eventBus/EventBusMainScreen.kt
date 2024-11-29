package org.example.eventBus

fun EventBusMainScreen (){
    val firstScreen = FirstScreen()
    val secondScreen = SecondScreen()

    //Sends an event to the bus
    firstScreen.onEventTriggered()
    //Start listening for events
    secondScreen.startListeningForEvents()


}