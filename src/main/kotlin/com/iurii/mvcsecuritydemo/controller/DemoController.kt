package com.iurii.mvcsecuritydemo.controller

import ch.qos.logback.core.model.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DemoController {
    @GetMapping("/")
    fun home(model: Model): String {
        return "home"
    }
}