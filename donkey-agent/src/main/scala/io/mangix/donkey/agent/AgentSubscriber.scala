package io.mangix.donkey.agent

import io.mangix.donkey.core.Message
import io.mangix.donkey.core.broker.MessageBroker
import io.mangix.donkey.core.subscriber.Subscriber

/**
  * Date: 2018/5/22
  * Description:
  *
  * @author Nirvana
  * @version 1.0
  */
abstract class AgentSubscriber(agent: Agent) extends Subscriber {

  /**
    * work on an message coming
    *
    * @param message the message
    */
  override def onMessage(message: Message): Unit = agent.sendPackage(message)

}
