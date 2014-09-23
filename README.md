# 家校通概述 HomeSchool Overview

“家校通”是一款应用于学校与家长之间交流的工具软件。家长和老师可以通过“家校通”app进行文字、图片、文件等格式的信息交流。
家长可以通过app获取老师给学生布置的家庭作业，获取学生的在校信息，实时了解学生的成长情况。
家长和老师可以通过签到的方式发送学生是否已经安全的到达家里或学校的信息，确保学生安全。


## 服务端

服务端使用`java`语言

1. 框架使用`SSH` 

**日后将 Struts2 替换为 Spring MVC**

## 客户端

客户端使用 Android

1. `ORM `使用 `ormlite`
2. `REST` 使用 `Retrofit`

支持的版本暂定为 `4.0+`

## 通信

1. 客户端与服务端之间通信使用 `json`
2. 客户端与服务器都使用 `JSON-lib`

## REST WEB
1. 显示的使用 HTTP 方法
2. 无状态
3. 公开目录结构式的 URI
4. 传输 XML、JavaScript Object Notation(JSON), 或者同时这两种

**使用 Spring MVC 实现 REST**

## 接口

### 列表

1. `/restful/message` 接口操作 Message

### 注意
1. json 中日期格式为 `yyyy-MM-dd HH:mm:ss`

## 第三方服务

* 消息模块使用 [JPush(极光推送)](https://www.jpush.cn/)
* 文件存储使用 [七牛](http://www.qiniu.com/)
