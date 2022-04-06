package co.edu.udea.chopeviverobackend.controllers;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class BaseController {

    @GetMapping
    public void redirect(HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Location", "http://localhost:8080/swagger-ui.html");
        httpServletResponse.setStatus(302);
    }

}
