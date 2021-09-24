package compass.sf.doggyclinicsf.service.map;

import compass.sf.doggyclinicsf.model.Visit;
import compass.sf.doggyclinicsf.service.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getDog() == null || visit.getDog().getOwner() == null || visit.getDog().getId() == null
            || visit.getDog().getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
