##一.程序入口类

MarsRover 通过 receiveCmd() 接收整体指令并直接返回结果。

##二.测试入口

MarsRoverTest 通过 testReceiveCmd() 确认题目中的用例可以获得正确的返回



##三.tasking（原始）

####1.输入合法位置后 输入一个M指令 返回下一个正确位置

####2.输入合法位置后 输入一个L指令 返回下一个正确位置

####3.输入合法位置后 输入一个R指令 返回下一个正确位置

####4.验证从不同的方向开始M，L,R均可以获得正确的位置

####5.输入合法位置后 输入多个LMR组合指令 返回正确位置

####6.输入一个地图数据，能正确检查给定的坐标是否超过边界。

####7.输入一个地图数据和小车起始位置，执行一组产生越界的指令会提示已经越界，并进行地图标识

####8.输入一个地图数据和小车起始位置，初始化一个会发生过RIP的地方 验证执行危险指令会跳过该指令

####9.验证发送多个火星车的情况，后面小车会使用前面地图RIP信息避过风险

####10.验证解析一个多行命令包括地图命令行输入，小车坐标输入，小车指令外部输入成功解析的情况。



##四.重构过程

####1.将编写在Car中的对于LMR四个指令的执行过程抽象到具体的CarAction类中独立处理

####2.将对应关于每个动作的单一指令的测试用例迁移到对应的CarActionTest测试类中完成

####3.将原先在marsrover中对于地图坐标解析交给MarsMap，对于小车启动坐标的解析交给Position.

