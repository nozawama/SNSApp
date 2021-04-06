新卒研修

SNSをイメージしたwebアプリケーションです。

### 1. 動作環境
- Docker Version: 20.10.5
- Java Version: 8.1.0
- Kotlin Version: 1.4.30
- Gradle Version: 6.8.3

### 2. 実行手順
    cd /SNSApp/docker-compose
    dokcer-compose up -d
    cd /SNSApp/app
    ./gradlew bootrun
"localhost:8080" からアクセス出来ます。

 ### 3. 補足
 起動時点でユーザを登録していないため、ユーザ登録ページに遷移して登録作業を行い、ログインしてメインページを確認して頂けると助かります。
 (ユーザ登録が上手くいっていないとそこで止まってしまうので良くなさそう, 要変更?)
