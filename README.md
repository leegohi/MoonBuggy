#MoonBuggy

程序设计思路：

一个Server端，5个Client端，也即是5辆月球车，整个系统通过akka实现

#消息定义

case object  StartServer extends Message

定义启动服务端消息

case object  StartClient extends Message

定义启动cars消息

case class MBMessage(id:String,x:Double,y:Double,angle:Double,speed:Double) extends  Message

定义cars发送给控制中心的消息

#路径定义

为CSV格式

carID，x坐标，y坐标，转向角度，车速(m/s)

例如：car1,10,20,30,1

#启动程序

cd进入MoonBuggy目录下

>sbt

>compile

>run


#其他

程序启动会读取route.csv，此文件包含cars初始路径，后续将会持续运行15min，car后续路径随机生成。
 

