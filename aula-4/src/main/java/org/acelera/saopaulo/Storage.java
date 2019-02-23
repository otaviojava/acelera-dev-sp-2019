package org.acelera.saopaulo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Storage {

    private Map<Long, Greeting> data = new HashMap<>();

    public void put(long id, Greeting greeting) {
        data.put(id, greeting);
    }

    public Greeting get(long id) {
        return data.get(id);
    }

    public Greeting update(long id, Greeting greeting) {
        return data.computeIfPresent(id, (k,v) -> greeting);
    }


    public Greeting remove(long id) {
        return data.remove(id);
    }
}
