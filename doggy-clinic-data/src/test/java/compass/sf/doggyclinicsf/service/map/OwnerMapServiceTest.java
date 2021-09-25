package compass.sf.doggyclinicsf.service.map;

import compass.sf.doggyclinicsf.model.Doggy;
import compass.sf.doggyclinicsf.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerId = 2L;
    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new DoggyTypeMapService(), new DoggyServiceMap());
        ownerMapService.save(Owner.builder().id(1L).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        //Owner owner = ownerMapService.findById(1L);
       // assertEquals(1, java.util.Optional.ofNullable(owner.getId()));
    }

    @Test
    void deleteById() {

    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(2L).build();
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
    }
}