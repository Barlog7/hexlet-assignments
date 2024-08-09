package exercise.controller;


import exercise.daytime.Daytime;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class WelcomeController {

    @Autowired
    private Daytime day;

    @GetMapping(path = "/welcome")
    public String welcome()  {
        //return "It is " + " now! Welcome to Spring!";
        return "It is " + day.getName() + " now! Welcome to Spring!";
    }
}
// END
