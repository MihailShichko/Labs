package com.bsuir.lr.Labs.Services;


import com.bsuir.lr.Labs.Controllers.HomeController;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.Integer;

@Service
public class RequestCountService {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private int count = 0;
    public synchronized int getCount(){ return count;}

    public synchronized void incrementCount() {
            count++;
            var builder = new StringBuilder();
            builder.append("count is ");
            builder.append(count);
            builder.append(" now");
            logger.info(builder.toString());
    }
}
