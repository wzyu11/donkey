package io.mangix.donkey.agent

/**
  * Date: 2018/5/14
  * Description:
  *
  * @author Nirvana
  * @version 1.0
  */
trait Agent {

  /**
    * handle package that passed to this agent
    *
    * @param pkg the package
    */
  def onPackage(pkg: XPackage): Unit

  /**
    * send package to client
    *
    * @param pkg the package
    */
  def sendPackage(pkg: XPackage): Unit

}
