package exam.async.execute.controller;

import exam.async.execute.config.AsyncConfig;
import exam.async.execute.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

  private AsyncService asyncService;

  public Controller(AsyncService asyncService) {
    this.asyncService = asyncService;
  }

  @RequestMapping(value = "async", method = RequestMethod.POST)
  public String async() {
    log.info(">>> Async Request OK !");
    asyncService.onAsync();

    return "Async Call !";
  }

  @RequestMapping(value = "sync", method = RequestMethod.POST)
  public String sync() {
    log.info(">>> Sync Request OK !");
    asyncService.onSync();

    return "Sync Call !";
  }

  @RequestMapping(value = "call-all", method = RequestMethod.POST)
  public String requestSyncAndAsync() {
    log.info(">>> Sync AND Async Request OK !");
    asyncService.onSync();
    asyncService.onAsync();

    return "all call !";
  }
}
