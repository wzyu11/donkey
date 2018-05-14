package io.mangix.donkey.core.subscriber

import io.mangix.donkey.core.Message
import io.mangix.donkey.core.broker.MessageBroker

/**
  * Date: 2018/5/12
  * Description:
  *
  * @author Nirvana
  * @version 1.0
  */
trait Subscriber {

  /**
    * subscribe a topic
    *
    * @param broker the message broker(topic) to subscribe
    */
  def subscribe(broker: MessageBroker)

  /**
    * unsubscribe a topic
    *
    * @param broker the message broker(topic) to unsubscribe
    */
  def unSubscribe(broker: MessageBroker)

  /**
    * work on an message coming
    *
    * @param message the message
    */
  def onMessage(message: Message)

}
