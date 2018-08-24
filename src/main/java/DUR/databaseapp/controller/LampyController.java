package DUR.databaseapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LampyController {

    @GetMapping(value = "/lampy")
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("lampy");
        return modelAndView;
    }
}
