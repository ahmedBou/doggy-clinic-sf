package compass.sf.doggyclinicsf.service.map;


import compass.sf.doggyclinicsf.model.Speciality;
import compass.sf.doggyclinicsf.model.Vet;
import compass.sf.doggyclinicsf.service.SpecialtiesService;
import compass.sf.doggyclinicsf.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtiesService specialtiesService;

    public VetServiceMap(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Vet object) {
        super.delete(object);


    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size()>0) {
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() ==  null){
                    Speciality savedSpecialty = specialtiesService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }
}
