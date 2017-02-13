package com.msse.web.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by z001hk8 on 1/27/17.
 */
@RestController
class HelloWorldController {

    @GetMapping('/hello/{name}')
    public Map sayHello(@PathVariable String name) {
        return [response: "Hello, " + name + "!"]
    }
}
