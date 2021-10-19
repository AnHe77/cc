# 基于Android的生活助手APP的设计与实现

# 摘  要

随着移动互联网的高速发展，Android操作系统在移动设备中地位已经被牢牢稳固。然而大量的Android设备高速普及过程中，与其配套的Android应用的开发速度和项目质量极为令人担忧。本课题的研究目的是通过114生活助手系统的开发，寻找Android应用快速迭代开发和高质量保证的开发方式。

在课题的研究过程中，通过对114生活助手系统的开发。实现了手机端的交通信息查询，建立了简易的在线交易市场，并实现了一套基于位置的周边信息查询系统。在开发的过程当中寻找和发现实现Android应用快速开发和高质量保证的技术和方法。在整个的课题研究过程中，尝试采用了众多最新的开源框架技术。这些技术包括EventBus、AndroidAnnotation、Robobinding、picasso、bolts、gson。并且采用了Android官方以及Android社区中普遍认同的最佳实践模式。这些模式包括大量使用Fragment实现解耦、使用Genymotion进行项目调试、等等。

在课题研究的最后阶段，发现采用这些最新的开源框架技术和这些新颖的实践模式，大大加快了过去原有的Android开发速度。同时保证了项目的质量。在各个模块之间的耦合也比按照原有开发模式有了巨大的提升。

**关键词**：生活助手；android；依赖注入

# ABSTRACT

With the high-speed development of mobile Internet, the Android operating system status in the mobile devices has been firmly.A large number of Android devices appear. However, Android application development speed and quality is very bad.It make us very worry.For example,in the application market, the application like LifeAssistant always are bad.They are bad performance,ugly design,information wrong.this research purpose is to find the way to make the Android application development more efficient.

In the research progress , we find the way to Improve the quality and speed for the android application development by develop the 114 life assistant.In the project,i try to use some newest open source project.like EventBus、AndroidAnnotation、Robobinding、picasso、bolts、gson.And i have try to use the best practise which has been proposed in the Android official and Android community.these best practise include use fragment to decouping and use Genymotion to debug.

In the end of the research,it is be proved that use these open source project and best practise will greatly improve the develpoment of the android application.And make the application high quality.

**Key words**:LifeAssistant; Android ;DependencyInjection

# 第一章 绪论

随着移动互联网的井喷式爆发，自从2008年推出第一款Android手机之后，Android操作系统以一种不可思议的速度不断的快速成长着。目前每天都有上百万部的Andorid手机被第一次激活，每月亿万次的App被下载。Android操作系统已经成为当今发展最快的移动设备操作系统。其设备的覆盖已经不仅仅只是手机。随着最新的Android5.0的推出，Android操作系统已经可以在手机、平板、电视、可穿戴设备、汽车上面运行。这些的成就都归功于Google公司和众多厂商的支持。然而在这个技术井喷的背景下面，Android开发的技术要求也越来越高，项目也变的越来越复杂。为了能够更好的支持最新版本的操作系统，为了能够在众多不同尺寸，不同分辨率屏幕上面表现优异。开发者需要付出更多的精力和成本。

本课题的研究目的就是，通过针对114生活助手的系统开发，寻找研究Android的快速高效的开发方式。在本课题中将会采用最新的开源项目，这些项目都是专门针对Android系统设计，目的是简化众多Android开发中的繁琐的过程，提高开发效率，简化代码的耦合性。同时将会根据Google官方最新提供的开发指南以及Android开发社区中最新流行，并被证明有效的最佳实践方式进行项目的开发。这些框架和方式并没有被普遍的证明是行之有效的，或者是万能的。在课题的研究过程中，将会通过114生活助手这个项目本身检验这些方法，这些项目是否是真实有用。

该课题的研究过程当中，将会采用Android最新的开发技术。其包括使用Gradle进行项目的编译和打包，使用AndroidStudio替代Eclipse开发，使用Genymotion作为调试用的虚拟机。并且在开发中将会使用git作为版本管理工具，记录开发的所有历史记录。在涉及的开源项目当中，将会使用到AndroidAnnotation，Gson，Picasso，Bolts，EventBus，ApacheCommons这些开源项目。这些项目有的是专门针对Andorid的框架，有的则是针对Java的框架。使用它们的目的在于尽最大的可能简化项目的开发过程。

## 1.1 安卓应用开发的目前现状

如今，世界上的190多个国家当中运行着数以亿计的Android设备。他已经成为被安装最多并且成长速度最快的移动操作系统。每天都有百万的用户第一次开启他的Android设备并寻找应用和游戏。Android为开发者提供了一个可以为全世界所有人提供应用和游戏的开发平台。这个基于Linux的开源操作系统，拥有超过300家的硬件，软件，运营合作伙伴[1]。Android的开源政策也广受开发者和用户的喜爱。这也直接促进了Android应用的大量需求。Android用户每月从Google Play中下载超过1.5亿的应用。在这些背景的驱使下，Android持续不断地推出最新的硬件和软件，为开发者和用户提供最新的功能。

在最近的Google IO大会上，Google推出了他最新的Android操作系统－Android 5.0 Lollipop。这个版本的操作系统为开发者提供了数以千计的最新的API。他适用于所有的Android设备，包括手机、平板、电视、可穿戴设备、汽车。在Android5.0当中，使用最新的ART虚拟机替代了原先的Dalvik虚拟机[2]。ART虚拟机实现了AOT，大大增强了GC的性能，提高了应用的调试能力。Android5.0还带来了最新的Material设计以及配套的一系列开发工具。这使得开发UI更加的方便和高效。最新的3D技术使得你可以更容易的开发出实时阴影这样的效果。最新的RenderThread线程使得你可以更加平滑的运行应用的动画效果。

然而在这些新技术层出不穷的背后，是开发者技术的止步不前。最新最好的技术不断的出现，但是开发者却依旧停留在过去的开发模式当中。这些老的模式造成了开发效率的不断降低，开发质量的不断恶化，项目进度的不断推迟。同时由于Android的高速发展，其碎片化带来的问题使得Android的开发难度不断的增大。不同版本的操作系统，不通尺寸和分辨率的屏幕，不同类型的设备。这些由于高速发展带来的问题导致了Android开发的难度不断增大[3]。

以Android的操作系统为例，目前市场上普遍存在10个以上的不同版本的Android核心版本。其占有率如表1-1和图1-1所示。4.0以上的版本已经占据安卓设备的80%以上。而另外的份额依旧被3.0以下的份额所占据。而最新推出的Android5.0操作系统，所占据的份额不到10%[4]。

| Vesion      | Codename    | API  | Distribution |
| ----------- | ----------- | ---- | ------------ |
| 2.2         | Froyo       | 8    | 0.4%         |
| 2.3.3-2.3.7 | Gingerbread | 10   | 6.4%         |
| 4.0.3-4.0.4 | Ice Cream   | 15   | 5.7%         |
| 4.1.x       | Jelly Bean  | 16   | 16.5%        |
| 4.2.x       |             | 17   | 18.6%        |
| 4.3         |             | 18   | 5.6%         |
| 4.4         | KitKat      | 19   | 41.4%        |
| 5.0         | Lollipop    | 21   | 5.0%         |
| 5.1         |             | 22   | 0.4%         |

![](http://www.writebug.com/myres/static/uploads/2021/10/19/e00658de6164916c0b5b5e400be72837.writebug)

另外一方面，Android设备的尺寸跨度非常巨大。如表1-2，图1-2所示，适配一款Android应用需要考虑的屏幕尺寸大小需要分为small、normal、large、Xlarge四种。而分辨率则需要分为ldpi、mdpi、hdpi、xhdpi、xxhdpi六种。而大屏和高分辨率正在变为市场的主流趋势[5]。

|        | Ldpi | Mdpi  | Hdpi  | Xhdpi | Xxhdpi | Total |
| ------ | ---- | ----- | ----- | ----- | ------ | ----- |
| Small  | 4.4% |       |       |       |        | 4.4%  |
| Normal |      | 8.1%  | 39.3% | 19.5% | 15.9%  | 82.9% |
| Large  | 0.4% | 4.8%  | 0.6%  | 0.6%  |        | 8.6%  |
| Xlarge |      | 3.2%  | 0.3%  | 0.6%  |        | 4.1%  |
| Total  | 4.8% | 16.1% | 40.2% | 20.7% | 15.9%  |       |

![](http://www.writebug.com/myres/static/uploads/2021/10/19/b76c54de99b2a1a5fec1bd48bfdce7f3.writebug)

## 1.2 本课题的研究目的和意义

生活助手类应用是Android中普遍存在的应用。用户通过该类型的应用实时获取周边信息。从衣食住行各个方面获取最及时最准确的信息。应用应当满足简单易用，高效便捷，功能强大的需求。然而由于Android系统的高速迭代，Android设备的高速发展，Android应用的开发难度也不断大增加，项目的开发进度也不断的减缓。本课题的研究目的就是，通过实现114生活助手Android系统，寻找Android的快速开发模式。确保以这样的模式，可以迅速的开发出一款Android应用，并保证其应有的质量。

课题的研究成果将是一款简单易用，功能强大，高效便捷的生活助手应用。通过他可以方便的查询当前位置的周边信息，可以方便的获取交通信息。并且可以简单的在其平台上面实现P2P的在线交易。同时更加重要的是，通过这个项目，寻找到一个快速高效开发Android应用的模式。使得原先相对复杂的Android开发模式变得简单有效。

## 1.3 本课题的研究方式和手段

课题将会通过实现一个基于Android的114生活助手来实现课题的研究目的。在114生活助手这个项目的开发过程当中，将会尝试使用最新的开源项目和普遍认同的最佳实践方式进行项目的开发。这些使用到的开源项目有：AndroidAnnotation、Robobinding、Gson、Picasso、Bolts、EventBus。而使用的最佳实践方式是根据Android官方最新的开发指南，以及Android社区中最为推崇的开发模式总结而成。这些最佳实践模式包括：使用依赖注入实现代码解偶，使用Fragment替代Activity的部分功能、使用Genymotion作为调试工具。另外在开发过程当中，将会使用最新的开发工具开发。这些最新的开发工具包括：使用Gradle进行编译和打包，使用AndroidStudio替换原来的Eclipse，使用git作为版本管理工具[6]。

# 第二章 相关技术介绍

## 2.1 开发技术的选择

Android移动操作系统是一个非常成熟的系统。在本项目当中，将会使用使用在Google 2013 IO大会上发布的最新的Android开发工具作为本项目的开发平台。本项目将使用AndroidStudio开发，在Android Srudio的第一个正式版本发布之后，其作为Android第一开发平台的地位已经被牢牢确定了。Gradle是今年最为流行了的编译工具，其在具备Maven优秀的特性的同时，引入了更多令无数开发者梦寐以求的功能。其简单的DSL脚本语言和丰富的构建方式，使得项目的编译打包过程变得无比的自然和简单。

另外在项目当中将会使用Genymotion替换Android默认的虚拟机。Genymotion是新一代的虚拟化开源项目，其采用VirtualBox作为技术支持，并采用x86核心而非arm[7]。这些种种的改变，直接决定了在调试过程中，使用Genymotion将会带来更佳快速，平滑，稳定的体验。并且Genymotion提供更为简单的基于位置的调试解决方案，其可以非常简单的设置GPS的经纬度坐标，以方便用户进行项目调试。

在项目的开发当中，除了使用最新的Android开发框架之外，还大量使用了开源框架。在这些开源项目的帮助下，项目的整体架构变得更为简单，代码的书写变得更加的灵活方便，使得项目的开发效率被大大的提升，同时质量也被大大的增高。这所有的一切都源于开源社区的支持。在接下来的章节当中，将会简单介绍一下，这些被用到的优秀开源框架。

## 2.2 相关开源框架的使用

### 2.2.1 EventBus 的使用

EventBus是由Greenrobot提供的一个用于模块间通信的工具，他可以被使用在Activity，Fragment，Service，Thread等任何组件之间，他使用方便，代码灵活。他的存在大大减少了原先用于项目模块之间的通信代码。EventBus是android平台上最佳的基于推送和订阅的消息总线框架。

如图2-1所示，消息提交者将一个事件推送给EventBus，之后EventBus将事件分发给该事件的订阅者，并回调他们的onEvent方法。EventBus的这种特性使得模块间的通信变的异常的容易，并且执行效率非常的高，使用代码非常的简单，依赖包非常的小。EventBus被超过一亿的应用使用，这些特性足以证明该框架优越性[8]。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/c6613760e0b9a9e724a233da944260e9.writebug)

同时集成使用EventBus的过程也非常的简单，因为EventBus已经在Maven核心仓库中出现了，因此可以非常容易在Maven和Gradle中使用EventBus框架。

### 2.2.2 AndroidAnnotation 的使用

AndroidAnnotation是一个开源的框架，他使得Android开发变的更加的迅捷。他使你真正关注项目的核心内容，他使得你的代码变的简洁的同时，也使得项目变的更加的易于维护。他的目标是让开发者写出易于维护的代码，他相信简单的代码就是实现该目标的最佳方法。

在过去的Android开发过程当中，开发者会不禁疑问：为什么我们总是在书写重复的代码？为什么项目变的越来越难以维护？Context和Activity这些神一样的对象，负责的线程机制，难以发现适合的API，一大堆异步的监听类，成千上万的常量。这些问题难道就没有解决方案吗？

通过使用Java的注解特性，开发者可以表达出他的意图，并让AndroidAnnotation把这些意图在编译时转换成真实的代码。以下是他所有拥有令人神往的特性。

- **依赖注入**，可以注入Views，Extras，System Service，几乎任何能想象到的东西

- **简单的线程模型**，通过注解决定该方法是被运行在UI线程还是运行在后台线程

- **事件绑定**，通过注解可以轻松的为View绑定事件，而不是过去那种丑陋的异步Listener

- **REST客户端**，只需要实现一个简单的REST接口，AndroidAnnotation就可以帮助你生成正真的REST代码[9]

![](http://www.writebug.com/myres/static/uploads/2021/10/19/a878d9441f26d5acae3aa303b17c1a0d.writebug)

### 2.2.3 Bolts 的使用

Bolts是由Parser和Facebook维护的一款Android底层的开源框架。他的出现使得Android开发变的更加容易。他是Parser和Facebook真实使用的项目，当他们在内部大规模使用之后，他们决定将其开源。贡献给大家，使得任何人都可以使用到这样的技术。使用这个框架不需要任何的Parser服务，不需要Parser和Facebook的账号支持了。

Bolts框架主要包括以下内容。

- **Tasks**：一个帮助组织管理java复杂的异步代码的工具。一个Task就像是JavaScript的Promise，但是却可以在Andorid中使用。

- **一个用于Application之间沟通通信的工具**，它用于帮助你实现应用之间的深链接[10]。

在Android项目的开发过程中，你将会需要执行众多不能运行在UI线程的复杂操作，以避免因此导致的UI线程的阻塞和等待。这意味这你需要在后台线程中运行这些程序。为了使得这个过程变得更加的简单，Bolts创建了一个名为Task的类。一个Task代表着一个异步操作。一般来说，一个Task是被作为一个方法的执行结果返回的，此刻他已经开始执行他的工作了。一个Task不是传统意义上的线程模型，他对应的是一个工作的完成，而不是工作的执行。Task相对于其他的异步编程技术有很多优势，像Callback和AsyncTask，在Task面前变得不值一提。

以下是Task的特性：

- **更少的系统资源消耗**，因为他不会为了等待其他的任务而占据某个线程

- 在一行代码当中使用多个Task**，不会像你使用Callback时那样造成代码量的增长

- **它提供了丰富的语法**，使得你可以处理分支，并排，和错误处理这些需求。而不需要像过去那样写出像意大利面一样层层叠叠的代码

- **还可以用Task的基础代码控制任务的执行顺序**，相比过去那种需要你通过多个回调接口来控制业务逻辑的方式变的无比的简洁

下图将会向你简单介绍Task的使用方式：

![](http://www.writebug.com/myres/static/uploads/2021/10/19/935fab7b2309d373ba83400761619905.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/a377ee736a75bd06310ecc94df57d9b9.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/90650f735ec104d67481a3d51a54756b.writebug)

### 2.2.4 Android 开发最实践

然而即使如此，项目的开发过程当中依旧充斥着许多令人痛苦的过程，项目会在无形之间变的越来越难以维护，项目周期变的越来越长。正因如此，非常需要一个最佳的方式指导开发者完成这些工作。以下内容总结来自于android的开发社区，也正是本项目使用的方式[11]。

概括的可以总结为以下几点：

- 使用Gradle和他推荐的项目架构

- 将密码和敏感的数据放置在gradle.properties中

- 不要使用你自己的HTTP客户端，而是使用Volley或者OkHttp开源框架

- 使用Jackson开源框架解析JSON数据

- 避免使用Guava和尽量少的使用第三方框架，因为有65k方法数的限制

- 使用Fragment来渲染UI

- 使用Activity管理Fragment

- 把XML布局文件当作代码看待，好好的管理他们

- 在XML布局文件当中避免使用过多的参数设置，而是使用style替代他们

- 使用多个style文件，而不是使用单一且庞大的一个style

- 保持你的color.xml短小简洁，仅仅只是定义调色板

- 不要直接使用深度嵌套的ViewGroups

- 使用Robolectric用于单元测试，使用Robotium进行UI测试

- 使用Genymotion作为你的虚拟机

- 经常使用ProGurad活着DexGuard

关于项目架构，目前有两种选择。使用Ant和Eclipse的项目架构，使用Gradle和AndroidStudio的项目架构[12]。你应该选择最新的项目架构，如果你使用的是老的架构，那么强烈建议你抛弃他，并且尝试最新的架构[13]。

**老的项目架构**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/7ad6f9119549f46a9a9efbc49f59d671.writebug)

**新的项目架构**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/3923ef5cdcf6da1a546bfdd0e045e00d.writebug)

# 第三章 需求分析与交互设计

基于安卓系统的114生活助手系统，在衣食住行各个方面为用户提供方便可靠的信息咨询。其主要提供的功能可以分为以下三类：

- 基于位置的周边信息

- 覆盖航空，火车，长途大巴的交通信息查询系统

- 在线交易市场。

其具体的功能又可以划分为以下几点。

## 3.1 城市选择功能

用户可以选择当前所在的城市，根据当前的城市信息，查询所需的生活信息。提供一个城市列表供用户选择，并且可以通过GPS定位到当前设备所在的城市，方便用户选择城市。城市选择用例图如3-1所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/c3b5f0803cedfeb77796fa4f3c810679.writebug)

## 3.2 查询医疗信息功能

用户可以查询到当前选择城市的相关医疗信息。这些信息主要包括周边的医院的地址，电话，介绍。通过这些信息为用户提供医疗服务。用户还可以添加相关的医疗信息，以丰富数据。其用例图如图3-2所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/e045311085f2d8eeb74075419b98d9cd.writebug)

## 3.3 查询交通信息功能

用户可以查询当前的实时航班信息，查询到12306的实时火车票信息，查询到长途大巴票的信息。根据这些信息为用户提供出行指南。其用例图如图3-3所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/2596033cf70f23f7acd2133b403249d0.writebug)

## 3.4 查询酒店信息功能

用户可以根据当前所在的城市，查询周边的酒店信息。这些信息主要包括酒店的地址，电话，介绍。通过这些信息用户可以随时找到合适的酒店安顿下来。当然，用户还可以添加相关的酒店信息，以丰富数据。其用例图如图3-4所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/db76e944be51cdeba85463769bbd6860.writebug)

## 3.5 用户身份验证功能

用户可以登录到手机程序，如果用户没有该程序的账号，用户还可以注册一个新的账号。当用户成功进行身份验证之后，用户便可以添加新的信息，并可以根据用户的权限管理信息。其用例图如图3-5所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/a0f3a9487ae0f46d10c1cd0ef2e7f823.writebug)

## 3.6 查询餐饮信息功能

用户可以根据当前所在的城市，查询周边的餐馆和美食信息。这些信息主要包括餐馆的地址，电话，介绍。通过这些信息满足用户对于食物和美食的需求。当然，用户还可以添加相关的餐饮信息，以丰富数据。 其用例图如图3-6所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/051a09242771eecf03fd7a5914e18ed2.writebug)

## 3.7 在线市场交易功能

用户可以游览在线市场当中的商品信息。这些信息包括商品的价格，介绍，图等。如果用户需要其中的某一件商品则可以通过线下联系的方式进行交易。当然，用户也可以发布自己的商品信息。从而形成P2P的在线交易市场。当然，管理员身份的用户可以审核这些信息，并对其进行管理。其用例图如图3-7所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/8bbebdad9a1e73cbc43e1b843ec37293.writebug)

## 3.8 查询家政服务功能

用户可以根据当前所在的城市，查询到关于清洁工，月嫂，搬家公司的信息。通过这些信息用户可以获取到自己所需要的服务。当然，如果用户是相关业务的从业者，也可以在程序当中发布自己的信息。其用例图如图3-8所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/88b75264a87c891f7ffd186ece119c5d.writebug)

# 第四章 架构设计与实现

## 4.1 整体架构设计

系统的整体架构分为三层，如图4-1所示，分别有Activity，Fragment，Model实现。这样的层次划分，降低了如图4-2所示的系统架构。这种过去将大量的业务逻辑全部封装在Actvitiy中的实现方式导致的项目臃肿，不易维护，大量重复代码的问题。其中Activity主要负责封装一整套的业务逻辑（例如：和交通信息相关的所有业务逻辑），同时负责管理和维护Frament的生命周期。而Fragment则负责具体的某个业务逻辑的实现。而Model则是真正负责实现该业务逻辑的具体代码。

**本项目采用的架构**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/67bb10b67f34be0874a67d8f11b543c4.writebug)

**大量Android项目中采用的架构**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/7da747d6727e166e04d053d6b058dc60.writebug)

正如上面所说一个模块是由一个Activity和若干Fragment构成。真正的业务逻辑由Fragment实现。而Actvitiy作为这些Fragment的容器和Manger。如图4-3所示，若干Activity构成了整个应用的功能模块，而每个Activity由若干Fragment构成。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/042177809d7677568bfca963840a3565.writebug)

而在Android3.0之前，系统的功能实现只能由单个Activity实现，众多的Activity组合成一个模块，就如图4-4所示。这种架构的实现方式的缺点在于，Activity之间的通信方式非常困难。同时也不利于程序代码的解耦工作。使用Fragment后的程序架构不仅变的更佳清晰，也有利于后期适配不同尺寸的工作。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/5ca67f03c7a08240fec3ba51d97136ae.writebug)

而各个Fragment的具体业务逻辑又由相应的BusinessModel，ServiceModel，PersistModel实现。就如图4-5所示，若干Model支撑着Fragment的具体实现。在这些Model中，ServiceModel主要负责与服务器对通信。PersistModel主要负责数据持续化的工作。BusinessModel主要负责专业的业务逻辑的工作。这些模块之间相互配合，相互调用，最终使得Fagment可以正常使用。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/aaf3852028e620bdb9ba1b996fb57b1b.writebug)

## 4.2 模块之间的通信方式

### 4.2.1 Activity 之间的通信

而在这样的架构当中，其模块之间的通信又和传统的开发模式有所不同。在原有的完全基于Activity的架构当中，其模块之间通信如图4-6所示，Activity之间通过Intent通信，通过Bundler传递数据。采用StartActivityForResult和OnActivityResult实现代码回调。这样的方式，在开发过程当中非常不便，代码不易阅读和维护。而在本项目当中使用的是如图4-7所示的通信方式。直接通过BusinessModel调用打开Activity，而在调用BusinessModel的同时，直接将数据以方法参数的形式间接传递给Activity。之后又通过Bolts框架的异步回调，实现Activity的异步回调。这样的通信架构设计解决了Activity与Activity之间原本糟糕的通信方式。

**大量项目采用的通信方式**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/f4643d3ff51c2f6d9118d1db68c38ac7.writebug)

**大量项目采用的通信方式**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/6d5d01bb9350c47b00745528f92e8715.writebug)

### 4.2.2 Fragment 之间的通信

由于Fragment本身的设计相对于Activity来说要更加容易实现模块间通信。在本项目当中采用了构造者的设计模式，将需要传入的数据传递给Builder，并把回调接口也传递给Builder。之后再调用create方法，生成Fragment。也就是说，Fragment使用了直接传值和回调接口的方式实现了模块通信。当然最后依旧使用BusinessModel对这些过程进行分装。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/abb71a7c64bc8ff2ae1fc52285ba1a8d.writebug)

### 4.2.3 其他模块之间的通信

对于其他模块的通信主要分为同步通信和异步通信。而在这其中主要将会遇到的问题是异步通信。目前大多的应用采用的都是AsyncTask或者在方法中传递回调接口的方式实现异步通信。但两者的代码都会造成代码的臃肿和维护的苦难。在本项目当中采用的是Bolts的框架，通过该框架实现了优美的异步通信通信模式。

## 4.3 业务模块的划分

整个系统分为以下5个模块。如图4-9所示。

- **功能导航**：实现应用的首页，为用户提供功能导航

- **POI模块**：提供周边信息的检索，管理相应的周边信息

- **交通信息模块**：提供长途大巴，飞机票，火车票信息的检索

- P2P模块**：提供在线交易市场的信息检索与管理

- **通用组件模块**：提供供其他模块使用的的通用模块，包括：城市选择、日期选择、通知弹出、公告信息、用户身份验证

![](http://www.writebug.com/myres/static/uploads/2021/10/19/a12f4598470e0a416844e49546a78ff0.writebug)

## 4.4 服务端的实现方式

在本项目的实现当中，服务端的数据主要分为三大类。如图4-10所示，分为第三方WebService、项目Service、虚拟Service。其中WebService使用的是聚合网的云服务和百度的LBS云服务，通过链接他们的API，获取与周边信息，交通信息相关的全网数据。项目Service，采用的是LeanClound和qiniu的云服务支持。其提供的是项目自身产生的数据，包括用户信息，P2P信息等。虚拟Service，则主要是用于项目调试使用的虚拟服务器。他是一个离线的伪服务器，通过他，在开发过程中可以抛弃服务端而直接进行开发，减少了与服务端的耦合。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/6593b26d02e250c3ba5476e3716edc93.writebug)

在选择选择云服务的过程当中，主要考虑的内容有以下几点：

- 是否能够提供全面准确的数据

- API接口是否足够简单易用

- 访问速度是否足够理想

- 是否收费

聚合网云服务和百度的LBS云服务，很显然满足以上要求。聚合网拥有千量级别的海量数据，数据类型富含数百种。其中与生活服务相关等数据占据了数十种。另外除了提供封装完好的SDK之外，还提供获取json、xml、jsonp数据类型的API。其数据的丰富程度和稳定性都另人满意。百度的LBS云服务，基于百度多年的数据积累。数据的丰富程度非常令人满意，唯独遗憾的事情是，百度的API接口不是非常完善，很多数据没有办法获取。但是，对于本项目而言已经足够。

LeanClound的云服务，是一个paas的云服务系统。他过去的称呼是AvosClound，后改名为LeanClound。他为开发者提供了非常简单的API接口，使得开发者可以非常简单方便的为移动客户端提供数据的管理。而qiniu云服务则为本项目提供了一个云图床的服务。通过qiniu云服务，大大简化了项目在图片上传下载处理的技术瓶颈。本项目选择这些云服务的一个主要的考虑因素在于，Android客户端的开发过程往往是需要与远程服务器配合的。但是大量的项目证明，完全建立自己的服务器是完全没有必要的。重复造轮子的过程将会大大增加项目的复杂程度，降低项目的质量，延长项目的周期。而这些云服务技术，为Android开发者提供了最为简单和高效的服务端的技术。

## 4.5 数据持续化的实现方式

在本项目当中，除了需要使用到网络数据之外，还需要使用到部分离线数据。这些数据都统一由持续化层来实现。如图4-11所示，本项目提供的持续化模块主要有以下这些。他们的工作就是通过代码的封装，将原本对于File和SharedPreferences的操作封装起来。为上层模块提供简单明了的API服务。在过去的项目当中，该层次的代码，往往被简易的放置在Actviity当中，这样的做法直接导致了离线数据的管理混乱和使用不便。时常会出现由于代码遗留的问题导致相同类型的数据被多次存放，或被错误存放。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/ad19c13e08878329d5251895967d7f37.writebug)

下面举例来说明数据持续化层的实现方式。在本项目当中UserPersisit主要负责存放和用户信息相关的数据。其背后的实现使用的是SharedPreferences。通过存储USER_NAME、USER_ID、USER_ICON三个字段来持续化用户的信息。

LocationPersist主要存放和位置相关的数据。其背后的实现使用的是SharedPreferences和File文件系统。通过SharedPreferences存储的是当前选择的城市，而File系统存储的是城市列表的json数据。

# 第五章 各个功能模块的具体实现

## 5.1 功能导航页面的实现

功能导航页作为程序的首页，负责引导用户前往其他功能模块。他由HomeActivity及其一系列模块组成。其中负责界面UI显示的有fragment_home.xml,fragment_arround.xml,fragment_life.xml,fragment_personal。其中fragment_home.xml只包含一个Tab和一个Pager。他们组成了一个fragment的容器，继而形成了当前的布局。而另外三个布局文件，则真正负责功能导航。在程序运行的过程中，ArroundFragment会加载fragment_arround.xml，LifeFragment会加载fragment_life.xml，PersonalFragment会加载fragment_personal.xml。而HomeFragment则会加载home_fragment，并将ArroundFragment，LifeFragment，PersonalFragment加载到容器当中。其关系如图5-1所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/de5c2b11672981d9974c80e0d2e79529.writebug)

值得注意的是，HomeFragment使用的Tab是一个第三方的开源框架。该框架简化了原Tab与Pager之间繁琐的设置，并且提供丰富的API设置，帮助开发者方便的设置Tab的细节。这些细节包括，Tab的字体风格，Tab区块的风格，Tab滑块的风格。最最重要的是，该框架的使用，使得原先50多行的代码被缩减到了10行。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/256a47fc3e6002dade7224bd5d0e672a.writebug)

HomeFragmnet除了负责作为Fragment的容器之外，其也要负责用户对当前城市的选择。这段代码被放置在了对Toolbar的设置当中。Toolbar是Android5.0最新引入的特性，他的作用是替代原先ActionBar的作用。但是他比ActionBar更加灵活丰富。

在ArroundFragment、LifeFragment、PersonalFragmnet中真正负责导航的逻辑由各个Model模块负责，例如说，P2PBusiness负责根据特定参数，跳转到P2PActivity。其中的关系如图5-3所示。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/72e4031f38415e4afd026d9a4ca95b0a.writebug)

功能导航模块对应的Activity为HomeActivity，其主要由HomeFragment，ArroundFragment、LifeFragment、PersonalFragment组成。HomeFragment实现了一个带有Tabs和Pager的Fragment，其通过包含另外三个Fragment实现功能导航。

而ArroundFragment主要负责的是周边信息的功能导航。他的业务逻辑主要由POIBusiness，LocationBusiness，TopInfoBusiness实现。它们分别负责POI的业务逻辑，定位业务逻辑，公告信息的业务逻辑。

LifeFragment主要负责生活信息的功能导航。其主要的业务逻辑又由LocationBusiness，TrafficBusiness，POIBusiness，P2PBusiness实现。其中TrafficBusiness主要负责交通信息查询的业务逻辑，P2PBusiness主要负责在线交易市场的业务逻辑。

PersonalFragment主要负责个人信息的功能导航。但他的业务逻辑主要由UserInfoBusiness，AuthenticateBusiness，P2PBusiness，POIBusiness，NoticeInfoBusiness实现。其中UserInfoBusiness，AuthenticateBusiness主要负责用户信息和用户身份验证的业务逻辑。NoticeInfoBusiness则主要负责公关信息的业务逻辑。

## 5.2 周边信息查询的实现

周边信息查询模块的组成如图5-4和5-5所示。Fragment负责对xml中的界面渲染，同时调用POIBusiness和POIService中的方法，实现周边信息的获取和管理。在POIService中，他会负责根据当前的地理位置，和用户关注的周边信息关键字返回封装好的POI信息数据。这些数据被封装在POIResultBean当中，当Fragment获取到这些数据之后将会将这些数据渲染到界面当中。

**POI模块的实现**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/47892fe00ba97a7bde97c78aeb745f34.writebug)

**POI模块的界面组成**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/7aee59077f23e17d2846323f4ddb82c2.writebug)

值得注意的是PersonalPOIListFragment和POIListFragment，PersonalPOIDetailFragment和POIDetailFragment是继承关系。这两个特殊的Fragment除了继承了原本Fragment的特性之外，还具有对现有POI信息修改的能力。当然，普通用户只能修改自己产生的POI数据，而管理员用户可以修改所有自己产生的POI数据。正因为有了这两个Fragment，程序拥有了数据管理和审核的功能。
而在POIBusiness的具体实现当中，由于周边信息的数据主要来自两方面。一个是百度提供的LBS云服务，另外一个是本应用自产生的数据。因此在整个数据获取的算法当中，其实现逻辑是首先获取本应用自产生的数据，之后获取百度LBS云服务的数据。通过这样的算法，强化了自产数据的价值。
POI模块对应的Activity主要是POIActivity。其主要是由POIInfoListFragmnet，POIInfoDetailFragment，POIAddFragment，POIAlterFragment，PersonalPOIInfoListFragment，PersonalPOIInfoDetailFragment实现。

其中POIInfoListFragment，负责显示POI信息的列表。POIInfODetailFragment负责显示详细的POI信息。而PersonalPOIInfoListFragment和PersonalPOIInfoDetailFragment分别继承于上述两个Fragment。其显示的是当前登入用户提交的POI信息。

POIAddFragment和POIAlterFragment分别负责POI信息的添加和管理的业务逻辑。在这些Fragment的内部实现当中，分别调用了POIService，POIPersist，CameraBusiness，POIBusiness这些模块。通过他们实现服务器的访问，数据的持续化，拍照，POI的具体业务逻辑。

**查询医疗信息的完成效果**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/6280ebd4ca4cf40aa8f791ffabd42b54.writebug)

**查询酒店信息的完成效果**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/44424e4c2a14df7c8667cbcba5dfdb85.writebug)

**查询家政信息的完成效果**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/2dcec1db3e5ddcc167936237338609fb.writebug)

**查询餐饮信息的完成效果**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/1ae17cc0390b07af90321f5d99155728.writebug)

## 5.3 交通信息查询的实现

交通查询模块的组成可以通过图5-10和图5-11得知。图中TrainInfoRequestFragment负责加载fragment_train_info_request.xml，BusInfoResultFragment负责加载fragment_bus_info_request.xml，PlaneInfoRequestFragment负责加载fragment_bus_info_request.xml。而所有的xxxInfoResultFragment使用的都是layout_list.xml。

**交通查询模块的界面组成**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/418e9f40540bf5fa227cd3e8fdd23d9b.writebug)

**交通查询模块的实现**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/23b3464df631f3224442ac068a26d6f1.writebug)

而在完成界面渲染之后，xxxInfoRequestFragment通过BusBusiness，TrainBusiness，PlaneBusiness封装所要查询的交通数据的请求参数，并跳转到对应的xxxInfoResultFragment当中。而在xxxInfoResultFragment中则根据传递而来的请求参数数据，BusService，TrainService，PlaneService请求获取相应的交通信息。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/f587a48fbb3c9fb650dbe1c51c768d3f.writebug)

交通查询模块对应的Activity主要是TrafficActivity。他的业务逻辑主要由PlaneInfoRequestFragment，PlaneInfoResultFragment，TrainInfoRequestFragment，TrainInfoResultFragment，BusInfoRequestFragment，BusInfoResultFragment实现。其中xxxRequestFragment负责的是显示设置参数请求页，xxxResultFrgament负责的是显示搜索结果页。以Plane为例，PlaneInfoRequestFragment负责的是航班信息搜索参数的设置页面，PlaneInfoResultFragment负责的是航班信息搜索结果页。

在这些Fragment的背后，其业务逻辑分别是由PlaneService，BusService，TrainService，DateBusiness，LocationBuseinss实现的。其中PlaneService，BusService，TrainService负责与相应的服务器联系，请求和获取数据。DateBusiness负责选择日期。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/02e43423a03b77c304f31bf34fbc81c0.writebug)

## 5.4 自由交易市场的实现

在线交易市场的组成如图5-14和5-15所示。其中P2PListFragment负责加载fragment_p2p_list.xml，P2PDetailFragemt负责加载fragment_p2p_detail.xml，P2PAddFragment负责加载fragment_p2p_add.xml，P2PAlterFragment负责加载fragment_p2p_alter.xml。在各个Fragment加载好数据之后，将会调用P2PService和P2PBusiness获取在线交易市场的数据，并对这些数据进行管理。

**P2P模块的界面组成**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/994741e4ac656b1621a2ec899ce7c664.writebug)

**P2P模块的功能实现**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/e945937ea606f12a54f209802752f0be.writebug)

值得注意的是，PersonalP2PListFragment和P2PListFragment，PersonalP2PDetailFragment和P2PDetialFragment之间是继承关系。他们在原有父类的基础上增加了对商品数据修改的功能，正是因为这些功能的存在，用户才可以对上述的数据进行修改和管理。当然如果当前的用户是管理员用户，他可以对所有的商品数据进行修改。

在P2PService中，将会负责访问服务器，获取相关的商品数据。服务器会根据相应的请求参数返回封装好的json数据。之后P2PService将会对这些Json数据进行解析，并将其封装成为P2PItemBean返回给响应的Fragment。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/1ed3d4a58ca12b8e5b6d9f11196985f0.writebug)

在P2PBusiness中，其主要负责在各个P2P页面中相互跳转。确保这样的页面跳转能够正常的运行。并且使得原本重复出现的代码被完好的封装，减少代码的冗余程度。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/4d2831ca76d3a3d4a0649cd878d4dd24.writebug)

P2P模块对应的Activity主要是P2PActivity，其主要是由P2PInfoListFragmnet，P2PInfoDetailFragment，P2PAddFragment，P2PAlterFragment，PersonalP2PInfoListFragment，PersonalP2PInfoDetailFragment实现。
其中P2PInfoListFragment，负责显示P2P信息的列表。P2PInfODetailFragment负责显示详细的P2P信息。而PersonalP2PInfoListFragment和PersonalP2PInfoDetailFragment分别继承了上述两个Fragment。其显示的是当前登入用户提交的P2P信息。

P2PAddFragment和P2PAlterFragment分别负责P2P信息的添加和管理的业务逻辑。在这些Fragment的内部实现当中，分别调用了P2PService，P2PPersist，CameraBusiness，P2PBusiness这些模块。通过他们实现服务器的访问，数据的持续化，拍照，P2P的具体业务逻辑。

**查询商品信息的完成效果**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/8ebbd11c1e7eb1b325cd929dbab8ebe1.writebug)

**发布新的商品的完成效果**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/cd659244334a5a3a8528612f93d976ae.writebug)

**信息审查管理的完成效果**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/0d52e73a383a36bd4668396c268b7b51.writebug)

## 5.5 选择城市和GPS 定位的实现

当前选择城市模块的组成如图5-21和图5-22所示。Fragemnt首先会加载fragment_choose_city.xml，之后会通过ChooseCityhelper获取城市列表，并将其数据传递给Adapter，Adapter会将城市数据进行渲染。

**选择城市模块的界面组成**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/0c3539bf14357f7b761b721f69167bd1.writebug)

**选择城市模块的实现**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/922a479e799cd2dae81a4b3c28c02915.writebug)

值得注意的是，ChooseCityHelper所获取的数据是本地离线数据。由于城市列表数据是一个非常稳定数据。因此在程序设计之初将其写死在程序当中。通过LocationPersist获取封装城市信息的json数据。之后再使用Gson将数据解析成CityBean数据，其相关的代码见图5-23。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/0963f2a0b247a79a894f898eb25e4115.writebug)

而在程序的设计时，为了方便用户选择城市。城市选择界面采用了按照拼音首字母排列的方式。因此这给原本简单的城市选择列表的时间增加了小小的难度。为了实现该功能，我们对传递给Adapter的数据进行了处理。其中增加了style数据变量，程序将会根据该变量判断，该数据是城市数据还是字母标签数据。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/9b685bb91ba318af215dbe5b8fdcc311.writebug)

另外在选择城市页面当中，当成功选择了当前城市之后，会触发设置的回调接口，通知相应的组件，已经成功的选择了城市。该回调接口的设置是在Builder中进行的，这样的设计确保了开启ChooseCityFragment时，必定设置了Callback。继而避免了不应有的程序Bug。

另外需要关注的是定位功能的实现。本项目的定位功能采用了baidu提供的SDK，通过调用百度SDK的API获取当前设备所在的地理位置信息。使用该SDK的方法是，首先在Applicatiion中onCreate方法中初始化百度SDK的对象。之后使用LocationClient获取当前的位置信息，其相关的代码见5-25。另外图5-26是城市选择模块的完成效果图。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/3349d1372d31a83ce79e5ceb5b3b83fc.writebug)

![](http://www.writebug.com/myres/static/uploads/2021/10/19/cc936d50eb8ab19ab0d77129c31d135c.writebug)

## 5.6 日期选择的实现

选择日期模块的组成如图5-27所示，其组成部分相对简单，只有DateBusiness和DatePcikerFragment。其中DatePickerFragment负责将日期渲染日期选择界面，并提供一个回调接口供调用者获取用户选择的日期。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/76664a6a0c246cbe1728e7ca0c6a8b2c.writebug)

日期选择实际上采用的是系统默认的日期选择组件。但是区别于以往的是，在程序中没有直接使用Dialog，而是使用DialogFragment封装了该模块。这样做的目的是为实现选择时间的回调接口，同时今后如果需要使用自定义的日期选择模块，则可以在不影响其他代码的情况下，无缝切换。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/dad80661d423f857a34cc51e97592ab5.writebug)

另外，同样为了实现日期选择的异步回调。日期选择模块和城市选择模块一样使用了回调接口的方式，实现日期选择结果的返回。并且回调接口被设计必须要通过Builder设置，通过这样的方法，避免了因为使用DatePickerFragment时，没有设置Callback而导致的Bug。另外在DateBusiness则使用Bolts框架，对日期选择的操作进一步做了封装，使得调用者可以非常优雅的卸除日期选择程序的代码。

另外，在程序中提供了DateUtil程序，帮助使用者处理日期数据的格式转换的工作。其可以方便的根据日期格式的类型将数据转换成Date对象，或者将Date对象，转换成制定的日期格式。同时他还提供了获取制定日期格式的当前日期。

## 5.7 用户身份验证的实现

如图5-29,5-30示，用户身份验证模块由以下部分组成。AuthenticateFragment负责加载fragment_authenicate.xml，LoginFragment负责加载fragment_login.xml，SigninFragment负责加载fragment_signin.xml。其中fragment_authenticate的布局文件由一个tab和一个pager组成。其实现和HomeFragment一样。其目的是作为一个容器存在。

**身份验证模块的实现**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/f84513fc020f879523f68bf327d975fc.writebug)

**身份验证模块的界面组成**

![](http://www.writebug.com/myres/static/uploads/2021/10/19/516e491a0fbcda154d0f466e7d683b1f.writebug)

在LoginFragment的实现当中，其主要的业务逻辑便是加载LoginFragment和SigninFragment。与此同时，设置Pager和Tab。由于使用了PagerSlidingTabStrip。因此相关的代码变的相对简单和简洁。

在LoginFragment中，其通过与AuthenticateService的通信，来验证当前输入的用户名和密码是否正确。如果正确，则会通过回调接口的方式，将用户数据UserInfoBean返回给相关代码。在这里，回调接口的设计依旧使用了Builder的方式，目的是为了减少在使用过程由于没有设置Callback导致的Bug，其相关的代码如图在LoginFragment的实现当中，其主要的业务逻辑便是加载LoginFragment和SigninFragment。与此同时，设置Pager和Tab。由于使用了PagerSlidingTabStrip。因此相关的代码变的相对简单和简洁。

在LoginFragment中，其通过与AuthenticateService的通信，来验证当前输入的用户名和密码是否正确。如果正确，则会通过回调接口的方式，将用户数据UserInfoBean返回给相关代码。在这里，回调接口的设计依旧使用了Builder的方式，目的是为了减少在使用过程由于没有设置Callback导致的Bug，其相关的代码如图5-31。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/591754490737892a452d47763f9cb4d7.writebug)

在SiginFragment中，其通过与AuthenticateService的通信，根据输入的用户名和密码注册新的用户。如果注册成功，则会通过回调接口的方式，将用户数据UserInfoBean返回给相关代码。在这里，回调接口的设计依旧使用了Builder的方式，目的是为了减少在使用过程由于没有设置Callback导致的Bug。

在AuthenticateBusiness中，程序提供了判断当前是否处于登入状态，如果除了查询登入状态还提供了获取当前登入用户的用户信息的接口。值得注意的是这些信息是通过persisit模块持续缓存在程序当中的。图5-32是用户验证模块完成的效果图。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/8c34fda1382a99fbc8e596e86a84af01.writebug)

## 5.8 公告信息的实现

图5-33是应用公告信息的实现。其实现方式非常的简单，由NotifeInfoFragmet加载fragment_notife_info.xml。然后Frgament再通过NotifeInfoBusiness获取相关的数据，并将数据渲染到界面当中去。其中NotifeInfoBusiness所获取的数据来自Persist的离线数据，该数据是被缓存在应用当中的。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/bff2175e42d69ff955c09350d493fe66.writebug)

如图5-34所示，十大旅游景点由如下模块组成。其中TenTopSpotsFragmet负责加载layout_list.xml，之后通过TenTopSpotsBusiness获取相关的数据。并将数据传递给Adapter，由其渲染到界面当中。其中TenSpotsBusines获取的数据是由Persist离线数据获得的，中间经过了json解析的步骤。

![](http://www.writebug.com/myres/static/uploads/2021/10/19/e7575e027effdeb55068ebbab2ca9128.writebug)

# 第六章 测试

## 6.1 测试方法

本项目当中，将主要使用黑盒测试的方法对项目进行测试。黑盒测试是软件测试中普遍采用的一种方法。通过该方法对项目进行测试时，并不需要了解项目的内部结构和具体的实现方式。测试者所需要做的事情就是，根据测试用例的指导，对项目进行操作。并根据运行的结果，以及项目的文档判断该测试是否符合软件的要求。

## 6.2 测试用例

以下表格是各个功能模块的测试用例。其中表6-1负责对城市选择模块进行测试。表6-2、表6-4、表6-5、表6-10分别是对周边信息查询模块的功能测试。表6-3是对交通信息查询模块的测试。表6-6、表6-7、表6-9是对现在交易市场模块的测试。表6-8是对用户身份验证模块的测试。

**定位到当前城市测试用例**

| 用例名称 | 定位到当前城市                                  |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_001                            |
| 测试要点 | 通过gps定位和城市列表选择当前城市                       |
| 操作步骤 | 1. 打开程序，进入首页  2. 点击ActionBar的城市按钮，跳转到选择城市页面  3. 选择目标城市，跳转回首页。 |
| 期望结果 | 成功选择了当前所在城市                              |
| 实际结果 | 成功选择了当前所在城市                              |

**查询医疗信息测试用例**

| 用例名称 | 查询医疗信息                                   |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_002                            |
| 测试要点 | 更具当前选择的城市，查询周边的医疗信息                      |
| 操作步骤 | 1. 打开程序，进入首页的周边信息页  2.点击周边查询的医疗按钮  3.跳转到医疗信息页面，显示周边的医疗信息 |
| 期望结果 | 能够查询到周边的医疗信息                             |
| 实际结果 | 能够查询到周边的医疗信息                             |

**查询交通信息测试用例**

| 用例名称 | 查询交通信息                                   |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_003                            |
| 测试要点 | 查询到交通信息的实时信息                             |
| 操作步骤 | 1. 打开程序，进入首页的生活信息页  2. 点击交通查询的飞机，火车，大巴按钮  3. 跳转到请求数据设置页，设置请求参数，点击查询  4. 跳转到交通信息查询结果页 |
| 期望结果 | 能够航班、火车、长途大巴的实时信息                        |
| 实际结果 | 能够航班、火车、长途大巴的实时信息                        |

**查询酒店信息测试用例**

| 用例名称 | 查询酒店信息                                   |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_004                            |
| 测试要点 | 查询到周边的酒店信息                               |
| 操作步骤 | 1. 打开程序，进入首页的周边信息页  2. 点击周边查询的酒店按钮  3. 跳转到酒店信息页，显示周边的酒店信息 |
| 期望结果 | 查看到当前选择城市的酒店信息                           |
| 实际结果 | 查看到当前选择城市的酒店信息                           |

**查询家政信息测试用例**

| 用例名称 | 查询家政信息                                   |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_005                            |
| 测试要点 | 查询到月嫂、清洁、搬家公的家政信息                        |
| 操作步骤 | 1. 打开程序，进入首页的生活信息页  2. 点击家政服务的搬家，月嫂，保洁按钮  3. 跳转到家政信息页，示周边的家政信息 |
| 期望结果 | 能够查询到当前选择城市的月嫂公司、清洁公司、搬家公司的信息            |
| 实际结果 | 能够查询到当前选择城市的月嫂公司、清洁公司、搬家公司的信息            |

**查看在线交易市场测试用例**

| 用例名称 | 查看在线交易市场                                 |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_006                            |
| 测试要点 | 查询在线交易市场的商品信息                            |
| 操作步骤 | 1. 打开程序，进入首页的生活信息页  2. 点击蔬菜家禽，电子商品，衣服鞋包按钮  3. 跳转到商品列表列表页面 |
| 期望结果 | 能够查询到交易市场的商品信息列表和商品详情                    |
| 实际结果 | 能够查询到交易市场的商品信息列表和商品详情                    |

**发布新的商品测试用例**

| 用例名称 | 发布新的商品                                   |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_007                            |
| 测试要点 | 新增自己的商品信息                                |
| 操作步骤 | 1. 打开程序，进入任意商品列表页  2. 点击ActionBar的增加按钮  3. 跳转到新增商品页面，填写商品信息  4. 点击发布，成功后可以在商品列表页面找到最新的商品 |
| 期望结果 | 新增自己的商品信息，并可以在商品列表中查询到自己发布的商品            |
| 实际结果 | 新增自己的商品信息，并可以在商品列表中查询到自己发布的商品            |

**用户身份验证测试用例**

| 用例名称 | 用户身份验证                                   |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_08                             |
| 测试要点 | 可以成功的登录或者注册                              |
| 操作步骤 | 1. 打开程序，进入首页的个人信息页  2. 点击头像图标进行登录  3. 跳转到身份验证页面，输入信息并提交  4. 成功登录后跳转回首页，显示登录的用户信息 |
| 期望结果 | 输入正确的账户和密码后完成用户验证                        |
| 实际结果 | 输入正确的账户和密码后完成用户验证                        |

**信息审核和管理测试用例**

| 用例名称 | 信息审核和管理                                  |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_09                             |
| 测试要点 | 对发布的信息进行修改或者删除                           |
| 操作步骤 | 1. 打开程序，以管理员身份登录程序  2. 跳转到个人信息页，点击我发布的商品，我发布的信息页面  3. 跳转到信息列表，长安需要管理的信息，跳转到信息修改页面。  4. 修改或者删除该信息 |
| 期望结果 | 成功的修改或删除发布的信息                            |
| 实际结果 | 成功的修改或删除发布的信息                            |

**查询餐饮信息测试用例**

| 用例名称 | 查询餐饮信息                                   |
| ---- | ---------------------------------------- |
| 用例标识 | TEST_CASE_010                            |
| 测试要点 | 对发布的信息进行修改或者删除                           |
| 操作步骤 | 1. 打开程序，进入首页的周边信息页  2. 点击周边查询的美食按钮  3. 跳转到美食信息页，显示周边的餐饮信息 |
| 期望结果 | 根据当前选择的城市，查询到周边的餐饮信息                     |
| 实际结果 | 根据当前选择的城市，查询到周边的餐饮信息                     |

# 结论

在本次的毕业设计当中，完成了基于Android的114生活助手系统的设计与实现。并通过项目的开发，尝试寻找一种快速开发的开发方式。在最终阶段完成了课题任务书当中的所有目标和需求，完成并实现了生活助手系统所具备的周边信息查询，交通信息查询，在线交易平台等功能。根据完成的项目你可以查询到航班、火车、长途大巴的实时交通信息。另外你还可以根据自己选择的城市查询到相关的周边信息。这些周边信息包括：酒店信息、餐饮信息、医疗信息、家政信息。

在项目当中，我尝试使用了Android开发的最新前沿技术。这些技术有的来自Andorid官方，有的来自开源社区。经过这次实际项目的考验，这些原本只是文章中提及到的技术大多被证明是非常有效的。当然其中也有少许的技术并没有如项目开始时预期的那样完美，其中仍然有许多另人遗憾的地方存在。其中值得作为总结的内容如下：

- **使用AndroidAnnotation这样的开发框架**，将会大大降低重复的代码，让开发变的无比的顺畅。但是随着项目的无限增长，该框架的使用可能依旧会不可避免的造成代码的冗余。另外AndroidAnnotation项目作为Android开发的一个整体框架来说，其可能存在的最大的问题在于，其和其他开源框架的配合使用。在本项目的开发当中，已经不仅一次的遇到了AndoridAnnotation和其他开源项目的冲突问题。

- **使用Fragment替换原来的Activity的部分功能**，使得开发变的更加灵活高效。但是同时这也引入了新的问题，而最主要的问题是在于在Andorid的官方文档当中，对于Fragment的具体使用方式似乎还是相对限制的比较死板的，这造成了在很多的开发当中，开发者一层不变的按照官方文档的思路使用Fragment。但是根据本次项目的实际经验来看，似乎这样的做法是不值得赞同的。Fragment应该被更加灵活和丰富的使用。

- **使用Bolts替代Callback和AsyncTask**，使得原先的代码变的更加清晰和容易阅读。该框架可以说是本项目中最值得注意的地方。Bolts项目作为一个刚刚发布的项目，其知名程度和影响程度在开发者中还不是非常的普及，其带来的效率的提升和优雅的代码还没有被人所知。然而此次的项目为其价值做了最好的证明。

- **Picasso框架的使用使得原先负责的图处理工作变的异常的简单**。但是非常遗憾的事，Picasso框架的稳定性依旧不是很好，在本项目的开发当中，发现Picasso项目对于部分的Android机型匹配支持的并不是非常的完美。虽然这种现象可以通过降低处理的图的大小来解决。但是其依旧作为问题而存在。

- **EventBus项目，在本项目当中，被主要作为Activity间的通信工具使用**。的确正如EventBus开发者介绍的那样，EventBus的使用的确解决了过去Android项目模块间沟通的问题。但是非常可惜的是，EventBus并没有使用java的注解特性，这使得EventBus的语法在程序当中显得有点突兀。

- **对项目架构的划分使得项目的架构变的非常的清晰**。多层的架构划分，使得Android很好的实现了MVC的架构逻辑。将UI代码放置在xml布局文件当中。Model层主要负责正真的业务逻辑。而Activity和Fragment作为Control层出现。这样的设计，要远远比单独使用Activity的要好很多。最最重要的是，这样的划分，也使得项目本身变的可以测试。当然，不能说这样的设计就是非常完美的。由于Android项目的特殊性，其层次的划分还不能被非常清晰的划分出来，在各个层次之间依旧存在很多交集的地方。

- **由于课题的研究时间和经历的现实，本项目在单元测试上面所耗费的精力几乎可以为零**。整个项目的开发都是朝着不断向前的步骤进行的，没有按照最佳实践的推荐对项目本身进行单元测试。同时在项目的过程当中，重构和代码回顾的过程也屈指可数，因此虽然在众多开源框架的帮助下，项目已经变的异常的简洁明了。但是其中依旧存在很多糟糕的设计需要改正。最后，由于设备的限制，项目最终的运行测试只有在魅蓝note和google nexus7上面进行。因此项目本项目的稳定性和适配性能另人担忧。

# 参考文献

[1] Hancock, Gregory,182 Most Asked Questions on Android: What You Need to Know,In  Success Secrets.[S.l.] : Emereo Publishing,2014.

[2] Samuelson, Pamela1 Copyrightability of Java APIs Revisited, Communications of the ACM, 2015.

[3] Sverdlove, Harry, Feature: The Java vulnerability landscape, In Network Security:2014, 2014(4):9-14.

[4] Karakoidas, Vassilios.A type-safe embedding of SQL into Java using the extensible compiler framework J, In Computer Languages. Systems & Structures, 2015, 41:1-20.

[5] 李寅,范明钰,王光卫.基于反编译的Android平台恶意代码静态分析.计算机系统应用 (Computer Systems＆ Applications), 2012, 11: 187-189.

[6] 陈融.Android安全研究综述.计算机应用与软件 (Computer Applications and Software), 2012, 29 (10): 20