package compass.sf.doggyclinicsf.controller;


import compass.sf.doggyclinicsf.model.Doggy;
import compass.sf.doggyclinicsf.model.Owner;
import compass.sf.doggyclinicsf.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@RequestMapping({"/owner"})
@Controller
public class OwnerController {


    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
/*
    @RequestMapping({"","/", "/index", "/index.html"})
    public String ownerList(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }

 */

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setAllowedFields("id");
    }


    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owner/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {

        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            System.out.println("}}}}}}}}}}}}}}}");
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        System.out.println("getLastname: "+ owner.getLastName());
        System.out.println(owner.getDogs());
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        System.out.println(results);
        //System.out.println(results.size());
        //System.out.println(results.isEmpty());
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            System.out.println(" no owners found");
            return "owner/findOwners";
        }
        else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            System.out.println("1 owner found");
            return "redirect:/owner/" + owner.getId();
        }
        else {
            // multiple owners found
            System.out.println("multiple owners found");
            model.addAttribute("selections", results);
            return "owner/ownersList";
        }
    }


    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owner/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
}
