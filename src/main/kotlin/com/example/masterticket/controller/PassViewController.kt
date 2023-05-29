package com.example.masterticket.controller

import com.example.masterticket.pass.Pass
import com.example.masterticket.pass.PassService
import com.example.masterticket.user.User
import com.example.masterticket.user.UserService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(value = ["/passes"])
@RequiredArgsConstructor
class PassViewController(
    val userService: UserService,
    val passService: PassService
) {

    @GetMapping
    fun getPasses(@RequestParam("userId") userId: String?): ModelAndView {
        val modelAndView = ModelAndView()
        val passes: List<Pass> = passService.getPasses(userId)
        val user: User = userService.getUser(userId)
        modelAndView.addObject("passes", passes)
        modelAndView.addObject("user", user)
        modelAndView.viewName = "pass/index"
        return modelAndView
    }
}