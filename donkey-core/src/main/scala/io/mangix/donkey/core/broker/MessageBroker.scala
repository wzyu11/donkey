package io.mangix.donkey.core.broker

import io.mangix.donkey.core.Message
import io.mangix.donkey.core.subscriber.Subscriber


/**
  * Date: 2018/5/12
  * Description:
  *
  * @author Nirvana
  * @version 1.0
  */
abstract class MessageBroker(messageSource: MessageSource) extends MessageSource {
  /**
    * do something before put message
    *
    * @param message the message
    */
  def beforeMessage(message: Message): Unit = {}

  /**
    * do something after put message
    *
    * @param message the message
    */
  def afterMessage(message: Message): Unit ={}

  /**
    * add subscriber into this broker.
    *
    * @param subscriber the subscriber to add in.
    */
  def addSubscriber(subscriber: Subscriber): Unit

  /**
    * remove subscriber from this broker
    *
    * @param subscriber the subscriber to remove.
    */
  def removeSubscriber(subscriber: Subscriber): Unit

  /**
    * put a message into this message source
    *
    * @param message the message
    */
  override def putMessage(message: Message): Unit = {
    beforeMessage(message)
    messageSource.putMessage(message)
    afterMessage(message)
  }

  /**
    * get message from index to currentSeq.
    *
    * @param index the begin index
    * @return message list
    */
  override def getMessage(index: Long): List[Message] = messageSource.getMessage(index)

  /**
    * get message from start index to end index.
    *
    * @param start the begin index
    * @param end   the end index
    * @return message list
    */
  override def getMessage(start: Long, end: Long): List[Message] = messageSource.getMessage(start, end)

  /**
    * current message seq number
    */
  override def getCurrentSeq: Long = messageSource.getCurrentSeq
}
