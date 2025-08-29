package dev.java10x.ninjasregister;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/welcome")
    public String Welcome() {
        return "This is my first message on this route";
    }



}
