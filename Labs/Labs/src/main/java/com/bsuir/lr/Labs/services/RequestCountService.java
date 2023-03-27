package com.bsuir.lr.Labs.services;


import com.bsuir.lr.Labs.controllers.HomeController;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;


@Service
public class RequestCountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private int count = 0;
    public synchronized int getCount(){ return count;}

    public synchronized void incrementCount() {
            count++;
            var builder = new StringBuilder();
            builder.append("count is ");
            builder.append(count);
            builder.append(" now");
            LOGGER.info(builder.toString());
    }
}
