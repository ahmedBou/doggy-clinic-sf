package compass.sf.doggyclinicsf.service.map;

import compass.sf.doggyclinicsf.model.Doggy;
import compass.sf.doggyclinicsf.model.Owner;
import compass.sf.doggyclinicsf.service.DoggyService;
import compass.sf.doggyclinicsf.service.DoggyTypeService;
import compass.sf.doggyclinicsf.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{


    private final DoggyTypeService doggyTypeService;
    private final DoggyService doggyService;

    public OwnerMapService(DoggyTypeService doggyTypeService, DoggyService doggyService) {
        this.doggyTypeService = doggyTypeService;
        this.doggyService = doggyService;
    }



    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);


    }
/*
we are comparing using a HashMap implementation to persist data to vs.
 using an SQL database. Through the SQL database, we're going to be using
 JPA Hibernate for implementation for ORM
 */
    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getDogs() != null){
                object.getDogs().forEach(doggy -> {
                    if(doggy.getDoggyType() != null){
                        if(doggy.getDoggyType().getId() == null){
                            doggy.setDoggyType(doggyTypeService.save(doggy.getDoggyType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(doggy.getId() == null){
                        Doggy savedDog = doggyService.save(doggy);
                        doggy.setId(savedDog.getId());
                    }
                });
            }
            return super.save(object);

        }else{
            return null;
        }


    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
