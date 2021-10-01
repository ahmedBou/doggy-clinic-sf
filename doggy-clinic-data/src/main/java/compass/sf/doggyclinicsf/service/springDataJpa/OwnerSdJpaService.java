package compass.sf.doggyclinicsf.service.springDataJpa;

import compass.sf.doggyclinicsf.model.Owner;
import compass.sf.doggyclinicsf.repositories.DoggyRepository;
import compass.sf.doggyclinicsf.repositories.DoggyTypeRepository;
import compass.sf.doggyclinicsf.repositories.OwnerRepository;
import compass.sf.doggyclinicsf.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("springDataJpa")
public class OwnerSdJpaService implements OwnerService {


    private final OwnerRepository ownerRepository;
    private final DoggyRepository doggyRepository;
    private final DoggyTypeRepository doggyTypeRepository;

    public OwnerSdJpaService(OwnerRepository ownerRepository,
                             DoggyRepository doggyRepository,
                             DoggyTypeRepository doggyTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.doggyRepository = doggyRepository;
        this.doggyTypeRepository = doggyTypeRepository;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
        if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }else{
            return null;
        }

    }

    @Override
    public Owner save(Owner object) {
        System.out.println("#####################");
        System.out.println("#####################");
        System.out.println("#####################");
        System.out.println("#####################");
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }


}
