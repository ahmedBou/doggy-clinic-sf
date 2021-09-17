package compass.sf.doggyclinicsf.bootstrap;

import compass.sf.doggyclinicsf.model.Doggy;
import compass.sf.doggyclinicsf.model.DoggyType;
import compass.sf.doggyclinicsf.model.Owner;
import compass.sf.doggyclinicsf.model.Vet;
import compass.sf.doggyclinicsf.service.DoggyTypeService;
import compass.sf.doggyclinicsf.service.OwnerService;
import compass.sf.doggyclinicsf.service.VetService;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Dataloader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final DoggyTypeService doggyTypeService;

    public Dataloader(OwnerService ownerService, VetService vetService, DoggyTypeService doggyTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.doggyTypeService = doggyTypeService;
    }



    @Override
    public void run(String... args) throws Exception {
        DoggyType rottweiller = new DoggyType();
        rottweiller.setName("pattu");

        DoggyType savedDogType = doggyTypeService.save(rottweiller);
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

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Foo");
        vet2.setLastName("BAr");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");




    }

}
