package compass.sf.doggyclinicsf.repositories;

import compass.sf.doggyclinicsf.model.Doggy;
import org.springframework.data.repository.CrudRepository;

public interface DoggyRepository extends CrudRepository<Doggy, Long> {
}


/*
these are JPA entities, Spring Data JPA is going to provide us instances of

these at runtime automatically, so we will get those available for our use in

the Spring context. Some of these, I don't know if we're going to have a direct

use case for. I just kinda went through blanket and added in repositories for

all our entities, so if we do need to use a repository we will have it there
 */