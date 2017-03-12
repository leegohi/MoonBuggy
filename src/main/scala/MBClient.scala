/**
  * Created by pc on 17/3/12.
  */
package com.ly.moonbuggy
import akka.actor.Actor
import akka.actor.ActorRef
import scala.util.Random
import scala.math._
class MBClient (line:Tuple5[String,Int,Int,Int,Int],server:ActorRef) extends Actor{
    var id=line._1
    var x:Double=line._2
    var y:Double=line._3
    var direction:Double=line._4
    var speed:Double=line._5
    def sendCurrentPosition():Unit={//cars send current position to Server,the format is:car_id,x,y,direction,speed(m/s)
        for(i<- 1 to 900 ){
        server ! MBMessage(id,x,y,direction,speed)
        Thread.sleep(1000)
        x+=speed*1*cos(direction.toDouble/180*Pi)
        y+=speed*1*sin(direction.toDouble/180*Pi)
        direction=(new Random).nextInt(180)
        speed=(new Random).nextInt(5)
    
     }
  }
    def receive={//recieve the start signal or other...
        case StartClient => sendCurrentPosition()
        case  _ =>println("Nothing")
     }
}
