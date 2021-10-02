package compass.sf.doggyclinicsf.controller;
import compass.sf.doggyclinicsf.model.Doggy;
import compass.sf.doggyclinicsf.model.DoggyType;
import compass.sf.doggyclinicsf.model.Owner;
import compass.sf.doggyclinicsf.service.DoggyService;
import compass.sf.doggyclinicsf.service.DoggyTypeService;
import compass.sf.doggyclinicsf.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@Controller
@RequestMapping("owner/{ownerId}")
public class DoggyController {
    public static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "dogs/createOrUpdateDogForm";
    private final DoggyService doggyService;
    private final OwnerService ownerService;
    private final DoggyTypeService doggyTypeService;

    public DoggyController(DoggyService doggyService, OwnerService ownerService, DoggyTypeService doggyTypeService) {
        this.doggyService = doggyService;
        this.ownerService = ownerService;
        this.doggyTypeService = doggyTypeService;
    }

    @ModelAttribute("types")
    public Collection<DoggyType> populatePetTypes() {
        return doggyTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {

        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/dogs/new")
    public String initCreationForm(Owner owner, Model model) {
        Doggy dog = new Doggy();
        owner.getDogs().add(dog);
        dog.setOwner(owner);
        model.addAttribute("dog", dog);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/dogs/new")
    public String processCreationForm(Owner owner, @Valid Doggy dog,
                                      BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(dog.getName()) && dog.isNew() /*&& owner.getDog(owner.getDog(dog.getName(), true)!=null)*/) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getDogs().add(dog);
        if (result.hasErrors()) {
            model.put("dog", dog);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            doggyService.save(dog);

            return "redirect:/owner/" + owner.getId();
        }
    }

    @GetMapping("/dogs/{dogId}/edit")
    public String initUpdateForm(@PathVariable Long dogId, Model model) {
        model.addAttribute("dog", doggyService.findById(dogId));
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/dogs/{dogId}/edit")
    public String processUpdateForm(@Valid Doggy dog, BindingResult result,
                                    Owner owner, Model model) {
        if (result.hasErrors()) {
            dog.setOwner(owner);
            model.addAttribute("dog", dog);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            owner.getDogs().add(dog);
            doggyService.save(dog);
            return "redirect:/owner/" + owner.getId();
        }
    }
}
