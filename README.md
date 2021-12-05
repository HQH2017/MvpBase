#MVP 项目架构#  rxjava2 + retrofit2 + okhttp3 + butterknife   (暂时没有加入dagger进行类对象管理)  
开发环境：Android Studio 3.6.3, JDK1.8  
简介说明：打造一个可以进行快速开发的项目（账号，密码 123456）  
![图片0](https://github.com/HQH2017/MvpBase/blob/master/app/src/main/res/drawable-v24/read00.png)
![图片1](https://github.com/HQH2017/MvpBase/blob/master/app/src/main/res/drawable-v24/read01.png)
![图片2](https://github.com/HQH2017/MvpBase/blob/master/app/src/main/res/drawable-v24/read02.png)
![图片3](https://github.com/HQH2017/MvpBase/blob/master/app/src/main/res/drawable-v24/read03.png)
---------------------------------------------------  
包结构说明：  
bean     ：实体类集合  
            -----  
di       ：依赖注入  
            - component  
            - module  
            -----  
global   ：全局属性  
            -----  
http     ：网络请求  
            -----  
modle    ：mvp模式中的M  
            -----  
presenter：mvp模式中的P  
            - contract  
            -----  
ui       ：mvp模式中的v (activity,fragment,xml视图)  
            - activity  
            - adapter 适配器类集合  
            - base activity,fragment的基类  
            - fragment  
            - main 基类的实现  
            - widget 一些自定义组件  
            -----  
utils    ：一些工具类  
            -----  
view     ：P层的View接口  
            -----  
---------------------------------------------------  

TestService.class类接口URL拼接：https://blog.csdn.net/weixin_33805557/article/details/88002977  





======================= 关于一些内存泄露问题 =======================  
1.inputMethodManager https://www.jianshu.com/p/95242060320f  
2.onnectivityManager 内存泄漏隐患：https://www.jianshu.com/p/7d4b55f7ed9f  
