package com.iurii.mvcsecuritydemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ErrorController {
    @GetMapping("/access-denied")
    fun accessDenied(): String {
        return "access-denied"
    }

}