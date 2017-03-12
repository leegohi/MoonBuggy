/**
  * Created by pc on 17/3/12.
  */
package com.ly.moonbuggy
sealed trait Message
case object  StartServer extends Message
case object  StartClient extends Message
case class MBMessage(id:String,x:Double,y:Double,angle:Double,speed:Double) extends  Message

