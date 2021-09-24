package compass.sf.doggyclinicsf.service.springDataJpa;

import compass.sf.doggyclinicsf.model.Speciality;
import compass.sf.doggyclinicsf.repositories.SpecialtyRepository;
import compass.sf.doggyclinicsf.service.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class VetSpecialitySdJpaService implements SpecialtiesService {
    private final SpecialtyRepository specialtyRepository;

    public VetSpecialitySdJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set< Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);

        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
