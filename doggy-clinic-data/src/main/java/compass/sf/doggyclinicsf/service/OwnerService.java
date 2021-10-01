package compass.sf.doggyclinicsf.service;

import compass.sf.doggyclinicsf.model.Owner;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
    /*
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();

     */
}
