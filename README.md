# sendgridjp-scala-example

本コードは、Scalaによる[SendGrid公式Javaライブラリ](https://github.com/sendgrid/sendgrid-java)の利用サンプルです。

## 使い方

```bash
git clone https://github.com/SendGridJP/sendgridjp-scala-example.git
cd sendgridjp-scala-example
cd src/main/resources/
cp application.conf.example application.conf
# application.confファイルを編集してください
cd ../../../
sbt run
```

`{"message":"success"}`と表示されたら送信成功です。

## application.confファイルの編集

application.confファイルは以下のようになっています。

```
API_KEY = "your_api_key"
TOS = ["you@youremail.com", "friend1@friendemail.com", "friend2@friendemail.com"]
FROM = "you@youremail.com"
```

API_KEY: SendGridの[API Key](https://sendgrid.kke.co.jp/docs/User_Manual_JP/Settings/api_keys.html)を指定してください。
TOS: 宛先をカンマ区切りで指定してください。
FROM: 送信元アドレスを指定してください。  
