package io.mangix.donkey.core.broker

import io.mangix.donkey.core.Message

/**
  * Date: 2018/5/12
  * Description:
  *
  * @author Nirvana
  * @version 1.0
  */
trait MessageSource {

  /**
    * put a message into this message source
    *
    * @param message the message
    */
  def putMessage(message: Message): Unit

  /**
    * get message from index to currentSeq.
    *
    * @param index the begin index
    * @return message list
    */
  def getMessage(index: Long): List[Message]

  /**
    * get message from start index to end index.
    *
    * @param start the begin index
    * @param end   the end index
    * @return message list
    */
  def getMessage(start: Long, end: Long): List[Message]

  /**
    * current message seq number
    */
  def getCurrentSeq: Long

}
