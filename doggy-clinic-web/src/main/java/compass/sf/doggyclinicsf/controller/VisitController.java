package compass.sf.doggyclinicsf.controller;

import compass.sf.doggyclinicsf.model.Doggy;
import compass.sf.doggyclinicsf.model.Visit;
import compass.sf.doggyclinicsf.service.DoggyService;
import compass.sf.doggyclinicsf.service.VisitService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class VisitController {
    private final VisitService visitService;
    private final DoggyService doggyService;


    public VisitController(VisitService visitService, DoggyService doggyService) {
        this.visitService = visitService;
        this.doggyService = doggyService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text));
            }
        });
    }

    /**
     * Called before each and every @RequestMapping annotated method.
     * 2 goals:
     * - Make sure we always have fresh data
     * - Since we do not use the session scope, make sure that Pet object always has an id
     * (Even though id is not part of the form fields)
     *
     * @param "dogId"
     * @return Dog
     */

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("dogId") Long dogId, Map<String, Object> model) {
        Doggy dog = doggyService.findById(dogId);
        model.put("dog", dog);
        Visit visit = new Visit();
        dog.getVisits().add(visit);
        visit.setDog(dog);
        return visit;
    }


    // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
    @GetMapping("/owner/*/dogs/{dogId}/visits/new")
    public String initNewVisitForm(@PathVariable("dogId") Long dogId, Map<String, Object> model) {
        return "dogs/createOrUpdateVisitForm";
    }

    // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
    @PostMapping("owner/{ownerId}/dogs/{dogId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "dogs/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);

            return "redirect:/owner/{ownerId}";
        }
    }
}
