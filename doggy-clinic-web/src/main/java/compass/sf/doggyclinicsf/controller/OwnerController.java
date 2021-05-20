package compass.sf.doggyclinicsf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owner"})
@Controller
public class OwnerController {

    @RequestMapping({"","/", "/index", "/index.html"})
    public String ownerList(){
        return "owner/index";
    }
}
