package compass.sf.doggyclinicsf.service.springDataJpa;

import compass.sf.doggyclinicsf.model.DoggyType;
import compass.sf.doggyclinicsf.repositories.DoggyTypeRepository;
import compass.sf.doggyclinicsf.service.DoggyTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class DoggyTypeSdJpaService implements DoggyTypeService {

    private final DoggyTypeRepository doggyTypeRepository;

    public DoggyTypeSdJpaService(DoggyTypeRepository doggyTypeRepository) {
        this.doggyTypeRepository = doggyTypeRepository;
    }


    @Override
    public Set<DoggyType> findAll() {
        Set<DoggyType> doggyTypes = new HashSet<>();
        doggyTypeRepository.findAll().forEach(doggyTypes::add);
        return doggyTypes;
    }

    @Override
    public DoggyType findById(Long aLong) {
        return doggyTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public DoggyType save(DoggyType object) {
        return doggyTypeRepository.save(object);
    }

    @Override
    public void delete(DoggyType object) {
        doggyTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        doggyTypeRepository.deleteById(aLong);
    }
}
