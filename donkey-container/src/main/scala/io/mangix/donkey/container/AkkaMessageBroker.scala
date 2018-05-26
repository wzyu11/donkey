package io.mangix.donkey.container

import akka.actor.Actor
import io.mangix.donkey.container.AkkaMessageBroker.EventType.EventType
import io.mangix.donkey.container.AkkaMessageBroker.{EventType, SetEvent}
import io.mangix.donkey.core.broker.MessageBroker
import io.mangix.donkey.core.subscriber.Subscriber

/**
  * Date: 2018/5/15
  * Description:
  *
  * @author Nirvana
  * @version 1.0
  */
class AkkaMessageBroker(broker: MessageBroker) extends MessageBroker(broker: MessageBroker) {

  var subscribers: Set[Subscriber] = Set()



  class SetActor extends Actor {

    override def receive: Receive = {
      case SetEvent(EventType.ADD, subscriber: Subscriber) => subscribers = subscribers + subscriber
      case SetEvent(EventType.REMOVE, subscriber: Subscriber) => subscribers = subscribers - subscriber
    }

  }

  /**
    * add subscriber into this broker.
    *
    * @param subscriber the subscriber to add in.
    */
  override def addSubscriber(subscriber: Subscriber): Unit = subscribers ! SetEvent(EventType.ADD, subscriber)


  /**
    * remove subscriber from this broker
    *
    * @param subscriber the subscriber to remove.
    */
  override def removeSubscriber(subscriber: Subscriber): Unit = subscribers ! SetEvent(EventType.REMOVE, subscriber)
}

object AkkaMessageBroker {

  object EventType extends Enumeration {
    type EventType = Value
    val ADD, REMOVE = Value
  }

  case class SetEvent(eventType: EventType, subscriber: Subscriber)

}
