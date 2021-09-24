package compass.sf.doggyclinicsf.service.springDataJpa;

import compass.sf.doggyclinicsf.model.Vet;
import compass.sf.doggyclinicsf.repositories.VetRepository;
import compass.sf.doggyclinicsf.service.VetService;
import compass.sf.doggyclinicsf.service.map.VetServiceMap;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("springDataJpa")
public class VetSdJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSdJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
       vetRepository.findAll().forEach(vets::add);
       return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        //vetRepository.findById(aLong).get();
        Optional<Vet> optionalVet = vetRepository.findById(aLong);
        if(optionalVet.isPresent()){
            return optionalVet.get();
        }else{
            return null;
        }
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
