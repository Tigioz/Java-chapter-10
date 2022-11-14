package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


      // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello () {
//        return "Hello, Spring!";
//    }

    // accessible through /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye () {
        return "Goodbye, Spring!";
    }

    // hello/QUERY-PARAM
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam (@RequestParam String name, @RequestParam String language) {
        return createMessage(name, language);
    }


    public static String createMessage(String name, String l) {
        String language = "";

        if (l.equals("english")){
            language = "Hello";
        } else if (l.equals("french")){
            language = "Bonjour";
        } else if (l.equals("Spanish")){
            language = "Hola";
        } else if (l.equals("german")){
            language = "Guten Tag";
        } else if (l.equals("italian")){
            language = "Ciao";
        }
        return language + ", " + name + "!";
    }


    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam (@PathVariable String name) {
        return "Hello, " + name +  "!";
    }


    @GetMapping("form")
    public String helloForm() {
        return  "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "    <option value='english'>English</option>" +
                "    <option value='french'>French</option>" +
                "    <option value='spanish'>Spanish</option>" +
                "    <option value='german'>German</option>" +
                "    <option value='italian'>Italian</option>" +
                "<input type = 'submit' value= 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
