package lottery.frontend.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static final String INDEX = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(final ModelMap model) {

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return INDEX;

    }
}
