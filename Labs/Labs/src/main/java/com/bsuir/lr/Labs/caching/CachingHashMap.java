package com.bsuir.lr.Labs.caching;
import com.bsuir.lr.Labs.models.ComplexNumber;
import com.bsuir.lr.Labs.models.ComplexRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CachingHashMap {
    private final HashMap<ComplexRequest, ComplexNumber> cach = new HashMap<ComplexRequest, ComplexNumber>();
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
