package io.mangix.donkey.core.subscriber

import java.util.concurrent.ConcurrentHashMap

import io.mangix.donkey.core.broker.MessageBroker

/**
  * Date: 2018/5/14
  * Description:
  *
  * @author Nirvana
  * @version 1.0
  */
abstract class AbstractSubscriber extends Subscriber {

  protected val brokers: java.util.Set[MessageBroker] = new ConcurrentHashMap[MessageBroker, Boolean]().keySet(true)

  /**
    * subscribe a topic
    *
    * @param broker the message broker(topic) to subscribe
    */
  override def subscribe(broker: MessageBroker): Unit = {
    broker.addSubscriber(this)
    brokers.add(broker)
  }

  /**
    * unsubscribe a topic
    *
    * @param broker the message broker(topic) to unsubscribe
    */
  override def unSubscribe(broker: MessageBroker): Unit = {
    broker.removeSubscriber(this)
    brokers.remove(broker)
  }
}
