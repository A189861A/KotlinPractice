# 协程 = 轻量级线程，专门用来做异步任务（网络请求、数据库、耗时操作）。
  ## 核心特点
    - 比线程轻量 100 倍
    - 不会阻塞主线程
    - 代码像同步一样写，实际是异步执行
    - 自带生命周期管理（不会内存泄漏）
    
  ## 关键字理解
    launch：开启一个协程（不返回结果）
    async：开启协程 + 返回结果
    suspend：挂起函数（只能在协程里调用）
    Dispatchers.IO：子线程（网络、数据库）
    Dispatchers.Main：主线程（更新 UI）

```kotlin
    // 开启协程
    lifecycleScope.launch {
        // 这里面是异步，但写法像同步
        val data = api.getData() // 网络请求（挂起函数）
        tv.text = data // 自动切回主线程
    }
```

# Channel = 协程之间的 “通信管道”，用来发数据、收数据。
  ## 作用
    - 一个协程 发数据
    - 另一个协程 收数据
    - 安全、不并发异常、自带挂起 / 恢复
```kotlin
  // 1. 创建通道
  val channel = Channel<Int>()
  
  // 2. 发送方协程
  lifecycleScope.launch {
      repeat(3) {
          channel.send(it) // 发送数据 0,1,2
          delay(1000)
      }
      channel.close() // 发送完关闭
  }
  
  // 3. 接收方协程
  lifecycleScope.launch {
      for (data in channel) { // 遍历接收
          println("收到：$data")
      }
  }
```


# 协程
  - 协程的生命周期 ≡ 绑定的 Scope 的生命周期

# lifecycleScope
  - 绑定 Activity / Fragment 生命周期
  - 页面 onDestroy() → 协程自动取消
```kotlin
  lifecycleScope.launch {
      // 页面销毁，这里自动停
  }
```

# viewModelScope
  - 绑定 ViewModel 生命周期
  - ViewModel 销毁 → 协程自动取消
```kotlin
  viewModelScope.launch { 
      // ViewModel 清空时自动停
      try {
        // 1. IO 线程做耗时操作
        val result = withContext(Dispatchers.IO) {
          repository.getData()
        }
    
        // 2. 自动切回主线程更新 UI
        uiState.value = result
      } catch (e: Exception) {
        // 异常处理
        uiState.value = Error(e.message)
      }
  }
```

# GlobalScope
  - 不绑定任何生命周期（不推荐！）
  - 应用退出才停，极易内存泄漏

# 4 大核心调度器
  ## Dispatchers.Main（主线程）
      * 作用：更新 UI、操作控件
      * 只能在 Android 主线程运行
      * 不能做耗时操作（会卡顿）
```kotlin
  lifecycleScope.launch(Dispatchers.Main) {
      // 默认就是主线程
      tv.text = "更新UI" // 必须在主线程
  }
```

  ## Dispatchers.IO（IO 线程）
    * 耗时操作都放这
```kotlin
  launch(Dispatchers.IO) {
    val data = api.getUser() // 网络请求
  }
```
  
  ## Dispatchers.Default（CPU 密集型）
    * 大量计算、解析数据、排序、复杂运算
    * 线程数 = CPU 核心数
    * 适合 CPU 繁重工作
```kotlin
  launch(Dispatchers.Default) {
      val result = bigList.sort() // 大量计算
  }
```
    
  ## Dispatchers.Unconfined（不限制线程，几乎不用）
    * 不指定线程，在哪挂起就在哪恢复

# 最常用切换写法（一行切换线程）
```kotlin
    lifecycleScope.launch {
        // 1. IO 线程做网络请求
        val data = withContext(Dispatchers.IO) {
            api.getData()
        }
    
        // 2. 自动切回主线程更新 UI
        tv.text = data
    }
```

# 并发请求最佳写法（async 并行）
  * 同时请求两个接口，一起等待结果，速度最快
```kotlin
    viewModelScope.launch {
        val job1 = async { api.getUser() }
        val job2 = async { api.getBanner() }
    
        // 等待全部完成
        val user = job1.await()
        val banner = job2.await()
    }

    viewModelScope.launch {
        /*
        * runCatching = 协程 / 普通代码专用的「安全 try-catch 升级版」
        * 专门用来捕获异常，写法比 try-catch 更优雅、更链式。
        * */
      runCatching {
        // 执行耗时逻辑
        withContext(Dispatchers.IO) { repo.getData() }
      }.onSuccess {
        // 成功
      }.onFailure {
        // 失败
      }
    }
```













































