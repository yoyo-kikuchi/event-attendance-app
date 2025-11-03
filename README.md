# Event Attendance App

イベント検索とイベントへの参加を管理するアプリケーションです。

## アプリケーションのビルドとデプロイ

### 開発環境

- Mac/Linux

```bash
./mvnw clean package wildfly:dev
```

- Windows

```bash
./mvnw.cmd clean package wildfly:dev
```

ランタイムが起動したら、http://localhost:8080/event-attendance-app でプロジェクトにアクセスできます。

#### 本番環境


