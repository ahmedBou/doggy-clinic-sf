package compass.sf.doggyclinicsf.bootstrap;

import compass.sf.doggyclinicsf.model.*;
import compass.sf.doggyclinicsf.service.DoggyTypeService;
import compass.sf.doggyclinicsf.service.OwnerService;
import compass.sf.doggyclinicsf.service.SpecialtiesService;
import compass.sf.doggyclinicsf.service.VetService;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Dataloader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final DoggyTypeService doggyTypeService;
    private final SpecialtiesService specialtiesService;

    public Dataloader(OwnerService ownerService, VetService vetService,
                      DoggyTypeService doggyTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.doggyTypeService = doggyTypeService;
        this.specialtiesService = specialtiesService;
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
        rottweiller.setName("rottweiller");
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
        owner1.setAddress("jhedfjhfsdf");
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

        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

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
