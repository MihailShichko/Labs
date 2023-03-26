package com.bsuir.lr.Labs.Caching;
import com.bsuir.lr.Labs.Controllers.HomeController;
import com.bsuir.lr.Labs.Models.ComplexNumber;
import com.bsuir.lr.Labs.Models.ComplexRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CachingHashMap {
    private final HashMap<ComplexRequest, ComplexNumber> cach = new HashMap<ComplexRequest, ComplexNumber>();
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    public boolean contains(ComplexRequest key){
        if(cach.size() >= 3) cach.clear();
        return cach.containsKey(key);
    }

    public void addValue(ComplexRequest key, ComplexNumber value) {
        cach.put(key, value);
    }

    public ComplexNumber getValue(ComplexRequest key) {
        return cach.get(key);
    }
}
