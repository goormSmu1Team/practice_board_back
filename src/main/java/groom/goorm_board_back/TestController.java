package groom.goorm_board_back;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    public String get() {
        return "hello world";
    }
}
