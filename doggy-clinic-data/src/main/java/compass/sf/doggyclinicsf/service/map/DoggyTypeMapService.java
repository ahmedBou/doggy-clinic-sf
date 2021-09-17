package compass.sf.doggyclinicsf.service.map;

import compass.sf.doggyclinicsf.model.DoggyType;
import compass.sf.doggyclinicsf.service.DoggyTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DoggyTypeMapService extends AbstractMapService<DoggyType, Long> implements DoggyTypeService {
    @Override
    public Set<DoggyType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(DoggyType object) {
        super.delete(object);
    }

    @Override
    public DoggyType save(DoggyType object) {
        return super.save(object.getId(), object);
    }

    @Override
    public DoggyType findById(Long id) {
        return super.findById(id);
    }
}
