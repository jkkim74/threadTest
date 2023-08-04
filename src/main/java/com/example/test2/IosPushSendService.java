package com.example.test2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IosPushSendService {

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Async("threadPoolTaskExecutor")
    public void pushSend(){
        System.out.println("iosPushSend : " + Thread.currentThread().getName());

        log.info("poolSize : " + threadPoolTaskExecutor.getPoolSize() +
                ", active : " + threadPoolTaskExecutor.getActiveCount() +
                ", queue : " + threadPoolTaskExecutor.getThreadPoolExecutor().getQueue().size());

    }
}
