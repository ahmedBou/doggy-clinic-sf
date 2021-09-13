package compass.sf.doggyclinicsf.service.map;

import compass.sf.doggyclinicsf.model.Doggy;
import compass.sf.doggyclinicsf.service.CrudService;
import java.util.Set;

public class DoggyServiceMap extends AbstractMapService<Doggy, Long> implements CrudService<Doggy, Long> {


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
        return super.save(object.getId(),object);
    }
}
