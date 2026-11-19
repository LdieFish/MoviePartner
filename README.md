# Movie Partner

一个 AI 应用生成平台。用户用自然语言描述想要的网站，系统通过对话生成代码，并可以实时预览、部署和下载。

## 能做什么

- 注册登录，区分普通用户和管理员
- 输入提示词创建应用，和 AI 多轮对话生成网站
- 生成过程用 SSE 流式返回，右侧实时预览
- 一键部署，拿到可访问地址；也可以下载项目代码
- 管理自己的应用；管理员可以搜索、编辑、删除、设为精选
- 自动截图作为应用封面

## 技术栈

- 前端：Vue 3、TypeScript、Vite、Pinia、Ant Design Vue
- 后端：Java 21、Spring Boot 3、MyBatis-Flex、MySQL
- AI：LangChain4j（对话与代码生成）、LangGraph4j（生成流程编排）、阿里云 DashScope
- 缓存与会话：Redis（Spring Session）、Redisson（限流）、Caffeine（本地缓存）
- 其他：Selenium 网页截图、腾讯云 COS、Prometheus 监控

## 目录

```
movie-partner/                  Spring Boot 单体，当前主要业务代码
movie-partner-frontend/         Vue 3 前端
movie-partner-microservice/     按用户、应用、AI、截图拆分的微服务版本
```

单体里已经包含完整链路。微服务是同一套业务的拆分，模块为 `user`、`app`、`ai`、`screenshot`，服务间使用 Dubbo。

## 生成流程

1. 用户提交提示词，创建应用并进入对话页
2. 后端通过 SSE 调用大模型，流式返回生成内容
3. 按生成类型保存单文件或多文件代码，静态资源接口提供预览
4. 部署时上传到对象存储；封面由 Selenium 打开页面后截图

LangGraph4j 里把生成拆成一条工作流：收集图片 → 优化提示词 → 路由生成类型 → 生成代码 → 构建项目。

## 可以展开聊的点

- 流式对话怎么接到前端，历史消息存在哪里
- 提示词路由如何决定生成单文件还是多文件项目
- 登录态、接口权限和限流怎么做
- 单体和微服务两套代码各自负责什么
