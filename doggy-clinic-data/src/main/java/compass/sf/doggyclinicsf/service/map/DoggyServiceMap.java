package compass.sf.doggyclinicsf.service.map;

import compass.sf.doggyclinicsf.model.Doggy;
import compass.sf.doggyclinicsf.service.DoggyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class DoggyServiceMap extends AbstractMapService<Doggy, Long> implements DoggyService {


    @Override
    public Set<Doggy> findAll() {
        return super.findAll();
    }

    @Override
    public Doggy findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Doggy object) {
        super.delete(object);


    }

    @Override
    public Doggy save(Doggy object) {
        return super.save(object);
    }
}
