package exam.async.execute.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Slf4j
@EnableAsync
@Configuration
public class AsyncConfig extends AsyncConfigurerSupport {

  @Override
  public Executor getAsyncExecutor() {
    log.info(">>> Async Executor !");
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setCorePoolSize(10);
    threadPoolTaskExecutor.setMaxPoolSize(20);
    threadPoolTaskExecutor.setQueueCapacity(1000);
    threadPoolTaskExecutor.setThreadNamePrefix("async-exam-");
    threadPoolTaskExecutor.initialize();

    return threadPoolTaskExecutor;
  }
}
