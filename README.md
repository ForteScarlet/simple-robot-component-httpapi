# 基于simple-robot与CQ HTTP API插件的Java开发框架
[![](https://img.shields.io/badge/simple--robot-core-green)](https://github.com/ForteScarlet/simple-robot-core)  [![img](https://camo.githubusercontent.com/f8464f5d605886b8369ab6daf28d7130a72fd80e/68747470733a2f2f696d672e736869656c64732e696f2f6d6176656e2d63656e7472616c2f762f696f2e6769746875622e466f727465536361726c65742f73696d706c652d726f626f742d636f7265)](https://search.maven.org/artifact/io.github.ForteScarlet/simple-robot-core) [![](https://img.shields.io/maven-central/v/io.github.ForteScarlet.simple-robot-core/component-forhttpapi)](https://search.maven.org/artifact/io.github.ForteScarlet.simple-robot-core/component-forhttpapi)  [![](https://img.shields.io/badge/%E7%9C%8B%E4%BA%91%E6%96%87%E6%A1%A3-doc-green)](https://www.kancloud.cn/forte-scarlet/simple-coolq-doc)

> 如果需要获得更好的阅读体验，请前往 [原文档](https://www.kancloud.cn/forte-scarlet/simple-coolq-doc/) -> `组件-酷Q-HTTP TO CQ` -> `快速开始` 处阅读
> 或尝试直接进入[快速开始](https://www.kancloud.cn/forte-scarlet/simple-coolq-doc/1519392)



# 快速开始

*****

<br>


## 一、**安装**

### 1\. **下载并安装 酷Q**

前往酷Q[官方下载地址](https://cqp.cc/t/23253)下载酷Q应用，并安装（启动一次），然后关闭。

<br>


### 2\. **下载并安装 HTTP TO CQ插件**

**①.** 前往`HTTP TO CQ`的 [releases ](https://github.com/Hstb1230/http-to-cq/releases) 下载最新版本。

**②.** 将下载好的`.cpk`格式文件移动至`酷Q`根目录下的`/app`文件夹下。

**③.** 启动一次酷Q程序，右键酷Q标志，选择：`应用 > 应用管理`，如图所示：
![](https://i.vgy.me/QpgBpK.png)

然后将会出现应用管理界面，选择HTTP API插件并选择启用，如图所示：
![](https://i.vgy.me/sYqhOi.png)

>[success] HTTP TO CQ插件自带UI，对于新手来说还是比较友好的。其配置UI图例如图：

![](https://i.vgy.me/G45hO5.png)  ![](https://i.vgy.me/QhZNuf.png)  ![](https://i.vgy.me/Q5ZiHw.png)

### 3\. **创建Java项目**

你可以使用一切支持的方式来自动构建项目，以下将会举几个例子：

>[info] 版本号请自行替换为 Maven仓库中的最新版本：[![](https://img.shields.io/maven-central/v/io.github.ForteScarlet.simple-robot-core/component-forhttpapi)](https://search.maven.org/artifact/io.github.ForteScarlet.simple-robot-core/component-forhttpapi)

#### **①. Maven**

```xml
<dependency>
  <groupId>io.github.ForteScarlet.simple-robot-core</groupId>
  <artifactId>component-forhttpapi</artifactId>
  <version>${version}</version>
</dependency>
```

#### **②. Gradle**

```
implementation 'io.github.ForteScarlet.simple-robot-core:component-forhttpapi:${version}'
```

#### **③. Grape**

```
@Grapes(
  @Grab(group='io.github.ForteScarlet.simple-robot-core', module='component-forhttpapi', version='${version}')
)
)
```

## **二. 使用**

## **4\. 配置**

有两个地方需要你进行配置：

* **酷Q的`HTTP TO CQ`**
* **你需要启动的Java程序**

从Java的配置开始吧。

>[warning] 由于目前文件配置尚比较繁琐，便暂时先只介绍代码配置的方式。如果对目前的较为繁琐的文件配置有兴趣，请在了解代码配置的情况下查看 [文件配置方式](./CQHTTPAPI%E6%96%87%E4%BB%B6%E9%85%8D%E7%BD%AE.md)

首先，创建一个类，实现`com.forte.qqrobot.component.forhttpapi.HttpApp`接口，并实现接口中的`before`与`after`方法。

>[info] 现在假定你这个类叫做 **`RunApp**` , 方便后续的代称。当然，它实际上叫做什么都无所谓。

可以发现，`before`方法中存在一个叫做`HttpConfiguration`的参数，我们就要通过这个参数对象进行配置。
以下我将会列举**最常见的**几项配置信息，而全面的配置可选项请查看[核心通用配置](./%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6.md) 与 [组件额外配置](./%E7%BB%84%E4%BB%B6CoolQ%20HTTP%20API%E9%85%8D%E7%BD%AE.md)

关于HTTP TO CQ的配置与Java程序的配置信息，我简单画了这么一个对应关系图：
![](https://i.vgy.me/qFcc0V.png)

>[danger] 千万别忘了写端口号！ 插件的提交地址的默认值并没有写端口号，这是个坑

## **5\. 运行**

历尽千辛万苦，终于到了这一步。
首先，新建一个`main`方法在任意地方。
写下以下代码，并且别忘了那个`RunApp`实际上代表了什么：

```java
HttpApplication application = new HttpApplication();
// 启动
application.run(new RunApp());
```

>[success] 如果这时候一看到控制台所输出的日志中最终出现了你的机器人的一些信息，那么恭喜，这说明你已经发送、获取、设置消息了。

那么能不能监听到消息呢？写一些代码来测试一下吧。

## **6\. 第一个监听器**

### **①. 新建一个类**

>[info] 尽量在`RunApp`的同级目录或者子级目录下创建。
> 创建好之后，在这个类上标注一个注解：`@com.forte.qqrobot.anno.depend.Beans`, 即`@Beans`

### **②. 写一个监听私信的方法**

我们写一个监听私信消息满足正则：`hello.*`的私信消息监听函数，且当我们收到消息后，复读。
完整代码如下：

```java
@Beans
public class TestListener {

    @Listen(MsgGetTypes.privateMsg)
    @Filter("hello.*")
    public void testListen1(PrivateMsg msg, MsgSender sender) {
        System.out.println(msg);
        // 以下三种方法均可
，效果相同
        sender.SENDER.sendPrivateMsg(msg, msg.getMsg());
//        sender.SENDER.sendPrivateMsg(msg.getQQ(), msg.getMsg());
//        sender.SENDER.sendPrivateMsg(msg.getQQCode(), msg.getMsg());
    }
}
```

### **③. 在来一次**

这次我们再启动一次，如果发现启动日志中成功加载了这个监听函数，那就试着给你的机器人发送一句`hello world`吧。
如果它也回复了你一句`hello world`，那么说明至此你已经成功了，探索文档所提供的众多功能并实现你的机器人吧~

## **7\. 失败了？**

如果跟着上述流程完整无误的操作却无法成功，也不要气馁，尝试根据[常见问题汇总](./%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98%E6%B1%87%E6%80%BB.md)进行排查或者加入QQ群`782930037`进行咨询。