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

    @GetMapping("/leaders")
    fun leaders(model: Model): String {
        return "leaders"
    }

    @GetMapping("/systems")
    fun systems(model: Model): String {
        return "systems"
    }
}