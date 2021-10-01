package compass.sf.doggyclinicsf.bootstrap;

import compass.sf.doggyclinicsf.model.*;
import compass.sf.doggyclinicsf.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Component
public class Dataloader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final DoggyTypeService doggyTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public Dataloader(OwnerService ownerService, VetService vetService,
                      DoggyTypeService doggyTypeService,
                      SpecialtiesService specialtiesService,
                      VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.doggyTypeService = doggyTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;

    }

    @Override
    public void run(String... args) throws Exception {

        int count = doggyTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        DoggyType rottweiller = new DoggyType();
        rottweiller.setNames("rottweiller");
        DoggyType savedDogType = doggyTypeService.save(rottweiller);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry= new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedRadiology = specialtiesService.save(radiology);
        Speciality savedSurgery = specialtiesService.save(surgery);
        Speciality savedDentistry = specialtiesService.save(dentistry);





        Owner owner1 = new Owner();
        owner1.setFirstName("Tom");
        owner1.setLastName("Jerry");
        owner1.setAddress("cité de chat maison 10");
        owner1.setCity("city");
        owner1.setTelephone("55666666");

        Doggy hamadaDog = new Doggy();
        hamadaDog.setDoggyType(savedDogType);
        hamadaDog.setOwner(owner1);
        hamadaDog.setBirthDate(LocalDate.now());
        hamadaDog.setName("pattu");
        owner1.getDogs().add(hamadaDog);

        ownerService.save(owner1);



        Owner owner2 = new Owner();
        owner2.setFirstName("Mono");
        owner2.setLastName("Six");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Doggy monoDog = new Doggy();
        monoDog.setName("turbo");
        monoDog.setOwner(owner2);
        monoDog.setBirthDate(LocalDate.now());
        monoDog.setDoggyType(savedDogType);
        owner2.getDogs().add(monoDog);

        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

        Visit rottVisit = new Visit();
        rottVisit.setDog(hamadaDog);
        rottVisit.setVisit(LocalDate.now());
        rottVisit.setDescription("incredible pattu");
        visitService.save(rottVisit);
        Vet vet1 = new Vet();

        vet1.setFirstName("bonnie");
        vet1.setLastName("Clyde");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Foo");
        vet2.setLastName("BAr");
        vet1.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }

}
