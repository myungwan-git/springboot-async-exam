package exam.async.execute.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {

  @Async
  public void onAsync() {
    try {
      log.info(">>> Async Thread Sleep 3000 Start !");
      Thread.sleep(3000);
      log.info(">>> Async Thread Sleep 3000 complete !");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void onSync() {
    try {
      log.info(">>> Sync Thread Sleep 5000 Start !");
      Thread.sleep(5000);
      log.info(">>> Sync Thread Sleep 5000 complete !");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


}
