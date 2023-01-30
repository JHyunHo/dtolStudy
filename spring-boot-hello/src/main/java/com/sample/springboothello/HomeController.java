package com.sample.springboothello;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping(path = "/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello rptp!!");
        return "hello";
    }

    @GetMapping(path ="/hello-get-parameter")
    public String helloGetParameter(
            @RequestParam("name") String name,
            Model model) {
        model.addAttribute("getData", name);
        return "hello-get-parameter";
    }

    @GetMapping(path ="/hello-rest-api")
    @ResponseBody
    public String helloRestApi(
            @RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping(path ="/hello-rest-api-get-class")
    @ResponseBody
    public Hello helloRestApiGetClass(
            @RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
