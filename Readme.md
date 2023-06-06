<h1 align="center"> taobao-buyer</h1>
<div align="center">
    🛍️ 淘宝自动抢购
</div>

## 如何使用
由于使用selenium，所以
### 第一步：下载ChromeDriver
找到你对应Chrome版本的ChromeDriver
> https://sites.google.com/a/chromium.org/chromedriver/home

### 第二步：配置ChromeDriver
```java
        System.setProperty("webdriver.chrome.driver", "/Users/beamstark/Desktop/chromedriver");
```
由于我是系统全局配置，所以这行代码没有在代码块中出现，需要的小伙伴自行添加代码配置

### 第三步：修改代码
打开 /src/main/java/TaoBaoBuyer.java <br>
修改 **ShoppingTime** 为自己的购买时间 <br>
修改 **price** 为自己的购买价格预期（实际价格 < 价格预期）  <br>
### 最后一步：运行代码
需要扫码登陆
<br>
### 说明：
该程序会选中购物车的第一个进行锁单，如需更改请查看代码中第38行。
<br>

****

**如果你想在 [拼多多](https://www.pinduoduo.com) 上自动购买，请 [Click me](https://github.com/BeammNotFound/pinduoduo-buyer).**


## 免责声名
本开源项目（以下简称“本项目”）为自由、开放、共享的非赢利性项目，由开发者（以下简称“我们”）所创建并维护。我们不对使用本项目产生的任何后果承担任何责任。
1. 本项目的代码仅供参考学习，不保证其准确性、完整性或实用性。开发者不承担因使用本项目引发的任何直接或间接损失或损害的法律责任。
2. 本项目中可能包含第三方组件或库，这些组件或库的使用可能受到其他许可证的限制。使用者应该自行了解并遵守相关许可证的规定，并对因使用这些组件或库而引发的任何法律责任自负。

3. 本项目中可能包含链接到其他网站或资源的链接。这些链接仅供参考。
   我们不对这些网站或资源的可用性、准确性、完整性、合法性或任何其他方面的信息负责。使用者应该自行决定是否信任这些链接，并对因使用这些链接而引发的任何法律责任自负。
4. 我们保留随时更改本免责声明的权利。使用者应该定期查看本免责声明，以了解任何变更。如果使用者继续使用本项目，则视为同意遵守新的免责声明。

<br>
<br>

> Enjoy this! 😎

## 请我喝杯咖啡☕️
<img src="./src/public/IMG_6480.JPG" alt="" width="300">

<img src="./src/public/IMG_6479.JPG" alt="" width="300">

