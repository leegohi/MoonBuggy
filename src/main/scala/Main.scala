/**
  * Created by pc on 17/3/12.
  */
package com.ly.moonbuggy
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorRef
import scala.io.Source
import scala.collection.mutable.Map
object Main {
  def main(args: Array[String]): Unit = {
    val lines=Source.fromFile("routes.csv").getLines().toList
    val cars=new Array[Array[String]](lines.length)
    for(i <- 0 to lines.length-1){
        cars(i)=lines(i).split(",")
    }
    val sys=ActorSystem("MoonBuggy")
    val server=sys.actorOf(Props[MBServer],name = "server")
    val clients=new Array[ActorRef](cars.length)
    for(i <- 0 to cars.length-1){
        clients(i)=sys.actorOf(Props(new MBClient((cars(i)(0),cars(i)(1).toInt,cars(i)(2).toInt,cars(i)(3).toInt,cars(i)(4).toInt),server)),name=cars(i)(0))
        clients(i) ! StartClient
    }
    server ! StartServer


  }
}
