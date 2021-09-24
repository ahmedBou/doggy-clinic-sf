package compass.sf.doggyclinicsf.service.springDataJpa;

import compass.sf.doggyclinicsf.model.Doggy;
import compass.sf.doggyclinicsf.repositories.DoggyRepository;
import compass.sf.doggyclinicsf.service.DoggyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class DoggySdJpaService implements DoggyService {
    private final DoggyRepository doggyRepository;

    public DoggySdJpaService(DoggyRepository doggyRepository) {
        this.doggyRepository = doggyRepository;
    }

    @Override
    public Set<Doggy> findAll() {
        Set<Doggy> doggies = new HashSet<>();
        doggyRepository.findAll().forEach(doggies::add);
        return doggies;
    }

    @Override
    public Doggy findById(Long aLong) {
        return doggyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Doggy save(Doggy object) {
        return doggyRepository.save(object);
    }

    @Override
    public void delete(Doggy object) {
        doggyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        doggyRepository.deleteById(aLong);
    }


}
