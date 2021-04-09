package compass.sf.doggyclinicsf.service;

import compass.sf.doggyclinicsf.model.Doggy;

import java.util.Set;

public interface DoggyService {
    Doggy findById(Long id);
    Doggy save(Doggy doggy);
    Set<Doggy> findAll();
}
