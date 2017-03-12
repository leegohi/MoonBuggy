/**
  * Created by pc on 17/3/12.
  */
package com.ly.moonbuggy
import akka.actor.Actor
import scala.math._
class MBServer() extends Actor {
    def predictPosition(id:String,x:Double,y:Double,angle:Double,speed:Double):Unit={//print the cars current position and the predict position 
        printf("current_position:{id:%s,x:%s,y:%s,direction:%s,speed:%s}\n",id,x,y,angle,speed)
        printf("predict_position:{id:%s,x:%s,y:%s,direction:%s,speed:%s}\n",id,x+speed*2*cos(angle.toDouble/180*Pi),y+speed*2*sin(angle.toDouble/180*Pi),angle,speed)
        Thread.sleep(500)
    }

     def receive={//recieve the message from cars
        case MBMessage(id,x,y,angle,speed) =>predictPosition(id,x,y,angle,speed)
        case StartServer  => println("Server Start Success!")
     }
}
