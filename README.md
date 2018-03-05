# Spring框架下的REST服務(測試各種httpClient

使用Spring為框架，測試各種RestClient元件

## 目標

測試標的
* Apache HttpClient
* Apache cxf
* OkHttp (with Retrofit)
* Jersey Client
* Spring RestTemplate

測試面向
* 支援Rest的程度
* 效能
* 是否好用(彈性、設定、維護)

### Prerequisites

* 需可執行gradle的套件
* tomcat8.0

### 安裝

下載之後轉為gradle專案

## 測試

以瀏覽器查詢http://localhost:8080/RestClient/


## 佈署

以gradle套件執行build即可，會產生war檔，即可佈署至tomcat上