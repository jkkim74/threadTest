package com.example.test2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableAsync
public class PushSendTask {

    @Autowired
    private AndroidPushSendService androidPushSendService;

    @Autowired
    private IosPushSendService iosPushSendService;

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Scheduled(fixedDelay = 10000)
    public void pushSendJob() throws InterruptedException {
        log.info("############# Push Send Start #############");
        int cnt_and = 0;
        int cnt_ios = 0;
        while (cnt_and < 10) {
            androidPushSendService.andPushSend();
            cnt_and++;
        }
        while (cnt_ios < 10) {
            iosPushSendService.pushSend();
            cnt_ios++;
        }
        Thread.sleep(10000);
        log.info("############# Push Send End #############");
//        if(threadPoolTaskExecutor.getActiveCount()==0){
//            log.info("############# Push Thread Shutdown #############");
//            threadPoolTaskExecutor.shutdown();
//        }

    }
}
