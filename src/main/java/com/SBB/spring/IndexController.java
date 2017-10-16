package com.SBB.spring;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class IndexController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value="haltestelle.jsp", method = RequestMethod.GET)
    public String getHaltPage() {
        return "haltestelle";
    }

}