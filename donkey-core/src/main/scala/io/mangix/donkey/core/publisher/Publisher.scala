package io.mangix.donkey.core.publisher

import io.mangix.donkey.core.Message
import io.mangix.donkey.core.broker.MessageBroker

/**
  * Date: 2018/5/12
  * Description:
  *
  * @author Nirvana
  * @version 1.0
  */
trait Publisher {

  /**
    * publish message to broker.
    *
    * @param broker  MessageBroker to publish.
    * @param message the message.
    */
  def publish(broker: MessageBroker, message: Message): Unit

}
