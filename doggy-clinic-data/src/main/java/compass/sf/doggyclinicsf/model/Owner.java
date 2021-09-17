package compass.sf.doggyclinicsf.model;

import java.util.Set;

public class Owner extends Person{

    private Set<Doggy> dogs;

    public Set<Doggy> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Doggy> dogs) {
        this.dogs = dogs;
    }
}
