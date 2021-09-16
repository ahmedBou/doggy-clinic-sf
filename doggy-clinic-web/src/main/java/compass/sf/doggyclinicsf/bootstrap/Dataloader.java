package compass.sf.doggyclinicsf.bootstrap;

import compass.sf.doggyclinicsf.model.Owner;
import compass.sf.doggyclinicsf.model.Vet;
import compass.sf.doggyclinicsf.service.OwnerService;
import compass.sf.doggyclinicsf.service.VetService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public Dataloader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();

        owner1.setFirstName("Tom");
        owner1.setLastName("Jerry");

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
