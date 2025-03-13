package team.gram.team.gram.aspismain

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping
    fun getMessage(): String {
        return "Hello, this is a test endpoint!"
    }
}
