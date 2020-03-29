package io.johnvincent.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class MyprojectApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World too!";
    }

	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
	}

}
