package org.acelera.saopaulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("greetings")
public class HelloWorldController {

    private static final String template = "Hello, %s!";

    @Autowired
    private AtomicLong counter;

    @Autowired
    private Storage storage;

    @GetMapping
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping
    public String save(@RequestBody Greeting greeting) {
        storage.put(greeting.getId(), greeting);
        return "Saved " + greeting.getContent();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Greeting getBook(@PathVariable long id) {
        return storage.get(id);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Greeting update(@PathVariable long id, @RequestBody Greeting greeting) {
        return storage.update(id, greeting);
    }


    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Greeting delete(@PathVariable long id) {
        return storage.remove(id);
    }



}
// curl -i -X POST -H "Content-Type: application/json" -d '{"id":1,"content":"Hello, Stranger!"}' localhost:8080/greetings/
// curl localhost:8080/greetings/1
// curl -i -X PUT -H "Content-Type: application/json" -d '{"id":1,"content":"Hello, Update!"}' localhost:8080/greetings/1
// curl -i -X DELETE localhost:8080/greetings/1